package com.quizproject.gameB;

import lombok.Data;

@Data
public class GameItemVO {
    private int giId;
    private String serial;
    private String subTitle;
    private String content;
    private String img;
    private String answer;
    private int score;
    private String gId;
    private String firstDt;
    private String lastDt;

}
