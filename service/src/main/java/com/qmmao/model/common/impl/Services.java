package com.qmmao.model.common.impl;

import com.qmmao.model.common.rpc.Provider;
import com.qmmao.model.common.rpc.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author maoqi
 */
public class Services {
    private Services() {
    }

    private static final Map<String, Provider> PROVIDER_MAP = new ConcurrentHashMap<String, Provider>();

    public static final String DEFAULT_PROVIDER_NAME = "<def>";

    public static void registerDefaultProvider(Provider provider) {
        registerProvider(DEFAULT_PROVIDER_NAME, provider);
    }

    public static void registerProvider(String name, Provider provider) {
        PROVIDER_MAP.put(name, provider);
    }

    public static Service newInstance() {
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name) {
        if (!PROVIDER_MAP.containsKey(name)) {
            throw new IllegalArgumentException(String.format("No provider registered with name: %s", name));
        }
        return PROVIDER_MAP.get(name).newService();
    }
}
