

package org.sang.hanzy;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;
	
	public R() {
		put("code", 0);
		put("msg", "success");
	}

	public R(int code, String msg){
		put("code", code);
		put("msg", msg);
	}

	public static org.sang.hanzy.R error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static org.sang.hanzy.R error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static org.sang.hanzy.R error(int code, String msg) {
		org.sang.hanzy.R r = new org.sang.hanzy.R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static org.sang.hanzy.R ok(String msg) {
		org.sang.hanzy.R r = new org.sang.hanzy.R();
		r.put("msg", msg);
		return r;
	}
	
	public static org.sang.hanzy.R ok(Map<String, Object> map) {
		org.sang.hanzy.R r = new org.sang.hanzy.R();
		r.putAll(map);
		return r;
	}
	
	public static org.sang.hanzy.R ok() {
		return new org.sang.hanzy.R();
	}

	@Override
	public org.sang.hanzy.R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
