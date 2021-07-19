/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.a.a;
import com.sina.weibo.sdk.a.a$3;
import com.sina.weibo.sdk.c.d;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public final class e {
    private static char[] ap;
    private static byte[] aq;

    static {
        int n10;
        int n11;
        byte[] byArray;
        int n12;
        Object[] objectArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
        ap = objectArray;
        int n13 = 256;
        aq = new byte[n13];
        byte[] byArray2 = null;
        for (n12 = 0; n12 < n13; ++n12) {
            byArray = aq;
            byArray[n12] = n11 = -1;
        }
        for (n13 = 65; n13 <= (n12 = 90); ++n13) {
            byArray2 = aq;
            byArray2[n13] = n10 = (int)((byte)(n13 + -65));
        }
        for (n12 = n13 = 97; n12 <= (n10 = 122); ++n12) {
            byArray = aq;
            byArray[n12] = n11 = (int)((byte)(n12 + 26 - n13));
        }
        for (n12 = n13 = 48; n12 <= (n10 = 57); ++n12) {
            byArray = aq;
            byArray[n12] = n11 = (int)((byte)(n12 + 52 - n13));
        }
        objectArray = aq;
        objectArray[43] = 62;
        objectArray[47] = 63;
    }

    public static int a(int n10, Context context) {
        float f10 = context.getResources().getDisplayMetrics().density;
        return (int)((float)n10 * f10 + 0.5f);
    }

    public static byte[] b(byte[] byArray) {
        int n10;
        int n11 = (byArray.length + 2) / 3 * 4;
        byte[] byArray2 = new byte[n11];
        int n12 = 0;
        int n13 = 0;
        while (n12 < (n10 = byArray.length)) {
            n10 = (byArray[n12] & 0xFF) << 8;
            int n14 = n12 + 1;
            int n15 = byArray.length;
            int n16 = 1;
            if (n14 < n15) {
                n14 = byArray[n14] & 0xFF;
                n10 |= n14;
                n14 = n16;
            } else {
                n14 = 0;
            }
            n10 <<= 8;
            n15 = n12 + 2;
            int n17 = byArray.length;
            if (n15 < n17) {
                n15 = byArray[n15] & 0xFF;
                n10 |= n15;
            } else {
                n16 = 0;
            }
            n15 = n13 + 3;
            char[] cArray = ap;
            int n18 = 64;
            float f10 = 9.0E-44f;
            n16 = n16 != 0 ? n10 & 0x3F : n18;
            byArray2[n15] = n16 = (int)((byte)cArray[n16]);
            n10 >>= 6;
            n15 = n13 + 2;
            if (n14 != 0) {
                n18 = n10 & 0x3F;
            }
            byArray2[n15] = n14 = (int)((byte)cArray[n18]);
            n14 = n13 + 1;
            n15 = (n10 >>= 6) & 0x3F;
            byArray2[n14] = n15 = (int)((byte)cArray[n15]);
            n10 >>= 6;
            n14 = n13 + 0;
            n10 &= 0x3F;
            byArray2[n14] = n10 = (int)((byte)cArray[n10]);
            n12 += 3;
            n13 += 4;
        }
        return byArray2;
    }

    public static String e(Context object, String string2) {
        block9: {
            object = object.getPackageManager();
            int n10 = 64;
            object = object.getPackageInfo(string2, n10);
            if (object == null) break block9;
            object = object.signatures;
            if (object == null) break block9;
            int n11 = ((Signature[])object).length;
            if (n11 <= 0) break block9;
            n11 = 0;
            string2 = null;
            object = object[0];
            object = object.toByteArray();
            try {
                return d.a((byte[])object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                nameNotFoundException.printStackTrace();
            }
        }
        return null;
    }

    public static String f(Context object, String object2) {
        Object object3 = a.b();
        String string2 = ((a)object3).c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        object3 = !bl2 ? ((a)object3).c : ((a)object3).c((Context)object, (String)object2);
        bl2 = TextUtils.isEmpty((CharSequence)object3);
        if (bl2) {
            object3 = a.b();
            a.a((Context)object, (String)object2);
            object2 = new a$3((a)object3);
            object = new Thread((Runnable)object2);
            ((Thread)object).start();
            object3 = ((a)object3).c;
        }
        return object3;
    }

    public static Bundle g(String string2) {
        try {
            URL uRL = new URL(string2);
            string2 = uRL.getQuery();
        }
        catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
            return null;
        }
        return e.i(string2);
    }

    public static Bundle h(String string2) {
        try {
            URI uRI = new URI(string2);
            string2 = uRI.getQuery();
        }
        catch (URISyntaxException uRISyntaxException) {
            uRISyntaxException.printStackTrace();
            return null;
        }
        return e.i(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Bundle i(String stringArray) {
        Bundle bundle = new Bundle();
        if (stringArray != null) {
            String string2 = "&";
            for (String string3 : stringArray.split(string2)) {
                String string4 = "=";
                String[] stringArray2 = string3.split(string4);
                try {
                    int n10 = stringArray2.length;
                    int n11 = 2;
                    String string5 = "UTF-8";
                    int n12 = 1;
                    if (n10 == n11) {
                        string4 = stringArray2[0];
                        string4 = URLDecoder.decode(string4, string5);
                        String string7 = stringArray2[n12];
                        string7 = URLDecoder.decode(string7, string5);
                        bundle.putString(string4, string7);
                        continue;
                    }
                    n10 = stringArray2.length;
                    if (n10 != n12) continue;
                    String string9 = stringArray2[0];
                    string9 = URLDecoder.decode(string9, string5);
                    string4 = "";
                    bundle.putString(string9, string4);
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    unsupportedEncodingException.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static String r() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Build.MANUFACTURER;
        stringBuilder.append(string2);
        stringBuilder.append("-");
        string2 = Build.MODEL;
        stringBuilder.append(string2);
        string2 = "_";
        stringBuilder.append(string2);
        String string3 = Build.VERSION.RELEASE;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        stringBuilder.append("weibosdk");
        stringBuilder.append(string2);
        stringBuilder.append("0041005000");
        stringBuilder.append("_android");
        return stringBuilder.toString();
    }
}

