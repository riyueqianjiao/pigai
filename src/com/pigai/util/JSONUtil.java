package com.pigai.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;


public class JSONUtil {	
		
	private boolean status;
    private Object data;
    private String message;
    
    public boolean getStatus()
    {
    	return status;
    }
    public void setStatus(boolean status)
    {
    	this.status = status;
    }
    public Object getData()
    {
    	return data;
    }
    public void setData(Object data)
    {
    	this.data = data;
    }
    public String getMessage()
    {
    	return message;
    }
    public void setMessage(String message)
    {
    	this.message = message;
    }
    public String toString()
    {
    	return JSON.toJSONString(this);
    }
    
	public static void toJSON(Object data,HttpServletResponse response) throws IOException
	{
		JSONUtil ju = new JSONUtil();
		ju.setStatus(true);
		ju.setData(data);
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(ju.toString());
		response.getWriter().flush();
		System.out.println(ju.toString());
	}
    
	public static void outputError(String message,HttpServletResponse response) throws IOException
	{
		JSONUtil ju = new JSONUtil();
		ju.setStatus(false);
		ju.setMessage(message);
		response.setCharacterEncoding("UTF-8"); 
		response.setContentType("application/json;charset=UTF-8");
		response.getWriter().write(ju.toString());
		response.getWriter().flush();
		System.out.println(ju.toString());
	}       
    
    public static void main(String args[]) throws IOException
    {
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(1);
    	list.add(2);
    	list.add(3);
    	list.add(4);
    	HttpServletResponse response = null;
    	JSONUtil.toJSON(list, response);
    	JSONUtil.outputError("用户名错误", response);

    }
}
