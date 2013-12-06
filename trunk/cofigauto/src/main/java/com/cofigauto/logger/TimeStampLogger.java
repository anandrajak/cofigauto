package com.cofigauto.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.log4j.FileAppender;

/**
 * @author Vinay Sharma
 *
 */
public class TimeStampLogger extends FileAppender {

  /**
   * 
   */
  private String timeformat = "dd_MMM_yyyy_HH_mm_ss";

  /* (non-Javadoc)
   * @see org.apache.log4j.FileAppender#setFile(java.lang.String)
   */
  @Override
  public final void setFile(final String file) {
    super.setFile(file.replace(".log", "")
        + " "
        + (new SimpleDateFormat(timeformat).format(Calendar.getInstance()
            .getTime())) + ".log");
  }

  /**
   * @return
   */
  public final String getTimeformat() {
    return timeformat;
  }

  /**
   * @param reportingTimeformat
   */
  public final void setTimeformat(final String reportingTimeformat) {
    this.timeformat = reportingTimeformat;
  }

}
