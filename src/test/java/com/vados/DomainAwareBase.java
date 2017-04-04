package com.vados;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;

import com.vados.config.WebAppConfig;

@WebAppConfiguration
@ContextConfiguration(classes = WebAppConfig.class)
public abstract class DomainAwareBase extends AbstractJUnit4SpringContextTests {

    private final String deleteScript = "src/main/resources/sql/cleanup.sql";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Before
    public void deleteAlldomainEntities() {
        try {
            ScriptUtils.executeSqlScript(jdbcTemplate.getDataSource().getConnection(), new FileSystemResource(deleteScript));
        } catch (SQLException ex) {
            Logger.getLogger(DomainAwareBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
