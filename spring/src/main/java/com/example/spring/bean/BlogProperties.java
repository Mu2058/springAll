package com.example.spring.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author luomj
 * @version 1.0
 * @description
 * @date 2020/11/24
 **/
@Component
@Data
public class BlogProperties {

    @Value("${m.blog.name}")
    private String name;
    @Value("${m.blog.title}")
    private String title;


}
