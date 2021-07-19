/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package com.google.android.gms.internal.phenotype;

import android.database.ContentObserver;
import android.os.Handler;
import com.google.android.gms.internal.phenotype.zzf;

public final class zzg
extends ContentObserver {
    public zzg(Handler handler) {
        super(null);
    }

    public final void onChange(boolean bl2) {
        zzf.zzi().set(true);
    }
}

