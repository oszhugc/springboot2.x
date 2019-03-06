package com.oszhugc.pojo;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("dbrole")
public class DatabaseRole implements Serializable {

    private Long id;
    private String roleName;
    private String note;



}
