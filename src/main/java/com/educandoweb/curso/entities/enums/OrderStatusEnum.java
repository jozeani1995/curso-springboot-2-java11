package com.educandoweb.curso.entities.enums;

public enum OrderStatusEnum {

	WAINTING_PAIMENT (1),
	PAID (2),
	SHIPPED (3),
	DELIVERED (4),
	CANCELED (5);
	
	private int code;
	
	private OrderStatusEnum(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
//	metodo estatico pra coverter um valor niumerico para um tipo enumeardo
	public static OrderStatusEnum valueOf(int code) {
		for (OrderStatusEnum value : OrderStatusEnum.values()) {
			if (value.getCode() == code) {
				return value; 
			}
		}
//		excessao para codigo invalido
		throw new IllegalArgumentException("CODIGO INVALIDO ORDERSTATUSENUM");
	}
}
