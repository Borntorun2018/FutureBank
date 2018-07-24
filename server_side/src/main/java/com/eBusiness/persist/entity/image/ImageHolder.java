package com.eBusiness.persist.entity.image;

import java.io.Serializable;

/**
 * This class is used as an middle class so that the byte image is stored in memory until it is stored in a file directory
 * @author 62065
 *
 */
public class ImageHolder extends Image implements Serializable{
	private static final long serialVersionUID = -9118619177798333712L;

	private String url;
	
	private String _file;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String get_file() {
		return _file;
	}
	public void set_file(String _file) {
		this._file = _file;
	}
}
