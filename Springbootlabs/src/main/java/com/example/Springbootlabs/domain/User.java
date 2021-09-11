package com.example.Springbootlabs.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
    public User(long id, String firstName, String lastName, List<Post> postList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.postList = postList;
    }

    @Id
    private long id;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    @Column(name="First_Name")
    private String firstName;

    @Column(name="Last_Name")
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name="User_Post")
    @Fetch(FetchMode.JOIN)
    private List<Post> postList;

}
