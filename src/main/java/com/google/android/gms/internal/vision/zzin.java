/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzim;
import com.google.android.gms.internal.vision.zzjn;
import java.io.IOException;

public class zzin
extends IOException {
    private zzjn zzyx = null;

    public zzin(String string2) {
        super(string2);
    }

    public static zzin zzhh() {
        zzin zzin2 = new zzin("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        return zzin2;
    }

    public static zzin zzhi() {
        zzin zzin2 = new zzin("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        return zzin2;
    }

    public static zzin zzhj() {
        zzin zzin2 = new zzin("CodedInputStream encountered a malformed varint.");
        return zzin2;
    }

    public static zzin zzhk() {
        zzin zzin2 = new zzin("Protocol message contained an invalid tag (zero).");
        return zzin2;
    }

    public static zzin zzhl() {
        zzin zzin2 = new zzin("Protocol message end-group tag did not match expected tag.");
        return zzin2;
    }

    public static zzim zzhm() {
        zzim zzim2 = new zzim("Protocol message tag had invalid wire type.");
        return zzim2;
    }

    public static zzin zzhn() {
        zzin zzin2 = new zzin("Failed to parse the message.");
        return zzin2;
    }

    public static zzin zzho() {
        zzin zzin2 = new zzin("Protocol message had invalid UTF-8.");
        return zzin2;
    }

    public final zzin zzg(zzjn zzjn2) {
        this.zzyx = zzjn2;
        return this;
    }
}

