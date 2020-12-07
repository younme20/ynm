package kr.ko.ym.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DatabaseConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Value("${database.mysql.classname}")
    private String classname;

    @Value("${database.mysql.url}")
    private String url;

    @Value("${database.mysql.username}")
    private String username;

    @Value("${database.mysql.password}")
    private String password;


    @Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setDriverClassName(classname);
        // 자바 설정으로 쓸 때에는 url에 &을 &amp; 로 치환하면 에러남
        source.setUrl(url);
        source.setUsername(username);
        source.setPassword(password);

        return source;
    }

    @Bean
    public SqlSessionFactory sqlSession() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setConfigLocation(applicationContext.getResource("classpath:config/context-mybatis.xml"));
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources("classpath*:*mapper*/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSession = new SqlSessionTemplate(sqlSession());
        return sqlSession;
    }


}
