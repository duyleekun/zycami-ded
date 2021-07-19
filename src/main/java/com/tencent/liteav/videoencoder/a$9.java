/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.videoencoder.a;

public class a$9
implements Runnable {
    public final /* synthetic */ a a;

    public a$9(a a10) {
        this.a = a10;
    }

    public void run() {
        int n10;
        int n11;
        Object object = com.tencent.liteav.videoencoder.a.e(this.a);
        if (object == null) {
            return;
        }
        object = this.a;
        object = com.tencent.liteav.videoencoder.a.e((a)object);
        try {
            object.signalEndOfInputStream();
        }
        catch (Exception exception) {
            String string2 = "TXCHWVideoEncoder";
            String string3 = "signalEndOfInputStream failed.";
            TXCLog.e(string2, string3, exception);
        }
        while ((n11 = com.tencent.liteav.videoencoder.a.c((a)(object = this.a), n10 = 10)) >= 0) {
        }
        com.tencent.liteav.videoencoder.a.a(this.a);
    }
}

