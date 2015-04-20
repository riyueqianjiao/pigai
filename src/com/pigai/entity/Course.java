package com.pigai.entity;
// default package
// Generated 2015-4-17 0:44:39 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Course generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_course", catalog = "pigai")
public class Course implements java.io.Serializable {

	private Integer courseId;
	private Teacher Teacher;
	private String couserName;
	private String courseIntr;
	private Set<Homework> Homeworks = new HashSet<Homework>(0);
	private Set<Courseware> Coursewares = new HashSet<Courseware>(0);
	private Set<Selectcourse> Selectcourses = new HashSet<Selectcourse>(0);

	public Course() {
	}

	public Course(Teacher Teacher, String couserName, String courseIntr) {
		this.Teacher = Teacher;
		this.couserName = couserName;
		this.courseIntr = courseIntr;
	}

	public Course(Teacher Teacher, String couserName, String courseIntr,
			Set<Homework> Homeworks, Set<Courseware> Coursewares,
			Set<Selectcourse> Selectcourses) {
		this.Teacher = Teacher;
		this.couserName = couserName;
		this.courseIntr = courseIntr;
		this.Homeworks = Homeworks;
		this.Coursewares = Coursewares;
		this.Selectcourses = Selectcourses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "courseId", unique = true, nullable = false)
	public Integer getCourseId() {
		return this.courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "teacherId", nullable = false)
	public Teacher getTeacher() {
		return this.Teacher;
	}

	public void setTeacher(Teacher Teacher) {
		this.Teacher = Teacher;
	}

	@Column(name = "couserName", nullable = false)
	public String getCouserName() {
		return this.couserName;
	}

	public void setCouserName(String couserName) {
		this.couserName = couserName;
	}

	@Column(name = "courseIntr", nullable = false)
	public String getCourseIntr() {
		return this.courseIntr;
	}

	public void setCourseIntr(String courseIntr) {
		this.courseIntr = courseIntr;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Course")
	public Set<Homework> getHomeworks() {
		return this.Homeworks;
	}

	public void setHomeworks(Set<Homework> Homeworks) {
		this.Homeworks = Homeworks;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Course")
	public Set<Courseware> getCoursewares() {
		return this.Coursewares;
	}

	public void setCoursewares(Set<Courseware> Coursewares) {
		this.Coursewares = Coursewares;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Course")
	public Set<Selectcourse> getSelectcourses() {
		return this.Selectcourses;
	}

	public void setSelectcourses(Set<Selectcourse> TSelectcourses) {
		this.Selectcourses = TSelectcourses;
	}

}
