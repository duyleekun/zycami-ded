/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.b;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;
import com.tencent.ugc.TXRecordCommon$TXRecordResult;

public class b$13
implements Runnable {
    public final /* synthetic */ b a;

    public b$13(b b10) {
        this.a = b10;
    }

    public void run() {
        int n10;
        TXRecordCommon$TXRecordResult tXRecordCommon$TXRecordResult = new TXRecordCommon$TXRecordResult();
        tXRecordCommon$TXRecordResult.retCode = n10 = -1;
        tXRecordCommon$TXRecordResult.descMsg = "record video failed";
        TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener = b.h(this.a);
        if (tXRecordCommon$ITXVideoRecordListener != null) {
            tXRecordCommon$ITXVideoRecordListener = b.h(this.a);
            tXRecordCommon$ITXVideoRecordListener.onRecordComplete(tXRecordCommon$TXRecordResult);
        }
        TXCLog.w(b.x(), "record complete fail");
    }
}

