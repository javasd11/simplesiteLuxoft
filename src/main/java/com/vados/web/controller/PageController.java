package com.vados.web.controller;

import com.vados.helper.EntityGenerator;
import com.vados.service.dao.PageDao;
import com.vados.web.model.Pages;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

    @Autowired
    private EntityGenerator entityGenerator;

    @Autowired
    private PageDao pageDao;

    @RequestMapping(value = {"/{pagename}"})
    public ModelAndView getMessagePage(@PathVariable("pagename") String name) {
        ModelAndView mav = new ModelAndView();
        Pages page = getPageByUrl(name);
        mav.addObject("page", page);
        mav.setViewName(page.getView());
        return mav;
    }

    @RequestMapping(value = {"/"})
    public String getWelcomePage() {
        return "redirect:/index";
    }

    private Pages getPageByUrl(String url) {
        return pageDao.findByUrl(url == null ? "index" : url);
    }

    @PostConstruct
    public void prepareFakeDomain() {
        entityGenerator.deleteDomain();
        entityGenerator.generateDomain();
    }
}
