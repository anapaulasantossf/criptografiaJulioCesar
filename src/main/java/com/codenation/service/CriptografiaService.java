package com.codenation.service;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codenation.data.DadosCriptografia;

@Service
public class CriptografiaService {

	public DadosCriptografia decriptar(DadosCriptografia dadosCriptografia) throws Exception {

		DadosCriptografia dados = new DadosCriptografia();

		// Variavel que ira guardar o texto decifrado
		String texto = new String();

		String textoCifrado = dadosCriptografia.getCifrado();

		// Variavel com tamanho do texto a ser decriptado
		int tamanhoTexto = dadosCriptografia.getCifrado().length();
		int chave = dadosCriptografia.getNumero_casas();

		// Descriptografa cada caracter por vez
		for (int c = 0; c < tamanhoTexto; c++) {
			// Transforma o caracter em codigo ASCII e faz a descriptografia
			int letraDecifradaASCII = ((int) textoCifrado.charAt(c)) - chave;
			
			if(c != 35) {
				// Verifica se o codigo ASCII esta no limite dos caracteres imprimiveis
				while (letraDecifradaASCII < 32) {
					letraDecifradaASCII += 94;
				}

				// Transforma codigo ASCII descriptografado em caracter ao novo texto
				texto += ((char) letraDecifradaASCII);
			} else {
				texto += ".";
			}
			
			System.out.println(texto);
		}
		dados.setNumero_casas(dadosCriptografia.getNumero_casas());
		dados.setCifrado(dadosCriptografia.getCifrado());
		dados.setToken(dadosCriptografia.getToken());
		dados.setDecifrado(texto.replace("}", " "));

		String input = dados.getDecifrado();

		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		dados.setResumo_criptografico(sb.toString().toLowerCase());
		
		System.out.println(dados.getResumo_criptografico());

		return dados;
	}
	
	public void saveUploadedFile(MultipartFile file) throws IOException {
	    if (!file.isEmpty()) {
	        byte[] bytes = file.getBytes();
	        Path path = Paths.get(file.getOriginalFilename());
	        Files.write(path, bytes);
	    }
	}
	

}
