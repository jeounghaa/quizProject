package com.quizproject.gameB;

import java.util.HashMap;

public interface GameBService {
    // 게임 삽입
    HashMap<String, Object> insertGame(GameVO gameVO);

    // 게임아이템 삽입
    HashMap<String, Object> insertGameItem(HashMap<String, String> paramMap);
}
