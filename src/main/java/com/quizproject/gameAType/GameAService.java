package com.quizproject.gameAType;


import java.util.List;

public interface GameAService {

    void addGame(GameAVO gameAVO);
    void addGameItem(GameItemAVO gameItemAVO);
    void addResult(ResultAVO resultVO);
    List<GameAVO> selectList();
    GameAVO selectGame(int gId);
    // 게임테스트 질문 조회
    List<GameItemAVO> selectGameItem(GameItemAVO gameItemAVO);

}
