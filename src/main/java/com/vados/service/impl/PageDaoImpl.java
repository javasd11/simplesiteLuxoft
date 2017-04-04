package com.vados.service.impl;

import org.springframework.stereotype.Repository;

import com.vados.service.dao.PageDao;
import com.vados.web.model.Pages;
import java.util.List;
import org.hibernate.Query;

@Repository("pagesDao")
public class PageDaoImpl extends HibernateDao<Pages, Integer>implements PageDao {

    @Override
    public Pages findByUrl(String url) {
        Query query = currentSession().getNamedQuery("Pages.findByUrl").setString("url", url);
        
        List<Pages>pList = query.list();
        if(pList.isEmpty()){
            return null;
        }
        else{
            return pList.get(0);
        }
    }
}