package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameItemADao {

    private final GameAMapper gameAMapper;

    public void addGameItem(GameItemAVO gameItemAVO){

        System.out.println(">>>>> GameItem1 저장");
        System.out.println(">>>>> gameItemVO: " + gameItemAVO);

        gameAMapper.insertGameItem1(gameItemAVO);
        gameAMapper.insertGameItem2(gameItemAVO);

    }

    public List<GameItemAVO> selectGameItem(GameItemAVO gameItemAVO){
        System.out.println(">>>>> itemdao..itemvo: " + gameItemAVO);
        return gameAMapper.selectGameItem(gameItemAVO);
    }

}
