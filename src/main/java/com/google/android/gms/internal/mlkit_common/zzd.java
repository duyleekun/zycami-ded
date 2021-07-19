/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ProviderInfo
 *  android.content.res.AssetFileDescriptor
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Environment
 *  android.os.ParcelFileDescriptor
 *  android.os.ParcelFileDescriptor$AutoCloseInputStream
 *  android.os.Process
 */
package com.google.android.gms.internal.mlkit_common;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.mlkit_common.zzan;
import com.google.android.gms.internal.mlkit_common.zzc;
import com.google.android.gms.internal.mlkit_common.zze;
import com.google.android.gms.internal.mlkit_common.zzf;
import com.google.android.gms.internal.mlkit_common.zzh;
import com.google.android.gms.internal.mlkit_common.zzj;
import com.google.android.gms.internal.mlkit_common.zzr;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public final class zzd {
    private static final String[] zza;
    private static final String[] zzb;

    static {
        String string2 = "com.nest.";
        String string3 = "com.waze";
        zza = new String[]{"com.android.", "com.google.", "com.chrome.", string2, "com.waymo.", string3};
        int n10 = 4;
        String[] stringArray = new String[n10];
        String string4 = "media";
        int n11 = 0;
        stringArray[0] = string4;
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 25;
        String string5 = "";
        string3 = n12 <= n13 ? "com.google.android.inputmethod.latin.inputcontent" : string5;
        int n14 = 1;
        stringArray[n14] = string3;
        int n15 = 2;
        string4 = n12 <= n13 ? "com.google.android.inputmethod.latin.dev.inputcontent" : string5;
        stringArray[n15] = string4;
        n12 = 3;
        string2 = Build.HARDWARE;
        string3 = "goldfish";
        n15 = (int)(string2.equals(string3) ? 1 : 0);
        if (n15 != 0 || (n13 = (int)(string2.equals(string3 = "ranchu") ? 1 : 0)) != 0) {
            n11 = n14;
        }
        if (n11 != 0) {
            string5 = "com.google.android.apps.common.testing.services.storage.runfiles";
        }
        stringArray[n12] = string5;
        zzb = stringArray;
    }

    public static AssetFileDescriptor zza(Context context, Uri uri, String string2) {
        zzh zzh2 = zzh.zza;
        return zzd.zza(context, uri, string2, zzh2);
    }

    private static AssetFileDescriptor zza(Context object, Uri object2, String string2, zzh zzh2) {
        ContentResolver contentResolver = object.getContentResolver();
        String string3 = "android.resource";
        String string4 = (object2 = Uri.parse((String)object2.toString())).getScheme();
        int n10 = string3.equals(string4);
        if (n10 != 0) {
            return contentResolver.openAssetFileDescriptor((Uri)object2, string2);
        }
        string3 = "content";
        n10 = string3.equals(string4);
        if (n10 != 0) {
            string2.hashCode();
            int n11 = -1;
            n10 = string2.hashCode();
            int n12 = 2;
            int n13 = 1;
            float f10 = Float.MIN_VALUE;
            switch (n10) {
                default: {
                    break;
                }
                case 113359: {
                    string3 = "rwt";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 4;
                    break;
                }
                case 3805: {
                    string3 = "wt";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 3;
                    break;
                }
                case 3653: {
                    string3 = "rw";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = n12;
                    break;
                }
                case 119: {
                    string3 = "w";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = n13;
                    break;
                }
                case 114: {
                    string3 = "r";
                    n10 = (int)(string2.equals(string3) ? 1 : 0);
                    if (n10 == 0) break;
                    n11 = 0;
                    string4 = null;
                }
            }
            switch (n11) {
                default: {
                    object = new IllegalArgumentException();
                    throw object;
                }
                case 0: {
                    n12 = n13;
                }
                case 1: 
                case 2: 
                case 3: 
                case 4: 
            }
            boolean bl2 = zzd.zza(object, (Uri)object2, n12, zzh2);
            if (bl2) {
                return (AssetFileDescriptor)zzd.zza(contentResolver.openAssetFileDescriptor((Uri)object2, string2));
            }
            object = new FileNotFoundException("Can't open content uri.");
            throw object;
        }
        string3 = "file";
        boolean bl3 = string3.equals(string4);
        if (bl3) {
            string2 = (AssetFileDescriptor)zzd.zza(contentResolver.openAssetFileDescriptor((Uri)object2, string2));
            contentResolver = string2.getParcelFileDescriptor();
            try {
                zzd.zza(object, (ParcelFileDescriptor)contentResolver, (Uri)object2, zzh2);
                return string2;
            }
            catch (IOException iOException) {
                object2 = new FileNotFoundException("Validation failed.");
                ((Throwable)object2).initCause(iOException);
                zzd.zza((AssetFileDescriptor)string2, (FileNotFoundException)object2);
                throw object2;
            }
            catch (FileNotFoundException fileNotFoundException) {
                zzd.zza((AssetFileDescriptor)string2, fileNotFoundException);
                throw fileNotFoundException;
            }
        }
        object = new FileNotFoundException("Not implemented. Contact tiktok-users@");
        throw object;
    }

    public static InputStream zza(Context context, Uri uri) {
        zzh zzh2 = zzh.zza;
        return zzd.zza(context, uri, zzh2);
    }

    private static InputStream zza(Context object, Uri object2, zzh zzh2) {
        ContentResolver contentResolver = object.getContentResolver();
        String string2 = "android.resource";
        Object object3 = (object2 = Uri.parse((String)object2.toString())).getScheme();
        boolean bl2 = string2.equals(object3);
        if (bl2) {
            return contentResolver.openInputStream((Uri)object2);
        }
        string2 = "content";
        bl2 = string2.equals(object3);
        if (bl2) {
            int n10 = 1;
            boolean bl3 = zzd.zza(object, (Uri)object2, n10, zzh2);
            if (bl3) {
                return (InputStream)zzd.zza(contentResolver.openInputStream((Uri)object2));
            }
            object = new FileNotFoundException("Can't open content uri.");
            throw object;
        }
        string2 = "file";
        boolean bl4 = string2.equals(object3);
        if (bl4) {
            string2 = object2.getPath();
            object3 = new File(string2);
            try {
                object3 = Uri.fromFile((File)((File)object3).getCanonicalFile());
                string2 = "r";
            }
            catch (IOException iOException) {
                object2 = new FileNotFoundException("Canonicalization failed.");
                ((Throwable)object2).initCause(iOException);
                throw object2;
            }
            contentResolver = contentResolver.openFileDescriptor((Uri)object3, string2);
            zzd.zza(object, (ParcelFileDescriptor)contentResolver, (Uri)object2, zzh2);
            try {
                object = new ParcelFileDescriptor.AutoCloseInputStream((ParcelFileDescriptor)contentResolver);
                return object;
            }
            catch (IOException iOException) {
                object2 = new FileNotFoundException("Validation failed.");
                ((Throwable)object2).initCause(iOException);
                zzd.zza((ParcelFileDescriptor)contentResolver, (FileNotFoundException)object2);
                throw object2;
            }
            catch (FileNotFoundException fileNotFoundException) {
                zzd.zza((ParcelFileDescriptor)contentResolver, fileNotFoundException);
                throw fileNotFoundException;
            }
        }
        object = new FileNotFoundException("Not implemented. Contact tiktok-users@");
        throw object;
    }

    private static Object zza(Object object) {
        if (object != null) {
            return object;
        }
        object = new FileNotFoundException("Content resolver returned null value.");
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    private static void zza(Context var0, ParcelFileDescriptor var1_1, Uri var2_2, zzh var3_3) {
        block16: {
            block17: {
                var2_2 = var2_2.getPath();
                var4_4 = new File((String)var2_2);
                var2_2 = var4_4.getCanonicalPath();
                var1_1 = zzj.zza(var1_1.getFileDescriptor());
                var4_4 = zzj.zza((String)var2_2);
                var5_5 = var4_4.zzc;
                var6_6 = "Can't open file: ";
                if (var5_5 != 0) {
                    var1_1 = String.valueOf(var2_2);
                    var7_7 = var1_1.length();
                    var1_1 = var7_7 != 0 ? var6_6.concat((String)var1_1) : new String(var6_6);
                    var0 /* !! */  = new FileNotFoundException((String)var1_1);
                    throw var0 /* !! */ ;
                }
                var8_10 = var1_1.zza;
                var10_11 = var4_4.zza;
                var5_5 = var8_10 == var10_11 ? 0 : (var8_10 < var10_11 ? -1 : 1);
                var12_12 = 0;
                var13_13 = 1;
                if (var5_5 == 0 && (var16_15 = (cfr_temp_0 = (var10_11 = var1_1.zzb) - (var14_14 = var4_4.zzb)) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) == 0) {
                    var16_15 = var13_13;
                } else {
                    var16_15 = 0;
                    var1_1 = null;
                }
                if (var16_15 == 0) {
                    var1_1 = String.valueOf(var2_2);
                    var7_8 = var1_1.length();
                    var1_1 = var7_8 != 0 ? var6_6.concat((String)var1_1) : new String(var6_6);
                    var0 /* !! */  = new FileNotFoundException((String)var1_1);
                    throw var0 /* !! */ ;
                }
                var1_1 = "/proc/";
                var16_15 = var2_2.startsWith((String)var1_1);
                if (var16_15 != 0) lbl-1000:
                // 3 sources

                {
                    while (true) {
                        var12_12 = var13_13;
                        break block16;
                        break;
                    }
                }
                var1_1 = "/data/misc/";
                var16_15 = var2_2.startsWith((String)var1_1);
                if (var16_15 != 0 || (var16_15 = zzh.zzb(var3_3)) != 0) ** GOTO lbl-1000
                var1_1 = ContextCompat.getDataDir((Context)var0 /* !! */ );
                if (var1_1 != null ? (var16_15 = var2_2.startsWith((String)(var1_1 = var1_1.getCanonicalPath()))) != 0 : (var16_15 = var2_2.startsWith((String)(var1_1 = Environment.getDataDirectory().getCanonicalPath()))) != 0) {
                    while (true) {
                        var16_15 = var13_13;
                        break;
                    }
                } else {
                    if ((var1_1 = ContextCompat.createDeviceProtectedStorageContext((Context)var0 /* !! */ )) != null && (var1_1 = ContextCompat.getDataDir((Context)var1_1)) != null && (var16_15 = (int)var2_2.startsWith((String)(var1_1 = var1_1.getCanonicalPath()))) != 0) ** continue;
                    var16_15 = 0;
                    var1_1 = null;
                }
                if (var16_15 != 0) {
                    while (true) {
                        var17_16 = var13_13;
                        break block17;
                        break;
                    }
                }
                var16_15 = Build.VERSION.SDK_INT;
                var18_17 = 19;
                if (var16_15 >= var18_17) {
                    block18: {
                        var1_1 = new zzc((Context)var0 /* !! */ );
                        var1_1 = zzd.zza((Callable)var1_1);
                        var18_17 = ((Object)var1_1).length;
                        var19_18 = null;
                        for (var5_5 = 0; var5_5 < var18_17; ++var5_5) {
                            var20_19 = var1_1[var5_5];
                            if (var20_19 == null || !(var21_20 = var2_2.startsWith((String)(var20_19 = var20_19.getCanonicalPath())))) continue;
                            while (true) {
                                var17_16 = var13_13;
                                break block18;
                                break;
                            }
                        }
                        var1_1 = new zzf((Context)var0 /* !! */ );
                        var0 /* !! */  = zzd.zza((Callable)var1_1);
                        var16_15 = var0 /* !! */ .length;
                        var4_4 = null;
                        for (var18_17 = 0; var18_17 < var16_15; ++var18_17) {
                            if ((var19_18 = var0 /* !! */ [var18_17]) != null && (var5_5 = (int)var2_2.startsWith((String)(var19_18 = var19_18.getCanonicalPath()))) != 0) ** continue;
                        }
                        var17_16 = 0;
                        var0 /* !! */  = null;
                    }
                    if (var17_16 != 0) ** continue;
                }
                var17_16 = 0;
                var0 /* !! */  = null;
            }
            if (var17_16 == (var16_15 = (int)zzh.zza(var3_3))) ** break;
            ** while (true)
        }
        if (var12_12 != 0) {
            var1_1 = String.valueOf(var2_2);
            var7_9 = var1_1.length();
            var1_1 = var7_9 != 0 ? var6_6.concat((String)var1_1) : new String(var6_6);
            var0 /* !! */  = new FileNotFoundException((String)var1_1);
            throw var0 /* !! */ ;
        }
    }

    private static void zza(AssetFileDescriptor assetFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            assetFileDescriptor.close();
            return;
        }
        catch (IOException iOException) {
            zzd.zza(fileNotFoundException, iOException);
            return;
        }
    }

    private static void zza(ParcelFileDescriptor parcelFileDescriptor, FileNotFoundException fileNotFoundException) {
        try {
            parcelFileDescriptor.close();
            return;
        }
        catch (IOException iOException) {
            zzd.zza(fileNotFoundException, iOException);
            return;
        }
    }

    private static void zza(Exception exception, Exception exception2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            zzan.zza(exception, exception2);
        }
    }

    private static boolean zza(Context stringArray, Uri uri, int n10, zzh object4) {
        Object object;
        int n11;
        Object object2;
        int n12;
        String string2 = uri.getAuthority();
        ProviderInfo providerInfo = stringArray.getPackageManager().resolveContentProvider(string2, 0);
        int n13 = 1;
        if (providerInfo == null) {
            n12 = string2.lastIndexOf(64);
            if (n12 >= 0) {
                string2 = string2.substring(n12 += n13);
                providerInfo = stringArray.getPackageManager().resolveContentProvider(string2, 0);
            }
            if (providerInfo == null) {
                boolean bl2 = zzh.zza((zzh)object4);
                if (!bl2) {
                    return n13 != 0;
                }
                return false;
            }
        }
        if ((n12 = (object2 = zze.zza)[n11 = zzh.zza((zzh)object4, (Context)stringArray, (zzr)(object = new zzr(uri, providerInfo, string2))) - n13]) != n13) {
            n11 = 2;
            if (n12 != n11) {
                object2 = stringArray.getPackageName();
                n12 = (int)(((String)object2).equals(object = providerInfo.packageName) ? 1 : 0);
                if (n12 != 0) {
                    return zzh.zza((zzh)object4);
                }
                int n14 = zzh.zza((zzh)object4);
                if (n14 != 0) {
                    return false;
                }
                n14 = Process.myPid();
                int n15 = stringArray.checkUriPermission(uri, n14, n12 = Process.myUid(), n10);
                if (n15 == 0) {
                    return n13 != 0;
                }
                for (String string3 : zzb) {
                    n14 = (int)(string3.equals(string2) ? 1 : 0);
                    if (n14 == 0) continue;
                    return n13 != 0;
                }
                n15 = (int)(providerInfo.exported ? 1 : 0);
                if (n15 != 0) {
                    for (String string4 : zza) {
                        int n16 = string4.length() - n13;
                        if (!((n16 = (int)string4.charAt(n16)) == (n12 = 46) ? (n14 = (int)((string2 = providerInfo.packageName).startsWith(string4) ? 1 : 0)) != 0 : (n14 = (int)((string2 = providerInfo.packageName).equals(string4) ? 1 : 0)) != 0)) continue;
                        return false;
                    }
                }
                return n13 != 0;
            }
            return false;
        }
        return n13 != 0;
    }

    public static final /* synthetic */ File[] zza(Context context) {
        return ContextCompat.getExternalCacheDirs(context);
    }

    private static File[] zza(Callable callable) {
        callable = callable.call();
        try {
            return (File[])callable;
        }
        catch (Exception exception) {
            RuntimeException runtimeException = new RuntimeException(exception);
            throw runtimeException;
        }
        catch (NullPointerException nullPointerException) {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 22;
            if (n10 < n11) {
                return new File[0];
            }
            throw nullPointerException;
        }
    }

    public static final /* synthetic */ File[] zzb(Context context) {
        return ContextCompat.getExternalFilesDirs(context, null);
    }
}

