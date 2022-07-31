package com.quizproject.playB;

import com.quizproject.gameB.GameItemVO;
import com.quizproject.gameB.GameVO;
import com.quizproject.util.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class PlayBServiceImpl implements PlayBService {

    private final PlayBDao playBDao;
    @Override
    public HashMap<String, Object> selectGameList() {
        List<PlayVO> resultList = playBDao.selectGameBList();

        HashMap<String, Object> returnMap = new HashMap<>();
        if (resultList != null) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "게임리스트 조회 성공");
            returnMap.put(Message.RESULT, resultList);
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "게임리스트 조회 실패");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> insertPlay(PlayVO playVO) {
        int result = playBDao.insertPlay(playVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result > 0) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "플레이 삽입 성공");
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "플레이 삽입 실패");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> selectGameItem(HashMap<String, String> paramMap) {
        List<GameItemVO> resultList = playBDao.selectGameItem(paramMap);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (resultList != null) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "게임아이템 리스트 조회 성공");
            returnMap.put(Message.RESULT, resultList);
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "게임아이템 리스트 조회 실패");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> insertPlayItem(PlayItemVO playItemVO) {
        int result = playBDao.insertPlayItem(playItemVO);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result > 0) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "플레이아이템 삽입 성공");
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "플레이아이템 삽입 실패");
        }

        return returnMap;
    }

    @Override
    public HashMap<String, Object> selectPlayResult(int pId) {
        ResultVO result = playBDao.selectPlayResult(pId);

        HashMap<String, Object> returnMap = new HashMap<>();
        if (result != null) {
            returnMap.put(Message.IS_SUCCEEDED, Message.YES);
            returnMap.put(Message.MSG, "플레이 결과 조회 성공");
            returnMap.put(Message.RESULT, result);
        }
        else {
            returnMap.put(Message.IS_SUCCEEDED, Message.NO);
            returnMap.put(Message.MSG, "플레이 결과 조회 실패");
        }

        return returnMap;
    }
}
