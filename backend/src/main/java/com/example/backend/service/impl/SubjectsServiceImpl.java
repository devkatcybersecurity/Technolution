package com.example.backend.service.impl;

import com.example.backend.dao.Subjects;
import com.example.backend.exception.ApiError;
import com.example.backend.exception.CustomException;
import com.example.backend.repository.SubjectsRepository;
import com.example.backend.service.SubjectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectsServiceImpl implements SubjectsService {

    private final SubjectsRepository subjectsRepository;


    @Autowired
    public SubjectsServiceImpl(SubjectsRepository subjectsRepository) {
        this.subjectsRepository = subjectsRepository;
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

