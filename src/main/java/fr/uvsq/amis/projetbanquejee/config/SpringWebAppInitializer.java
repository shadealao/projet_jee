package fr.uvsq.amis.projetbanquejee.config;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import fr.uvsq.amis.projetbanquejee.controller.AppConfig;
 
public class SpringWebAppInitializer implements WebApplicationInitializer {
	public static AnnotationConfigApplicationContext appContext = null;
	@Override
    public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("ON START UP");
		/*this.appContext = new AnnotationConfigApplicationContext();
		appContext.scan("fr.uvsq.amis.projetbanquejee");
		
		appContext.refresh();/*
		
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(AppConfig.class);
        appContext.setServletContext(servletContext);
       /* 
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher",
                new DispatcherServlet(appContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");*/
        /* 
         * 
         * 
		var ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(WebConfig.class);
        ctx.setServletContext(servletContext);

        var servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
        */
        
	}
	 // Static Resource Config
	  
//	   public void addResourceHandlers(ResourceHandlerRegistry registry) {
//	    
//	       // Css resource.
//	       registry.addResourceHandler("/styles/**") //
//	                 .addResourceLocations("/WEB-INF/images/").setCachePeriod(31556926);
//	        
//	   }
}
