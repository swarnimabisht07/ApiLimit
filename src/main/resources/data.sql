call next value for hibernate_sequence;
    insert 
    into
        student
        (student_name, student_id) 
    values
        ('Prashant',1);

call next value for hibernate_sequence;
insert 
    into
        apilimit
        (count, student_id, timestamp, id) 
    values
        (1, 1, '2021-04-07 00:00:00', 2);