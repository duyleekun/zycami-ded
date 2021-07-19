/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.Signature
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.common.zzc;
import com.google.android.gms.common.zzd;
import com.google.android.gms.common.zzg;
import com.google.android.gms.common.zzi;
import com.google.android.gms.common.zzl;

public class GoogleSignatureVerifier {
    private static GoogleSignatureVerifier zza;
    private final Context zzb;
    private volatile String zzc;

    private GoogleSignatureVerifier(Context context) {
        this.zzb = context = context.getApplicationContext();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static GoogleSignatureVerifier getInstance(Context context) {
        Preconditions.checkNotNull(context);
        Class<GoogleSignatureVerifier> clazz = GoogleSignatureVerifier.class;
        synchronized (clazz) {
            GoogleSignatureVerifier googleSignatureVerifier = zza;
            if (googleSignatureVerifier == null) {
                com.google.android.gms.common.zzc.zza(context);
                zza = googleSignatureVerifier = new GoogleSignatureVerifier(context);
            }
            return zza;
        }
    }

    private static zzd zza(PackageInfo object, zzd ... zzdArray) {
        int n10;
        Object object2 = ((PackageInfo)object).signatures;
        if (object2 == null) {
            return null;
        }
        int n11 = ((Signature[])object2).length;
        int n12 = 1;
        if (n11 != n12) {
            Log.w((String)"GoogleSignatureVerifier", (String)"Package has more than one signature.");
            return null;
        }
        object = ((PackageInfo)object).signatures;
        object = object[0].toByteArray();
        object2 = new zzg((byte[])object);
        for (n12 = 0; n12 < (n10 = zzdArray.length); ++n12) {
            object = zzdArray[n12];
            n10 = (int)(((zzd)object).equals(object2) ? 1 : 0);
            if (n10 == 0) continue;
            return zzdArray[n12];
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final zzl zza(String var1_1) {
        block10: {
            block11: {
                block9: {
                    var2_2 /* !! */  = "null pkg";
                    if (var1_1 == null) {
                        return zzl.zza((String)var2_2 /* !! */ );
                    }
                    var3_3 = this.zzc;
                    var4_4 = var1_1.equals(var3_3);
                    if (var4_4 != 0) {
                        return zzl.zza();
                    }
                    try {
                        var3_3 = this.zzb;
                    }
                    catch (PackageManager.NameNotFoundException v0) {
                        var2_2 /* !! */  = "no pkg ";
                        var1_1 = String.valueOf(var1_1);
                        var4_4 = var1_1.length();
                        var1_1 = var4_4 != 0 ? var2_2 /* !! */ .concat(var1_1) : new String((String)var2_2 /* !! */ );
                        return zzl.zza(var1_1);
                    }
                    var3_3 = Wrappers.packageManager((Context)var3_3);
                    var5_5 = 64 != 0;
                    var3_3 = var3_3.getPackageInfo(var1_1, (int)var5_5);
                    var6_6 /* !! */  = this.zzb;
                    var5_5 = GooglePlayServicesUtilLight.honorsDebugCertificates(var6_6 /* !! */ );
                    if (var3_3 != null) break block9;
                    var2_2 /* !! */  = zzl.zza((String)var2_2 /* !! */ );
                    break block10;
                }
                var2_2 /* !! */  = var3_3.signatures;
                if (var2_2 /* !! */  == null || (var7_7 = ((Signature[])var2_2 /* !! */ ).length) != (var8_8 = true)) break block11;
                var9_9 /* !! */  = var3_3.signatures[0].toByteArray();
                var2_2 /* !! */  = new zzg(var9_9 /* !! */ );
                var9_9 /* !! */  = (byte[])var3_3.packageName;
                var6_6 /* !! */  = com.google.android.gms.common.zzc.zza((String)var9_9 /* !! */ , (zzd)var2_2 /* !! */ , var5_5, false);
                var10_10 = var6_6 /* !! */ .zza;
                if (!var10_10 || (var3_3 = var3_3.applicationInfo) == null || (var4_4 = var3_3.flags & 2) == 0) ** GOTO lbl-1000
                var2_2 /* !! */  = com.google.android.gms.common.zzc.zza((String)var9_9 /* !! */ , (zzd)var2_2 /* !! */ , false, var8_8);
                var7_7 = var2_2 /* !! */ .zza;
                if (var7_7) {
                    var2_2 /* !! */  = zzl.zza("debuggable release cert app rejected");
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 /* !! */  = var6_6 /* !! */ ;
                }
                break block10;
            }
            var2_2 /* !! */  = zzl.zza("single cert required");
        }
        var4_4 = (int)var2_2 /* !! */ .zza;
        if (var4_4 != 0) {
            this.zzc = var1_1;
        }
        return var2_2 /* !! */ ;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final zzl zza(String string2, int n10) {
        try {
            boolean bl2;
            boolean bl3;
            Object object = this.zzb;
            object = Wrappers.packageManager((Context)object);
            int n11 = 64;
            Object object2 = ((PackageManagerWrapper)object).zza(string2, n11, n10);
            object = this.zzb;
            boolean bl4 = GooglePlayServicesUtilLight.honorsDebugCertificates((Context)object);
            if (object2 == null) {
                object2 = "null pkg";
                return zzl.zza((String)object2);
            }
            Signature[] signatureArray = object2.signatures;
            if (signatureArray != null && (bl3 = signatureArray.length) == (bl2 = true)) {
                Signature[] signatureArray2 = object2.signatures;
                Signature signature = signatureArray2[0];
                byte[] byArray = signature.toByteArray();
                zzg zzg2 = new zzg(byArray);
                String string3 = object2.packageName;
                object = com.google.android.gms.common.zzc.zza(string3, zzg2, bl4, false);
                boolean bl5 = ((zzl)object).zza;
                if (!bl5) return object;
                object2 = object2.applicationInfo;
                if (object2 == null) return object;
                n10 = object2.flags & 2;
                if (n10 == 0) return object;
                object2 = com.google.android.gms.common.zzc.zza(string3, zzg2, false, bl2);
                n10 = (int)(object2.zza ? 1 : 0);
                if (n10 == 0) return object;
                object2 = "debuggable release cert app rejected";
                return zzl.zza((String)object2);
            }
            object2 = "single cert required";
            return zzl.zza((String)object2);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            String string4 = "no pkg ";
            string2 = String.valueOf(string2);
            int n12 = string2.length();
            if (n12 != 0) {
                string2 = string4.concat(string2);
                return zzl.zza(string2);
            }
            string2 = new String(string4);
            return zzl.zza(string2);
        }
    }

    public static boolean zza(PackageInfo object, boolean bl2) {
        Signature[] signatureArray;
        if (object != null && (signatureArray = object.signatures) != null) {
            boolean bl3 = true;
            if (bl2) {
                zzd[] zzdArray = zzi.zza;
                object = GoogleSignatureVerifier.zza(object, zzdArray);
            } else {
                zzd zzd2;
                zzd[] zzdArray = new zzd[bl3];
                zzdArray[0] = zzd2 = zzi.zza[0];
                object = GoogleSignatureVerifier.zza(object, zzdArray);
            }
            if (object != null) {
                return bl3;
            }
        }
        return false;
    }

    public boolean isGooglePublicSignedPackage(PackageInfo object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = GoogleSignatureVerifier.zza(object, false);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        boolean bl4 = GoogleSignatureVerifier.zza(object, bl3);
        if (bl4) {
            object = this.zzb;
            bl4 = GooglePlayServicesUtilLight.honorsDebugCertificates((Context)object);
            if (bl4) {
                return bl3;
            }
            object = "GoogleSignatureVerifier";
            String string2 = "Test-keys aren't accepted on this build.";
            Log.w((String)object, (String)string2);
        }
        return false;
    }

    public boolean isPackageGoogleSigned(String object) {
        object = this.zza((String)object);
        ((zzl)object).zzc();
        return ((zzl)object).zza;
    }

    /*
     * WARNING - void declaration
     */
    public boolean isUidGoogleSigned(int n10) {
        void var4_11;
        block4: {
            int n11;
            String[] stringArray = Wrappers.packageManager(this.zzb).zza(n10);
            if (stringArray != null && (n11 = stringArray.length) != 0) {
                void var4_5;
                Object object;
                n11 = 0;
                Object object3 = null;
                for (String string2 : stringArray) {
                    zzl zzl2 = this.zza(string2, n10);
                    boolean bl2 = zzl2.zza;
                    if (!bl2) {
                        continue;
                    }
                    break block4;
                }
                Object object2 = object = Preconditions.checkNotNull(var4_5);
                zzl zzl3 = (zzl)object;
            } else {
                String string3 = "no pkgs";
                zzl zzl4 = zzl.zza(string3);
            }
        }
        var4_11.zzc();
        return var4_11.zza;
    }
}

