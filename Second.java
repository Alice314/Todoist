package com.wusui.todoist;

/**
 * Created by fg on 2016/2/19.
 */
public class Second {
    private String name;
    private int imageId;

    public Second(){}
    public Second(String name,int imageId){
        this.name = name;
        this.imageId = imageId;
    }
    public String getName(){return name;}
    public void setName(){this.name = name;}

    public int getImageId(){return imageId;}
    public void setImageId(){this.imageId = imageId;}
}
