package com.dwarsh.mashapplication;

import android.widget.ImageView;

public class Games {
    String name,desc,points;
    int img;
    public Games() {}
    public Games(String name,String desc,String points,int imageView)
    {
        this.name = name;
        this.desc = desc;
        this.points = points;
        this.img = imageView;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }

    public String getPoints() {
        return points;
    }
}
