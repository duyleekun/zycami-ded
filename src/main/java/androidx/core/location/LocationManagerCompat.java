/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.location.GnssStatus$Callback
 *  android.location.GpsStatus$Listener
 *  android.location.LocationManager
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Looper
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 */
package androidx.core.location;

import android.content.ContentResolver;
import android.content.Context;
import android.location.GnssStatus;
import android.location.GpsStatus;
import android.location.LocationManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.collection.SimpleArrayMap;
import androidx.core.location.GnssStatusCompat$Callback;
import androidx.core.location.LocationManagerCompat$1;
import androidx.core.location.LocationManagerCompat$Api28Impl;
import androidx.core.location.LocationManagerCompat$GnssStatusTransport;
import androidx.core.location.LocationManagerCompat$GpsStatusTransport;
import androidx.core.location.LocationManagerCompat$InlineHandlerExecutor;
import androidx.core.location.LocationManagerCompat$PreRGnssStatusTransport;
import androidx.core.os.ExecutorCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class LocationManagerCompat {
    private static final long PRE_N_LOOPER_TIMEOUT_S = 4L;
    private static Field sContextField;
    private static final SimpleArrayMap sGnssStatusListeners;

    static {
        SimpleArrayMap simpleArrayMap;
        sGnssStatusListeners = simpleArrayMap = new SimpleArrayMap();
    }

    private LocationManagerCompat() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean isLocationEnabled(LocationManager locationManager) {
        String string2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return LocationManagerCompat$Api28Impl.isLocationEnabled(locationManager);
        }
        n11 = 19;
        boolean bl2 = false;
        boolean bl3 = true;
        if (n10 <= n11) {
            try {
                String string3;
                Object object = sContextField;
                if (object == null) {
                    object = LocationManager.class;
                    String string4 = "mContext";
                    sContextField = object = ((Class)object).getDeclaredField(string4);
                }
                object = sContextField;
                ((Field)object).setAccessible(bl3);
                object = sContextField;
                object = ((Field)object).get(locationManager);
                object = (Context)object;
                if (n10 != n11) {
                    Object object2 = object.getContentResolver();
                    String string5 = "location_providers_allowed";
                    object2 = Settings.Secure.getString((ContentResolver)object2, (String)string5);
                    return TextUtils.isEmpty((CharSequence)object2) ^ bl3;
                }
                ContentResolver contentResolver = object.getContentResolver();
                int n12 = Settings.Secure.getInt((ContentResolver)contentResolver, (String)(string3 = "location_mode"), (int)0);
                if (n12 == 0) return bl2;
                return bl3;
            }
            catch (ClassCastException | IllegalAccessException | NoSuchFieldException | SecurityException exception) {}
        }
        if ((n10 = (int)(locationManager.isProviderEnabled(string2 = "network") ? 1 : 0)) != 0) return bl3;
        string2 = "gps";
        boolean bl4 = locationManager.isProviderEnabled(string2);
        if (!bl4) return bl2;
        return bl3;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private static boolean registerGnssStatusCallback(LocationManager var0, Handler var1_1, Executor var2_9, GnssStatusCompat$Callback var3_14) {
        var4_18 = Build.VERSION.SDK_INT;
        var5_19 = true;
        var6_20 = 1.4E-45f;
        var7_21 = 30 != 0;
        if (var4_18 >= var7_21) {
            var8_22 = LocationManagerCompat.sGnssStatusListeners;
            synchronized (var8_22) {
                var1_4 = var8_22.get(var3_17);
                var1_4 = (LocationManagerCompat$GnssStatusTransport)var1_4;
                if (var1_4 == null) {
                    var1_4 = new LocationManagerCompat$GnssStatusTransport((GnssStatusCompat$Callback)var3_17);
                }
                if (var9_25 = var0.registerGnssStatusCallback((Executor)var2_12, (GnssStatus.Callback)var1_4)) {
                    var8_22.put(var3_17, var1_4);
                    return var5_19;
                }
                return false;
                catch (Throwable var0_1) {}
                {
                    throw var0_1;
                }
            }
        }
        var7_21 = 24 != 0;
        if (var4_18 >= var7_21) {
            if (var1_4 != null) {
                var4_18 = var5_19;
            } else {
                var4_18 = false;
                var10_28 = null;
            }
            Preconditions.checkArgument(var4_18);
            var10_28 = LocationManagerCompat.sGnssStatusListeners;
            synchronized (var10_28) {
                var8_23 = var10_28.get(var3_17);
                var8_23 = (LocationManagerCompat$PreRGnssStatusTransport)var8_23;
                if (var8_23 == null) {
                    var8_23 = new LocationManagerCompat$PreRGnssStatusTransport((GnssStatusCompat$Callback)var3_17);
                } else {
                    var8_23.unregister();
                }
                var8_23.register((Executor)var2_12);
                var9_26 = var0.registerGnssStatusCallback((GnssStatus.Callback)var8_23, (Handler)var1_4);
                if (var9_26) {
                    var10_28.put(var3_17, var8_23);
                    return var5_19;
                }
                return false;
                catch (Throwable var0_2) {}
                {
                    throw var0_2;
                }
            }
        }
        if (var1_4 != null) {
            var4_18 = var5_19;
        } else {
            var4_18 = false;
            var10_29 = null;
        }
        Preconditions.checkArgument(var4_18);
        var10_29 = LocationManagerCompat.sGnssStatusListeners;
        synchronized (var10_29) {
            block45: {
                block43: {
                    var8_24 = var10_29.get(var3_17);
                    var8_24 = (LocationManagerCompat$GpsStatusTransport)var8_24;
                    if (var8_24 == null) {
                        var8_24 = new LocationManagerCompat$GpsStatusTransport((LocationManager)var0, (GnssStatusCompat$Callback)var3_17);
                    } else {
                        var8_24.unregister();
                    }
                    var8_24.register((Executor)var2_12);
                    var11_30 = new LocationManagerCompat$1((LocationManager)var0, (LocationManagerCompat$GpsStatusTransport)var8_24);
                    var2_12 = new FutureTask(var11_30);
                    var0 = Looper.myLooper();
                    var11_30 = var1_4.getLooper();
                    if (var0 != var11_30) ** GOTO lbl70
                    var2_12.run();
                    break block43;
lbl70:
                    // 1 sources

                    var9_27 = var1_4.post(var2_12);
                    if (!var9_27) ** GOTO lbl169
                }
                try {
                    var0 = TimeUnit.SECONDS;
                    var12_31 = 4;
                    var12_31 = var0.toNanos(var12_31);
                    var14_32 = System.nanoTime() + var12_31;
                    var9_27 = false;
                    var0 = null;
                    var16_33 = 0.0f;
                }
                catch (Throwable var1_8) {
                    var5_19 = false;
                    var6_20 = 0.0f;
                    break block45;
                }
                catch (TimeoutException var2_15) {
                    var5_19 = false;
                    var6_20 = 0.0f;
                }
                while (true) {
                    var17_34 = TimeUnit.NANOSECONDS;
                    var11_30 = var2_12.get(var12_31, var17_34);
                    var11_30 = (Boolean)var11_30;
                    var18_35 = var11_30.booleanValue();
                    if (!var18_35) ** GOTO lbl96
                    var11_30 = LocationManagerCompat.sGnssStatusListeners;
                    var11_30.put(var3_17, var8_24);
                    if (!var9_27) ** GOTO lbl95
                    var0 = Thread.currentThread();
                    var0.interrupt();
lbl95:
                    // 2 sources

                    return var5_19;
lbl96:
                    // 1 sources

                    if (var9_27) {
                        var0 = Thread.currentThread();
                        var0.interrupt();
                    }
                    return false;
                    catch (Throwable var1_5) {
                        var5_19 = var9_27;
                        var6_20 = var16_33;
                    }
                    catch (TimeoutException var2_13) {
                        var5_19 = var9_27;
                        var6_20 = var16_33;
                        break;
                    }
                    catch (ExecutionException var1_6) {
                        var5_19 = var9_27;
                        var6_20 = var16_33;
                        ** GOTO lbl145
                    }
                    catch (InterruptedException v0) {
                        try {
                            var12_31 = System.nanoTime();
                            var12_31 = var14_32 - var12_31;
                            var9_27 = var5_19;
                            var16_33 = var6_20;
                        }
                        catch (TimeoutException var2_14) {
                            break;
                        }
                        catch (ExecutionException var1_7) {
                            ** GOTO lbl145
                        }
                    }
                }
                var3_17 = new StringBuilder();
                var3_17.append(var1_4);
                var1_4 = " appears to be blocked, please run registerGnssStatusCallback() directly on a Looper thread or ensure the main Looper is not blocked by this thread";
                var3_17.append((String)var1_4);
                var1_4 = var3_17.toString();
                var0 = new IllegalStateException((String)var1_4, (Throwable)var2_16);
                throw var0;
                catch (ExecutionException var1_9) {
                    var5_19 = false;
                    var6_20 = 0.0f;
                }
lbl145:
                // 3 sources

                var0 = var1_4.getCause();
                var9_27 = var0 instanceof RuntimeException;
                if (var9_27) ** GOTO lbl158
                var0 = var1_4.getCause();
                var9_27 = var0 instanceof Error;
                if (!var9_27) ** GOTO lbl156
                var0 = var1_4.getCause();
                var0 = (Error)var0;
                throw var0;
lbl156:
                // 1 sources

                var0 = new IllegalStateException((Throwable)var1_4);
                throw var0;
lbl158:
                // 1 sources

                var0 = var1_4.getCause();
                var0 = (RuntimeException)var0;
                throw var0;
                {
                    catch (Throwable var1_10) {
                        // empty catch block
                    }
                }
            }
            if (!var5_19) ** GOTO lbl168
            var0 = Thread.currentThread();
            var0.interrupt();
lbl168:
            // 2 sources

            throw var1_11;
lbl169:
            // 1 sources

            var2_12 = new StringBuilder();
            var2_12.append(var1_4);
            var1_4 = " is shutting down";
            var2_12.append((String)var1_4);
            var1_4 = var2_12.toString();
            var0 = new IllegalStateException((String)var1_4);
            throw var0;
            catch (Throwable var0_3) {}
            {
                throw var0_3;
            }
        }
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, GnssStatusCompat$Callback gnssStatusCompat$Callback, Handler object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            object = ExecutorCompat.create(object);
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, (Executor)object, gnssStatusCompat$Callback);
        }
        LocationManagerCompat$InlineHandlerExecutor locationManagerCompat$InlineHandlerExecutor = new LocationManagerCompat$InlineHandlerExecutor((Handler)object);
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, locationManagerCompat$InlineHandlerExecutor, gnssStatusCompat$Callback);
    }

    public static boolean registerGnssStatusCallback(LocationManager locationManager, Executor executor, GnssStatusCompat$Callback gnssStatusCompat$Callback) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            return LocationManagerCompat.registerGnssStatusCallback(locationManager, null, executor, gnssStatusCompat$Callback);
        }
        Looper looper = Looper.myLooper();
        if (looper == null) {
            looper = Looper.getMainLooper();
        }
        Handler handler = new Handler(looper);
        return LocationManagerCompat.registerGnssStatusCallback(locationManager, handler, executor, gnssStatusCompat$Callback);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void unregisterGnssStatusCallback(LocationManager locationManager, GnssStatusCompat$Callback object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            SimpleArrayMap simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                object = simpleArrayMap.remove(object);
                object = (LocationManagerCompat$GnssStatusTransport)((Object)object);
                if (object == null) return;
                locationManager.unregisterGnssStatusCallback((GnssStatus.Callback)object);
                return;
            }
        }
        n11 = 24;
        if (n10 >= n11) {
            SimpleArrayMap simpleArrayMap = sGnssStatusListeners;
            synchronized (simpleArrayMap) {
                object = simpleArrayMap.remove(object);
                object = (LocationManagerCompat$PreRGnssStatusTransport)((Object)object);
                if (object == null) return;
                ((LocationManagerCompat$PreRGnssStatusTransport)((Object)object)).unregister();
                locationManager.unregisterGnssStatusCallback((GnssStatus.Callback)object);
                return;
            }
        }
        SimpleArrayMap simpleArrayMap = sGnssStatusListeners;
        synchronized (simpleArrayMap) {
            object = simpleArrayMap.remove(object);
            object = (LocationManagerCompat$GpsStatusTransport)object;
            if (object == null) return;
            ((LocationManagerCompat$GpsStatusTransport)object).unregister();
            locationManager.removeGpsStatusListener((GpsStatus.Listener)object);
            return;
        }
    }
}

