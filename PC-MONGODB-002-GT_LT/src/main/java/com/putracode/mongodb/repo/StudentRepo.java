package com.putracode.mongodb.repo;

import com.putracode.mongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Created by KrisnaPutra on 12/26/2015.
 */
public interface StudentRepo extends MongoRepository<Student,String>{

    List<Student> findByAgeGreaterThanEqual(Long age);
    List<Student> findByAgeLessThan(Long Age);
    List<Student> findByAgeBetween(Long age,Long age1);
    fasdfasdf
}
