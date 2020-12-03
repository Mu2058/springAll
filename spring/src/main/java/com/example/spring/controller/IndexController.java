package com.example.spring.controller;

import com.example.spring.bean.Account;
import com.example.spring.bean.BlogProperties;
import com.example.spring.config.ConfigBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class IndexController {
    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private ConfigBean configBean;

    @RequestMapping("/")
    String index() {
        return blogProperties.getName()+"——"+blogProperties.getTitle();
    }

    @RequestMapping("/index1")
    String index1() {
        return configBean.getName()+"——"+configBean.getTitle();
    }

    @RequestMapping("/ ")
    public  String index(Model m) {
        List<Account> list = new ArrayList<Account>();
        list.add(new Account("KangKang", "康康", "e10adc3949ba59abbe56e", "超级管理员", "17777777777"));
        list.add(new Account("Mike", "麦克", "e10adc3949ba59abbe56e", "管理员", "13444444444"));
        list.add(new Account("Jane","简","e10adc3949ba59abbe56e","运维人员","18666666666"));
        list.add(new Account("Maria", "玛利亚", "e10adc3949ba59abbe56e", "清算人员", "19999999999"));
        m.addAttribute("accountList",list);
        return "account";
    }

    public static void main(String[] args) {
        System.out.println("1 = " + UUID.randomUUID());
        System.out.println("2 = " + UUID.randomUUID());
        System.out.println("3 = " + UUID.randomUUID());
        System.out.println("4 = " + UUID.randomUUID());
        System.out.println("5 = " + UUID.randomUUID());
        System.out.println("6 = " + UUID.randomUUID());

    }
}