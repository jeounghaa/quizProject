package com.quizproject.gameAType;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameAServiceImpl implements GameAService {

    private final GameADao gameDao;
    private final GameItemADao itemDao;
    static int count; // serial
    static int gId;

    @Override
    public void addGame(GameAVO gameAVO) {
        System.out.println(gameAVO);
        gId = gameDao.selectGID()+1; //max값 + 1
        System.out.println(">>>>> addGame..gId: " + gId);
        gameAVO.setGId(gId);

        gameDao.addGame(gameAVO);
    }

    @Override
    public void addGameItem(GameItemAVO gameItemAVO) {

        gameItemAVO.setGId(gId);

        itemDao.addGameItem(gameItemAVO);
    }

    @Override
    public void addResult(ResultAVO resultVO) {
        gameDao.addResult(resultVO);
    }

    @Override
    public List<GameAVO> selectList() {

        return gameDao.selectList();

    }

    @Override
    public GameAVO selectGame(int gId) {
        return gameDao.selectGame(gId);
    }

    @Override
    public List<GameItemAVO> selectGameItem(GameItemAVO gameItemAVO) {
        System.out.println(">>>>> dao..selectGameItem: " + itemDao.selectGameItem(gameItemAVO));

        return itemDao.selectGameItem(gameItemAVO);
    }

}
