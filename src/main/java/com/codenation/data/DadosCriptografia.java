package com.codenation.data;

public class DadosCriptografia {
	
	private int 	numero_casas;
	private String 	token;
	private String 	cifrado;
	private String 	decifrado;
	private String 	resumo_criptografico;
	
	
	public DadosCriptografia() {
		
	}

	public DadosCriptografia(int numero_casas, String token, String cifrado, String decifrado, String resumo_criptografico) {
		this.numero_casas = numero_casas;
		this.token = token;
		this.cifrado = cifrado;
		this.decifrado = decifrado;
		this.resumo_criptografico = resumo_criptografico;
	}

	public int getNumero_casas() {
		return numero_casas;
	}

	public void setNumero_casas(int numero_casas) {
		this.numero_casas = numero_casas;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getCifrado() {
		return cifrado;
	}

	public void setCifrado(String cifrado) {
		this.cifrado = cifrado;
	}

	public String getDecifrado() {
		return decifrado;
	}

	public void setDecifrado(String decifrado) {
		this.decifrado = decifrado;
	}

	public String getResumo_criptografico() {
		return resumo_criptografico;
	}

	public void setResumo_criptografico(String resumo_criptografico) {
		this.resumo_criptografico = resumo_criptografico;
	}
	
}
