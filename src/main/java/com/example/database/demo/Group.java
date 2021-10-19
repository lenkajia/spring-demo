package com.example.database.demo;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import org.springframework.stereotype.Component;

@Data
@Entity
public class Group {
    @Id
    @Column(name = "group_id")
    private String groupId;

    @Column(name = "user")
    private String user;

    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @OneToMany
    @JoinColumn(name = "user")
    private List<User> users;

}
