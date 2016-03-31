package com.appleframework.rop.jmx;

public interface DebugEnableConfigMBean {
	
	/* 默认的Type */
	public static final String ROP_DEFAULT_TYPE = "rop";
	/* type的key */
	public static final String ROP_TYPE_KEY = "type";
	/* name的key */
	public static final String ROP_ID_KEY = "id";


	public boolean isDebugEnable();

	public void setDebugEnable(boolean debugEnable);
	
}
