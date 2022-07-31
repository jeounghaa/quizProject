package com.quizproject.gameAType;

import lombok.Data;

@Data
public class GameAVO {
    //game
    private int gId;
    private String title;
    private String intro; //소개글
    private String thumbnail;
    private String type;
    private String uId;


}
