package com.quizproject.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @RequestMapping(value="/user/main.do")
    public String main(HttpServletRequest request, HttpServletResponse response){
        return "/main";
    }

    @RequestMapping(value="/user/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response){
        return "/user/login";
    }

    @RequestMapping(value="/user/join.do")
    public String join(HttpServletRequest request, HttpServletResponse response){
        return "/user/join";
    }

    @RequestMapping(value="/user/myPage.do")
    public String myPage(Model model, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        int uId = (int) session.getAttribute("uId");
        UserVO userVO = new UserVO();
        userVO.setUId(uId);

        System.out.println("준비:: " + userVO);

        HashMap<String, Object> resultUser = userService.selectUserByUId(userVO);
        HashMap<String, Object> resultGame = userService.selectMyGame(uId);

        model.addAttribute("resultUser", resultUser.get("result"));
        model.addAttribute("resultGame", resultGame.get("result"));

        return "/user/myPage";
    }


    @PostMapping(value = "/user/selectUser.ajax")
    public ModelAndView selectUser(UserVO userVO, HttpServletRequest request, HttpServletResponse response){
        HashMap<String, Object> resultMap = userService.selectUser(userVO);
        String isSucceeded = (String) resultMap.get("isSucceeded");
        UserVO user = (UserVO) resultMap.get("result");

        if (isSucceeded.equals("Y")) {
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("uId", user.getUId());
        }

        ModelAndView model = new ModelAndView("jsonView", resultMap);

        return model;
    }

    @PostMapping(value = "/user/insertUser.ajax")
    public ModelAndView insertUser(UserVO userVO, HttpServletRequest request, HttpServletResponse response){
        HashMap<String, Object> resultMap = userService.insertUser(userVO);

        ModelAndView model = new ModelAndView("jsonView", resultMap);

        return model;
    }

    @RequestMapping(value="/user/logout.ajax")
    public String logout(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.removeAttribute("uId");
        session.removeAttribute("id");

        return "/user/main";
    }
}
