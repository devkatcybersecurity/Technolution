package com.example.backend.service.impl;

import com.example.backend.dao.SubjectTeacher;
import com.example.backend.exception.ApiError;
import com.example.backend.exception.CustomException;
import com.example.backend.repository.SubjectTeacherRepository;
import com.example.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectTeacherServiceImpl implements SubjectTeacherService {


    private final SubjectTeacherRepository subjectTeacherRepository;


    @Autowired
    public SubjectTeacherServiceImpl(SubjectTeacherRepository subjectTeacherRepository) {
        this.subjectTeacherRepository = subjectTeacherRepository;
    }


    @Override
    public List<SubjectTeacher> findAll() {
        return subjectTeacherRepository.findAll();
    }

    @Override
    public SubjectTeacher getSubjectTeacherById(Integer subjectTeacherId) {
        return subjectTeacherRepository.findById(subjectTeacherId).orElseThrow(
                () -> new CustomException(ApiError.SUBJECT_TEACHER_NOT_FOUND.getApiError(), ApiError.SUBJECT_TEACHER_NOT_FOUND.getErrorMessage()));
    }

    @Override
    public SubjectTeacher addSubjectTeacher(Integer subjectId, Integer teacherId, Integer groupId) {
        try {
            return subjectTeacherRepository.save(SubjectTeacher.builder()
                    .subjectId(subjectId)
                    .teacherId(teacherId)
                    .groupId(groupId)
                    .build());
        } catch (Exception e) {
            throw new CustomException(ApiError.SUBJECT_TEACHER_NOT_FOUND.getApiError(), ApiError.SUBJECT_TEACHER_NOT_FOUND.getErrorMessage());
        }
    }

    @Override
    public void deleteSubjectTeacher(Integer subjectTeacherId) {
        try {
            subjectTeacherRepository.deleteById(subjectTeacherId);
        } catch (Exception e) {
            throw new CustomException(ApiError.SUBJECT_TEACHER_NOT_FOUND.getApiError(), ApiError.SUBJECT_TEACHER_NOT_FOUND.getErrorMessage());
        }
    }
}

