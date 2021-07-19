/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzgy
extends IOException {
    public zzgy() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }

    public zzgy(String string2, Throwable throwable) {
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        String string3 = "CodedOutputStream was writing to a flat byte array and ran out of space.: ";
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        super(string2, throwable);
    }

    public zzgy(Throwable throwable) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", throwable);
    }
}

