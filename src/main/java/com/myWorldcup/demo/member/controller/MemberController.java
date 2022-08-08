package com.myWorldcup.demo.member.controller;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.repository.MemberRepository;
import com.myWorldcup.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addMember(Model model){
        return "/member/addForm";
    }

    @PostMapping("/add")
    public String addMember(@ModelAttribute Member member){
        log.debug("#### member = {} ", member);

        memberService.save(member); // 저장하기

        return "redirect:/member/list";
    }

    @GetMapping("/list")
    public String listMember(Model model){
        System.out.println("MemberController.listMember");

        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);

        return "/member/list";
    }

}
