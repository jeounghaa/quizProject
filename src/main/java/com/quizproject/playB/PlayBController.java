package com.quizproject.playB;

import com.quizproject.gameB.GameVO;
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
public class PlayBController {
    private final PlayBService playBService;

    @RequestMapping(value = "/playB/playList.do")
    public String quizBList(Model model, HttpServletRequest request) {
        HashMap<String, Object> resultMap = playBService.selectGameList();

        model.addAttribute("result", resultMap.get("result"));

        return "/playB/playList";
    }

    @RequestMapping(value = "/playB/play.do")
    public String play(@RequestParam HashMap<String, String> paramMap, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int uId = (int) session.getAttribute("uId");

        PlayVO playVO = new PlayVO();
        playVO.setGId(Integer.parseInt(paramMap.get("gId")));
        playVO.setUId(uId);
        playVO.setState("C");

        int pId = 0;
        if (Integer.parseInt(paramMap.get("serial")) == 1) {
            playBService.insertPlay(playVO);
            pId = playVO.getPId();
        }
        else {
            pId = Integer.parseInt(paramMap.get("pId"));
        }

        System.out.println("파람:: " + paramMap);

        HashMap<String, Object> resultMapGameItem = playBService.selectGameItem(paramMap);

        model.addAttribute("order", paramMap.get("serial"));
        model.addAttribute("pId", pId);
        model.addAttribute("gId", playVO.getGId());
        model.addAttribute("resultGameItem", resultMapGameItem.get("result"));

        return "/playB/play";
    }

    @PostMapping(value = "/playB/insertPlayItem.ajax")
    public ModelAndView insertPlayItem(PlayItemVO playItemVO){
        playItemVO.setGiId(Integer.parseInt(playItemVO.getAnswer()));
        System.out.println("준비:: " + playItemVO);
        HashMap<String, Object> resultMap = playBService.insertPlayItem(playItemVO);
        System.out.println("결과:: " + resultMap);

        ModelAndView modelAndView = new ModelAndView("jsonView", resultMap);
        return modelAndView;
    }

    @RequestMapping(value = "/playB/playResult.do")
    public String gameItem(@RequestParam String pId, Model model, HttpServletRequest request){
        HashMap<String, Object> result = playBService.selectPlayResult(Integer.parseInt(pId));

        model.addAttribute("result", result.get("result"));

        return "/playB/playResult";
    }


}
