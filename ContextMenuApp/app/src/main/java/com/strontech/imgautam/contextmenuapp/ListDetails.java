package com.strontech.imgautam.contextmenuapp;

/**
 * Created by imgautam on 31/1/18.
 */

public class ListDetails {
    public Integer img[];
    public String name[];
    public String desc[];
    public String time[];

    ListDetails(Integer img[], String name[], String desc[], String time[])
    {
        this.img=img;
        this.name=name;
        this.desc=desc;
        this.time=time;
    }
}
