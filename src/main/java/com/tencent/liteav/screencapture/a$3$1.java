/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Handler
 */
package com.tencent.liteav.screencapture;

import android.os.Build;
import android.os.Handler;
import com.tencent.liteav.screencapture.a$3;

public class a$3$1
implements Runnable {
    public final /* synthetic */ a$3 a;

    public a$3$1(a$3 var1_1) {
        this.a = var1_1;
    }

    public void run() {
        int n10;
        Handler handler = this.a.a;
        if (handler != null) {
            n10 = 0;
            handler.removeCallbacksAndMessages(null);
        }
        if ((handler = this.a.b) != null) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 >= n11) {
                handler.quitSafely();
            } else {
                handler.quit();
            }
        }
    }
}

