package com.techmojo.apilimit.util;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.techmojo.apilimit.beans.APILimit;
import com.techmojo.apilimit.beans.APILimitResponse;
import com.techmojo.apilimit.beans.Student;
import com.techmojo.apilimit.dao.APILimitDAO;
import com.techmojo.apilimit.exception.InvalidStudentId;
import com.techmojo.apilimit.service.StudentService;

@Service
public class UtilServices {

	@Autowired
	private APILimitDAO apiLimitDAO;

	@Autowired
	private StudentService studentService;

	@Value("${api.limit}")
	private int apiLimitCount;

	public APILimitResponse checkAPILimit(int studentId) throws InvalidStudentId {

		APILimit apiLimit = apiLimitDAO.findByStudentStudentId(studentId);
		if (apiLimit == null) {
			APILimit apiLimit1 = new APILimit();
			Student student = studentService.getStudent(studentId);
			apiLimit1.setStudent(student);
			apiLimit1.setCount(1);
			apiLimitDAO.save(apiLimit1);
			return new APILimitResponse(true, 1);
		} else {
			Timestamp timestamp = apiLimit.getTimestamp();
			float hours = getHourDifference(timestamp);
			if (hours < 60) {
				if (apiLimit.getCount() < this.apiLimitCount) {
					apiLimit.setCount(apiLimit.getCount() + 1);
					apiLimitDAO.save(apiLimit);
					return new APILimitResponse(true,hours);
				} else {
					return new APILimitResponse(false,hours);
				}
			} else {
				apiLimit.setTimestamp(new Timestamp(System.currentTimeMillis()));
				apiLimit.setCount(1);
				apiLimitDAO.save(apiLimit);
				return new APILimitResponse(true,hours);
			}
		}
	}

	private float getHourDifference(Timestamp timestamp) {
		Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(currentTimestamp);
		long difference = currentTimestamp.getTime() - timestamp.getTime();
		System.out.println(difference);
		float seconds =  difference / 1000;
		System.out.println(seconds);
		float minutes = seconds / 60;
		System.out.println(minutes);
		return minutes;
	}

}
