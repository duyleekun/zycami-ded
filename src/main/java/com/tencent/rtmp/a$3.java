/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.r;
import com.tencent.rtmp.a;

public class a$3
implements r {
    public final /* synthetic */ a a;

    public a$3(a a10) {
        this.a = a10;
    }

    public void a(String object, int n10, TXSVideoFrame tXSVideoFrame) {
        int n11;
        if (tXSVideoFrame != null && (n11 = tXSVideoFrame.width) > 0 && (n11 = tXSVideoFrame.height) > 0) {
            object = com.tencent.rtmp.a.f(this.a);
            Object object2 = this.a;
            int n12 = 0;
            com.tencent.rtmp.a.a((a)object2, null);
            object2 = com.tencent.rtmp.a.g(this.a);
            if (object2 != null && object != null) {
                n12 = ((Object)object).length;
                int n13 = tXSVideoFrame.width;
                int n14 = tXSVideoFrame.height;
                if (n12 >= (n13 = n13 * n14 * 3 / 2)) {
                    tXSVideoFrame.loadYUVArray((byte[])object);
                    n12 = tXSVideoFrame.width;
                    n13 = tXSVideoFrame.height;
                    long l10 = tXSVideoFrame.pts;
                    n14 = (int)l10;
                    object2.onVideoRawDataAvailable((byte[])object, n12, n13, n14);
                    tXSVideoFrame.release();
                } else {
                    object = "TXLivePlayer";
                    object2 = "raw data buffer length is too large";
                    TXCLog.e((String)object, (String)object2);
                }
            }
        }
    }
}

