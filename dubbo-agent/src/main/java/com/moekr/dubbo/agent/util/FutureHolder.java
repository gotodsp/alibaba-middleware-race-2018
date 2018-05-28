package com.moekr.dubbo.agent.util;

import com.moekr.dubbo.agent.protocol.AbstractRequest;

import java.util.HashMap;
import java.util.Map;

public abstract class FutureHolder {
	private static final Map<Long, ResponseFuture> FUTURE_MAP = new HashMap<>();

	public static void hold(ResponseFuture future) {
		AbstractRequest request = future.getRequest();
		FUTURE_MAP.put(request.getId(), future);
	}

	public static ResponseFuture remove(long id) {
		return FUTURE_MAP.remove(id);
	}
}