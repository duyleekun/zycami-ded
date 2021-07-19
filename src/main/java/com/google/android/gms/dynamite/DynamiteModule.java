/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.IBinder
 *  android.os.RemoteException
 *  android.util.Log
 *  dalvik.system.DelegateLastClassLoader
 */
package com.google.android.gms.dynamite;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zza;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$zzb;
import com.google.android.gms.dynamite.DynamiteModule$zza;
import com.google.android.gms.dynamite.DynamiteModule$zzb;
import com.google.android.gms.dynamite.zza;
import com.google.android.gms.dynamite.zzb;
import com.google.android.gms.dynamite.zzc;
import com.google.android.gms.dynamite.zzd;
import com.google.android.gms.dynamite.zze;
import com.google.android.gms.dynamite.zzf;
import com.google.android.gms.dynamite.zzg;
import com.google.android.gms.dynamite.zzh;
import com.google.android.gms.dynamite.zzi;
import com.google.android.gms.dynamite.zzj;
import com.google.android.gms.dynamite.zzk;
import com.google.android.gms.dynamite.zzl;
import com.google.android.gms.dynamite.zzm;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class DynamiteModule {
    public static final DynamiteModule$VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION;
    public static final DynamiteModule$VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
    public static final DynamiteModule$VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION;
    public static final DynamiteModule$VersionPolicy PREFER_LOCAL;
    public static final DynamiteModule$VersionPolicy PREFER_REMOTE;
    public static final DynamiteModule$VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING;
    private static Boolean zza;
    private static zzk zzb;
    private static zzm zzc;
    private static String zzd;
    private static int zze = 255;
    private static final ThreadLocal zzf;
    private static final DynamiteModule$VersionPolicy$zzb zzg;
    private static final DynamiteModule$VersionPolicy zzh;
    private final Context zzi;

    static {
        Object object = new ThreadLocal();
        zzf = object;
        zzg = object = new zzb();
        PREFER_REMOTE = object = new zza();
        PREFER_LOCAL = object = new zzd();
        PREFER_REMOTE_VERSION_NO_FORCE_STAGING = object = new zzc();
        PREFER_HIGHEST_OR_LOCAL_VERSION = object = new zzf();
        PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = object = new zze();
        PREFER_HIGHEST_OR_REMOTE_VERSION = object = new zzh();
        zzh = object = new zzg();
    }

    private DynamiteModule(Context context) {
        this.zzi = context = (Context)Preconditions.checkNotNull(context);
    }

    public static int getLocalVersion(Context object, String string2) {
        int n10;
        Object object2;
        String string3;
        block31: {
            string3 = "DynamiteModule";
            object = object.getApplicationContext();
            object = object.getClassLoader();
            object2 = String.valueOf(string2);
            n10 = ((String)object2).length() + 61;
            CharSequence charSequence = new StringBuilder(n10);
            object2 = "com.google.android.gms.dynamite.descriptors.";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(string2);
            object2 = ".ModuleDescriptor";
            ((StringBuilder)charSequence).append((String)object2);
            object2 = ((StringBuilder)charSequence).toString();
            object = ((ClassLoader)object).loadClass((String)object2);
            object2 = "MODULE_ID";
            object2 = ((Class)object).getDeclaredField((String)object2);
            charSequence = "MODULE_VERSION";
            object = ((Class)object).getDeclaredField((String)charSequence);
            int n11 = 0;
            charSequence = null;
            Object object3 = ((Field)object2).get(null);
            boolean bl2 = object3.equals(string2);
            if (bl2) break block31;
            object = ((Field)object2).get(null);
            object = String.valueOf(object);
            object2 = String.valueOf(object);
            n10 = ((String)object2).length() + 51;
            charSequence = String.valueOf(string2);
            n11 = ((String)charSequence).length();
            n10 += n11;
            charSequence = new StringBuilder(n10);
            object2 = "Module descriptor id '";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append((String)object);
            object = "' didn't match expected id '";
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(string2);
            object = "'";
            ((StringBuilder)charSequence).append((String)object);
            object = ((StringBuilder)charSequence).toString();
            Log.e((String)string3, (String)object);
            return 0;
        }
        try {
            return ((Field)object).getInt(null);
        }
        catch (Exception exception) {
            string2 = "Failed to load module descriptor class: ";
            String string4 = String.valueOf(exception.getMessage());
            n10 = string4.length();
            string4 = n10 != 0 ? string2.concat(string4) : new String(string2);
            Log.e((String)string3, (String)string4);
        }
        catch (ClassNotFoundException classNotFoundException) {
            int n12 = String.valueOf(string2).length() + 45;
            object2 = new StringBuilder(n12);
            ((StringBuilder)object2).append("Local module descriptor class for ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" not found.");
            object = ((StringBuilder)object2).toString();
            Log.w((String)string3, (String)object);
        }
        return 0;
    }

    public static int getRemoteVersion(Context context, String string2) {
        return DynamiteModule.zza(context, string2, false);
    }

    /*
     * Loose catch block
     */
    public static DynamiteModule load(Context object, DynamiteModule$VersionPolicy object2, String string2) {
        int n10;
        Object object3;
        DynamiteModule$zza dynamiteModule$zza;
        DynamiteModule$zza dynamiteModule$zza2;
        CharSequence charSequence;
        CharSequence charSequence2;
        block61: {
            int n11;
            int n12;
            int n13;
            Object object4;
            block62: {
                charSequence2 = ":";
                charSequence = "DynamiteModule";
                object4 = zzf;
                dynamiteModule$zza2 = (DynamiteModule$zza)((ThreadLocal)object4).get();
                dynamiteModule$zza = new DynamiteModule$zza(null);
                ((ThreadLocal)object4).set(dynamiteModule$zza);
                object3 = zzg;
                {
                    catch (Throwable throwable) {
                        throw throwable;
                    }
                }
                object3 = object2.zza((Context)object, string2, (DynamiteModule$VersionPolicy$zzb)object3);
                n13 = ((DynamiteModule$VersionPolicy$zza)object3).zza;
                n12 = ((DynamiteModule$VersionPolicy$zza)object3).zzb;
                String string3 = String.valueOf(string2);
                n11 = string3.length() + 68;
                CharSequence charSequence3 = String.valueOf(string2);
                int n14 = ((String)charSequence3).length();
                n11 += n14;
                charSequence3 = new StringBuilder(n11);
                string3 = "Considering local module ";
                ((StringBuilder)charSequence3).append(string3);
                ((StringBuilder)charSequence3).append(string2);
                ((StringBuilder)charSequence3).append((String)charSequence2);
                ((StringBuilder)charSequence3).append(n13);
                String string4 = " and remote module ";
                ((StringBuilder)charSequence3).append(string4);
                ((StringBuilder)charSequence3).append(string2);
                ((StringBuilder)charSequence3).append((String)charSequence2);
                ((StringBuilder)charSequence3).append(n12);
                charSequence2 = ((StringBuilder)charSequence3).toString();
                Log.i((String)charSequence, (String)charSequence2);
                n10 = ((DynamiteModule$VersionPolicy$zza)object3).zzc;
                if (n10 == 0) break block61;
                n13 = -1;
                if (n10 != n13) break block62;
                n12 = ((DynamiteModule$VersionPolicy$zza)object3).zza;
                if (n12 == 0) break block61;
            }
            if (n10 == (n12 = 1)) {
                n11 = ((DynamiteModule$VersionPolicy$zza)object3).zzb;
                if (n11 == 0) break block61;
            }
            if (n10 == n13) {
                block63: {
                    object = DynamiteModule.zza(object, string2);
                    object2 = dynamiteModule$zza.zza;
                    if (object2 == null) break block63;
                    object2.close();
                }
                ((ThreadLocal)object4).set(dynamiteModule$zza2);
                return object;
            }
            if (n10 == n12) {
                block64: {
                    n10 = ((DynamiteModule$VersionPolicy$zza)object3).zzb;
                    try {
                        object = DynamiteModule.zza(object, string2, n10);
                        object2 = dynamiteModule$zza.zza;
                        if (object2 == null) break block64;
                    }
                    catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                        block66: {
                            String string5;
                            block65: {
                                object4 = "Failed to load remote module: ";
                                string5 = dynamiteModule$LoadingException.getMessage();
                                string5 = String.valueOf(string5);
                                n11 = string5.length();
                                if (n11 == 0) break block65;
                                object4 = ((String)object4).concat(string5);
                            }
                            string5 = new String((String)object4);
                            object4 = string5;
                            Log.w((String)charSequence, (String)object4);
                            int n15 = ((DynamiteModule$VersionPolicy$zza)object3).zza;
                            if (n15 == 0) break block66;
                            object3 = null;
                            object4 = new DynamiteModule$zzb(n15, 0);
                            object2 = object2.zza((Context)object, string2, (DynamiteModule$VersionPolicy$zzb)object4);
                            int n16 = ((DynamiteModule$VersionPolicy$zza)object2).zzc;
                            if (n16 != n13) break block66;
                            object = DynamiteModule.zza(object, string2);
                            return object;
                        }
                        object2 = "Remote load failed. No local fallback found.";
                        object = new DynamiteModule$LoadingException((String)object2, dynamiteModule$LoadingException, null);
                        throw object;
                    }
                    object2.close();
                }
                ((ThreadLocal)object4).set(dynamiteModule$zza2);
                return object;
            }
            int n17 = ((DynamiteModule$VersionPolicy$zza)object3).zzc;
            int n18 = 47;
            charSequence2 = new StringBuilder(n18);
            string2 = "VersionPolicy returned invalid code:";
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append(n17);
            object2 = ((StringBuilder)charSequence2).toString();
            object = new DynamiteModule$LoadingException((String)object2, null);
            throw object;
        }
        int n19 = ((DynamiteModule$VersionPolicy$zza)object3).zza;
        int n20 = ((DynamiteModule$VersionPolicy$zza)object3).zzb;
        n10 = 91;
        charSequence = new StringBuilder(n10);
        charSequence2 = "No acceptable module found. Local version is ";
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(n19);
        object2 = " and remote version is ";
        ((StringBuilder)charSequence).append((String)object2);
        ((StringBuilder)charSequence).append(n20);
        object2 = ".";
        ((StringBuilder)charSequence).append((String)object2);
        object2 = ((StringBuilder)charSequence).toString();
        object = new DynamiteModule$LoadingException((String)object2, null);
        throw object;
        {
            finally {
                object2 = dynamiteModule$zza.zza;
                if (object2 != null) {
                    object2.close();
                }
                zzf.set(dynamiteModule$zza2);
            }
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public static int zza(Context context, String string2, boolean bl2) {
        Object object;
        Object object2;
        block30: {
            Object object3;
            block33: {
                block29: {
                    block32: {
                        Object object4;
                        block31: {
                            object2 = Boolean.TRUE;
                            object3 = Boolean.FALSE;
                            Class<DynamiteModule> clazz = DynamiteModule.class;
                            object = zza;
                            if (object != null) break block30;
                            object = context.getApplicationContext();
                            object = object.getClassLoader();
                            Class<?> clazz2 = DynamiteModule$DynamiteLoaderClassLoader.class;
                            clazz2 = clazz2.getName();
                            object = ((ClassLoader)object).loadClass((String)((Object)clazz2));
                            clazz2 = "sClassLoader";
                            object = ((Class)object).getDeclaredField((String)((Object)clazz2));
                            clazz2 = ((Field)object).getDeclaringClass();
                            // MONITORENTER : clazz2
                            Object var8_15 = null;
                            object4 = ((Field)object).get(null);
                            object4 = (ClassLoader)object4;
                            if (object4 == null) break block31;
                            object = ClassLoader.getSystemClassLoader();
                            if (object4 == object) break block32;
                            try {
                                DynamiteModule.zza((ClassLoader)object4);
                                break block29;
                            }
                            catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {}
                        }
                        object4 = "com.google.android.gms";
                        Object object5 = context.getApplicationContext();
                        int n10 = ((String)object4).equals(object5 = object5.getPackageName());
                        if (n10 != 0) {
                            object2 = ClassLoader.getSystemClassLoader();
                            ((Field)object).set(null, object2);
                        } else {
                            try {
                                n10 = DynamiteModule.zzc(context, string2, bl2);
                                object5 = zzd;
                                if (object5 == null) return n10;
                                int n11 = object5.isEmpty();
                                if (n11 != 0) {
                                    return n10;
                                }
                                n11 = Build.VERSION.SDK_INT;
                                int n12 = 29;
                                if (n11 >= n12) {
                                    String string3 = zzd;
                                    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                                    object5 = new DelegateLastClassLoader(string3, classLoader);
                                } else {
                                    String string4 = zzd;
                                    ClassLoader classLoader = ClassLoader.getSystemClassLoader();
                                    object5 = new zzi(string4, classLoader);
                                }
                                DynamiteModule.zza((ClassLoader)object5);
                                ((Field)object).set(null, object5);
                                zza = object2;
                                // MONITOREXIT : clazz2
                                // MONITOREXIT : clazz
                                return n10;
                            }
                            catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                                object2 = ClassLoader.getSystemClassLoader();
                                ((Field)object).set(null, object2);
                            }
                        }
                    }
                    object2 = object3;
                }
                // MONITOREXIT : clazz2
                object3 = object2;
                break block33;
                catch (NoSuchFieldException noSuchFieldException) {
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (ClassNotFoundException classNotFoundException) {
                    // empty catch block
                }
                object = "DynamiteModule";
                object2 = String.valueOf(object2);
                String string5 = String.valueOf(object2);
                int n13 = string5.length() + 30;
                StringBuilder stringBuilder = new StringBuilder(n13);
                string5 = "Failed to load module via V2: ";
                stringBuilder.append(string5);
                stringBuilder.append((String)object2);
                object2 = stringBuilder.toString();
                Log.w((String)object, (String)object2);
            }
            zza = object3;
            object = object3;
        }
        // MONITOREXIT : clazz
        try {
            boolean bl3 = (Boolean)object;
            if (!bl3) return DynamiteModule.zzb(context, string2, bl2);
            try {
                return DynamiteModule.zzc(context, string2, bl2);
            }
            catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
                String string6 = "DynamiteModule";
                object2 = "Failed to retrieve remote module version: ";
                String string7 = dynamiteModule$LoadingException.getMessage();
                string7 = String.valueOf(string7);
                int n14 = string7.length();
                string7 = n14 != 0 ? ((String)object2).concat(string7) : new String((String)object2);
                Log.w((String)string6, (String)string7);
                return 0;
            }
        }
        catch (Throwable throwable) {
            CrashUtils.addDynamiteErrorToDropBox(context, throwable);
            throw throwable;
        }
    }

    private static DynamiteModule zza(Context context, String object) {
        object = String.valueOf(object);
        int n10 = ((String)object).length();
        String string2 = "Selected local version of ";
        object = n10 != 0 ? string2.concat((String)object) : new String(string2);
        Log.i((String)"DynamiteModule", (String)object);
        context = context.getApplicationContext();
        object = new DynamiteModule(context);
        return object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static DynamiteModule zza(Context var0, String var1_2, int var2_4) {
        var3_5 = DynamiteModule.class;
        try {
            synchronized (var3_5) {
                var4_6 = DynamiteModule.zza;
            }
        }
        catch (Throwable var1_3) {
            CrashUtils.addDynamiteErrorToDropBox(var0 /* !! */ , var1_3);
            var0 /* !! */  = new DynamiteModule$LoadingException("Failed to load remote module.", var1_3, null);
            throw var0 /* !! */ ;
        }
        catch (DynamiteModule$LoadingException v0) {
            throw v0;
        }
        catch (RemoteException var0_1) {
            var1_2 = new DynamiteModule$LoadingException("Failed to load remote module.", var0_1, null);
            throw var1_2;
        }
        {
            if (var4_6 == null) ** GOTO lbl61
        }
        {
            var5_7 = var4_6.booleanValue();
            if (var5_7) {
                return DynamiteModule.zzb(var0 /* !! */ , (String)var1_2, var2_4);
            }
            var3_5 = "DynamiteModule";
            var4_6 = String.valueOf(var1_2);
            var6_8 = var4_6.length() + 51;
            var7_9 /* !! */  = new StringBuilder(var6_8);
            var4_6 = "Selected remote version of ";
            var7_9 /* !! */ .append((String)var4_6);
            var7_9 /* !! */ .append((String)var1_2);
            var4_6 = ", version >= ";
            var7_9 /* !! */ .append((String)var4_6);
            var7_9 /* !! */ .append(var2_4);
            var4_6 = var7_9 /* !! */ .toString();
            Log.i((String)var3_5, (String)var4_6);
            var3_5 = DynamiteModule.zza(var0 /* !! */ );
            if (var3_5 == null) {
                var9_12 = "Failed to create IDynamiteLoader.";
                var1_2 = new DynamiteModule$LoadingException(var9_12, null);
                throw var1_2;
            }
            var6_8 = var3_5.zzb();
            if (var6_8 >= (var8_10 = 2)) {
                var4_6 = ObjectWrapper.wrap(var0 /* !! */ );
                var1_2 = var3_5.zzb((IObjectWrapper)var4_6, (String)var1_2, var2_4);
            } else {
                var4_6 = "DynamiteModule";
                var7_9 /* !! */  = "Dynamite loader version < 2, falling back to createModuleContext";
                Log.w((String)var4_6, (String)var7_9 /* !! */ );
                var4_6 = ObjectWrapper.wrap(var0 /* !! */ );
                var1_2 = var3_5.zza((IObjectWrapper)var4_6, (String)var1_2, var2_4);
            }
            var9_11 = ObjectWrapper.unwrap((IObjectWrapper)var1_2);
            if (var9_11 != null) {
                var1_2 = ObjectWrapper.unwrap((IObjectWrapper)var1_2);
                var1_2 = (Context)var1_2;
                return new DynamiteModule((Context)var1_2);
            }
            var9_11 = "Failed to load remote module.";
            var1_2 = new DynamiteModule$LoadingException((String)var9_11, null);
            throw var1_2;
lbl61:
            // 1 sources

            var9_13 = "Failed to determine which loading route to use.";
            var1_2 = new DynamiteModule$LoadingException(var9_13, null);
            throw var1_2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static zzk zza(Context object) {
        Class<DynamiteModule> clazz = DynamiteModule.class;
        synchronized (clazz) {
            block8: {
                zzk zzk2 = zzb;
                if (zzk2 != null) {
                    return zzk2;
                }
                zzk2 = null;
                Object object2 = "com.google.android.gms";
                int n10 = 3;
                try {
                    object = object.createPackageContext((String)object2, n10);
                    object = object.getClassLoader();
                    object2 = "com.google.android.gms.chimera.container.DynamiteLoaderImpl";
                    object = object.loadClass((String)object2);
                    object = object.newInstance();
                    object = (IBinder)object;
                    if (object == null) {
                        return null;
                    }
                    object2 = "com.google.android.gms.dynamite.IDynamiteLoader";
                }
                catch (Exception exception) {
                    object2 = "DynamiteModule";
                    String string2 = "Failed to load IDynamiteLoader from GmsCore: ";
                    String string3 = exception.getMessage();
                    string3 = String.valueOf(string3);
                    int n11 = string3.length();
                    string3 = n11 != 0 ? string2.concat(string3) : new String(string2);
                    Log.e((String)object2, (String)string3);
                    break block8;
                }
                n10 = (object2 = object.queryLocalInterface((String)object2)) instanceof zzk;
                object2 = n10 != 0 ? (zzk)object2 : new zzj((IBinder)object);
                {
                    if (object2 == null) return null;
                    zzb = object2;
                    return object2;
                }
            }
            return null;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Boolean zza() {
        Class<DynamiteModule> clazz = DynamiteModule.class;
        synchronized (clazz) {
            boolean bl2 = zze;
            boolean bl3 = 2 != 0;
            if (bl2 >= bl3) {
                bl2 = true;
                return bl2;
            } else {
                bl2 = false;
                Boolean bl4 = null;
            }
            return bl2;
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(ClassLoader var0) {
        block17: {
            block16: {
                var1_7 = "com.google.android.gms.dynamiteloader.DynamiteLoaderV2";
                var0 /* !! */  = var0 /* !! */ .loadClass((String)var1_7);
                var1_7 = null;
                var2_8 = new Class[]{};
                var0 /* !! */  = var0 /* !! */ .getConstructor(var2_8);
                var1_7 = new Object[]{};
                var0 /* !! */  = var0 /* !! */ .newInstance(var1_7);
                var0 /* !! */  = var0 /* !! */ ;
                if (var0 /* !! */  != null) break block16;
                var1_7 = null;
                ** GOTO lbl30
            }
            var1_7 = "com.google.android.gms.dynamite.IDynamiteLoaderV2";
            var1_7 = var0 /* !! */ .queryLocalInterface((String)var1_7);
            var3_9 = var1_7 instanceof zzm;
            if (!var3_9) break block17;
            var1_7 = (zzm)var1_7;
            ** GOTO lbl30
        }
        try {
            var1_7 = new zzl(var0 /* !! */ );
lbl30:
            // 3 sources

            DynamiteModule.zzc = var1_7;
            return;
        }
        catch (NoSuchMethodException var0_1) {
        }
        catch (InvocationTargetException var0_2) {
        }
        catch (InstantiationException var0_3) {
        }
        catch (IllegalAccessException var0_4) {
        }
        catch (ClassNotFoundException var0_5) {
            // empty catch block
        }
        var1_7 = new DynamiteModule$LoadingException("Failed to instantiate dynamite loader", (Throwable)var0_6, null);
        throw var1_7;
    }

    private static int zzb(Context object, String string2, boolean bl2) {
        zzk zzk2;
        String string3;
        block7: {
            string3 = "DynamiteModule";
            zzk2 = DynamiteModule.zza((Context)object);
            if (zzk2 == null) {
                return 0;
            }
            try {
                int n10 = zzk2.zzb();
                int n11 = 2;
                if (n10 < n11) break block7;
            }
            catch (RemoteException remoteException) {
                string2 = "Failed to retrieve remote module version: ";
                String string4 = String.valueOf(remoteException.getMessage());
                int n12 = string4.length();
                string4 = n12 != 0 ? string2.concat(string4) : new String(string2);
                Log.w((String)string3, (String)string4);
                return 0;
            }
            object = ObjectWrapper.wrap(object);
            return zzk2.zzb((IObjectWrapper)object, string2, bl2);
        }
        String string4 = "IDynamite loader version < 2, falling back to getModuleVersion2";
        Log.w((String)string3, (String)string4);
        object = ObjectWrapper.wrap(object);
        return zzk2.zza((IObjectWrapper)object, string2, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static DynamiteModule zzb(Context object, String object2, int n10) {
        Object object3;
        int n11 = String.valueOf(object2).length() + 51;
        Object object4 = new StringBuilder(n11);
        ((StringBuilder)object4).append("Selected remote version of ");
        ((StringBuilder)object4).append((String)object2);
        ((StringBuilder)object4).append(", version >= ");
        ((StringBuilder)object4).append(n10);
        Object object5 = ((StringBuilder)object4).toString();
        Log.i((String)"DynamiteModule", (String)object5);
        Class<DynamiteModule> clazz = DynamiteModule.class;
        synchronized (clazz) {
            object5 = zzc;
        }
        clazz = null;
        if (object5 == null) {
            object = new DynamiteModule$LoadingException("DynamiteLoaderV2 was not cached.", null);
            throw object;
        }
        object4 = (DynamiteModule$zza)zzf.get();
        if (object4 != null && (object3 = ((DynamiteModule$zza)object4).zza) != null) {
            object = object.getApplicationContext();
            object4 = ((DynamiteModule$zza)object4).zza;
            ObjectWrapper.wrap(null);
            object3 = DynamiteModule.zza();
            boolean bl2 = (Boolean)object3;
            if (bl2) {
                object3 = "DynamiteModule";
                String string2 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils";
                Log.v((String)object3, (String)string2);
                object = ObjectWrapper.wrap(object);
                object4 = ObjectWrapper.wrap(object4);
                object = object5.zzb((IObjectWrapper)object, (String)object2, n10, (IObjectWrapper)object4);
            } else {
                object3 = "DynamiteModule";
                String string3 = "Dynamite loader version < 2, falling back to loadModule2";
                Log.w((String)object3, (String)string3);
                object = ObjectWrapper.wrap(object);
                object4 = ObjectWrapper.wrap(object4);
                object = object5.zza((IObjectWrapper)object, (String)object2, n10, (IObjectWrapper)object4);
            }
            object = (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
            if (object != null) {
                return new DynamiteModule((Context)object);
            }
            object = new DynamiteModule$LoadingException("Failed to get module context", null);
            throw object;
        }
        object = new DynamiteModule$LoadingException("No result cursor", null);
        throw object;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static int zzc(Context var0, String var1_4, boolean var2_6) {
        block18: {
            block19: {
                block17: {
                    block21: {
                        block20: {
                            var3_7 = null;
                            try {
                                var4_8 /* !! */  = var0.getContentResolver();
                                var0 = var2_6 != false ? "api_force_staging" : "api";
                                var2_6 = var0.length() + 42;
                                var5_9 = String.valueOf(var1_4);
                                var6_10 = var5_9.length();
                                var5_9 = new StringBuilder((int)(var2_6 += var6_10));
                                var7_11 = "content://com.google.android.gms.chimera/";
                                var5_9.append((String)var7_11);
                                var5_9.append((String)var0);
                                var0 = "/";
                                var5_9.append((String)var0);
                                var5_9.append((String)var1_4);
                                var0 = var5_9.toString();
                                var5_9 = Uri.parse((String)var0);
                                var0 = var4_8 /* !! */ .query((Uri)var5_9, null, null, null, null);
                                if (var0 == null) break block17;
                            }
                            catch (Throwable var0_1) {
                                break block18;
                            }
                            catch (Exception var0_2) {
                                var8_13 = false;
                                var1_4 = null;
                                break block19;
                            }
                            try {
                                var8_12 = var0.moveToFirst();
                                if (var8_12 == 0) break block17;
                                var8_12 = 0;
                                var1_4 = null;
                                var8_12 = var0.getInt(0);
                                if (var8_12 <= 0) break block20;
                                var7_11 = DynamiteModule.class;
                                synchronized (var7_11) {
                                    var9_14 = 2;
                                }
                            }
                            catch (Throwable var1_5) {
                                var3_7 = var0;
                                var0 = var1_5;
                                break block18;
                            }
                            catch (Exception var10_15) {
                                var1_4 = var0;
                                var0 = var10_15;
                                break block19;
                            }
                            {
                                var4_8 /* !! */  = var0.getString(var9_14);
                                DynamiteModule.zzd = var4_8 /* !! */ ;
                                var4_8 /* !! */  = "loaderVersion";
                                var9_14 = var0.getColumnIndex((String)var4_8 /* !! */ );
                                if (var9_14 >= 0) {
                                    DynamiteModule.zze = var9_14 = var0.getInt(var9_14);
                                }
                            }
                            {
                                var7_11 = DynamiteModule.zzf;
                                var7_11 = var7_11.get();
                                var7_11 = (DynamiteModule$zza)var7_11;
                                if (var7_11 == null || (var4_8 /* !! */  = var7_11.zza) != null) break block20;
                                var7_11.zza = var0;
                                break block21;
                            }
                        }
                        var3_7 = var0;
                    }
                    if (var3_7 != null) {
                        var3_7.close();
                    }
                    return var8_12;
                }
                var1_4 = "DynamiteModule";
                var7_11 = "Failed to retrieve remote module version.";
                {
                    Log.w((String)var1_4, (String)var7_11);
                    var7_11 = "Failed to connect to dynamite module ContentResolver.";
                    var1_4 = new DynamiteModule$LoadingException((String)var7_11, null);
                    throw var1_4;
                }
            }
            var2_6 = var0 instanceof DynamiteModule$LoadingException;
            if (!var2_6) ** GOTO lbl80
            try {
                throw (Throwable)var0;
lbl80:
                // 1 sources

                var4_8 /* !! */  = "V2 version check failed";
                var7_11 = new DynamiteModule$LoadingException((String)var4_8 /* !! */ , (Throwable)var0, null);
                throw var7_11;
            }
            catch (Throwable var0_3) {
                var3_7 = var1_4;
            }
        }
        if (var3_7 != null) {
            var3_7.close();
        }
        throw var0;
    }

    public final Context getModuleContext() {
        return this.zzi;
    }

    /*
     * WARNING - void declaration
     */
    public final IBinder instantiate(String string2) {
        void var2_6;
        Object object = this.zzi;
        object = object.getClassLoader();
        object = object.loadClass(string2);
        object = object.newInstance();
        try {
            return (IBinder)object;
        }
        catch (IllegalAccessException illegalAccessException) {
        }
        catch (InstantiationException instantiationException) {
        }
        catch (ClassNotFoundException classNotFoundException) {
            // empty catch block
        }
        String string3 = "Failed to instantiate module class: ";
        string2 = String.valueOf(string2);
        int n10 = string2.length();
        string2 = n10 != 0 ? string3.concat(string2) : new String(string3);
        DynamiteModule$LoadingException dynamiteModule$LoadingException = new DynamiteModule$LoadingException(string2, (Throwable)var2_6, null);
        throw dynamiteModule$LoadingException;
    }
}

