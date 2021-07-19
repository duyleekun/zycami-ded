/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf;

import java.util.Map;

public interface FirebasePerformanceAttributable {
    public static final int MAX_ATTRIBUTE_KEY_LENGTH = 40;
    public static final int MAX_ATTRIBUTE_VALUE_LENGTH = 100;
    public static final int MAX_TRACE_CUSTOM_ATTRIBUTES = 5;
    public static final int MAX_TRACE_NAME_LENGTH = 100;

    public String getAttribute(String var1);

    public Map getAttributes();

    public void putAttribute(String var1, String var2);

    public void removeAttribute(String var1);
}

