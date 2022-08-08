package com.myWorldcup.demo.member.controller;

import com.myWorldcup.demo.member.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/add")
    public String addMember(){
        System.out.println("MemberController.addMember(POST)");
        return "/member/addForm";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member){
        System.out.println("MemberController.addMember(POST)");
        System.out.println(member.getUserId());
        log.debug("#### member = {} ", member);

        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String listMember(Model model){
        System.out.println("MemberController.listMember");

        return "/member/list";
    }

}
