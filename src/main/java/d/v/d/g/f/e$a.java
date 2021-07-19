/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 */
package d.v.d.g.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import d.v.d.g.f.e;
import d.v.d.h.f;
import java.nio.ByteBuffer;

public class e$a
implements Runnable {
    public static final /* synthetic */ boolean b;
    public final /* synthetic */ e a;

    public e$a(e e10) {
        this.a = e10;
    }

    public void run() {
        Object object;
        int n10;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while ((n10 = e.a((e)(object = this.a))) != 0) {
            object = e.b(this.a);
            long l10 = 10000L;
            n10 = object.dequeueOutputBuffer(bufferInfo, l10);
            Object object2 = this.a;
            float f10 = e.d((e)object2);
            Object object3 = this.a;
            float f11 = e.e((e)object3);
            f10 /= f11;
            int n11 = 1148846080;
            f11 = 1000.0f;
            int n12 = (int)(f10 * f11);
            long l11 = System.nanoTime();
            long l12 = n12;
            bufferInfo.presentationTimeUs = l11 /= l12;
            n12 = -1;
            f10 = 0.0f / 0.0f;
            if (n10 == n12) {
                object = this.a;
                n10 = (int)(e.a((e)object) ? 1 : 0);
                if (n10 != 0) continue;
                break;
            }
            n12 = -2;
            f10 = 0.0f / 0.0f;
            if (n10 == n12) {
                object = e.f(this.a);
                if (object == null) continue;
                object = e.f(this.a);
                object2 = e.b(this.a).getOutputFormat();
                object.b((MediaFormat)object2);
                continue;
            }
            if (n10 < 0) continue;
            object2 = e.b(this.a).getOutputBuffer(n10);
            n11 = bufferInfo.flags & 2;
            if (n11 != 0) {
                bufferInfo.size = 0;
            }
            if ((n11 = bufferInfo.size) != 0) {
                n11 = bufferInfo.offset;
                ((ByteBuffer)object2).position(n11);
                n11 = bufferInfo.offset;
                int n13 = bufferInfo.size;
                ((ByteBuffer)object2).limit(n11 += n13);
                object3 = e.f(this.a);
                if (object3 != null) {
                    object3 = e.f(this.a);
                    object3.a((ByteBuffer)object2, bufferInfo);
                }
            }
            object2 = e.b(this.a);
            object2.releaseOutputBuffer(n10, false);
        }
        f.a("release video encoder");
        e.b(this.a).stop();
        e.b(this.a).release();
        e.c(this.a, null);
        e.g(this.a).release();
        e.h(this.a, null);
    }
}

