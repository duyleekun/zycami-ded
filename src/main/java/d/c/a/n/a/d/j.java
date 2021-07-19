/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.Log
 */
package d.c.a.n.a.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bumptech.glide.integration.webp.WebpHeaderParser$WebpImageType;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;
import d.c.a.n.a.d.j$a;
import d.c.a.o.b;
import d.c.a.o.f;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.d0;
import d.c.a.o.m.d.o;
import d.c.a.o.m.d.o$b;
import d.c.a.u.g;
import d.c.a.u.k;
import d.c.a.u.m;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

public final class j {
    private static final String e = "WebpDownsampler";
    public static final d.c.a.o.e f;
    private static final o$b g;
    private static final Queue h;
    private static final int i = 0xA00000;
    private static final int j = 1000000000;
    private final e a;
    private final DisplayMetrics b;
    private final d.c.a.o.k.x.b c;
    private final List d;

    static {
        Object object = Boolean.FALSE;
        f = d.c.a.o.e.g("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", object);
        g = object = new j$a();
        h = m.f(0);
    }

    public j(List object, DisplayMetrics displayMetrics, e e10, d.c.a.o.k.x.b b10) {
        this.d = object;
        object = (DisplayMetrics)k.d(displayMetrics);
        this.b = object;
        this.a = object = (e)k.d(e10);
        this.c = object = (d.c.a.o.k.x.b)k.d(b10);
    }

    private static int a(double d10) {
        int n10 = d.c.a.n.a.d.j.s(1.0E9 * d10);
        double d11 = (float)n10 / 1.0E9f;
        double d12 = n10;
        return d.c.a.n.a.d.j.s((d10 /= d11) * d12);
    }

    private void b(InputStream object, DecodeFormat object2, boolean bl2, boolean bl3, BitmapFactory.Options options, int n10, int n11) {
        DecodeFormat decodeFormat = DecodeFormat.PREFER_ARGB_8888;
        if (object2 != decodeFormat && (bl2 = Build.VERSION.SDK_INT) != (bl3 = 16)) {
            block7: {
                bl2 = false;
                decodeFormat = null;
                Object object3 = this.d;
                Object object4 = this.c;
                object = d.c.a.o.b.e((List)object3, (InputStream)object, (d.c.a.o.k.x.b)object4);
                try {
                    bl2 = ((ImageHeaderParser$ImageType)((Object)object)).hasAlpha();
                }
                catch (IOException iOException) {
                    object4 = e;
                    bl3 = Log.isLoggable((String)object4, (int)3);
                    if (!bl3) break block7;
                    object3 = new StringBuilder();
                    String string2 = "Cannot determine whether the image has alpha or not from header, format ";
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append(object2);
                    object2 = ((StringBuilder)object3).toString();
                    Log.d((String)object4, (String)object2, (Throwable)iOException);
                }
            }
            object = bl2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = object;
            object2 = Bitmap.Config.RGB_565;
            if (object == object2 || object == (object2 = Bitmap.Config.ARGB_4444) || object == (object2 = Bitmap.Config.ALPHA_8)) {
                boolean bl4;
                options.inDither = bl4 = true;
            }
            return;
        }
        object = Bitmap.Config.ARGB_8888;
        options.inPreferredConfig = object;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void c(ImageHeaderParser$ImageType var0, InputStream var1_1, o$b var2_2, e var3_3, DownsampleStrategy var4_4, int var5_5, int var6_6, int var7_7, int var8_8, int var9_9, BitmapFactory.Options var10_10) {
        block11: {
            block12: {
                block13: {
                    block15: {
                        block19: {
                            block16: {
                                block18: {
                                    block17: {
                                        block14: {
                                            var11_11 /* !! */  = var0;
                                            var12_12 = var4_4;
                                            var13_13 = var6_6;
                                            var14_14 = var7_7;
                                            var15_15 = var8_8;
                                            var16_16 = var9_9;
                                            var17_17 = var10_10;
                                            var18_18 = Build.VERSION.SDK_INT;
                                            if (var6_6 <= 0 || var7_7 <= 0) break block11;
                                            var19_19 = 90;
                                            var20_20 = 1.26E-43f;
                                            if (var5_5 == var19_19) ** GOTO lbl-1000
                                            var19_19 = 270;
                                            var20_20 = 3.78E-43f;
                                            if (var5_5 != var19_19) {
                                                var21_21 = var4_4.b(var6_6, var7_7, var8_8, var9_9);
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var21_21 = var12_12.b(var14_14, var13_13, var15_15, var16_16);
                                            }
                                            var20_20 = 0.0f;
                                            var22_22 /* !! */  = null;
                                            cfr_temp_0 = var21_21 - 0.0f;
                                            var19_19 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
                                            var23_23 = "], target: [";
                                            var24_24 /* !! */  = "x";
                                            if (var19_19 <= 0) break block12;
                                            var22_22 /* !! */  = var12_12.a(var13_13, var14_14, var15_15, var16_16);
                                            if (var22_22 /* !! */  == null) break block13;
                                            var25_25 = var13_13;
                                            var26_26 = var21_21 * var25_25;
                                            var27_27 = var26_26;
                                            var29_28 = d.c.a.n.a.d.j.s(var27_27);
                                            var30_29 = var14_14;
                                            var31_30 = var21_21 * var30_29;
                                            var32_31 = var23_23;
                                            var33_32 = var24_24 /* !! */ ;
                                            var34_33 = var31_30;
                                            var36_34 = d.c.a.n.a.d.j.s(var34_33);
                                            var37_35 /* !! */  = var13_13 / var29_28;
                                            var36_34 = var14_14 / var36_34;
                                            var38_36 = DownsampleStrategy$SampleSizeRounding.MEMORY;
                                            var36_34 = var22_22 /* !! */  == var38_36 ? Math.max(var37_35 /* !! */ , var36_34) : Math.min(var37_35 /* !! */ , var36_34);
                                            var36_34 = Integer.highestOneBit(var36_34);
                                            var37_35 /* !! */  = 1;
                                            var36_34 = Math.max(var37_35 /* !! */ , var36_34);
                                            if (var22_22 /* !! */  == var38_36) {
                                                var20_20 = var36_34;
                                                var29_28 = 1065353216;
                                                var26_26 = 1.0f / var21_21;
                                                cfr_temp_1 = var20_20 - var26_26;
                                                var19_19 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1));
                                                if (var19_19 < 0) {
                                                    var36_34 <<= 1;
                                                }
                                            }
                                            var17_17.inSampleSize = var36_34;
                                            var22_22 /* !! */  = ImageHeaderParser$ImageType.JPEG;
                                            var29_28 = 0;
                                            var26_26 = 0.0f;
                                            var38_36 = null;
                                            if (var11_11 /* !! */  != var22_22 /* !! */ ) break block14;
                                            var39_37 = Math.min(var36_34, 8);
                                            var40_40 = Math.ceil(var25_25 /= var39_37);
                                            var37_35 /* !! */  = (int)var40_40;
                                            var42_43 = Math.ceil(var30_29 /= var39_37);
                                            var44_44 /* !! */  = (int)var42_43;
                                            var45_45 = var36_34 / 8;
                                            if (var45_45 > 0) {
                                                var37_35 /* !! */  /= var45_45;
                                                var44_44 /* !! */  /= var45_45;
                                            }
                                            break block15;
                                        }
                                        var24_24 /* !! */  = ImageHeaderParser$ImageType.PNG;
                                        if (var11_11 /* !! */  == var24_24 /* !! */  || var11_11 /* !! */  == (var24_24 /* !! */  = ImageHeaderParser$ImageType.PNG_A)) break block16;
                                        var24_24 /* !! */  = ImageHeaderParser$ImageType.WEBP;
                                        if (var11_11 /* !! */  == var24_24 /* !! */  || var11_11 /* !! */  == (var24_24 /* !! */  = ImageHeaderParser$ImageType.WEBP_A)) break block17;
                                        var44_44 /* !! */  = var13_13 % var36_34;
                                        if (var44_44 /* !! */  == 0 && (var44_44 /* !! */  = var14_14 % var36_34) == 0) {
                                            var37_35 /* !! */  = var13_13 / var36_34;
                                            var44_44 /* !! */  = var14_14 / var36_34;
                                        } else {
                                            var11_11 /* !! */  = var1_1;
                                            var24_24 /* !! */  = var2_2;
                                            var11_11 /* !! */  = (ImageHeaderParser$ImageType)d.c.a.n.a.d.j.j(var1_1, (BitmapFactory.Options)var17_17, var2_2, var3_3);
                                            var37_35 /* !! */  = (int)var11_11 /* !! */ [0];
                                            var19_19 = 1;
                                            var20_20 = 1.4E-45f;
                                            var44_44 /* !! */  = (int)var11_11 /* !! */ [var19_19];
                                        }
                                        break block15;
                                    }
                                    var44_44 /* !! */  = 24;
                                    var39_38 = 3.4E-44f;
                                    if (var18_18 < var44_44 /* !! */ ) break block18;
                                    var39_38 = var36_34;
                                    var37_35 /* !! */  = Math.round(var25_25 /= var39_38);
                                    var44_44 /* !! */  = Math.round(var30_29 /= var39_38);
                                    break block15;
                                }
                                var39_38 = var36_34;
                                var40_41 = Math.floor(var25_25 /= var39_38);
                                var37_35 /* !! */  = (int)var40_41;
                                var42_43 = Math.floor(var30_29 /= var39_38);
                                break block19;
                            }
                            var39_39 = var36_34;
                            var40_42 = Math.floor(var25_25 /= var39_39);
                            var37_35 /* !! */  = (int)var40_42;
                            var42_43 = Math.floor(var30_29 /= var39_39);
                        }
                        var44_44 /* !! */  = (int)var42_43;
                    }
                    var42_43 = var12_12.b(var37_35 /* !! */ , var44_44 /* !! */ , var15_15, var16_16);
                    var46_46 = 19;
                    if (var18_18 >= var46_46) {
                        var17_17.inTargetDensity = var46_46 = d.c.a.n.a.d.j.a(var42_43);
                        var17_17.inDensity = var46_46 = 1000000000;
                    }
                    if ((var46_46 = (int)d.c.a.n.a.d.j.n(var10_10)) != 0) {
                        var46_46 = 1;
                        var17_17.inScaled = var46_46;
                    } else {
                        var17_17.inTargetDensity = 0;
                        var17_17.inDensity = 0;
                    }
                    var47_47 = "WebpDownsampler";
                    var46_46 = (int)Log.isLoggable((String)var47_47, (int)2);
                    if (var46_46 != 0) {
                        var12_12 = new StringBuilder();
                        var12_12.append("Calculate scaling, source: [");
                        var12_12.append(var13_13);
                        var22_22 /* !! */  = var33_32;
                        var12_12.append(var33_32);
                        var12_12.append(var14_14);
                        var12_12.append(var32_31);
                        var12_12.append(var15_15);
                        var12_12.append(var33_32);
                        var12_12.append(var16_16);
                        var48_48 = "], power of two scaled: [";
                        var12_12.append(var48_48);
                        var12_12.append(var37_35 /* !! */ );
                        var12_12.append(var33_32);
                        var12_12.append(var44_44 /* !! */ );
                        var12_12.append("], exact scale factor: ");
                        var12_12.append(var21_21);
                        var12_12.append(", power of 2 sample size: ");
                        var12_12.append(var36_34);
                        var12_12.append(", adjusted scale factor: ");
                        var12_12.append(var42_43);
                        var12_12.append(", target density: ");
                        var44_44 /* !! */  = var17_17.inTargetDensity;
                        var12_12.append(var44_44 /* !! */ );
                        var12_12.append(", density: ");
                        var44_44 /* !! */  = var17_17.inDensity;
                        var12_12.append(var44_44 /* !! */ );
                        var11_11 /* !! */  = var12_12.toString();
                        Log.v((String)var47_47, (String)var11_11 /* !! */ );
                    }
                    return;
                }
                var11_11 /* !! */  = new IllegalArgumentException("Cannot round with null rounding");
                throw var11_11 /* !! */ ;
            }
            var22_22 /* !! */  = var24_24 /* !! */ ;
            var17_17 = new StringBuilder();
            var17_17.append("Cannot scale with factor: ");
            var17_17.append(var21_21);
            var17_17.append(" from: ");
            var17_17.append(var12_12);
            var17_17.append(", source: [");
            var17_17.append(var13_13);
            var17_17.append(var24_24 /* !! */ );
            var17_17.append(var14_14);
            var17_17.append(var23_23);
            var17_17.append(var15_15);
            var17_17.append(var24_24 /* !! */ );
            var17_17.append(var16_16);
            var17_17.append("]");
            var12_12 = var17_17.toString();
            var11_11 /* !! */  = new IllegalArgumentException((String)var12_12);
            throw var11_11 /* !! */ ;
        }
    }

    private Bitmap f(InputStream inputStream, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, boolean object, int n10, int object2, boolean bl2, o$b o$b) {
        Object object3;
        Object object4;
        Object object5 = this;
        Object object6 = inputStream;
        BitmapFactory.Options options2 = options;
        o$b o$b2 = o$b;
        long l10 = d.c.a.u.g.b();
        Object object7 = this.a;
        object7 = d.c.a.n.a.d.j.j(inputStream, options, o$b, (e)object7);
        Object object8 = 0;
        Object object9 = object7[0];
        Object object10 = 1;
        float f10 = Float.MIN_VALUE;
        Object object11 = object7[object10];
        Object object12 = options.outMimeType;
        Object object13 = -1;
        Object object14 = object9 != object13 && object11 != object13 ? object : 0;
        object7 = object5.d;
        Object object15 = object5.c;
        object13 = d.c.a.o.b.b((List)object7, (InputStream)object6, (d.c.a.o.k.x.b)object15);
        int n11 = d0.j(object13);
        boolean bl3 = d0.m(object13);
        Object object16 = -1 << -1;
        Object object17 = n10;
        Object object18 = object2;
        Object object19 = n10 == object16 ? object9 : (Object)n10;
        Object object20 = object18 == object16 ? object11 : (Object)object18;
        object15 = object5.d;
        Object object21 = object5.c;
        Object object22 = d.c.a.o.b.e((List)object15, (InputStream)object6, (d.c.a.o.k.x.b)object21);
        Object object23 = object5.a;
        object15 = object22;
        object21 = inputStream;
        e e10 = object23;
        object23 = o$b;
        object5 = object22;
        object22 = e10;
        Object object24 = downsampleStrategy;
        object17 = object9;
        d.c.a.n.a.d.j.c((ImageHeaderParser$ImageType)((Object)object15), inputStream, o$b, e10, downsampleStrategy, n11, (int)object9, (int)object11, (int)object19, (int)object20, options);
        object17 = object13;
        object7 = this;
        object23 = object12;
        object12 = inputStream;
        Object object25 = object11;
        Object object26 = decodeFormat;
        object16 = object10;
        object10 = object14;
        Object object27 = object9;
        object9 = bl3;
        object24 = o$b2;
        o$b2 = options;
        BitmapFactory.Options options3 = options2;
        Object object28 = object19;
        Object object29 = object20;
        this.b(inputStream, decodeFormat, (boolean)object14, bl3, options, (int)object19, (int)object20);
        object13 = Build.VERSION.SDK_INT;
        Object object30 = 19;
        if (object13 >= object30) {
            object8 = object16;
        }
        object13 = options3.inSampleSize;
        object30 = 2;
        object26 = e;
        if (object13 != object16 && object8 == 0) {
            object7 = this;
        } else {
            object7 = this;
            object4 = object5;
            object10 = this.u((ImageHeaderParser$ImageType)((Object)object5));
            if (object10 != 0) {
                Object object31;
                if (bl2 && object8 != 0) {
                    object31 = object19;
                    object28 = object20;
                } else {
                    object10 = d.c.a.n.a.d.j.n(options);
                    if (object10 != 0) {
                        object10 = options3.inTargetDensity;
                        f10 = object10;
                        object9 = options3.inDensity;
                        float f11 = (float)object9;
                        f10 /= f11;
                    } else {
                        object10 = 1065353216;
                        f10 = 1.0f;
                    }
                    object9 = options3.inSampleSize;
                    float f12 = (float)object27;
                    float f13 = (float)object9;
                    double d10 = Math.ceil(f12 / f13);
                    object31 = (int)d10;
                    float f14 = (float)object25 / f13;
                    double d11 = Math.ceil(f14);
                    object28 = (int)d11;
                    f12 = (float)object31 * f10;
                    object31 = Math.round(f12);
                    f13 = (float)object28 * f10;
                    object28 = Math.round(f13);
                    object29 = Log.isLoggable((String)object26, (int)object30);
                    if (object29 != false) {
                        object6 = new StringBuilder();
                        ((StringBuilder)object6).append("Calculated target [");
                        ((StringBuilder)object6).append((int)object31);
                        object5 = "x";
                        ((StringBuilder)object6).append((String)object5);
                        ((StringBuilder)object6).append((int)object28);
                        object15 = "] for source [";
                        ((StringBuilder)object6).append((String)object15);
                        ((StringBuilder)object6).append((int)object27);
                        ((StringBuilder)object6).append((String)object5);
                        ((StringBuilder)object6).append((int)object25);
                        object5 = "], sampleSize: ";
                        ((StringBuilder)object6).append((String)object5);
                        ((StringBuilder)object6).append((int)object9);
                        ((StringBuilder)object6).append(", targetDensity: ");
                        object9 = options3.inTargetDensity;
                        ((StringBuilder)object6).append((int)object9);
                        ((StringBuilder)object6).append(", density: ");
                        object9 = options3.inDensity;
                        ((StringBuilder)object6).append((int)object9);
                        object3 = ", density multiplier: ";
                        ((StringBuilder)object6).append((String)object3);
                        ((StringBuilder)object6).append(f10);
                        object4 = ((StringBuilder)object6).toString();
                        Log.v((String)object26, (String)object4);
                    }
                }
                if (object31 > 0 && object28 > 0) {
                    object4 = ((j)object7).a;
                    d.c.a.n.a.d.j.t(options3, (e)object4, (int)object31, (int)object28);
                }
            }
        }
        object4 = ((j)object7).a;
        object3 = inputStream;
        object4 = d.c.a.n.a.d.j.g(inputStream, options3, (o$b)object24, (e)object4);
        object3 = ((j)object7).a;
        object24.a((e)object3, (Bitmap)object4);
        object30 = Log.isLoggable((String)object26, (int)object30);
        if (object30 != 0) {
            object16 = object27;
            object22 = options;
            object24 = object4;
            n11 = n10;
            object30 = object17;
            object17 = object2;
            d.c.a.n.a.d.j.o((int)object27, (int)object25, (String)object23, options, (Bitmap)object4, n10, object2, l10);
        } else {
            object30 = object17;
        }
        object11 = false;
        object26 = null;
        if (object4 != null) {
            object11 = object7.b.densityDpi;
            object4.setDensity((int)object11);
            object26 = d0.o(((j)object7).a, (Bitmap)object4, object30);
            object30 = object4.equals(object26);
            if (object30 == 0) {
                object12 = ((j)object7).a;
                object12.d((Bitmap)object4);
            }
        }
        return object26;
    }

    /*
     * Exception decompiling
     */
    private static Bitmap g(InputStream var0, BitmapFactory.Options var1_2, o$b var2_3, e var3_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [2 : 108->112)] java.lang.Throwable
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

    private static String h(Bitmap bitmap) {
        CharSequence charSequence;
        CharSequence charSequence2;
        if (bitmap == null) {
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append(" (");
            n11 = bitmap.getAllocationByteCount();
            ((StringBuilder)charSequence2).append(n11);
            charSequence = ")";
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
        } else {
            charSequence2 = "";
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("[");
        int n12 = bitmap.getWidth();
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append("x");
        n12 = bitmap.getHeight();
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append("] ");
        bitmap = bitmap.getConfig();
        ((StringBuilder)charSequence).append(bitmap);
        ((StringBuilder)charSequence).append((String)charSequence2);
        return ((StringBuilder)charSequence).toString();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private static BitmapFactory.Options i() {
        Class<j> clazz = j.class;
        // MONITORENTER : clazz
        Queue queue = h;
        // MONITORENTER : queue
        Object object = queue.poll();
        object = (BitmapFactory.Options)object;
        // MONITOREXIT : queue
        if (object == null) {
            object = new Object();
            d.c.a.n.a.d.j.r(object);
        }
        // MONITOREXIT : clazz
        return object;
    }

    private static int[] j(InputStream inputStream, BitmapFactory.Options options, o$b object, e e10) {
        int n10 = 1;
        options.inJustDecodeBounds = n10;
        d.c.a.n.a.d.j.g(inputStream, options, (o$b)object, e10);
        options.inJustDecodeBounds = false;
        object = new int[2];
        int n11 = options.outWidth;
        object[0] = n11;
        int n12 = options.outHeight;
        object[n10] = n12;
        return object;
    }

    private static String k(BitmapFactory.Options options) {
        return d.c.a.n.a.d.j.h(options.inBitmap);
    }

    private static boolean n(BitmapFactory.Options options) {
        int n10;
        int n11 = options.inTargetDensity;
        if (n11 > 0 && (n10 = options.inDensity) > 0 && n11 != n10) {
            n10 = 1;
        } else {
            n10 = 0;
            options = null;
        }
        return n10 != 0;
    }

    private static void o(int n10, int n11, String string2, BitmapFactory.Options options, Bitmap object, int n12, int n13, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoded ");
        object = d.c.a.n.a.d.j.h(object);
        stringBuilder.append((String)object);
        stringBuilder.append(" from [");
        stringBuilder.append(n10);
        String string3 = "x";
        stringBuilder.append(string3);
        stringBuilder.append(n11);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        stringBuilder.append(" with inBitmap ");
        String string4 = d.c.a.n.a.d.j.k(options);
        stringBuilder.append(string4);
        stringBuilder.append(" for [");
        stringBuilder.append(n12);
        stringBuilder.append(string3);
        stringBuilder.append(n13);
        stringBuilder.append("], sample size: ");
        n10 = options.inSampleSize;
        stringBuilder.append(n10);
        stringBuilder.append(", density: ");
        n10 = options.inDensity;
        stringBuilder.append(n10);
        stringBuilder.append(", target density: ");
        n10 = options.inTargetDensity;
        stringBuilder.append(n10);
        stringBuilder.append(", thread: ");
        string3 = Thread.currentThread().getName();
        stringBuilder.append(string3);
        stringBuilder.append(", duration: ");
        double d10 = d.c.a.u.g.a(l10);
        stringBuilder.append(d10);
        string3 = stringBuilder.toString();
        Log.v((String)e, (String)string3);
    }

    private static IOException p(IllegalArgumentException illegalArgumentException, int n10, int n11, String string2, BitmapFactory.Options options) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception decoding bitmap, outWidth: ");
        stringBuilder.append(n10);
        stringBuilder.append(", outHeight: ");
        stringBuilder.append(n11);
        stringBuilder.append(", outMimeType: ");
        stringBuilder.append(string2);
        stringBuilder.append(", inBitmap: ");
        String string3 = d.c.a.n.a.d.j.k(options);
        stringBuilder.append(string3);
        string3 = stringBuilder.toString();
        IOException iOException = new IOException(string3, illegalArgumentException);
        return iOException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void q(BitmapFactory.Options options) {
        d.c.a.n.a.d.j.r(options);
        Queue queue = h;
        synchronized (queue) {
            queue.offer(options);
            return;
        }
    }

    private static void r(BitmapFactory.Options options) {
        int n10;
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = n10 = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = n10;
    }

    private static int s(double d10) {
        return (int)(d10 + 0.5);
    }

    private static void t(BitmapFactory.Options options, e e10, int n10, int n11) {
        Bitmap.Config config;
        Bitmap.Config config2;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 26;
        if (n12 >= n13 && (config2 = options.inPreferredConfig) == (config = Bitmap.Config.HARDWARE)) {
            return;
        }
        config2 = options.inPreferredConfig;
        e10 = e10.g(n10, n11, config2);
        options.inBitmap = e10;
    }

    private boolean u(ImageHeaderParser$ImageType imageHeaderParser$ImageType) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        return n10 >= n11;
    }

    public s d(InputStream inputStream, int n10, int n11, f f10) {
        o$b o$b = g;
        return this.e(inputStream, n10, n11, f10, o$b);
    }

    public s e(InputStream inputStream, int n10, int n11, f f10, o$b o$b) {
        boolean bl2;
        j j10 = this;
        Object object = f10;
        Class<byte[]> clazz = byte[].class;
        boolean bl3 = inputStream.markSupported();
        k.a(bl3, "You must provide an InputStream that supports mark()");
        Object object2 = this.c;
        int n12 = 65536;
        Object object3 = object2 = object2.c(n12, clazz);
        object3 = (byte[])object2;
        BitmapFactory.Options options = d.c.a.n.a.d.j.i();
        options.inTempStorage = (byte[])object3;
        object2 = o.g;
        Object object4 = object2 = f10.c((d.c.a.o.e)object2);
        object4 = (DecodeFormat)((Object)object2);
        object2 = o.i;
        Object object5 = object2 = f10.c((d.c.a.o.e)object2);
        object5 = (DownsampleStrategy)object2;
        object2 = o.j;
        boolean bl4 = (Boolean)f10.c((d.c.a.o.e)object2);
        object2 = o.k;
        Object object6 = f10.c((d.c.a.o.e)object2);
        if (object6 != null && (bl2 = ((Boolean)(object = (Boolean)f10.c((d.c.a.o.e)object2))).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object2 = this;
        object6 = inputStream;
        try {
            object = this.f(inputStream, options, (DownsampleStrategy)object5, (DecodeFormat)((Object)object4), bl2, n10, n11, bl4, o$b);
            object2 = j10.a;
            object = d.c.a.o.m.d.g.d((Bitmap)object, (e)object2);
            return object;
        }
        finally {
            d.c.a.n.a.d.j.q(options);
            j10.c.e(object3, clazz);
        }
    }

    public boolean l(InputStream object, f object2) {
        d.c.a.o.e e10 = f;
        object2 = (Boolean)((f)object2).c(e10);
        boolean bl2 = (Boolean)object2;
        boolean bl3 = false;
        e10 = null;
        if (!bl2 && !(bl2 = WebpHeaderParser.k) && (bl2 = WebpHeaderParser.i((WebpHeaderParser$WebpImageType)((Object)(object = WebpHeaderParser.b(object, (d.c.a.o.k.x.b)(object2 = this.c)))))) && object != (object2 = WebpHeaderParser$WebpImageType.WEBP_SIMPLE)) {
            bl3 = true;
        }
        return bl3;
    }

    public boolean m(ByteBuffer object, f object2) {
        d.c.a.o.e e10 = f;
        object2 = (Boolean)((f)object2).c(e10);
        boolean bl2 = (Boolean)object2;
        boolean bl3 = false;
        e10 = null;
        if (!bl2 && !(bl2 = WebpHeaderParser.k) && (bl2 = WebpHeaderParser.i((WebpHeaderParser$WebpImageType)((Object)(object = WebpHeaderParser.c(object))))) && object != (object2 = WebpHeaderParser$WebpImageType.WEBP_SIMPLE)) {
            bl3 = true;
        }
        return bl3;
    }
}

