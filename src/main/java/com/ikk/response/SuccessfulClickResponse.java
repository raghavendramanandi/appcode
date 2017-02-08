package com.ikk.response;

import java.io.Serializable;

import com.howtodoinjava.demo.enums.MODE;

public class SuccessfulClickResponse extends ClickResponse implements Serializable{
	/**
	 * Serialization version
	 */
	private static final long serialVersionUID = 8308438995999844368L;
	
	private String state;
	private String code;
	private MODE mode;
	private String parm1;
	private String parm2;
	private String parm3;
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public MODE getMode() {
		return mode;
	}
	public void setMode(MODE mode) {
		this.mode = mode;
	}
	public String getParm1() {
		return parm1;
	}
	public void setParm1(String parm1) {
		this.parm1 = parm1;
	}
	public String getParm2() {
		return parm2;
	}
	public void setParm2(String parm2) {
		this.parm2 = parm2;
	}
	public String getParm3() {
		return parm3;
	}
	public void setParm3(String parm3) {
		this.parm3 = parm3;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "SuccessfulClickResponse [state=" + state + ", code=" + code + ", mode=" + mode + ", parm1=" + parm1
				+ ", parm2=" + parm2 + ", parm3=" + parm3 + "]";
	}
	public SuccessfulClickResponse(String state, String code, MODE mode, String parm1, String parm2, String parm3) {
		super();
		this.state = state;
		this.code = code;
		this.mode = mode;
		this.parm1 = parm1;
		this.parm2 = parm2;
		this.parm3 = parm3;
	}
	public SuccessfulClickResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
