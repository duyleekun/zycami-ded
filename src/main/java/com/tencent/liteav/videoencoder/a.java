/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$CodecException
 *  android.media.MediaCodecInfo
 *  android.media.MediaCodecInfo$CodecCapabilities
 *  android.media.MediaCodecInfo$CodecProfileLevel
 *  android.media.MediaCodecList
 *  android.media.MediaFormat
 *  android.opengl.EGLContext
 *  android.opengl.GLES20
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.opengl.b;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.k;
import com.tencent.liteav.basic.opengl.l;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.a$1;
import com.tencent.liteav.videoencoder.a$3;
import com.tencent.liteav.videoencoder.a$4;
import com.tencent.liteav.videoencoder.a$5;
import com.tencent.liteav.videoencoder.a$6;
import com.tencent.liteav.videoencoder.a$7;
import com.tencent.liteav.videoencoder.a$8;
import com.tencent.liteav.videoencoder.a$9;
import com.tencent.liteav.videoencoder.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLContext;

public class a
extends c {
    private boolean A;
    private boolean B;
    private boolean C;
    private ByteBuffer[] D;
    private byte[] E;
    private volatile long F;
    private long G;
    private long H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private boolean N;
    private boolean O;
    private boolean P;
    private int Q;
    private int R;
    private int S;
    private long T;
    private int U;
    private int V;
    private int W;
    private i X;
    private final Object Y;
    private boolean Z;
    private int a = 0;
    private ArrayList aa;
    private int ab;
    private boolean ac;
    private long ad;
    private int ae;
    private int af;
    private boolean ag;
    private boolean ah;
    private long ai;
    private Runnable aj;
    private long b;
    private double c;
    private long d;
    private long e;
    private int f;
    private boolean g;
    private boolean h;
    private long i;
    private long j;
    private long k;
    private long l;
    private long m;
    private long n;
    private boolean o;
    private boolean p;
    private long q;
    private long r;
    private MediaCodec s;
    private h t;
    private Runnable u;
    private Runnable v;
    private Runnable w;
    private ArrayDeque x;
    private Object y;
    private Surface z;

    public a() {
        Object object;
        boolean bl2;
        long l10;
        this.b = l10 = 0L;
        this.c = 0.0;
        this.d = l10;
        this.e = l10;
        this.f = 0;
        this.g = false;
        this.h = bl2 = true;
        this.i = l10;
        this.j = l10;
        this.k = l10;
        this.l = l10;
        this.m = l10;
        this.n = l10;
        this.q = l10;
        this.r = l10;
        this.s = null;
        this.t = null;
        ArrayDeque arrayDeque = new ArrayDeque(this);
        this.u = arrayDeque;
        super(this);
        this.v = arrayDeque;
        super(this);
        this.w = arrayDeque;
        this.x = arrayDeque = new ArrayDeque(10);
        this.z = null;
        this.A = bl2;
        this.B = bl2;
        this.C = false;
        this.D = null;
        this.E = null;
        this.F = l10;
        this.G = l10;
        this.H = l10;
        this.O = bl2;
        this.P = false;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.T = l10;
        this.U = 0;
        this.V = 0;
        this.W = -1;
        this.Y = object = new Object();
        this.Z = false;
        this.ab = 0;
        this.ac = bl2;
        this.ad = l10;
        this.ae = 3;
        this.af = 0;
        this.ag = false;
        this.ah = bl2;
        this.ai = l10;
        Object object2 = new a$3(this);
        this.aj = object2;
        this.t = object2 = new h("HWVideoEncoder");
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int a(int var1_1) {
        block62: {
            block60: {
                block63: {
                    block59: {
                        var2_2 = this;
                        var3_3 = "TXCHWVideoEncoder";
                        var4_4 = this.s;
                        var5_11 = -1;
                        if (var4_4 == null) {
                            return var5_11;
                        }
                        var4_4 = new MediaCodec.BufferInfo();
                        var6_12 /* !! */  = this.s;
                        var7_13 = var1_1;
                        var7_13 = var1_1 * 1000;
                        var8_14 = var7_13;
                        var10_15 = var6_12 /* !! */ .dequeueOutputBuffer((MediaCodec.BufferInfo)var4_4, var8_14);
                        if (var10_15 == var5_11) {
                            return 0;
                        }
                        var11_16 = -3;
                        var12_17 = 1;
                        var13_18 = 1.4E-45f;
                        if (var10_15 != var11_16) break block59;
                        var4_4 = this.s.getOutputBuffers();
                        this.D = var4_4;
                        return var12_17;
                    }
                    var14_19 = -2;
                    if (var10_15 == var14_19) {
                        try {
                            var4_4 = this.s;
                        }
                        catch (IllegalStateException var4_5) {
                            var6_12 /* !! */  = new StringBuilder();
                            var6_12 /* !! */ .append("mediacodec getOutputFormat failed.");
                            var6_12 /* !! */ .append(var4_5);
                            var4_6 = var6_12 /* !! */ .toString();
                            TXCLog.e(var3_3, var4_6);
                            return var5_11;
                        }
                        var4_4 = var4_4.getOutputFormat();
                        this.callDelegate((MediaFormat)var4_4);
                        return var12_17;
                    }
                    if (var10_15 < 0) {
                        return var5_11;
                    }
                    var15_20 = TXCTimeUtil.getTimeTick();
                    var6_12 /* !! */  = this.D;
                    var17_21 = var6_12 /* !! */ [var10_15];
                    if (var17_21 == null) lbl-1000:
                    // 3 sources

                    {
                        while (true) {
                            var18_27 = var10_15;
                            var7_13 = 0;
                            var19_22 = null;
                            var6_12 /* !! */  = var2_2;
                            var20_28 = var3_3;
                            break block60;
                            break;
                        }
                    }
                    var11_16 = var4_4.size;
                    var19_22 = new byte[var11_16];
                    var21_24 /* !! */  = var4_4.offset;
                    var17_21.position(var21_24 /* !! */ );
                    var21_24 /* !! */  = var4_4.offset;
                    var22_29 /* !! */  = var4_4.size;
                    var17_21.limit(var21_24 /* !! */  += var22_29 /* !! */ );
                    var21_24 /* !! */  = var4_4.size;
                    var17_21.get((byte[])var19_22, 0, var21_24 /* !! */ );
                    var21_24 /* !! */  = var4_4.size;
                    var22_29 /* !! */  = 5;
                    var23_30 = 4;
                    var24_31 = 2;
                    if (var21_24 /* !! */  > var22_29 /* !! */  && (var21_24 /* !! */  = (int)var19_22[0]) == 0 && (var21_24 /* !! */  = (int)var19_22[var12_17]) == 0 && (var21_24 /* !! */  = (int)var19_22[var24_31]) == 0 && (var25_32 /* !! */  = var19_22[var21_24 /* !! */  = 3]) == false && (var25_32 /* !! */  = var19_22[var23_30]) == false && (var22_29 /* !! */  = (int)var19_22[var22_29 /* !! */ ]) == 0) {
                        block61: {
                            while (var21_24 /* !! */  < (var22_29 /* !! */  = var11_16 + -4)) {
                                var22_29 /* !! */  = (int)var19_22[var21_24 /* !! */ ];
                                if (var22_29 /* !! */  == 0) {
                                    var22_29 /* !! */  = var21_24 /* !! */  + 1;
                                    if ((var22_29 /* !! */  = (int)var19_22[var22_29 /* !! */ ]) == 0) {
                                        var22_29 /* !! */  = var21_24 /* !! */  + 2;
                                        if ((var22_29 /* !! */  = (int)var19_22[var22_29 /* !! */ ]) == 0) {
                                            var22_29 /* !! */  = var21_24 /* !! */  + 3;
                                            if ((var22_29 /* !! */  = (int)var19_22[var22_29 /* !! */ ]) == var12_17) {
                                                var11_16 -= var21_24 /* !! */ ;
                                                break block61;
                                            }
                                        }
                                    }
                                }
                                ++var21_24 /* !! */ ;
                            }
                            var21_24 /* !! */  = 0;
                            var26_25 = null;
                        }
                        var27_33 = new byte[var11_16];
                        System.arraycopy(var19_22, var21_24 /* !! */ , var27_33, 0, var11_16);
                    } else {
                        var27_33 = var19_22;
                    }
                    var11_16 = var4_4.size;
                    var28_34 = 0;
                    var29_35 = null;
                    if (var11_16 != 0) break block63;
                    var30_36 = var4_4.flags & 4;
                    if (var30_36 != 0) {
                        var4_4 = var2_2.mListener;
                        if (var4_4 != null) {
                            var4_4.a(null, 0);
                        }
                        var5_11 = var14_19;
                    }
                    ** GOTO lbl-1000
                }
                var11_16 = var4_4.flags;
                var21_24 /* !! */  = var11_16 & 2;
                if (var21_24 /* !! */  == var24_31) {
                    var30_37 = var2_2.g;
                    if (var30_37) {
                        var4_4 = (byte[])var27_33.clone();
                        var2_2.E = (byte[])var4_4;
                    } else {
                        var4_4 = (byte[])var27_33.clone();
                        var4_4 = var2_2.a((byte[])var4_4);
                        var2_2.E = (byte[])var4_4;
                    }
                    var5_11 = var12_17;
                    ** continue;
                }
                if ((var11_16 &= var12_17) == var12_17) {
                    var2_2.I = var5_11;
                    var5_11 = (int)var2_2.g;
                    if (var5_11 != 0) {
                        var31_39 = var2_2.E;
                        var11_16 = ((byte[])var31_39).length;
                        var21_24 /* !! */  = ((Object)var27_33).length;
                        var6_12 /* !! */  = (ByteBuffer[])new byte[var11_16 += var21_24 /* !! */ ];
                        var21_24 /* !! */  = ((byte[])var31_39).length;
                        System.arraycopy(var31_39, 0, var6_12 /* !! */ , 0, var21_24 /* !! */ );
                        var31_39 = var2_2.E;
                        var5_11 = ((byte[])var31_39).length;
                        var21_24 /* !! */  = ((Object)var27_33).length;
                        System.arraycopy(var27_33, 0, var6_12 /* !! */ , var5_11, var21_24 /* !! */ );
                    } else {
                        var31_39 = var2_2.a((byte[])var27_33);
                        var6_12 /* !! */  = (ByteBuffer[])var2_2.E;
                        var21_24 /* !! */  = var6_12 /* !! */ .length;
                        var22_29 /* !! */  = ((byte[])var31_39).length;
                        var26_25 = new byte[var21_24 /* !! */  += var22_29 /* !! */ ];
                        var22_29 /* !! */  = var6_12 /* !! */ .length;
                        System.arraycopy(var6_12 /* !! */ , 0, var26_25, 0, var22_29 /* !! */ );
                        var11_16 = var2_2.E.length;
                        var22_29 /* !! */  = ((byte[])var31_39).length;
                        System.arraycopy(var31_39, 0, var26_25, var11_16, var22_29 /* !! */ );
                        var6_12 /* !! */  = var26_25;
                    }
                    var21_24 /* !! */  = 0;
                    var26_25 = null;
                } else {
                    var5_11 = (int)var2_2.g;
                    if (var5_11 == 0) {
                        var31_39 = var2_2.a((byte[])var27_33);
                        var6_12 /* !! */  = (ByteBuffer[])var31_39;
                    } else {
                        var6_12 /* !! */  = var27_33;
                    }
                    var21_24 /* !! */  = var12_17;
                }
                var5_11 = (int)var2_2.N;
                if (var5_11 == 0) {
                    var2_2.I = var5_11 = var2_2.I + var12_17;
                    var22_29 /* !! */  = var2_2.f;
                    var25_32 /* !! */  = var2_2.J;
                    if (var5_11 == (var22_29 /* !! */  *= var25_32 /* !! */ )) {
                        this.f();
                    }
                }
                var1_1 = var10_15;
                var32_40 = this.a();
                var34_41 = var4_4.presentationTimeUs;
                var36_42 = 1000L;
                var38_43 = var2_2.n;
                cfr_temp_0 = (var34_41 /= var36_42) - var38_43;
                var5_11 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var5_11 < 0 && (var5_11 = (int)var2_2.o) == 0) {
                    var2_2.o = true;
                    var31_39 = new StringBuilder;
                    var31_39();
                    var31_39.append("[Encoder] pts error, maybe have b frames. profile:");
                    var28_34 = var2_2.M;
                    var31_39.append(var28_34);
                    var31_39.append(" device:");
                    var29_35 = TXCCommonUtil.getDeviceInfo();
                    var31_39.append((String)var29_35);
                    var31_39.append(" last pts:");
                    var38_43 = var2_2.n;
                    var31_39.append(var38_43);
                    var31_39.append(" current pts:");
                    var31_39.append(var34_41);
                    var31_39 = var31_39.toString();
                    TXCLog.e(var3_3, (String)var31_39);
                    var29_35 = "";
                    var22_29 /* !! */  = 2;
                    Monitor.a(var22_29 /* !! */ , (String)var31_39, (String)var29_35, 0);
                    var31_39 = com.tencent.liteav.basic.c.c.a();
                    var31_39.a(false);
                    var5_11 = var2_2.M;
                    var12_17 = 1;
                    var13_18 = 1.4E-45f;
                    if (var5_11 != var12_17) {
                        var2_2.M = var12_17;
                        var31_39 = "[Encoder] force reset profile to baseline when recv b frame.";
                        TXCLog.e(var3_3, (String)var31_39);
                    }
                    TXCLog.i(var3_3, "[Encoder] post restart encoder task.");
                    var31_39 = var2_2.t;
                    if (var31_39 != null) {
                        var27_33 = var2_2.aj;
                        var31_39.b((Runnable)var27_33);
                    }
                } else {
                    var12_17 = 1;
                    var13_18 = 1.4E-45f;
                }
                var2_2.n = var34_41;
                var40_44 = var2_2.H;
                var42_45 = 0L;
                var5_11 = (int)(var40_44 == var42_45 ? 0 : (var40_44 < var42_45 ? -1 : 1));
                var44_46 = this;
                var45_47 = var32_40;
                if (var5_11 == 0) {
                    this.H = var32_40;
                }
                var47_48 = var3_3;
                var48_49 = var44_46.G;
                var50_50 = 0L;
                cfr_temp_1 = var48_49 - var50_50;
                var5_11 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var5_11 == 0) {
                    var44_46.G = var34_41;
                }
                var48_49 = var44_46.H;
                var52_51 = var17_21;
                var53_52 = var44_46.G;
                var48_49 = var48_49 - var53_52 + var34_41;
                var55_53 = var44_46.m;
                var5_11 = (int)(var45_47 == var55_53 ? 0 : (var45_47 < var55_53 ? -1 : 1));
                var57_54 = 1L;
                var59_55 = 4.9E-324;
                var55_53 = var5_11 <= 0 ? (var55_53 += var57_54) : var45_47;
                var5_11 = (int)(var55_53 == var48_49 ? 0 : (var55_53 < var48_49 ? -1 : 1));
                if (var5_11 > 0) {
                    var55_53 = var48_49;
                }
                var44_46.m = var55_53;
                var55_53 = TXCTimeUtil.getTimeTick();
                if (var21_24 /* !! */  == 0) {
                    var45_47 = var44_46.d;
                    cfr_temp_2 = var55_53 - (var36_42 = var45_47 + var36_42);
                    var5_11 = (int)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
                    if (var5_11 > 0) {
                        var59_55 = var44_46.q;
                        var61_56 = 8000.0;
                        var59_55 *= var61_56;
                        var63_57 = var55_53 - var45_47;
                        var59_55 /= var63_57;
                        var45_47 = 0x4090000000000000L;
                        var63_57 = 1024.0;
                        var44_46.b = var57_54 = (long)(var59_55 / var63_57);
                        var57_54 = 0L;
                        var59_55 = 0.0;
                        var44_46.q = var57_54;
                        var44_46.d = var55_53;
                        this.g();
                    } else {
                        var57_54 = 0L;
                        var59_55 = 0.0;
                    }
                    var45_47 = var44_46.j;
                    var36_42 = 1L;
                    var44_46.j = var45_47 += var36_42;
                    var50_50 = var45_47 % 256L;
                    var5_11 = (int)(var50_50 == var57_54 ? 0 : (var50_50 < var57_54 ? -1 : 1));
                    if (var5_11 == 0) {
                        var44_46.j = var45_47 += var36_42;
                    }
                    var44_46.k = var57_54;
                } else {
                    var36_42 = var57_54;
                    var44_46.k = var57_54 = var44_46.k + var36_42;
                }
                var57_54 = var44_46.q;
                var45_47 = var6_12 /* !! */ .length;
                var44_46.q = var57_54 += var45_47;
                var57_54 = var44_46.e;
                var63_57 = 9.88E-321;
                var45_47 = 2000L + var57_54;
                var5_11 = (int)(var55_53 == var45_47 ? 0 : (var55_53 < var45_47 ? -1 : 1));
                if (var5_11 > 0) {
                    var45_47 = var44_46.r;
                    var63_57 = var45_47;
                    var61_56 = 1000.0;
                    var63_57 *= var61_56;
                    var59_55 = var55_53 - var57_54;
                    var44_46.c = var63_57 /= var59_55;
                    var57_54 = 0L;
                    var59_55 = 0.0;
                    var44_46.r = var57_54;
                    var44_46.e = var55_53;
                    var31_39 = var44_46.aa.iterator();
                    while ((var22_29 /* !! */  = (int)var31_39.hasNext()) != 0) {
                        var27_33 = (Long)var31_39.next();
                        var45_47 = var27_33.longValue();
                        cfr_temp_3 = var45_47 - var57_54;
                        var24_31 = (int)(cfr_temp_3 == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1));
                        if (var24_31 <= 0) continue;
                        var57_54 = var55_53 = var27_33.longValue();
                    }
                    var31_39 = var44_46.aa;
                    var31_39.clear();
                    var55_53 = 3;
                    var44_46.ab = var5_11 = (int)(var57_54 *= var55_53);
                }
                var55_53 = var44_46.r;
                var57_54 = 1L;
                var59_55 = 4.9E-324;
                var44_46.r = var55_53 += var57_54;
                var5_11 = var4_4.offset;
                var52_51.position(var5_11);
                var44_46.l = var55_53 = var44_46.l + var57_54;
                var31_39 = var44_46.mListener;
                if (var31_39 != null) {
                    var65_58 = 2;
                    var55_53 = var44_46.j;
                    var57_54 = var44_46.k;
                    var31_39.a(var65_58, var55_53, var57_54);
                }
                if ((var5_11 = (int)var44_46.o) != 0) {
                    var31_39 = "[Encoder] drop all frame when find b frame.";
                    TXCLog.w(var47_48, (String)var31_39);
                    var18_27 = var1_1;
                    var6_12 /* !! */  = var44_46;
                    var20_28 = var47_48;
                    var66_59 = -2;
                    var67_60 = 1;
                } else {
                    var5_11 = (int)var44_46.h;
                    if (var5_11 != 0) {
                        var55_53 = var44_46.j;
                        var57_54 = var44_46.k;
                        var29_35 = var52_51;
                        var32_40 = var44_46.l;
                        var36_42 = var21_24 /* !! */  == 0 ? var57_54 : var57_54 - 1L;
                        var31_39 = this;
                        var7_13 = var21_24 /* !! */ ;
                        var68_61 = var55_53;
                        var34_41 = var57_54;
                        var70_62 = var29_35;
                        var53_52 = var32_40;
                        var66_59 = -2;
                        var67_60 = 1;
                        var40_44 = var36_42;
                        var18_27 = var1_1;
                        var45_47 = var48_49;
                        var20_28 = var47_48;
                        this.callDelegate((byte[])var6_12 /* !! */ , var21_24 /* !! */ , var55_53, var57_54, var32_40, var36_42, var48_49, var48_49, 0, (ByteBuffer)var29_35, (MediaCodec.BufferInfo)var4_4);
                    } else {
                        var18_27 = var1_1;
                        var70_63 = var52_51;
                        var20_28 = var47_48;
                        var66_59 = -2;
                        var67_60 = 1;
                        var55_53 = var44_46.j;
                        var57_54 = var44_46.k;
                        var38_43 = var44_46.l;
                        var71_64 = var21_24 /* !! */  == 0 ? var57_54 : (var73_65 = var57_54 - 1L);
                        var31_39 = this;
                        var6_12 /* !! */  = var19_22;
                        var7_13 = var21_24 /* !! */ ;
                        var68_61 = var55_53;
                        var34_41 = var57_54;
                        var53_52 = var38_43;
                        var40_44 = var71_64;
                        var45_47 = var48_49;
                        this.callDelegate((byte[])var19_22, var21_24 /* !! */ , var55_53, var57_54, var38_43, var71_64, var48_49, var48_49, 0, var70_63, (MediaCodec.BufferInfo)var4_4);
                    }
                    var6_12 /* !! */  = this;
                }
                var6_12 /* !! */ .R = var5_11 = var6_12 /* !! */ .R + 1;
                var30_38 = var4_4.flags & 4;
                if (var30_38 != 0) {
                    var4_4 = var6_12 /* !! */ .mListener;
                    if (var4_4 != null) {
                        var5_11 = 0;
                        var31_39 = null;
                        var7_13 = 0;
                        var19_22 = null;
                        var4_4.a(null, 0);
                    } else {
                        var7_13 = 0;
                        var19_22 = null;
                    }
                    var5_11 = var66_59;
                } else {
                    var7_13 = 0;
                    var19_22 = null;
                    var5_11 = var67_60;
                }
                var68_61 = TXCTimeUtil.getTimeTick();
                var4_4 = var6_12 /* !! */ .aa;
                var26_25 = var68_61 -= var15_20;
                var4_4.add(var26_25);
            }
            var4_4 = var6_12 /* !! */ .s;
            if (var4_4 == null) break block62;
            var21_24 /* !! */  = var18_27;
            try {
                var4_4.releaseOutputBuffer(var18_27, false);
            }
            catch (IllegalStateException var4_7) {
                var19_22 = new StringBuilder;
                var19_22();
                var26_25 = "releaseOutputBuffer failed.";
                var19_22.append((String)var26_25);
                var4_8 = var4_7.getMessage();
                var19_22.append(var4_8);
                var4_8 = var19_22.toString();
                var19_22 = var20_28;
                TXCLog.e(var20_28, var4_8);
            }
        }
        return var5_11;
        catch (IllegalStateException var4_9) {
            var6_12 /* !! */  = var2_2;
            var19_23 = var3_3;
            var26_26 = new StringBuilder();
            var26_26.append("dequeueOutputBuffer failed.");
            var4_10 = var4_9.getMessage();
            var26_26.append(var4_10);
            var4_10 = var26_26.toString();
            TXCLog.e(var3_3, var4_10);
            return var5_11;
        }
    }

    private int a(int n10, int n11, byte[] byArray, byte[] byArray2, int n12) {
        if (n11 > 0 && n10 > n11) {
            n10 -= n11;
            int n13 = 4;
            Object object = new byte[n13];
            object = ByteBuffer.wrap(object);
            Object object2 = object.asIntBuffer();
            ((IntBuffer)object2).put(n10);
            object2 = ByteOrder.BIG_ENDIAN;
            object.order((ByteOrder)object2);
            object = object.array();
            object2 = null;
            System.arraycopy(object, 0, byArray, n12, n13);
            int n14 = n12 + 4;
            try {
                System.arraycopy(byArray2, n11, byArray, n14, n10);
                n12 += (n10 += n13);
            }
            catch (Exception exception) {
                String string2 = "TXCHWVideoEncoder";
                String string3 = "setNalData exception";
                TXCLog.e(string2, string3);
            }
        }
        return n12;
    }

    private long a() {
        Long l10 = (Long)this.x.poll();
        long l11 = l10 == null ? 0L : l10;
        return l11;
    }

    private static MediaCodecInfo a(String string2) {
        int n10 = MediaCodecList.getCodecCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            MediaCodecInfo mediaCodecInfo = MediaCodecList.getCodecInfoAt((int)i10);
            boolean bl2 = mediaCodecInfo.isEncoder();
            if (!bl2) continue;
            for (String string3 : mediaCodecInfo.getSupportedTypes()) {
                boolean bl3 = string3.equalsIgnoreCase(string2);
                if (!bl3) continue;
                return mediaCodecInfo;
            }
        }
        return null;
    }

    private MediaFormat a(int n10, int n11, int n12, int n13, int n14) {
        if (n10 != 0 && n11 != 0 && n12 != 0 && n13 != 0) {
            MediaFormat mediaFormat = MediaFormat.createVideoFormat((String)"video/avc", (int)n10, (int)n11);
            mediaFormat.setInteger("bitrate", n12 *= 1024);
            mediaFormat.setInteger("frame-rate", n13);
            mediaFormat.setInteger("color-format", 2130708361);
            mediaFormat.setInteger("i-frame-interval", n14);
            return mediaFormat;
        }
        return null;
    }

    private MediaFormat a(int n10, int n11, int n12, int n13, int n14, int n15, int n16, boolean n17) {
        MediaFormat mediaFormat = this.a(n10, n11, n12, n13, n14);
        if (mediaFormat == null) {
            return null;
        }
        n11 = Build.VERSION.SDK_INT;
        n12 = 21;
        if (n11 >= n12) {
            String string2 = "video/avc";
            Object object = com.tencent.liteav.videoencoder.a.a(string2);
            if (object == null) {
                return mediaFormat;
            }
            string2 = object.getCapabilitiesForType(string2);
            object = string2.getEncoderCapabilities();
            Object object2 = "bitrate-mode";
            if (n17 != 0) {
                mediaFormat.setInteger((String)object2, n15);
            } else {
                n17 = object.isBitrateModeSupported(n15);
                if (n17 != 0) {
                    mediaFormat.setInteger((String)object2, n15);
                } else {
                    n15 = (int)(this.N ? 1 : 0);
                    n17 = 2;
                    if (n15 != 0) {
                        n15 = 1;
                        boolean bl2 = object.isBitrateModeSupported(n15);
                        if (bl2) {
                            mediaFormat.setInteger((String)object2, n15);
                        } else {
                            n15 = (int)(object.isBitrateModeSupported(n17) ? 1 : 0);
                            if (n15 != 0) {
                                mediaFormat.setInteger((String)object2, n17);
                            }
                        }
                    } else {
                        n15 = (int)(object.isBitrateModeSupported(n17) ? 1 : 0);
                        if (n15 != 0) {
                            mediaFormat.setInteger((String)object2, n17);
                        }
                    }
                }
            }
            object = object.getComplexityRange();
            n14 = 5;
            object2 = n14;
            object = (Integer)object.clamp((Comparable)object2);
            n13 = (Integer)object;
            object2 = "complexity";
            mediaFormat.setInteger((String)object2, n13);
            n13 = 23;
            if (n11 >= n13) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArray = ((MediaCodecInfo.CodecCapabilities)string2).profileLevels;
                n12 = codecProfileLevelArray.length;
                object = null;
                n14 = 0;
                object2 = null;
                for (n13 = 0; n13 < n12; ++n13) {
                    Object object3 = codecProfileLevelArray[n13];
                    n17 = object3.profile;
                    if (n17 > n16 || n17 <= n14) continue;
                    object2 = "profile";
                    mediaFormat.setInteger((String)object2, n17);
                    n14 = object3.level;
                    object3 = "level";
                    mediaFormat.setInteger((String)object3, n14);
                    n14 = n17;
                }
            }
        }
        return mediaFormat;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(int n10, int n11) {
        Object object = "createCopyTexture";
        TXCLog.i("TXCHWVideoEncoder", (String)object);
        Object object2 = this.Y;
        synchronized (object2) {
            this.X = object = new i();
            boolean bl2 = true;
            ((i)object).a(bl2);
            object = this.X;
            ((i)object).a();
            object = this.X;
            ((i)object).a(n10, n11);
            return;
        }
    }

    private void a(long l10) {
        ArrayDeque arrayDeque = this.x;
        Long l11 = l10;
        arrayDeque.add(l11);
    }

    public static /* synthetic */ void a(a a10) {
        a10.e();
    }

    public static /* synthetic */ void a(a a10, int n10) {
        a10.d(n10);
    }

    public static /* synthetic */ void a(a a10, long l10) {
        a10.a(l10);
    }

    private boolean a(Surface object, int n10, int n11) {
        boolean bl2;
        if (object == null) {
            return false;
        }
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("HWVideoEncode createGL: ");
        Object object3 = this.mGLContextExternal;
        ((StringBuilder)object2).append(object3);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i("TXCHWVideoEncoder", (String)object2);
        object2 = this.mGLContextExternal;
        object3 = null;
        if (object2 != null && (bl2 = object2 instanceof android.opengl.EGLContext)) {
            object2 = (android.opengl.EGLContext)object2;
            this.y = object = com.tencent.liteav.basic.opengl.c.a(null, (android.opengl.EGLContext)object2, (Surface)object, n10, n11);
        } else {
            object2 = (EGLContext)object2;
            this.y = object = com.tencent.liteav.basic.opengl.b.a(null, (EGLContext)object2, (Surface)object, n10, n11);
        }
        object = this.y;
        if (object == null) {
            return false;
        }
        float f10 = 1.0f;
        GLES20.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)f10);
        object = new i();
        this.mEncodeFilter = object;
        object2 = com.tencent.liteav.basic.opengl.l.e;
        float[] fArray = com.tencent.liteav.basic.opengl.l.a(com.tencent.liteav.basic.opengl.k.a, false, false);
        ((i)object).a((float[])object2, fArray);
        object = this.mEncodeFilter;
        boolean bl3 = ((i)object).a();
        if (!bl3) {
            this.mEncodeFilter = null;
            return false;
        }
        GLES20.glViewport((int)0, (int)0, (int)n10, (int)n11);
        return true;
    }

    /*
     * Exception decompiling
     */
    private boolean a(TXSVideoEncoderParam var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:461)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:250)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:673)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:717)
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

    public static /* synthetic */ boolean a(a a10, TXSVideoEncoderParam tXSVideoEncoderParam) {
        return a10.a(tXSVideoEncoderParam);
    }

    public static /* synthetic */ boolean a(a a10, boolean bl2) {
        a10.A = bl2;
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private byte[] a(byte[] byArray) {
        int n10;
        int n11;
        int n12;
        byte[] byArray2;
        block6: {
            int n13;
            int n14 = byArray.length;
            int n15 = n14 + 20;
            byArray2 = new byte[n15];
            n12 = 0;
            n11 = 0;
            for (n13 = 0; n13 < n14; ++n13) {
                int n16;
                int n17;
                block9: {
                    block8: {
                        block7: {
                            n17 = byArray[n13];
                            n16 = 1;
                            if (n17 != 0) break block7;
                            n17 = n13 + 1;
                            if ((n17 = byArray[n17]) != 0) break block7;
                            n17 = n13 + 2;
                            if ((n17 = byArray[n17]) != n16) break block7;
                            n10 = n13;
                            n11 = this.a(n13, n12, byArray2, byArray, n11);
                            n12 = n13 + 3;
                            break block8;
                        }
                        if ((n17 = byArray[n13]) != 0) break block9;
                        n17 = n13 + 1;
                        if ((n17 = byArray[n17]) != 0) break block9;
                        n17 = n13 + 2;
                        if ((n17 = byArray[n17]) != 0) break block9;
                        n17 = n13 + 3;
                        if ((n17 = byArray[n17]) != n16) break block9;
                        n10 = n13;
                        n11 = this.a(n13, n12, byArray2, byArray, n11);
                        n12 = n13 + 4;
                    }
                    n13 = n12;
                }
                if (n13 != (n17 = n14 + -4)) continue;
                n17 = n13 + 1;
                if ((n17 = byArray[n17]) == 0) {
                    n17 = n13 + 2;
                    if ((n17 = byArray[n17]) == 0) {
                        n17 = n13 + 3;
                        if ((n17 = byArray[n17]) == n16) continue;
                    }
                }
                n10 = n14;
                break block6;
            }
            n10 = n13;
        }
        int n18 = this.a(n10, n12, byArray2, byArray, n11);
        byte[] byArray3 = new byte[n18];
        System.arraycopy(byArray2, 0, byArray3, 0, n18);
        return byArray3;
    }

    public static /* synthetic */ long b(a a10, long l10) {
        a10.ai = l10;
        return l10;
    }

    private void b() {
        boolean bl2;
        TXCLog.i("TXCHWVideoEncoder", "HWVideoEncode destroyGL");
        Object object = this.mEncodeFilter;
        if (object != null) {
            ((i)object).d();
            this.mEncodeFilter = null;
        }
        if (bl2 = (object = this.y) instanceof b) {
            object = (b)object;
            ((b)object).c();
            this.y = null;
        }
        if (bl2 = (object = this.y) instanceof com.tencent.liteav.basic.opengl.c) {
            object = (com.tencent.liteav.basic.opengl.c)object;
            ((com.tencent.liteav.basic.opengl.c)object).d();
            this.y = null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b(int n10) {
        int n11;
        int n12 = (int)(this.A ? 1 : 0);
        int n13 = 1;
        if (n12 == n13) return;
        Object object = this.y;
        if (object == null) {
            return;
        }
        object = this.Y;
        synchronized (object) {
            int n14;
            float f10;
            int n15;
            Object object2;
            Object object3;
            int n16 = this.W;
            int n17 = this.O;
            n11 = -1;
            if (n17 != 0) {
                this.W = n11;
                if (n16 == n11) {
                    this.Z = n13;
                    return;
                }
                this.V = n17 = this.V + n13;
                object3 = this.t;
                object2 = this.v;
                n15 = 1000;
                f10 = 1.401E-42f;
                n14 = this.K;
                long l10 = n15 /= n14;
                ((h)object3).a((Runnable)object2, l10);
            }
            if (n16 == n11) {
                return;
            }
            long l11 = this.F;
            this.a(l11);
            n17 = this.mRotation;
            n17 = 720 - n17;
            int n18 = n17 % 360;
            n17 = 270;
            float f11 = 3.78E-43f;
            int n19 = 90;
            n15 = n18 != n19 && n18 != n17 ? this.mOutputWidth : this.mOutputHeight;
            n17 = n18 != n19 && n18 != n17 ? this.mOutputHeight : this.mOutputWidth;
            object2 = this.mEncodeFilter;
            n14 = this.mInputWidth;
            int n20 = this.mInputHeight;
            f10 = n15;
            f11 = n17;
            f11 = f10 / f11;
            boolean bl2 = this.mEnableXMirror;
            boolean bl3 = true;
            n15 = n14;
            n14 = n20;
            n20 = 0;
            ((i)object2).a(n15, n14, n18, null, f11, bl2, bl3);
            object3 = this.mEncodeFilter;
            ((i)object3).a(n16);
            Object object4 = this.y;
            n17 = object4 instanceof com.tencent.liteav.basic.opengl.c;
            if (n17 != 0) {
                object4 = (com.tencent.liteav.basic.opengl.c)object4;
                l11 = this.F;
                long l12 = 1000000L;
                ((com.tencent.liteav.basic.opengl.c)object4).a(l11 *= l12);
                object4 = this.y;
                object4 = (com.tencent.liteav.basic.opengl.c)object4;
                ((com.tencent.liteav.basic.opengl.c)object4).e();
            }
            if ((n17 = (object4 = this.y) instanceof b) != 0) {
                object4 = (b)object4;
                ((b)object4).a();
            }
        }
        while ((n12 = this.a(n10)) > 0) {
        }
        if (n12 != n11 && n12 != (n10 = -2)) {
            this.Q = n10 = this.Q + n13;
            return;
        }
        if (n12 == n11) {
            n10 = 10000005;
            this.callDelegate(n10);
        }
        this.A = n13;
        this.e();
    }

    public static /* synthetic */ void b(a a10, int n10) {
        a10.c(n10);
    }

    public static /* synthetic */ boolean b(a a10) {
        return a10.A;
    }

    public static /* synthetic */ int c(a a10, int n10) {
        return a10.a(n10);
    }

    public static /* synthetic */ Object c(a a10) {
        return a10.y;
    }

    private void c(int n10) {
        Object object;
        long l10;
        CharSequence charSequence;
        n10 = (int)(this.mInit ? 1 : 0);
        if (n10 == 0) {
            return;
        }
        long l11 = this.i;
        n10 = this.a;
        long l12 = n10;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            return;
        }
        l12 = n10;
        n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
        int n11 = 0;
        Runnable runnable = null;
        if (n10 < 0 && (n10 = (int)(this.ah ? 1 : 0)) != 0) {
            n10 = (int)(this.ag ? 1 : 0);
            if (n10 != 0) {
                n10 = 1;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("restart video hw encoder when down bps\u3002[module:");
                String string2 = Build.MODEL;
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("] [Hardware:");
                string2 = Build.HARDWARE;
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append("] [osVersion:");
                string2 = Build.VERSION.RELEASE;
                ((StringBuilder)charSequence).append(string2);
                string2 = "]";
                ((StringBuilder)charSequence).append(string2);
                charSequence = ((StringBuilder)charSequence).toString();
                object2 = 4;
                String string3 = "";
                Monitor.a((int)object2, (String)charSequence, string3, 0);
                n11 = n10;
            } else {
                this.ae = 3;
                this.ad = l10 = System.currentTimeMillis();
                this.af = n10 = this.a;
            }
        }
        this.i = l10 = (long)this.a;
        n10 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n10 >= n12 && (object = this.s) != null) {
            if (n11 != 0) {
                object = this.t.a();
                runnable = this.aj;
                object.removeCallbacks(runnable);
                l11 = System.currentTimeMillis();
                l12 = this.ai;
                long l14 = l11 - l12;
                long l15 = 2000L;
                n10 = (int)(l14 == l15 ? 0 : (l14 < l15 ? -1 : 1));
                if (n10 >= 0) {
                    object = this.aj;
                    object.run();
                } else {
                    object = this.t;
                    Runnable runnable2 = this.aj;
                    ((h)object).a(runnable2, l15 -= (l11 -= l12));
                }
            } else {
                object = new Bundle();
                n11 = this.a * 1024;
                charSequence = "video-bitrate";
                object.putInt((String)charSequence, n11);
                runnable = this.s;
                runnable.setParameters((Bundle)object);
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private boolean c() {
        block104: {
            block106: {
                block105: {
                    block100: {
                        block108: {
                            block107: {
                                block101: {
                                    block103: {
                                        block102: {
                                            block99: {
                                                block98: {
                                                    var1_1 = this;
                                                    var2_2 = "[Encoder] set fmt error. fmt:";
                                                    var3_3 = Build.VERSION.SDK_INT;
                                                    var4_4 = "TXCHWVideoEncoder";
                                                    var5_5 = 18;
                                                    if (var3_3 < var5_5) {
                                                        return false;
                                                    }
                                                    var6_6 = com.tencent.liteav.basic.c.c.a();
                                                    var7_20 = "Video";
                                                    var8_21 = "CheckVideoEncDownBps";
                                                    var9_22 = var6_6.a((String)var7_20, var8_21);
                                                    var11_23 = 0L;
                                                    var5_5 = (int)(var9_22 == var11_23 ? 0 : (var9_22 < var11_23 ? -1 : 1));
                                                    var13_24 = 1;
                                                    if (var5_5 > 0) {
                                                        var5_5 = var13_24;
                                                    } else {
                                                        var5_5 = 0;
                                                        var6_6 = null;
                                                    }
                                                    var1_1.ah = var5_5;
                                                    var1_1.o = false;
                                                    var1_1.Q = 0;
                                                    var1_1.R = 0;
                                                    var1_1.T = var11_23;
                                                    var1_1.U = 0;
                                                    var1_1.S = 0;
                                                    var1_1.V = 0;
                                                    var14_25 = 5;
                                                    var15_26 = 0;
                                                    var16_27 = var1_1.mOutputWidth;
                                                    var17_28 = var1_1.mOutputHeight;
                                                    var18_29 = var1_1.a;
                                                    var19_30 = var1_1.K;
                                                    var20_31 = var1_1.J;
                                                    var21_32 = var1_1.L;
                                                    var5_5 = var1_1.M;
                                                    var23_34 = var22_33 = (int)var1_1.P;
                                                    var7_20 = this;
                                                    var15_26 = var5_5;
                                                    var14_25 = var22_33;
                                                    var24_35 = this.a(var16_27, var17_28, var18_29, var19_30, var20_31, var21_32, var5_5, (boolean)var22_33);
                                                    if (var24_35 != null) break block98;
                                                    try {
                                                        var1_1.A = var13_24;
                                                        return false;
                                                    }
                                                    catch (Exception var6_7) {
                                                        var14_25 = var13_24;
                                                    }
                                                    break block100;
                                                }
                                                var6_6 = "video/avc";
                                                var6_6 = MediaCodec.createEncoderByType((String)var6_6);
                                                var1_1.s = var6_6;
                                                var23_34 = 2;
                                                var6_6 = var1_1.mEncFmt;
                                                if (var6_6 == null) break block99;
                                                var5_5 = 0;
                                                var6_6 = null;
                                                while (true) {
                                                    var7_20 = var1_1.mEncFmt;
                                                    var22_33 = var7_20.length();
                                                    if (var5_5 >= var22_33) break block99;
                                                    var7_20 = var1_1.mEncFmt;
                                                    var7_20 = var7_20.getJSONObject(var5_5);
                                                    var8_21 = "key";
                                                    var8_21 = var7_20.optString(var8_21);
                                                    var25_36 = "value";
                                                    var22_33 = var7_20.optInt(var25_36);
                                                    var24_35.setInteger(var8_21, var22_33);
                                                    ++var5_5;
                                                    continue;
                                                    break;
                                                }
                                                catch (Exception var6_8) {
                                                    try {
                                                        var7_20 = new StringBuilder();
                                                        var8_21 = "config custom format error ";
                                                    }
                                                    catch (Exception var6_9) {
                                                        var14_25 = var23_34;
                                                        break block100;
                                                    }
                                                    var7_20.append(var8_21);
                                                    var6_6 = var6_8.toString();
                                                    var7_20.append((String)var6_6);
                                                    var6_6 = var7_20.toString();
                                                    TXCLog.w(var4_4, (String)var6_6);
                                                }
                                            }
                                            var6_6 = var1_1.s;
                                            var15_26 = 0;
                                            try {
                                                var6_6.configure(var24_35, null, null, var13_24);
                                                break block101;
                                            }
                                            catch (Exception var6_10) {
                                                break block102;
                                            }
                                            catch (Exception var6_11) {
                                                var15_26 = 0;
                                            }
                                        }
                                        var26_37 = var6_6;
                                        var6_6 = new StringBuilder();
                                        var6_6.append(var2_2);
                                        var6_6.append(var24_35);
                                        var6_6 = var6_6.toString();
                                        TXCLog.i(var4_4, (String)var6_6);
                                        var26_37.printStackTrace();
                                        var5_5 = (int)var1_1.P;
                                        var20_31 = 21;
                                        if (var5_5 == 0) break block103;
                                        var16_27 = var1_1.mOutputWidth;
                                        var17_28 = var1_1.mOutputHeight;
                                        var18_29 = var1_1.a;
                                        var19_30 = var1_1.K;
                                        var5_5 = var1_1.J;
                                        var22_33 = var1_1.L;
                                        var15_26 = var1_1.M;
                                        var7_20 = this;
                                        var20_31 = var5_5;
                                        var27_38 = var26_37;
                                        var21_32 = var22_33;
                                        var28_39 = var24_35;
                                        var14_25 = 0;
                                        var24_35 = null;
                                        var6_6 = this.a(var16_27, var17_28, var18_29, var19_30, var5_5, var22_33, var15_26, false);
                                        var7_20 = var1_1.s;
                                        try {
                                            var7_20.configure((MediaFormat)var6_6, null, null, var13_24);
                                        }
                                        catch (Exception var6_12) {
                                            var7_20 = new StringBuilder();
                                            var7_20.append(var2_2);
                                            var8_21 = var28_39;
                                            var7_20.append(var28_39);
                                            var7_20 = var7_20.toString();
                                            TXCLog.i(var4_4, (String)var7_20);
                                            var22_33 = var6_12 instanceof IllegalArgumentException;
                                            if (var22_33 == 0 && (var3_3 < (var22_33 = 21) || (var5_5 = var6_12 instanceof MediaCodec.CodecException) == 0)) ** GOTO lbl196
                                            var16_27 = var1_1.mOutputWidth;
                                            var17_28 = var1_1.mOutputHeight;
                                            var18_29 = var1_1.a;
                                            var19_30 = var1_1.K;
                                            var20_31 = var1_1.J;
                                            var7_20 = this;
                                            var6_6 = this.a(var16_27, var17_28, var18_29, var19_30, var20_31);
                                            var7_20 = var1_1.s;
                                            var7_20.configure((MediaFormat)var6_6, null, null, var13_24);
lbl196:
                                            // 2 sources

                                            var27_38.printStackTrace();
                                        }
                                        break block101;
                                    }
                                    var7_20 = var26_37;
                                    var5_5 = var26_37 instanceof IllegalArgumentException;
                                    if (var5_5 != 0 || var3_3 >= (var16_27 = 21) && (var5_5 = var26_37 instanceof MediaCodec.CodecException) != 0) ** GOTO lbl204
                                    throw var7_20;
lbl204:
                                    // 1 sources

                                    var16_27 = var1_1.mOutputWidth;
                                    var17_28 = var1_1.mOutputHeight;
                                    var18_29 = var1_1.a;
                                    var19_30 = var1_1.K;
                                    var20_31 = var1_1.J;
                                    var7_20 = this;
                                    var6_6 = this.a(var16_27, var17_28, var18_29, var19_30, var20_31);
                                    var7_20 = var1_1.s;
                                    var7_20.configure((MediaFormat)var6_6, null, null, var13_24);
                                }
                                var14_25 = 3;
                                var6_6 = var1_1.s;
                                var6_6 = var6_6.createInputSurface();
                                var1_1.z = var6_6;
                                var14_25 = 4;
                                var6_6 = var1_1.s;
                                var6_6.start();
                                try {
                                    var6_6 = var1_1.s;
                                }
                                catch (Exception var6_13) {
                                    var14_25 = 5;
                                    break block100;
                                }
                                var6_6 = var6_6.getOutputBuffers();
                                var1_1.D = var6_6;
                                break block104;
                                catch (Exception var6_14) {}
                                {
                                    break block100;
                                    catch (Exception var6_15) {}
                                }
                                break block107;
                                catch (Exception var6_16) {}
                                break block107;
                                catch (Exception var6_17) {
                                    // empty catch block
                                }
                            }
                            var14_25 = var23_34;
                            break block100;
                            catch (Exception var6_18) {}
                            break block108;
                            catch (Exception var6_19) {
                                // empty catch block
                            }
                        }
                        var14_25 = var13_24;
                    }
                    var7_20 = "create encode format failed.";
                    TXCLog.e(var4_4, (String)var7_20, (Throwable)var6_6);
                    var22_33 = 5;
                    if (var14_25 >= var22_33) {
                        var6_6 = var1_1.s;
                        if (var6_6 == null) break block105;
                        var6_6.stop();
                    }
                }
                try {
                    var1_1.s = null;
                    var6_6 = var1_1.z;
                    if (var6_6 == null) break block106;
                }
                catch (Exception v0) {
                    ** continue;
                }
                var6_6.release();
            }
            var1_1.z = null;
        }
lbl283:
        // 2 sources

        while (true) {
            var6_6 = var1_1.s;
            if (var6_6 != null && (var6_6 = var1_1.D) != null && (var6_6 = var1_1.z) != null) {
                var22_33 = var1_1.mOutputWidth;
                var16_27 = var1_1.mOutputHeight;
                var5_5 = (int)var1_1.a((Surface)var6_6, var22_33, var16_27);
                if (var5_5 == 0) {
                    var1_1.A = var13_24;
                    return false;
                }
                return (boolean)var13_24;
            }
            var1_1.A = var13_24;
            return false;
        }
    }

    public static /* synthetic */ int d(a a10) {
        int n10;
        int n11 = a10.Q;
        a10.Q = n10 = n11 + 1;
        return n11;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void d() {
        String string2;
        Throwable throwable2222222;
        String string3;
        String string4;
        block13: {
            block14: {
                string4 = "release encoder failed.";
                string3 = "TXCHWVideoEncoder";
                MediaCodec mediaCodec = this.s;
                if (mediaCodec == null) {
                    return;
                }
                Object var4_8 = null;
                mediaCodec.stop();
                {
                    catch (Throwable throwable2222222) {
                        break block13;
                    }
                    catch (IllegalStateException illegalStateException) {}
                    string2 = "stop encoder failed.";
                    {
                        TXCLog.e(string3, string2, illegalStateException);
                    }
                    try {}
                    catch (Exception exception) {
                        TXCLog.e(string3, string4, exception);
                    }
                    MediaCodec mediaCodec2 = this.s;
                    mediaCodec2.release();
                    mediaCodec2 = this.z;
                    if (mediaCodec2 != null) {
                        mediaCodec2.release();
                    }
                    this.z = null;
                    break block14;
                }
                {
                    mediaCodec = this.s;
                    mediaCodec.release();
                    mediaCodec = this.z;
                    if (mediaCodec != null) {
                        mediaCodec.release();
                    }
                    this.z = null;
                }
            }
            this.s = null;
            return;
        }
        try {
            string2 = this.s;
            string2.release();
            string2 = this.z;
            if (string2 != null) {
                string2.release();
            }
            this.z = null;
            throw throwable2222222;
        }
        catch (Exception exception) {
            TXCLog.e(string3, string4, exception);
        }
        throw throwable2222222;
    }

    private void d(int n10) {
        int n11 = this.mInit;
        if (n11 == 0) {
            return;
        }
        if (n10 != 0 && (n11 = this.K) != n10) {
            n11 = Build.VERSION.SDK_INT;
            int n12 = 18;
            if (n11 < n12) {
                return;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append("set fps ");
            charSequence.append(n10);
            charSequence.append(", restart encoder.");
            charSequence = charSequence.toString();
            String string2 = "TXCHWVideoEncoder";
            TXCLog.i(string2, (String)charSequence);
            this.b();
            this.d();
            this.K = n10;
            this.c();
        }
    }

    public static /* synthetic */ void d(a a10, int n10) {
        a10.b(n10);
    }

    public static /* synthetic */ MediaCodec e(a a10) {
        return a10.s;
    }

    private void e() {
        long l10;
        boolean bl2 = this.mInit;
        if (!bl2) {
            return;
        }
        this.A = bl2 = true;
        this.B = bl2;
        this.b();
        this.d();
        this.W = -1;
        this.b = l10 = 0L;
        this.c = 0.0;
        this.d = l10;
        this.e = l10;
        this.f = 0;
        this.i = l10;
        this.j = l10;
        this.k = l10;
        this.l = l10;
        this.m = l10;
        this.q = l10;
        this.r = l10;
        this.mGLContextExternal = null;
        this.D = null;
        this.E = null;
        this.F = l10;
        this.mOutputWidth = 0;
        this.mOutputHeight = 0;
        this.mInit = false;
        this.mListener = null;
        this.x.clear();
        this.aa.clear();
        this.ab = 0;
    }

    private void f() {
        MediaCodec mediaCodec;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11 && (mediaCodec = this.s) != null) {
            mediaCodec = new Bundle();
            n11 = 0;
            String string2 = "request-sync";
            mediaCodec.putInt(string2, 0);
            MediaCodec mediaCodec2 = this.s;
            mediaCodec2.setParameters((Bundle)mediaCodec);
        }
    }

    public static /* synthetic */ void f(a a10) {
        a10.b();
    }

    private void g() {
        long l10 = this.ad;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            object = this.K;
            double d10 = this.c;
            int n10 = (int)d10;
            n10 = (int)(object - n10);
            int n11 = 5;
            if ((object /= 2) < n11) {
                object = n11;
            }
            if (n10 <= object) {
                l10 = System.currentTimeMillis();
                long l13 = this.ad;
                n11 = this.ae;
                int n12 = 3 - n11;
                int n13 = 1;
                long l14 = n12 = (n12 + n13) * 2000;
                long l15 = (l10 -= l13) - l14;
                object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object > 0) {
                    object = this.af;
                    l10 = object;
                    l14 = this.b;
                    l10 -= l14;
                    l14 = this.i / (long)2;
                    long l16 = 100;
                    long l17 = l14 - l16;
                    n12 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                    if (n12 < 0) {
                        l14 = l16;
                    }
                    if ((object = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1)) > 0) {
                        this.ag = n13;
                        Object object2 = new StringBuilder();
                        ((StringBuilder)object2).append("real bitrate is too much lower than target bitrate![current profile:");
                        n10 = this.M;
                        ((StringBuilder)object2).append(n10);
                        ((StringBuilder)object2).append("][targetBr:");
                        n10 = this.af;
                        ((StringBuilder)object2).append(n10);
                        ((StringBuilder)object2).append("] [realBr:");
                        l13 = this.b;
                        ((StringBuilder)object2).append(l13);
                        ((StringBuilder)object2).append("]. restart encoder. [module:");
                        Object object3 = Build.MODEL;
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append("] [Hardware:");
                        object3 = Build.HARDWARE;
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append("] [osVersion:");
                        object3 = Build.VERSION.RELEASE;
                        ((StringBuilder)object2).append((String)object3);
                        ((StringBuilder)object2).append("]");
                        object2 = ((StringBuilder)object2).toString();
                        object3 = "TXCHWVideoEncoder";
                        TXCLog.e((String)object3, (String)object2);
                        n11 = 0;
                        String string2 = null;
                        n12 = 3;
                        String string3 = "";
                        Monitor.a(n12, (String)object2, string3, 0);
                        object = this.M;
                        if (object != n13) {
                            this.M = n13;
                            object2 = new StringBuilder();
                            ((StringBuilder)object2).append("[Encoder] force reset profile to baseline when restart encoder. device:");
                            string2 = TXCCommonUtil.getDeviceInfo();
                            ((StringBuilder)object2).append(string2);
                            object2 = ((StringBuilder)object2).toString();
                            TXCLog.e((String)object3, (String)object2);
                        }
                        if ((object2 = this.t) != null) {
                            object3 = this.aj;
                            ((h)object2).b((Runnable)object3);
                        }
                        this.ad = l11;
                    } else {
                        this.ae = n11 -= n13;
                        if (n11 <= 0) {
                            this.ad = l11;
                        }
                    }
                }
            }
        }
    }

    public static /* synthetic */ void g(a a10) {
        a10.d();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void h() {
        Object object = "destroyCopyTexture";
        TXCLog.i("TXCHWVideoEncoder", (String)object);
        Object object2 = this.Y;
        synchronized (object2) {
            int n10;
            object = this.X;
            if (object != null) {
                ((i)object).d();
                n10 = 0;
                object = null;
                this.X = null;
            }
            this.W = n10 = -1;
            return;
        }
    }

    public static /* synthetic */ boolean h(a a10) {
        return a10.c();
    }

    public int getEncodeCost() {
        return this.ab;
    }

    public long getRealBitrate() {
        return this.b;
    }

    public double getRealFPS() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long pushVideoFrame(int n10, int n11, int n12, long l10) {
        long l11;
        long l12;
        Object object;
        Object[] objectArray;
        Object object2;
        Object object3;
        int n13;
        int n14 = this.B;
        if (n14 != 0) {
            return 10000004L;
        }
        Object object4 = this.Y;
        synchronized (object4) {
            i i10 = this.X;
            if (i10 == null) {
                this.a(n11, n12);
            }
            i10 = this.X;
            i10.a(n11, n12);
            i10 = null;
            GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
            i i11 = this.X;
            n10 = i11.b(n10);
            n13 = this.ac;
            if (n13 != 0) {
                GLES20.glFinish();
            } else {
                GLES20.glFlush();
            }
        }
        n14 = this.S;
        n13 = 1;
        this.S = n14 += n13;
        this.F = l10;
        this.W = n10;
        this.mInputWidth = n11;
        this.mInputHeight = n12;
        n10 = (int)(this.N ? 1 : 0);
        if (n10 != 0) {
            this.f();
        }
        if ((n10 = (int)(this.O ? 1 : 0)) == 0 || (n10 = (int)(this.Z ? 1 : 0)) != 0) {
            this.V = n10 = this.V + n13;
            object3 = this.t;
            object2 = this.v;
            ((h)object3).b((Runnable)object2);
            this.Z = false;
        }
        n10 = this.Q;
        n11 = this.R + 30;
        n12 = 2;
        if (n10 > n11) {
            object2 = "TXCHWVideoEncoder";
            objectArray = "hw encoder error when render[%d] pop[%d]";
            object = new Object[n12];
            object[0] = object3 = Integer.valueOf(n10);
            n10 = this.R;
            object[n13] = object3 = Integer.valueOf(n10);
            object3 = String.format((String)objectArray, object);
            TXCLog.e((String)object2, (String)object3);
            object3 = this.mListener;
            if (object3 != null) {
                n11 = this.mStreamType;
                object3.g(n11);
            }
        }
        if ((n10 = (int)((l12 = (l11 = this.T + 5000L) - (l10 = System.currentTimeMillis())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) < 0) {
            this.T = l11 = System.currentTimeMillis();
            n10 = this.U;
            if (n10 != 0 && n10 == (n11 = this.Q)) {
                int n15 = 4;
                objectArray = new Object[n15];
                objectArray[0] = object = Integer.valueOf(this.S);
                objectArray[n13] = object = Integer.valueOf(this.V);
                objectArray[n12] = object = Integer.valueOf(this.Q);
                n12 = 3;
                int n16 = this.R;
                objectArray[n12] = object = Integer.valueOf(n16);
                object2 = String.format("hw encoder error when push[%d] render task[%d] render[%d] pop[%d]", objectArray);
                TXCLog.i("TXCHWVideoEncoder", (String)object2);
                object3 = this.mListener;
                if (object3 != null) {
                    n11 = this.mStreamType;
                    object3.g(n11);
                }
            }
            this.U = n10 = this.Q;
        }
        return 0L;
    }

    public long pushVideoFrameAsync(int n10, int n11, int n12, long l10) {
        n11 = (int)(this.B ? 1 : 0);
        if (n11 != 0) {
            return 10000004L;
        }
        n11 = (int)(this.ac ? 1 : 0);
        if (n11 != 0) {
            GLES20.glFinish();
        } else {
            GLES20.glFlush();
        }
        n11 = (int)(this.N ? 1 : 0);
        if (n11 != 0) {
            this.f();
        }
        Handler handler = this.t.a();
        a$8 a$8 = new a$8(this, n10, l10);
        handler.post((Runnable)a$8);
        return 0L;
    }

    public long pushVideoFrameSync(int n10, int n11, int n12, long l10) {
        n11 = (int)(this.B ? 1 : 0);
        if (n11 != 0) {
            return 10000004L;
        }
        n11 = (int)(this.ac ? 1 : 0);
        if (n11 != 0) {
            GLES20.glFinish();
        } else {
            GLES20.glFlush();
        }
        this.F = l10;
        this.W = n10;
        n10 = (int)(this.N ? 1 : 0);
        if (n10 != 0) {
            this.f();
        }
        h h10 = this.t;
        Runnable runnable = this.w;
        h10.a(runnable);
        return 0L;
    }

    public void setBitrate(int n10) {
        this.a = n10;
        h h10 = this.t;
        a$6 a$6 = new a$6(this, n10);
        h10.b(a$6);
    }

    public void setBitrateFromQos(int n10, int n11) {
        this.a = n10;
        h h10 = this.t;
        a$7 a$7 = new a$7(this, n10);
        h10.b(a$7);
    }

    public void setEncodeIdrFpsFromQos(int n10) {
    }

    public void setFPS(int n10) {
        h h10 = this.t;
        a$5 a$5 = new a$5(this, n10);
        h10.b(a$5);
    }

    public void setGLFinishedTextureNeed(boolean bl2) {
        this.ac = bl2;
    }

    public void signalEOSAndFlush() {
        boolean bl2 = this.B;
        if (bl2) {
            return;
        }
        h h10 = this.t;
        a$9 a$9 = new a$9(this);
        h10.a(a$9);
    }

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        boolean bl2;
        super.start(tXSVideoEncoderParam);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 0;
        int n12 = 18;
        if (n10 < n12) {
            bl2 = false;
            tXSVideoEncoderParam = null;
        } else {
            h h10 = this.t;
            a$1 a$1 = new a$1(this, tXSVideoEncoderParam);
            h10.b(a$1);
            bl2 = true;
        }
        if (!bl2) {
            n11 = 10000004;
        }
        return n11;
    }

    public void stop() {
        this.B = true;
        h h10 = this.t;
        a$4 a$4 = new a$4(this);
        h10.b(a$4);
        this.h();
    }
}

