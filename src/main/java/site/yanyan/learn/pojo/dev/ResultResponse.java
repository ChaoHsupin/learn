package site.yanyan.learn.pojo.dev;

import io.swagger.annotations.ApiModelProperty;

public class ResultResponse<T extends Object> {
	  
	@ApiModelProperty(value = "错误码（成功：0 错误： 1）")
	private int code;
	@ApiModelProperty(value = "详细信息")
	private String msg;
	@ApiModelProperty(value = "返回数据")
	private T data;

	public ResultResponse(int c, String m) { 
		code = c;
		msg = m;
	}
	
	
	public ResultResponse(int c, String m, T o) { 
		code = c;
		msg = m;
		data = o;
	}
	
	public ResultResponse(String m) { 
		code = 0;
		msg = m; 
		data = null;
	}
	

	public ResultResponse(T o) { 
		code = 0;
		msg = "OK";
		data = o;
	}
	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
