package com.example.spring.bean;

import com.example.spring.deserialize.UserDeserializer;
import com.example.spring.serializer.UserSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties({ "password", "age" })
@JsonNaming(PropertyNamingStrategy.LowerCaseStrategy.class)
@JsonSerialize(using = UserSerializer.class)
@JsonDeserialize(using = UserDeserializer.class)
public class User implements Serializable {
    private static final long serialVersionUID = 6222176558369919436L;

    private Long id;
    private String name;
    private String userName;
    private int age;
    @JsonIgnore
    private String password;

    @JsonProperty("bth")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date birthday;

}