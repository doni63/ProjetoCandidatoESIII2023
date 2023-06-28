
package RNF;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import dominio.Candidato;
import dominio.Cidade;
import dominio.Criptografia;
import dominio.Curso;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Estado;
import dominio.Filiacao;
import dominio.Telefone;

public class CriptografarEntidade extends EntidadeDominio{

	private String chaveCriptografia = "";

	public String gerarChaveCriptografia(EntidadeDominio entidade) throws NoSuchAlgorithmException {
		Candidato candidato = (Candidato) entidade;
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(candidato.getNome().getBytes(StandardCharsets.UTF_8));
		this.chaveCriptografia = bytesToHex(hash);
		candidato.getCrip().setChave(this.chaveCriptografia);
		System.out.println(this.chaveCriptografia);
		return this.chaveCriptografia;
	}

	public String getChave() {
		return this.chaveCriptografia;
	}
	
	private String bytesToHex(byte[] bytes) {
		StringBuilder result = new StringBuilder();
		for (byte b : bytes) {
			result.append(String.format("%02x", b));
		}
		return result.toString();
	}

	public void criptografarObjeto(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception {
		Candidato candidato = (Candidato) entidade;
		if (chaveCriptografia.isEmpty()) {
			gerarChaveCriptografia(candidato);
		}

		Field[] fields = candidato.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true); // Torna o campo acessível, mesmo se for privado
			Object campoCripto, campoCriptoList;
			String tempCripto;

			campoCripto = field.get(candidato);

			
			if ((campoCripto instanceof Filiacao) || (campoCripto instanceof Telefone)) {

				Field[] fieldsLista = campoCripto.getClass().getDeclaredFields();
				for (Field fieldlist : fieldsLista) {
					fieldlist.setAccessible(true); // Torna o campo acessível, mesmo se for privado
					try {
						campoCriptoList = fieldlist.get(campoCripto);
						
						
						if ((campoCriptoList!=null) && !validarCampoNumerico(campoCriptoList.toString())) {
							tempCripto = criptografar(campoCriptoList.toString(), chaveCriptografia);
							fieldlist.set(campoCripto, tempCripto);
						}
					} catch (IllegalAccessException e) {
						campoCripto = null;
					}

				}

			} else if ((campoCripto instanceof Endereco)) {
				Object tempCampos = campoCripto.getClass().getDeclaredFields();
				Field[] fieldsLista = campoCripto.getClass().getDeclaredFields();

				for (Field fieldlist : fieldsLista) {
					fieldlist.setAccessible(true); // Torna o campo acessível, mesmo se for privado
					try {
						campoCriptoList = fieldlist.get(campoCripto);

						if ((campoCriptoList!=null) && !validarCampoNumerico(campoCriptoList.toString()) && !(campoCriptoList instanceof Cidade)
								&& !(campoCriptoList instanceof Estado)) {
							tempCripto = criptografar(campoCriptoList.toString(), chaveCriptografia);
							fieldlist.set(campoCripto, tempCripto);
						}
					} catch (IllegalAccessException e) {
						campoCripto = null;
					}
				}

			} else {
				if (!(campoCripto instanceof ArrayList) &&  !(campoCripto instanceof Criptografia)){
					try {

						if (((campoCripto!=null) && !validarCampoNumerico(campoCripto.toString()) && !(campoCripto instanceof Date))) {
							tempCripto = criptografar(campoCripto.toString(), chaveCriptografia);
							field.set(candidato, tempCripto);
						}
					} catch (IllegalAccessException e) {
						campoCripto = null;
					}					
				}


			}

		}

	}

	public void desCriptografarObjeto(EntidadeDominio entidade) throws NoSuchAlgorithmException, Exception {
		Candidato candidato = (Candidato) entidade;

		chaveCriptografia = candidato.getCrip().getChave();
		System.out.println(candidato.getCrip().getChave());
		System.out.println(candidato.getId());
		System.out.println("descriptografando");
		Field[] fields = candidato.getClass().getDeclaredFields();
		for (Field field : fields) {
			field.setAccessible(true); // Torna o campo acessível, mesmo se for privado
			Object campoCripto, campoCriptoList;
			String tempCripto;

			campoCripto = field.get(candidato);

			
			if ((campoCripto instanceof Filiacao) || (campoCripto instanceof Telefone)) {

				Field[] fieldsLista = campoCripto.getClass().getDeclaredFields();
				for (Field fieldlist : fieldsLista) {
					fieldlist.setAccessible(true); // Torna o campo acessível, mesmo se for privado
					try {
						campoCriptoList = fieldlist.get(campoCripto);
						
						
						if ((campoCriptoList!=null) && !validarCampoNumerico(campoCriptoList.toString())) {
							tempCripto = descriptografar(campoCriptoList.toString(), chaveCriptografia);
							fieldlist.set(campoCripto, tempCripto);
						}
					} catch (IllegalAccessException e) {
						campoCripto = null;
					}

				}

			} else if ((campoCripto instanceof Endereco)) {
				Object tempCampos = campoCripto.getClass().getDeclaredFields();
				Field[] fieldsLista = campoCripto.getClass().getDeclaredFields();

				for (Field fieldlist : fieldsLista) {
					fieldlist.setAccessible(true); // Torna o campo acessível, mesmo se for privado
					try {
						campoCriptoList = fieldlist.get(campoCripto);

						if ((campoCriptoList!=null) && !validarCampoNumerico(campoCriptoList.toString()) && !(campoCriptoList instanceof Cidade)
								&& !(campoCriptoList instanceof Estado)) {
							tempCripto = descriptografar(campoCriptoList.toString(), chaveCriptografia);
							fieldlist.set(campoCripto, tempCripto);
						}
					} catch (IllegalAccessException e) {
						campoCripto = null;
					}
				}

			} else {
				if (!(campoCripto instanceof ArrayList) && !(campoCripto==null) && !(campoCripto instanceof Criptografia)){
					try {

						if (((campoCripto!=null) && !validarCampoNumerico(campoCripto.toString()) && !(campoCripto instanceof Date))) {
							tempCripto = descriptografar(campoCripto.toString(), chaveCriptografia);
							field.set(candidato, tempCripto);
						}
					} catch (IllegalAccessException e) {
						campoCripto = null;
					}					
				}


			}

		}
	}

	private String criptografar(String texto, String chave) throws Exception {
		byte[] chaveBytes = ajustarTamanhoChave(chave);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec secretKey = new SecretKeySpec(chaveBytes, "AES");
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedBytes = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
		return Base64.getEncoder().encodeToString(encryptedBytes);
	}

	private String descriptografar(String textoCriptografado, String chave) throws Exception {
		byte[] chaveBytes = ajustarTamanhoChave(chave);
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		SecretKeySpec secretKey = new SecretKeySpec(chaveBytes, "AES");
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(textoCriptografado));
		return new String(decryptedBytes, StandardCharsets.UTF_8);
	}

	private byte[] ajustarTamanhoChave(String chave) {
		// Ajustar a chave para 32 bytes (256 bits)
		byte[] chaveBytes = new byte[32];
		byte[] chaveOriginalBytes = chave.getBytes(StandardCharsets.UTF_8);
		int tamanhoChave = Math.min(chaveOriginalBytes.length, chaveBytes.length);
		System.arraycopy(chaveOriginalBytes, 0, chaveBytes, 0, tamanhoChave);
		return chaveBytes;
	}

	public boolean validarCampoNumerico(String texto) {
		try {
			Integer.parseInt(texto);
			return true; // O valor é um número inteiro válido
		} catch (NumberFormatException e) {

			return false;

		}
	}
}
