insert into GROUPS values(101, 'Red House');
insert into GROUPS values(102, 'Blue House');
insert into GROUPS values(103, 'Yellow House');

insert into STUDENTS values(1, 'Teena', 'Lamba', 101);
insert into STUDENTS values(2, 'Aneet', 'Lamba', 101);
insert into STUDENTS values(3, 'Sahil', 'Arora', 101);
insert into STUDENTS values(4, 'Adarsh', 'Lamba', 102);
insert into STUDENTS values(5, 'Rahul', 'Sharma', 103);

insert into SUBJECTS values(2001, 'Maths');
insert into SUBJECTS values(2002, 'English');
insert into SUBJECTS values(2003, 'Science');
insert into SUBJECTS values(2004, 'Geography');
insert into SUBJECTS values(2005, 'Physical');

insert into MARKS values(301, '08-12-19', 65, 1, 2001);
insert into MARKS values(302, '08-12-19', 95, 1, 2002);
insert into MARKS values(303, '08-12-19', 75, 1, 2003);
insert into MARKS values(304, '08-12-19', 60, 1, 2004);
insert into MARKS values(305,'08-12-19', 55, 1, 2005);

insert into MARKS values(306, '08-12-19', 65, 2, 2001);
insert into MARKS values(307, '08-12-19', 60, 2, 2002);
insert into MARKS values(308, '08-12-19', 62, 2, 2003);
insert into MARKS values(309, '08-12-19', 68, 2, 2004);
insert into MARKS values(310, '08-12-19', 95, 2, 2005);


insert into MARKS values(311,'08-12-19', 65,3, 2001);
insert into MARKS values(312, '08-12-19', 65, 3, 2002);
insert into MARKS values(313, '08-12-19', 65,3, 2003);
insert into MARKS values(314, '08-12-19', 65, 3, 2004);
insert into MARKS values(315, '08-12-19', 95, 3, 2005);

insert into MARKS values(316, '08-12-19', 63, 4, 2001);
insert into MARKS values(317, '08-12-19', 85, 4, 2002);
insert into MARKS values(318, '08-12-19', 45, 4, 2003);
insert into MARKS values(319, '08-12-19', 55, 4, 2004);
insert into MARKS values(320, '08-12-19', 98, 4, 2005);

insert into MARKS values(321, '08-12-19', 35, 5, 2001);
insert into MARKS values(322, '08-12-19', 75, 5, 2002);
insert into MARKS values(323, '08-12-19', 85, 5, 2003);
insert into MARKS values(324, '08-12-19', 60, 5, 2004);
insert into MARKS values(325, '08-12-19', 90, 5, 2005);

insert into SUBJECT_TEACHER values(801, 601,101, 2001);
insert into SUBJECT_TEACHER values(802, 602,102, 2002);
insert into SUBJECT_TEACHER values(803, 603,103, 2003);
insert into SUBJECT_TEACHER values(804, 604,101, 2004);
insert into SUBJECT_TEACHER values(805, 605, 102, 2005);


select sum(m.marks) from marks m where m.student_id = 1 group by m.student_id;
 select count(student_id) from students where group_id =    select group_id from subject_teacher where teacher_id = 602






