package yncrea.lab04.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import yncrea.lab04.core.config.AppConfig;
import yncrea.lab04.core.config.DBConfig;
import yncrea.lab04.web.config.WebConfig;

public class Initializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        Class[] configClasses = new Class[2];
        configClasses[0] = AppConfig.class;
        configClasses[1] = DBConfig.class;
        return configClasses;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] servletConfigClasses = new Class[1];
        servletConfigClasses[0] = WebConfig.class;
        return servletConfigClasses;
    }

    @Override
    protected String[] getServletMappings() {
        String[] servletMappings = new String[1];
        servletMappings[0] = "/";
        return servletMappings;
    }
}
