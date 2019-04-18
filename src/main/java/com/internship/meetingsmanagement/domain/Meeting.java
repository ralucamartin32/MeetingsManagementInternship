package com.internship.meetingsmanagement.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
