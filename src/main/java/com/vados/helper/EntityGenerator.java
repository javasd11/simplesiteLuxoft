package com.vados.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vados.service.dao.PageDao;
import com.vados.web.model.Pages;

@Service
public class EntityGenerator {

    @Autowired
    private PageDao pageDao;

    public void generateDomain() {
        Pages page = new Pages();
        page.setUrl("index");
        page.setView("index");
        page.setDescription(" Welcome to main page ");
        page.setContent("It is a long established fact that a reader "
                + "will be distracted by the readable content of a page "
                + "when looking at its layout. The point of using Lorem "
                + "Ipsum is that it has a more-or-less normal "
                + "distribution of letters, as opposed to using "
                + "'Content h ");

        pageDao.add(page);
        
    }

    public void deleteDomain() {
        List<Pages> pageList = pageDao.list();
        for (Pages p : pageList) {
            pageDao.remove(p);
        }
    }
}
