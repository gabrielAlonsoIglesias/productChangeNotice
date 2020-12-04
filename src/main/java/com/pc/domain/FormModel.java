package com.pc.domain;

import java.io.Serializable;

public class FormModel implements Serializable {

	private static final long serialVersionUID = 2L;

	private Integer productId;

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

}
