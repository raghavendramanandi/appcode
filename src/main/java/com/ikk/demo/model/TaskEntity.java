package com.ikk.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.ikk.demo.enums.Status;
import com.ikk.demo.enums.TaskType;

@Entity
@Table(name="task")
public class TaskEntity implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@NotBlank
	private TaskType taskType;
	private DeviceEntity device;
	@NotBlank
	private Status status;
	@NotNull
	private Date createDateTime;
	@NotNull
	private Date updatedDateTime;
	private String misc1;
	private String misc2;
	public TaskEntity(int id, TaskType taskType, DeviceEntity device, Status status, Date createDateTime,
			Date updatedDateTime, String misc1, String misc2) {
		super();
		this.id = id;
		this.taskType = taskType;
		this.device = device;
		this.status = status;
		this.createDateTime = createDateTime;
		this.updatedDateTime = updatedDateTime;
		this.misc1 = misc1;
		this.misc2 = misc2;
	}
	public TaskEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public TaskType getTaskType() {
		return taskType;
	}
	public void setTaskType(TaskType taskType) {
		this.taskType = taskType;
	}
	public DeviceEntity getDevice() {
		return device;
	}
	public void setDevice(DeviceEntity device) {
		this.device = device;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public Date getUpdatedDateTime() {
		return updatedDateTime;
	}
	public void setUpdatedDateTime(Date updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
	public String getMisc1() {
		return misc1;
	}
	public void setMisc1(String misc1) {
		this.misc1 = misc1;
	}
	public String getMisc2() {
		return misc2;
	}
	public void setMisc2(String misc2) {
		this.misc2 = misc2;
	}
	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", taskType=" + taskType + ", device=" + device + ", status=" + status
				+ ", createDateTime=" + createDateTime + ", updatedDateTime=" + updatedDateTime + ", misc1=" + misc1
				+ ", misc2=" + misc2 + "]";
	}
}
