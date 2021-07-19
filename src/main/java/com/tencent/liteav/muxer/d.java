/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.text.TextUtils
 */
package com.tencent.liteav.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.a;
import com.tencent.liteav.muxer.d$a;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI;
import com.tencent.liteav.muxer.jni.TXSWMuxerJNI$AVOptions;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.AbstractQueue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d
implements a {
    public static float a = 0.5f;
    public static float b = 0.8f;
    public static float c = 1.25f;
    public static float d = 2.0f;
    private int e = 2;
    private TXSWMuxerJNI f;
    private String g = null;
    private MediaFormat h = null;
    private MediaFormat i = null;
    private int j = 0;
    private int k = 0;
    private boolean l = false;
    private boolean m = false;
    private ConcurrentLinkedQueue n;
    private ConcurrentLinkedQueue o;
    private long p;
    private long q;
    private long r;

    public d() {
        long l10;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.n = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.o = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.p = l10 = (long)-1;
        this.q = l10;
        this.r = l10;
    }

    private void a(long l10) {
        Object object;
        int n10;
        while ((n10 = ((ConcurrentLinkedQueue)(object = this.o)).size()) > 0) {
            Object object2;
            object = ((d$a)this.o.peek()).b();
            if (object == null) {
                object2 = "flushAudioCache, bufferInfo is null";
                TXCLog.e("TXCMP4SWMuxer", (String)object2);
                object = this.o;
                ((AbstractQueue)object).remove();
                continue;
            }
            object = ((d$a)this.o.peek()).b();
            long l11 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 >= 0) break;
            object = (d$a)this.o.poll();
            object2 = ((d$a)object).a();
            object = ((d$a)object).b();
            this.d((ByteBuffer)object2, (MediaCodec.BufferInfo)object);
        }
    }

    private void a(boolean n10, ByteBuffer object, MediaCodec.BufferInfo object2) {
        if (object != null && object2 != null) {
            int n11 = ((Buffer)object).capacity();
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n11);
            ((ByteBuffer)object).rewind();
            int n12 = object2.size;
            if (n12 > 0) {
                n12 = object2.offset;
                ((ByteBuffer)object).position(n12);
                n12 = object2.size;
                ((ByteBuffer)object).limit(n12);
            }
            byteBuffer.rewind();
            byteBuffer.put((ByteBuffer)object);
            object = new MediaCodec.BufferInfo();
            int n13 = object2.offset;
            int n14 = object2.size;
            long l10 = object2.presentationTimeUs;
            int n15 = object2.flags;
            object.set(n13, n14, l10, n15);
            object2 = new d$a(byteBuffer, (MediaCodec.BufferInfo)object);
            if (n10 != 0) {
                int n16;
                Object object3 = this.n;
                n10 = ((ConcurrentLinkedQueue)object3).size();
                if (n10 < (n16 = 200)) {
                    object3 = this.n;
                    ((ConcurrentLinkedQueue)object3).add(object2);
                } else {
                    object3 = "TXCMP4SWMuxer";
                    object = "drop video frame. video cache size is larger than 200";
                    TXCLog.e((String)object3, (String)object);
                }
            } else {
                ConcurrentLinkedQueue concurrentLinkedQueue = this.o;
                concurrentLinkedQueue.add(object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        float f10;
        int n10;
        int n11;
        long l10;
        Object object;
        Object object2;
        String string2;
        long l11;
        long l12;
        block12: {
            block14: {
                float f11;
                block16: {
                    block15: {
                        block13: {
                            long l13;
                            l12 = bufferInfo.presentationTimeUs;
                            long l14 = this.p;
                            l12 -= l14;
                            l14 = 0L;
                            l11 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
                            string2 = "TXCMP4SWMuxer";
                            if (l11 < 0) {
                                object2 = new StringBuilder();
                                ((StringBuilder)object2).append("pts error! first frame offset timeus = ");
                                long l15 = this.p;
                                ((StringBuilder)object2).append(l15);
                                object = ", current timeus = ";
                                ((StringBuilder)object2).append((String)object);
                                l15 = bufferInfo.presentationTimeUs;
                                ((StringBuilder)object2).append(l15);
                                object2 = ((StringBuilder)object2).toString();
                                TXCLog.e(string2, (String)object2);
                                l12 = this.q;
                                l11 = l12 == l14 ? 0 : (l12 < l14 ? -1 : 1);
                                if (l11 <= 0) {
                                    l12 = l14;
                                }
                            }
                            if ((l10 = (l13 = l12 - (l14 = this.q)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("video is not in chronological order. current frame's pts(");
                                stringBuilder.append(l12);
                                stringBuilder.append(") smaller than pre frame's pts(");
                                long l16 = this.q;
                                stringBuilder.append(l16);
                                String string3 = ")";
                                stringBuilder.append(string3);
                                String string4 = stringBuilder.toString();
                                TXCLog.w(string2, string4);
                            } else {
                                this.q = l12;
                            }
                            l10 = this.e;
                            n11 = 2;
                            n10 = 1;
                            if (l10 == n11) break block12;
                            n11 = 3;
                            if (l10 != n11) break block13;
                            f11 = l12;
                            f10 = b;
                            break block14;
                        }
                        n11 = 4;
                        if (l10 != n11) break block15;
                        f11 = l12;
                        f10 = a;
                        break block14;
                    }
                    if (l10 != n10) break block16;
                    f11 = l12;
                    f10 = c;
                    break block14;
                }
                if (l10 != false) break block12;
                f11 = l12;
                f10 = d;
            }
            l12 = (long)(f11 *= f10);
        }
        bufferInfo.presentationTimeUs = l12;
        try {
            int n12;
            int n13 = bufferInfo.offset;
            byteBuffer.position(n13);
            n13 = bufferInfo.offset;
            int n14 = bufferInfo.size;
            byteBuffer.limit(n13 += n14);
            object2 = this.f;
            l10 = 1;
            n11 = bufferInfo.offset;
            l11 = bufferInfo.size;
            n14 = bufferInfo.flags;
            if (n14 == n10) {
                n12 = n10;
            } else {
                n14 = 0;
                f10 = 0.0f;
                object = null;
                n12 = 0;
            }
            long l17 = bufferInfo.presentationTimeUs;
            object = byteBuffer;
            ((TXSWMuxerJNI)object2).a(byteBuffer, (int)l10, n11, (int)l11, n12, l17);
            int n15 = bufferInfo.flags & n10;
            if (n15 == 0) return;
            this.m = n10;
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object2 = new StringBuilder();
            object = "write frame IllegalArgumentException: ";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(illegalArgumentException);
            String string5 = ((StringBuilder)object2).toString();
            TXCLog.e(string2, string5);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            object2 = new StringBuilder();
            object = "write frame IllegalStateException: ";
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(illegalStateException);
            String string6 = ((StringBuilder)object2).toString();
            TXCLog.e(string2, string6);
        }
    }

    private ByteBuffer d() {
        Object object = this.i;
        String string2 = "csd-0";
        if ((object = object.getByteBuffer(string2)) != null) {
            string2 = null;
            ((ByteBuffer)object).position(0);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d(ByteBuffer object, MediaCodec.BufferInfo object2) {
        String string2;
        long l10;
        block8: {
            String string3;
            Object object3;
            block9: {
                float f10;
                block11: {
                    float f11;
                    int n10;
                    block13: {
                        int n11;
                        block12: {
                            block10: {
                                long l11;
                                long l12;
                                l10 = ((MediaCodec.BufferInfo)object2).presentationTimeUs;
                                long l13 = this.p;
                                long l14 = 0L;
                                long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
                                string2 = "TXCMP4SWMuxer";
                                if (l15 < 0 || (l12 = (l11 = (l10 -= l13) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) break block8;
                                l14 = this.r;
                                long l16 = l10 - l14;
                                Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                if (object4 < 0) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    object3 = "audio is not in chronological order. current audio's pts pts(";
                                    stringBuilder.append((String)object3);
                                    stringBuilder.append(l10);
                                    stringBuilder.append(") must larger than pre audio's pts(");
                                    l10 = this.r;
                                    stringBuilder.append(l10);
                                    stringBuilder.append(")");
                                    string3 = stringBuilder.toString();
                                    TXCLog.e(string2, string3);
                                    l10 = this.r;
                                    l14 = 1L;
                                    l10 += l14;
                                } else {
                                    this.r = l10;
                                }
                                n10 = this.e;
                                n11 = 2;
                                if (n10 == n11) break block9;
                                n11 = 3;
                                if (n10 != n11) break block10;
                                f11 = l10;
                                f10 = b;
                                break block11;
                            }
                            n11 = 4;
                            if (n10 != n11) break block12;
                            f11 = l10;
                            f10 = a;
                            break block11;
                        }
                        n11 = 1;
                        if (n10 != n11) break block13;
                        f11 = l10;
                        f10 = c;
                        break block11;
                    }
                    if (n10 != 0) break block9;
                    f11 = l10;
                    f10 = d;
                }
                l10 = (long)(f11 *= f10);
            }
            ((MediaCodec.BufferInfo)object2).presentationTimeUs = l10;
            try {
                int n12 = ((MediaCodec.BufferInfo)object2).offset;
                ((ByteBuffer)object).position(n12);
                n12 = ((MediaCodec.BufferInfo)object2).offset;
                int n13 = ((MediaCodec.BufferInfo)object2).size;
                ((ByteBuffer)object).limit(n12 += n13);
                object3 = this.f;
                int n14 = ((MediaCodec.BufferInfo)object2).offset;
                int n15 = ((MediaCodec.BufferInfo)object2).size;
                int n16 = ((MediaCodec.BufferInfo)object2).flags;
                long l17 = ((MediaCodec.BufferInfo)object2).presentationTimeUs;
                ((TXSWMuxerJNI)object3).a((ByteBuffer)object, 0, n14, n15, n16, l17);
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = new StringBuilder();
                string3 = "write sample IllegalArgumentException: ";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(illegalArgumentException);
                String string4 = ((StringBuilder)object2).toString();
                TXCLog.e(string2, string4);
                return;
            }
            catch (IllegalStateException illegalStateException) {
                object2 = new StringBuilder();
                string3 = "write sample IllegalStateException: ";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(illegalStateException);
                String string5 = ((StringBuilder)object2).toString();
                TXCLog.e(string2, string5);
            }
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("drop sample. first frame offset timeus = ");
        l10 = this.p;
        ((StringBuilder)object).append(l10);
        ((StringBuilder)object).append(", current sample timeus = ");
        l10 = ((MediaCodec.BufferInfo)object2).presentationTimeUs;
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        TXCLog.w(string2, (String)object);
    }

    private ByteBuffer e() {
        return this.h.getByteBuffer("csd-0");
    }

    private ByteBuffer f() {
        return this.h.getByteBuffer("csd-1");
    }

    private long g() {
        long l10;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.n;
        int n10 = concurrentLinkedQueue.size();
        if (n10 > 0) {
            concurrentLinkedQueue = ((d$a)this.n.peek()).b();
            l10 = ((MediaCodec.BufferInfo)concurrentLinkedQueue).presentationTimeUs;
        } else {
            l10 = 0L;
        }
        Object object = this.o;
        int n11 = ((ConcurrentLinkedQueue)object).size();
        if (n11 > 0 && (object = (d$a)this.o.peek()) != null && (object = ((d$a)object).b()) != null) {
            object = ((d$a)this.o.peek()).b();
            long l11 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                l10 = l11;
            }
        }
        return l10;
    }

    private void h() {
        ByteBuffer byteBuffer;
        Object object;
        int n10;
        while ((n10 = ((ConcurrentLinkedQueue)(object = this.n)).size()) > 0) {
            object = (d$a)this.n.poll();
            byteBuffer = ((d$a)object).a();
            object = ((d$a)object).b();
            this.c(byteBuffer, (MediaCodec.BufferInfo)object);
        }
        while ((n10 = ((ConcurrentLinkedQueue)(object = this.o)).size()) > 0) {
            object = (d$a)this.o.poll();
            byteBuffer = ((d$a)object).a();
            object = ((d$a)object).b();
            this.d(byteBuffer, (MediaCodec.BufferInfo)object);
        }
    }

    private void i() {
        Object object;
        int n10;
        while ((n10 = ((ConcurrentLinkedQueue)(object = this.n)).size()) > 0) {
            object = (d$a)this.n.poll();
            long l10 = object.b().presentationTimeUs;
            this.a(l10);
            ByteBuffer byteBuffer = ((d$a)object).a();
            object = ((d$a)object).b();
            this.c(byteBuffer, (MediaCodec.BufferInfo)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a() {
        synchronized (this) {
            boolean bl2;
            Object object = this.g;
            if (object != null && !(bl2 = ((String)object).isEmpty())) {
                int n10;
                Object object2;
                int n11;
                Object object3;
                bl2 = this.c();
                if (!bl2) {
                    object = "TXCMP4SWMuxer";
                    String string2 = "video track not set yet!";
                    TXCLog.e((String)object, string2);
                    return -2;
                }
                object = this.f;
                String string3 = null;
                if (object != null) {
                    object = "TXCMP4SWMuxer";
                    String string4 = "start has been called. stop must be called before start";
                    TXCLog.w((String)object, string4);
                    return 0;
                }
                object = "TXCMP4SWMuxer";
                Object object4 = "start";
                TXCLog.d((String)object, (String)object4);
                this.f = object = new TXSWMuxerJNI();
                object = new TXSWMuxerJNI$AVOptions();
                object4 = this.h;
                if (object4 != null) {
                    object3 = "width";
                    n11 = object4.getInteger((String)object3);
                    object3 = this.h;
                    object2 = "height";
                    ((TXSWMuxerJNI$AVOptions)object).videoHeight = n10 = object3.getInteger((String)object2);
                    ((TXSWMuxerJNI$AVOptions)object).videoWidth = n11;
                    object4 = this.h;
                    object3 = "i-frame-interval";
                    n11 = (int)(object4.containsKey((String)object3) ? 1 : 0);
                    if (n11 != 0) {
                        object4 = this.h;
                        object3 = "i-frame-interval";
                        n11 = object4.getInteger((String)object3);
                    } else {
                        n11 = 3;
                    }
                    ((TXSWMuxerJNI$AVOptions)object).videoGOP = n11;
                }
                if ((object4 = this.i) != null) {
                    object3 = "channel-count";
                    n11 = object4.getInteger((String)object3);
                    object3 = this.i;
                    object2 = "sample-rate";
                    n10 = object3.getInteger((String)object2);
                    ((TXSWMuxerJNI$AVOptions)object).audioChannels = n11;
                    ((TXSWMuxerJNI$AVOptions)object).audioSampleRate = n10;
                }
                object4 = this.e();
                object3 = this.f();
                object2 = null;
                Object object5 = this.i;
                if (object5 != null) {
                    object2 = this.d();
                }
                int n12 = -3;
                if (object4 != null && object3 != null) {
                    long l10;
                    MediaFormat mediaFormat = this.i;
                    if (mediaFormat != null && object2 == null) {
                        object = "TXCMP4SWMuxer";
                        string3 = "audio format contains error csd!";
                        TXCLog.e((String)object, string3);
                        return n12;
                    }
                    object5 = this.f;
                    int n13 = ((Buffer)object4).capacity();
                    int n14 = ((Buffer)object3).capacity();
                    ((TXSWMuxerJNI)object5).a((ByteBuffer)object4, n13, (ByteBuffer)object3, n14);
                    object4 = this.i;
                    if (object4 != null) {
                        object4 = this.f;
                        n10 = ((Buffer)object2).capacity();
                        ((TXSWMuxerJNI)object4).a((ByteBuffer)object2, n10);
                    }
                    object4 = this.f;
                    ((TXSWMuxerJNI)object4).a((TXSWMuxerJNI$AVOptions)object);
                    object = this.f;
                    object4 = this.g;
                    ((TXSWMuxerJNI)object).a((String)object4);
                    object = this.f;
                    ((TXSWMuxerJNI)object).a();
                    this.p = l10 = (long)-1;
                    this.l = bl2 = true;
                    this.m = false;
                    this.q = l10;
                    this.r = l10;
                    return 0;
                }
                object = "TXCMP4SWMuxer";
                string3 = "video format contains error csd!";
                TXCLog.e((String)object, string3);
                return n12;
            }
            object = "TXCMP4SWMuxer";
            String string5 = "target path not set yet!";
            TXCLog.e((String)object, string5);
            return -1;
        }
    }

    public void a(MediaFormat object) {
        synchronized (this) {
            String string2 = "TXCMP4SWMuxer";
            CharSequence charSequence = new StringBuilder();
            String string3 = "addVideoTrack:";
            charSequence.append(string3);
            charSequence.append(object);
            charSequence = charSequence.toString();
            TXCLog.d(string2, (String)charSequence);
            this.h = object;
            object = this.n;
            ((ConcurrentLinkedQueue)object).clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String object) {
        synchronized (this) {
            this.g = object;
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (!bl2) {
                boolean bl3;
                Object object2 = this.g;
                object = new File((String)object2);
                boolean bl4 = ((File)(object2 = ((File)object).getParentFile())).exists();
                if (!bl4) {
                    ((File)object2).mkdirs();
                }
                if (bl3 = ((File)object).exists()) {
                    ((File)object).delete();
                }
                try {
                    ((File)object).createNewFile();
                }
                catch (IOException iOException) {
                    object2 = "TXCMP4SWMuxer";
                    String string2 = "create new file failed.";
                    TXCLog.e((String)object2, string2, iOException);
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(ByteBuffer object, MediaCodec.BufferInfo object2) {
        synchronized (this) {
            CharSequence charSequence;
            Object object3 = this.f;
            boolean bl2 = true;
            if (object3 == null) {
                this.a(bl2, (ByteBuffer)object, (MediaCodec.BufferInfo)charSequence);
                object = "TXCMP4SWMuxer";
                object3 = new StringBuilder();
                String string2 = "cache frame before muexer ready. ptsUs: ";
                ((StringBuilder)object3).append(string2);
                long l10 = ((MediaCodec.BufferInfo)charSequence).presentationTimeUs;
                ((StringBuilder)object3).append(l10);
                charSequence = ((StringBuilder)object3).toString();
                TXCLog.w((String)object, (String)charSequence);
                return;
            }
            long l11 = this.p;
            long l12 = 0L;
            long l13 = l11 - l12;
            Object object4 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object4 < 0) {
                long l14;
                this.a(bl2, (ByteBuffer)object, (MediaCodec.BufferInfo)charSequence);
                this.p = l14 = this.g();
                object = "TXCMP4SWMuxer";
                charSequence = new StringBuilder();
                object3 = "first frame offset = ";
                ((StringBuilder)charSequence).append((String)object3);
                long l15 = this.p;
                ((StringBuilder)charSequence).append(l15);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.d((String)object, (String)charSequence);
                this.i();
            } else {
                long l16 = ((MediaCodec.BufferInfo)charSequence).presentationTimeUs;
                this.a(l16);
                this.c((ByteBuffer)object, (MediaCodec.BufferInfo)charSequence);
            }
            return;
        }
    }

    public void a(byte[] object, int n10, int n11, long l10, int n12) {
        synchronized (this) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n11);
            byteBuffer.put((byte[])object, n10, n11);
            object = new MediaCodec.BufferInfo;
            object();
            object.presentationTimeUs = l10;
            n10 = 0;
            object.offset = 0;
            object.size = n11;
            object.flags = n12;
            this.b(byteBuffer, (MediaCodec.BufferInfo)object);
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int b() {
        synchronized (this) {
            block10: {
                Object object = this.f;
                ConcurrentLinkedQueue concurrentLinkedQueue = null;
                if (object != null) {
                    Throwable throwable2222222;
                    Object object2;
                    this.h();
                    object = "TXCMP4SWMuxer";
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "stop. start flag = ";
                    charSequence.append(string2);
                    boolean bl2 = this.l;
                    charSequence.append(bl2);
                    string2 = ", video key frame set = ";
                    charSequence.append(string2);
                    bl2 = this.m;
                    charSequence.append(bl2);
                    charSequence = charSequence.toString();
                    TXCLog.d((String)object, (String)charSequence);
                    long l10 = -1;
                    object = null;
                    boolean bl3 = this.l;
                    if (bl3 && (bl3 = this.m)) {
                        object2 = this.f;
                        ((TXSWMuxerJNI)object2).b();
                    }
                    object2 = this.f;
                    ((TXSWMuxerJNI)object2).c();
                    this.f = null;
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    object2 = this.n;
                    ((ConcurrentLinkedQueue)object2).clear();
                    object2 = this.o;
                    ((ConcurrentLinkedQueue)object2).clear();
                    this.h = null;
                    this.i = null;
                    this.q = l10;
                    this.r = l10;
                    break block10;
                    {
                        int n10;
                        catch (Throwable throwable2222222) {
                        }
                        catch (Exception exception) {}
                        String string3 = "TXCMP4SWMuxer";
                        {
                            StringBuilder stringBuilder = new StringBuilder();
                            String string4 = "muxer stop/release exception: ";
                            stringBuilder.append(string4);
                            stringBuilder.append(exception);
                            String string5 = stringBuilder.toString();
                            TXCLog.e(string3, string5);
                            n10 = -1;
                            this.l = false;
                            this.f = null;
                            this.m = false;
                            concurrentLinkedQueue = this.n;
                            concurrentLinkedQueue.clear();
                            concurrentLinkedQueue = this.o;
                            concurrentLinkedQueue.clear();
                            this.h = null;
                            this.i = null;
                            this.q = l10;
                            this.r = l10;
                        }
                        return n10;
                    }
                    this.l = false;
                    this.f = null;
                    this.m = false;
                    concurrentLinkedQueue = this.n;
                    concurrentLinkedQueue.clear();
                    concurrentLinkedQueue = this.o;
                    concurrentLinkedQueue.clear();
                    this.h = null;
                    this.i = null;
                    this.q = l10;
                    this.r = l10;
                    throw throwable2222222;
                }
            }
            return 0;
        }
    }

    public void b(MediaFormat object) {
        synchronized (this) {
            String string2 = "TXCMP4SWMuxer";
            CharSequence charSequence = new StringBuilder();
            String string3 = "addAudioTrack:";
            charSequence.append(string3);
            charSequence.append(object);
            charSequence = charSequence.toString();
            TXCLog.d(string2, (String)charSequence);
            this.i = object;
            object = this.o;
            ((ConcurrentLinkedQueue)object).clear();
            return;
        }
    }

    public void b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this) {
            this.a(false, byteBuffer, bufferInfo);
            return;
        }
    }

    public void b(byte[] object, int n10, int n11, long l10, int n12) {
        synchronized (this) {
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(n11);
            byteBuffer.put((byte[])object, n10, n11);
            object = new MediaCodec.BufferInfo;
            object();
            object.presentationTimeUs = l10;
            n10 = 0;
            object.offset = 0;
            object.size = n11;
            object.flags = n12;
            this.a(byteBuffer, (MediaCodec.BufferInfo)object);
            return;
        }
    }

    public boolean c() {
        synchronized (this) {
            block3: {
                MediaFormat mediaFormat = this.h;
                if (mediaFormat == null) break block3;
                return true;
            }
            return false;
        }
    }
}

