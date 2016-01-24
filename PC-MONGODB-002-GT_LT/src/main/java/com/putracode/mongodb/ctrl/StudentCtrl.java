package com.putracode.mongodb.ctrl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.putracode.mongodb.common.JsonUtils;
import com.putracode.mongodb.domain.Student;
import com.putracode.mongodb.service.StudentSM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by KrisnaPutra on 12/26/2015.
 */
@RestController
@RequestMapping("/student")
public class StudentCtrl {
    @Autowired
    StudentSM studentSM;
    @Autowired
    ObjectMapper mapper;
    @Autowired
    JsonUtils jsonUtils;
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<String> createStudent(@RequestBody HashMap<String,Object> data){
        try {
            ObjectMapper map=new ObjectMapper();
            map.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Student student=map.convertValue(data,Student.class);
            if (studentSM.createStudent(student)){
                return new ResponseEntity<>("Data Inserted: Ok", HttpStatus.OK);
            }else
                return new ResponseEntity<>("Data Inserted: Not Ok", HttpStatus.OK);
        }catch ( Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Data Inserted: Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET)
    public ResponseEntity<String> findAll()throws Exception{
        return new ResponseEntity<>(mapper.writeValueAsString(studentSM.findAllStudent()),HttpStatus.OK);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseEntity<String> deleteStudent(@RequestParam("id") String id){
        try {
            if (studentSM.deleteStudent(id)){
                return new ResponseEntity<>("Data Inserted: Ok", HttpStatus.OK);
            }else
                return new ResponseEntity<>("Data Inserted: Not Ok", HttpStatus.OK);
        }catch ( Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Data Inserted: Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Spring Way
    @RequestMapping(value = "/ageGreaterThanEqualSW",method = RequestMethod.GET)
    public ResponseEntity<String> ageGreaterThanEqualSW(@RequestParam("age") Long Age){
        try{
            return new ResponseEntity<>(jsonUtils.toJson(studentSM.findByAgeUsingGreaterThanEqualSpringWay(Age)),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/ageUsingLessThanSW",method = RequestMethod.GET)
    public ResponseEntity<String> AgeUsingLessThanSW(@RequestParam("age") Long Age){
        try{
            return new ResponseEntity<>(jsonUtils.toJson(studentSM.findByAgeUsingLessThanSpringWay(Age)),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/AgeUsingBetween",method = RequestMethod.GET)
    public ResponseEntity<String> AgeUsingBetween(@RequestParam("age1") Long Age1,@RequestParam("age2") Long Age2){
        try{
            return new ResponseEntity<>(jsonUtils.toJson(studentSM.findByAgeUsingBetweenSpringWay(Age1,Age2)),HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
