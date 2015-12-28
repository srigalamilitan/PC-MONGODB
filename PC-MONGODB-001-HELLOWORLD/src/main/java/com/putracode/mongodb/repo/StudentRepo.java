package com.putracode.mongodb.repo;

import com.putracode.mongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by KrisnaPutra on 12/26/2015.
 */
public interface StudentRepo extends MongoRepository<Student,String>{

}
