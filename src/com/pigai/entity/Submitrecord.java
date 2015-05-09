package com.pigai.entity;

// default package
// Generated 2015-5-9 15:06:17 by Hibernate Tools 4.3.1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Submitrecord generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "submitrecord", catalog = "pigai")
public class Submitrecord implements java.io.Serializable {

	private Integer submitId;
	private Fileinfo fileinfo;
	private Homework homework;
	private Student student;
	private int score;
	private Date createTime;
	private String studentName;

	public Submitrecord() {
	}

	public Submitrecord(Fileinfo fileinfo, Homework homework, Student student,
			int score, Date createTime, String studentName) {
		this.fileinfo = fileinfo;
		this.homework = homework;
		this.student = student;
		this.score = score;
		this.createTime = createTime;
		this.studentName = studentName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "submitId", unique = true, nullable = false)
	public Integer getSubmitId() {
		return this.submitId;
	}

	public void setSubmitId(Integer submitId) {
		this.submitId = submitId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fileId", nullable = false)
	public Fileinfo getFileinfo() {
		return this.fileinfo;
	}

	public void setFileinfo(Fileinfo fileinfo) {
		this.fileinfo = fileinfo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "homeworkId", nullable = false)
	public Homework getHomework() {
		return this.homework;
	}

	public void setHomework(Homework homework) {
		this.homework = homework;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "studentId", nullable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Column(name = "score", nullable = false)
	public int getScore() {
		return this.score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createTime", nullable = false, length = 19)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "studentName", nullable = false)
	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

}
