package com.pigai.entity;

// default package
// Generated 2015-4-26 23:48:10 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Selectcourse generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "selectcourse", catalog = "pigai")
public class Selectcourse implements java.io.Serializable {

	private Integer selectId;
	private Course course;
	private Student student;
	private int grade;

	public Selectcourse() {
	}

	public Selectcourse(Course course, Student student, int grade) {
		this.course = course;
		this.student = student;
		this.grade = grade;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "selectId", unique = true, nullable = false)
	public Integer getSelectId() {
		return this.selectId;
	}

	public void setSelectId(Integer selectId) {
		this.selectId = selectId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "courseId", nullable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", nullable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "grade", nullable = false)
	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
