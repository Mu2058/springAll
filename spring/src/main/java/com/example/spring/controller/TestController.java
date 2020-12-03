package com.example.spring.controller;

import com.example.spring.bean.Student;
import com.example.spring.bean.User;
import com.example.spring.dao.StudentDao;
import com.example.spring.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentDao studentDao;
    
    @RequestMapping( value = "/querystudent", method = RequestMethod.GET)
    public Student queryStudentBySno(String sno) {
        return this.studentService.queryStudentBySno(sno);
    }

    @RequestMapping( value = "/querystudentList", method = RequestMethod.GET)
    public List<Map<String, Object>> querystudentList() {
        return this.studentDao.queryStudentsListMap();
    }

    @RequestMapping("getuser")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserName("m");
        user.setBirthday(new Date());
        return user;
    }

    @Autowired
    ObjectMapper mapper;

    @RequestMapping("serialization")
    @ResponseBody
    public String serialization() {
        try {
            User user = new User();
            user.setUserName("m");
            user.setBirthday(new Date());
            String str = mapper.writeValueAsString(user);
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("readjsonasobject")
    @ResponseBody
    public String readJsonAsObject() {
        try {
            String json = "{\"user-name\":\"m\"}";
            User user = mapper.readValue(json, User.class);
            String name = user.getUserName();
            return name;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}