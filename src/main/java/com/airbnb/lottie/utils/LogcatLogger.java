/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.airbnb.lottie.utils;

import android.util.Log;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieLogger;
import java.util.HashSet;
import java.util.Set;

public class LogcatLogger
implements LottieLogger {
    private static final Set loggedMessages;

    static {
        HashSet hashSet;
        loggedMessages = hashSet = new HashSet();
    }

    public void debug(String string2) {
        this.debug(string2, null);
    }

    public void debug(String string2, Throwable throwable) {
        boolean bl2 = L.DBG;
        if (bl2) {
            String string3 = "LOTTIE";
            Log.d((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void error(String string2, Throwable throwable) {
        boolean bl2 = L.DBG;
        if (bl2) {
            String string3 = "LOTTIE";
            Log.d((String)string3, (String)string2, (Throwable)throwable);
        }
    }

    public void warning(String string2) {
        this.warning(string2, null);
    }

    public void warning(String string2, Throwable throwable) {
        Set set = loggedMessages;
        boolean bl2 = set.contains(string2);
        if (bl2) {
            return;
        }
        Log.w((String)"LOTTIE", (String)string2, (Throwable)throwable);
        set.add(string2);
    }
}

