package com.quizproject.user;

import com.quizproject.gameB.GameItemVO;
import com.quizproject.gameB.GameVO;
import com.quizproject.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDao userDao;
    @Override
    public HashMap<String, Object> selectUser(UserVO userVO) {
        UserVO result = userDao.selectUser(userVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result != null) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "로그인 성공");
            returnMap.put(Message.RESULT, result);
        }
        else {
            returnMap.put(Message.MSG, "로그인 실패");
            returnMap.put(Message.NO, "N");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> selectUserByUId(UserVO userVO) {
        UserVO result = userDao.selectUserByUId(userVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result != null) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "회원조회 성공");
            returnMap.put(Message.RESULT, result);
        }
        else {
            returnMap.put(Message.MSG, "회원조회 실패");
            returnMap.put(Message.NO, "N");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> insertUser(UserVO userVO) {
        int result = userDao.insertUser(userVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result > 0) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "회원가입 성공");
        }
        else {
            returnMap.put(Message.MSG, "회원가입 실패");
            returnMap.put(Message.NO, "N");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> selectMyGame(int uId) {
        List<GameVO> resultList = userDao.selectMyGame(uId);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (resultList != null) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "마이게임 조회 성공");
            returnMap.put(Message.RESULT, resultList);
        }
        else {
            returnMap.put(Message.MSG, "마이게임 조회 실패");
            returnMap.put(Message.NO, "N");
        }

        return returnMap;
    }
}
