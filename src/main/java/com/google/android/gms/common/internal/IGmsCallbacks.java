/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.zzc;

public interface IGmsCallbacks
extends IInterface {
    public void onPostInitComplete(int var1, IBinder var2, Bundle var3);

    public void zza(int var1, Bundle var2);

    public void zza(int var1, IBinder var2, zzc var3);
}

