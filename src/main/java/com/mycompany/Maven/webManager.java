/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenfirst;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author w200880842
 */
public class webManager {
    
    public static String fetchData(){
    StringBuilder sb = new StringBuilder();
    try{
               
               URL url = new URL("http://www.w3schools.com/angular/customers.php");
               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("GET");
               conn.setRequestProperty("Accept", "application/json");
               
              
               if(conn.getResponseCode() !=200){
                   throw new RuntimeException("Failed : HTTP error code : "
                           + conn.getResponseCode());
               }
               
               BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
               
               String output;
               
               System.out.println("Output from server ...\n");
              
               
               while((output=br.readLine())!=null) {
                   System.out.println(output);
                   sb.append(output);
                   JOptionPane.showMessageDialog(null, output);
               }
               conn.disconnect();
           }
               catch(Exception e){
                   e.printStackTrace();
                       } 
        return sb.toString();
    }
    
    public void jsonToJavaObject(){
             Gson gson = new GsonBuilder().create();
             String jsonData = "{name:\"Tom\",city:\"Houston\",country:\"USA\"}";
            Demographics p = gson.fromJson(jsonData, Demographics.class);
            JOptionPane.showMessageDialog(null, p);
            System.out.println(p.getName());
    }

    
    public void gsontoJsonArray(){    
         String str = "[{\"name\":\"Tom\",\"city\":\"Houston\",\"country\":\"USA\"},\n"
                 + "{\"name\":\"Ady\",\"city\":\"Melbourne\",\"country\":\"Australia\"}]";       
            JsonElement json = new JsonParser().parse(str);
            JsonArray array=json.getAsJsonArray();
            Iterator iterator = array.iterator();
            List<Demographics> p  = new ArrayList<>();
            while(iterator.hasNext())
            {
            JsonObject json2 = (JsonObject)iterator.next();
            Gson gson = new Gson();
            Demographics v = gson.fromJson(json2, Demographics.class);
            p.add(v);
            }
            JOptionPane.showMessageDialog(null, p);
            System.out.println(p);      
    }   
    
    
public static void main(String[] args){
    webManager wm = new webManager(); 
    wm.jsonToJavaObject();
    wm.gsontoJsonArray();
      
}

}

