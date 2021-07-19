/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbs;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzbt {
    private static volatile boolean zzgm = false;
    private static final Class zzgn;
    public static final zzbt zzgo;
    private final Map zzgp;

    static {
        zzbt zzbt2;
        zzgn = zzbt.zzam();
        zzgo = zzbt2 = new zzbt(true);
    }

    public zzbt() {
        HashMap hashMap;
        this.zzgp = hashMap = new HashMap();
    }

    private zzbt(boolean bl2) {
        Map map;
        this.zzgp = map = Collections.emptyMap();
    }

    private static Class zzam() {
        String string2 = "com.google.protobuf.Extension";
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    public static zzbt zzan() {
        return zzbs.zzal();
    }
}

