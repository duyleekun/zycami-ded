/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.os.Build
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import com.google.android.gms.common.util.PlatformVersion;

public final class DeviceProperties {
    private static Boolean zza;
    private static Boolean zzb;
    private static Boolean zzc;
    private static Boolean zzd;
    private static Boolean zze;
    private static Boolean zzf;
    private static Boolean zzg;
    private static Boolean zzh;

    private DeviceProperties() {
    }

    public static boolean isAuto(Context context) {
        return DeviceProperties.isAuto(context.getPackageManager());
    }

    public static boolean isAuto(PackageManager object) {
        Object object2 = zzg;
        if (object2 == null) {
            boolean bl2;
            boolean bl3 = PlatformVersion.isAtLeastO();
            if (bl3 && (bl2 = object.hasSystemFeature((String)(object2 = "android.hardware.type.automotive")))) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            object = bl2;
            zzg = object;
        }
        return zzg;
    }

    public static boolean isFeaturePhone(Context context) {
        return false;
    }

    public static boolean isLatchsky(Context object) {
        Object object2 = zze;
        if (object2 == null) {
            boolean bl2;
            boolean bl3 = (object = object.getPackageManager()).hasSystemFeature((String)(object2 = "com.google.android.feature.services_updater"));
            if (bl3 && (bl2 = object.hasSystemFeature((String)(object2 = "cn.google.services")))) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            object = bl2;
            zze = object;
        }
        return zze;
    }

    public static boolean isSidewinder(Context context) {
        return DeviceProperties.zzb(context);
    }

    public static boolean isTablet(Resources object) {
        block9: {
            int n10;
            block11: {
                int n11;
                block10: {
                    int n12;
                    n10 = 0;
                    if (object == null) {
                        return false;
                    }
                    Boolean bl2 = zza;
                    if (bl2 != null) break block9;
                    bl2 = object.getConfiguration();
                    int n13 = ((Configuration)bl2).screenLayout & 0xF;
                    int n14 = 3;
                    n11 = 1;
                    if (n13 > n14) {
                        n13 = n11;
                    } else {
                        n13 = 0;
                        bl2 = null;
                    }
                    if (n13 != 0) break block10;
                    bl2 = zzb;
                    if (bl2 == null) {
                        object = object.getConfiguration();
                        n13 = ((Configuration)object).screenLayout & 0xF;
                        if (n13 <= n14 && (n12 = ((Configuration)object).smallestScreenWidthDp) >= (n13 = 600)) {
                            n12 = n11;
                        } else {
                            n12 = 0;
                            object = null;
                        }
                        zzb = object = Boolean.valueOf(n12 != 0);
                    }
                    if ((n12 = ((Boolean)(object = zzb)).booleanValue()) == 0) break block11;
                }
                n10 = n11;
            }
            object = n10 != 0;
            zza = object;
        }
        return zza;
    }

    public static boolean isTv(Context context) {
        return DeviceProperties.isTv(context.getPackageManager());
    }

    public static boolean isTv(PackageManager object) {
        Object object2 = zzh;
        if (object2 == null) {
            boolean bl2;
            object2 = "com.google.android.tv";
            boolean bl3 = object.hasSystemFeature((String)object2);
            if (!(bl3 || (bl3 = object.hasSystemFeature((String)(object2 = "android.hardware.type.television"))) || (bl2 = object.hasSystemFeature((String)(object2 = "android.software.leanback"))))) {
                bl2 = false;
                object = null;
            } else {
                bl2 = true;
            }
            object = bl2;
            zzh = object;
        }
        return zzh;
    }

    public static boolean isUserBuild() {
        String string2 = Build.TYPE;
        return "user".equals(string2);
    }

    public static boolean isWearable(Context context) {
        return DeviceProperties.isWearable(context.getPackageManager());
    }

    public static boolean isWearable(PackageManager object) {
        Object object2 = zzc;
        if (object2 == null) {
            boolean bl2;
            boolean bl3 = PlatformVersion.isAtLeastKitKatWatch();
            if (bl3 && (bl2 = object.hasSystemFeature((String)(object2 = "android.hardware.type.watch")))) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            object = bl2;
            zzc = object;
        }
        return zzc;
    }

    public static boolean isWearableWithoutPlayStore(Context context) {
        boolean bl2;
        boolean bl3 = DeviceProperties.isWearable(context);
        return bl3 && (!(bl3 = PlatformVersion.isAtLeastN()) || (bl2 = DeviceProperties.zzb(context)) && !(bl2 = PlatformVersion.isAtLeastO()));
    }

    public static boolean zza(Context object) {
        Object object2 = zzf;
        if (object2 == null) {
            boolean bl2;
            String string2;
            object2 = object.getPackageManager();
            boolean bl3 = object2.hasSystemFeature(string2 = "android.hardware.type.iot");
            if (!bl3 && !(bl2 = (object = object.getPackageManager()).hasSystemFeature((String)(object2 = "android.hardware.type.embedded")))) {
                bl2 = false;
                object = null;
            } else {
                bl2 = true;
            }
            object = bl2;
            zzf = object;
        }
        return zzf;
    }

    private static boolean zzb(Context object) {
        Object object2 = zzd;
        if (object2 == null) {
            boolean bl2;
            boolean bl3 = PlatformVersion.isAtLeastLollipop();
            if (bl3 && (bl2 = (object = object.getPackageManager()).hasSystemFeature((String)(object2 = "cn.google")))) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            object = bl2;
            zzd = object;
        }
        return zzd;
    }
}

