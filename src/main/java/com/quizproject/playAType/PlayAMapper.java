package com.quizproject.playAType;

import com.quizproject.gameAType.ResultAVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlayAMapper {
    void insertPlay(PlayAVO playAVO);
    int insertPlayItem(PlayItemAVO playItemAVO);
    ResultAVO selectResult(int pId);
    void updatePlay(int pId);
}
