/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import com.google.firebase.platforminfo.LibraryVersion;
import java.util.Objects;

public final class AutoValue_LibraryVersion
extends LibraryVersion {
    private final String libraryName;
    private final String version;

    public AutoValue_LibraryVersion(String string2, String string3) {
        Objects.requireNonNull(string2, "Null libraryName");
        this.libraryName = string2;
        Objects.requireNonNull(string3, "Null version");
        this.version = string3;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof LibraryVersion;
        if (bl3) {
            boolean bl4;
            String string2 = this.libraryName;
            String string3 = ((LibraryVersion)(object = (LibraryVersion)object)).getLibraryName();
            bl3 = string2.equals(string3);
            if (!bl3 || !(bl4 = (string2 = this.version).equals(object = ((LibraryVersion)object).getVersion()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public String getLibraryName() {
        return this.libraryName;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int n10 = this.libraryName.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.version.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LibraryVersion{libraryName=");
        String string2 = this.libraryName;
        stringBuilder.append(string2);
        stringBuilder.append(", version=");
        string2 = this.version;
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

