package com.aoj.jschTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class Comando {
	private String comando;
	private Session session;
	
	public Comando(String comando, Session session) {
		super();
		this.comando = comando;
		this.session = session;
	}
	
	public List<String> executa() throws JSchException, IOException {
		List<String> lista = new ArrayList<>();
		Channel channel = session.openChannel("exec");
        ((ChannelExec)channel).setCommand(this.comando);
        channel.setInputStream(null);
        ((ChannelExec)channel).setErrStream(System.err);
         
        InputStream input = channel.getInputStream();
        channel.connect();
         
        System.out.println("Canal conectado com o servidor:  comando: " + this.comando );
        
        try{
            InputStreamReader inputReader = new InputStreamReader(input);
            BufferedReader bufferedReader = new BufferedReader(inputReader);
            String line = null;
             
            while((line = bufferedReader.readLine()) != null){
                lista.add(line);
            }
            bufferedReader.close();
            inputReader.close();
        }catch(IOException ex){
        	
            ex.printStackTrace();
        }
        
        return lista;
	}
	
	
	
	
}
