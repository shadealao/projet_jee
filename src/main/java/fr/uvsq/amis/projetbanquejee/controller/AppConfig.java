package fr.uvsq.amis.projetbanquejee.controller;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
//@EnableJpaRepositories(basePackages = {"fr.uvsq.amis.projetbanquejee.repositoryAdresse","fr.uvsq.amis.projetbanquejee.repositoryClient", "fr.uvsq.amis.projetbanquejee.repositoryCompte", "fr.uvsq.amis.projetbanquejee.entity", "fr.uvsq.amis.projetbanquejee.controller"})

@Configuration   // correspond au fichier xlm de spring
<<<<<<< HEAD
@EnableJpaRepositories(basePackages = {"fr.uvsq.amis.projetbanquejee.repositoryadresse", "fr.uvsq.amis.projetbanquejee.repositoryCompte","fr.uvsq.amis.projetbanquejee.repositoryClient", "fr.uvsq.amis.projetbanquejee.entity", "fr.uvsq.amis.projetbanquejee.controller"})
=======
@EnableJpaRepositories(basePackages = {"fr.uvsq.amis.projetbanquejee"})
>>>>>>> 52a701420b0d4f39e8486170e454b2a487674c2e
public class AppConfig {
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("persist");
		return factoryBean;
	}
	
	@Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }
}
