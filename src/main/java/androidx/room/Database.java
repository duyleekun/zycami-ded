/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

public @interface Database {
    public Class[] autoMigrations();

    public Class[] entities();

    public boolean exportSchema();

    public int version();

    public Class[] views();
}

