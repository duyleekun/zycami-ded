/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.job.JobInfo
 *  android.app.job.JobScheduler
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.UserHandle
 *  android.util.Log
 */
package com.google.android.gms.internal.measurement;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build;
import android.os.UserHandle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public final class zzg {
    private static final Method zzb;
    private static final Method zzc;
    private final JobScheduler zza;

    static {
        Method method;
        block15: {
            boolean bl2;
            String string2;
            int n10;
            Class[] classArray;
            int n11;
            int n12;
            Object object;
            block13: {
                block14: {
                    object = String.class;
                    n12 = Build.VERSION.SDK_INT;
                    n11 = 6;
                    classArray = null;
                    n10 = 24;
                    string2 = "JobSchedulerCompat";
                    method = null;
                    if (n12 >= n10) {
                        int n13 = 4;
                        Class[] classArray2 = new Class[n13];
                        Object object2 = JobInfo.class;
                        classArray2[0] = object2;
                        int n14 = 1;
                        classArray2[n14] = object;
                        n14 = 2;
                        Class<Integer> clazz = Integer.TYPE;
                        classArray2[n14] = clazz;
                        n14 = 3;
                        classArray2[n14] = object;
                        object = JobScheduler.class;
                        object2 = "scheduleAsPackage";
                        try {
                            object = ((Class)object).getDeclaredMethod((String)object2, classArray2);
                            break block13;
                        }
                        catch (NoSuchMethodException noSuchMethodException) {
                            bl2 = Log.isLoggable((String)string2, (int)n11);
                            if (!bl2) break block14;
                            object = "No scheduleAsPackage method available, falling back to schedule";
                            Log.e((String)string2, (String)object);
                        }
                    }
                }
                bl2 = false;
                object = null;
            }
            zzb = object;
            if (n12 >= n10) {
                object = UserHandle.class;
                String string3 = "myUserId";
                classArray = new Class[]{};
                try {
                    method = ((Class)object).getDeclaredMethod(string3, classArray);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    bl2 = Log.isLoggable((String)string2, (int)n11);
                    if (!bl2) break block15;
                    object = "No myUserId method available";
                    Log.e((String)string2, (String)object);
                }
            }
        }
        zzc = method;
    }

    public zzg(JobScheduler jobScheduler) {
        this.zza = jobScheduler;
    }

    /*
     * WARNING - void declaration
     */
    public static int zza(Context object, JobInfo jobInfo, String object2, String object3) {
        int n10;
        object2 = (JobScheduler)object.getSystemService("jobscheduler");
        Objects.requireNonNull(object2);
        object3 = zzb;
        if (object3 != null && (n10 = object.checkSelfPermission((String)(object3 = "android.permission.UPDATE_DEVICE_STATS"))) == 0) {
            int n11;
            block25: {
                int n12;
                int n13;
                Object[] objectArray;
                Object object4;
                block23: {
                    block22: {
                        object = new zzg((JobScheduler)object2);
                        object2 = zzc;
                        n11 = 0;
                        object3 = null;
                        if (object2 != null) {
                            object4 = UserHandle.class;
                            objectArray = new Object[]{};
                            object2 = ((Method)object2).invoke(object4, objectArray);
                            object2 = (Integer)object2;
                            if (object2 == null) break block22;
                            try {
                                n13 = (Integer)object2;
                                break block23;
                            }
                            catch (InvocationTargetException invocationTargetException) {
                            }
                            catch (IllegalAccessException illegalAccessException) {
                                // empty catch block
                            }
                            objectArray = "JobSchedulerCompat";
                            n12 = Log.isLoggable((String)objectArray, (int)6);
                            if (n12 != 0) {
                                object4 = "myUserId invocation illegal";
                                Log.e((String)objectArray, (String)object4, (Throwable)object2);
                            }
                        }
                    }
                    n13 = 0;
                    object2 = null;
                }
                object4 = "com.google.android.gms";
                objectArray = "UploadAlarm";
                Method method = zzb;
                if (method != null) {
                    void var2_7;
                    JobScheduler jobScheduler = object.zza;
                    int n14 = 4;
                    Object[] objectArray2 = new Object[n14];
                    objectArray2[0] = jobInfo;
                    int n15 = 1;
                    objectArray2[n15] = object4;
                    n12 = 2;
                    object2 = n13;
                    objectArray2[n12] = object2;
                    n13 = 3;
                    objectArray2[n13] = objectArray;
                    object2 = method.invoke(jobScheduler, objectArray2);
                    object2 = (Integer)object2;
                    if (object2 == null) break block25;
                    try {
                        n11 = (Integer)object2;
                        break block25;
                    }
                    catch (InvocationTargetException invocationTargetException) {
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        // empty catch block
                    }
                    object3 = "error calling scheduleAsPackage";
                    Log.e((String)objectArray, (String)object3, (Throwable)var2_7);
                }
                object = object.zza;
                n11 = object.schedule(jobInfo);
            }
            return n11;
        }
        return object2.schedule(jobInfo);
    }
}

