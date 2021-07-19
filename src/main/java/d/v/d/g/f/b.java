/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 */
package d.v.d.g.f;

import android.media.MediaCodec;
import android.media.MediaFormat;
import d.v.d.g.f.b$a;
import d.v.d.h.f;
import java.io.IOException;
import java.nio.ByteBuffer;

public class b {
    private int a;
    private int b;
    private int c;
    private int d;
    private MediaCodec e;
    private b$a f;
    private MediaFormat g;
    private final MediaCodec.BufferInfo h;
    public final Object i;

    public b() {
        Object object;
        this.i = object = new Object();
        object = new MediaCodec.BufferInfo();
        this.h = object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] object) {
        Object object2 = this.i;
        synchronized (object2) {
            int n10;
            Object object3 = this.e;
            if (object3 == null) {
                return;
            }
            long l10 = 10000L;
            int n11 = object3.dequeueInputBuffer(l10);
            if (n11 != (n10 = -1)) {
                Object object4 = this.e;
                object4 = object4.getInputBuffer(n11);
                ((ByteBuffer)object4).put((byte[])object);
                object4 = this.e;
                int n12 = ((byte[])object).length;
                long l11 = System.nanoTime();
                long l12 = 1000L;
                object4.queueInputBuffer(n11, 0, n12, l11 /= l12, 0);
                object = this.e;
                object4 = this.h;
                int n13 = object.dequeueOutputBuffer((MediaCodec.BufferInfo)object4, l10);
                Object object5 = this.h;
                long l13 = System.nanoTime();
                ((MediaCodec.BufferInfo)object5).presentationTimeUs = l13 /= l12;
                if (n13 != n10) {
                    n10 = -2;
                    if (n13 == n10) {
                        object = this.e;
                        object = object.getOutputFormat();
                        this.g = (MediaFormat)object;
                        object3 = this.f;
                        if (object3 != null) {
                            object3.b((MediaFormat)object);
                        }
                    } else {
                        object3 = this.e;
                        object3 = object3.getOutputBuffer(n13);
                        object5 = this.f;
                        if (object5 != null) {
                            MediaCodec.BufferInfo bufferInfo = this.h;
                            object5.a((ByteBuffer)object3, bufferInfo);
                        }
                        object3 = this.e;
                        object5 = null;
                        object3.releaseOutputBuffer(n13, false);
                    }
                }
            }
            return;
        }
    }

    public MediaFormat b() {
        return this.g;
    }

    public void c() {
        int n10;
        int n11;
        int n12 = this.a;
        if (n12 > 0 && (n11 = this.b) > 0 && (n10 = this.c) > 0 && (n10 = this.d) > 0) {
            String string2 = "audio/mp4a-latm";
            MediaFormat mediaFormat = MediaFormat.createAudioFormat((String)string2, (int)n12, (int)n11);
            n11 = this.d;
            mediaFormat.setInteger("max-input-size", n11);
            n11 = this.c;
            mediaFormat.setInteger("bitrate", n11);
            n11 = 17;
            String string3 = "aac-profile";
            mediaFormat.setInteger(string3, n11);
            Object object = MediaCodec.createEncoderByType((String)string2);
            this.e = object;
            n10 = 1;
            string3 = null;
            try {
                object.configure(mediaFormat, null, null, n10);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
                object = new StringBuilder();
                string2 = "prepare failed e=";
                ((StringBuilder)object).append(string2);
                String string4 = iOException.toString();
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                d.v.d.h.f.a(string4);
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("\u8bf7\u68c0\u67e5\u97f3\u9891\u53c2\u6570 !!! ");
        throw illegalStateException;
    }

    public void d(int n10) {
        this.c = n10;
    }

    public void e(int n10) {
        this.d = n10;
    }

    public void f(b$a b$a) {
        this.f = b$a;
    }

    public void g(int n10) {
        this.b = n10;
    }

    public void h(int n10) {
        this.a = n10;
    }

    public void i() {
        MediaCodec mediaCodec = this.e;
        if (mediaCodec != null) {
            d.v.d.h.f.a("start audio encoder");
            mediaCodec = this.e;
            mediaCodec.start();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void j() {
        Object object = this.i;
        synchronized (object) {
            Object object2 = this.e;
            if (object2 != null) {
                object2 = "stop audio encoder";
                d.v.d.h.f.a((String)object2);
                object2 = this.e;
                object2.stop();
                object2 = this.e;
                object2.release();
                object2 = null;
                this.e = null;
                this.f = null;
            }
            return;
        }
    }
}

