package com.example.info;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.map.MultiValueMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.Data;
import com.example.service.DataService;
import com.example.service.JsonResponse;
import com.google.gson.Gson;

@RestController
public class TestClass {
	@Autowired
	private DataService dt;
	MultiValueMap<String, String> counties = new MultiValueMap<String, String>();
	MultiValueMap<String, String> subcounties = new MultiValueMap<String, String>();
	MultiValueMap<String, String> wards = new MultiValueMap<String, String>();
	MultiValueMap<String, String> subcountyid = new MultiValueMap<String, String>();
	String county_id = "";
	JsonResponse jsonResponse = new JsonResponse();
    Gson gson = new Gson();

    JsonResponse.Data data = jsonResponse.new Data();
    String jsonString ="";
    
   
    @RequestMapping(value = "/county", method = RequestMethod.GET, produces = "application/json")
	public String getallinfo(@RequestParam("data") String countyname) {
    	System.out.println(countyname);
		Data d = new Data();
		d = dt.getdetails();
		counties = d.getCounties();
		subcounties = d.getSubcounties();
		wards = d.getWard();
		subcountyid = d.getSubcountyid();
		
		
	   ArrayList<String>countyid = (ArrayList<String>) counties.get(countyname);
		
		
		for(String a:countyid) {
			county_id = a;
		}
		
		
		
		//subcounties is a map
		// I am going to search the subcounties map by passing countyid and extract the values and 
		//put it in a list
		
       ArrayList<String>subcountynames = (ArrayList<String>) subcounties.get(county_id);
       //So now I have an arraylist called subcountynames
       
       //Now pass each subcounty names and extract keys and store those keys in
       //a list
       
       data.setResponse("success");
	    data.setCounty(countyname);
	    data.setSubcounty(subcountynames);
	    List<List<String>> parentList =new ArrayList();  //parentList
	    int i=0;
       for(String z:subcountynames) {
           ArrayList<String>cnames = (ArrayList<String>) subcountyid.get(z);
           
           for(String k:cnames) {
        	   ArrayList<String>ward = (ArrayList<String>) wards.get(k);
        	   
        	   parentList.add(i,ward);
         	  System.out.println("Wards under:"+k +"\t"+ward);
         	  i++;
           }
 		}  
  	  data.setWards(parentList);

       jsonResponse.setData(data);
       jsonString = gson.toJson(jsonResponse);
	   System.out.println(jsonString);
		return jsonString;
	}
	
}
