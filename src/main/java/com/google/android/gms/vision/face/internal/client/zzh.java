/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IInterface
 */
package com.google.android.gms.vision.face.internal.client;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.face.internal.client.FaceParcel;

public interface zzh
extends IInterface {
    public FaceParcel[] zza(IObjectWrapper var1, IObjectWrapper var2, IObjectWrapper var3, int var4, int var5, int var6, int var7, int var8, int var9, zzu var10);

    public FaceParcel[] zzc(IObjectWrapper var1, zzu var2);

    public boolean zzd(int var1);

    public void zzo();
}

