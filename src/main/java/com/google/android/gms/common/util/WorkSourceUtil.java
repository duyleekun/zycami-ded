/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Process
 *  android.os.WorkSource
 *  android.util.Log
 */
package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkSourceUtil {
    private static final int zza = Process.myUid();
    private static final Method zzb = WorkSourceUtil.zza();
    private static final Method zzc = WorkSourceUtil.zzb();
    private static final Method zzd = WorkSourceUtil.zzc();
    private static final Method zze = WorkSourceUtil.zzd();
    private static final Method zzf = WorkSourceUtil.zze();
    private static final Method zzg = WorkSourceUtil.zzf();
    private static final Method zzh = WorkSourceUtil.zzg();

    private WorkSourceUtil() {
    }

    public static WorkSource fromPackage(Context object, String string2) {
        PackageManager packageManager;
        String string3 = "WorkSourceUtil";
        if (object != null && (packageManager = object.getPackageManager()) != null && string2 != null) {
            block8: {
                object = Wrappers.packageManager((Context)object);
                int n10 = 0;
                packageManager = null;
                try {
                    object = ((PackageManagerWrapper)object).getApplicationInfo(string2, 0);
                    if (object != null) break block8;
                    object = "Could not get applicationInfo from package: ";
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    object = "Could not find package: ";
                    string2 = String.valueOf(string2);
                    n10 = string2.length();
                    if (n10 != 0) {
                        object = ((String)object).concat(string2);
                    } else {
                        string2 = new String((String)object);
                        object = string2;
                    }
                    Log.e((String)string3, (String)object);
                }
                n10 = (string2 = String.valueOf(string2)).length();
                if (n10 != 0) {
                    object = ((String)object).concat(string2);
                } else {
                    string2 = new String((String)object);
                    object = string2;
                }
                Log.e((String)string3, (String)object);
                return null;
            }
            return WorkSourceUtil.zza(((ApplicationInfo)object).uid, string2);
        }
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static WorkSource fromPackageAndModuleExperimentalPi(Context objectArray, String object, String string2) {
        Object object2;
        WorkSource workSource = null;
        String string3 = "WorkSourceUtil";
        if (objectArray != null && (object2 = objectArray.getPackageManager()) != null && string2 != null && object != null) {
            Method method;
            int n10 = WorkSourceUtil.zza((Context)objectArray, (String)object);
            if (n10 < 0) {
                return null;
            }
            workSource = new WorkSource();
            object2 = zzg;
            if (object2 != null && (method = zzh) != null) {
                try {
                    Object[] objectArray2 = new Object[]{};
                    object2 = ((Method)object2).invoke(workSource, objectArray2);
                    int n11 = zza;
                    int n12 = 1;
                    int n13 = 2;
                    if (n10 != n11) {
                        Object[] objectArray3 = new Object[n13];
                        objectArray3[0] = objectArray = Integer.valueOf(n10);
                        objectArray3[n12] = object;
                        method.invoke(object2, objectArray3);
                    }
                    objectArray = new Object[n13];
                    objectArray[0] = object = Integer.valueOf(n11);
                    objectArray[n12] = string2;
                    method.invoke(object2, objectArray);
                    return workSource;
                }
                catch (Exception exception) {
                    object = "Unable to assign chained blame through WorkSource";
                    Log.w((String)string3, (String)object, (Throwable)exception);
                    return workSource;
                }
            }
            WorkSourceUtil.zza(workSource, n10, (String)object);
            return workSource;
        }
        Log.w((String)string3, (String)"Unexpected null arguments");
        return null;
    }

    public static List getNames(WorkSource workSource) {
        int n10 = workSource == null ? 0 : WorkSourceUtil.zza(workSource);
        if (n10 == 0) {
            return Collections.emptyList();
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string2 = WorkSourceUtil.zza(workSource, i10);
            boolean bl2 = Strings.isEmptyOrWhitespace(string2);
            if (bl2) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static boolean hasWorkSourcePermission(Context object) {
        String string2;
        if (object == null) {
            return false;
        }
        Object object2 = object.getPackageManager();
        if (object2 == null) {
            return false;
        }
        object2 = Wrappers.packageManager(object);
        int n10 = ((PackageManagerWrapper)object2).checkPermission(string2 = "android.permission.UPDATE_DEVICE_STATS", (String)(object = object.getPackageName()));
        return n10 == 0;
    }

    private static int zza(Context object, String string2) {
        block7: {
            int n10;
            String string3 = "WorkSourceUtil";
            int n11 = -1;
            try {
                object = Wrappers.packageManager((Context)object);
                n10 = 0;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = "Could not find package: ";
                string2 = String.valueOf(string2);
                n10 = string2.length();
                if (n10 != 0) {
                    object = ((String)object).concat(string2);
                } else {
                    string2 = new String((String)object);
                    object = string2;
                }
                Log.e((String)string3, (String)object);
                return n11;
            }
            object = ((PackageManagerWrapper)object).getApplicationInfo(string2, 0);
            if (object != null) break block7;
            object = "Could not get applicationInfo from package: ";
            n10 = (string2 = String.valueOf(string2)).length();
            if (n10 != 0) {
                object = ((String)object).concat(string2);
            } else {
                string2 = new String((String)object);
                object = string2;
            }
            Log.e((String)string3, (String)object);
            return n11;
        }
        return ((ApplicationInfo)object).uid;
    }

    private static int zza(WorkSource object) {
        Object object2 = zzd;
        if (object2 != null) {
            Object[] objectArray = new Object[]{};
            object = ((Method)object2).invoke(object, objectArray);
            object = (Integer)object;
            try {
                return (Integer)object;
            }
            catch (Exception exception) {
                object2 = "WorkSourceUtil";
                objectArray = "Unable to assign blame through WorkSource";
                Log.wtf((String)object2, (String)objectArray, (Throwable)exception);
            }
        }
        return 0;
    }

    private static WorkSource zza(int n10, String string2) {
        WorkSource workSource = new WorkSource();
        WorkSourceUtil.zza(workSource, n10, string2);
        return workSource;
    }

    private static String zza(WorkSource object, int n10) {
        Object object2 = zzf;
        if (object2 != null) {
            int n11 = 1;
            Object[] objectArray = new Object[n11];
            Object object3 = n10;
            objectArray[0] = object3;
            object = ((Method)object2).invoke(object, objectArray);
            try {
                return (String)object;
            }
            catch (Exception exception) {
                object3 = "WorkSourceUtil";
                object2 = "Unable to assign blame through WorkSource";
                Log.wtf((String)object3, (String)object2, (Throwable)exception);
            }
        }
        return null;
    }

    private static Method zza() {
        Object object = WorkSource.class;
        String string2 = "add";
        int n10 = 1;
        Class[] classArray = new Class[n10];
        Class<Integer> clazz = Integer.TYPE;
        classArray[0] = clazz;
        try {
            object = ((Class)object).getMethod(string2, classArray);
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    private static void zza(WorkSource workSource, int n10, String object) {
        Object[] objectArray = zzc;
        String string2 = "Unable to assign blame through WorkSource";
        String string3 = "WorkSourceUtil";
        int n11 = 1;
        if (objectArray != null) {
            Object[] objectArray2;
            if (object == null) {
                object = "";
            }
            int n12 = 2;
            try {
                objectArray2 = new Object[n12];
            }
            catch (Exception exception) {
                Log.wtf((String)string3, (String)string2, (Throwable)exception);
                return;
            }
            Integer n13 = n10;
            objectArray2[0] = n13;
            objectArray2[n11] = object;
            objectArray.invoke(workSource, objectArray2);
            return;
        }
        object = zzb;
        if (object != null) {
            objectArray = new Object[n11];
            Integer n14 = n10;
            objectArray[0] = n14;
            try {
                ((Method)object).invoke(workSource, objectArray);
                return;
            }
            catch (Exception exception) {
                Log.wtf((String)string3, (String)string2, (Throwable)exception);
            }
        }
    }

    private static Method zzb() {
        Object object;
        block7: {
            boolean bl2 = PlatformVersion.isAtLeastJellyBeanMR2();
            if (bl2) {
                int n10;
                Class[] classArray;
                object = WorkSource.class;
                String string2 = "add";
                int n11 = 2;
                try {
                    classArray = new Class[n11];
                    n10 = 0;
                }
                catch (Exception exception) {}
                Class<Object> clazz = Integer.TYPE;
                classArray[0] = clazz;
                n10 = 1;
                clazz = String.class;
                classArray[n10] = clazz;
                object = ((Class)object).getMethod(string2, classArray);
                break block7;
            }
            bl2 = false;
            object = null;
        }
        return object;
    }

    private static Method zzc() {
        Object object = WorkSource.class;
        String string2 = "size";
        Class[] classArray = null;
        classArray = new Class[]{};
        try {
            object = ((Class)object).getMethod(string2, classArray);
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    private static Method zzd() {
        Object object = WorkSource.class;
        String string2 = "get";
        int n10 = 1;
        Class[] classArray = new Class[n10];
        Class<Integer> clazz = Integer.TYPE;
        classArray[0] = clazz;
        try {
            object = ((Class)object).getMethod(string2, classArray);
        }
        catch (Exception exception) {
            object = null;
        }
        return object;
    }

    private static Method zze() {
        Object object;
        block6: {
            boolean bl2 = PlatformVersion.isAtLeastJellyBeanMR2();
            if (bl2) {
                Class[] classArray;
                object = WorkSource.class;
                String string2 = "getName";
                int n10 = 1;
                try {
                    classArray = new Class[n10];
                }
                catch (Exception exception) {}
                Class<Integer> clazz = Integer.TYPE;
                classArray[0] = clazz;
                object = ((Class)object).getMethod(string2, classArray);
                break block6;
            }
            bl2 = false;
            object = null;
        }
        return object;
    }

    private static final Method zzf() {
        Object object;
        block4: {
            boolean bl2 = PlatformVersion.isAtLeastP();
            if (bl2) {
                object = WorkSource.class;
                String string2 = "createWorkChain";
                Object object2 = null;
                object2 = new Class[]{};
                try {
                    object = ((Class)object).getMethod(string2, (Class<?>)object2);
                    break block4;
                }
                catch (Exception exception) {
                    string2 = "WorkSourceUtil";
                    object2 = "Missing WorkChain API createWorkChain";
                    Log.w((String)string2, (String)object2, (Throwable)exception);
                }
            }
            bl2 = false;
            object = null;
        }
        return object;
    }

    private static final Method zzg() {
        Object object;
        block8: {
            boolean bl2 = PlatformVersion.isAtLeastP();
            if (bl2) {
                object = "android.os.WorkSource$WorkChain";
                object = Class.forName((String)object);
                String string2 = "addNode";
                int n10 = 2;
                Class[] classArray = new Class[n10];
                int n11 = 0;
                Class<Object> clazz = Integer.TYPE;
                classArray[0] = clazz;
                n11 = 1;
                clazz = String.class;
                classArray[n11] = clazz;
                try {
                    object = ((Class)object).getMethod(string2, classArray);
                    break block8;
                }
                catch (Exception exception) {
                    string2 = "WorkSourceUtil";
                    classArray = "Missing WorkChain class";
                    Log.w((String)string2, (String)classArray, (Throwable)exception);
                }
            }
            bl2 = false;
            object = null;
        }
        return object;
    }
}

