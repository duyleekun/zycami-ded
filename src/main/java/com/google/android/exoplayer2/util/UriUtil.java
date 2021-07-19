/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.text.TextUtils
 */
package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;
import java.util.Iterator;

public final class UriUtil {
    private static final int FRAGMENT = 3;
    private static final int INDEX_COUNT = 4;
    private static final int PATH = 1;
    private static final int QUERY = 2;
    private static final int SCHEME_COLON;

    private UriUtil() {
    }

    /*
     * Unable to fully structure code
     */
    private static int[] getUriIndices(String var0) {
        var1_1 = 4;
        var2_2 = new int[var1_1];
        var3_3 = TextUtils.isEmpty((CharSequence)var0);
        var4_4 = -1;
        if (var3_3 != 0) {
            var2_2[0] = var4_4;
            return var2_2;
        }
        var3_3 = var0.length();
        var5_5 = var0.indexOf(35);
        if (var5_5 != var4_4) {
            var3_3 = var5_5;
        }
        var5_5 = var0.indexOf(63);
        if (var5_5 == var4_4 || var5_5 > var3_3) {
            var5_5 = var3_3;
        }
        if ((var7_7 = var0.indexOf(var6_6 = 47)) == var4_4 || var7_7 > var5_5) {
            var7_7 = var5_5;
        }
        if ((var8_8 = var0.indexOf(58)) > var7_7) {
            var8_8 = var4_4;
        }
        var7_7 = var8_8 + 2;
        var9_9 = 1;
        if (var7_7 >= var5_5) ** GOTO lbl-1000
        var10_10 = var8_8 + 1;
        if ((var10_10 = (int)var0.charAt(var10_10)) == var6_6 && (var7_7 = (int)var0.charAt(var7_7)) == var6_6) {
            var7_7 = var9_9;
        } else lbl-1000:
        // 2 sources

        {
            var7_7 = 0;
        }
        if (var7_7 != 0) {
            var7_7 = var8_8 + 3;
            var11_11 = var0.indexOf(var6_6, var7_7);
            if (var11_11 == var4_4 || var11_11 > var5_5) {
                var11_11 = var5_5;
            }
        } else {
            var11_11 = var8_8 + 1;
        }
        var2_2[0] = var8_8;
        var2_2[var9_9] = var11_11;
        var2_2[2] = var5_5;
        var2_2[3] = var3_3;
        return var2_2;
    }

    private static String removeDotSegments(StringBuilder stringBuilder, int n10, int n11) {
        int n12;
        if (n10 >= n11) {
            return stringBuilder.toString();
        }
        int n13 = stringBuilder.charAt(n10);
        if (n13 == (n12 = 47)) {
            ++n10;
        }
        n13 = n10;
        int n14 = n10;
        while (n13 <= n11) {
            block11: {
                int n15;
                int n16;
                block10: {
                    block9: {
                        if (n13 != n11) break block9;
                        n16 = n13;
                        break block10;
                    }
                    n16 = stringBuilder.charAt(n13);
                    if (n16 != n12) break block11;
                    n16 = n13 + 1;
                }
                int n17 = n14 + 1;
                int n18 = 46;
                if (n13 == n17 && (n15 = stringBuilder.charAt(n14)) == n18) {
                    stringBuilder.delete(n14, n16);
                    n11 -= (n16 -= n14);
                } else {
                    n15 = n14 + 2;
                    if (n13 == n15 && (n15 = (int)stringBuilder.charAt(n14)) == n18 && (n17 = (int)stringBuilder.charAt(n17)) == n18) {
                        String string2 = "/";
                        n13 = stringBuilder.lastIndexOf(string2, n14 += -2) + 1;
                        n14 = n13 > n10 ? n13 : n10;
                        stringBuilder.delete(n14, n16);
                        n11 -= (n16 -= n14);
                    }
                    n14 = ++n13;
                }
                n13 = n14;
                continue;
            }
            ++n13;
        }
        return stringBuilder.toString();
    }

    public static Uri removeQueryParameter(Uri uri, String string2) {
        boolean bl2;
        Uri.Builder builder = uri.buildUpon();
        builder.clearQuery();
        Iterator iterator2 = uri.getQueryParameterNames().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            String string3 = (String)iterator2.next();
            boolean bl4 = string3.equals(string2);
            if (bl4) continue;
            Iterator iterator3 = uri.getQueryParameters(string3).iterator();
            while (bl3 = iterator3.hasNext()) {
                String string4 = (String)iterator3.next();
                builder.appendQueryParameter(string3, string4);
            }
        }
        return builder.build();
    }

    public static String resolve(String string2, String string3) {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = "";
        if (string2 == null) {
            string2 = object;
        }
        if (string3 == null) {
            string3 = object;
        }
        object = UriUtil.getUriIndices(string3);
        Object object2 = object[0];
        int n10 = -1;
        int n11 = 2;
        int n12 = 1;
        if (object2 != n10) {
            stringBuilder.append(string3);
            Object n16 = object[n12];
            Object n17 = object[n11];
            UriUtil.removeDotSegments(stringBuilder, (int)n16, (int)n17);
            return stringBuilder.toString();
        }
        int[] nArray = UriUtil.getUriIndices(string2);
        int n13 = 3;
        Object object3 = object[n13];
        if (object3 == false) {
            int object6 = nArray[n13];
            stringBuilder.append(string2, 0, object6);
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
        n13 = (int)object[n11];
        if (n13 == 0) {
            int object7 = nArray[n11];
            stringBuilder.append(string2, 0, object7);
            stringBuilder.append(string3);
            return stringBuilder.toString();
        }
        n13 = (int)object[n12];
        if (n13 != 0) {
            int n14 = nArray[0] + n12;
            stringBuilder.append(string2, 0, n14);
            stringBuilder.append(string3);
            reference n19 = object[n12] + n14;
            Object n20 = object[n11];
            int n15 = n14 + n20;
            return UriUtil.removeDotSegments(stringBuilder, (int)n19, n15);
        }
        n13 = (int)object[n12];
        if ((n13 = (int)string3.charAt(n13)) == (object3 = (Object)47)) {
            n10 = nArray[n12];
            stringBuilder.append(string2, 0, n10);
            stringBuilder.append(string3);
            int n21 = nArray[n12];
            int object8 = nArray[n12];
            Object object4 = object[n11];
            return UriUtil.removeDotSegments(stringBuilder, n21, object8 += object4);
        }
        n13 = nArray[0] + n11;
        int n16 = nArray[n12];
        if (n13 < n16 && (n13 = nArray[n12]) == (n16 = nArray[n11])) {
            n10 = nArray[n12];
            stringBuilder.append(string2, 0, n10);
            stringBuilder.append((char)object3);
            stringBuilder.append(string3);
            int n17 = nArray[n12];
            int n18 = nArray[n12];
            Object object5 = object[n11];
            n18 = n18 + object5 + n12;
            return UriUtil.removeDotSegments(stringBuilder, n17, n18);
        }
        n13 = nArray[n11] - n12;
        n10 = (n13 = string2.lastIndexOf((int)object3, n13)) == n10 ? nArray[n12] : n13 + 1;
        stringBuilder.append(string2, 0, n10);
        stringBuilder.append(string3);
        int n19 = nArray[n12];
        Object object6 = object[n11];
        return UriUtil.removeDotSegments(stringBuilder, n19, n10 += object6);
    }

    public static Uri resolveToUri(String string2, String string3) {
        return Uri.parse((String)UriUtil.resolve(string2, string3));
    }
}

