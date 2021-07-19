/*
 * Decompiled with CFR 0.151.
 */
package androidx.versionedparcelable;

public @interface VersionedParcelize {
    public boolean allowSerialization();

    public int[] deprecatedIds();

    public Class factory();

    public boolean ignoreParcelables();

    public boolean isCustom();

    public String jetifyAs();
}

