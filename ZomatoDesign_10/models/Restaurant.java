package LLD.ZomatoDesign_10.models;

import java.awt.MenuItem;
import java.util.ArrayList;
import java.util.List;


public class Restaurant {

    private static int nextRestuarntId = 0;
    private int id;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant(String name, String location) {
        this.id = ++nextRestuarntId;
        this.name = name;
        this.location = location;

    }

    //getters and setters
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getLocation(){
        return this.location;
    }

    public void setLocation(String location){
        this.location = location;
    }

    public void addMenu(MenuItem item){
        menu.add(item);
    }

    public List<MenuItem> getMenu(){
        return this.menu;   
    }
}
