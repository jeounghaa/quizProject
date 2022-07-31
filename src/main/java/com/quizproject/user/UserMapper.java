package com.quizproject.user;

import com.quizproject.gameB.GameVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    // 로그인
    UserVO selectUser(UserVO userVO);
    int insertUser(UserVO userVO);

    UserVO selectUserByUId(UserVO userVO);

    List<GameVO> selectMyGame(int uId);
}
