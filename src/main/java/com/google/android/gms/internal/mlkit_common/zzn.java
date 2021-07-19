/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.internal.mlkit_common;

import android.util.Log;
import com.google.android.gms.internal.mlkit_common.zzj;
import com.google.android.gms.internal.mlkit_common.zzm;
import com.google.android.gms.internal.mlkit_common.zzp;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public final class zzn {
    private static final Method zza;
    private static final Method zzb;
    private static final Method zzc;
    private static final Field zzd;
    private static final Field zze;
    private static final Field zzf;
    private static final Object zzg;
    private static final Throwable zzh;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        String string2;
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        block21: {
            block19: {
                block18: {
                    block20: {
                        boolean bl2;
                        object8 = "libcore.io.Libcore";
                        try {
                            object8 = Class.forName((String)object8);
                            object7 = "libcore.io.StructStat";
                            object7 = Class.forName((String)object7);
                            object6 = "libcore.io.OsConstants";
                            object6 = Class.forName((String)object6);
                            object5 = "libcore.io.ForwardingOs";
                            object5 = Class.forName((String)object5);
                            object4 = "S_ISLNK";
                            bl2 = true;
                            object3 = new Class[bl2];
                            object2 = Integer.TYPE;
                            string2 = null;
                            object3[0] = object2;
                            object6 = ((Class)object6).getDeclaredMethod((String)object4, (Class<?>)object3);
                        }
                        catch (Throwable throwable) {
                            object8 = null;
                            object7 = null;
                            object6 = null;
                            object5 = null;
                            break block18;
                        }
                        try {
                            ((Method)object6).setAccessible(bl2);
                            object4 = "lstat";
                            object3 = new Class[bl2];
                            object2 = String.class;
                            object3[0] = object2;
                            object4 = ((Class)object5).getDeclaredMethod((String)object4, (Class<?>)object3);
                            object3 = "fstat";
                        }
                        catch (Throwable throwable) {
                            object8 = null;
                            object7 = null;
                            object5 = null;
                            break block18;
                        }
                        try {
                            object2 = new Class[bl2];
                            object2[0] = object = FileDescriptor.class;
                            object5 = ((Class)object5).getDeclaredMethod((String)object3, (Class<?>)object2);
                            object3 = "os";
                        }
                        catch (Throwable throwable) {
                            object8 = null;
                            object7 = null;
                            object5 = null;
                            object3 = null;
                            break block19;
                        }
                        try {
                            object3 = ((Class)object8).getDeclaredField((String)object3);
                            ((Field)object3).setAccessible(bl2);
                            object8 = ((Field)object3).get(object8);
                            object3 = "st_dev";
                        }
                        catch (Throwable throwable) {
                            object8 = null;
                            object7 = null;
                            break block20;
                        }
                        try {
                            object3 = ((Class)object7).getField((String)object3);
                            object2 = "st_ino";
                        }
                        catch (Throwable throwable) {
                            object7 = null;
                            break block20;
                        }
                        try {
                            object2 = ((Class)object7).getField((String)object2);
                            string2 = "st_mode";
                        }
                        catch (Throwable throwable) {
                            object7 = null;
                            object2 = null;
                            break block21;
                        }
                        try {
                            object7 = ((Class)object7).getField(string2);
                        }
                        catch (Throwable throwable) {
                            object7 = null;
                            break block21;
                        }
                        try {
                            ((Field)object3).setAccessible(bl2);
                            ((Field)object2).setAccessible(bl2);
                            ((Field)object7).setAccessible(bl2);
                            zza = object6;
                            zzb = object4;
                            zzc = object5;
                            zzd = object3;
                            zze = object2;
                            zzf = object7;
                            zzg = object8;
                            zzh = null;
                            return;
                        }
                        catch (Throwable throwable) {}
                        break block21;
                    }
                    object3 = null;
                    break block19;
                }
                object4 = null;
                object3 = null;
            }
            object2 = null;
        }
        string2 = "StructStatHelper";
        object = "Reflection failed";
        try {
            void var10_15;
            Log.d((String)string2, (String)object, (Throwable)var10_15);
            zza = object6;
            zzb = object4;
            zzc = object5;
            zzd = object3;
            zze = object2;
            zzf = object7;
            zzg = object8;
            zzh = var10_15;
            return;
        }
        catch (Throwable throwable) {
            zza = object6;
            zzb = object4;
            zzc = object5;
            zzd = object3;
            zze = object2;
            zzf = object7;
            zzg = object8;
            zzh = null;
            throw throwable;
        }
    }

    public static zzj zza(FileDescriptor fileDescriptor) {
        zzp zzp2 = new zzp(fileDescriptor);
        return (zzj)zzn.zza(zzp2);
    }

    private static zzj zza(Object object) {
        long l10 = (Long)zzd.get(object);
        long l11 = (Long)zze.get(object);
        int n10 = (Integer)zzf.get(object);
        Method method = zza;
        object = n10;
        Object object2 = new Object[]{object};
        boolean bl2 = (Boolean)method.invoke(null, object2);
        object2 = object;
        object = new zzj(l10, l11, bl2, null);
        return object;
    }

    public static zzj zza(String string2) {
        zzm zzm2 = new zzm(string2);
        return (zzj)zzn.zza(zzm2);
    }

    private static Object zza(Callable object) {
        Throwable throwable;
        block4: {
            try {
                throwable = zzh;
                if (throwable != null) break block4;
            }
            catch (Throwable throwable2) {
                throwable = new IOException(throwable2);
                throw throwable;
            }
            return object.call();
        }
        object = new IOException(throwable);
        throw object;
    }

    public static final /* synthetic */ zzj zzb(FileDescriptor fileDescriptor) {
        Method method = zzc;
        Object object = zzg;
        Object[] objectArray = new Object[]{fileDescriptor};
        return zzn.zza(method.invoke(object, objectArray));
    }

    public static final /* synthetic */ zzj zzb(String string2) {
        Method method = zzb;
        Object object = zzg;
        Object[] objectArray = new Object[]{string2};
        return zzn.zza(method.invoke(object, objectArray));
    }
}

