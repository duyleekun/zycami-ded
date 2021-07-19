/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 *  android.util.Log
 */
package com.geetest.sdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.geetest.sdk.utils.l;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class at
implements SensorEventListener {
    private static final String g = at.class.getSimpleName();
    private SensorManager a;
    private final List b;
    private float c;
    private final float[] d;
    private boolean e;
    private int f;

    public at(Context object) {
        Object object2 = new ArrayList();
        this.b = object2;
        object2 = new float[3];
        this.d = (float[])object2;
        object2 = null;
        this.e = false;
        this.f = 0;
        String string2 = "sensor";
        object = (SensorManager)object.getSystemService(string2);
        this.a = object;
        int n10 = -1;
        object = object.getSensorList(n10);
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            int n11;
            string2 = (Sensor)object.get(i10);
            n10 = string2.getType();
            if (n10 != (n11 = 4)) continue;
            n10 = 1;
            this.e = n10;
        }
    }

    private String d() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        Integer n10 = 0;
        arrayList.add(n10);
        arrayList.add(n10);
        arrayList.add(n10);
        arrayList.add(n10);
        return ((Object)arrayList).toString();
    }

    public String a() {
        int n10 = this.e;
        if (n10 == 0) {
            return null;
        }
        List list = this.b;
        n10 = list.size();
        if (n10 == 0) {
            list = this.b;
            String string2 = this.d();
            list.add(0, string2);
            return this.b.toString();
        }
        return this.b.toString();
    }

    public void b() {
        SensorManager sensorManager = null;
        this.f = 0;
        boolean bl2 = this.e;
        if (bl2) {
            sensorManager = this.a;
            int n10 = 4;
            if ((sensorManager = sensorManager.getDefaultSensor(n10)) != null) {
                SensorManager sensorManager2 = this.a;
                int n11 = 2;
                sensorManager2.registerListener((SensorEventListener)this, (Sensor)sensorManager, n11);
            }
        }
    }

    public void c() {
        Object object = this.b;
        object.clear();
        boolean bl2 = this.e;
        if (bl2) {
            object = g;
            CharSequence charSequence = new StringBuilder();
            String string2 = "GT3SensorManager-->unregisterSensor";
            charSequence.append(string2);
            int n10 = this.hashCode();
            charSequence.append(n10);
            charSequence = charSequence.toString();
            l.b((String)object, (String)charSequence);
            object = this.a;
            object.unregisterListener((SensorEventListener)this);
        }
    }

    public void onAccuracyChanged(Sensor sensor, int n10) {
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        block41: {
            float f10;
            block42: {
                int n10;
                int n11;
                Object object;
                block44: {
                    double d10;
                    float f11;
                    float f12;
                    int n12;
                    Object object2;
                    Object object3;
                    float f13;
                    block43: {
                        object = sensorEvent.sensor;
                        n11 = object.getType();
                        if (n11 != (n10 = 4)) break block41;
                        f13 = this.c;
                        float f14 = f13 - 0.0f;
                        object3 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                        if (object3 == false) break block42;
                        object3 = true;
                        object2 = sensorEvent.values;
                        n12 = 2;
                        f12 = 2.8E-45f;
                        f11 = object2[n12];
                        double d11 = f11;
                        d10 = 0.15;
                        double d12 = d11 == d10 ? 0 : (d11 > d10 ? 1 : -1);
                        if (d12 > 0) break block43;
                        f11 = (float)object2[n12];
                        d11 = f11;
                        d10 = -0.15;
                        d12 = d11 == d10 ? 0 : (d11 < d10 ? -1 : 1);
                        if (d12 >= 0) break block44;
                    }
                    long l10 = sensorEvent.timestamp;
                    f11 = (float)l10 - f13;
                    n11 = 814313567;
                    f13 = 1.0E-9f;
                    f11 *= f13;
                    object = this.d;
                    reference var18_16 = object[0];
                    reference var19_17 = object2[0] * f11;
                    var18_16 += var19_17;
                    object[0] = var18_16;
                    var18_16 = object[object3];
                    var19_17 = object2[object3] * f11;
                    var18_16 += var19_17;
                    object[object3] = var18_16;
                    var18_16 = object[n12];
                    Object object4 = object2[n12] * f11;
                    var18_16 += object4;
                    object[n12] = var18_16;
                    f13 = (float)object[0];
                    d10 = f13;
                    d10 = Math.toDegrees(d10);
                    f13 = (float)d10;
                    object2 = this.d;
                    object4 = object2[object3];
                    d10 = (double)object4;
                    d10 = Math.toDegrees(d10);
                    object4 = d10;
                    Object object5 = this.d;
                    f12 = object5[n12];
                    d10 = f12;
                    d10 = Math.toDegrees(d10);
                    f12 = (float)d10;
                    object5 = new ArrayList;
                    ((ArrayList)object5)();
                    object5.clear();
                    double d13 = f13;
                    BigDecimal bigDecimal = new BigDecimal(d13);
                    object = bigDecimal.setScale(0, n10);
                    object5.add(object);
                    double d14 = (double)object4;
                    object = new BigDecimal(d14);
                    object = ((BigDecimal)object).setScale(0, n10);
                    object5.add(object);
                    double d15 = f12;
                    object = new BigDecimal(d15);
                    object = ((BigDecimal)object).setScale(0, n10);
                    object5.add(object);
                    object4 = 1000.0f;
                    d15 = f11 *= object4;
                    object = new BigDecimal(d15);
                    object = ((BigDecimal)object).setScale(0, n10);
                    object5.add(object);
                    object = this.b;
                    String string2 = object5.toString();
                    object.add(string2);
                    n11 = this.f + object3;
                    try {
                        this.f = n11;
                    }
                    catch (Exception exception) {
                        string2 = g;
                        object2 = new StringBuilder;
                        object2();
                        object2.append("Exception: ");
                        String string3 = exception.toString();
                        object2.append(string3);
                        object2 = object2.toString();
                        Log.e((String)string2, (String)object2);
                        exception.printStackTrace();
                        this.f = n11 = this.f + object3;
                    }
                }
                if ((n11 = this.f) > (n10 = 25) && (n11 = (int)(this.e ? 1 : 0)) != 0) {
                    object = this.a;
                    object.unregisterListener((SensorEventListener)this);
                }
            }
            long l11 = sensorEvent.timestamp;
            this.c = f10 = (float)l11;
        }
    }
}

