/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.core.database;

import android.text.TextUtils;

public final class DatabaseUtilsCompat {
    private DatabaseUtilsCompat() {
    }

    public static String[] appendSelectionArgs(String[] stringArray, String[] stringArray2) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            n10 = stringArray.length;
            int n11 = stringArray2.length;
            String[] stringArray3 = new String[n10 + n11];
            n11 = stringArray.length;
            System.arraycopy(stringArray, 0, stringArray3, 0, n11);
            int n12 = stringArray.length;
            n11 = stringArray2.length;
            System.arraycopy(stringArray2, 0, stringArray3, n12, n11);
            return stringArray3;
        }
        return stringArray2;
    }

    public static String concatenateWhere(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string3;
        }
        bl2 = TextUtils.isEmpty((CharSequence)string3);
        if (bl2) {
            return string2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        stringBuilder.append(string2);
        stringBuilder.append(") AND (");
        stringBuilder.append(string3);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

