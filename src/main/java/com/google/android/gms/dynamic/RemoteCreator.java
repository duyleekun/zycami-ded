/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.IBinder
 */
package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException;

public abstract class RemoteCreator {
    private final String zza;
    private Object zzb;

    public RemoteCreator(String string2) {
        this.zza = string2;
    }

    public abstract Object getRemoteCreator(IBinder var1);

    public final Object getRemoteCreatorInstance(Context object) {
        Object object2 = this.zzb;
        if (object2 == null) {
            Preconditions.checkNotNull(object);
            object = GooglePlayServicesUtilLight.getRemoteContext(object);
            if (object != null) {
                object = object.getClassLoader();
                object2 = this.zza;
                object = object.loadClass((String)object2);
                object = object.newInstance();
                object = (IBinder)object;
                object = this.getRemoteCreator((IBinder)object);
                try {
                    this.zzb = object;
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = new RemoteCreator$RemoteCreatorException("Could not access creator.", illegalAccessException);
                    throw object2;
                }
                catch (InstantiationException instantiationException) {
                    object2 = new RemoteCreator$RemoteCreatorException("Could not instantiate creator.", instantiationException);
                    throw object2;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    object2 = new RemoteCreator$RemoteCreatorException("Could not load creator class.", classNotFoundException);
                    throw object2;
                }
            } else {
                object = new RemoteCreator$RemoteCreatorException("Could not get remote context.");
                throw object;
            }
        }
        return this.zzb;
    }
}

