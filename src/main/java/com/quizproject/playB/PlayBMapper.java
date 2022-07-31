package com.quizproject.playB;

import com.quizproject.gameB.GameItemVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PlayBMapper {
    List<PlayVO> selectGameList();

    List<GameItemVO> selectGameItem(HashMap<String, String> paramMap);

    int insertPlay(PlayVO playVO);

    int insertPlayItem(PlayItemVO playItemVO);

    ResultVO selectPlayResult(int pId);
}
