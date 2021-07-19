/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

public @interface Update {
    public Class entity();

    public int onConflict();
}

