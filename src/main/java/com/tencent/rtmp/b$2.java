/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.rtmp.b;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;

public class b$2
implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ b b;

    public b$2(b b10, long l10) {
        this.b = b10;
        this.a = l10;
    }

    public void run() {
        TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener = com.tencent.rtmp.b.h(this.b);
        if (tXRecordCommon$ITXVideoRecordListener != null) {
            tXRecordCommon$ITXVideoRecordListener = com.tencent.rtmp.b.h(this.b);
            long l10 = this.a;
            tXRecordCommon$ITXVideoRecordListener.onRecordProgress(l10);
        }
    }
}

