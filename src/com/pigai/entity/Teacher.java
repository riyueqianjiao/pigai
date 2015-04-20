package com.pigai.entity;
// default package
// Generated 2015-4-17 0:44:39 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Teacher generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name="t_teacher",catalog="pigai")
public class Teacher  implements java.io.Serializable {


     private Integer teacherId;
     private String name;
     private String school;
     private String college;
     private String password;
     private String email;
     private String telephone;
     private Set<Course> Courses = new HashSet<Course>(0);

    public Teacher() {
    }

	
    public Teacher(String name, String school, String college, String password) {
        this.name = name;
        this.school = school;
        this.college = college;
        this.password = password;
    }
    public Teacher(String name, String school, String college, String password, String email, String 
telephone, Set<Course> Courses) {
       this.name = name;
       this.school = school;
       this.college = college;
       this.password = password;
       this.email = email;
       this.telephone = telephone;
       this.Courses = Courses;
    }
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    @Column(name="teacherId", unique=true, nullable=false)
    public Integer geTeacherId() {
        return this.teacherId;
    }
    
    public void seTeacherId(Integer teacherId) {
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

    @OneToMany(fetch=FetchType.LAZY, mappedBy="Teacher")
    public Set<Course> getCourses() {
        return this.Courses;
    }
    
    public void setCourses(Set<Course> Courses) {
        this.Courses = Courses;
    }




}

