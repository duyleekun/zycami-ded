/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.internal.vision.zzk;
import com.google.android.gms.internal.vision.zzl;
import com.google.android.gms.internal.vision.zzn;
import com.google.android.gms.internal.vision.zzp;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;
import com.google.android.gms.vision.barcode.Barcode;
import java.nio.ByteBuffer;

public final class zzm
extends zzs {
    private final zzk zzbs;

    public zzm(Context context, zzk zzk2) {
        super(context, "BarcodeNativeHandle", "barcode");
        this.zzbs = zzk2;
        this.zzr();
    }

    public final /* synthetic */ Object zza(DynamiteModule object, Context object2) {
        Object object3;
        boolean bl2;
        object3 = (object = ((DynamiteModule)object).instantiate("com.google.android.gms.vision.barcode.ChimeraNativeBarcodeDetectorCreator")) == null ? null : ((bl2 = (object3 = object.queryLocalInterface("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator")) instanceof zzn) ? (zzn)object3 : new zzp((IBinder)object));
        if (object3 == null) {
            return null;
        }
        object = ObjectWrapper.wrap(object2);
        object2 = this.zzbs;
        return object3.zza((IObjectWrapper)object, (zzk)object2);
    }

    public final Barcode[] zza(Bitmap object, zzu zzu2) {
        boolean bl2 = this.isOperational();
        if (!bl2) {
            return new Barcode[0];
        }
        try {
            object = ObjectWrapper.wrap(object);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"BarcodeNativeHandle", (String)"Error calling native barcode detector", (Throwable)remoteException);
            return new Barcode[0];
        }
        Object object2 = this.zzr();
        object2 = (zzl)object2;
        return object2.zzb((IObjectWrapper)object, zzu2);
    }

    public final Barcode[] zza(ByteBuffer object, zzu zzu2) {
        boolean bl2 = this.isOperational();
        if (!bl2) {
            return new Barcode[0];
        }
        try {
            object = ObjectWrapper.wrap(object);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"BarcodeNativeHandle", (String)"Error calling native barcode detector", (Throwable)remoteException);
            return new Barcode[0];
        }
        Object object2 = this.zzr();
        object2 = (zzl)object2;
        return object2.zza((IObjectWrapper)object, zzu2);
    }

    public final void zzp() {
        boolean bl2 = this.isOperational();
        if (bl2) {
            zzl zzl2 = (zzl)this.zzr();
            zzl2.zzo();
        }
    }
}

