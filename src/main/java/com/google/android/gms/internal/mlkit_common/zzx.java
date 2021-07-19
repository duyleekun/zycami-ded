/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzu;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class zzx {
    private static String zza(Object object) {
        if (object == null) {
            return "null";
        }
        try {
            return object.toString();
        }
        catch (Exception exception) {
            CharSequence charSequence;
            Object object2 = object.getClass().getName();
            int n10 = System.identityHashCode(object);
            object = Integer.toHexString(n10);
            int n11 = String.valueOf(object2).length() + 1;
            int n12 = String.valueOf(object).length();
            CharSequence charSequence2 = new StringBuilder(n11 += n12);
            ((StringBuilder)charSequence2).append((String)object2);
            char c10 = '@';
            ((StringBuilder)charSequence2).append(c10);
            ((StringBuilder)charSequence2).append((String)object);
            object = ((StringBuilder)charSequence2).toString();
            object2 = Logger.getLogger("com.google.common.base.Strings");
            Level level = Level.WARNING;
            charSequence2 = "Exception during lenientFormat for ";
            String string2 = String.valueOf(object);
            int n13 = string2.length();
            if (n13 != 0) {
                charSequence = charSequence2 = ((String)charSequence2).concat(string2);
            } else {
                string2 = new String((String)charSequence2);
                charSequence = string2;
            }
            ((Logger)object2).logp(level, "com.google.common.base.Strings", "lenientToString", (String)charSequence, exception);
            object2 = exception.getClass().getName();
            n11 = String.valueOf(object).length() + 9;
            n12 = String.valueOf(object2).length();
            charSequence2 = new StringBuilder(n11 += n12);
            ((StringBuilder)charSequence2).append("<");
            ((StringBuilder)charSequence2).append((String)object);
            ((StringBuilder)charSequence2).append(" threw ");
            ((StringBuilder)charSequence2).append((String)object2);
            ((StringBuilder)charSequence2).append(">");
            return ((StringBuilder)charSequence2).toString();
        }
    }

    public static String zza(String string2) {
        return zzu.zza(string2);
    }

    public static String zza(String object, Object ... objectArray) {
        int n10;
        String string2;
        String string3;
        int n11;
        object = String.valueOf(object);
        int n12 = 0;
        Object object2 = null;
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < (n11 = objectArray.length); ++i10) {
            string3 = zzx.zza(objectArray[i10]);
            objectArray[i10] = string3;
        }
        n11 = ((String)object).length();
        int n13 = objectArray.length * 16;
        stringBuilder = new StringBuilder(n11 += n13);
        n11 = 0;
        string3 = null;
        while (n12 < (n13 = objectArray.length) && (n13 = ((String)object).indexOf(string2 = "%s", n11)) != (n10 = -1)) {
            stringBuilder.append((CharSequence)object, n11, n13);
            n11 = n12 + 1;
            object2 = objectArray[n12];
            stringBuilder.append(object2);
            n12 = n13 + 2;
            int n14 = n11;
            n11 = n12;
            n12 = n14;
        }
        n13 = ((String)object).length();
        stringBuilder.append((CharSequence)object, n11, n13);
        int n15 = objectArray.length;
        if (n12 < n15) {
            object = " [";
            stringBuilder.append((String)object);
            n15 = n12 + 1;
            object2 = objectArray[n12];
            stringBuilder.append(object2);
            while (n15 < (n12 = objectArray.length)) {
                object2 = ", ";
                stringBuilder.append((String)object2);
                n12 = n15 + '\u0001';
                object = objectArray[n15];
                stringBuilder.append(object);
                n15 = n12;
            }
            n15 = 93;
            stringBuilder.append((char)n15);
        }
        return stringBuilder.toString();
    }
}

