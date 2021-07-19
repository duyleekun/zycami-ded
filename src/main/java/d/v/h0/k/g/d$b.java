/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 */
package d.v.h0.k.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build;
import android.os.SystemClock;
import d.v.h0.k.c;
import d.v.h0.k.g.a;
import d.v.h0.k.g.d;
import d.v.h0.k.g.d$a;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicBoolean;

public class d$b
implements c {
    public final long a;
    public MediaCodec.BufferInfo b;
    public boolean c;
    public long d;
    public final /* synthetic */ d e;

    private d$b(d d10) {
        this.e = d10;
        this.a = 1000L;
        this.b = d10;
    }

    public /* synthetic */ d$b(d d10, d$a d$a) {
        this(d10);
    }

    public void n() {
        this.c = true;
    }

    public void release() {
        int n10;
        int n11;
        Object object = d.v.h0.k.g.d.k(this.e);
        if (object != null) {
            d.v.h0.k.g.d.k(this.e).release();
            object = this.e;
            d.v.h0.k.g.d.l((d)object, null);
        }
        if ((object = d.v.h0.k.g.d.n(this.e)) != null && (n11 = Build.VERSION.SDK_INT) < (n10 = 23)) {
            d.v.h0.k.g.d.n(this.e).release();
            object = this.e;
            d.v.h0.k.g.d.o((d)object, null);
        }
        this.e.d(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        try {
            int n10;
            Object object3 = this.e;
            object3 = d.v.h0.k.g.d.k((d)object3);
            if (object3 == null) {
                return;
            }
            while ((n10 = this.c) == 0) {
                Object object4;
                int n11;
                long l10;
                object3 = this.e;
                object3 = ((a)object3).a;
                n10 = ((AtomicBoolean)object3).get();
                if (n10 != 0) {
                    long l11 = 2;
                    SystemClock.sleep((long)l11);
                    continue;
                }
                object3 = this.e;
                n10 = (object3 = d.v.h0.k.g.d.k((d)object3)).dequeueOutputBuffer((MediaCodec.BufferInfo)(object2 = this.b), l10 = 1000L);
                if (n10 == (n11 = -2)) {
                    object2 = this.e;
                    if ((object2 = d.v.h0.k.g.d.m((d)object2)) != null) {
                        object2 = this.e;
                        object2 = d.v.h0.k.g.d.m((d)object2);
                        object4 = this.e;
                        object4 = d.v.h0.k.g.d.k((d)object4);
                        object4 = object4.getOutputFormat();
                        object2.d((MediaFormat)object4);
                        long l12 = System.nanoTime();
                        this.d = l12 /= l10;
                    }
                }
                if (n10 < 0) continue;
                object2 = this.e;
                object2 = d.v.h0.k.g.d.k((d)object2);
                object2 = object2.getOutputBuffer(n10);
                object4 = this.e;
                if ((object4 = d.v.h0.k.g.d.m((d)object4)) != null) {
                    object4 = this.b;
                    int n12 = ((MediaCodec.BufferInfo)object4).flags & 2;
                    if (n12 != 0) {
                        ((MediaCodec.BufferInfo)object4).size = 0;
                    }
                    if ((n12 = ((MediaCodec.BufferInfo)object4).size) != 0 && (n12 = (int)(this.c ? 1 : 0)) == 0) {
                        long l13 = System.nanoTime();
                        l13 /= l10;
                        l10 = this.d;
                        ((MediaCodec.BufferInfo)object4).presentationTimeUs = l13 -= l10;
                        object = this.e;
                        object = d.v.h0.k.g.d.m((d)object);
                        MediaCodec.BufferInfo bufferInfo = this.b;
                        object.a((ByteBuffer)object2, bufferInfo);
                    }
                }
                object2 = this.e;
                object2 = d.v.h0.k.g.d.k((d)object2);
                object2.releaseOutputBuffer(n10, false);
            }
            this.release();
            object3 = this.e;
            object3 = d.v.h0.k.g.d.m((d)object3);
            if (object3 == null) return;
            object3 = this.e;
            object3 = d.v.h0.k.g.d.m((d)object3);
            object3.e();
            return;
        }
        catch (Exception exception) {
            this.release();
            object2 = d.v.h0.k.g.d.m(this.e);
            if (object2 == null) return;
            object2 = d.v.h0.k.g.d.m(this.e);
            object = "\u89c6\u9891\u7f16\u7801\u5f02\u5e38";
            object2.c((String)object, exception);
        }
    }
}

