package com.example.backend.repository;


import com.example.backend.dao.SubjectTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectTeacherRepository extends JpaRepository<SubjectTeacher, Integer> {
}

