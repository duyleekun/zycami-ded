/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.gd;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

public class fu {
    public static int a(Throwable object) {
        Throwable throwable;
        Object object2;
        int n10 = object instanceof gd;
        if (n10 != 0) {
            object2 = object;
            object2 = (gd)object;
            throwable = ((gd)object2).a();
            if (throwable != null) {
                object = ((gd)object2).a();
            }
        }
        object2 = ((Throwable)object).getMessage();
        throwable = ((Throwable)object).getCause();
        if (throwable != null) {
            object2 = ((Throwable)object).getCause().getMessage();
        }
        boolean bl2 = object instanceof SocketTimeoutException;
        int n11 = 105;
        if (bl2) {
            return n11;
        }
        bl2 = object instanceof SocketException;
        if (bl2) {
            object = "Network is unreachable";
            int n12 = ((String)object2).indexOf((String)object);
            if (n12 != (n10 = -1)) {
                return 102;
            }
            object = "Connection refused";
            n12 = ((String)object2).indexOf((String)object);
            if (n12 != n10) {
                return 103;
            }
            object = "Connection timed out";
            n12 = ((String)object2).indexOf((String)object);
            if (n12 != n10) {
                return n11;
            }
            object = "EACCES (Permission denied)";
            n12 = (int)(((String)object2).endsWith((String)object) ? 1 : 0);
            if (n12 != 0) {
                return 101;
            }
            object = "Connection reset by peer";
            n12 = ((String)object2).indexOf((String)object);
            if (n12 != n10) {
                return 109;
            }
            object = "Broken pipe";
            n12 = ((String)object2).indexOf((String)object);
            if (n12 != n10) {
                return 110;
            }
            object = "No route to host";
            n12 = ((String)object2).indexOf((String)object);
            if (n12 != n10) {
                return 104;
            }
            object = "EINVAL (Invalid argument)";
            n12 = (int)(((String)object2).endsWith((String)object) ? 1 : 0);
            if (n12 != 0) {
                return 106;
            }
            return 199;
        }
        boolean bl3 = object instanceof UnknownHostException;
        if (bl3) {
            return 107;
        }
        if (n10 != 0) {
            return 399;
        }
        return 0;
    }
}

