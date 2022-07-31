package com.quizproject.playAType;

import com.quizproject.gameAType.ResultAVO;

public interface PlayAService {
    void insertPlay(PlayAVO playAVO);
    int insertPlayItem(PlayItemAVO playItemAVO);
    ResultAVO selectResult();
    void updatePlay();
}
