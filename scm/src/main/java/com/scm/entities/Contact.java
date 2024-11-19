package com.scm.entities;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Contact {
    @Id
private String id;
private String name;
private String email;
private String phonenumber;
private String address;
// @Column(length=1000)
private String description;
private String picture;
private Boolean favourite=false;
private String weblinks;
private String linkedinlink;



// private List<String> sociallinks=new ArrayList<>();
 
@ManyToOne
private User user;



@OneToMany(mappedBy="contact",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval=true)
private List<SocialLink> links= new ArrayList<>();

}
