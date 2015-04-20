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
 * File generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity
@Table(name = "t_file", catalog = "pigai")
public class File implements java.io.Serializable {

	private Integer fileId;
	private String fileName;
	private String filePath;
	private Double fileSize;
	private String fileType;
	private Set<Courseware> Coursewares = new HashSet<Courseware>(0);
	private Set<Submitrecord> Submitrecords = new HashSet<Submitrecord>(0);

	public File() {
	}

	public File(String fileName, String filePath) {
		this.fileName = fileName;
		this.filePath = filePath;
	}

	public File(String fileName, String filePath, Double fileSize,
			String fileType, Set<Courseware> Coursewares,
			Set<Submitrecord> Submitrecords) {
		this.fileName = fileName;
		this.filePath = filePath;
		this.fileSize = fileSize;
		this.fileType = fileType;
		this.Coursewares = Coursewares;
		this.Submitrecords = Submitrecords;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "fileId", unique = true, nullable = false)
	public Integer geFileId() {
		return this.fileId;
	}

	public void seFileId(Integer fileId) {
		this.fileId = fileId;
	}

	@Column(name = "fileName", nullable = false)
	public String geFileName() {
		return this.fileName;
	}

	public void seFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "filePath", nullable = false)
	public String geFilePath() {
		return this.filePath;
	}

	public void seFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Column(name = "fileSize", precision = 22, scale = 0)
	public Double geFileSize() {
		return this.fileSize;
	}

	public void seFileSize(Double fileSize) {
		this.fileSize = fileSize;
	}

	@Column(name = "fileType")
	public String geFileType() {
		return this.fileType;
	}

	public void seFileType(String fileType) {
		this.fileType = fileType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "File")
	public Set<Courseware> getCoursewares() {
		return this.Coursewares;
	}

	public void setCoursewares(Set<Courseware> Coursewares) {
		this.Coursewares = Coursewares;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "File")
	public Set<Submitrecord> getSubmitrecords() {
		return this.Submitrecords;
	}

	public void setSubmitrecords(Set<Submitrecord> Submitrecords) {
		this.Submitrecords = Submitrecords;
	}

}