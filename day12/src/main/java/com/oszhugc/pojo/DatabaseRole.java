package com.oszhugc.pojo;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Alias("dbrole")
@Getter
@Setter
@AllArgsConstructor
public class DatabaseRole implements Serializable {

    private Long id;
    private String roleName;
    private String note;



}
