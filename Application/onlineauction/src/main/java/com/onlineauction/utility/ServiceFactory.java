package com.onlineauction.utility;

import com.onlineauction.service.Service;
import com.onlineauction.service.ServiceInterface;

public class ServiceFactory {

	public static ServiceInterface createServiceObject() {
		return new Service();
	}

}