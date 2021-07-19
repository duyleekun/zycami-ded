/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.xiaomi.channel.commonutils.logger;

import android.util.Log;
import com.xiaomi.channel.commonutils.logger.LoggerInterface;

public class a
implements LoggerInterface {
    private String a = "xiaomi";

    public void log(String string2) {
        Log.v((String)this.a, (String)string2);
    }

    public void log(String string2, Throwable throwable) {
        Log.v((String)this.a, (String)string2, (Throwable)throwable);
    }

    public void setTag(String string2) {
        this.a = string2;
    }
}

