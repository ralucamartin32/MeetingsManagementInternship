package com.internship.meetingsmanagement.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meeting {

    private Integer id;
    private Date date;
    private String title;
    private String location;


}
