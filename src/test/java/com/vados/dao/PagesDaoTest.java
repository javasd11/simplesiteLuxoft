package com.vados.dao;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vados.DomainAwareBase;
import com.vados.config.WebAppConfig;
import com.vados.service.dao.PageDao;
import com.vados.web.model.Pages;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertNull;

@WebAppConfiguration
@ContextConfiguration(classes = WebAppConfig.class)
public class PagesDaoTest extends DomainAwareBase {

    @Autowired
    private PageDao pageDao;

    @Test
    public void addPage() {
        int size = pageDao.list().size();
        pageDao.add(simplePage());
        assertTrue(size < pageDao.list().size());
    }

    @Test
    public void testUpdate() {
        Pages p = simplePage();
        pageDao.add(p);
        int id = p.getId();

        p.setDescription("updated");
        pageDao.update(p);
        assertEquals("updated", pageDao.find(id).getDescription());
    }

    @Test
    public void findTest() {
        Pages p = simplePage();
        pageDao.add(p);
        assertEquals(p, pageDao.find(p.getId()));
    }

    @Test
    public void testList() {
        assertTrue(pageDao.list().isEmpty());

        List<Pages> pages = Arrays.asList(
                new Pages("in1", "in1", "d1", "c1"),
                new Pages("in2", "in2", "d2", "c2"),
                new Pages("in3", "in3", "d3", "c3")
        );

        for (Pages p : pages) {
            pageDao.add(p);
        }

        List<Pages> found = pageDao.list();
        assertEquals(3, found.size());

        for (Pages p : found) {
            assertTrue(pages.contains(p));
        }
        assertTrue(pages.containsAll(found));
    }

    @Test
    public void removeTest() {
        Pages p = simplePage();
        pageDao.add(p);
        int id = p.getId();
        pageDao.remove(p);

        assertNull(pageDao.find(id));
    }
    
    @Test
    public void findByUrlTest(){
        final String url = "myUrl";
        Pages p =simplePage();
        p.setUrl(url);
        pageDao.add(p);
        Pages found = pageDao.findByUrl(url);
        assertEquals(p,found);
    }

    private Pages simplePage() {
        Pages page = new Pages();

        page.setUrl("home");
        page.setView("home");
        page.setDescription("description page");
        page.setContent("page content");

        return page;

    }
}
