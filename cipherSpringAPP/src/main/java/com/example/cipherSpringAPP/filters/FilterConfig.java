package com.example.cipherSpringAPP.filters;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<AccessFilterUser> authorizationFilterRegistration() {
        FilterRegistrationBean<AccessFilterUser> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AccessFilterUser());
        registrationBean.addUrlPatterns("/cipher,cipher-list,userTable");
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean<AllCiphersFilterAdmin> cypherLogForAdminFilterRegistration() {
        FilterRegistrationBean<AllCiphersFilterAdmin> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new AllCiphersFilterAdmin());
        registrationBean.addUrlPatterns("/showAllCiphers");
        registrationBean.setOrder(Ordered.LOWEST_PRECEDENCE);
        return registrationBean;
    }
}
