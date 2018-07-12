package com.fjd.ssm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
//@Component
//@EnableWebMvc
//@EnableTransactionManagement

public class MultitenantConfiguration {

    @Autowired
    private DataSourceProperties properties;
    private static Map<String, DataSource> dataSourceMap = new HashMap<>();

    /**
     * Defines the data source for the application
     * @return
     */
//    @Bean
//    @ConfigurationProperties(
//            prefix = "spring.datasource"
//    )
    public DataSource getTenantDataSource(String tenantId){
        if (dataSourceMap.containsKey(tenantId)) {
            System.out.println("GetDataSource:" + tenantId);
            return dataSourceMap.get(tenantId);
        } else {
            System.out.println("GetDataSource:" + "Default");
            return dataSourceMap.get("Default");
        }
    }
    @Bean
    public MultitenantDataSource multitenantDataSource() {
//        File[] files = Paths.get("tenants").toFile().listFiles();
        Map<Object,Object> resolvedDataSources = new HashMap<>();
//
//        for(File propertyFile : files) {
//            Properties tenantProperties = new Properties();
//            DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//
//            try {
//                tenantProperties.load(new FileInputStream(propertyFile));
//
//                String tenantId = tenantProperties.getProperty("name");
//
//                // Assumption: The tenant database uses the same driver class
//                // as the default database that you configure.
//                dataSourceBuilder.driverClassName(properties.getDriverClassName())
//                        .url(tenantProperties.getProperty("datasource.url"))
//                        .username(tenantProperties.getProperty("datasource.username"))
//                        .password(tenantProperties.getProperty("datasource.password"));
//
//                if(properties.getType() != null) {
//                    dataSourceBuilder.type(properties.getType());
//                }
//
//                resolvedDataSources.put(tenantId, dataSourceBuilder.build());
//            } catch (IOException e) {
//                // Ooops, tenant could not be loaded. This is bad.
//                // Stop the application!
//                e.printStackTrace();
//                return null;
//            }


//        }
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create()
                .url("jdbc:mysql://localhost/test")
                .username("root")
                .password("123456");
        resolvedDataSources.put("tenant1",dataSourceBuilder.build());
        resolvedDataSources.put("Default",dataSourceBuilder.build());
        DataSourceBuilder dataSourceBuilder2 = DataSourceBuilder.create()
                .url("jdbc:mysql://localhost/test2")
                .username("root")
                .password("123456");
        resolvedDataSources.put("tenant2",dataSourceBuilder2.build());

        // Create the final multi-tenant source.
        // It needs a default database to connect to.
        // Make sure that the default database is actually an empty tenant database.
        // Don't use that for a regular tenant if you want things to be safe!
        MultitenantDataSource dataSource = new MultitenantDataSource();
        dataSource.setDefaultTargetDataSource(resolvedDataSources.get("Default"));
        dataSource.setTargetDataSources(resolvedDataSources);

        // Call this to finalize the initialization of the data source.
        dataSource.afterPropertiesSet();

        return dataSource;
    }

    /**
     * Creates the default data source for the application
     * @return
     */
//    @Bean
//    public DataSource defaultDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create()
//                .driverClassName("com.mysql.jdbc.Driver")
//                .url("jdbc:mysql://localhost/test")
//                .username("root")
//                .password("123456");
//        dataSourceMap.put("Default",dataSourceBuilder.build());
//        return dataSourceBuilder.build();
//    }
    @Bean
    public DataSourceTransactionManager transactionManager() {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(this.multitenantDataSource());
        return transactionManager;
    }
}