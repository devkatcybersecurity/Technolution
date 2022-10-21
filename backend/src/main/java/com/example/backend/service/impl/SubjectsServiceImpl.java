package com.example.backend.service.impl;

import com.example.backend.dao.Groups;
import com.example.backend.dao.Students;
import com.example.backend.dao.SubjectTeacher;
import com.example.backend.dao.Subjects;
import com.example.backend.exception.ApiError;
import com.example.backend.exception.CustomException;
import com.example.backend.repository.StudentsRepository;
import com.example.backend.repository.SubjectsRepository;
import com.example.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    private final SubjectsRepository subjectsRepository;
    private final StudentsRepository studentsRepository;


    @Autowired
    public SubjectsServiceImpl(SubjectsRepository subjectsRepository,
                               StudentsRepository studentsRepository) {
        this.subjectsRepository = subjectsRepository;
        this.studentsRepository = studentsRepository;
    }

    @Override
    public List<Subjects> getAllSubjects() {
        return subjectsRepository.findAll();
    }

    @Override
    public Subjects getSubjectById(Integer subjectId) {
        return subjectsRepository.findById(subjectId).orElseThrow(
                () -> new CustomException(ApiError.SUBJECT_NOT_FOUND.getApiError(), ApiError.SUBJECT_NOT_FOUND.getErrorMessage()));
    }

    @Override
    public Subjects addSubject(String subjectName) {

            return subjectsRepository.save(Subjects.builder()
                    .title(subjectName)
                    .build());

    }

    @Override
    public List<SubjectTeacher> getMarksForParticularSubject(int subjectId) {
        Optional<Students> students= studentsRepository.findById(subjectId);
        if(students.isPresent()) {
            Groups groups= students.get().getGroups();
            List<SubjectTeacher> subjectTeachers = groups.getSubjectTeachersList();
            return subjectTeachers;
        }
        return null;

    }
    @Override
    public Subjects updateSubject(Integer subjectId, Subjects subject) {
        subjectsRepository.findById(subjectId).orElseThrow(
                () -> new CustomException(ApiError.SUBJECT_NOT_FOUND.getApiError(), ApiError.SUBJECT_NOT_FOUND.getErrorMessage()));
        Subjects newSubjectData = Subjects.builder()
                .subjectId(subjectId)
                .title(subject.getTitle())
                .build();
        return subjectsRepository.save(newSubjectData);
    }

    @Override
    public void deleteSubject(Integer subjectId) {
        subjectsRepository.findById(subjectId).orElseThrow(
                () -> new CustomException(ApiError.SUBJECT_NOT_FOUND.getApiError(), ApiError.SUBJECT_NOT_FOUND.getErrorMessage()));
        subjectsRepository.deleteById(subjectId);
    }
}

