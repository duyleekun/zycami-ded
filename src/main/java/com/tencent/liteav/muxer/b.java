/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.media.MediaMuxer
 *  android.text.TextUtils
 */
package com.tencent.liteav.muxer;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.muxer.a;
import com.tencent.liteav.muxer.b$a;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b
implements a {
    public static float a = 0.5f;
    public static float b = 0.8f;
    public static float c = 1.25f;
    public static float d = 2.0f;
    private int e = 2;
    private MediaMuxer f;
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

    public b() {
        long l10;
        ConcurrentLinkedQueue concurrentLinkedQueue;
        this.n = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.o = concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.p = l10 = (long)-1;
        this.q = l10;
        this.r = l10;
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
            object2 = new b$a(byteBuffer, (MediaCodec.BufferInfo)object);
            object = "TXCMP4HWMuxer";
            if (n10 != 0) {
                Object object3 = this.n;
                n10 = ((ConcurrentLinkedQueue)object3).size();
                if (n10 < (n11 = 200)) {
                    object3 = this.n;
                    ((ConcurrentLinkedQueue)object3).add(object2);
                } else {
                    object3 = "drop video frame. video cache size is larger than 200";
                    TXCLog.e((String)object, (String)object3);
                }
            } else {
                Object object4 = this.o;
                n10 = ((ConcurrentLinkedQueue)object4).size();
                if (n10 < (n11 = 600)) {
                    object4 = this.o;
                    ((ConcurrentLinkedQueue)object4).add(object2);
                } else {
                    object4 = "drop audio frame. audio cache size is larger than 600";
                    TXCLog.e((String)object, (String)object4);
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void c(ByteBuffer byteBuffer, MediaCodec.BufferInfo object) {
        String string2;
        long l10;
        long l11;
        block10: {
            float f10;
            block12: {
                float f11;
                long l12;
                block14: {
                    block13: {
                        int n10;
                        block11: {
                            long l13;
                            l11 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
                            long l14 = this.p;
                            l11 -= l14;
                            l14 = 0L;
                            l10 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
                            string2 = "TXCMP4HWMuxer";
                            if (l10 < 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("pts error! first frame offset timeus = ");
                                long l15 = this.p;
                                stringBuilder.append(l15);
                                String string3 = ", current timeus = ";
                                stringBuilder.append(string3);
                                l15 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
                                stringBuilder.append(l15);
                                String string4 = stringBuilder.toString();
                                TXCLog.e(string2, string4);
                                l11 = this.q;
                                l10 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
                                if (l10 <= 0) {
                                    l11 = l14;
                                }
                            }
                            if ((l12 = (l13 = l11 - (l14 = this.q)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) < 0) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("video is not in chronological order. current frame's pts(");
                                stringBuilder.append(l11);
                                stringBuilder.append(") smaller than pre frame's pts(");
                                long l16 = this.q;
                                stringBuilder.append(l16);
                                String string5 = ")";
                                stringBuilder.append(string5);
                                String string6 = stringBuilder.toString();
                                TXCLog.w(string2, string6);
                            } else {
                                this.q = l11;
                            }
                            l12 = this.e;
                            n10 = 2;
                            l10 = 1;
                            if (l12 == n10) break block10;
                            n10 = 3;
                            if (l12 != n10) break block11;
                            f11 = l11;
                            f10 = b;
                            break block12;
                        }
                        n10 = 4;
                        if (l12 != n10) break block13;
                        f11 = l11;
                        f10 = a;
                        break block12;
                    }
                    if (l12 != l10) break block14;
                    f11 = l11;
                    f10 = c;
                    break block12;
                }
                if (l12 != false) break block10;
                f11 = l11;
                f10 = d;
            }
            l11 = (long)(f11 *= f10);
        }
        ((MediaCodec.BufferInfo)object).presentationTimeUs = l11;
        try {
            int n11 = ((MediaCodec.BufferInfo)object).offset;
            byteBuffer.position(n11);
            n11 = ((MediaCodec.BufferInfo)object).offset;
            int n12 = ((MediaCodec.BufferInfo)object).size;
            byteBuffer.limit(n11 += n12);
            MediaMuxer mediaMuxer = this.f;
            n12 = this.k;
            mediaMuxer.writeSampleData(n12, byteBuffer, (MediaCodec.BufferInfo)object);
            int n13 = ((MediaCodec.BufferInfo)object).flags & l10;
            if (n13 == 0) return;
            this.m = l10;
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = new StringBuilder();
            String string7 = "write frame IllegalArgumentException: ";
            ((StringBuilder)object).append(string7);
            ((StringBuilder)object).append(illegalArgumentException);
            String string8 = ((StringBuilder)object).toString();
            TXCLog.e(string2, string8);
            return;
        }
        catch (IllegalStateException illegalStateException) {
            object = new StringBuilder();
            String string9 = "write frame IllegalStateException: ";
            ((StringBuilder)object).append(string9);
            ((StringBuilder)object).append(illegalStateException);
            String string10 = ((StringBuilder)object).toString();
            TXCLog.e(string2, string10);
        }
    }

    private long d() {
        long l10;
        ConcurrentLinkedQueue concurrentLinkedQueue = this.n;
        int n10 = concurrentLinkedQueue.size();
        if (n10 > 0) {
            concurrentLinkedQueue = ((b$a)this.n.peek()).b();
            l10 = ((MediaCodec.BufferInfo)concurrentLinkedQueue).presentationTimeUs;
        } else {
            l10 = 0L;
        }
        Object object = this.o;
        int n11 = ((ConcurrentLinkedQueue)object).size();
        if (n11 > 0 && (object = (b$a)this.o.peek()) != null && (object = ((b$a)object).b()) != null) {
            object = ((b$a)this.o.peek()).b();
            long l11 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 > 0) {
                l10 = l11;
            }
        }
        return l10;
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
                                string2 = "TXCMP4HWMuxer";
                                if (l15 < 0 || (l12 = (l11 = (l10 -= l13) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) break block8;
                                l14 = this.r;
                                long l16 = l10 - l14;
                                Object object3 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                                if (object3 < 0) {
                                    StringBuilder stringBuilder = new StringBuilder();
                                    String string3 = "audio is not in chronological order. current audio's pts pts(";
                                    stringBuilder.append(string3);
                                    stringBuilder.append(l10);
                                    stringBuilder.append(") must larger than pre audio's pts(");
                                    l10 = this.r;
                                    stringBuilder.append(l10);
                                    stringBuilder.append(")");
                                    String string4 = stringBuilder.toString();
                                    TXCLog.e(string2, string4);
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
                MediaMuxer mediaMuxer = this.f;
                int n12 = this.j;
                mediaMuxer.writeSampleData(n12, (ByteBuffer)object, (MediaCodec.BufferInfo)object2);
                return;
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object2 = new StringBuilder();
                String string5 = "write sample IllegalArgumentException: ";
                ((StringBuilder)object2).append(string5);
                ((StringBuilder)object2).append(illegalArgumentException);
                String string6 = ((StringBuilder)object2).toString();
                TXCLog.e(string2, string6);
                return;
            }
            catch (IllegalStateException illegalStateException) {
                object2 = new StringBuilder();
                String string7 = "write sample IllegalStateException: ";
                ((StringBuilder)object2).append(string7);
                ((StringBuilder)object2).append(illegalStateException);
                String string8 = ((StringBuilder)object2).toString();
                TXCLog.e(string2, string8);
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

    private void e() {
        ByteBuffer byteBuffer;
        Object object;
        int n10;
        while ((n10 = ((ConcurrentLinkedQueue)(object = this.n)).size()) > 0) {
            object = (b$a)this.n.poll();
            byteBuffer = ((b$a)object).a();
            object = ((b$a)object).b();
            this.c(byteBuffer, (MediaCodec.BufferInfo)object);
        }
        while ((n10 = ((ConcurrentLinkedQueue)(object = this.o)).size()) > 0) {
            object = (b$a)this.o.poll();
            byteBuffer = ((b$a)object).a();
            object = ((b$a)object).b();
            this.d(byteBuffer, (MediaCodec.BufferInfo)object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a() {
        synchronized (this) {
            int n10;
            String string2 = this.g;
            if (string2 != null && (n10 = string2.isEmpty()) == 0) {
                long l10;
                CharSequence charSequence;
                String string3;
                block14: {
                    n10 = this.c();
                    if (n10 == 0) {
                        string2 = "TXCMP4HWMuxer";
                        String string4 = "video track not set yet!";
                        TXCLog.e(string2, string4);
                        return -2;
                    }
                    string2 = this.f;
                    string3 = null;
                    if (string2 != null) {
                        string2 = "TXCMP4HWMuxer";
                        String string5 = "start has been called. stop must be called before start";
                        TXCLog.w(string2, string5);
                        return 0;
                    }
                    string2 = "TXCMP4HWMuxer";
                    charSequence = "start";
                    TXCLog.d(string2, (String)charSequence);
                    try {
                        charSequence = this.g;
                        string2 = new MediaMuxer((String)charSequence, 0);
                        this.f = string2;
                        charSequence = this.h;
                        if (charSequence == null) break block14;
                    }
                    catch (IOException iOException) {
                        string3 = "TXCMP4HWMuxer";
                        charSequence = new StringBuilder();
                        String string6 = "create MediaMuxer exception:";
                        ((StringBuilder)charSequence).append(string6);
                        ((StringBuilder)charSequence).append(iOException);
                        String string7 = ((StringBuilder)charSequence).toString();
                        TXCLog.e(string3, string7);
                        return -4;
                    }
                    try {
                        this.k = n10 = string2.addTrack((MediaFormat)charSequence);
                    }
                    catch (IllegalStateException illegalStateException) {
                        string3 = "TXCMP4HWMuxer";
                        charSequence = new StringBuilder();
                        String string8 = "addVideoTrack IllegalStateException: ";
                        ((StringBuilder)charSequence).append(string8);
                        ((StringBuilder)charSequence).append(illegalStateException);
                        String string9 = ((StringBuilder)charSequence).toString();
                        TXCLog.e(string3, string9);
                        return -6;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        string3 = "TXCMP4HWMuxer";
                        charSequence = new StringBuilder();
                        String string10 = "addVideoTrack IllegalArgumentException: ";
                        ((StringBuilder)charSequence).append(string10);
                        ((StringBuilder)charSequence).append(illegalArgumentException);
                        String string11 = ((StringBuilder)charSequence).toString();
                        TXCLog.e(string3, string11);
                        return -5;
                    }
                }
                if ((string2 = this.i) != null) {
                    try {
                        charSequence = this.f;
                        this.j = n10 = charSequence.addTrack((MediaFormat)string2);
                    }
                    catch (IllegalStateException illegalStateException) {
                        string3 = "TXCMP4HWMuxer";
                        charSequence = new StringBuilder();
                        String string12 = "addAudioTrack IllegalStateException: ";
                        ((StringBuilder)charSequence).append(string12);
                        ((StringBuilder)charSequence).append(illegalStateException);
                        String string13 = ((StringBuilder)charSequence).toString();
                        TXCLog.e(string3, string13);
                        return -8;
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        string3 = "TXCMP4HWMuxer";
                        charSequence = new StringBuilder();
                        String string14 = "addAudioTrack IllegalArgumentException: ";
                        ((StringBuilder)charSequence).append(string14);
                        ((StringBuilder)charSequence).append(illegalArgumentException);
                        String string15 = ((StringBuilder)charSequence).toString();
                        TXCLog.e(string3, string15);
                        return -7;
                    }
                }
                string2 = this.f;
                string2.start();
                this.p = l10 = (long)-1;
                n10 = 1;
                this.l = n10;
                this.m = false;
                this.q = l10;
                this.r = l10;
                return 0;
            }
            string2 = "TXCMP4HWMuxer";
            String string16 = "target path not set yet!";
            TXCLog.e(string2, string16);
            return -1;
        }
    }

    public void a(MediaFormat object) {
        synchronized (this) {
            String string2 = "TXCMP4HWMuxer";
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
                    object2 = "TXCMP4HWMuxer";
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
                object = "TXCMP4HWMuxer";
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
                this.p = l14 = this.d();
                object = "TXCMP4HWMuxer";
                charSequence = new StringBuilder();
                object3 = "first frame offset = ";
                ((StringBuilder)charSequence).append((String)object3);
                long l15 = this.p;
                ((StringBuilder)charSequence).append(l15);
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.d((String)object, (String)charSequence);
                this.e();
            } else {
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
                    object = "TXCMP4HWMuxer";
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
                        object2.stop();
                    }
                    object2 = this.f;
                    object2.release();
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
                        String string3 = "TXCMP4HWMuxer";
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
            String string2 = "TXCMP4HWMuxer";
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
            long l10;
            long l11;
            Object object;
            block11: {
                object = this.f;
                if (object == null) break block11;
                long l12 = this.p;
                l11 = 0L;
                l10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                if (l10 < 0) break block11;
                this.d(byteBuffer, bufferInfo);
                return;
            }
            object = "TXCMP4HWMuxer";
            CharSequence charSequence = new StringBuilder();
            String string2 = "cache sample before muexer ready. ptsUs: ";
            charSequence.append(string2);
            l11 = bufferInfo.presentationTimeUs;
            charSequence.append(l11);
            charSequence = charSequence.toString();
            TXCLog.d((String)object, (String)charSequence);
            l10 = 0;
            object = null;
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

