package config;

import Interceptor.IdInterceptor;
import exception.SkillException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import service.MessageService;

@Configuration
public class webConfiguration extends WebMvcConfigurerAdapter {
    @Autowired
    private MessageConfig messageConfig;
    private IdInterceptor idInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(messageConfig.localeChangeInterceptor());
        registry.addInterceptor(idInterceptor);
    }
}
