package com.pigai.util;

public class CheckUtil 
{
	/**
	 * @Description  对象为空返回true
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) 
	{
		boolean isEmpty = false;
        if (obj instanceof String) 
        {
            if(null == obj || ("").equals(((String) obj).trim()))
            	isEmpty = true;         
        }
        else
        {
        	if(null == obj || ("").equals(obj))
        		isEmpty = true;
        }
        return isEmpty;
    }	
}
