package edu.eci.cvds.patterns;

/**
 * Hello world!
 *
 */
public class App 
{
	 
    public static void main( String[] args )
    {
    	String cadena=new String();
    	for (int i=0;i<args.length;i++)
    	{
    		cadena=cadena+" "+args[i];
    	}
    	
        System.out.println("Hello"+ cadena+"!" );
    }
}
