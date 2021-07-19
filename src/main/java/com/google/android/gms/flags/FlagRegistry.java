/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.flags;

import android.content.Context;
import com.google.android.gms.flags.Flag;
import com.google.android.gms.flags.Singletons;
import java.util.ArrayList;
import java.util.Collection;

public class FlagRegistry {
    private final Collection zzg;
    private final Collection zzh;
    private final Collection zzi;

    public FlagRegistry() {
        ArrayList arrayList;
        this.zzg = arrayList = new ArrayList();
        this.zzh = arrayList = new ArrayList();
        this.zzi = arrayList = new ArrayList();
    }

    public static void initialize(Context context) {
        Singletons.zzd().initialize(context);
    }

    public final void zza(Flag flag) {
        this.zzg.add(flag);
    }
}

