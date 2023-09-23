package com.lm2a.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties
@RefreshScope
public class DBConfig {

	@Value("${application.name}")
	private String applicationName;
	
	@Value("${activar.funcionalidad}")
	private boolean activateFunctionality;
	

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public boolean isActivateFunctionality() {
		return activateFunctionality;
	}

	public void setActivateFunctionality(boolean activateFunctionality) {
		this.activateFunctionality = activateFunctionality;
	}

}
