package com.quizproject.gameAType;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface GameAMapper {

    void insertGame(GameAVO gameAVO);
//    void insertGameItem1(int count, GameItemAVO gameItemAVO);
    void insertGameItem1(GameItemAVO gameItemAVO);
    void insertGameItem2(GameItemAVO gameItemAVO);
    void insertResult(ResultAVO resultVO);
    int selectGID();
    List<GameAVO> selectList();
    GameAVO selectGame(int gId);
    List<GameItemAVO> selectGameItem(GameItemAVO gameItemAVO);
}
