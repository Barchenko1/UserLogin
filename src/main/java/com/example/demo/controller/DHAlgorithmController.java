package com.example.demo.controller;

import com.example.demo.algorithms.MyDH;
import com.example.demo.model.ClientDHData;
import com.example.demo.model.DHLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

import static com.example.demo.constants.Constant.DH_ALGORITHM_PAGE;

@Controller
public class DHAlgorithmController {

    @Autowired
    private MyDH myDH;

    private DHLogger dhLogger;

    @RequestMapping(value = "/dh", method = RequestMethod.GET)
    protected ModelAndView rsaPageGet() {
        ModelAndView modelAndView = new ModelAndView();
        dhLogger = new DHLogger();
        modelAndView.setViewName(DH_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/showViewLogger", method = RequestMethod.GET)
    protected ModelAndView generateRsaKeysGet() {
        myDH.calculateSecurityClientKey();
        myDH.calculateSecurityServerKey();
        dhLogger = myDH.setUpDHViewLogger();
        ModelAndView modelAndView = new ModelAndView();
        List<DHLogger> dhLoggerList = Arrays.asList(dhLogger);
        modelAndView.addObject("dhLoggerList", dhLoggerList);
        modelAndView.setViewName(DH_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/clientToClient", method = RequestMethod.POST)
    protected ModelAndView clientToClient(@ModelAttribute("clientDHData") ClientDHData clientDHData) {
        myDH.calculatePublicClientKey(clientDHData);
        dhLogger = myDH.setUpDHViewLogger();
        ModelAndView modelAndView = new ModelAndView();
        List<DHLogger> dhLoggerList = Arrays.asList(dhLogger);
        modelAndView.addObject("dhLoggerList", dhLoggerList);
        modelAndView.setViewName(DH_ALGORITHM_PAGE);
        return modelAndView;
    }

    @RequestMapping(value = "/serverToClient", method = RequestMethod.GET)
    protected ModelAndView serverToClient() {
        myDH.calculatePublicServerKey();
        dhLogger = myDH.setUpDHViewLogger();
        ModelAndView modelAndView = new ModelAndView();
        List<DHLogger> dhLoggerList = Arrays.asList(dhLogger);
        modelAndView.addObject("dhLoggerList", dhLoggerList);
        modelAndView.setViewName(DH_ALGORITHM_PAGE);
        return modelAndView;
    }

}
