package kr.ac.kopo.sun.bookmarket.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import kr.ac.kopo.sun.bookmarket.domain.Member;
import kr.ac.kopo.sun.bookmarket.service.BookService;
import kr.ac.kopo.sun.bookmarket.service.MemberService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

    @RequestMapping("/")
    public String welcom(Model model, Authentication authentication, HttpServletRequest httpServletRequest) {

        if (authentication == null) {
            return "login";
        }

        User user = (User) authentication.getPrincipal();
        String userId = user.getUsername();

        if(userId == null)
            return "redirect:/login";

        Member member = memberService.getMemberByMemberId(userId);

        HttpSession session = httpServletRequest.getSession(true);
        session.setAttribute("userLoginInfo", member);
        return "welcome";
    }
}