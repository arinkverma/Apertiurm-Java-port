/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.apertium.port;


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
	          "<Data Dir>    <\"translate text from English to Esperanto\">\n" +
	          "<\"translate text from English to Esperanto\">\n");
	      System.exit(-1);
	  }
	
    public static void main(String[] args) throws Exception {
    	String output = "";
    	if (args.length == 0){ showHelp(null);
    	
    	}else if(args.length == 1){
    		output = Port.get(args[0],"eo-en");
    	}else if(args.length ==2){
    		Port.setAddresss(args[0]);
    		output = Port.get(args[1],"eo-en");
    	}
        System.out.println(output);
    }
}
