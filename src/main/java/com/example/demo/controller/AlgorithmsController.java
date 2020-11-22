package com.example.demo.controller;

import com.example.demo.algorithms.MyRsa;
import com.example.demo.model.KeyData;
import com.example.demo.model.RsaData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static com.example.demo.constants.Constant.*;

@Controller
public class AlgorithmsController {

    private MyRsa rsa = new MyRsa();
    private KeyData keyData;
    private String encrypted;
    private String decrypt;

    @RequestMapping(value = "/rsa", method = RequestMethod.GET)
    protected ModelAndView rsaPageGet() {
        ModelAndView modelAndView = new ModelAndView();
        rsa = new MyRsa();
        modelAndView.setViewName(RSA_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/generateRsaKeys", method = RequestMethod.GET)
    protected ModelAndView generateRsaKeysGet() {
        rsa.createKeys();
        keyData = rsa.getKeyData();
        ModelAndView modelAndView = new ModelAndView();
        List<KeyData> keyDataList = Arrays.asList(keyData);
        modelAndView.addObject("keyDataList", keyDataList);
        modelAndView.setViewName(RSA_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/encryptRsa", method = RequestMethod.POST)
    protected ModelAndView encryptRsaPagePost(@ModelAttribute("rsaData") RsaData rsaData) {
        ModelAndView modelAndView = new ModelAndView();
        rsa.createKeys();
        keyData = rsa.getKeyData();
        encrypted = rsa.encryptService(new BigInteger(rsaData.geteNumber()), new BigInteger(rsaData.getnNumber()), rsaData.getValue());
        List<KeyData> keyDataList = Arrays.asList(keyData);
        modelAndView.addObject("keyDataList", keyDataList);
        modelAndView.addObject("encrypted", encrypted);
        modelAndView.addObject("decrypt", decrypt);
        modelAndView.setViewName(RSA_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/decryptRsa", method = RequestMethod.POST)
    protected ModelAndView decryptRsaPagePost(@ModelAttribute("rsaData") RsaData rsaData) {
        ModelAndView modelAndView = new ModelAndView();
        rsa.createKeys();
        keyData = rsa.getKeyData();
        decrypt = rsa.decryptService(new BigInteger(rsaData.getdNumber()), new BigInteger(rsaData.getnNumber()), rsaData.getValue());
        List<KeyData> keyDataList = Arrays.asList(keyData);
        modelAndView.addObject("keyDataList", keyDataList);
        modelAndView.addObject("encrypted", encrypted);
        modelAndView.addObject("decrypt", decrypt);
        modelAndView.setViewName(RSA_ALGORITHM_PAGE);
        return modelAndView;
    }
}
