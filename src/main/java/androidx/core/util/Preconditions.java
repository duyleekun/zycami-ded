/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package androidx.core.util;

import android.text.TextUtils;
import java.util.Locale;
import java.util.Objects;

public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean bl2) {
        if (bl2) {
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static void checkArgument(boolean bl2, Object object) {
        if (bl2) {
            return;
        }
        object = String.valueOf(object);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static int checkArgumentInRange(int n10, int n11, int n12, String string2) {
        Object object;
        int n13 = 2;
        int n14 = 1;
        int n15 = 3;
        if (n10 >= n11) {
            Object object2;
            if (n10 <= n12) {
                return n10;
            }
            Locale locale = Locale.US;
            Object[] objectArray = new Object[n15];
            objectArray[0] = string2;
            objectArray[n14] = object2 = Integer.valueOf(n11);
            objectArray[n13] = object2 = Integer.valueOf(n12);
            object2 = String.format(locale, "%s is out of range of [%d, %d] (too high)", objectArray);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object2);
            throw illegalArgumentException;
        }
        Locale locale = Locale.US;
        Object[] objectArray = new Object[n15];
        objectArray[0] = string2;
        objectArray[n14] = object = Integer.valueOf(n11);
        objectArray[n13] = object = Integer.valueOf(n12);
        object = String.format(locale, "%s is out of range of [%d, %d] (too low)", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public static int checkArgumentNonnegative(int n10) {
        if (n10 >= 0) {
            return n10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public static int checkArgumentNonnegative(int n10, String string2) {
        if (n10 >= 0) {
            return n10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static int checkFlagsArgument(int n10, int n11) {
        int n12 = n10 & n11;
        if (n12 == n10) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Requested flags 0x");
        String string2 = Integer.toHexString(n10);
        stringBuilder.append(string2);
        stringBuilder.append(", but only 0x");
        string2 = Integer.toHexString(n11);
        stringBuilder.append(string2);
        stringBuilder.append(" are allowed");
        string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public static Object checkNotNull(Object object) {
        Objects.requireNonNull(object);
        return object;
    }

    public static Object checkNotNull(Object object, Object object2) {
        if (object != null) {
            return object;
        }
        object2 = String.valueOf(object2);
        object = new NullPointerException((String)object2);
        throw object;
    }

    public static void checkState(boolean bl2) {
        Preconditions.checkState(bl2, null);
    }

    public static void checkState(boolean bl2, String string2) {
        if (bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public static CharSequence checkStringNotEmpty(CharSequence object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public static CharSequence checkStringNotEmpty(CharSequence object, Object object2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        object2 = String.valueOf(object2);
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static CharSequence checkStringNotEmpty(CharSequence object, String string2, Object ... objectArray) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            return object;
        }
        string2 = String.format(string2, objectArray);
        object = new IllegalArgumentException(string2);
        throw object;
    }
}

