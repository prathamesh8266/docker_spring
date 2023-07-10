package com.example.docker.controller;

import com.example.docker.entity.DemoEntity;
import com.example.docker.repository.DemoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app")
@CrossOrigin
public class TestController {

    @Autowired
    DemoRepo db;

    @GetMapping("/")
    public ResponseEntity<String> getDummy(){
        return new ResponseEntity<>("working", HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> save(@RequestBody DemoEntity body){
        try{
            System.out.println(body.toString());
            db.save(body);
            return new ResponseEntity<>("SAVED TO THE DATABASE",HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("SOMETHING WENT WRONG",HttpStatus.OK);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<DemoEntity>> getData(){
        try{
            return new ResponseEntity<>(db.findAll(),HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
        }
    }
}
