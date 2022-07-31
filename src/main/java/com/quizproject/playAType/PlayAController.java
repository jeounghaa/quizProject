package com.quizproject.playAType;

import com.quizproject.gameAType.GameAService;
import com.quizproject.gameAType.GameAVO;
import com.quizproject.gameAType.GameItemAVO;
import com.quizproject.gameAType.ResultAVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlayAController {

    private final PlayAService service;
    private final GameAService gameAService;

    @RequestMapping(value = "/playAType/playGame.do", method = RequestMethod.GET)
    public String openPlay(@RequestParam int gId, GameItemAVO gameItemAVO, Model model) {

        // game에 대한 제목 및 설명
        GameAVO vo = gameAService.selectGame(gId);
        model.addAttribute("vo", vo);

        System.out.println(">>>>> gId: " + gId);
        model.addAttribute("gId", gId);

//        service.insertPlay(playAVO);

        // gameitem
        List<GameItemAVO> item_vo = gameAService.selectGameItem(gameItemAVO);
        for (int i = 0; i < item_vo.size(); i++) {
            System.out.println(">>>>> " + i + "번째: " + item_vo.get(i));
            model.addAttribute("item_vo" + i, item_vo.get(i));
        }

        return "/playAType/playGame";
    }

    @PostMapping(value = "/playAType/playGame.ajax")
    public String addData(PlayAVO playAVO, PlayItemAVO playItemAVO) {
        System.out.println("ajax 시작");
//        service.insertPlay(playAVO);
        System.out.println(">>>>> playAVO: " + playAVO);
        System.out.println(">>>>> playItemAVO: " + playItemAVO);

        System.out.println("pId: " + playAVO.getPId());
        int pid = playAVO.getPId();
        System.out.println(">>> " + pid);

        int a = playItemAVO.getAnswer1().length();
        int b = playItemAVO.getAnswer2().length();
        int c = playItemAVO.getAnswer3().length();

        int g1 = Integer.parseInt(playItemAVO.getAnswer1().substring(a - 1, a));
        int g2 = Integer.parseInt(playItemAVO.getAnswer2().substring(b - 1, b));
        int g3 = Integer.parseInt(playItemAVO.getAnswer3().substring(c - 1, c));

        playItemAVO.setGiId1(g1);
        playItemAVO.setGiId2(g2);
        playItemAVO.setGiId3(g3);
        playItemAVO.setPId(pid);
        for (int i = 1; i < 4; i++) {
            playItemAVO.setSerial(i);
        }
        System.out.println(">>>>> playItemAVO: " + playItemAVO);

        service.insertPlayItem(playItemAVO);
        service.updatePlay();

        return "/playAType/playGame";
    }

    @RequestMapping(value = "/playAType/playGameAResult.do")
    public String openPlay(Model model) {
        System.out.println(">>>>> result start!!");
        ResultAVO resultVO = service.selectResult();
        System.out.println(">>>>> resultVO: " + resultVO);
        model.addAttribute("resultVO", resultVO);

        return "/playAType/playGameAResult";
    }
}