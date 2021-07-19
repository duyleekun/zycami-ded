/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BitmapFactory$Options
 *  android.graphics.ColorSpace
 *  android.graphics.ColorSpace$Named
 *  android.os.Build$VERSION
 *  android.os.ParcelFileDescriptor
 *  android.util.DisplayMetrics
 *  android.util.Log
 */
package d.c.a.o.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.PreferredColorSpace;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.j.m;
import d.c.a.o.k.s;
import d.c.a.o.k.x.b;
import d.c.a.o.m.d.d0;
import d.c.a.o.m.d.g;
import d.c.a.o.m.d.o$a;
import d.c.a.o.m.d.o$b;
import d.c.a.o.m.d.u;
import d.c.a.o.m.d.v;
import d.c.a.o.m.d.v$a;
import d.c.a.o.m.d.v$b;
import d.c.a.u.k;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class o {
    public static final String f = "Downsampler";
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    private static final String l = "image/vnd.wap.wbmp";
    private static final String m = "image/x-ico";
    private static final Set n;
    private static final o$b o;
    private static final Set p;
    private static final Queue q;
    private final d.c.a.o.k.x.e a;
    private final DisplayMetrics b;
    private final b c;
    private final List d;
    private final u e;

    static {
        Object object = DecodeFormat.DEFAULT;
        g = d.c.a.o.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", object);
        object = PreferredColorSpace.SRGB;
        h = d.c.a.o.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", object);
        i = DownsampleStrategy.h;
        object = Boolean.FALSE;
        j = d.c.a.o.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", object);
        k = d.c.a.o.e.g("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", object);
        Object object2 = Arrays.asList(l, m);
        object = new HashSet(object2);
        n = Collections.unmodifiableSet(object);
        o = object = new o$a();
        object = ImageHeaderParser$ImageType.JPEG;
        object2 = ImageHeaderParser$ImageType.PNG_A;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType = ImageHeaderParser$ImageType.PNG;
        p = Collections.unmodifiableSet(EnumSet.of(object, object2, imageHeaderParser$ImageType));
        q = d.c.a.u.m.f(0);
    }

    public o(List object, DisplayMetrics displayMetrics, d.c.a.o.k.x.e e10, b b10) {
        u u10;
        this.e = u10 = u.a();
        this.d = object;
        object = (DisplayMetrics)d.c.a.u.k.d(displayMetrics);
        this.b = object;
        this.a = object = (d.c.a.o.k.x.e)d.c.a.u.k.d(e10);
        this.c = object = (b)d.c.a.u.k.d(b10);
    }

    private static int a(double d10) {
        int n10 = d.c.a.o.m.d.o.l(d10);
        int n11 = d.c.a.o.m.d.o.x((double)n10 * d10);
        float f10 = n11;
        float f11 = n10;
        double d11 = f10 / f11;
        double d12 = n11;
        return d.c.a.o.m.d.o.x((d10 /= d11) * d12);
    }

    private void b(v object, DecodeFormat object2, boolean bl2, boolean bl3, BitmapFactory.Options options, int n10, int n11) {
        u u10 = this.e;
        if (bl2 = u10.e(n10, n11, options, bl2, bl3)) {
            return;
        }
        DecodeFormat decodeFormat = DecodeFormat.PREFER_ARGB_8888;
        if (object2 != decodeFormat && (bl2 = Build.VERSION.SDK_INT) != (bl3 = 16)) {
            block6: {
                bl2 = false;
                decodeFormat = null;
                object = object.d();
                try {
                    bl2 = ((ImageHeaderParser$ImageType)((Object)object)).hasAlpha();
                }
                catch (IOException iOException) {
                    String string2 = f;
                    bl3 = Log.isLoggable((String)string2, (int)3);
                    if (!bl3) break block6;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "Cannot determine whether the image has alpha or not from header, format ";
                    stringBuilder.append(string3);
                    stringBuilder.append(object2);
                    object2 = stringBuilder.toString();
                    Log.d((String)string2, (String)object2, (Throwable)iOException);
                }
            }
            object = bl2 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
            options.inPreferredConfig = object;
            object2 = Bitmap.Config.RGB_565;
            if (object == object2) {
                boolean bl4;
                options.inDither = bl4 = true;
            }
            return;
        }
        object = Bitmap.Config.ARGB_8888;
        options.inPreferredConfig = object;
    }

    private static void c(ImageHeaderParser$ImageType imageHeaderParser$ImageType, v v10, o$b o$b, d.c.a.o.k.x.e e10, DownsampleStrategy downsampleStrategy, int n10, int n11, int n12, int n13, int n14, BitmapFactory.Options options) {
        Object object;
        String string2;
        Object object2;
        int n15;
        int n16;
        Object object3;
        Object object4;
        block14: {
            float f10;
            int n17;
            int n18;
            Object object5;
            block15: {
                block16: {
                    Object object6;
                    double d10;
                    Object object7;
                    int n19;
                    String string3;
                    String string4;
                    int n20;
                    BitmapFactory.Options options2;
                    block18: {
                        block22: {
                            block19: {
                                float f11;
                                block21: {
                                    block20: {
                                        Object object8;
                                        int n21;
                                        int n22;
                                        block17: {
                                            float f12;
                                            object4 = imageHeaderParser$ImageType;
                                            object3 = downsampleStrategy;
                                            object5 = n11;
                                            n18 = n12;
                                            n16 = n13;
                                            n15 = n14;
                                            options2 = options;
                                            object2 = "]";
                                            string2 = f;
                                            object = "x";
                                            if (n11 <= 0 || n12 <= 0) break block14;
                                            n22 = d.c.a.o.m.d.o.r(n10);
                                            if (n22 != 0) {
                                                n17 = n11;
                                                n22 = n12;
                                            } else {
                                                n22 = n11;
                                                n17 = n12;
                                            }
                                            f10 = ((DownsampleStrategy)object3).b(n22, n17, n16, n15);
                                            float f13 = 0.0f;
                                            float f14 = f10 - 0.0f;
                                            float f15 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                                            if (f15 <= 0) break block15;
                                            object2 = ((DownsampleStrategy)object3).a(n22, n17, n16, n15);
                                            if (object2 == null) break block16;
                                            f13 = n22;
                                            float f16 = f10 * f13;
                                            double d11 = f16;
                                            n20 = d.c.a.o.m.d.o.x(d11);
                                            float f17 = n17;
                                            float f18 = f10 * f17;
                                            double d12 = f18;
                                            object5 = d.c.a.o.m.d.o.x(d12);
                                            n18 = n22 / n20;
                                            object5 = n17 / object5;
                                            DownsampleStrategy$SampleSizeRounding downsampleStrategy$SampleSizeRounding = DownsampleStrategy$SampleSizeRounding.MEMORY;
                                            object5 = object2 == downsampleStrategy$SampleSizeRounding ? Math.max(n18, object5) : Math.min(n18, object5);
                                            n18 = Build.VERSION.SDK_INT;
                                            string4 = object;
                                            n21 = 23;
                                            string3 = string2;
                                            if (n18 <= n21 && (n19 = (object = n).contains(string2 = options2.outMimeType)) != 0) {
                                                n19 = 1;
                                                float f19 = Float.MIN_VALUE;
                                            } else {
                                                object5 = Integer.highestOneBit(object5);
                                                n19 = 1;
                                                float f20 = Float.MIN_VALUE;
                                                object5 = Math.max(n19, object5);
                                                if (object2 == downsampleStrategy$SampleSizeRounding) {
                                                    f12 = object5;
                                                    n19 = 1065353216;
                                                    f20 = 1.0f / f10;
                                                    float f21 = f12 - f20;
                                                    object7 = f21 == 0.0f ? 0 : (f21 < 0.0f ? -1 : 1);
                                                    if (object7 < 0) {
                                                        object5 <<= 1;
                                                    }
                                                }
                                                n19 = object5;
                                            }
                                            options2.inSampleSize = n19;
                                            object8 = ImageHeaderParser$ImageType.JPEG;
                                            object7 = 0;
                                            f12 = 0.0f;
                                            object2 = null;
                                            if (object4 != object8) break block17;
                                            float f22 = Math.min(n19, 8);
                                            object5 = (int)Math.ceil(f13 /= f22);
                                            d10 = Math.ceil(f17 /= f22);
                                            object6 = (int)d10;
                                            n21 = n19 / 8;
                                            if (n21 > 0) {
                                                object5 /= n21;
                                                object6 /= n21;
                                            }
                                            break block18;
                                        }
                                        object8 = ImageHeaderParser$ImageType.PNG;
                                        if (object4 == object8 || object4 == (object8 = ImageHeaderParser$ImageType.PNG_A)) break block19;
                                        object8 = ImageHeaderParser$ImageType.WEBP;
                                        if (object4 == object8 || object4 == (object8 = ImageHeaderParser$ImageType.WEBP_A)) break block20;
                                        object6 = n22 % n19;
                                        if (object6 == 0 && (object6 = n17 % n19) == 0) {
                                            object5 = n22 / n19;
                                            object6 = n17 / n19;
                                        } else {
                                            object4 = v10;
                                            object8 = o$b;
                                            object = e10;
                                            object4 = d.c.a.o.m.d.o.m(v10, options2, o$b, e10);
                                            object5 = (Object)object4[0];
                                            n21 = 1;
                                            object6 = (Object)object4[n21];
                                        }
                                        break block18;
                                    }
                                    object6 = 24;
                                    f11 = 3.4E-44f;
                                    if (n18 < object6) break block21;
                                    f11 = n19;
                                    object5 = Math.round(f13 /= f11);
                                    object6 = Math.round(f17 /= f11);
                                    break block18;
                                }
                                f11 = n19;
                                object5 = (int)Math.floor(f13 /= f11);
                                d10 = Math.floor(f17 /= f11);
                                break block22;
                            }
                            float f23 = n19;
                            object5 = (int)Math.floor(f13 /= f23);
                            d10 = Math.floor(f17 /= f23);
                        }
                        object6 = (int)d10;
                    }
                    d10 = ((DownsampleStrategy)object3).b((int)object5, (int)object6, n16, n15);
                    int n23 = 19;
                    if (n18 >= n23) {
                        options2.inTargetDensity = n23 = d.c.a.o.m.d.o.a(d10);
                        options2.inDensity = n23 = d.c.a.o.m.d.o.l(d10);
                    }
                    if ((n23 = (int)(d.c.a.o.m.d.o.s(options) ? 1 : 0)) != 0) {
                        n23 = 1;
                        options2.inScaled = n23;
                    } else {
                        options2.inTargetDensity = 0;
                        options2.inDensity = 0;
                    }
                    n23 = (int)(Log.isLoggable((String)string3, (int)2) ? 1 : 0);
                    if (n23 != 0) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Calculate scaling, source: [");
                        n17 = n11;
                        ((StringBuilder)object3).append(n11);
                        ((StringBuilder)object3).append(string4);
                        n20 = n12;
                        ((StringBuilder)object3).append(n12);
                        ((StringBuilder)object3).append("], degreesToRotate: ");
                        object7 = n10;
                        ((StringBuilder)object3).append(n10);
                        object2 = ", target: [";
                        ((StringBuilder)object3).append((String)object2);
                        ((StringBuilder)object3).append(n16);
                        ((StringBuilder)object3).append(string4);
                        ((StringBuilder)object3).append(n15);
                        String string5 = "], power of two scaled: [";
                        ((StringBuilder)object3).append(string5);
                        ((StringBuilder)object3).append((int)object5);
                        ((StringBuilder)object3).append(string4);
                        ((StringBuilder)object3).append((int)object6);
                        ((StringBuilder)object3).append("], exact scale factor: ");
                        ((StringBuilder)object3).append(f10);
                        ((StringBuilder)object3).append(", power of 2 sample size: ");
                        ((StringBuilder)object3).append(n19);
                        ((StringBuilder)object3).append(", adjusted scale factor: ");
                        ((StringBuilder)object3).append(d10);
                        ((StringBuilder)object3).append(", target density: ");
                        object6 = options2.inTargetDensity;
                        ((StringBuilder)object3).append((int)object6);
                        ((StringBuilder)object3).append(", density: ");
                        object6 = options2.inDensity;
                        ((StringBuilder)object3).append((int)object6);
                        object4 = ((StringBuilder)object3).toString();
                        Log.v((String)string3, (String)object4);
                    }
                    return;
                }
                object4 = new IllegalArgumentException("Cannot round with null rounding");
                throw object4;
            }
            n17 = object5;
            int n24 = n18;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cannot scale with factor: ");
            stringBuilder.append(f10);
            stringBuilder.append(" from: ");
            stringBuilder.append(object3);
            stringBuilder.append(", source: [");
            stringBuilder.append((int)object5);
            stringBuilder.append((String)object);
            stringBuilder.append(n18);
            stringBuilder.append("], target: [");
            stringBuilder.append(n16);
            stringBuilder.append((String)object);
            stringBuilder.append(n15);
            stringBuilder.append((String)object2);
            object3 = stringBuilder.toString();
            object4 = new IllegalArgumentException((String)object3);
            throw object4;
        }
        boolean bl2 = Log.isLoggable((String)string2, (int)3);
        if (bl2) {
            object3 = new StringBuilder();
            String string6 = "Unable to determine dimensions for: ";
            ((StringBuilder)object3).append(string6);
            ((StringBuilder)object3).append(object4);
            ((StringBuilder)object3).append(" with target [");
            ((StringBuilder)object3).append(n16);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(n15);
            ((StringBuilder)object3).append((String)object2);
            object4 = ((StringBuilder)object3).toString();
            Log.d((String)string2, (String)object4);
        }
    }

    private s e(v v10, int n10, int n11, f f10, o$b o$b) {
        boolean bl2;
        o o10 = this;
        Object object = f10;
        Object object2 = this.c;
        int n12 = 65536;
        Object object3 = object2 = object2.c(n12, byte[].class);
        object3 = (byte[])object2;
        BitmapFactory.Options options = d.c.a.o.m.d.o.k();
        options.inTempStorage = (byte[])object3;
        object2 = g;
        Object object4 = object2 = f10.c((e)object2);
        object4 = (DecodeFormat)((Object)object2);
        object2 = h;
        Object object5 = object2 = f10.c((e)object2);
        object5 = (PreferredColorSpace)((Object)object2);
        object2 = DownsampleStrategy.h;
        Object object6 = object2 = f10.c((e)object2);
        object6 = (DownsampleStrategy)object2;
        object2 = j;
        boolean bl3 = (Boolean)f10.c((e)object2);
        object2 = k;
        Object object7 = f10.c((e)object2);
        if (object7 != null && (bl2 = ((Boolean)(object = (Boolean)f10.c((e)object2))).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object2 = this;
        object7 = v10;
        try {
            object = this.h(v10, options, (DownsampleStrategy)object6, (DecodeFormat)((Object)object4), (PreferredColorSpace)((Object)object5), bl2, n10, n11, bl3, o$b);
            object2 = o10.a;
            object = d.c.a.o.m.d.g.d((Bitmap)object, (d.c.a.o.k.x.e)object2);
            return object;
        }
        finally {
            d.c.a.o.m.d.o.v(options);
            o10.c.put(object3);
        }
    }

    private Bitmap h(v v10, BitmapFactory.Options options, DownsampleStrategy downsampleStrategy, DecodeFormat decodeFormat, PreferredColorSpace preferredColorSpace, boolean object, int n10, int object2, boolean bl2, o$b o$b) {
        float f10;
        Bitmap bitmap;
        Object object3;
        Object object4;
        Object object5 = this;
        Object object6 = v10;
        Object object7 = options;
        Object object8 = o$b;
        long l10 = d.c.a.u.g.b();
        Object object9 = this.a;
        object9 = d.c.a.o.m.d.o.m(v10, options, o$b, (d.c.a.o.k.x.e)object9);
        int object10 = 0;
        Object object11 = object9[0];
        Object object12 = 1;
        float f11 = Float.MIN_VALUE;
        Object object13 = object9[object12];
        Object object14 = options.outMimeType;
        Object object15 = -1;
        Object object16 = object11 != object15 && object13 != object15 ? object : false;
        object15 = v10.c();
        int n12 = d0.j(object15);
        boolean bl3 = d0.m(object15);
        Object object17 = -1 << -1;
        Object object18 = n10;
        if (n10 == object17) {
            boolean n11 = d.c.a.o.m.d.o.r(n12);
            object4 = object2;
            object3 = n11 ? (Object)object13 : (Object)object11;
        } else {
            object4 = object2;
            object3 = n10;
        }
        Object object19 = object4 == object17 ? ((object17 = (Object)d.c.a.o.m.d.o.r(n12)) != 0 ? object11 : object13) : object4;
        Object object20 = v10.d();
        Object object21 = object5.a;
        ImageHeaderParser$ImageType imageHeaderParser$ImageType = object20;
        d.c.a.o.k.x.e e10 = object21;
        object21 = o$b;
        object5 = object20;
        object20 = e10;
        Object object22 = downsampleStrategy;
        object18 = object11;
        d.c.a.o.m.d.o.c(imageHeaderParser$ImageType, v10, o$b, e10, downsampleStrategy, n12, (int)object11, (int)object13, object3, (int)object19, options);
        object18 = object15;
        object9 = this;
        object21 = object14;
        object14 = v10;
        Object object23 = object13;
        Object object24 = decodeFormat;
        object17 = object12;
        object12 = object16;
        Object object25 = object11;
        object11 = bl3;
        object22 = object8;
        object8 = options;
        BitmapFactory.Options options2 = object7;
        Object object26 = object3;
        Object object27 = object19;
        this.b(v10, decodeFormat, (boolean)object16, bl3, options, (int)object3, (int)object19);
        object15 = Build.VERSION.SDK_INT;
        Object object28 = 19;
        if (object15 >= object28) {
            object12 = object17;
        } else {
            object12 = 0;
            bitmap = null;
            f11 = 0.0f;
        }
        object28 = options2.inSampleSize;
        String string2 = f;
        if (object28 != object17 && object12 == 0) {
            object14 = this;
        } else {
            object14 = this;
            object8 = object5;
            int n11 = this.z((ImageHeaderParser$ImageType)((Object)object5));
            if (n11 != 0) {
                if (object25 >= 0 && object23 >= 0 && bl2 && object12 != 0) {
                    object13 = object3;
                    object12 = object19;
                } else {
                    float f12;
                    object12 = d.c.a.o.m.d.o.s(options);
                    if (object12 != 0) {
                        object12 = options2.inTargetDensity;
                        f11 = object12;
                        n11 = options2.inDensity;
                        f12 = n11;
                        f11 /= f12;
                    } else {
                        object12 = 1065353216;
                        f11 = 1.0f;
                    }
                    n11 = options2.inSampleSize;
                    float f13 = (float)object25;
                    float f14 = n11;
                    float f15 = f11;
                    double d10 = Math.ceil(f13 /= f14);
                    object13 = (int)d10;
                    double d11 = Math.ceil((float)object23 / f14);
                    object12 = (int)d11;
                    f10 = (float)object13 * f15;
                    object13 = Math.round(f10);
                    f11 = (float)object12 * f15;
                    object12 = Math.round(f11);
                    object26 = 2;
                    f13 = 2.8E-45f;
                    object27 = Log.isLoggable((String)string2, (int)object26);
                    if (object27 != false) {
                        object7 = new StringBuilder();
                        ((StringBuilder)object7).append("Calculated target [");
                        ((StringBuilder)object7).append((int)object13);
                        object6 = "x";
                        ((StringBuilder)object7).append((String)object6);
                        ((StringBuilder)object7).append((int)object12);
                        object5 = "] for source [";
                        ((StringBuilder)object7).append((String)object5);
                        ((StringBuilder)object7).append((int)object25);
                        ((StringBuilder)object7).append((String)object6);
                        ((StringBuilder)object7).append((int)object23);
                        object6 = "], sampleSize: ";
                        ((StringBuilder)object7).append((String)object6);
                        ((StringBuilder)object7).append(n11);
                        ((StringBuilder)object7).append(", targetDensity: ");
                        n11 = options2.inTargetDensity;
                        ((StringBuilder)object7).append(n11);
                        ((StringBuilder)object7).append(", density: ");
                        n11 = options2.inDensity;
                        ((StringBuilder)object7).append(n11);
                        ((StringBuilder)object7).append(", density multiplier: ");
                        f12 = f15;
                        ((StringBuilder)object7).append(f15);
                        object8 = ((StringBuilder)object7).toString();
                        Log.v((String)string2, (String)object8);
                    }
                }
                if (object13 > 0 && object12 > 0) {
                    object8 = ((o)object14).a;
                    d.c.a.o.m.d.o.y(options2, (d.c.a.o.k.x.e)object8, (int)object13, object12);
                }
            }
        }
        object13 = 28;
        f10 = 3.9E-44f;
        if (object15 >= object13) {
            object9 = PreferredColorSpace.DISPLAY_P3;
            object24 = preferredColorSpace;
            if (preferredColorSpace == object9 && (object9 = options2.outColorSpace) != null && (object15 = (Object)object9.isWideGamut()) != 0) {
                object10 = object17;
            }
            object9 = object10 != 0 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB;
            object9 = ColorSpace.get((ColorSpace.Named)object9);
            options2.inPreferredColorSpace = object9;
        } else {
            object13 = 26;
            f10 = 3.6E-44f;
            if (object15 >= object13) {
                object9 = ColorSpace.get((ColorSpace.Named)ColorSpace.Named.SRGB);
                options2.inPreferredColorSpace = object9;
            }
        }
        object9 = ((o)object14).a;
        object24 = v10;
        object9 = d.c.a.o.m.d.o.i(v10, options2, (o$b)object22, (d.c.a.o.k.x.e)object9);
        object24 = ((o)object14).a;
        object22.a((d.c.a.o.k.x.e)object24, (Bitmap)object9);
        f10 = 2.8E-45f;
        object13 = Log.isLoggable((String)string2, (int)2);
        if (object13 != false) {
            object17 = object25;
            object20 = options;
            object22 = object9;
            n12 = n10;
            object13 = object18;
            object18 = object2;
            d.c.a.o.m.d.o.t((int)object25, (int)object23, (String)object21, options, (Bitmap)object9, n10, (int)object2, l10);
        } else {
            object13 = object18;
        }
        object12 = 0;
        f11 = 0.0f;
        bitmap = null;
        if (object9 != null) {
            object12 = object14.b.densityDpi;
            object9.setDensity(object12);
            bitmap = d0.o(((o)object14).a, (Bitmap)object9, (int)object13);
            object13 = object9.equals(bitmap);
            if (object13 == false) {
                object24 = ((o)object14).a;
                object24.d((Bitmap)object9);
            }
        }
        return bitmap;
    }

    /*
     * Exception decompiling
     */
    private static Bitmap i(v var0, BitmapFactory.Options var1_2, o$b var2_3, d.c.a.o.k.x.e var3_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [2 : 89->93)] java.lang.Throwable
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

    private static String j(Bitmap bitmap) {
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
    private static BitmapFactory.Options k() {
        Class<o> clazz = o.class;
        // MONITORENTER : clazz
        Queue queue = q;
        // MONITORENTER : queue
        Object object = queue.poll();
        object = (BitmapFactory.Options)object;
        // MONITOREXIT : queue
        if (object == null) {
            object = new Object();
            d.c.a.o.m.d.o.w(object);
        }
        // MONITOREXIT : clazz
        return object;
    }

    private static int l(double d10) {
        double d11 = 1.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object > 0) {
            d10 = d11 / d10;
        }
        return (int)Math.round(d10 * 2.147483647E9);
    }

    private static int[] m(v v10, BitmapFactory.Options options, o$b object, d.c.a.o.k.x.e e10) {
        int n10 = 1;
        options.inJustDecodeBounds = n10;
        d.c.a.o.m.d.o.i(v10, options, (o$b)object, e10);
        options.inJustDecodeBounds = false;
        object = new int[2];
        int n11 = options.outWidth;
        object[0] = n11;
        int n12 = options.outHeight;
        object[n10] = n12;
        return object;
    }

    private static String n(BitmapFactory.Options options) {
        return d.c.a.o.m.d.o.j(options.inBitmap);
    }

    private static boolean r(int n10) {
        int n11 = 90;
        n10 = n10 != n11 && n10 != (n11 = 270) ? 0 : 1;
        return n10 != 0;
    }

    private static boolean s(BitmapFactory.Options options) {
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

    private static void t(int n10, int n11, String string2, BitmapFactory.Options options, Bitmap object, int n12, int n13, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoded ");
        object = d.c.a.o.m.d.o.j(object);
        stringBuilder.append((String)object);
        stringBuilder.append(" from [");
        stringBuilder.append(n10);
        String string3 = "x";
        stringBuilder.append(string3);
        stringBuilder.append(n11);
        stringBuilder.append("] ");
        stringBuilder.append(string2);
        stringBuilder.append(" with inBitmap ");
        String string4 = d.c.a.o.m.d.o.n(options);
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
        Log.v((String)f, (String)string3);
    }

    private static IOException u(IllegalArgumentException illegalArgumentException, int n10, int n11, String string2, BitmapFactory.Options options) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Exception decoding bitmap, outWidth: ");
        stringBuilder.append(n10);
        stringBuilder.append(", outHeight: ");
        stringBuilder.append(n11);
        stringBuilder.append(", outMimeType: ");
        stringBuilder.append(string2);
        stringBuilder.append(", inBitmap: ");
        String string3 = d.c.a.o.m.d.o.n(options);
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
    private static void v(BitmapFactory.Options options) {
        d.c.a.o.m.d.o.w(options);
        Queue queue = q;
        synchronized (queue) {
            queue.offer(options);
            return;
        }
    }

    private static void w(BitmapFactory.Options options) {
        int n10;
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = n10 = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 26;
        if (n11 >= n12) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = n10;
    }

    private static int x(double d10) {
        return (int)(d10 + 0.5);
    }

    private static void y(BitmapFactory.Options options, d.c.a.o.k.x.e e10, int n10, int n11) {
        Bitmap.Config config;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 26;
        if (n12 >= n13) {
            config = options.inPreferredConfig;
            Bitmap.Config config2 = Bitmap.Config.HARDWARE;
            if (config == config2) {
                return;
            }
            config = options.outConfig;
        } else {
            n12 = 0;
            config = null;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        e10 = e10.g(n10, n11, config);
        options.inBitmap = e10;
    }

    private boolean z(ImageHeaderParser$ImageType imageHeaderParser$ImageType) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return true;
        }
        return p.contains((Object)imageHeaderParser$ImageType);
    }

    public s d(ParcelFileDescriptor parcelFileDescriptor, int n10, int n11, f f10) {
        Object object = this.d;
        b b10 = this.c;
        v$b v$b = new v$b(parcelFileDescriptor, (List)object, b10);
        o$b o$b = o;
        object = this;
        return this.e(v$b, n10, n11, f10, o$b);
    }

    public s f(InputStream inputStream, int n10, int n11, f f10) {
        o$b o$b = o;
        return this.g(inputStream, n10, n11, f10, o$b);
    }

    public s g(InputStream inputStream, int n10, int n11, f f10, o$b o$b) {
        Object object = this.d;
        b b10 = this.c;
        v$a v$a = new v$a(inputStream, (List)object, b10);
        object = this;
        return this.e(v$a, n10, n11, f10, o$b);
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return d.c.a.o.j.m.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }
}

