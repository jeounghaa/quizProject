package com.quizproject.gameB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GameBDao {
    private final GameBMapper gameBMapper;

    int insertGame(GameVO gameVO) {
        return gameBMapper.insertGame(gameVO);
    }

    int insertGameItem(GameItemVO gameItemVO) {
        return gameBMapper.insertGameItem(gameItemVO);
    }
}
