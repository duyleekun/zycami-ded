/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 */
package com.tencent.liteav;

import android.graphics.Bitmap;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.b;
import java.nio.ByteBuffer;

public class d$8
implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ ByteBuffer b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ d e;

    public d$8(d d10, Bitmap bitmap, ByteBuffer byteBuffer, int n10, int n11) {
        this.e = d10;
        this.a = bitmap;
        this.b = byteBuffer;
        this.c = n10;
        this.d = n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            long l10;
            int n10;
            int n11;
            int n12;
            int n13;
            Object object;
            int n14;
            Object object2;
            block15: {
                int n15;
                int n16;
                block14: {
                    block13: {
                        block12: {
                            object2 = this.e;
                            n14 = com.tencent.liteav.d.m((d)object2);
                            n16 = 2;
                            if (n14 != n16) {
                                object2 = this.e;
                                n14 = (int)(com.tencent.liteav.d.n((d)object2) ? 1 : 0);
                                if (n14 == 0) return;
                            }
                            if ((object2 = this.a) == null) return;
                            object2 = this.b;
                            if (object2 == null) {
                                return;
                            }
                            object2 = this.e;
                            if ((object2 = com.tencent.liteav.d.a((d)object2)) == null || (n14 = (int)(com.tencent.liteav.d.o((d)(object2 = this.e)) ? 1 : 0)) != 0) break block12;
                            object2 = this.e;
                            object2 = com.tencent.liteav.d.c((d)object2);
                            n14 = ((TXSVideoEncoderParam)object2).width;
                            n15 = this.c;
                            if (n14 != n15) break block12;
                            object2 = this.e;
                            object2 = com.tencent.liteav.d.c((d)object2);
                            n14 = ((TXSVideoEncoderParam)object2).height;
                            n15 = this.d;
                            if (n14 != n15) break block12;
                            object2 = this.e;
                            object2 = com.tencent.liteav.d.c((d)object2);
                            n14 = ((TXSVideoEncoderParam)object2).encodeType;
                            if (n14 != n16) break block12;
                            object2 = this.e;
                            object2 = com.tencent.liteav.d.c((d)object2);
                            n14 = ((TXSVideoEncoderParam)object2).gop;
                            object = this.e;
                            object = com.tencent.liteav.d.d((d)object);
                            n15 = ((g)object).i;
                            if (n14 == n15) break block13;
                        }
                        object = this.e;
                        n13 = this.c;
                        n12 = this.d;
                        n11 = 2;
                        object2 = com.tencent.liteav.d.d((d)object);
                        int n17 = ((g)object2).C;
                        n10 = 1;
                        com.tencent.liteav.d.a((d)object, n13, n12, n11, null, n17, n10 != 0);
                    }
                    object2 = this.e;
                    if ((object2 = com.tencent.liteav.d.b((d)object2)) == null) break block14;
                    object2 = this.e;
                    object2 = com.tencent.liteav.d.g((d)object2);
                    n14 = ((TXSVideoEncoderParam)object2).encodeType;
                    if (n14 == n16) break block15;
                }
                if ((n14 = (int)(com.tencent.liteav.d.p((d)(object2 = this.e)) ? 1 : 0)) != 0) {
                    object2 = this.e;
                    n15 = 0;
                    object = null;
                    n13 = 1;
                    com.tencent.liteav.d.a((d)object2, null, n16, n13 != 0);
                }
            }
            object2 = this.a;
            n14 = object2.getWidth();
            Object object3 = this.a;
            n10 = object3.getHeight();
            object3 = this.e;
            if ((object3 = com.tencent.liteav.d.a((d)object3)) != null) {
                object = this.b;
                object = ((ByteBuffer)object).array();
                n13 = 2;
                l10 = TXCTimeUtil.generatePtsMS();
                n12 = n14;
                n11 = n10;
                ((b)object3).a((byte[])object, n13, n14, n10, l10);
            }
            object3 = this.e;
            if ((object3 = com.tencent.liteav.d.b((d)object3)) == null) return;
            object = this.b;
            object = ((ByteBuffer)object).array();
            n13 = 2;
            l10 = TXCTimeUtil.generatePtsMS();
            n12 = n14;
            n11 = n10;
            ((b)object3).a((byte[])object, n13, n14, n10, l10);
            return;
        }
        catch (Exception exception) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "onPushBitmap failed.";
            charSequence.append(string2);
            String string3 = exception.getMessage();
            charSequence.append(string3);
            string3 = charSequence.toString();
            charSequence = "TXCCaptureAndEnc";
            TXCLog.e((String)charSequence, string3);
        }
    }
}

