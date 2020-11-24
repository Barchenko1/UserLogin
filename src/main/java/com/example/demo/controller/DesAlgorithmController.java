package com.example.demo.controller;

import com.example.demo.algorithms.MyDes;
import com.example.demo.model.DesDataLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.constants.Constant.DES_ALGORITHM_PAGE;

@Controller
public class DesAlgorithmController {

    @Autowired
    private MyDes myDes;
    private final String key = "AABB09182736CCDD";
    private String encryptValue;
    private String decryptValue;
    private DesDataLogger encryptDataLogger;
    private DesDataLogger decryptDataLogger;


    @RequestMapping(value = "/des", method = RequestMethod.GET)
    protected ModelAndView desPageGet() {
        ModelAndView modelAndView = new ModelAndView();
        encryptDataLogger = new DesDataLogger();
        decryptDataLogger = new DesDataLogger();
        modelAndView.addObject("key", key);
        modelAndView.addObject("encryptValue", encryptValue);
        modelAndView.addObject("decryptValue", decryptValue);
        modelAndView.setViewName(DES_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/desEncrypt", method = RequestMethod.POST)
    protected ModelAndView desEncryptPost(@RequestParam("value") String value, @RequestParam("key") String key) {
        ModelAndView modelAndView = new ModelAndView();
        encryptValue = myDes.encrypt(value, key);
        encryptDataLogger = myDes.getDesDataLogger();
        List<DesDataLogger> desDataLoggerList = Arrays.asList(encryptDataLogger);
        modelAndView.addObject("encryptDataLogger", desDataLoggerList);
        modelAndView.addObject("key", key);
        modelAndView.addObject("encryptValue", encryptValue);
        modelAndView.addObject("decryptValue", decryptValue);
        modelAndView.setViewName(DES_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/desDecrypt", method = RequestMethod.POST)
    protected ModelAndView desDecryptPost(@RequestParam("value") String value, @RequestParam("key") String key) {
        ModelAndView modelAndView = new ModelAndView();
        decryptValue = myDes.decrypt(value, key);
        decryptDataLogger = myDes.getDesDataLogger();
        List<DesDataLogger> desDataLoggerList = Arrays.asList(decryptDataLogger);
        modelAndView.addObject("decryptDataLogger", desDataLoggerList);
        modelAndView.addObject("key", key);
        modelAndView.addObject("encryptValue", encryptValue);
        modelAndView.addObject("decryptValue", decryptValue);
        modelAndView.setViewName(DES_ALGORITHM_PAGE);
        return modelAndView;
    }

}
