package com.putracode.mongodb.service;

import com.putracode.mongodb.domain.Student;

import java.util.List;

/**
 * Created by KrisnaPutra on 12/26/2015.
 */
public interface StudentSM {
    List<Student> findAllStudent();
    boolean createStudent(Student student) throws Exception;
    boolean deleteStudent(String _id) throws Exception;

    // Greater , Less and Between Spring Way
    List<Student> findByAgeUsingGreaterThanEqualSpringWay(Long Age);
    List<Student> findByAgeUsingLessThanSpringWay(Long Age);
    List<Student> findByAgeUsingBetweenSpringWay(Long Age,Long Age2);

}
