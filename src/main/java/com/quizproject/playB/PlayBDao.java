package com.quizproject.playB;

import com.quizproject.gameB.GameItemVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PlayBDao {
    private final PlayBMapper playBMapper;

    List<PlayVO> selectGameBList() {
        return playBMapper.selectGameList();
    }

    List<GameItemVO> selectGameItem(HashMap<String, String> paramMap) {
        return playBMapper.selectGameItem(paramMap);
    }

    int insertPlay(PlayVO playVO) {
        return playBMapper.insertPlay(playVO);
    }

    int insertPlayItem(PlayItemVO playItemVO) {
        return playBMapper.insertPlayItem(playItemVO);
    }

    ResultVO selectPlayResult(int pId) {
        return playBMapper.selectPlayResult(pId);
    }
}
