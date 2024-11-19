package com.scm.entities;

import java.util.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// import org.apache.catalina.authenticator.jaspic.PersistentProviderRegistrations.Providers;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="user")
@Table(name="users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User implements UserDetails{
@Id
private String userId;
@Column(name="user_name",nullable=false)
private String name;
@Column(unique=true,nullable=false)
private String email;
private String password;
@Column(length=1000)
private String about;
@Column(length=1000)
private String Profilepic;
private String phonenumber;

// //information
private boolean enabled=true;
private boolean emailverified=false;
private boolean phoneverified=false;
// self,google,facebook,github,linkedin
@Enumerated(value=EnumType.STRING)
private providers Provider=providers.SELF;
private String provideruserid;

@OneToMany(mappedBy="user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval=true)
private List<Contact> contacts=new ArrayList<>();

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAuthorities'");
}
//for this project:
//email id hai wahi hmara username
 
@Override
public String getUsername() {
   return this.email;
}
@Override
public boolean isAccountNonExpired(){
    return true;
}
@Override
public boolean isAccountNonLocked(){
    return true;
}
}
