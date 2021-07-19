/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;

public final class CollectPreconditions {
    public static void checkEntryNotNull(Object object, Object object2) {
        if (object != null) {
            if (object2 != null) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("null value in entry: ");
            stringBuilder.append(object);
            stringBuilder.append("=null");
            object = stringBuilder.toString();
            object2 = new NullPointerException((String)object);
            throw object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("null key in entry: null=");
        stringBuilder.append(object2);
        object2 = stringBuilder.toString();
        object = new NullPointerException((String)object2);
        throw object;
    }

    public static int checkNonnegative(int n10, String string2) {
        if (n10 >= 0) {
            return n10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static long checkNonnegative(long l10, String string2) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            return l10;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" cannot be negative but was: ");
        stringBuilder.append(l10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static void checkPositive(int n10, String string2) {
        if (n10 > 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(" must be positive but was: ");
        stringBuilder.append(n10);
        String string3 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public static void checkRemove(boolean bl2) {
        Preconditions.checkState(bl2, "no calls to next() since the last call to remove()");
    }
}

