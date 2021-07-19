/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.SystemClock
 */
package d.v.h0.k.g;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.SystemClock;
import d.v.h0.k.c;
import d.v.h0.k.g.a;
import d.v.h0.k.g.b;
import d.v.h0.k.g.b$a;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class b$b
implements c {
    public final long a;
    public MediaCodec.BufferInfo b;
    private boolean c;
    public long d;
    public final /* synthetic */ b e;

    private b$b(b b10) {
        this.e = b10;
        this.a = 1000L;
        this.b = b10;
    }

    public /* synthetic */ b$b(b b10, b$a b$a) {
        this(b10);
    }

    public void n() {
        this.c = true;
    }

    public void release() {
        Object object = d.v.h0.k.g.b.k(this.e);
        if (object != null) {
            d.v.h0.k.g.b.k(this.e).release();
            object = this.e;
            d.v.h0.k.g.b.l((b)object, null);
        }
        d.v.h0.k.g.b.m(this.e).clear();
        this.e.d(false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string2;
        Object object;
        Object object2 = d.v.h0.k.g.b.k(this.e);
        if (object2 == null) {
            return;
        }
        try {
            boolean bl2;
            while (!(bl2 = this.c)) {
                Object object3;
                int n10;
                int n11;
                Object object4;
                Object object5;
                object2 = this.e;
                object2 = ((a)object2).a;
                bl2 = ((AtomicBoolean)object2).get();
                if (bl2) {
                    long l10 = 2;
                    SystemClock.sleep((long)l10);
                    continue;
                }
                object2 = this.e;
                object2 = d.v.h0.k.g.b.k((b)object2);
                long l11 = 1000L;
                int n12 = object2.dequeueInputBuffer(l11);
                bl2 = false;
                object2 = null;
                if (n12 >= 0) {
                    object5 = this.e;
                    object5 = d.v.h0.k.g.b.k((b)object5);
                    object5 = object5.getInputBuffer(n12);
                    object4 = this.e;
                    object4 = d.v.h0.k.g.b.m((b)object4);
                    object4 = ((ConcurrentLinkedQueue)object4).poll();
                    n11 = (object4 = (Object)((byte[])object4)) == null ? 0 : ((Object)object4).length;
                    if (object5 != null && n11 > 0) {
                        ((ByteBuffer)object5).put((byte[])object4);
                    }
                    object5 = this.e;
                    object5 = d.v.h0.k.g.b.k((b)object5);
                    n10 = 0;
                    object4 = null;
                    long l12 = System.nanoTime();
                    object5.queueInputBuffer(n12, 0, n11, l12 /= l11, 0);
                }
                object5 = this.e;
                int n13 = (object5 = d.v.h0.k.g.b.k((b)object5)).dequeueOutputBuffer(object3 = this.b, l11);
                if (n13 == (n12 = -2)) {
                    object3 = this.e;
                    object3 = d.v.h0.k.g.b.k((b)object3);
                    object3 = object3.getOutputFormat();
                    object4 = this.e;
                    if ((object4 = d.v.h0.k.g.b.n((b)object4)) != null) {
                        object4 = this.e;
                        object4 = d.v.h0.k.g.b.n((b)object4);
                        object4.d((MediaFormat)object3);
                        long l13 = System.nanoTime();
                        this.d = l13 /= l11;
                    }
                }
                if (n13 < 0) continue;
                object3 = this.e;
                object3 = d.v.h0.k.g.b.k((b)object3);
                object3 = object3.getOutputBuffer(n13);
                object4 = this.b;
                n10 = ((MediaCodec.BufferInfo)object4).flags & 4;
                if (n10 != 0) {
                    boolean bl3;
                    this.c = bl3 = true;
                } else {
                    object4 = this.e;
                    if ((object4 = d.v.h0.k.g.b.n((b)object4)) != null) {
                        object4 = this.b;
                        n11 = ((MediaCodec.BufferInfo)object4).flags & 2;
                        if (n11 != 0) {
                            ((MediaCodec.BufferInfo)object4).size = 0;
                        }
                        if ((n11 = ((MediaCodec.BufferInfo)object4).size) != 0 && (n11 = (int)(this.c ? 1 : 0)) == 0) {
                            long l14 = System.nanoTime();
                            l14 /= l11;
                            l11 = this.d;
                            ((MediaCodec.BufferInfo)object4).presentationTimeUs = l14 -= l11;
                            object = this.e;
                            object = d.v.h0.k.g.b.n((b)object);
                            string2 = this.b;
                            object.a((ByteBuffer)object3, (MediaCodec.BufferInfo)string2);
                        }
                    }
                }
                object = this.e;
                object = d.v.h0.k.g.b.k((b)object);
                object.releaseOutputBuffer(n13, false);
            }
            this.release();
            object2 = this.e;
            object2 = d.v.h0.k.g.b.n((b)object2);
            if (object2 == null) return;
            object2 = this.e;
            object2 = d.v.h0.k.g.b.n((b)object2);
            object2.e();
            return;
        }
        catch (Exception exception) {
            this.release();
            object = d.v.h0.k.g.b.n(this.e);
            if (object == null) return;
            object = d.v.h0.k.g.b.n(this.e);
            string2 = "\u89c6\u9891\u7f16\u7801\u5f02\u5e38";
            object.c(string2, exception);
        }
    }
}

