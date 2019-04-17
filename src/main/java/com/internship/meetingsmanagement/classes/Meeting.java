package com.internship.meetingsmanagement.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Meeting {

    private Long id;
    private LocalDateTime date;
    private String title;
    private String location;


}
