package org.sang.hanzy.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
//jpa多源数据库配置
//@Configuration
//public class DataSourceConfig {
//    @Bean
//    @ConfigurationProperties("spring.datasource.one")
//    @Primary
//    DataSource dsOne(){
//        return DruidDataSourceBuilder.create().build();
//    }
//    @Bean
//    @ConfigurationProperties("spring.datasource.two")
//    DataSource dsTwo(){
//        return DruidDataSourceBuilder.create().build();
//    }
//}
