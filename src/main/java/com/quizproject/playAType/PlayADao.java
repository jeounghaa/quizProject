package com.quizproject.playAType;

import com.quizproject.gameAType.ResultAVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class PlayADao {

    private final PlayAMapper playAMapper;

    public void insertPlay(PlayAVO playAVO){
        playAMapper.insertPlay(playAVO);
    }

    public int insertPlayItem(PlayItemAVO playItemAVO){
        return playAMapper.insertPlayItem(playItemAVO);
    }
    public ResultAVO selectResult(int pId) {
        return playAMapper.selectResult(pId);
    }
    public void updatePlay(int pId){playAMapper.updatePlay(pId);}
}
