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
import com.google.android.gms.internal.vision.zzad;
import com.google.android.gms.internal.vision.zzae;
import com.google.android.gms.internal.vision.zzaf;
import com.google.android.gms.internal.vision.zzah;
import com.google.android.gms.internal.vision.zzaj;
import com.google.android.gms.internal.vision.zzam;
import com.google.android.gms.internal.vision.zzs;
import com.google.android.gms.internal.vision.zzu;

public final class zzan
extends zzs {
    private final zzam zzem;

    public zzan(Context context, zzam zzam2) {
        super(context, "TextNativeHandle", "ocr");
        this.zzem = zzam2;
        this.zzr();
    }

    public final /* synthetic */ Object zza(DynamiteModule object, Context object2) {
        Object object3;
        boolean bl2;
        object3 = (object = ((DynamiteModule)object).instantiate("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator")) == null ? null : ((bl2 = (object3 = object.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator")) instanceof zzaf) ? (zzaf)object3 : new zzae((IBinder)object));
        if (object3 == null) {
            return null;
        }
        object = ObjectWrapper.wrap(object2);
        object2 = this.zzem;
        return object3.zza((IObjectWrapper)object, (zzam)object2);
    }

    public final zzah[] zza(Bitmap object, zzu zzu2, zzaj zzaj2) {
        boolean bl2 = this.isOperational();
        if (!bl2) {
            return new zzah[0];
        }
        try {
            object = ObjectWrapper.wrap(object);
        }
        catch (RemoteException remoteException) {
            Log.e((String)"TextNativeHandle", (String)"Error calling native text recognizer", (Throwable)remoteException);
            return new zzah[0];
        }
        Object object2 = this.zzr();
        object2 = (zzad)object2;
        return object2.zza((IObjectWrapper)object, zzu2, zzaj2);
    }

    public final void zzp() {
        ((zzad)this.zzr()).zzs();
    }
}

