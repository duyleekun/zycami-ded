/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 */
package com.baidu.location.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.baidu.location.f;
import com.baidu.location.indoor.g;
import com.baidu.location.indoor.mapversion.IndoorJni;

public class s
implements SensorEventListener {
    private static s d;
    private float[] a;
    private float[] b;
    private SensorManager c;
    private float e;
    private boolean f = false;
    private boolean g = false;
    private boolean h = false;

    private s() {
    }

    public static s a() {
        Class<s> clazz = s.class;
        synchronized (clazz) {
            s s10 = d;
            if (s10 == null) {
                d = s10 = new s();
            }
            s10 = d;
            return s10;
        }
    }

    public void a(boolean bl2) {
        this.f = bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b() {
        synchronized (this) {
            SensorManager sensorManager;
            boolean bl2 = this.h;
            if (bl2) {
                return;
            }
            bl2 = this.f;
            if (!bl2) {
                return;
            }
            SensorManager sensorManager2 = this.c;
            if (sensorManager2 == null) {
                SensorManager sensorManager3;
                Context context = com.baidu.location.f.getServiceContext();
                String string2 = "sensor";
                Object object = context.getSystemService(string2);
                this.c = sensorManager3 = (SensorManager)object;
            }
            if ((sensorManager = this.c) != null) {
                SensorManager sensorManager4;
                Sensor sensor;
                SensorManager sensorManager5;
                int n10;
                int n11 = 11;
                Sensor sensor2 = sensorManager.getDefaultSensor(n11);
                n11 = 3;
                if (sensor2 != null && (n10 = this.f) != 0) {
                    sensorManager5 = this.c;
                    sensorManager5.registerListener((SensorEventListener)this, sensor2, n11);
                }
                if ((sensor = (sensorManager4 = this.c).getDefaultSensor(n10 = 2)) != null && (n10 = (int)(this.f ? 1 : 0)) != 0) {
                    sensorManager5 = this.c;
                    sensorManager5.registerListener((SensorEventListener)this, sensor, n11);
                }
            }
            this.h = bl2 = true;
            return;
        }
    }

    public void b(boolean bl2) {
        this.g = bl2;
    }

    public void c() {
        synchronized (this) {
            SensorManager sensorManager;
            boolean bl2;
            block8: {
                block7: {
                    bl2 = this.h;
                    if (bl2) break block7;
                    return;
                }
                sensorManager = this.c;
                if (sensorManager == null) break block8;
                sensorManager.unregisterListener((SensorEventListener)this);
                bl2 = false;
                sensorManager = null;
                this.c = null;
            }
            bl2 = false;
            sensorManager = null;
            this.h = false;
            return;
        }
    }

    public boolean d() {
        return this.f;
    }

    public float e() {
        return this.e;
    }

    public void onAccuracyChanged(Sensor sensor, int n10) {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSensorChanged(SensorEvent object) {
        Sensor sensor = ((SensorEvent)object).sensor;
        int n10 = sensor.getType();
        int n11 = 0;
        float f10 = 0.0f;
        int n12 = 2;
        if (n10 != n12) {
            float f11;
            n12 = 11;
            if (n10 != n12) {
                return;
            }
            object = (float[])((SensorEvent)object).values.clone();
            this.a = (float[])object;
            if (object == null) return;
            n10 = 9;
            float f12 = 1.3E-44f;
            float[] fArray = new float[n10];
            n12 = 0;
            try {
                SensorManager.getRotationMatrixFromVector((float[])fArray, (float[])object);
                int n13 = 3;
                f11 = 4.2E-45f;
                object = new float[n13];
                SensorManager.getOrientation((float[])fArray, (float[])object);
                f11 = (float)object[0];
            }
            catch (Exception exception) {
                this.e = 0.0f;
                return;
            }
            double d10 = f11;
            d10 = Math.toDegrees(d10);
            f11 = (float)d10;
            this.e = f11;
            float f13 = f11 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 < 0) {
                n10 = 1135869952;
                f12 = 360.0f;
                f11 += f12;
            }
            d10 = f11;
            d10 = Math.floor(d10);
            f11 = (float)d10;
            this.e = f11;
            return;
        }
        object = (float[])((SensorEvent)object).values.clone();
        this.b = (float[])object;
        reference var7_10 = object[0];
        f10 = (float)object[0];
        var7_10 *= f10;
        n11 = 1;
        reference var12_17 = object[n11];
        f10 = (float)object[n11];
        var7_10 += (var12_17 *= f10);
        f10 = (float)object[n12];
        SensorEvent sensorEvent = object[n12];
        double d11 = Math.sqrt((double)(var7_10 += (f10 *= sensorEvent)));
        object = this.b;
        if (object == null) return;
        try {
            object = com.baidu.location.indoor.g.a();
            boolean bl2 = ((g)object).e();
            if (!bl2) return;
            IndoorJni.setPfGeomag(d11);
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

