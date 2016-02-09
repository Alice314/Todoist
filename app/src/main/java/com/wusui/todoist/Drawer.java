package com.wusui.todoist;

/**
 * Created by fg on 2016/2/9.
 */
public class Drawer  {
    private String name;
    private int imageId;
    public Drawer(){ }
    public Drawer(String name ,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public int getImageId(){return imageId;}
    public void setImageId(int imageId){this.imageId = imageId;}
}
