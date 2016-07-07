package com.freitas.exception;

public enum Service {
	CUSTOMER_SERVICE(1, "CustomerGupErrorCode"),
	;
	
	private int          serviceId;
	private String serviceEnumName;

	Service(int serviceId, String serviceEnumName) {
		this.serviceId       = serviceId;
		this.serviceEnumName = serviceEnumName;
	}
	
	public int getServiceId() {
		return serviceId;
	}
	
	public String getServiceEnumName(){
		return serviceEnumName;
	}
	
	static public BaseException createServiceException(RestError restError) {
		switch (restError.getServiceId()){
		case 1:
			ErrorCode errorCodeEnum = CustomerGupErrorCode.get(restError.getErrorCode());
			return new CustomerGupException(errorCodeEnum, restError.getDebugMessage(), restError.getMessageArgs());
		default:
			return null;
		}
	}
}
