package com.hcon.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.n3r.diamond.client.Miner;
import org.n3r.diamond.client.Minerable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by kunlun on 2017/3/28.
 */
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {

    private static Logger logger = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    public DataSource writeDataSource(){
        Minerable config = new Miner().getMiner("hcon.base", "datasource");
        String url = config.getString("url");
        String driverClass = config.getString("driver-class");
        String user = config.getString("userName");
        String password = config.getString("password");
        int initSize = config.getInt("initialSize");
        int minIdle = config.getInt("minIdle");
        int maxWait = config.getInt("maxWait");
        int maxActive = config.getInt("maxActive");
        logger.info("注入Druid连接池...");
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driverClass);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setMaxActive(maxActive);
        dataSource.setMinIdle(minIdle);
        return dataSource;
    }
}
