package br.com.produto.util;



import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.Provider;
import java.security.Security;
import java.util.Iterator;
import java.util.StringTokenizer;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

public class Criptografia {

	public Criptografia() {
	}

	public String encrypt(String s, String s1) {
		byte abyte1[];
		Key key = getKey(s1);
		try {
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			cipher.init(1, key);
			byte abyte0[] = s.getBytes();
			abyte1 = cipher.doFinal(abyte0);
			return getString(abyte1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String generateKey() {
		byte abyte0[];
		try {
			KeyGenerator keygenerator = KeyGenerator.getInstance("DESede");
			SecretKey secretkey = keygenerator.generateKey();
			abyte0 = secretkey.getEncoded();
			return getString(abyte0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public String decrypt(String cryptedText, String keyText) {
		byte abyte1[];
		try {
			Key key = getKey(keyText);
			Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
			byte abyte0[] = isEncrypted(cryptedText) ? getBytesDecript(cryptedText)
					: getBytesDecript(getString(hex2ByteArray(cryptedText)));
			cipher.init(2, key);
			abyte1 = cipher.doFinal(abyte0);
			return new String(abyte1);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	private Key getKey(String s) {
		SecretKey secretkey;
		try {
			byte abyte0[] = s.getBytes();
			DESedeKeySpec desedekeyspec = new DESedeKeySpec(abyte0);
			SecretKeyFactory secretkeyfactory = SecretKeyFactory
					.getInstance("DESede");
			secretkey = secretkeyfactory.generateSecret(desedekeyspec);
			return secretkey;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean isEncrypted(String s) {
		if (s.indexOf('-') == -1)
			return false;
		for (StringTokenizer stringtokenizer = new StringTokenizer(s, "-",
				false); stringtokenizer.hasMoreTokens();) {
			String s1 = stringtokenizer.nextToken();
			if (s1.length() > 3)
				return false;
			int i = 0;
			while (i < s1.length()) {
				if (!Character.isDigit(s1.charAt(i)))
					return false;
				i++;
			}
		}

		return true;
	}

	private String getString2(byte[] b) {

		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			sb.append(b[i]);

		return sb.toString();

	}

	private String getString(byte abyte0[]) {
		StringBuffer stringbuffer = new StringBuffer();
		for (int i = 0; i < abyte0.length; i++) {
			byte byte0 = abyte0[i];
			stringbuffer.append(0xff & byte0);
			if (i + 1 < abyte0.length)
				stringbuffer.append("-");
		}
		return stringbuffer.toString();
	}

	private byte[] getBytesDecript(String s) {
		ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
		int i;
		for (StringTokenizer stringtokenizer = new StringTokenizer(s, "-",
				false); stringtokenizer.hasMoreTokens(); bytearrayoutputstream
				.write((byte) i))
			i = Integer.parseInt(stringtokenizer.nextToken());

		return bytearrayoutputstream.toByteArray();
	}

	private byte[] getBytes(String s) {

		/*
		 * ByteArrayOutputStream bytearrayoutputstream = new
		 * ByteArrayOutputStream(); int i; for (StringTokenizer stringtokenizer =
		 * new StringTokenizer(s, "-", false); stringtokenizer.hasMoreTokens();
		 * bytearrayoutputstream .write((byte) i)) i =
		 * Integer.parseInt(stringtokenizer.nextToken());
		 * 
		 * return bytearrayoutputstream.toByteArray();
		 */

		return s.getBytes();
	}

	public static void main(String args[]) {
		final String key = "sP81h6rB1wr2qoieqwrl5zW3";

		String senha = "PVC";// hexa
		//String sss = "4100831535";
		Criptografia crip = new Criptografia();
		String senhaCriptografada = crip.encrypt(senha, key);
		String senhaDescriptografada = crip.decrypt(senhaCriptografada, key);
		
		System.out.println("Encripted Text............: " + senhaCriptografada);
		System.out.println("Decripted text (direto)...: " + crip.decrypt(senhaCriptografada, key));
		System.out.println("Decripted text (hexa).....: " + crip.decrypt(senhaCriptografada, key));

	}

	public void showProviders() {
		try {
			Provider aprovider[] = Security.getProviders();
			for (int i = 0; i < aprovider.length; i++) {
				System.out.println("Provider: " + aprovider[i].getName() + ", "
						+ aprovider[i].getInfo());
				String s;
				String s1;
				for (Iterator iterator = aprovider[i].keySet().iterator(); iterator
						.hasNext(); System.out.println("\t" + s + " = " + s1)) {
					s = (String) iterator.next();
					s1 = (String) aprovider[i].get(s);
				}

			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public byte[] hex2ByteArray(String key) {
		byte[] bts = new java.math.BigInteger(key, 16).toByteArray();
		byte[] r = new byte[bts.length - 1];
		System.arraycopy(bts, 1, r, 0, r.length);
		return r;
	}

	public String byteArray2Hex(byte[] bytes) {

		char[] HEX = "0123456789abcdef".toCharArray();

		char[] ret = new char[bytes.length * 2];
		for (int i = 0, j = 0; i < bytes.length; ++i) {
			ret[j++] = HEX[(bytes[i] >> 4) & 0x0F];
			ret[j++] = HEX[bytes[i] & 0x0F];
		}
		return String.valueOf(ret);
	}
}