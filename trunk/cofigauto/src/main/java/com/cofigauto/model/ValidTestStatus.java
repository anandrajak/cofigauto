package com.cofigauto.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

/**
 */
@XmlType(name = "validTestStatus")
@XmlEnum
public enum ValidTestStatus {
  /**
   * FAIL test case status.
   */
  FAIL,
  /**
   * PASS test case status.
   */
  PASS,
  /**
   * NOTRUN test case status.
   */
  NOT_RUN;
}
