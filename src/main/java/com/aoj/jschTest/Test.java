package com.aoj.jschTest;

import java.io.IOException;
import java.util.List;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Test {

	public static void main(String[] args) throws IOException {
		String command = "ls -la";
		String comando2 = "curl -u admin:admin http://localhost:8080/manager/text/list";
		
		try {
			Session session = new SSH("localhost", "marcelo", "oliveira", 22).sessionOpen();
			List<String> respostas = new Comando(command, session).executa();
			List<String> respostas2 = new Comando(comando2, session).executa();
			
			Session desenv = new Desenvolvimento().sessionOpen();
			List<String> respostasDesenv = new Comando(comando2, desenv).executa();
			
			
			respostas.forEach(System.out::println);
			respostas2.forEach(System.out::println);
			respostasDesenv.forEach(System.out::println);
		} catch (JSchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
