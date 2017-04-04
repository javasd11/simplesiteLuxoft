package com.vados.service.dao;

import com.vados.service.GenericDao;
import com.vados.web.model.Pages;

public interface PageDao extends GenericDao<Pages, Integer>{

    public Pages findByUrl(String url);
}
