package com.example.backend.models;

import lombok.Data;

import java.util.List;

@Data
public class MarksBySubjectModel {

	private String subjectName;
	private List<MarksListModel> marksListModels;
}
