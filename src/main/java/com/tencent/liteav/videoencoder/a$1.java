/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.videoencoder;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.a;
import com.tencent.liteav.videoencoder.c;

public class a$1
implements Runnable {
    public final /* synthetic */ TXSVideoEncoderParam a;
    public final /* synthetic */ a b;

    public a$1(a a10, TXSVideoEncoderParam tXSVideoEncoderParam) {
        this.b = a10;
        this.a = tXSVideoEncoderParam;
    }

    public void run() {
        Object object = this.a;
        int n10 = ((TXSVideoEncoderParam)object).encoderMode;
        Object object2 = "unknown";
        int n11 = 3;
        int n12 = 1;
        int n13 = 2;
        Object object3 = n10 != n12 ? (n10 != n13 ? (n10 != n11 ? object2 : "CQ") : "VBR") : "CBR";
        int n14 = ((TXSVideoEncoderParam)object).encoderProfile;
        if (n14 != n12) {
            if (n14 != n13) {
                if (n14 == n11) {
                    object2 = "High";
                }
            } else {
                object2 = "Main";
            }
        } else {
            object2 = "Baseline";
        }
        n14 = 10;
        object = new Object[n14];
        Integer n15 = this.b.hashCode();
        object[0] = n15;
        n15 = this.a.width;
        object[n12] = n15;
        n15 = this.a.height;
        object[n13] = n15;
        n15 = this.a.fps;
        object[n11] = n15;
        n15 = this.a.bitrate;
        object[4] = n15;
        int n16 = this.a.gop;
        n15 = n16;
        object[5] = n15;
        object[6] = object3;
        object[7] = object2;
        n10 = 8;
        object2 = this.a;
        n11 = (int)(((TXSVideoEncoderParam)object2).bMultiRef ? 1 : 0);
        String string2 = n11 != 0 ? "true" : "false";
        object[n10] = string2;
        int n17 = ((TXSVideoEncoderParam)object2).streamType;
        object[9] = object2 = Integer.valueOf(n17);
        object = String.format("VideoEncoder[%d]: Start [type:hardware][resolution:%d*%d][fps:%d][bitrate:%dkbps][gop:%d][rateControl:%s][profile:%s][rps:%s][streamType:%d]", (Object[])object);
        Monitor.a(n13, (String)object, "", 0);
        object3 = new StringBuilder();
        object2 = "start:";
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append((String)object);
        object = ((StringBuilder)object3).toString();
        object3 = "TXCHWVideoEncoder";
        TXCLog.i((String)object3, (String)object);
        object = this.b;
        n10 = (int)(((c)object).mInit ? 1 : 0);
        if (n10 != 0) {
            com.tencent.liteav.videoencoder.a.a((a)object);
        }
        if ((n14 = (int)(com.tencent.liteav.videoencoder.a.a((a)(object = this.b), (TXSVideoEncoderParam)(object3 = this.a)) ? 1 : 0)) != 0) {
            object = new Object[n13];
            object[0] = object3 = Integer.valueOf(this.b.hashCode());
            n10 = this.a.streamType;
            object[n12] = object3 = Integer.valueOf(n10);
            object = String.format("VideoEncoder[%d]: Start successfully, streamType:%d", (Object[])object);
            object3 = "streamType: 2-big, 3-small, 7-sub";
            Monitor.a(n13, (String)object, (String)object3, 0);
        } else {
            object = this.b;
            n10 = 10000004;
            ((c)object).callDelegate(n10);
        }
    }
}

