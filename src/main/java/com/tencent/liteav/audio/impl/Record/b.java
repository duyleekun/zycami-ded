/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecList
 *  android.media.MediaFormat
 */
package com.tencent.liteav.audio.impl.Record;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import com.tencent.liteav.audio.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.Vector;

public class b
extends Thread {
    private MediaCodec.BufferInfo a;
    private MediaCodecInfo b;
    private MediaFormat c;
    private MediaCodec d;
    private Vector e;
    private WeakReference f;
    private volatile boolean g = false;
    private volatile boolean h = false;
    private final Object i;
    private long j;
    private int k;
    private int l;
    private int m;
    private byte[] n;

    static {
        com.tencent.liteav.basic.util.g.f();
    }

    public b() {
        super("TXAudioRecordThread");
        Object object;
        this.i = object = new Object();
        this.j = 0L;
        this.k = 48000;
        this.l = 1;
        this.m = 16;
    }

    private static final MediaCodecInfo a(String string2) {
        MediaCodecInfo mediaCodecInfo;
        block3: {
            String string3 = "AudioCenter:TXCAudioHWEncoder";
            String string4 = "selectAudioCodec:";
            TXCLog.v(string3, string4);
            int n10 = MediaCodecList.getCodecCount();
            for (int i10 = 0; i10 < n10; ++i10) {
                int n11;
                mediaCodecInfo = MediaCodecList.getCodecInfoAt((int)i10);
                boolean bl2 = mediaCodecInfo.isEncoder();
                if (!bl2) continue;
                String[] stringArray = mediaCodecInfo.getSupportedTypes();
                for (int i11 = 0; i11 < (n11 = stringArray.length); ++i11) {
                    CharSequence charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("supportedType:");
                    String string5 = mediaCodecInfo.getName();
                    ((StringBuilder)charSequence).append(string5);
                    ((StringBuilder)charSequence).append(",MIME=");
                    string5 = stringArray[i11];
                    ((StringBuilder)charSequence).append(string5);
                    charSequence = ((StringBuilder)charSequence).toString();
                    TXCLog.i(string3, (String)charSequence);
                    charSequence = stringArray[i11];
                    n11 = (int)(((String)charSequence).equalsIgnoreCase(string2) ? 1 : 0);
                    if (n11 == 0) {
                        continue;
                    }
                    break block3;
                }
            }
            mediaCodecInfo = null;
        }
        return mediaCodecInfo;
    }

    private void a(ByteBuffer object, int n10, long l10) {
        boolean bl2 = this.h;
        if (bl2) {
            return;
        }
        Object object2 = this.d.getInputBuffers();
        Object object3 = this.d;
        long l11 = 10000L;
        int n11 = object3.dequeueInputBuffer(l11);
        object3 = "AudioCenter:TXCAudioHWEncoder";
        if (n11 >= 0) {
            int n12;
            MediaCodec mediaCodec;
            object2 = object2[n11];
            ((ByteBuffer)object2).clear();
            if (object != null) {
                ((ByteBuffer)object2).put((ByteBuffer)object);
            }
            if (n10 <= 0) {
                object = "send BUFFER_FLAG_END_OF_STREAM";
                TXCLog.i((String)object3, (String)object);
                mediaCodec = this.d;
                n12 = 4;
                mediaCodec.queueInputBuffer(n11, 0, 0, l10, n12);
            } else {
                mediaCodec = this.d;
                n12 = 0;
                mediaCodec.queueInputBuffer(n11, 0, n10, l10, 0);
            }
        }
        object = this.d.getOutputBuffers();
        do {
            int n13;
            Object object4;
            MediaCodec mediaCodec;
            if ((n10 = (mediaCodec = this.d).dequeueOutputBuffer(object4 = this.a, l11)) == (n13 = -1)) continue;
            n13 = -3;
            if (n10 == n13) {
                object = this.d.getOutputBuffers();
                continue;
            }
            n13 = -2;
            if (n10 == n13) {
                object4 = this.d;
                object4.getOutputFormat();
                continue;
            }
            if (n10 < 0) continue;
            object4 = object[n10];
            Object object5 = this.a;
            int n14 = object5.flags & 2;
            bl2 = false;
            object2 = null;
            if (n14 != 0) {
                TXCLog.d((String)object3, "drain:BUFFER_FLAG_CODEC_CONFIG");
                object5 = this.a;
                object5.size = 0;
            }
            object5 = this.a;
            int n15 = object5.size;
            if (n15 != 0) {
                long l12;
                object5.presentationTimeUs = l12 = this.f();
                n14 = object4.limit();
                object5 = new byte[n14];
                this.n = (byte[])object5;
                object4.get((byte[])object5);
                object4 = this.n;
                object5 = this.a;
                l12 = object5.presentationTimeUs;
                this.b((byte[])object4, l12);
                object4 = this.a;
                this.j = l10 = object4.presentationTimeUs;
            }
            object4 = this.d;
            object4.releaseOutputBuffer(n10, false);
        } while (n10 >= 0);
    }

    private void b() {
        CharSequence charSequence = "audio/mp4a-latm";
        Object object = com.tencent.liteav.audio.impl.Record.b.a((String)charSequence);
        this.b = object;
        String string2 = "AudioCenter:TXCAudioHWEncoder";
        if (object == null) {
            TXCLog.e(string2, "Unable to find an appropriate codec for audio/mp4a-latm");
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("selected codec: ");
        String string3 = this.b.getName();
        ((StringBuilder)object).append(string3);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string2, (String)object);
        int n10 = this.k;
        int n11 = 32000;
        if (n10 >= n11) {
            n11 = 64000;
        }
        int n12 = this.l;
        charSequence = MediaFormat.createAudioFormat((String)charSequence, (int)n10, (int)n12);
        this.c = charSequence;
        charSequence.setInteger("bitrate", n11);
        charSequence = this.c;
        n10 = this.l;
        charSequence.setInteger("channel-count", n10);
        charSequence = this.c;
        n10 = this.k;
        charSequence.setInteger("sample-rate", n10);
        charSequence = this.c;
        n10 = 2;
        string3 = "aac-profile";
        charSequence.setInteger(string3, n10);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("format: ");
        object = this.c;
        ((StringBuilder)charSequence).append(object);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i(string2, (String)charSequence);
        try {
            this.d();
        }
        catch (Exception exception) {
            object = "start media codec failed.";
            TXCLog.e(string2, (String)object, exception);
        }
        this.start();
    }

    private void b(byte[] byArray, long l10) {
        WeakReference weakReference = this.f;
        if (weakReference != null) {
            weakReference = weakReference.get();
            Object object = weakReference;
            object = (f)((Object)weakReference);
            if (object != null) {
                int n10 = this.k;
                int n11 = this.l;
                int n12 = this.m;
                object.b(byArray, l10, n10, n11, n12);
            }
        }
    }

    private void c() {
        this.h = true;
    }

    private void d() {
        MediaCodec mediaCodec = this.d;
        if (mediaCodec != null) {
            return;
        }
        this.d = mediaCodec = MediaCodec.createEncoderByType((String)"audio/mp4a-latm");
        MediaFormat mediaFormat = this.c;
        int n10 = 1;
        mediaCodec.configure(mediaFormat, null, null, n10);
        this.d.start();
        TXCLog.i("AudioCenter:TXCAudioHWEncoder", "prepare finishing");
        this.g = n10;
    }

    private void e() {
        MediaCodec mediaCodec = this.d;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.d.release();
            mediaCodec = null;
            this.d = null;
        }
        this.g = false;
    }

    private long f() {
        long l10;
        long l11 = TXCTimeUtil.getTimeTick();
        long l12 = l11 - (l10 = this.j);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            l10 -= l11;
            l11 += l10;
        }
        return l11;
    }

    public void a() {
        this.c();
    }

    public void a(int n10, int n11, int n12, int n13, WeakReference weakReference) {
        Object object;
        this.f = weakReference;
        this.a = object = new MediaCodec.BufferInfo();
        object = new Vector();
        this.e = object;
        this.k = n11;
        this.l = n12;
        this.m = n13;
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(byte[] object, long l10) {
        Object object2 = this.e;
        if (object2 != null && object != null) {
            synchronized (object2) {
                Vector vector = this.e;
                if (vector == null) {
                    return;
                }
                vector.add(object);
            }
        }
        object = this.i;
        synchronized (object) {
            object2 = this.i;
            object2.notify();
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void run() {
        var1_1 = 1024;
        var2_2 = ByteBuffer.allocateDirect(var1_1);
        while (true) {
            if ((var3_4 = this.h) != 0) {
                this.e();
                return;
            }
            var3_4 = this.g;
            if (var3_4 != 0) {
                var4_5 = this.e;
                // MONITORENTER : var4_5
                var5_7 = this.e;
                var6_8 = var5_7.isEmpty();
                // MONITOREXIT : var4_5
                if (var6_8 != 0) {
                    var7_9 = 10;
                    Thread.sleep(var7_9);
                }
                var5_7 = this.e;
                // MONITORENTER : var5_7
                var4_5 = this.e;
                var9_10 = 0;
                var10_11 = null;
                var4_5 = var4_5.remove(0);
                var4_5 = (byte[])var4_5;
                // MONITOREXIT : var5_7
                if (var4_5 == null) continue;
                try {
                    var2_2.clear();
                    var6_8 = ((Object)var4_5).length;
                    var9_10 = var2_2.capacity();
                    if (var6_8 > var9_10) {
                        var6_8 = ((Object)var4_5).length;
                        var2_2 = ByteBuffer.allocateDirect(var6_8);
                    }
                    var2_2.clear();
                    var2_2.put((byte[])var4_5);
                    var2_2.flip();
                    var3_4 = ((Object)var4_5).length;
                    var11_12 = this.f();
                    this.a(var2_2, var3_4, var11_12);
                }
                catch (Exception var4_6) {
                    var5_7 = "AudioCenter:TXCAudioHWEncoder";
                    var10_11 = "encode frame failed.";
                    TXCLog.e((String)var5_7, var10_11, var4_6);
                }
                continue;
            }
            var4_5 = this.i;
            // MONITORENTER : var4_5
            var5_7 = this.i;
            var5_7.wait();
            ** GOTO lbl-1000
            catch (InterruptedException v0) {}
            continue;
            catch (Throwable var2_3) {
                throw var2_3;
            }
            catch (InterruptedException v1) {}
lbl-1000:
            // 2 sources

            {
                // MONITOREXIT : var4_5
                continue;
            }
            break;
        }
    }
}

