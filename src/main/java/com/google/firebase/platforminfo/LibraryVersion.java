/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import com.google.firebase.platforminfo.AutoValue_LibraryVersion;

public abstract class LibraryVersion {
    public static LibraryVersion create(String string2, String string3) {
        AutoValue_LibraryVersion autoValue_LibraryVersion = new AutoValue_LibraryVersion(string2, string3);
        return autoValue_LibraryVersion;
    }

    public abstract String getLibraryName();

    public abstract String getVersion();
}

