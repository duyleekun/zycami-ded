/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcp;
import com.google.android.gms.internal.clearcut.zzdo;
import java.io.IOException;

public class zzco
extends IOException {
    private zzdo zzkw = null;

    public zzco(String string2) {
        super(string2);
    }

    public static zzco zzbl() {
        zzco zzco2 = new zzco("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return zzco2;
    }

    public static zzco zzbm() {
        zzco zzco2 = new zzco("Protocol message contained an invalid tag (zero).");
        return zzco2;
    }

    public static zzcp zzbn() {
        zzcp zzcp2 = new zzcp("Protocol message tag had invalid wire type.");
        return zzcp2;
    }

    public static zzco zzbo() {
        zzco zzco2 = new zzco("Failed to parse the message.");
        return zzco2;
    }

    public static zzco zzbp() {
        zzco zzco2 = new zzco("Protocol message had invalid UTF-8.");
        return zzco2;
    }

    public final zzco zzg(zzdo zzdo2) {
        this.zzkw = zzdo2;
        return this;
    }
}

