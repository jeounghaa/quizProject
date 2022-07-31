package com.quizproject.gameB;

import com.quizproject.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class GameBSerivceImpl implements GameBService{
    private final GameBDao gameBDao;

//    private final String IS_SUCCEEDED = "isSucceeded";
//    private final String YES = "Y";
//    private final String NO = "N";
//    private final String MSG = "msg";
//    private final String RESULT = "result";

    @Override
    public HashMap<String, Object> insertGame(GameVO gameVO) {
        int result = gameBDao.insertGame(gameVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result > 0) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "게임 삽입 성공");
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "게임 삽입 실패");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> insertGameItem(HashMap<String, String> paramMap) {
        GameItemVO gameItemVO1 = new GameItemVO();
        gameItemVO1.setGId(paramMap.get("gId"));
        gameItemVO1.setSubTitle(paramMap.get("subTitle"));
        gameItemVO1.setContent(paramMap.get("content1"));
        gameItemVO1.setScore(Integer.parseInt(paramMap.get("score1")));
        gameItemVO1.setAnswer(paramMap.get("answer1") != null ? "Y" : "N");
        gameItemVO1.setSerial(paramMap.get("serial"));
        gameItemVO1.setGId(paramMap.get("gId"));

        GameItemVO gameItemVO2 = new GameItemVO();
        gameItemVO2.setGId(paramMap.get("gId"));
        gameItemVO2.setSubTitle(paramMap.get("subTitle"));
        gameItemVO2.setContent(paramMap.get("content2"));
        gameItemVO2.setScore(Integer.parseInt(paramMap.get("score2")));
        gameItemVO2.setAnswer(paramMap.get("answer2") != null ? "Y" : "N");
        gameItemVO2.setSerial(paramMap.get("serial"));
        gameItemVO2.setGId(paramMap.get("gId"));

        int result = gameBDao.insertGameItem(gameItemVO1) + gameBDao.insertGameItem(gameItemVO2);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result == 2) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "게임아이템 삽입 성공");
            returnMap.put(Message.RESULT, result);
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "게임아이템 삽입 실패");
        }

        return returnMap;
    }
}
