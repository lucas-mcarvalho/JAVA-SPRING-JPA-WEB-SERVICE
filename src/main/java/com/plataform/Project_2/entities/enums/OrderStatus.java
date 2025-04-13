package com.plataform.Project_2.entities.enums;

public enum OrderStatus {
	WAITING_PAYMENT(1),
	PAID(2)
	,SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);	
	
	int code;
	
	private OrderStatus(int code) {

		this.code = code;
	}

	public int getCode() {

		return code;
	}
	
	public static OrderStatus ValueOff(Integer code) {
		for(OrderStatus status : OrderStatus.values()) {
			if(status.getCode() == code) {
				return status;
			}
		}
		throw new IllegalArgumentException("Invalid order status code!");
	}
}
