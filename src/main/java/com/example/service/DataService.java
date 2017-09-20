package com.example.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.models.*;
@Component
public class DataService {
	public  Data getdetails(){
		 String csvFile = "C:/Users/user/workspace/SpringProjects/demo/src/main/java/com/example/service/records.csv";

	     MultiValueMap<String,String> map = new MultiValueMap<String,String>();
	     MultiValueMap<String,String> map2 = new MultiValueMap<String,String>();
	     MultiValueMap<String,String> map3 = new MultiValueMap<String,String>();
	     MultiValueMap<String,String> map4 = new MultiValueMap<String,String>();


	    Data di = new Data();
		 try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
		      String line;
		      while ((line = br.readLine()) != null) {
		    	 
		        String[] parts = line.split(",");
		        if (parts[2].equals("County")) {
		        	map3.put(parts[3],parts[0]);
		        }
		        else if (parts[2].equals("Sub-County")) {
		        	
		        	map.put(parts[1],parts[3]);
		        	map4.put(parts[3],parts[0]);
		          		        } 
		         else if (parts[2].equals("Ward")) {
		        	map2.put(parts[1], parts[3]);
		        }
		      }
		    } catch (FileNotFoundException ex) {
		      ex.printStackTrace();
		    } catch (IOException ex) {
		      ex.printStackTrace();
		    }
		  di.setSubcounties(map);
          di.setWard(map2);
          di.setCounties(map3);
          di.setSubcountyid(map4);
		   
	      return di;
		  }


}
