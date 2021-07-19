/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.t.a.i;

import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import d.t.a.i.f$a;
import d.t.a.i.f$b;
import d.t.a.i.f$c;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class f {
    private static final String b = "ImageHeaderParser";
    public static final int c = 255;
    private static final int d = 65496;
    private static final int e = 19789;
    private static final int f = 18761;
    private static final String g = "Exif\u0000\u0000";
    private static final byte[] h;
    private static final int i = 218;
    private static final int j = 217;
    private static final int k = 255;
    private static final int l = 225;
    private static final int m = 274;
    private static final int[] n;
    private final f$b a;

    static {
        Object object = Charset.forName("UTF-8");
        h = g.getBytes((Charset)object);
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
        n = (int[])object;
    }

    public f(InputStream inputStream) {
        f$c f$c = new f$c(inputStream);
        this.a = f$c;
    }

    private static int a(int n10, int n11) {
        return (n10 += 2) + (n11 *= 12);
    }

    public static void b(ExifInterface exifInterface, int n10, int n11, String string2) {
        int n12;
        Object object = "FNumber";
        String string3 = "DateTime";
        String string4 = "DateTimeDigitized";
        Object object2 = "ExposureTime";
        String string5 = "Flash";
        String string6 = "FocalLength";
        String string7 = "GPSAltitude";
        String string8 = "GPSAltitudeRef";
        String string9 = "GPSDateStamp";
        String string10 = "GPSLatitude";
        String string11 = "GPSLatitudeRef";
        String string12 = "GPSLongitude";
        String string13 = "GPSLongitudeRef";
        String string14 = "GPSProcessingMethod";
        String string15 = "GPSTimeStamp";
        String string16 = "PhotographicSensitivity";
        String string17 = "Make";
        String string18 = "Model";
        String string19 = "SubSecTime";
        String string20 = "SubSecTimeDigitized";
        String string21 = "SubSecTimeOriginal";
        String string22 = "WhiteBalance";
        Object object3 = new String[]{object, string3, string4, object2, string5, string6, string7, string8, string9, string10, string11, string12, string13, string14, string15, string16, string17, string18, string19, string20, string21, string22};
        string3 = string2;
        object = new ExifInterface(string2);
        string3 = null;
        for (int i10 = 0; i10 < (n12 = 22); ++i10) {
            string4 = object3[i10];
            object2 = exifInterface;
            string5 = exifInterface.getAttribute(string4);
            boolean bl2 = TextUtils.isEmpty((CharSequence)string5);
            if (bl2) continue;
            ((ExifInterface)object).setAttribute(string4, string5);
        }
        object3 = "ImageWidth";
        string3 = String.valueOf(n10);
        ((ExifInterface)object).setAttribute((String)object3, string3);
        object3 = "ImageLength";
        string3 = String.valueOf(n11);
        ((ExifInterface)object).setAttribute((String)object3, string3);
        object3 = "Orientation";
        string3 = "0";
        try {
            ((ExifInterface)object).setAttribute((String)object3, string3);
            ((ExifInterface)object).saveAttributes();
        }
        catch (IOException iOException) {
            object3 = iOException.getMessage();
            object = b;
            Log.d((String)object, (String)object3);
        }
    }

    private static boolean d(int n10) {
        int n11 = -40;
        int n12 = n10 & n11;
        n10 = n12 != n11 && n10 != (n11 = 19789) && n10 != (n11 = 18761) ? 0 : 1;
        return n10 != 0;
    }

    private boolean e(byte[] byArray, int n10) {
        boolean bl2;
        byte[] byArray2;
        int n11;
        boolean bl22 = false;
        n10 = byArray != null && n10 > (n11 = (byArray2 = h).length) ? 1 : 0;
        if (n10 != 0) {
            byte[] byArray3;
            int n12;
            byArray2 = null;
            for (n11 = 0; n11 < (n12 = (byArray3 = h).length); ++n11) {
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

    private int f() {
        int n10;
        block7: {
            String string2;
            int n11;
            int n12;
            int n13;
            Object object;
            long l10;
            Object object2;
            long l11;
            long l12;
            int n14;
            do {
                Object object3;
                object = this.a;
                n13 = object.b();
                n10 = 255;
                n12 = 3;
                n11 = -1;
                string2 = b;
                if (n13 != n10) {
                    n10 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                    if (n10 != 0) {
                        object3 = new StringBuilder();
                        String string3 = "Unknown segmentId=";
                        ((StringBuilder)object3).append(string3);
                        ((StringBuilder)object3).append(n13);
                        object = ((StringBuilder)object3).toString();
                        Log.d((String)string2, (String)object);
                    }
                    return n11;
                }
                object = this.a;
                n13 = object.b();
                if (n13 == (n10 = 218)) {
                    return n11;
                }
                n10 = 217;
                if (n13 == n10) {
                    n13 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                    if (n13 != 0) {
                        object = "Found MARKER_EOI in exif segment";
                        Log.d((String)string2, (String)object);
                    }
                    return n11;
                }
                object3 = this.a;
                n10 = object3.a() + -2;
                n14 = 225;
                if (n13 == n14) break block7;
            } while ((n14 = (int)((l12 = (l11 = (object2 = this.a).skip(l10 = (long)n10)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0);
            if ((n12 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0)) != 0) {
                StringBuilder stringBuilder = new StringBuilder();
                object2 = "Unable to skip enough data, type: ";
                stringBuilder.append((String)object2);
                stringBuilder.append(n13);
                stringBuilder.append(", wanted to skip: ");
                stringBuilder.append(n10);
                stringBuilder.append(", but actually skipped: ");
                stringBuilder.append(l11);
                object = stringBuilder.toString();
                Log.d((String)string2, (String)object);
            }
            return n11;
        }
        return n10;
    }

    private static int g(f$a f$a) {
        CharSequence charSequence;
        StringBuilder stringBuilder;
        Object object;
        int n10 = 6;
        int n11 = f$a.a(n10);
        int n12 = 3;
        String string2 = b;
        int n13 = 19789;
        if (n11 == n13) {
            object = ByteOrder.BIG_ENDIAN;
        } else {
            n13 = 18761;
            if (n11 == n13) {
                object = ByteOrder.LITTLE_ENDIAN;
            } else {
                n13 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                if (n13 != 0) {
                    stringBuilder = new StringBuilder();
                    charSequence = "Unknown endianness = ";
                    stringBuilder.append((String)charSequence);
                    stringBuilder.append(n11);
                    object = stringBuilder.toString();
                    Log.d((String)string2, (String)object);
                }
                object = ByteOrder.BIG_ENDIAN;
            }
        }
        f$a.d((ByteOrder)object);
        n11 = f$a.b(10) + n10;
        n10 = f$a.a(n11);
        stringBuilder = null;
        for (n13 = 0; n13 < n10; ++n13) {
            String string3;
            int n14;
            int n15;
            int n16 = d.t.a.i.f.a(n11, n13);
            int n17 = f$a.a(n16);
            if (n17 != (n15 = 274)) continue;
            n15 = n16 + 2;
            if ((n15 = (int)f$a.a(n15)) >= (n14 = 1) && n15 <= (n14 = 12)) {
                CharSequence charSequence2;
                Object object2;
                n14 = n16 + 4;
                if ((n14 = f$a.b(n14)) < 0) {
                    n16 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                    if (n16 == 0) continue;
                    charSequence = "Negative tiff component count";
                    Log.d((String)string2, (String)charSequence);
                    continue;
                }
                int n18 = Log.isLoggable((String)string2, (int)n12);
                String string4 = " tagType=";
                if (n18 != false) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Got tagIndex=");
                    ((StringBuilder)object2).append(n13);
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
                object2 = n;
                n18 = object2[n15];
                if ((n14 += n18) > (n18 = 4)) {
                    n16 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                    if (n16 == 0) continue;
                    charSequence = new StringBuilder();
                    string3 = "Got byte count > 4, not orientation, continuing, formatCode=";
                    ((StringBuilder)charSequence).append(string3);
                    ((StringBuilder)charSequence).append(n15);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.d((String)string2, (String)charSequence);
                    continue;
                }
                if ((n16 += 8) >= 0 && n16 <= (n15 = f$a.c())) {
                    if (n14 >= 0 && (n14 += n16) <= (n15 = f$a.c())) {
                        return f$a.a(n16);
                    }
                    n16 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
                    if (n16 == 0) continue;
                    charSequence = new StringBuilder();
                    charSequence2 = "Illegal number of bytes for TI tag data tagType=";
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(n17);
                    charSequence = ((StringBuilder)charSequence).toString();
                    Log.d((String)string2, (String)charSequence);
                    continue;
                }
                n15 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
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
            n16 = (int)(Log.isLoggable((String)string2, (int)n12) ? 1 : 0);
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

    private int h(byte[] object, int n10) {
        Object object2 = this.a;
        int n11 = object2.read((byte[])object, n10);
        int n12 = -1;
        int n13 = 3;
        String string2 = b;
        if (n11 != n10) {
            boolean bl2 = Log.isLoggable((String)string2, (int)n13);
            if (bl2) {
                object = new StringBuilder;
                ((StringBuilder)object)();
                String string3 = "Unable to read exif segment data, length: ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(n10);
                String string4 = ", actually read: ";
                ((StringBuilder)object).append(string4);
                ((StringBuilder)object).append(n11);
                object = ((StringBuilder)object).toString();
                Log.d((String)string2, (String)object);
            }
            return n12;
        }
        n11 = (int)(this.e((byte[])object, n10) ? 1 : 0);
        if (n11 != 0) {
            object2 = new f$a((byte[])object, n10);
            return d.t.a.i.f.g((f$a)object2);
        }
        boolean bl3 = Log.isLoggable((String)string2, (int)n13);
        if (bl3) {
            object = "Missing jpeg exif preamble";
            Log.d((String)string2, (String)object);
        }
        return n12;
    }

    public int c() {
        Object object = this.a;
        int n10 = object.a();
        boolean bl2 = d.t.a.i.f.d(n10);
        int n11 = 3;
        int n12 = -1;
        String string2 = b;
        if (!bl2) {
            bl2 = Log.isLoggable((String)string2, (int)n11);
            if (bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "Parser doesn't handle magic number: ";
                stringBuilder.append(string3);
                stringBuilder.append(n10);
                object = stringBuilder.toString();
                Log.d((String)string2, (String)object);
            }
            return n12;
        }
        n10 = this.f();
        if (n10 == n12) {
            n10 = (int)(Log.isLoggable((String)string2, (int)n11) ? 1 : 0);
            if (n10 != 0) {
                object = "Failed to parse exif segment length, or exif segment not found";
                Log.d((String)string2, (String)object);
            }
            return n12;
        }
        byte[] byArray = new byte[n10];
        return this.h(byArray, n10);
    }
}

