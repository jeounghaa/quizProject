package com.quizproject.gameB;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GameBMapper {
    int insertGame(GameVO gameVO);
    int insertGameItem(GameItemVO gameItemVO);
}
