/*
 * Decompiled with CFR 0.151.
 */
package androidx.annotation;

public @interface RequiresPermission {
    public String[] allOf();

    public String[] anyOf();

    public boolean conditional();

    public String value();
}

