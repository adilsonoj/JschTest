package com.aoj.jschTest;

import com.jcraft.jsch.JSchException;

public class Desenvolvimento extends SSH {
	private static String host = "localhost";
	private static String usuario = "marcelo";
	private static String senha = "oliveira";
	private static int port = 22;
	
	public Desenvolvimento() throws JSchException {
		super(host, usuario, senha, port);
		System.out.println("desenvolvimento");
	}

}
