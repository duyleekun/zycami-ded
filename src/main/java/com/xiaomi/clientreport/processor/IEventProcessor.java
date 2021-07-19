/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.clientreport.processor;

import com.xiaomi.clientreport.processor.c;
import com.xiaomi.clientreport.processor.d;
import java.util.HashMap;

public interface IEventProcessor
extends c,
d {
    public String bytesToString(byte[] var1);

    public void setEventMap(HashMap var1);

    public byte[] stringToBytes(String var1);
}

