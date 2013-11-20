package com.cofigauto.internal;

import org.apache.commons.lang.StringUtils;

/**
 */
public class TestStatus {
	private ValidTestStatus status=ValidTestStatus.NOT_RUN;
	private String statusDesc = StringUtils.EMPTY;

	/**
	 * Method getStatus.
	 * @return ValidTestStatus
	 */
	public ValidTestStatus getStatus() {
		return status;
	}

	/**
	 * Method setStatus.
	 * @param status ValidTestStatus
	 */
	public void setStatus(ValidTestStatus status) {
		this.status = status;
	}

	/**
	 * Method getStatusDesc.
	 * @return String
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * Method setStatusDesc.
	 * @param statusDesc String
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * Method toString.
	 * @return String
	 */
	@Override
	public String toString() {
		return "TestStatus [status=" + status + ", statusDesc=" + statusDesc + "]";
	}
}
