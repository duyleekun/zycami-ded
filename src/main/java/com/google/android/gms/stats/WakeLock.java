/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.PowerManager
 *  android.os.PowerManager$WakeLock
 *  android.os.WorkSource
 *  android.text.TextUtils
 *  android.util.Log
 */
package com.google.android.gms.stats;

import android.content.Context;
import android.os.PowerManager;
import android.os.WorkSource;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.providers.PooledExecutorsProvider;
import com.google.android.gms.common.stats.StatsUtils;
import com.google.android.gms.common.stats.WakeLockTracker;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.stats.WakeLock$zza;
import com.google.android.gms.stats.zza;
import com.google.android.gms.stats.zzb;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WakeLock {
    private static ScheduledExecutorService zzn;
    private static volatile WakeLock$zza zzo;
    private final Object zza;
    private final PowerManager.WakeLock zzb;
    private WorkSource zzc;
    private final int zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final Context zzh;
    private boolean zzi;
    private final Map zzj;
    private final Set zzk;
    private int zzl;
    private AtomicInteger zzm;

    static {
        zza zza2 = new zza();
        zzo = zza2;
    }

    public WakeLock(Context context, int n10, String string2) {
        String string3 = context == null ? null : context.getPackageName();
        this(context, n10, string2, null, string3);
    }

    private WakeLock(Context context, int n10, String string2, String string3, String string4) {
        this(context, n10, string2, null, string4, null);
    }

    private WakeLock(Context object, int n10, String string2, String object2, String string3, String string4) {
        block11: {
            Object object3;
            this.zza = this;
            this.zzi = true;
            object2 = new HashMap();
            this.zzj = object2;
            this.zzk = object2 = Collections.synchronizedSet(object2);
            this.zzm = object2 = new AtomicInteger(0);
            Preconditions.checkNotNull(object, "WakeLock: context must not be null");
            Preconditions.checkNotEmpty(string2, "WakeLock: wakeLockName must not be empty");
            this.zzd = n10;
            this.zzf = null;
            this.zzg = null;
            object2 = object.getApplicationContext();
            this.zzh = object2;
            string4 = object.getPackageName();
            String string5 = "com.google.android.gms";
            boolean bl2 = string5.equals(string4);
            if (!bl2) {
                string4 = "*gcore*:";
                string5 = String.valueOf(string2);
                int n11 = string5.length();
                string4 = n11 != 0 ? string4.concat(string5) : (string5 = new String(string4));
                this.zze = string4;
            } else {
                this.zze = string2;
            }
            string4 = (PowerManager)object.getSystemService("power");
            this.zzb = object3 = string4.newWakeLock(n10, string2);
            boolean bl3 = WorkSourceUtil.hasWorkSourcePermission((Context)object);
            if (bl3) {
                bl3 = Strings.isEmptyOrWhitespace(string3);
                if (bl3) {
                    string3 = object.getPackageName();
                }
                object = WorkSourceUtil.fromPackage((Context)object, string3);
                this.zzc = object;
                if (object != null && (bl3 = WorkSourceUtil.hasWorkSourcePermission((Context)object2))) {
                    string2 = this.zzc;
                    if (string2 != null) {
                        string2.add((WorkSource)object);
                    } else {
                        this.zzc = object;
                    }
                    object = this.zzc;
                    try {
                        object3.setWorkSource((WorkSource)object);
                        break block11;
                    }
                    catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    }
                    catch (IllegalArgumentException illegalArgumentException) {
                        // empty catch block
                    }
                    object = ((Throwable)object).toString();
                    object3 = "WakeLock";
                    Log.wtf((String)object3, (String)object);
                }
            }
        }
        if ((object = zzn) == null) {
            object = PooledExecutorsProvider.getInstance().newSingleThreadScheduledExecutor();
            zzn = object;
        }
    }

    private final String zza(String string2) {
        boolean bl2 = this.zzi;
        if (bl2) {
            bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                return string2;
            }
            return this.zzf;
        }
        return this.zzf;
    }

    private final List zza() {
        return WorkSourceUtil.getNames(this.zzc);
    }

    private final void zza(int n10) {
        block5: {
            PowerManager.WakeLock wakeLock = this.zzb;
            n10 = (int)(wakeLock.isHeld() ? 1 : 0);
            if (n10 != 0) {
                RuntimeException runtimeException2;
                block4: {
                    wakeLock = this.zzb;
                    try {
                        wakeLock.release();
                    }
                    catch (RuntimeException runtimeException2) {
                        Object object = runtimeException2.getClass();
                        Object object2 = RuntimeException.class;
                        boolean bl2 = object.equals(object2);
                        if (!bl2) break block4;
                        object = String.valueOf(this.zze).concat(" was already released!");
                        object2 = "WakeLock";
                        Log.e((String)object2, (String)object, (Throwable)runtimeException2);
                    }
                    wakeLock = this.zzb;
                    wakeLock.isHeld();
                    break block5;
                }
                throw runtimeException2;
            }
        }
    }

    public static /* synthetic */ void zza(WakeLock wakeLock, int n10) {
        wakeLock.zza(0);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void acquire(long l10) {
        Object object;
        Object object2;
        Object object3;
        int n10;
        block12: {
            this.zzm.incrementAndGet();
            n10 = 0;
            String string2 = this.zza(null);
            object3 = this.zza;
            synchronized (object3) {
                Object object4;
                int n11;
                int n12;
                block11: {
                    block10: {
                        object2 = this.zzj;
                        n12 = object2.isEmpty();
                        int n13 = 0;
                        object = null;
                        if ((n12 == 0 || (n12 = this.zzl) > 0) && (n12 = (int)((object2 = this.zzb).isHeld() ? 1 : 0)) == 0) {
                            object2 = this.zzj;
                            object2.clear();
                            this.zzl = 0;
                        }
                        n12 = (int)(this.zzi ? 1 : 0);
                        n11 = 1;
                        if (n12 == 0) break block10;
                        object2 = this.zzj;
                        object2 = object2.get(string2);
                        if ((object2 = (Integer[])object2) == null) {
                            object2 = this.zzj;
                            object4 = new Integer[n11];
                            Integer n14 = n11;
                            object4[0] = n14;
                            object2.put(string2, object4);
                            n13 = n11;
                        } else {
                            object4 = object2[0];
                            int n15 = object4.intValue() + n11;
                            object4 = n15;
                            object2[0] = object4;
                        }
                        if (n13 != 0) break block11;
                    }
                    if ((n12 = (int)(this.zzi ? 1 : 0)) != 0 || (n12 = this.zzl) != 0) break block12;
                }
                object2 = WakeLockTracker.getInstance();
                object = this.zzh;
                object4 = this.zzb;
                object4 = StatsUtils.getEventKey(object4, string2);
                int n16 = 7;
                String string3 = this.zze;
                int n17 = this.zzd;
                List list = this.zza();
                ((WakeLockTracker)object2).registerEvent((Context)object, (String)object4, n16, string3, string2, null, n17, list, l10);
                this.zzl = n12 = this.zzl + n11;
            }
        }
        object3 = this.zzb;
        object3.acquire();
        long l11 = 0L;
        n10 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (n10 > 0) {
            object3 = zzn;
            object2 = new zzb(this);
            object = TimeUnit.MILLISECONDS;
            object3.schedule((Runnable)object2, l10, (TimeUnit)((Object)object));
        }
    }

    public boolean isHeld() {
        return this.zzb.isHeld();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        block13: {
            var1_1 = this.zzm;
            var2_2 = var1_1.decrementAndGet();
            if (var2_2 < 0) {
                var1_1 = "WakeLock";
                var3_3 = String.valueOf(this.zze);
                var4_4 = " release without a matched acquire!";
                var3_3 = var3_3.concat((String)var4_4);
                Log.e((String)var1_1, (String)var3_3);
            }
            var2_2 = 0;
            var5_5 = this.zza(null);
            var1_1 = this.zza;
            synchronized (var1_1) {
                block12: {
                    block11: {
                        var6_6 = this.zzi;
                        var7_7 = 1;
                        if (var6_6 == 0) break block11;
                        var3_3 = this.zzj;
                        var3_3 = var3_3.get(var5_5);
                        if ((var3_3 = (Integer[])var3_3) == null) ** GOTO lbl31
                        var4_4 = var3_3[0];
                        var8_8 = var4_4.intValue();
                        if (var8_8 == var7_7) {
                            var3_3 = this.zzj;
                            var3_3.remove(var5_5);
                            var6_6 = var7_7;
                        } else {
                            var4_4 = var3_3[0];
                            var8_8 = var4_4.intValue() - var7_7;
                            var3_3[0] = var4_4 = Integer.valueOf(var8_8);
lbl31:
                            // 2 sources

                            var6_6 = 0;
                            var3_3 = null;
                        }
                        if (var6_6 != 0) break block12;
                    }
                    if ((var6_6 = this.zzi) != 0 || (var6_6 = this.zzl) != var7_7) break block13;
                }
                var3_3 = WakeLockTracker.getInstance();
                var4_4 = this.zzh;
                var9_9 /* !! */  = this.zzb;
                var9_9 /* !! */  = StatsUtils.getEventKey(var9_9 /* !! */ , var5_5);
                var10_10 = 8;
                var11_11 = this.zze;
                var12_12 = this.zzd;
                var13_13 = this.zza();
                var3_3.registerEvent((Context)var4_4, (String)var9_9 /* !! */ , var10_10, var11_11, var5_5, null, var12_12, var13_13);
                this.zzl = var6_6 = this.zzl - var7_7;
            }
        }
        this.zza(0);
    }

    public void setReferenceCounted(boolean bl2) {
        this.zzb.setReferenceCounted(bl2);
        this.zzi = bl2;
    }
}

