/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.port;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;

import org.apertium.pipeline.ApertiumMain;


/**
 *
 * @author Arink Verma
 */
public class Run {
	
	static void showHelp(String invocationCommand) {
	    String bareCommand = "";
	    if (invocationCommand == null) {
	      String jar = System.getProperty("java.class.path");
	      if (jar.contains(":") || !jar.endsWith("ApertiumPort.jar")) jar = "ApertiumPort.jar";
	      bareCommand = "java -jar " +jar;
	      invocationCommand = bareCommand +" [task]";
	    }

	      System.err.println("ApertiumPort: A java port translator for English <-> Esperanto\n" +
	          "USAGE: "+invocationCommand+"\n" +
	          "Examples:\n" +
	          "<Path of input file>" +
	          "<\"translate text from English to Esperanto\">\n");
	      System.exit(-1);
	  }
	
	private static String readFile( String file ) throws IOException {
	    BufferedReader reader = new BufferedReader( new FileReader (file));
	    String line  = null;
	    StringBuilder stringBuilder = new StringBuilder();
	    String ls = System.getProperty("line.separator");
	    while( ( line = reader.readLine() ) != null ) {
	        stringBuilder.append( line );
	        stringBuilder.append( ls );
	    }
	    return stringBuilder.toString();
	 }
	
    public static void main(String[] args) {
    	String output = "";
    	String f = "";
    	if (args.length == 0){ showHelp(null);
    	
    	}else if(args.length == 1){
    		f = args[0];
    	}else if(args.length ==2){
    		Port.setAddresss(args[0]);
    		f = args[1];   		
    	}
    	
    	String input;
		try {
			input = readFile(f);
			output = Port.get(input,"eo-en");
	        System.out.println(output);
		} catch (IOException e) {
			System.out.println("Invalid input path");
			showHelp(null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    		

    }
}
