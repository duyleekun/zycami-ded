/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 */
package com.tencent.liteav.network;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.liteav.network.TXCStreamUploader;

public class TXCStreamUploader$1
extends Handler {
    public final /* synthetic */ TXCStreamUploader a;

    public TXCStreamUploader$1(TXCStreamUploader tXCStreamUploader, Looper looper) {
        this.a = tXCStreamUploader;
        super(looper);
    }

    public void handleMessage(Message object) {
        int n10 = object.what;
        int n11 = 101;
        if (n10 != n11) {
            int n12 = 103;
            if (n10 != n12) {
                n12 = 104;
                if (n10 == n12) {
                    TXCStreamUploader.access$200(this.a);
                    Handler handler = TXCStreamUploader.access$300(this.a);
                    if (handler != null) {
                        handler = TXCStreamUploader.access$300(this.a);
                        long l10 = 2000L;
                        handler.sendEmptyMessageDelayed(n12, l10);
                    }
                }
            } else {
                object = this.a;
                TXCStreamUploader.access$100((TXCStreamUploader)object);
            }
        } else {
            TXCStreamUploader tXCStreamUploader = this.a;
            String string2 = (String)object.obj;
            int n13 = object.arg1;
            int n14 = 2;
            if (n13 == n14) {
                n13 = 1;
            } else {
                n13 = 0;
                object = null;
            }
            TXCStreamUploader.access$000(tXCStreamUploader, string2, n13 != 0, 0);
        }
    }
}

