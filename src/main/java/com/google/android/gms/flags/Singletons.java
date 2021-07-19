/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.flags;

import com.google.android.gms.flags.FlagRegistry;
import com.google.android.gms.flags.zzb;

public final class Singletons {
    private static Singletons zzl;
    private final FlagRegistry zzm;
    private final zzb zzn;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Singletons singletons = new Singletons();
        Class<Singletons> clazz = Singletons.class;
        synchronized (clazz) {
            zzl = singletons;
            return;
        }
    }

    private Singletons() {
        Object object = new FlagRegistry();
        this.zzm = object;
        this.zzn = object = new zzb();
    }

    public static FlagRegistry flagRegistry() {
        return Singletons.zzc().zzm;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Singletons zzc() {
        Class<Singletons> clazz = Singletons.class;
        synchronized (clazz) {
            return zzl;
        }
    }

    public static zzb zzd() {
        return Singletons.zzc().zzn;
    }
}

