package com.example.diary.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class EmailValidatorTest {

    @Test
    public void isValidTest() {
        Assert.assertEquals(EmailValidator.isValid("digimon.1740@gmail.com"), true);
        log.info("result of digimon.1740@gmail.com : {}", EmailValidator.isValid("digimon.1740@gmail.com"));

        Assert.assertEquals(EmailValidator.isValid("digimon.1740"), false);
        log.info("result of digimon.1740 : {}", EmailValidator.isValid("digimon.1740"));

        Assert.assertEquals(EmailValidator.isValid("Digimon.1740@gmail.com"), true);
        log.info("result of Digimon.1740@gmail.com : {}", EmailValidator.isValid("Digimon.1740@gmail.com"));
    }
}
