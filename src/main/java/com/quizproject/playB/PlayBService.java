package com.quizproject.playB;

import com.quizproject.gameB.GameVO;

import java.util.HashMap;

public interface PlayBService {
    // 전체 게임 목록 조회
    HashMap<String, Object> selectGameList();

    // 특정 게임 조회
    HashMap<String, Object> selectGameItem(HashMap<String, String> paramMap);

    // 특정 게임 플레이로 삽입
    HashMap<String, Object> insertPlay(PlayVO playVO);

    HashMap<String, Object> insertPlayItem(PlayItemVO playItemVO);

    HashMap<String, Object> selectPlayResult(int pId);
}
