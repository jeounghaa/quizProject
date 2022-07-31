package com.quizproject.gameAType;

import lombok.Data;

@Data
public class GameItemAVO {
    //gameitem
    private int giId;
    private int serial;
    private String subTitle;
    private String content;
    private String content1;
    private String content2;
    private String img;
    private String score1;
    private String score2;
    private int gId; //game - gid
    private int count;
}
