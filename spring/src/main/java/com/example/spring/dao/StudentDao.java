package com.example.spring.dao;

import com.example.spring.bean.Student;

import java.util.List;
import java.util.Map;

/**
 * @author luomj
 * @version 1.0
 * @description
 * @date 2020/11/25
 **/
public interface StudentDao {

    int add(Student student);

    int update(Student student);

    int deleteBysno(String sno);

    List<Map<String, Object>> queryStudentsListMap();

    Student queryStudentBySno(String sno);
}
