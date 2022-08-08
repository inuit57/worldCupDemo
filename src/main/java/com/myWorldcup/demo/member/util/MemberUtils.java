package com.myWorldcup.demo.member.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Component
public class MemberUtils {

    public String generateTempPw(){
        // 8자 숫자+영문 섞인 임시 비밀번호 생성하기
        List<Integer> numbers = new Random().ints('0', '9' + 1)
                .distinct()
                .limit(3)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> alpha = new Random().ints('A', 'z' + 1)
                .filter(i -> (i <= 'Z' || 'a' <= i))
                .limit(5)
                .boxed()
                .collect(Collectors.toList());

        numbers.addAll(alpha);
        Collections.shuffle(numbers);

        return numbers.stream()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
