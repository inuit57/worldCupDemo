package com.myWorldcup.demo.member.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

public class MemberUtilsTest {

    private final MemberUtils memberUtils = new MemberUtils();

    private final Logger logger = LoggerFactory.getLogger(MemberUtilsTest.class);

    @Test
    void makeTempPwTest(){
        for(int i=0; i< 5; i++){
            String tempPw = memberUtils.generateTempPw();
            logger.debug("{} : {} " , i, tempPw);
        }
    }
}