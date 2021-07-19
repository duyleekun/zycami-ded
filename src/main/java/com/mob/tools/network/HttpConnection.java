/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import java.io.InputStream;
import java.util.Map;

public interface HttpConnection {
    public InputStream getErrorStream();

    public Map getHeaderFields();

    public InputStream getInputStream();

    public int getResponseCode();
}

