package com.quizproject.user;

import lombok.Data;

@Data
public class UserVO {
    private int uId;
    private String id;
    private String pw;
    private String name;
    private String email;
    private String firstDt;
    private String lastDt;
}
