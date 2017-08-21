package com.spring.boot.rest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.spring.boot.rest.controller"})
public class SpringBootStarter {
	/*public void book (Details details){
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		try{
			fout = new FileOutputStream("C:\address.str");
			oos = new ObjectOutputStream(fout);
			oos.writeObject(details);
			System.out.println("Done");
					
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			 
			
		}
	}
	public void serializeDetails(Details details)
	{
		try{fout = new FileOutputStream("C:\address.str");
		oos = new ObjectOutputStream(fout);
		oos.writeObject(details);
		System.out.println("Done");
				
	}catch(Exception ex){
		ex.printStackTrace();*/
	public static void main(String[] args){
		SpringApplication.run(SpringBootStarter.class, args);
		
		//obj.serializeDetails(details);
	}
}
