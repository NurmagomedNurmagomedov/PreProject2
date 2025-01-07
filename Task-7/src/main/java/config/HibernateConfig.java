package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.sql.DataSource;
import java.util.Map;

@Configuration
@PropertySource("classpath:hibernate.properties")
public class HibernateConfig {

    private final Environment env;

    public HibernateConfig(Environment env) {
        this.env = env;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("hibernate.driver_class"));
        dataSource.setUrl(env.getProperty("hibernate.connection.url"));
        dataSource.setUsername(env.getProperty("hibernate.connection.username"));
        dataSource.setPassword(env.getProperty("hibernate.connection.password"));
        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.example.model"); // Укажите пакеты с вашими сущностями
        factoryBean.setJpaPropertyMap(Map.of(
                "hibernate.dialect", env.getProperty("hibernate.dialect"),
                "hibernate.show_sql", env.getProperty("hibernate.show_sql"),
                "hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"),
                "hibernate.current_session_context_class", env.getProperty("hibernate.current_session_context_class")));
        return factoryBean;
    }
}
