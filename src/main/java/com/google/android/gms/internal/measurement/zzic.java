/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;
import java.io.IOException;

public class zzic
extends IOException {
    public zzic(String string2) {
        super(string2);
    }

    public static zzic zza() {
        zzic zzic2 = new zzic("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return zzic2;
    }

    public static zzic zzb() {
        zzic zzic2 = new zzic("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return zzic2;
    }

    public static zzic zzc() {
        zzic zzic2 = new zzic("Protocol message contained an invalid tag (zero).");
        return zzic2;
    }

    public static zzib zzd() {
        zzib zzib2 = new zzib("Protocol message tag had invalid wire type.");
        return zzib2;
    }

    public static zzic zze() {
        zzic zzic2 = new zzic("Failed to parse the message.");
        return zzic2;
    }

    public static zzic zzf() {
        zzic zzic2 = new zzic("Protocol message had invalid UTF-8.");
        return zzic2;
    }
}

