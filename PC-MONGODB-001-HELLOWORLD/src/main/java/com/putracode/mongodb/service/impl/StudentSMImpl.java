package com.putracode.mongodb.service.impl;

import com.putracode.mongodb.domain.Student;
import com.putracode.mongodb.repo.StudentRepo;
import com.putracode.mongodb.service.StudentSM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by KrisnaPutra on 12/26/2015.
 */
@Service
public class StudentSMImpl implements StudentSM {
    @Autowired
    StudentRepo studentRepo;

    @Override
    public List<Student> findAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public boolean createStudent(Student student) throws Exception{
        Student s=studentRepo.insert(student);
        return s.getId()!=null;
    }

    @Override
    public boolean deleteStudent(String _id) throws Exception{
         studentRepo.delete(_id);
        return true;
    }
}
