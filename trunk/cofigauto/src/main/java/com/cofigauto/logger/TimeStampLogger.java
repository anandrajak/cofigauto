package com.cofigauto.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.FileAppender;

public class TimeStampLogger extends FileAppender {

	private String timeformat="dd_MMM_yyyy_HH_mm_ss";
	
	@Override
	public void setFile(String file) {
		super.setFile(file.replace(".log", "") +" "+(new SimpleDateFormat(timeformat).format(Calendar.getInstance().getTime()))+".log");
	}

	public String getTimeformat() {
		return timeformat;
	}

	public void setTimeformat(String timeformat) {
		this.timeformat = timeformat;
	}

}
