/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.j.f.a.a.k;

import android.text.TextUtils;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Locale;

public final class c {
    private static final String a = "";
    private static final String b = "HexUtil";

    private c() {
    }

    public static String a(String object) {
        String string2 = b;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        String string3 = a;
        if (bl2) {
            return string3;
        }
        CharSequence charSequence = "UTF-8";
        object = ((String)object).getBytes((String)charSequence);
        try {
            string3 = c.b((byte[])object);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            String string4 = "byte array 2 hex string exception : ";
            ((StringBuilder)charSequence).append(string4);
            String string5 = exception.getMessage();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            Log.e((String)string2, (String)string5);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            charSequence = new StringBuilder();
            String string6 = "byte array 2 hex string UnsupportedEncodingException : ";
            ((StringBuilder)charSequence).append(string6);
            String string7 = unsupportedEncodingException.getMessage();
            ((StringBuilder)charSequence).append(string7);
            string7 = ((StringBuilder)charSequence).toString();
            Log.e((String)string2, (String)string7);
        }
        return string3;
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
        String string2 = b;
        String string3 = "UTF-8";
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            return new byte[0];
        }
        Locale locale = Locale.ENGLISH;
        object = ((String)object).toUpperCase(locale);
        n10 = ((String)object).length() / 2;
        byte[] byArray = new byte[n10];
        object = ((String)object).getBytes(string3);
        for (int i10 = 0; i10 < n10; ++i10) {
            String string4;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append((String)charSequence);
            int n11 = 1;
            Object object3 = new byte[n11];
            Object object4 = i10 * 2;
            Object object5 = object[object4];
            object3[0] = (byte)object5;
            Object object6 = new String((byte[])object3, string3);
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
            object3(byArray2, string3);
            ((StringBuilder)object6).append((String)object3);
            object6 = ((StringBuilder)object6).toString();
            object6 = Byte.decode((String)object6);
            byte by3 = (Byte)object6;
            by2 = (byte)(by2 ^ by3);
            try {
                byArray[i10] = by2;
                continue;
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                string3 = "byte array 2 hex string exception : ";
                ((StringBuilder)charSequence).append(string3);
                String string5 = exception.getMessage();
                ((StringBuilder)charSequence).append(string5);
                string5 = ((StringBuilder)charSequence).toString();
                Log.e((String)string2, (String)string5);
                break;
            }
            catch (NumberFormatException numberFormatException) {
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                // empty catch block
            }
            charSequence = new StringBuilder();
            string3 = "hex string 2 byte UnsupportedEncodingException or NumberFormatException : ";
            ((StringBuilder)charSequence).append(string3);
            string4 = ((Throwable)((Object)string4)).getMessage();
            ((StringBuilder)charSequence).append(string4);
            string4 = ((StringBuilder)charSequence).toString();
            Log.e((String)string2, (String)string4);
            break;
        }
        return byArray;
    }
}

