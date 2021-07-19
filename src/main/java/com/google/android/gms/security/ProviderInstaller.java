/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources$NotFoundException
 *  android.util.Log
 */
package com.google.android.gms.security;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule$LoadingException;
import com.google.android.gms.dynamite.DynamiteModule$VersionPolicy;
import com.google.android.gms.security.ProviderInstaller$ProviderInstallListener;
import com.google.android.gms.security.zza;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;

public class ProviderInstaller {
    public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
    private static final GoogleApiAvailabilityLight zza;
    private static final Object zzb;
    private static Method zzc;

    static {
        Object object;
        zza = GoogleApiAvailabilityLight.getInstance();
        zzb = object = new Object();
        zzc = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void installIfNeeded(Context context) {
        Preconditions.checkNotNull(context, "Context must not be null");
        Object object = zza;
        int n10 = 11925000;
        ((GoogleApiAvailabilityLight)object).verifyGooglePlayServicesIsAvailable(context, n10);
        object = ProviderInstaller.zza(context);
        if (object == null) {
            object = ProviderInstaller.zzb(context);
        }
        int n11 = 8;
        if (object == null) {
            Log.e((String)"ProviderInstaller", (String)"Failed to get remote context");
            object = new GooglePlayServicesNotAvailableException(n11);
            throw object;
        }
        Object object2 = zzb;
        synchronized (object2) {
            try {
                try {
                    Class[] classArray;
                    GenericDeclaration genericDeclaration = zzc;
                    boolean bl2 = false;
                    Object var7_12 = null;
                    int n12 = 1;
                    if (genericDeclaration == null) {
                        genericDeclaration = object.getClassLoader();
                        classArray = "com.google.android.gms.common.security.ProviderInstallerImpl";
                        genericDeclaration = ((ClassLoader)((Object)genericDeclaration)).loadClass((String)classArray);
                        classArray = new Class[n12];
                        Object object3 = Context.class;
                        classArray[0] = object3;
                        object3 = "insertProvider";
                        genericDeclaration = genericDeclaration.getMethod((String)object3, classArray);
                        zzc = genericDeclaration;
                    }
                    genericDeclaration = zzc;
                    classArray = null;
                    Object[] objectArray = new Object[n12];
                    objectArray[0] = object;
                    ((Method)genericDeclaration).invoke(null, objectArray);
                    return;
                }
                catch (Exception exception) {
                    Object object4;
                    Object object5 = exception.getCause();
                    String string2 = "ProviderInstaller";
                    int n13 = 6;
                    boolean bl3 = Log.isLoggable((String)string2, (int)n13);
                    if (bl3) {
                        object4 = object5 == null ? exception.getMessage() : ((Throwable)object5).getMessage();
                        object5 = "ProviderInstaller";
                        string2 = "Failed to install provider: ";
                        object4 = String.valueOf(object4);
                        n13 = ((String)object4).length();
                        object4 = n13 != 0 ? string2.concat((String)object4) : new String(string2);
                        Log.e((String)object5, (String)object4);
                    }
                    object4 = new GooglePlayServicesNotAvailableException(n11);
                    throw object4;
                }
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    public static void installIfNeededAsync(Context objectArray, ProviderInstaller$ProviderInstallListener providerInstaller$ProviderInstallListener) {
        Preconditions.checkNotNull(objectArray, "Context must not be null");
        Preconditions.checkNotNull(providerInstaller$ProviderInstallListener, "Listener must not be null");
        Preconditions.checkMainThread("Must be called on the UI thread");
        zza zza2 = new zza((Context)objectArray, providerInstaller$ProviderInstallListener);
        objectArray = new Void[]{};
        zza2.execute(objectArray);
    }

    private static Context zza(Context object) {
        String string2;
        Object object2;
        try {
            object2 = DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING;
            string2 = "providerinstaller";
        }
        catch (DynamiteModule$LoadingException dynamiteModule$LoadingException) {
            object2 = "Failed to load providerinstaller module: ";
            String string3 = String.valueOf(dynamiteModule$LoadingException.getMessage());
            int n10 = string3.length();
            string3 = n10 != 0 ? ((String)object2).concat(string3) : new String((String)object2);
            Log.w((String)"ProviderInstaller", (String)string3);
            return null;
        }
        object = DynamiteModule.load((Context)object, (DynamiteModule$VersionPolicy)object2, string2);
        return ((DynamiteModule)object).getModuleContext();
    }

    public static /* synthetic */ GoogleApiAvailabilityLight zza() {
        return zza;
    }

    private static Context zzb(Context context) {
        try {
            return GooglePlayServicesUtilLight.getRemoteContext(context);
        }
        catch (Resources.NotFoundException notFoundException) {
            String string2 = "Failed to load GMS Core context for providerinstaller: ";
            String string3 = String.valueOf(notFoundException.getMessage());
            int n10 = string3.length();
            string2 = n10 != 0 ? string2.concat(string3) : (string3 = new String(string2));
            Log.w((String)"ProviderInstaller", (String)string2);
            CrashUtils.addDynamiteErrorToDropBox(context, notFoundException);
            return null;
        }
    }
}

