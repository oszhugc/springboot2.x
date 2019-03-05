package com.oszhugc.mq.pojo;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String userName;
    private String note;


}
