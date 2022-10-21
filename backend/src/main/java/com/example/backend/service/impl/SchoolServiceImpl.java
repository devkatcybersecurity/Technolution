package com.example.backend.service.impl;

import com.example.backend.dao.Marks;
import com.example.backend.dao.SubjectTeacher;
import com.example.backend.models.MarksBySubjectModel;
import com.example.backend.models.MarksListModel;
import com.example.backend.service.MarksService;
import com.example.backend.service.SchoolService;
import com.example.backend.service.SubjectTeacherService;
import com.example.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private MarksService marksService;
    private SubjectsService subjectsService;
    private SubjectTeacherService subjectTeacherService;

    @Autowired
    public SchoolServiceImpl(MarksService marksService,
                             SubjectsService subjectsService,
                             SubjectTeacherService subjectTeacherService) {
        this.marksService = marksService;
        this.subjectsService = subjectsService;
        this.subjectTeacherService = subjectTeacherService;
    }

    @Override
    public long getStudentMarks(int studentId) {
        // TODO Auto-generated method stub
        return marksService.getMarks(studentId);
    }

    @Override
    public long getCountStudentsWithTeacherId(int teacherId) {
        // TODO Auto-generated method stub
        return subjectTeacherService.noOfStudentsFromTeacherId(teacherId);
    }
    @Override
    public List<MarksBySubjectModel> getListOfMarksForStudentsId(int studentsId) {
        // TODO Auto-generated method stub
//        List<MarksBySubjectModel> marksBySubjectModelList = new ArrayList<>();
//        List<MarksListModel> marksList = marksService.getMarksList(studentsId);
//        for (MarksListModel marksListModel : marksList) {
//            MarksBySubjectModel marksBySubjectModel = new MarksBySubjectModel();
//            marksBySubjectModel.setSubjectName(subjectsService.getSubjectName(marksListModel.getSubjectId()));
//            marksBySubjectModel.setMarks(marksListModel.getMarks());
//            marksBySubjectModelList.add(marksBySubjectModel);
//        }
//        return marksBySubjectModelList;
        return null;
    }

}

