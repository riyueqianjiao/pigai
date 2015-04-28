package com.pigai.entity;

// default package
// Generated 2015-4-26 23:48:10 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Teacher generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="teacher",catalog="pigai")
public class Teacher  implements java.io.Serializable {


     private String teacherId;
     private String name;
     private String school;
     private String college;
     private String password;
     private String email;
     private String 
telephone;
     private Set<Course> courses = new HashSet<Course>(0);

    public Teacher() {
    }

	
    public Teacher(String name, String school, String college, String password) {
        this.name = name;
        this.school = school;
        this.college = college;
        this.password = password;
    }
    public Teacher(String name, String school, String college, String password, String email, String 
telephone, Set<Course> courses) {
       this.name = name;
       this.school = school;
       this.college = college;
       this.password = password;
       this.email = email;
       this.telephone = telephone;
       this.courses = courses;
    }
   
    @Id
    @GeneratedValue(strategy=IDENTITY)   
    @Column(name="teacherId", unique=true, nullable=false)
    public String getTeacherId() {
        return this.teacherId;
    }
    
    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    
    @Column(name="name", nullable=false)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="school", nullable=false)
    public String getSchool() {
        return this.school;
    }
    
    public void setSchool(String school) {
        this.school = school;
    }

    
    @Column(name="college", nullable=false)
    public String getCollege() {
        return this.college;
    }
    
    public void setCollege(String college) {
        this.college = college;
    }

    
    @Column(name="password", nullable=false)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="email")
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="telephone")
    public String gettelephone() {
        return this.telephone;
    }
    
    public void settelephone(String telephone) {
        this.telephone = telephone;
    }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="teacher")
    public Set<Course> getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }




}


