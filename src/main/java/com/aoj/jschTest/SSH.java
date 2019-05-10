package com.aoj.jschTest;

import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSH {
	private String host;
	private String usuario;
	private String senha;
	private int port;
	
	private Session session;
	
	public SSH(String host, String usuario, String senha, int port) throws JSchException {
		super();
		this.host = host;
		this.usuario = usuario;
		this.senha = senha;
		this.port = port;  
	}
	
	public Session sessionOpen() throws JSchException {
		JSch jsch = new JSch();
	    session = jsch.getSession(this.usuario, this.host, this.port);
	    Properties config = new Properties();
	    config.put("StrictHostKeyChecking", "no");
	    session.setConfig(config);;
	    session.setPassword(this.senha);
	    session.connect();  
	    return session;
	}
	
	

	
	
}
