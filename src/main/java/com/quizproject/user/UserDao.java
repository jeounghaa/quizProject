package com.quizproject.user;

import com.quizproject.gameB.GameVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserDao {
    private final UserMapper userMapper;

    // 로그인
    public UserVO selectUser(UserVO userVO){
        return userMapper.selectUser(userVO);
    }
    public int insertUser(UserVO userVO) {
        return userMapper.insertUser(userVO);
    }

    public UserVO selectUserByUId(UserVO userVO){
        return userMapper.selectUserByUId(userVO);
    }

    List<GameVO> selectMyGame(int uId) {
        return userMapper.selectMyGame(uId);
    }
}
