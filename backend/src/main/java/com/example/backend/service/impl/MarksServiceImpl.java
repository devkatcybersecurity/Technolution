package com.example.backend.service.impl;

import com.example.backend.dao.Marks;
import com.example.backend.exception.CustomException;
import com.example.backend.exception.ApiError;
import com.example.backend.repository.MarksRepository;
import com.example.backend.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class MarksServiceImpl implements MarksService {

    private final MarksRepository marksRepository;


    @Autowired
    public MarksServiceImpl(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }


    @Override
    public Marks getMarksById(Integer markId) {
        Marks marks = marksRepository.findById(markId).orElseThrow(
                () -> new CustomException(ApiError.MARK_NOT_FOUND.getApiError(), ApiError.MARK_NOT_FOUND.getErrorMessage()));
        return marks;
    }

    @Override
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    @Override
    public Marks addMarks(Integer studentId, Integer subjectId, Integer mark) {
        try{
        return marksRepository.save(Marks.builder()
                .studentId(studentId)
                .subjectId(subjectId)
                .mark(mark)
                .date(new Date())
                .build());}
        catch (Exception e) {
            throw new CustomException(ApiError.MARK_NOT_FOUND.getApiError(), ApiError.MARK_NOT_FOUND.getErrorMessage());
        }
    }

    @Override
    public Marks updateMarks(Integer markId, Integer studentId, Integer subjectId, Integer mark) {
        marksRepository.findById(markId).orElseThrow(
                () -> new CustomException(ApiError.MARK_NOT_FOUND.getApiError(), ApiError.MARK_NOT_FOUND.getErrorMessage()));
        Marks newMarkData = Marks.builder()
                .markId(markId)
                .studentId(studentId)
                .subjectId(subjectId)
                .mark(markId)
                .date(new Date())
                .build();
        return marksRepository.save(newMarkData);
    }

    @Override
    public void deleteMarks(Integer markId) {
        try{
            marksRepository.deleteById(markId);}
        catch (Exception e) {
            throw new CustomException(ApiError.MARK_NOT_FOUND.getApiError(), ApiError.MARK_NOT_FOUND.getErrorMessage());
        }
    }


}

