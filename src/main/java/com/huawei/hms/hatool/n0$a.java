/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.hatool;

import com.huawei.hms.hatool.y;

public class n0$a
implements Runnable {
    public Runnable a;

    public n0$a(Runnable runnable) {
        this.a = runnable;
    }

    public void run() {
        Object object = this.a;
        if (object != null) {
            try {
                object.run();
            }
            catch (Exception exception) {
                object = "hmsSdk";
                String string2 = "InnerTask : Exception has happened,From internal operations!";
                y.e((String)object, string2);
            }
        }
    }
}

