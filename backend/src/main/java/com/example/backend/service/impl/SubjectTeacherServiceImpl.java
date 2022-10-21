package com.example.backend.service.impl;

import com.example.backend.dao.Groups;
import com.example.backend.dao.Students;
import com.example.backend.dao.SubjectTeacher;
import com.example.backend.exception.ApiError;
import com.example.backend.exception.CustomException;
import com.example.backend.repository.GroupsRepository;
import com.example.backend.repository.SubjectTeacherRepository;
import com.example.backend.service.SubjectTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectTeacherServiceImpl implements SubjectTeacherService {


    private final SubjectTeacherRepository subjectTeacherRepository;
    private final GroupsRepository groupsRepository;


    @Autowired
    public SubjectTeacherServiceImpl(SubjectTeacherRepository subjectTeacherRepository,
                                     GroupsRepository groupsRepository) {
        this.subjectTeacherRepository = subjectTeacherRepository;
        this.groupsRepository = groupsRepository;
    }


    @Override
    public long noOfStudentsFromTeacherId(int teacherId) {
        SubjectTeacher subjeOptional = subjectTeacherRepository.findByTeacherId(teacherId);
        if(subjeOptional!=null) {
            Groups groups = subjeOptional.getGroups();
            Optional<Groups> groupsOptional = groupsRepository.findById(groups.getGroupId());
            if(groupsOptional.isPresent()) {
                List<Students> stuList= groupsOptional.get().getStudentsList();
                return stuList.stream().map(s -> s.getStudentId()).count();
            }
        }
        return 0;
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
//        try {
//            return subjectTeacherRepository.save(SubjectTeacher.builder()
//                    .subjectId(subjectId)
//                    .teacherId(teacherId)
//                    .groupId(groupId)
//                    .build());
//        } catch (Exception e) {
//            throw new CustomException(ApiError.SUBJECT_TEACHER_NOT_FOUND.getApiError(), ApiError.SUBJECT_TEACHER_NOT_FOUND.getErrorMessage());
//        }
        return null;
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

