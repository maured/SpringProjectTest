/*package com.test.server.jdbc;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.MessageDigest;

public class ConnectionCredentials{
	
	private String serverName = "";
	private String databaseName = "";
	private String userName = "";
	private Key passwordKey;
	private byte[] encryptedPassword;
	
	//Constructor
	
	public ConnectionCredentials(String serverName, String databaseName, String userName, String password)
	{
		this.serverName  = serverName;
		this.databaseName = databaseName;
		this.userName = userName;
		encryptedPassword = encrypt(password);
	}
	
	private byte[] encrypt(String password)
	{
		byte[] encrypted = {};
		try{
			MessageDigest digester = MessageDigest.getInstance("MD5");
			digester.update(String.valueOf(password).getBytes("UTF-8"));
			byte[] digest = digester.digest();
			passwordKey = new SecretKeySpec(digest, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, passwordKey);
			encrypted = cipher.doFinal(password.getBytes());
		} catch(Exception exc) {
			exc.printStackTrace();
		}
			return encrypted;
	}

	@Override
	public String toString() {
		return String.format(
				"serverName: %s | databaseName: %s | username: %s | password: HIDDEN",
				getServerName(),
				getDatabaseName(),
				getUsername()
		);
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public void setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String userName) {
		this.userName = userName;
	}

	public Key getPasswordKey() {
		return passwordKey;
	}

	public byte[] getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setPassword(String password) {
		encryptedPassword = encrypt(password);
	}
}

*/