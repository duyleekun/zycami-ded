/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.AudioRecord
 *  android.text.TextUtils
 */
package com.zhiyun.nvseditor.record;

import android.media.AudioRecord;
import android.text.TextUtils;
import com.zhiyun.nvseditor.record.AudioRecorder$Status;
import com.zhiyun.nvseditor.record.AudioRecorder$a;
import com.zhiyun.nvseditor.record.AudioRecorder$b;
import d.v.v.g.h;
import d.v.v.l.c;
import d.v.v.l.d;
import d.v.v.q.e;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteOrder;
import java.util.Arrays;
import m.a.a;

public class AudioRecorder {
    public static final int l = 100;
    private static AudioRecorder m;
    private static final int n = 1;
    private static final int o = 16000;
    private static final int p = 16;
    private static final int q = 2;
    private int a = 0;
    private AudioRecord b;
    private AudioRecorder$Status c;
    private String d;
    private String e;
    private e f;
    private AudioRecorder$b g;
    private short[] h;
    private int i;
    private long j;
    private long k;

    private AudioRecorder() {
        AudioRecorder$Status audioRecorder$Status;
        this.c = audioRecorder$Status = AudioRecorder$Status.STATUS_NO_READY;
    }

    public static /* synthetic */ String b(AudioRecorder audioRecorder) {
        return audioRecorder.d;
    }

    public static /* synthetic */ AudioRecorder$b c(AudioRecorder audioRecorder) {
        return audioRecorder.g;
    }

    public static /* synthetic */ String d(AudioRecorder audioRecorder) {
        return audioRecorder.e;
    }

    public static AudioRecorder j() {
        AudioRecorder audioRecorder = m;
        if (audioRecorder == null) {
            m = audioRecorder = new AudioRecorder();
        }
        return m;
    }

    public static /* synthetic */ void l(AudioRecorder audioRecorder) {
        audioRecorder.u();
    }

    private /* synthetic */ void m() {
        e e10 = this.f;
        String string2 = this.d;
        String string3 = this.e;
        AudioRecorder$a audioRecorder$a = new AudioRecorder$a(this);
        e10.a(string2, string3, audioRecorder$a);
    }

    private void o() {
        Object object = this.c;
        Object object2 = AudioRecorder$Status.STATUS_NO_READY;
        if (object != object2 && object != (object2 = AudioRecorder$Status.STATUS_READY)) {
            d.v.v.g.h.k().B();
            this.b.stop();
            this.c = object = AudioRecorder$Status.STATUS_STOP;
            this.q();
        } else {
            object = new IllegalStateException("\u5f55\u97f3\u5c1a\u672a\u5f00\u59cb");
            object2 = this.g;
            if (object2 != null) {
                object2.d((Exception)object);
            }
        }
    }

    private void q() {
        Object object;
        block5: {
            Object object2;
            try {
                object2 = new c(this);
            }
            catch (IllegalStateException illegalStateException) {
                String string2 = illegalStateException.getMessage();
                object2 = new IllegalStateException(string2);
                throw object2;
            }
            object = new Thread((Runnable)object2);
            object.start();
            object = this.b;
            if (object == null) break block5;
            object.release();
            object = null;
            this.b = null;
        }
        object = AudioRecorder$Status.STATUS_NO_READY;
        this.c = object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void u() {
        block45: {
            block42: {
                block41: {
                    var2_6 = this.d;
                    var1_1 /* !! */  = new File((String)var2_6);
                    var3_7 = var1_1 /* !! */ .exists();
                    if (!var3_7) break block41;
                    var1_1 /* !! */ .delete();
                }
                try {
                    var2_6 = new FileOutputStream(var1_1 /* !! */ );
                    break block42;
                }
                catch (FileNotFoundException var1_2) {
                }
                catch (IllegalStateException var1_3) {
                    // empty catch block
                }
                var2_6 = this.g;
                if (var2_6 != null) {
                    var2_6.d((Exception)var1_1 /* !! */ );
                }
                var3_7 = false;
                var2_6 = null;
            }
            while ((var1_1 /* !! */  = this.c) == (var4_8 = AudioRecorder$Status.STATUS_START)) {
                block44: {
                    var8_12 = -3;
                    var1_1 /* !! */  = this.b;
                    var5_9 /* !! */  = this.h;
                    var6_10 = var5_9 /* !! */ .length;
                    var7_11 = var1_1 /* !! */ .read(var5_9 /* !! */ , 0, var6_10);
                    if (var8_12 == var7_11 || var2_6 == null) continue;
                    var5_9 /* !! */  = (short[])this.c;
                    if (var5_9 /* !! */  != var4_8) continue;
                    var5_9 /* !! */  = this.h;
                    var6_10 = var5_9 /* !! */ .length;
                    if (var7_11 != var6_10) continue;
                    var5_9 /* !! */  = this.a(var5_9 /* !! */ );
                    var6_10 = this.i;
                    var9_13 = var6_10;
                    var11_14 = this.j;
                    var13_15 = var9_13 == var11_14 ? 0 : (var9_13 < var11_14 ? -1 : 1);
                    if (var13_15 > 0) ** GOTO lbl106
                    var9_13 = var5_9 /* !! */ .length + var6_10;
                    var14_16 = var9_13 == var11_14 ? 0 : (var9_13 < var11_14 ? -1 : 1);
                    var13_15 = 1;
                    if (var14_16 > 0) {
                        var14_16 = var13_15;
                    } else {
                        var14_16 = 0;
                        var4_8 = null;
                    }
                    if (var14_16 != false) {
                        var15_17 = var6_10;
                        var6_10 = (int)(var11_14 -= var15_17);
                        var5_9 /* !! */  = Arrays.copyOfRange((byte[])var5_9 /* !! */ , 0, var6_10);
                        var17_18 = this.h;
                        var6_10 >>= 1;
                        var18_19 /* !! */  = Arrays.copyOfRange(var17_18, 0, var6_10);
                        this.h = var18_19 /* !! */ ;
                    }
                    var2_6.write((byte[])var5_9 /* !! */ );
                    var6_10 = this.i;
                    var8_12 = var5_9 /* !! */ .length;
                    var6_10 += var8_12;
                    this.i = var6_10;
                    var5_9 /* !! */  = (short[])this.g;
                    if (var5_9 /* !! */  == null) break block44;
                    var18_19 /* !! */  = this.h;
                    var5_9 /* !! */ .a(var18_19 /* !! */ );
                    var5_9 /* !! */  = "readsize = %s,wave.length = %s";
                    var6_10 = 2;
                    var18_19 /* !! */  = (short[])new Object[var6_10];
                    var1_1 /* !! */  = Integer.valueOf(var7_11);
                    var18_19 /* !! */ [0] = (short)var1_1 /* !! */ ;
                    var1_1 /* !! */  = (File)this.h;
                    var7_11 = ((File)var1_1 /* !! */ ).length;
                    var1_1 /* !! */  = Integer.valueOf(var7_11);
                    var18_19 /* !! */ [var13_15] = (short)var1_1 /* !! */ ;
                    m.a.a.b((String)var5_9 /* !! */ , var18_19 /* !! */ );
                }
                if (var14_16 == false) continue;
                this.o();
                continue;
lbl106:
                // 1 sources

                var1_1 /* !! */  = this.c;
                if (var1_1 /* !! */  != var4_8) continue;
                try {
                    this.o();
                }
                catch (IOException var1_4) {
                    var4_8 = this.g;
                    if (var4_8 == null) continue;
                    var4_8.d(var1_4);
                }
            }
            if (var2_6 != null) {
                try {
                    var2_6.close();
                }
                catch (IOException var1_5) {
                    var2_6 = this.g;
                    if (var2_6 == null) break block45;
                    var2_6 = this.g;
                    var2_6.d(var1_5);
                }
            }
        }
    }

    public byte[] a(short[] sArray) {
        int n10;
        int n11 = sArray.length;
        int n12 = 2;
        byte[] byArray = new byte[n11 *= n12];
        for (int i10 = 0; i10 < (n10 = sArray.length); ++i10) {
            n10 = sArray[i10];
            byte[] byArray2 = this.h((short)n10);
            for (int i11 = 0; i11 < n12; ++i11) {
                byte by2;
                int n13 = i10 * 2 + i11;
                byArray[n13] = by2 = byArray2[i11];
            }
        }
        return byArray;
    }

    public void e() {
        AudioRecorder$Status audioRecorder$Status;
        this.d = null;
        this.c = audioRecorder$Status = AudioRecorder$Status.STATUS_NO_READY;
        audioRecorder$Status = this.b;
        if (audioRecorder$Status != null) {
            audioRecorder$Status.release();
            this.b = null;
        }
    }

    public void f(String string2, int n10, int n11, int n12, int n13) {
        AudioRecord audioRecord;
        int n14;
        int n15 = this.a = (n14 = AudioRecord.getMinBufferSize((int)n11, (int)n12, (int)n13));
        this.b = audioRecord = new AudioRecord(n10, n11, n12, n13, n15);
        this.d = string2;
    }

    public void g(String string2) {
        Object object;
        this.a = 6400;
        short[] sArray = new short[1600];
        this.h = sArray;
        int n10 = this.a;
        int n11 = 16000;
        int n12 = 16;
        int n13 = 2;
        int n14 = AudioRecord.getMinBufferSize((int)n11, (int)n12, (int)n13);
        if (n10 < n14) {
            this.a = n14;
        }
        int n15 = this.a;
        this.b = object = new AudioRecord(1, 16000, 16, 2, n15);
        this.d = string2;
        object = AudioRecorder$Status.STATUS_READY;
        this.c = object;
        object = new e(n11, n12, n13);
        this.f = object;
        this.e = string2 = string2.replace("pcm", "wav");
    }

    public byte[] h(short s10) {
        boolean bl2 = this.t();
        return this.i(s10, bl2);
    }

    public byte[] i(short s10, boolean n10) {
        int n11 = 2;
        byte[] byArray = new byte[n11];
        if (n10 != 0) {
            for (n10 = 1; n10 >= 0; n10 += -1) {
                byArray[n10] = n11 = (int)((byte)(s10 & 0xFF));
                s10 = (short)(s10 >> 8);
            }
        } else {
            for (n10 = 0; n10 < n11; ++n10) {
                byte by2;
                byArray[n10] = by2 = (byte)(s10 & 0xFF);
                s10 = (short)(s10 >> 8);
            }
        }
        return byArray;
    }

    public boolean k() {
        boolean bl2;
        AudioRecorder$Status audioRecorder$Status = this.c;
        AudioRecorder$Status audioRecorder$Status2 = AudioRecorder$Status.STATUS_START;
        if (audioRecorder$Status == audioRecorder$Status2) {
            bl2 = true;
        } else {
            bl2 = false;
            audioRecorder$Status = null;
        }
        return bl2;
    }

    public /* synthetic */ void n() {
        this.m();
    }

    public void p() {
        this.g = null;
    }

    public void r(AudioRecorder$b object) {
        int n10;
        this.g = object;
        Object object2 = this.c;
        Object object3 = AudioRecorder$Status.STATUS_NO_READY;
        if (object2 != object3 && (n10 = TextUtils.isEmpty((CharSequence)(object2 = this.d))) == 0) {
            long l10;
            object2 = this.c;
            object3 = AudioRecorder$Status.STATUS_START;
            if (object2 == object3) {
                object3 = "\u6b63\u5728\u5f55\u97f3";
                object2 = new IllegalStateException((String)object3);
                if (object != null) {
                    object.d((Exception)object2);
                }
                return;
            }
            this.i = 0;
            this.b.startRecording();
            this.c = object3;
            this.k = l10 = d.v.v.q.h.n();
            float f10 = d.v.v.q.h.y(l10);
            n10 = 1023611503;
            float f11 = 0.032f;
            this.j = l10 = (long)(f10 *= f11);
            object = this.g;
            if (object != null) {
                l10 = this.k;
                object.b(l10);
            }
            object2 = new d(this);
            object = new Thread((Runnable)object2);
            ((Thread)object).start();
            return;
        }
        object3 = "\u5f55\u97f3\u5c1a\u672a\u521d\u59cb\u5316,\u8bf7\u68c0\u67e5\u662f\u5426\u7981\u6b62\u4e86\u5f55\u97f3\u6743\u9650~";
        object2 = new IllegalStateException((String)object3);
        if (object != null) {
            object.d((Exception)object2);
        }
    }

    public void s() {
        d.v.v.g.h.k().B();
        long l10 = d.v.v.q.h.n();
        long l11 = this.k;
        this.j = l10 = (long)((float)(l10 - l11) / 500000.0f * 16000.0f);
    }

    public boolean t() {
        ByteOrder byteOrder;
        ByteOrder byteOrder2 = ByteOrder.nativeOrder();
        return byteOrder2 == (byteOrder = ByteOrder.BIG_ENDIAN);
    }
}

