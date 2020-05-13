package com.sample.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.util.HtmlUtils;

@Component
public class HtmlUtilsWrapper {
    public String htmlEncode(String toEncode) {
        return HtmlUtils.htmlEscape(toEncode.trim());
    }
}
