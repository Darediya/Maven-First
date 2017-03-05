/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenfirst;

/**
 *
 * @author w200880842
 */
public class Demographics {
    private String name;
    private String city;
    private String country;

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
    
    
    @Override
    public String toString(){
       return  
            "name=" + name + ", city='" + city + '\'' +", country='" + country+ '\'' 
            ;
    }
   
}
    

