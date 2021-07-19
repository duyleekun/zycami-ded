/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.bumptech.glide.load.resource.bitmap;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$a;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$b;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$c;
import d.c.a.o.k.x.b;
import d.c.a.u.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class DefaultImageHeaderParser
implements ImageHeaderParser {
    private static final String b = "DfltImageHeaderParser";
    private static final int c = 4671814;
    private static final int d = -1991225785;
    public static final int e = 65496;
    private static final int f = 19789;
    private static final int g = 18761;
    private static final String h = "Exif\u0000\u0000";
    public static final byte[] i;
    private static final int j = 218;
    private static final int k = 217;
    public static final int l = 255;
    public static final int m = 225;
    private static final int n = 274;
    private static final int[] o;
    private static final int p = 1380533830;
    private static final int q = 1464156752;
    private static final int r = 1448097792;
    private static final int s = 65280;
    private static final int t = 255;
    private static final int u = 88;
    private static final int v = 76;
    private static final int w = 16;
    private static final int x = 8;

    static {
        Object object = Charset.forName("UTF-8");
        i = h.getBytes((Charset)object);
        Object object2 = object = (Object)new int[13];
        object2[0] = false;
        object2[1] = true;
        object2[2] = true;
        object2[3] = 2;
        object2[4] = 4;
        object2[5] = 8;
        object2[6] = true;
        object2[7] = true;
        object2[8] = 2;
        object2[9] = 4;
        object2[10] = 8;
        object2[11] = 4;
        object2[12] = 8;
        o = (int[])object;
    }

    private static int e(int n10, int n11) {
        return (n10 += 2) + (n11 *= 12);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int f(DefaultImageHeaderParser$Reader object, b object2) {
        Object object3;
        int n10;
        int n12 = -1;
        try {
            n10 = object.a();
            boolean bl2 = DefaultImageHeaderParser.h(n10);
            int n11 = 3;
            String string2 = b;
            if (!bl2) {
                boolean bl3 = Log.isLoggable((String)string2, (int)n11);
                if (!bl3) return n12;
                object = new StringBuilder();
                object2 = "Parser doesn't handle magic number: ";
                ((StringBuilder)object).append((String)object2);
                ((StringBuilder)object).append(n10);
                object = ((StringBuilder)object).toString();
                Log.d((String)string2, (String)object);
                return n12;
            }
            n10 = this.j((DefaultImageHeaderParser$Reader)object);
            if (n10 == n12) {
                boolean bl4 = Log.isLoggable((String)string2, (int)n11);
                if (!bl4) return n12;
                object = "Failed to parse exif segment length, or exif segment not found";
                Log.d((String)string2, (String)object);
                return n12;
            }
            object3 = byte[].class;
            object3 = object2.c(n10, (Class)object3);
            object3 = (byte[])object3;
        }
        catch (DefaultImageHeaderParser$Reader$EndOfFileException defaultImageHeaderParser$Reader$EndOfFileException) {
            return n12;
        }
        try {
            int n13 = this.l((DefaultImageHeaderParser$Reader)object, (byte[])object3, n10);
            return n13;
        }
        finally {
            object2.put(object3);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private ImageHeaderParser$ImageType g(DefaultImageHeaderParser$Reader var1_1) {
        block32: {
            block30: {
                block31: {
                    block29: {
                        var2_2 = var1_1.a();
                        {
                            catch (DefaultImageHeaderParser$Reader$EndOfFileException v0) {
                                return ImageHeaderParser$ImageType.UNKNOWN;
                            }
                        }
                        var3_3 = -40;
                        if (var2_2 == var3_3) {
                            return ImageHeaderParser$ImageType.JPEG;
                        }
                        var2_2 <<= 8;
                        var3_3 = var1_1.b();
                        var2_2 |= var3_3;
                        var3_3 = 4671814;
                        if (var2_2 != var3_3) break block29;
                        return ImageHeaderParser$ImageType.GIF;
                    }
                    var2_2 <<= 8;
                    var3_3 = var1_1.b();
                    var2_2 |= var3_3;
                    var3_3 = -1991225785;
                    if (var2_2 != var3_3) break block30;
                    var4_4 = 21;
                    var1_1.skip(var4_4);
                    var6_6 = var1_1.b();
                    var2_2 = 3;
                    if (var6_6 < var2_2) break block31;
                    var1_1 = ImageHeaderParser$ImageType.PNG_A;
                }
                try {
                    var1_1 = ImageHeaderParser$ImageType.PNG;
                }
                catch (DefaultImageHeaderParser$Reader$EndOfFileException v1) {
                    return ImageHeaderParser$ImageType.PNG;
                }
                return var1_1;
            }
            var3_3 = 1380533830;
            if (var2_2 != var3_3) {
                return ImageHeaderParser$ImageType.UNKNOWN;
            }
            var4_5 = 4;
            var1_1.skip(var4_5);
            var7_9 = var1_1.a() << 16;
            var8_10 = var1_1.a();
            var7_9 |= var8_10;
            var8_10 = 1464156752;
            if (var7_9 == var8_10) ** GOTO lbl59
            return ImageHeaderParser$ImageType.UNKNOWN;
lbl59:
            // 1 sources

            var7_9 = var1_1.a() << 16;
            var8_10 = var1_1.a();
            var7_9 |= var8_10;
            var8_10 = var7_9 & -256;
            var9_11 = 1448097792;
            if (var8_10 == var9_11) break block32;
            return ImageHeaderParser$ImageType.UNKNOWN;
        }
        var8_10 = 88;
        if ((var7_9 &= 255) == var8_10) {
            block34: {
                block33: {
                    var1_1.skip(var4_5);
                    var6_7 = var1_1.b() & 16;
                    if (var6_7 == 0) break block33;
                    var1_1 = ImageHeaderParser$ImageType.WEBP_A;
                    break block34;
                }
                var1_1 = ImageHeaderParser$ImageType.WEBP;
            }
            return var1_1;
        }
        var8_10 = 76;
        if (var7_9 == var8_10) {
            block36: {
                block35: {
                    var1_1.skip(var4_5);
                    var6_8 = var1_1.b() & 8;
                    if (var6_8 == 0) break block35;
                    var1_1 = ImageHeaderParser$ImageType.WEBP_A;
                    break block36;
                }
                var1_1 = ImageHeaderParser$ImageType.WEBP;
            }
            return var1_1;
        }
        return ImageHeaderParser$ImageType.WEBP;
    }

    private static boolean h(int n10) {
        int n11 = -40;
        int n12 = n10 & n11;
        n10 = n12 != n11 && n10 != (n11 = 19789) && n10 != (n11 = 18761) ? 0 : 1;
        return n10 != 0;
    }

    private boolean i(byte[] byArray, int n10) {
        boolean bl2;
        byte[] byArray2;
        int n11;
        boolean bl22 = false;
        n10 = byArray != null && n10 > (n11 = (byArray2 = i).length) ? 1 : 0;
        if (n10 != 0) {
            byte[] byArray3;
            int n12;
            byArray2 = null;
            for (n11 = 0; n11 < (n12 = (byArray3 = i).length); ++n11) {
                n12 = byArray[n11];
                byte by2 = byArray3[n11];
                if (n12 == by2) {
                    continue;
                }
                break;
            }
        } else {
            bl2 = n10;
        }
        return bl2;
    }

    private int j(DefaultImageHeaderParser$Reader object) {
        int n10;
        block7: {
            String string2;
            int n11;
            int n12;
            int n13;
            long l10;
            long l11;
            long l12;
            int n14;
            do {
                n13 = object.b();
                n10 = 255;
                n12 = 3;
                n11 = -1;
                string2 = b;
                if (n13 != n10) {
                    boolean bl2 = Log.isLoggable((String)string2, (int)n12);
                    if (bl2) {
                        object = new StringBuilder();
                        String string3 = "Unknown segmentId=";
                        ((StringBuilder)object).append(string3);
                        ((StringBuilder)object).append(n13);
                        object = ((StringBuilder)object).toString();
                        Log.d((String)string2, (String)object);
                    }
                    return n11;
                }
                n13 = object.b();
                if (n13 == (n10 = 218)) {
                    return n11;
                }
                n10 = 217;
                if (n13 == n10) {
                    boolean bl3 = Log.isLoggable((String)string2, (int)n12);
                    if (bl3) {
                        object = "Found MARKER_EOI in exif segment";
                        Log.d((String)string2, (String)object);
                    }
                    return n11;
                }
                n10 = object.a() + -2;
                n14 = 225;
                if (n13 == n14) break block7;
            } while ((n14 = (int)((l12 = (l11 = object.skip(l10 = (long)n10)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0);
            boolean bl4 = Log.isLoggable((String)string2, (int)n12);
            if (bl4) {
                object = new StringBuilder();
                String string4 = "Unable to skip enough data, type: ";
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(n13);
                ((StringBuilder)object).append(", wanted to skip: ");
                ((StringBuilder)object).append(n10);
                String string5 = ", but actually skipped: ";
                ((StringBuilder)object).append(string5);
                ((StringBuilder)object).append(l11);
                object = ((StringBuilder)object).toString();
                Log.d((String)string2, (String)object);
            }
            return n11;
        }
        return n10;
    }

    private static int k(DefaultImageHeaderParser$b defaultImageHeaderParser$b) {
        Object object;
        CharSequence charSequence;
        StringBuilder stringBuilder;
        int n10 = 6;
        int n11 = defaultImageHeaderParser$b.a(n10);
        int n12 = 18761;
        int n13 = 3;
        String string2 = b;
        if (n11 != n12) {
            n12 = 19789;
            if (n11 != n12) {
                n12 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
                if (n12 != 0) {
                    stringBuilder = new StringBuilder();
                    charSequence = "Unknown endianness = ";
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append(n11);
                    object = stringBuilder.toString();
                    Log.d((String)string2, (String)object);
                }
                object = ByteOrder.BIG_ENDIAN;
            } else {
                object = ByteOrder.BIG_ENDIAN;
            }
        } else {
            object = ByteOrder.LITTLE_ENDIAN;
        }
        defaultImageHeaderParser$b.e((ByteOrder)object);
        n11 = defaultImageHeaderParser$b.b(10) + n10;
        n10 = defaultImageHeaderParser$b.a(n11);
        stringBuilder = null;
        for (n12 = 0; n12 < n10; ++n12) {
            String string3;
            int n14;
            int n15;
            int n16 = DefaultImageHeaderParser.e(n11, n12);
            int n17 = defaultImageHeaderParser$b.a(n16);
            if (n17 != (n15 = 274)) continue;
            n15 = n16 + 2;
            if ((n15 = (int)defaultImageHeaderParser$b.a(n15)) >= (n14 = 1) && n15 <= (n14 = 12)) {
                CharSequence charSequence2;
                Object object2;
                n14 = n16 + 4;
                if ((n14 = defaultImageHeaderParser$b.b(n14)) < 0) {
                    n16 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
                    if (n16 == 0) continue;
                    charSequence = "Negative tiff component count";
                    Log.d((String)string2, (String)charSequence);
                    continue;
                }
                int n18 = Log.isLoggable((String)string2, (int)n13);
                String string4 = " tagType=";
                if (n18 != false) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Got tagIndex=");
                    ((StringBuilder)object2).append(n12);
                    ((StringBuilder)object2).append(string4);
                    ((StringBuilder)object2).append(n17);
                    ((StringBuilder)object2).append(" formatCode=");
                    ((StringBuilder)object2).append(n15);
                    String string5 = " componentCount=";
                    ((StringBuilder)object2).append(string5);
                    ((StringBuilder)object2).append(n14);
                    object2 = ((StringBuilder)object2).toString();
                    Log.d((String)string2, (String)object2);
                }
                object2 = o;
                n18 = object2[n15];
                if ((n14 += n18) > (n18 = 4)) {
                    n16 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
                    if (n16 == 0) continue;
                    charSequence = new StringBuilder();
                    string3 = "Got byte count > 4, not orientation, continuing, formatCode=";
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(n15);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.d((String)string2, (String)charSequence);
                    continue;
                }
                if ((n16 += 8) >= 0 && n16 <= (n15 = defaultImageHeaderParser$b.d())) {
                    if (n14 >= 0 && (n14 += n16) <= (n15 = defaultImageHeaderParser$b.d())) {
                        return defaultImageHeaderParser$b.a(n16);
                    }
                    n16 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
                    if (n16 == 0) continue;
                    charSequence = new StringBuilder();
                    charSequence2 = "Illegal number of bytes for TI tag data tagType=";
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(n17);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.d((String)string2, (String)charSequence);
                    continue;
                }
                n15 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
                if (n15 == 0) continue;
                charSequence2 = new StringBuilder();
                String string6 = "Illegal tagValueOffset=";
                ((StringBuilder)charSequence2).append(string6);
                ((StringBuilder)charSequence2).append(n16);
                ((StringBuilder)charSequence2).append(string4);
                ((StringBuilder)charSequence2).append(n17);
                charSequence = ((StringBuilder)charSequence2).toString();
                Log.d((String)string2, (String)charSequence);
                continue;
            }
            n16 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
            if (n16 == 0) continue;
            charSequence = new StringBuilder();
            string3 = "Got invalid format code = ";
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append(n15);
            charSequence = ((StringBuilder)charSequence).toString();
            Log.d((String)string2, (String)charSequence);
        }
        return -1;
    }

    private int l(DefaultImageHeaderParser$Reader object, byte[] object2, int n10) {
        int n11 = object.read((byte[])object2, n10);
        int n12 = -1;
        int n13 = 3;
        String string2 = b;
        if (n11 != n10) {
            boolean bl2 = Log.isLoggable((String)string2, (int)n13);
            if (bl2) {
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                String string3 = "Unable to read exif segment data, length: ";
                ((StringBuilder)object2).append(string3);
                ((StringBuilder)object2).append(n10);
                String string4 = ", actually read: ";
                ((StringBuilder)object2).append(string4);
                ((StringBuilder)object2).append(n11);
                object = ((StringBuilder)object2).toString();
                Log.d((String)string2, (String)object);
            }
            return n12;
        }
        n11 = (int)(this.i((byte[])object2, n10) ? 1 : 0);
        if (n11 != 0) {
            object = new DefaultImageHeaderParser$b((byte[])object2, n10);
            return DefaultImageHeaderParser.k((DefaultImageHeaderParser$b)object);
        }
        n11 = (int)(Log.isLoggable((String)string2, (int)n13) ? 1 : 0);
        if (n11 != 0) {
            object = "Missing jpeg exif preamble";
            Log.d((String)string2, (String)object);
        }
        return n12;
    }

    public ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        byteBuffer = (ByteBuffer)d.c.a.u.k.d(byteBuffer);
        DefaultImageHeaderParser$a defaultImageHeaderParser$a = new DefaultImageHeaderParser$a(byteBuffer);
        return this.g(defaultImageHeaderParser$a);
    }

    public int b(ByteBuffer object, b b10) {
        object = (ByteBuffer)d.c.a.u.k.d(object);
        DefaultImageHeaderParser$a defaultImageHeaderParser$a = new DefaultImageHeaderParser$a((ByteBuffer)object);
        object = (b)d.c.a.u.k.d(b10);
        return this.f(defaultImageHeaderParser$a, (b)object);
    }

    public ImageHeaderParser$ImageType c(InputStream inputStream) {
        inputStream = (InputStream)d.c.a.u.k.d(inputStream);
        DefaultImageHeaderParser$c defaultImageHeaderParser$c = new DefaultImageHeaderParser$c(inputStream);
        return this.g(defaultImageHeaderParser$c);
    }

    public int d(InputStream object, b b10) {
        object = (InputStream)d.c.a.u.k.d(object);
        DefaultImageHeaderParser$c defaultImageHeaderParser$c = new DefaultImageHeaderParser$c((InputStream)object);
        object = (b)d.c.a.u.k.d(b10);
        return this.f(defaultImageHeaderParser$c, (b)object);
    }
}

