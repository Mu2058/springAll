package com.example.spring;

import com.example.spring.bean.Student;
import com.example.spring.bean.User;
import com.example.spring.service.StudentService;
import com.example.spring.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTest {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @Test
    public void test1() throws Exception {
        PageHelper.startPage(2, 2);

        User user = new User();
        user.setId(userService.getSequence("seq_user"));
        user.setUserName("scott");
        user.setPassword("ac089b11709f9b9e9980e7c497268dfa");
        user.setBirthday(new Date());
        user.setAge(11);
        this.userService.save(user);
    }

    @Test
    public void test2() throws Exception {
        PageHelper.startPage(2, 2);
        List<User> list = userService.selectAll();
        PageInfo<User> pageInfo = new PageInfo<User>(list);
        List<User> result = pageInfo.getList();
        for (User u : result) {
            System.out.println(u.getUserName());
        }
    }

    @Test
    public void test() throws Exception {
        Student student1 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

        student1.setName("康康");
        this.studentService.update(student1);

        Student student2 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
    }


}