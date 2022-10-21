package com.example.backend.controller;

import com.example.backend.models.MarksBySubjectModel;
import com.example.backend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ComponentScan("com.*.*")
public class SchoolController {

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		this.schoolService = schoolService;
	}


	@GetMapping( "/getMarksByStudent")
	public long getStudentMarks(@RequestParam("studentId") int studentId) {
		return schoolService.getStudentMarks(studentId);
	}

	@GetMapping( "/getStudentsByTeacherId")
	public long getCountStudentsWithTeacherId(@RequestParam("teacherId") int teacherId) {
		return schoolService.getCountStudentsWithTeacherId(teacherId);
	}

	@GetMapping( "/getListOfMarksByStudentsId")
	public List<MarksBySubjectModel> getListOfMarksForStudentsId(@RequestParam("studentId") int studentId) {
		return schoolService.getListOfMarksForStudentsId(studentId);
	}


}
