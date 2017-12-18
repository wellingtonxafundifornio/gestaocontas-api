package com.example.gestaocursosapi.config.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("gestaocursos")
public class GestaoCursosApiProperty {

	private String origemPermitida = "http://localhost:4200";
	
	private final Seguranca seguranca = new Seguranca();
	
	
	public String getOrigemPermitida() {
		return origemPermitida;
	}


	public void setOrigemPermitida(final String origemPermitida) {
		this.origemPermitida = origemPermitida;
	}


	public Seguranca getSeguranca() {
		return seguranca;
	}


	public static class Seguranca{
		
		private boolean enableHttps;

		public boolean isEnableHttps() {
			return enableHttps;
		}

		public void setEnableHttps(final boolean enableHttps) {
			this.enableHttps = enableHttps;
		}
		
		
	}
}
