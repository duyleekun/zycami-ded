/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.media.MediaMuxer
 *  android.os.SystemClock
 *  android.util.Log
 */
package d.u.a;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.SystemClock;
import android.util.Log;
import com.zhishen.imagetool.ImagePixelBuffer;
import d.u.a.a;
import d.u.a.c$a;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class c {
    private Thread a = null;
    private MediaCodec.BufferInfo b;
    private ReentrantLock c;
    private final Semaphore d;
    private MediaMuxer e;
    public MediaCodec f;
    private int g;
    private boolean h;
    private int i;
    private boolean j;
    public int k;
    public int l;
    public String m;
    public int n;
    public boolean o;
    public boolean p;
    private boolean q;
    public List r;

    public c(int n10, int n11, int n12, String string2) {
        ArrayList arrayList;
        int n13;
        Serializable serializable;
        this.c = serializable = new ReentrantLock();
        boolean bl2 = true;
        super((int)(bl2 ? 1 : 0), bl2);
        this.d = serializable;
        this.f = null;
        this.g = n13 = -1;
        this.h = false;
        this.i = n13;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.n = 2135033992;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = arrayList = new ArrayList();
        this.n = n12;
        this.m = string2;
        this.c(n10, n11, n12);
    }

    public c(String string2) {
        ArrayList arrayList;
        int n10;
        Serializable serializable;
        this.c = serializable = new ReentrantLock();
        boolean bl2 = true;
        super((int)(bl2 ? 1 : 0), bl2);
        this.d = serializable;
        this.f = null;
        this.g = n10 = -1;
        this.h = false;
        this.i = n10;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.n = 2135033992;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = arrayList = new ArrayList();
        this.m = string2;
        this.d();
    }

    public c(String string2, int n10) {
        ArrayList arrayList;
        int n11;
        Serializable serializable;
        this.c = serializable = new ReentrantLock();
        boolean bl2 = true;
        super((int)(bl2 ? 1 : 0), bl2);
        this.d = serializable;
        this.f = null;
        this.g = n11 = -1;
        this.h = false;
        this.i = n11;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.n = 2135033992;
        this.o = false;
        this.p = false;
        this.q = false;
        this.r = arrayList = new ArrayList();
        this.n = n10;
        this.m = string2;
        this.d();
    }

    private void d() {
        block8: {
            Object object = this.e;
            if (object != null) {
                return;
            }
            object = this.m;
            if (object != null) {
                String string2 = this.m;
                object = new File(string2);
                boolean bl2 = ((File)object).exists();
                if (bl2) {
                    ((File)object).delete();
                }
                string2 = this.m;
                object = new MediaMuxer(string2, 0);
                try {
                    this.e = object;
                }
                catch (IOException iOException) {
                    iOException.printStackTrace();
                    object = this.e;
                    if (object == null) break block8;
                    object.release();
                    object = null;
                    this.e = null;
                }
            }
        }
    }

    private void e() {
        int n10 = this.k;
        int n11 = this.l;
        int n12 = this.n;
        this.c(n10, n11, n12);
    }

    public boolean a(MediaFormat mediaFormat, int n10) {
        int n11;
        int n12;
        int n13;
        block9: {
            MediaMuxer mediaMuxer = this.e;
            n13 = 0;
            if (mediaMuxer == null) {
                return false;
            }
            n12 = this.g;
            if (n12 >= 0 && n10 == 0) {
                return false;
            }
            n12 = this.i;
            if (n12 >= 0 && n10 != 0) {
                return false;
            }
            n12 = 1;
            if (mediaFormat != null) {
                try {
                    n13 = mediaMuxer.addTrack(mediaFormat);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    n13 = -1;
                    n11 = 0;
                    mediaFormat = null;
                    break block9;
                }
            }
            n11 = n12;
        }
        if (n10 == 0) {
            this.h = n12;
            this.g = n13;
        } else {
            this.j = n12;
            this.i = n13;
        }
        n10 = (int)(this.h ? 1 : 0);
        if (n10 != 0 && (n10 = (int)(this.j ? 1 : 0)) != 0) {
            MediaMuxer mediaMuxer = this.e;
            mediaMuxer.start();
            this.o = n12;
        }
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        int n10;
        ByteBuffer[] byteBufferArray = this.f;
        if (byteBufferArray == null) return;
        Object object = this.e;
        if (object == null) {
            return;
        }
        byteBufferArray = byteBufferArray.getOutputBuffers();
        while ((n10 = this.p) == 0) {
            ByteBuffer byteBuffer;
            int n11;
            String string2;
            int n12;
            long l10;
            Object object2;
            object = this.c;
            if (object != null) {
                ((ReentrantLock)object).lock();
            }
            if ((n10 = (object = this.f).dequeueOutputBuffer((MediaCodec.BufferInfo)(object2 = this.b), l10 = 0L)) == (n12 = -1)) {
                long l11 = 5;
                SystemClock.sleep((long)l11);
            } else {
                int n13 = -3;
                if (n10 == n13) {
                    byteBufferArray = this.f.getOutputBuffers();
                } else {
                    n13 = -2;
                    if (n10 == n13) {
                        object = this.f.getOutputFormat();
                        this.a((MediaFormat)object, 0);
                        object2 = new StringBuilder();
                        string2 = "encoder format:";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(object);
                        object = ((StringBuilder)object2).toString();
                        object2 = "VideoEncoder";
                        Log.d((String)object2, (String)object);
                    } else if (n10 < 0) {
                        object2 = new StringBuilder();
                        string2 = "-------encoderStatus=";
                        ((StringBuilder)object2).append(string2);
                        ((StringBuilder)object2).append(n10);
                        object = ((StringBuilder)object2).toString();
                        object2 = "Encoder";
                        Log.d((String)object2, (String)object);
                    } else {
                        int n14;
                        ByteBuffer byteBuffer2 = byteBufferArray[n10];
                        MediaMuxer mediaMuxer = this.e;
                        if (mediaMuxer != null && (n14 = this.g) != n12) {
                            long l12;
                            long l13;
                            object2 = this.b;
                            n14 = ((MediaCodec.BufferInfo)object2).size;
                            if (n14 > 0 && (n14 = (int)(this.o ? 1 : 0)) != 0 && ((n14 = ((MediaCodec.BufferInfo)object2).flags & 4) == 0 || (n12 = (int)((l13 = (l12 = ((MediaCodec.BufferInfo)object2).presentationTimeUs) - l10) == 0L ? 0 : (l13 < 0L ? -1 : 1))) != 0)) {
                                byteBuffer2.rewind();
                                n12 = this.b.offset;
                                byteBuffer2.position(n12);
                                object2 = this.b;
                                n11 = ((MediaCodec.BufferInfo)object2).offset;
                                n12 = ((MediaCodec.BufferInfo)object2).size;
                                byteBuffer2.limit(n11 += n12);
                                object2 = this.e;
                                n11 = this.g;
                                byteBuffer = this.b;
                                object2.writeSampleData(n11, byteBuffer2, (MediaCodec.BufferInfo)byteBuffer);
                            }
                        }
                        object2 = this.f;
                        object2.releaseOutputBuffer(n10, false);
                        object = this.b;
                        n10 = ((MediaCodec.BufferInfo)object).flags & 4;
                        if (n10 != 0) {
                            n10 = 1;
                            this.p = n10;
                        }
                    }
                }
            }
            try {
                object = this.d;
                ((Semaphore)object).acquire();
            }
            catch (Exception exception) {}
            if ((n10 = (object = this.r).size()) > 0 && (n10 = this.i) >= 0 && (n10 = (int)(this.o ? 1 : 0)) != 0) {
                object = (a)this.r.remove(0);
                ((a)object).a.rewind();
                object2 = ((a)object).a;
                n11 = object.b.offset;
                ((ByteBuffer)object2).position(n11);
                object2 = ((a)object).a;
                string2 = ((a)object).b;
                int n15 = ((MediaCodec.BufferInfo)string2).offset;
                n11 = ((MediaCodec.BufferInfo)string2).size;
                ((ByteBuffer)object2).limit(n15 += n11);
                object2 = this.e;
                n11 = this.i;
                byteBuffer = ((a)object).a;
                object = ((a)object).b;
                object2.writeSampleData(n11, byteBuffer, (MediaCodec.BufferInfo)object);
            }
            this.d.release();
            object = this.c;
            if (object == null) continue;
            ((ReentrantLock)object).unlock();
        }
    }

    /*
     * Unable to fully structure code
     */
    public void c(int var1_1, int var2_2, int var3_3) {
        block10: {
            block9: {
                var4_4 = this.q;
                if (var4_4 != 0) {
                    return;
                }
                var5_5 = this.m;
                if (var5_5 == null || var1_1 <= 0 || var2_2 <= 0) break block10;
                var4_4 = 2134288520;
                if (var3_3 != var4_4 && var3_3 != (var4_4 = 2135033992) && var3_3 != (var4_4 = 2130708361)) {
                    return;
                }
                this.k = var1_1;
                this.l = var2_2;
                var4_4 = var1_1 * 30 * var2_2 * 3 / 20;
                var6_6 = var4_4 % 10000;
                if ((var6_6 = var4_4 - var6_6) > 0) {
                    var4_4 = var6_6;
                }
                var7_7 = "video/avc";
                var8_8 = MediaFormat.createVideoFormat((String)var7_7, (int)var1_1, (int)var2_2);
                var8_8.setInteger("color-format", var3_3);
                var2_2 = this.k;
                var8_8.setInteger("width", var2_2);
                var2_2 = this.l;
                var9_11 = "height";
                var8_8.setInteger(var9_11, var2_2);
                var8_8.setInteger("bitrate", var4_4);
                var8_8.setInteger("frame-rate", 30);
                var3_3 = 1;
                var8_8.setInteger("i-frame-interval", var3_3);
                var2_2 = 0;
                var10_12 = null;
                var5_5 = MediaCodec.createEncoderByType((String)var7_7);
                try {
                    var5_5.configure(var8_8, null, null, var3_3);
                    ** GOTO lbl-1000
                }
                catch (Exception var8_9) {
                    break block9;
                }
                catch (Exception var8_10) {
                    var4_4 = 0;
                    var5_5 = null;
                }
            }
            var8_8.printStackTrace();
            if (var5_5 != null) {
                var5_5.stop();
                var5_5.release();
            } else lbl-1000:
            // 2 sources

            {
                var10_12 = var5_5;
            }
            this.f = var10_12;
            var8_8 = new MediaCodec.BufferInfo();
            this.b = var8_8;
            this.d();
            this.q = var3_3;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean f(a a10) {
        if (a10 == null) return false;
        int n10 = this.i;
        if (n10 < 0) return false;
        Object object = this.e;
        if (object == null) {
            return false;
        }
        try {
            object = this.d;
            ((Semaphore)object).acquire();
        }
        catch (Exception exception) {}
        this.r.add(a10);
        this.d.release();
        return true;
    }

    public boolean g(ImagePixelBuffer imagePixelBuffer, boolean bl2) {
        MediaMuxer mediaMuxer;
        Object object;
        int n10 = this.q;
        byte[] byArray = null;
        if (n10 == 0 && bl2) {
            return false;
        }
        int n11 = 1;
        if (n10 == 0) {
            this.k = n10 = imagePixelBuffer.a;
            this.l = n10 = imagePixelBuffer.b;
            n10 = imagePixelBuffer.d;
            this.n = n10 == n11 ? (n10 = 2134288520) : (n10 = 2135033992);
            this.e();
            this.i();
        }
        if ((object = this.f) != null && (mediaMuxer = this.e) != null) {
            int n12 = this.n;
            int n13 = 2130708361;
            if (n12 == n13) {
                return false;
            }
            long l10 = 1000000000L;
            int n14 = object.dequeueInputBuffer(l10);
            if (n14 >= 0) {
                object = this.f.getInputBuffer(n14);
                object.rewind();
                object.position(0);
                if (imagePixelBuffer != null) {
                    int n15;
                    byArray = imagePixelBuffer.e;
                    object.put(byArray);
                    MediaCodec mediaCodec = this.f;
                    object = imagePixelBuffer.e;
                    int n16 = ((MediaCodec)object).length;
                    long l11 = imagePixelBuffer.f;
                    int n17 = bl2 ? (n15 = 4) : n11;
                    mediaCodec.queueInputBuffer(n14, 0, n16, l11, n17);
                } else if (bl2) {
                    MediaCodec mediaCodec = this.f;
                    boolean bl3 = false;
                    long l12 = 0L;
                    int n18 = 4;
                    mediaCodec.queueInputBuffer(n14, 0, 0, l12, n18);
                }
            }
            return n11 != 0;
        }
        return false;
    }

    public boolean h() {
        MediaCodec mediaCodec;
        boolean bl2 = this.q;
        if (bl2 && (mediaCodec = this.f) != null && (mediaCodec = this.e) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            mediaCodec = null;
        }
        return bl2;
    }

    public void i() {
        Object object;
        Object object2;
        boolean bl2 = this.q;
        if (!bl2) {
            this.e();
        }
        if ((object2 = this.f) != null && (object = this.e) != null) {
            object = this.a;
            if (object != null) {
                return;
            }
            object2.start();
            object = new c$a(this);
            object2 = new Thread((Runnable)object);
            this.a = object2;
            ((Thread)object2).start();
        }
    }

    public void j() {
        Object object = this.f;
        if (object != null && (object = this.e) != null) {
            long l10;
            long l11;
            int n10;
            long l12 = 0L;
            while ((n10 = this.p) == 0 && (n10 = (l11 = l12 - (l10 = 500L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
                l10 = 10;
                SystemClock.sleep((long)l10);
                l12 += l10;
            }
            this.p = n10 = 1;
            object = this.c;
            if (object != null) {
                ((ReentrantLock)object).lock();
            }
            object = this.f;
            object.stop();
            object = this.f;
            object.release();
            try {
                this.f = null;
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            object = this.e;
            if (object != null) {
                object.stop();
                object = this.e;
                try {
                    object.release();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                this.e = null;
            }
            if ((object = this.c) != null) {
                ((ReentrantLock)object).unlock();
            }
            this.a = null;
            return;
        }
        object = this.e;
        if (object != null) {
            object.stop();
            object = this.e;
            try {
                object.release();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            this.e = null;
        }
    }
}

