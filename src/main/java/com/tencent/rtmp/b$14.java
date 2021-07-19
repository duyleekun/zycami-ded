/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.rtmp.b;
import com.tencent.ugc.TXRecordCommon$TXRecordResult;

public class b$14
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ b c;

    public b$14(b b10, String string2, String string3) {
        this.c = b10;
        this.a = string2;
        this.b = string3;
    }

    public void run() {
        TXRecordCommon$TXRecordResult tXRecordCommon$TXRecordResult = new TXRecordCommon$TXRecordResult();
        tXRecordCommon$TXRecordResult.retCode = 0;
        tXRecordCommon$TXRecordResult.descMsg = "record success";
        Object object = this.a;
        tXRecordCommon$TXRecordResult.videoPath = object;
        object = this.b;
        tXRecordCommon$TXRecordResult.coverPath = object;
        object = com.tencent.rtmp.b.h(this.c);
        if (object != null) {
            object = com.tencent.rtmp.b.h(this.c);
            object.onRecordComplete(tXRecordCommon$TXRecordResult);
        }
        TXCLog.w(com.tencent.rtmp.b.x(), "record complete success");
    }
}

