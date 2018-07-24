package com.eBusiness.util;
import java.io.Serializable;

public class SystemConfig implements Serializable{
	
	private static final long serialVersionUID = -4345519177798333712L;
	
	private String developmentServerURL;
	private String defaultWebImageDir;
	private String uploadImageExternalDir;
	private String defaultWebImageName;			
		
	public String getDevelopmentServerURL() {
		return developmentServerURL;
	}
	public void setDevelopmentServerURL(String developmentServerURL) {
		this.developmentServerURL = developmentServerURL;
	}
	public String getDefaultWebImageDir() {
		return defaultWebImageDir;
	}
	public void setDefaultWebImageDir(String defaultWebImageDir) {
		this.defaultWebImageDir = defaultWebImageDir;
	}
	public String getUploadImageExternalDir() {
		return uploadImageExternalDir;
	}
	public void setUploadImageExternalDir(String uploadImageExternalDir) {
		this.uploadImageExternalDir = uploadImageExternalDir;
	}
	public String getDefaultWebImageName() {
		return defaultWebImageName;
	}
	public void setDefaultWebImageName(String defaultWebImageName) {
		this.defaultWebImageName = defaultWebImageName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
