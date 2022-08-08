package com.myWorldcup.demo.member.controller;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.domain.MemberDto;
import com.myWorldcup.demo.member.domain.MemberForm;
import com.myWorldcup.demo.member.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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
    public String addMember(@Valid MemberForm form, BindingResult bindingResult){

        if( bindingResult.hasErrors()){
            log.debug("errors={}",bindingResult);
            return "/member/addForm";
        }

        memberService.save(form); // 저장하기

        return "redirect:/member/list";
        // 테스트라서 목록으로 넘어가지만 실제로는 메인으로 넘어가야 한다.
        //return "redirect:/";
    }

    @GetMapping("/list")
    public String listMember(Model model){

        // Entity 가 그대로 노출되는 것은 좋지 않다.
        // 필요한 정보만 가지고 있는 Dto 객체를 대신 돌려주도록 하자.
        List<Member> members = memberService.findAll();

        List<MemberDto> collect = members.stream()
                .map(m -> new MemberDto(m.getId(), m.getUserId(), m.getUserPw(), m.getNickname(), m.getEmailAddress()))
                .collect(Collectors.toList());
        
        model.addAttribute("members",collect);

        return "/member/list";
    }


    @ResponseBody
    @GetMapping("/api/list")
    public Result listMember(){
        List<Member> members = memberService.findAll();
        List<MemberDto> collect = members.stream()
                .map(m -> new MemberDto(m.getId(), m.getUserId(), m.getUserPw(), m.getNickname(), m.getEmailAddress()))
                .collect(Collectors.toList());

        return new Result(collect);
    }

    @Data
    @AllArgsConstructor
    static class Result<T>{
        private T data;
    }

}
