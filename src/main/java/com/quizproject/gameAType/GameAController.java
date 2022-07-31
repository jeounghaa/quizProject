package com.quizproject.gameAType;

import com.quizproject.playAType.PlayAService;
import com.quizproject.playAType.PlayAVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GameAController {

    private final GameAService service;
    private final PlayAService playAService;

    static int count; // serial

    @RequestMapping(value = "/gameAType/gameACreate.do")
    public String openCreate(HttpServletRequest request, HttpServletResponse response) {
        return "/gameAType/gameACreate";
    }

    // game 저장
    @RequestMapping(value = "/gameAType/addGame.do")
    public void addGame(GameAVO gameAVO) {
        service.addGame(gameAVO);
    }

    // game, gameItem ajax
    @PostMapping(value = "/gameAType/addMain.ajax")
    public ModelAndView addData(GameAVO gameAVO, GameItemAVO gameItemAVO, ResultAVO resultVO) {
        System.out.println("ajax 시작");
        System.out.println(">>>>>> gameAVO: " + gameAVO);
        System.out.println(">>>>>> gameItemAVO: " + gameItemAVO);
        System.out.println(">>>>> resultVO: " + resultVO);

        count += 1;

        gameItemAVO.setCount(count);

        if (count > 1) {
            service.addGameItem(gameItemAVO);
            if(count == 3){
                count = 0;
            }
        } else {
            service.addGame(gameAVO);
            resultVO.setGId(gameAVO.getGId());
            service.addResult(resultVO);
            service.addGameItem(gameItemAVO);
        }

        HashMap<String, Object> result = new HashMap<>();
        result.put("gameAVO", gameAVO);

        ModelAndView model = new ModelAndView("jsonView", result);

        return model;

    }

    @RequestMapping(value = "/gameAType/gameAResult.do")
    public String openResult(Model model, HttpServletRequest request, HttpServletResponse response) {
        List<GameAVO> vo = service.selectList();
        System.out.println(vo);
//
//        System.out.println(vo);

        model.addAttribute("vo", vo);

        return "/gameAType/gameAResult";
    }

    @PostMapping(value = "/gameAType/addPlay.ajax")
    public String addData(int gId, PlayAVO playAVO){
        System.out.println(">>>>> addplay..gId:" + gId);

        playAVO.setGId(gId);
        playAService.insertPlay(playAVO);
        System.out.println("addplay.ajax..playAVO: " + playAVO);

        return "success";
    }



}
