package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class GameADao {

    private final GameAMapper gameAMapper;

    public int selectGID(){
        return gameAMapper.selectGID();
    }

    public void addGame(GameAVO gameAVO) {
        gameAMapper.insertGame(gameAVO);
    }
    public void addResult(ResultAVO resultVO){
        gameAMapper.insertResult(resultVO);
    }
    public List<GameAVO> selectList(){
        return gameAMapper.selectList();
    }
    public GameAVO selectGame(int gId){
        return gameAMapper.selectGame(gId);
    }

}
