package com.quizproject.gameB;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class GameBController {

    private final GameBService gameBService;

    @RequestMapping(value = "/gameB/game.do")
    public String game(){
        return "/gameB/game";
    }

    @RequestMapping(value = "/gameB/gameItem.do")
    public String gameItem(@RequestParam String gId, Model model, HttpServletRequest request){
        model.addAttribute("gId", gId);

        return "/gameB/gameItem";
    }

    @PostMapping(value = "/gameB/insertGame.ajax")
    public ModelAndView insertGame(GameVO paramVO, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
//        String uId = (String) session.getAttribute("uId");
//        paramVO.setUId(Integer.parseInt(uId));
        int uId = (int) session.getAttribute("uId");
        paramVO.setUId(uId);

        HashMap<String, Object> resultMap = gameBService.insertGame(paramVO);
        resultMap.put("gId", paramVO.getGId());

        ModelAndView modelAndView = new ModelAndView("jsonView", resultMap);
        return modelAndView;
    }

    @PostMapping(value = "/gameB/insertGameItem.ajax")
    public ModelAndView insertGameItem(@RequestParam HashMap<String, String> paramMap, HttpServletRequest request) {
        HashMap<String, Object> resultMap = gameBService.insertGameItem(paramMap);

        ModelAndView model = new ModelAndView("jsonView", resultMap);
        return model;
    }
}
