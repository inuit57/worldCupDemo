package com.myWorldcup.demo.member.controller;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.domain.MemberForm;
import com.myWorldcup.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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
    public String addMember(@Valid MemberForm form, BindingResult result){

        if( result.hasErrors()){
            return "/member/addForm";
        }

        memberService.save(form); // 저장하기

        return "redirect:/member/list";
        // 테스트라서 목록으로 넘어가지만 실제로는 메인으로 넘어가야 한다.
        //return "redirect:/";
    }

    @GetMapping("/list")
    public String listMember(Model model){

        List<Member> members = memberService.findAll();
        model.addAttribute("members",members);

        return "/member/list";
    }

}
