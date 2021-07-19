/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecList
 *  android.media.MediaFormat
 *  android.os.Build$VERSION
 *  android.view.Surface
 *  org.json.JSONArray
 */
package com.tencent.liteav.videodecoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.videodecoder.b;
import com.tencent.liteav.videodecoder.d;
import com.tencent.liteav.videodecoder.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.json.JSONArray;

public class e
implements b {
    private MediaCodec.BufferInfo a;
    private MediaCodec b;
    private String c;
    private int d;
    private int e;
    private long f;
    private long g;
    private boolean h;
    private boolean i;
    private boolean j;
    private Surface k;
    private int l;
    private ArrayList m;
    private ArrayList n;
    private long o;
    private int p;
    private JSONArray q;
    private f r;
    private d s;
    private boolean t;
    private WeakReference u;

    public e() {
        ArrayList arrayList;
        long l10;
        Object object;
        this.a = object = new MediaCodec.BufferInfo();
        this.b = null;
        this.c = "video/avc";
        this.d = 540;
        this.e = 960;
        this.f = l10 = 0L;
        this.g = l10;
        this.h = true;
        this.i = false;
        this.j = false;
        this.k = null;
        this.l = 0;
        this.m = arrayList = new ArrayList();
        this.n = arrayList = new ArrayList();
        this.o = l10;
        this.p = 0;
        this.q = null;
        this.s = object;
        this.t = false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int a(ByteBuffer var1_1, ByteBuffer var2_7, boolean var3_9) {
        block25: {
            block24: {
                block23: {
                    var4_10 = "MediaCodecDecoder";
                    var5_11 = 1;
                    var6_12 = 0;
                    var7_13 = -1;
                    var8_14 /* !! */  = this.b;
                    if (var8_14 /* !! */  != null || (var8_14 /* !! */  = this.k) == null) ** GOTO lbl101
                    this.j = var3_9;
                    this.c = var3_9 != false ? (var9_15 = "video/hevc") : (var9_15 = "video/avc");
                    var9_15 = this.c;
                    var10_16 = this.d;
                    var11_17 = this.e;
                    var9_15 = MediaFormat.createVideoFormat((String)var9_15, (int)var10_16, (int)var11_17);
                    if (var1_1 != null) {
                        var8_14 /* !! */  = "csd-0";
                        var9_15.setByteBuffer((String)var8_14 /* !! */ , (ByteBuffer)var1_1);
                    }
                    if (var2_7 != null) {
                        var1_1 = "csd-1";
                        var9_15.setByteBuffer((String)var1_1, (ByteBuffer)var2_7);
                    }
                    if ((var1_1 = this.q) != null) {
                        var2_7 = null;
                    }
                    ** GOTO lbl47
                    {
                        catch (Exception var1_5) {
                            var5_11 = 0;
                            break block23;
                        }
                        try {
                            for (var12_18 = 0; var12_18 < (var10_16 = var1_1.length()); ++var12_18) {
                                var8_14 /* !! */  = var1_1.getJSONObject(var12_18);
                                var13_19 = "key";
                                var13_19 = var8_14 /* !! */ .optString(var13_19);
                                var14_20 = "value";
                                var10_16 = var8_14 /* !! */ .optInt(var14_20);
                                var9_15.setInteger(var13_19, var10_16);
                            }
                            ** GOTO lbl47
                        }
                        catch (Exception var1_2) {}
                        {
                            var2_7 = new StringBuilder();
                            var8_14 /* !! */  = "config custom format error ";
                            var2_7.append((String)var8_14 /* !! */ );
                            var1_1 = var1_2.toString();
                            var2_7.append((String)var1_1);
                            var1_1 = var2_7.toString();
                            TXCLog.w(var4_10, (String)var1_1);
lbl47:
                            // 3 sources

                            var1_1 = this.c;
                            var1_1 = MediaCodec.createDecoderByType((String)var1_1);
                            this.b = var1_1;
                        }
                    }
                    try {
                        var2_7 = this.k;
                        var1_1.configure((MediaFormat)var9_15, (Surface)var2_7, null, 0);
                        var15_21 = 2;
                    }
                    catch (Exception var1_4) {
                        break block23;
                    }
                    try {
                        var2_7 = this.b;
                        var2_7.setVideoScalingMode(var5_11);
                        var5_11 = 3;
                    }
                    catch (Exception var2_8) {
                        var5_11 = var15_21;
                        var1_1 = var2_8;
                        break block23;
                    }
                    {
                        var1_1 = this.b;
                        var1_1.start();
                        var5_11 = 4;
                        var1_1 = new StringBuilder();
                        var2_7 = "decode: start decoder success, is hevc: ";
                        var1_1.append((String)var2_7);
                        var12_18 = (int)this.j;
                        var1_1.append((boolean)var12_18);
                        var2_7 = " w = ";
                        var1_1.append((String)var2_7);
                        var12_18 = this.d;
                        var1_1.append(var12_18);
                        var2_7 = " h = ";
                        var1_1.append((String)var2_7);
                        var12_18 = this.e;
                        var1_1.append(var12_18);
                        var2_7 = ", format = ";
                        var1_1.append((String)var2_7);
                        var2_7 = var9_15.toString();
                        var1_1.append((String)var2_7);
                        var1_1 = var1_1.toString();
                        TXCLog.w(var4_10, (String)var1_1);
                    }
                    try {
                        this.l = 0;
                        return var6_12;
                    }
                    catch (Exception var1_3) {}
                    {
                        break block24;
lbl101:
                        // 1 sources

                        var1_1 = new StringBuilder();
                        var2_7 = "decode: init decoder error, can not init for decoder=";
                        var1_1.append((String)var2_7);
                        var2_7 = this.b;
                        var1_1.append(var2_7);
                        var2_7 = ",surface=";
                        var1_1.append((String)var2_7);
                        var2_7 = this.k;
                        var1_1.append(var2_7);
                        var1_1 = var1_1.toString();
                        TXCLog.e(var4_10, (String)var1_1);
                        return var7_13;
                    }
                }
                var6_12 = var7_13;
            }
            var2_7 = this.b;
            if (var2_7 != null) {
                var2_7.release();
                var2_7 = "decode: , decoder release success";
                TXCLog.w(var4_10, (String)var2_7);
lbl126:
                // 2 sources

                while (true) {
                    this.b = null;
                    break block25;
                    break;
                }
                {
                    catch (Throwable var1_6) {
                    }
                    catch (Exception v0) {}
                    {
                        var2_7 = new StringBuilder();
                        var9_15 = "decode: , decoder release exception: ";
                        var2_7.append(var9_15);
                        var9_15 = var1_1.toString();
                        var2_7.append(var9_15);
                        var2_7 = var2_7.toString();
                        TXCLog.e(var4_10, (String)var2_7);
                        ** continue;
                    }
                }
                this.b = null;
                throw var1_6;
            }
        }
        var2_7 = new StringBuilder();
        var2_7.append("decode: init decoder ");
        var2_7.append(var5_11);
        var2_7.append(" step exception: ");
        var9_15 = var1_1.toString();
        var2_7.append(var9_15);
        var2_7 = var2_7.toString();
        TXCLog.e(var4_10, (String)var2_7);
        var1_1.printStackTrace();
        this.f();
        return var6_12;
    }

    /*
     * Exception decompiling
     */
    private void a() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [10 : 64->67)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2289)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:414)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private void a(int n10, long l10, long l11, int n11) {
        block6: {
            e e10 = this;
            Object object = this.b;
            boolean bl2 = true;
            object.releaseOutputBuffer(n10, bl2);
            object = this.a;
            int n12 = object.flags & 4;
            String string2 = "MediaCodecDecoder";
            if (n12 != 0) {
                object = "output EOS";
                TXCLog.i(string2, (String)object);
            }
            Object object2 = e10.r;
            if (object2 == null) break block6;
            int n13 = e10.d;
            int n14 = e10.e;
            try {
                object2.onDecodeFrame(null, n13, n14, l10, l11, n11);
            }
            catch (Exception exception) {
                object2 = "onDecodeFrame failed.";
                TXCLog.e(string2, (String)object2, exception);
            }
        }
        this.d();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(TXSNALPacket tXSNALPacket) {
        int n10;
        byte[] byArray;
        byte[] byArray2;
        byte[] byArray3;
        int n11;
        int n12;
        int n13;
        byte[] byArray4;
        int n14 = this.t;
        if (n14 == 0) {
            return;
        }
        n14 = tXSNALPacket.nalType;
        if (n14 != 0) return;
        n14 = -1;
        Object object = null;
        int n15 = 0;
        try {
            while (true) {
                block18: {
                    block17: {
                        int n16;
                        int n17;
                        block16: {
                            byArray4 = tXSNALPacket.nalData;
                            n13 = byArray4.length;
                            n12 = 1;
                            if (n15 >= n13) break;
                            n13 = byArray4[n15];
                            n17 = 7;
                            if (n13 != 0) break block16;
                            n13 = n15 + 1;
                            if ((n13 = byArray4[n13]) != 0) break block16;
                            n13 = n15 + 2;
                            if ((n13 = byArray4[n13]) != 0) break block16;
                            n13 = n15 + 3;
                            if ((n13 = byArray4[n13]) == n12 && (n16 = byArray4[n13 = n15 + 4] & 0x1F) == n17) break block17;
                        }
                        if ((n13 = byArray4[n15]) != 0) break block18;
                        n13 = n15 + 1;
                        if ((n13 = byArray4[n13]) != 0) break block18;
                        n13 = n15 + 2;
                        if ((n13 = byArray4[n13]) != 0 || (n16 = byArray4[n13 = n15 + 3] & 0x1F) != n17) break block18;
                    }
                    n14 = n13;
                    break;
                }
                n15 = n15 + 1 + n12;
            }
            if (n14 < 0) return;
            n15 = byArray4.length - n14;
        }
        catch (Exception exception) {
            String string2 = "MediaCodecDecoder";
            object = "modify dec buffer error ";
            TXCLog.e(string2, (String)object, exception);
            return;
        }
        {
            int n18;
            for (n11 = n14; n11 < (n18 = (byArray3 = tXSNALPacket.nalData).length); ++n11) {
                block20: {
                    block19: {
                        n18 = byArray3[n11];
                        if (n18 != 0) break block19;
                        n18 = n11 + 1;
                        if ((n18 = byArray3[n18]) != 0) break block19;
                        n18 = n11 + 2;
                        if ((n18 = byArray3[n18]) == n12) break block20;
                    }
                    if ((n18 = byArray3[n11]) != 0) continue;
                    n18 = n11 + 1;
                    if ((n18 = byArray3[n18]) != 0) continue;
                    n18 = n11 + 2;
                    if ((n18 = byArray3[n18]) != 0) continue;
                    n18 = n11 + 3;
                    if ((n18 = byArray3[n18]) != n12) continue;
                }
                n15 = n11 - n14;
                break;
            }
        }
        {
            byArray4 = new byte[n15];
            System.arraycopy(byArray3, n14, byArray4, 0, n15);
            d d10 = this.s;
            byArray4 = d10.a(byArray4);
            if (byArray4 == null) return;
            byArray2 = tXSNALPacket.nalData;
            n12 = byArray2.length;
            int n19 = byArray4.length;
            n12 = n12 + n19 - n15;
        }
        {
            byArray = new byte[n12];
            if (n14 > 0) {
                System.arraycopy(byArray2, 0, byArray, 0, n14);
            }
            n13 = byArray4.length;
            System.arraycopy(byArray4, 0, byArray, n14, n13);
            object = tXSNALPacket.nalData;
            n13 = n14 + n15;
            n11 = byArray4.length + n14;
            n10 = ((Object)object).length - n15 - n14;
        }
        {
            System.arraycopy(object, n13, byArray, n11, n10);
            tXSNALPacket.nalData = byArray;
            return;
        }
    }

    private void a(boolean bl2) {
        boolean bl3 = this.j;
        if (bl3 != bl2) {
            CharSequence charSequence = new StringBuilder();
            String string2 = "[Video][Decoder] nal data format changed, from:";
            charSequence.append(string2);
            boolean bl4 = this.j;
            String string3 = "h265";
            String string4 = "h264";
            string2 = bl4 ? string3 : string4;
            charSequence.append(string2);
            string2 = " to:";
            charSequence.append(string2);
            if (!bl2) {
                string3 = string4;
            }
            charSequence.append(string3);
            charSequence = charSequence.toString();
            string2 = "MediaCodecDecoder";
            TXCLog.i(string2, (String)charSequence);
            this.j = bl2;
            if (bl2 && !(bl2 = this.e())) {
                this.a();
                this.f();
            } else {
                this.a();
                bl2 = this.j;
                bl3 = false;
                charSequence = null;
                this.a(null, null, bl2);
            }
        }
    }

    private void b() {
        int n10;
        e e10 = this;
        Object object = this.b;
        Object object2 = "MediaCodecDecoder";
        if (object == null) {
            TXCLog.e((String)object2, "null decoder");
            return;
        }
        Object object3 = object = this.m.get(0);
        object3 = (TXSNALPacket)object;
        if (object3 != null && (n10 = ((MediaCodec)(object = (Object)((TXSNALPacket)object3).nalData)).length) != 0) {
            CharSequence charSequence;
            long l10 = TXCTimeUtil.getTimeTick();
            long l11 = this.o;
            long l12 = 0L;
            long l13 = l11 - l12;
            n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
            if (n10 == 0) {
                this.o = l10;
            }
            int n11 = 0;
            Object object4 = null;
            object = e10.b;
            try {
                object4 = object.getInputBuffers();
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "decode: getInputBuffers Exception!! ";
                charSequence.append(string2);
                object = exception.toString();
                charSequence.append((String)object);
                object = charSequence.toString();
                TXCLog.e((String)object2, (String)object);
            }
            if (object4 != null && (n10 = ((ByteBuffer[])object4).length) != 0) {
                long l14;
                int n12;
                String string3;
                Object object5;
                long l15 = 10000L;
                object = e10.b;
                try {
                    n10 = object.dequeueInputBuffer(l15);
                }
                catch (Exception exception) {
                    object5 = new StringBuilder();
                    string3 = "decode: dequeueInputBuffer Exception!! ";
                    ((StringBuilder)object5).append(string3);
                    object = exception.toString();
                    ((StringBuilder)object5).append((String)object);
                    object = ((StringBuilder)object5).toString();
                    TXCLog.e((String)object2, (String)object);
                    n10 = -10000;
                }
                if (n10 >= 0) {
                    object4 = object4[n10];
                    object5 = ((TXSNALPacket)object3).nalData;
                    ((ByteBuffer)object4).put((byte[])object5);
                    string3 = e10.b;
                    object4 = ((TXSNALPacket)object3).nalData;
                    n11 = ((ByteBuffer[])object4).length;
                    long l16 = ((TXSNALPacket)object3).pts;
                    string3.queueInputBuffer(n10, 0, n11, l16, 0);
                    object4 = e10.m;
                    try {
                        ((ArrayList)object4).remove(0);
                    }
                    catch (Exception exception) {
                        this.g();
                    }
                    l16 = e10.f;
                    n11 = (int)(l16 == l12 ? 0 : (l16 < l12 ? -1 : 1));
                    if (n11 == 0) {
                        object4 = new StringBuilder();
                        String string4 = "decode: input buffer available, dequeueInputBuffer index: ";
                        ((StringBuilder)object4).append(string4);
                        ((StringBuilder)object4).append(n10);
                        object = ((StringBuilder)object4).toString();
                        TXCLog.w((String)object2, (String)object);
                    }
                } else {
                    object = "decode: input buffer not available, dequeueInputBuffer failed";
                    TXCLog.w((String)object2, (String)object);
                }
                object = e10.b;
                object4 = e10.a;
                try {
                    n10 = object.dequeueOutputBuffer((MediaCodec.BufferInfo)object4, l15);
                }
                catch (Exception exception) {
                    this.g();
                    object4 = new StringBuilder();
                    charSequence = "decode: dequeueOutputBuffer exception!!";
                    ((StringBuilder)object4).append((String)charSequence);
                    ((StringBuilder)object4).append(exception);
                    object = ((StringBuilder)object4).toString();
                    TXCLog.e((String)object2, (String)object);
                    n10 = -10000;
                }
                if (n10 >= 0) {
                    long l17 = e10.a.presentationTimeUs;
                    int n13 = ((TXSNALPacket)object3).rotation;
                    object2 = this;
                    n12 = n10;
                    l11 = l17;
                    this.a(n10, l17, l17, n13);
                    e10.l = 0;
                } else {
                    n12 = -1;
                    if (n10 == n12) {
                        l14 = 10;
                        try {
                            Thread.sleep(l14);
                        }
                        catch (InterruptedException interruptedException) {
                            object3 = interruptedException;
                            interruptedException.printStackTrace();
                        }
                        object = new StringBuilder();
                        object3 = "decode: no output from decoder available when timeout fail count ";
                        ((StringBuilder)object).append((String)object3);
                        n12 = e10.l;
                        ((StringBuilder)object).append(n12);
                        object = ((StringBuilder)object).toString();
                        TXCLog.i((String)object2, (String)object);
                        this.g();
                    } else {
                        n12 = -3;
                        if (n10 == n12) {
                            object = "decode: output buffers changed";
                            TXCLog.i((String)object2, (String)object);
                        } else {
                            n12 = -2;
                            if (n10 == n12) {
                                this.c();
                            } else {
                                object3 = new StringBuilder();
                                object4 = "decode: unexpected result from decoder.dequeueOutputBuffer: ";
                                ((StringBuilder)object3).append((String)object4);
                                ((StringBuilder)object3).append(n10);
                                object = ((StringBuilder)object3).toString();
                                TXCLog.e((String)object2, (String)object);
                            }
                        }
                    }
                }
                long l18 = TXCTimeUtil.getTimeTick();
                object3 = e10.n;
                l11 = l18 - l10;
                object4 = l11;
                ((ArrayList)object3).add(object4);
                l14 = e10.o;
                l15 = 1000L;
                long l19 = l18 - (l14 += l15);
                n12 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                if (n12 > 0) {
                    object3 = e10.n.iterator();
                    while ((n11 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
                        object4 = (Long)object3.next();
                        l15 = (Long)object4;
                        long l20 = l15 - l12;
                        Object object6 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                        if (object6 <= 0) continue;
                        l12 = l11 = ((Long)object4).longValue();
                    }
                    object3 = e10.n;
                    ((ArrayList)object3).clear();
                    e10.o = l18;
                    l18 = 3;
                    e10.p = n10 = (int)(l12 *= l18);
                }
                return;
            }
            TXCLog.e((String)object2, "decode: getInputBuffers failed");
            return;
        }
        TXCLog.e((String)object2, "decode: empty buffer");
        e10.m.remove(0);
    }

    private void c() {
        Object object = this.b.getOutputFormat();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("decode output format changed: ");
        charSequence.append(object);
        charSequence = charSequence.toString();
        String string2 = "MediaCodecDecoder";
        TXCLog.i(string2, (String)charSequence);
        charSequence = "crop-right";
        int n10 = object.getInteger((String)charSequence);
        int n11 = object.getInteger("crop-left");
        n10 = Math.abs(n10 - n11) + 1;
        Object object2 = "crop-bottom";
        n11 = object.getInteger((String)object2);
        int n12 = object.getInteger("crop-top");
        n11 = Math.abs(n11 - n12) + 1;
        String string3 = "width";
        n12 = object.getInteger(string3);
        String string4 = "height";
        int n13 = object.getInteger(string4);
        n10 = Math.min(n10, n12);
        n13 = Math.min(n11, n13);
        n11 = this.d;
        if (n10 == n11 && n13 == (n12 = this.e)) {
            n13 = (int)(this.h ? 1 : 0);
            if (n13 != 0) {
                n13 = 0;
                this.h = false;
                object = this.r;
                if (object != null) {
                    object.onVideoSizeChange(n11, n12);
                }
            }
        } else {
            block7: {
                this.d = n10;
                this.e = n13;
                object2 = this.r;
                if (object2 == null) break block7;
                try {
                    object2.onVideoSizeChange(n10, n13);
                }
                catch (Exception exception) {
                    string3 = "onVideoSizeChange failed.";
                    TXCLog.e(string2, string3, exception);
                }
            }
            object2 = new StringBuilder();
            string3 = "decode: video size change to w:";
            ((StringBuilder)object2).append(string3);
            ((StringBuilder)object2).append(n10);
            charSequence = ",h:";
            ((StringBuilder)object2).append((String)charSequence);
            ((StringBuilder)object2).append(n13);
            object = ((StringBuilder)object2).toString();
            TXCLog.i(string2, (String)object);
        }
    }

    private void d() {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        CharSequence charSequence;
        long l15 = this.f;
        long l16 = 0L;
        Object object = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
        String string2 = "MediaCodecDecoder";
        if (object == false) {
            charSequence = "decode first frame sucess";
            TXCLog.w(string2, (String)charSequence);
        }
        long l17 = System.currentTimeMillis();
        long l18 = this.f;
        long l19 = l18 - l16;
        object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object > 0 && (object = (l14 = l17 - (l18 += (l13 = 1000L))) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0 && (object = (l12 = l17 - (l11 = 2000L + (l18 = this.g))) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0 && (object = l18 == l16 ? 0 : (l18 < l16 ? -1 : 1)) != false) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("frame interval[");
            l18 = this.f;
            l18 = l17 - l18;
            ((StringBuilder)charSequence).append(l18);
            String string3 = "] > ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(l13);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.e(string2, (String)charSequence);
            this.g = l17;
        }
        if ((object = (l10 = (l15 = this.g) - l16) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            this.g = l17;
        }
        this.f = l17;
    }

    private boolean e() {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = ",encoder:";
        String string3 = "MediaCodecDecoder";
        String string4 = "video/hevc";
        boolean bl2 = true;
        int n11 = 21;
        if (n10 >= n11) {
            Object object = new MediaCodecList((int)(bl2 ? 1 : 0));
            object = object.getCodecInfos();
            n11 = ((MediaCodecInfo[])object).length;
            Object var9_10 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                MediaCodecInfo mediaCodecInfo = object[i10];
                String[] stringArray = mediaCodecInfo.getSupportedTypes();
                int n12 = stringArray.length;
                Object var14_19 = null;
                for (int i11 = 0; i11 < n12; ++i11) {
                    String string5 = stringArray[i11];
                    boolean bl3 = string5.contains(string4);
                    if (!bl3) continue;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("decode: video/hevc MediaCodecInfo: ");
                    string4 = mediaCodecInfo.getName();
                    ((StringBuilder)object).append(string4);
                    ((StringBuilder)object).append(string2);
                    boolean bl4 = mediaCodecInfo.isEncoder();
                    ((StringBuilder)object).append(bl4);
                    object = ((StringBuilder)object).toString();
                    TXCLog.e(string3, (String)object);
                    return bl2;
                }
            }
            return false;
        }
        n11 = 16;
        if (n10 >= n11) {
            n10 = MediaCodecList.getCodecCount();
            for (n11 = 0; n11 < n10; ++n11) {
                MediaCodecInfo mediaCodecInfo = MediaCodecList.getCodecInfoAt((int)n11);
                for (String string6 : mediaCodecInfo.getSupportedTypes()) {
                    boolean bl5 = string6.contains(string4);
                    if (!bl5) continue;
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("video/hevc MediaCodecInfo: ");
                    string4 = mediaCodecInfo.getName();
                    charSequence.append(string4);
                    charSequence.append(string2);
                    boolean bl6 = mediaCodecInfo.isEncoder();
                    charSequence.append(bl6);
                    charSequence = charSequence.toString();
                    TXCLog.e(string3, (String)charSequence);
                    return bl2;
                }
            }
        }
        return false;
    }

    private void f() {
        boolean bl2 = this.i;
        if (!bl2) {
            this.i = true;
            Object object = new StringBuilder();
            ((StringBuilder)object).append("[Video][Decoder] notify HWDecoder error, isHEVC:");
            int n10 = this.j;
            ((StringBuilder)object).append(n10 != 0);
            object = ((StringBuilder)object).toString();
            String string2 = "MediaCodecDecoder";
            TXCLog.e(string2, (String)object);
            bl2 = this.j;
            if (bl2) {
                object = this.u;
                n10 = -2304;
                String string3 = "h265 Decoding failed";
                com.tencent.liteav.basic.util.g.a((WeakReference)object, n10, string3);
            } else {
                object = this.u;
                n10 = 2106;
                String string4 = "Failed to enable hardware decoding\uff0cuse software decoding.";
                com.tencent.liteav.basic.util.g.a((WeakReference)object, n10, string4);
            }
            object = this.r;
            if (object != null) {
                n10 = -1;
                object.onDecodeFailed(n10);
            }
        }
    }

    private void g() {
        int n10 = this.l;
        int n11 = 40;
        if (n10 >= n11) {
            this.f();
            n10 = 0;
            this.l = 0;
        } else {
            this.l = ++n10;
        }
    }

    public int GetDecodeCost() {
        return this.p;
    }

    public void a(int n10, int n11) {
        if (n10 > 0 && n11 > 0) {
            this.d = n10;
            this.e = n11;
            CharSequence charSequence = new StringBuilder();
            charSequence.append("decode: init with video size: ");
            n11 = this.d;
            charSequence.append(n11);
            charSequence.append(", ");
            n11 = this.e;
            charSequence.append(n11);
            charSequence = charSequence.toString();
            String string2 = "MediaCodecDecoder";
            TXCLog.w(string2, (String)charSequence);
        }
    }

    public void a(JSONArray jSONArray) {
        this.q = jSONArray;
    }

    public int config(Surface surface) {
        if (surface == null) {
            return -1;
        }
        this.k = surface;
        return 0;
    }

    public void decode(TXSNALPacket object) {
        int n10;
        CharSequence charSequence;
        int n11 = ((TXSNALPacket)object).codecId;
        int n12 = 1;
        if (n11 != n12) {
            n12 = 0;
            charSequence = null;
        }
        this.a(n12 != 0);
        this.a((TXSNALPacket)object);
        Object object2 = this.m;
        ((ArrayList)object2).add(object);
        while ((n10 = ((ArrayList)(object = this.m)).isEmpty()) == 0) {
            object = this.m;
            n10 = ((ArrayList)object).size();
            try {
                this.b();
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "decode: doDecode Exception!! ";
                charSequence.append(string2);
                object2 = exception.toString();
                charSequence.append((String)object2);
                object2 = charSequence.toString();
                charSequence = "MediaCodecDecoder";
                TXCLog.e((String)charSequence, (String)object2);
            }
            if (n10 != (n11 = ((ArrayList)(object2 = this.m)).size())) continue;
        }
    }

    public void enableLimitDecCache(boolean bl2) {
        this.t = bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("decode: enable limit dec cache: ");
        stringBuilder.append(bl2);
        String string2 = stringBuilder.toString();
        TXCLog.i("MediaCodecDecoder", string2);
    }

    public boolean isHevc() {
        return this.j;
    }

    public void setListener(f f10) {
        this.r = f10;
    }

    public void setNotifyListener(WeakReference weakReference) {
        this.u = weakReference;
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean bl2, boolean bl3) {
        return this.a(byteBuffer, byteBuffer2, bl3);
    }

    public void stop() {
        this.a();
    }
}

