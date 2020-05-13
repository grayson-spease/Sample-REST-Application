package com.sample.logging;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;

@Component
public class MdcWrapper {
    public void put(String key, String value) {
        MDC.put(key, value);
    }

    public void clear() {
        MDC.clear();
    }

    public String get(String key) {
        return MDC.get(key);
    }
}
