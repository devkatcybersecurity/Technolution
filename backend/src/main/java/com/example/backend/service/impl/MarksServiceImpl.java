package com.example.backend.service.impl;

import com.example.backend.dao.Marks;
import com.example.backend.dao.Students;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ApiError;
import com.example.backend.repository.MarksRepository;
import com.example.backend.repository.StudentsRepository;
import com.example.backend.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;
    private final StudentsRepository studentsRepository;


    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository,
                            StudentsRepository studentsRepository) {
        this.marksRepository = marksRepository;
        this.studentsRepository = studentsRepository;
    }


    @Override
    public long getMarks(int studentsId) {
        Optional<Students> students= studentsRepository.findById(studentsId);
        if(students.isPresent()) {
            List<Marks> markList= students.get().getMarksList();
            return markList.stream().mapToLong(s -> s.getMarks()).sum();
        }
        return 0;

    }
    @Override
    public Marks getMarksById(Integer markId) {
        Marks marks = marksRepository.findById(markId).orElseThrow(
                () -> new CustomException("Mark with id " + markId + " not found", HttpStatus.NOT_FOUND));
        return marks;
    }

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public Marks addMarks(Integer studentId, Integer subjectId, Integer mark) {
//        try{
//        return marksRepository.save(Marks.builder()
//                .studentId(studentId)
//                .subjectId(subjectId)
//                .mark(mark)
//                .date(new Date())
//                .build());}
//        catch (Exception e) {
//            throw new CustomException(ApiError.MARK_NOT_FOUND.getApiError(), ApiError.MARK_NOT_FOUND.getErrorMessage());
//        }
        return null;
    }

    @Override
    public Marks updateMarks(Integer markId, Integer studentId, Integer subjectId, Integer mark) {
//        marksRepository.findById(markId).orElseThrow(
//                () -> new CustomException(ApiError.MARK_NOT_FOUND.getApiError(), ApiError.MARK_NOT_FOUND.getErrorMessage()));
//        Marks newMarkData = Marks.builder()
//                .markId(markId)
//                .studentId(studentId)
//                .subjectId(subjectId)
//                .mark(markId)
//                .date(new Date())
//                .build();
//        return marksRepository.save(newMarkData);

        return null;
    }

    @Override
    public void deleteMarks(Integer markId) {
        try{
            marksRepository.deleteById(markId);}
        catch (Exception e) {
            throw new CustomException("Mark with id " + markId + " not found", HttpStatus.NOT_FOUND);
        }
    }


}

