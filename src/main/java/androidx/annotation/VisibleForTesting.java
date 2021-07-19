/*
 * Decompiled with CFR 0.151.
 */
package androidx.annotation;

public @interface VisibleForTesting {
    public static final int NONE = 5;
    public static final int PACKAGE_PRIVATE = 3;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;

    public int otherwise();
}

