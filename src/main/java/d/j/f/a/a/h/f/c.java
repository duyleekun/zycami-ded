/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package d.j.f.a.a.h.f;

import android.text.TextUtils;
import d.j.f.a.a.h.f.g;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class c {
    private static final String a = "";
    private static final String b = "HexUtil";

    private c() {
    }

    public static String a(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string2 = a;
        if (bl2) {
            return string2;
        }
        CharSequence charSequence = "UTF-8";
        object = ((String)object).getBytes((String)charSequence);
        try {
            string2 = c.b((byte[])object);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            charSequence = new StringBuilder();
            String string3 = "byte array 2 hex string exception : ";
            ((StringBuilder)charSequence).append(string3);
            String string4 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            charSequence = b;
            g.f((String)charSequence, string4);
        }
        return string2;
    }

    public static String b(byte[] byArray) {
        int n10;
        if (byArray != null && (n10 = byArray.length) != 0) {
            int n11;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i10 = 0; i10 < (n11 = byArray.length); ++i10) {
                int n12;
                n11 = byArray[i10] & 0xFF;
                String string2 = Integer.toHexString(n11);
                int n13 = string2.length();
                if (n13 == (n12 = 1)) {
                    n13 = 48;
                    stringBuilder.append((char)n13);
                }
                stringBuilder.append(string2);
            }
            return stringBuilder.toString();
        }
        return a;
    }

    public static byte[] c(String object) {
        CharSequence charSequence = "0x";
        String string2 = "UTF-8";
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            return new byte[0];
        }
        Locale locale = Locale.ENGLISH;
        object = ((String)object).toUpperCase(locale);
        n10 = ((String)object).length() / 2;
        byte[] byArray = new byte[n10];
        object = ((String)object).getBytes(string2);
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)charSequence);
            int n11 = 1;
            Object object3 = new byte[n11];
            Object object4 = i10 * 2;
            Object object5 = object[object4];
            object3[0] = (byte)object5;
            Object object6 = new String((byte[])object3, string2);
            ((StringBuilder)object2).append((String)object6);
            object2 = ((StringBuilder)object2).toString();
            object2 = Byte.decode((String)object2);
            byte by2 = (byte)((Byte)object2 << 4);
            object6 = new StringBuilder();
            ((StringBuilder)object6).append((String)charSequence);
            object3 = new String;
            byte[] byArray2 = new byte[n11];
            ++object4;
            object4 = object[object4];
            byArray2[0] = object4;
            object3(byArray2, string2);
            ((StringBuilder)object6).append((String)object3);
            object6 = ((StringBuilder)object6).toString();
            object6 = Byte.decode((String)object6);
            byte by3 = (Byte)object6;
            by2 = (byte)(by2 ^ by3);
            try {
                byArray[i10] = by2;
                continue;
            }
            catch (NumberFormatException numberFormatException) {
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
            charSequence = new StringBuilder();
            string2 = "hex string 2 byte array exception : ";
            ((StringBuilder)charSequence).append(string2);
            string3 = ((Throwable)((Object)string3)).getMessage();
            ((StringBuilder)charSequence).append(string3);
            string3 = ((StringBuilder)charSequence).toString();
            charSequence = b;
            g.f((String)charSequence, string3);
            break;
        }
        return byArray;
    }
}

