package com.putracode.mongodb.service;

import com.putracode.mongodb.domain.Student;

import java.util.List;

/**
 * Created by KrisnaPutra on 12/26/2015.
 */
public interface StudentSM {
    public List<Student> findAllStudent();
    public boolean createStudent(Student student) throws Exception;
    public boolean deleteStudent(String _id) throws Exception;
}
