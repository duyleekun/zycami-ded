/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 */
package com.baidu.location.indoor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.location.indoor.mapversion.a;
import com.baidu.location.indoor.n;

public class o
implements SensorEventListener {
    public final /* synthetic */ n a;

    public o(n n10) {
        this.a = n10;
    }

    public void onAccuracyChanged(Sensor sensor, int n10) {
    }

    public void onSensorChanged(SensorEvent object) {
        Object object2 = object.sensor;
        int n10 = object2.getType();
        int n11 = 20;
        Object object3 = 2.8E-44f;
        int n12 = 2;
        int n13 = 1;
        if (n10 != n13) {
            int n14 = 3;
            float f10 = 4.2E-45f;
            if (n10 != n14) {
                n11 = 4;
                object3 = 5.6E-45f;
                if (n10 == n11) {
                    object2 = (float[])object.values.clone();
                    n n15 = this.a;
                    n12 = (int)(n.a(n15) ? 1 : 0);
                    if (n12 != 0 && (n12 = (int)(com.baidu.location.indoor.mapversion.a.b() ? 1 : 0)) != 0) {
                        long l10 = object.timestamp;
                        com.baidu.location.indoor.mapversion.a.a(n11, (float[])object2, l10);
                    }
                }
            } else {
                object2 = (float[])object.values.clone();
                n n16 = this.a;
                n14 = (int)(n.a(n16) ? 1 : 0);
                if (n14 != 0 && (n14 = (int)(com.baidu.location.indoor.mapversion.a.b() ? 1 : 0)) != 0) {
                    n14 = 5;
                    f10 = 7.0E-45f;
                    long l11 = object.timestamp;
                    com.baidu.location.indoor.mapversion.a.a(n14, (float[])object2, l11);
                }
                object = n.d(this.a);
                n14 = n.e(this.a);
                Sensor sensor = object2[0];
                Object object4 = (double)sensor;
                object[n14] = (SensorEvent)object4;
                n.f(this.a);
                object = this.a;
                int n17 = n.e((n)object);
                n16 = this.a;
                n14 = n.g(n16);
                if (n17 == n14) {
                    object = this.a;
                    n.b((n)object, 0);
                }
                if ((n17 = n.h((n)(object = this.a))) >= n11) {
                    Object object5;
                    object = this.a;
                    n11 = (int)(n.i((n)object) ? 1 : 0);
                    n.a((n)object, n11 != 0);
                    object = this.a;
                    n17 = (int)(n.j((n)object) ? 1 : 0);
                    if (n17 == 0) {
                        object = n.l(this.a);
                        object5 = this.a;
                        n16 = ((n)object5).b;
                        object5 = n.k((n)object5);
                        object.unregisterListener((SensorEventListener)n16, (Sensor)object5);
                    }
                    object = n.m(this.a);
                    n16 = this.a;
                    object5 = n.m(n16);
                    object4 = object5[0];
                    double d10 = (double)object2[0];
                    double d11 = 0.7;
                    double d12 = n.a(n16, object4, d10, d11);
                    object[0] = (SensorEvent)d12;
                    object = n.m(this.a);
                    object3 = object2[n13];
                    double d13 = object3;
                    object[n13] = (SensorEvent)d13;
                    object = n.m(this.a);
                    Sensor sensor2 = object2[n12];
                    double d14 = (double)sensor2;
                    object[n12] = (SensorEvent)d14;
                }
            }
        } else {
            object2 = (float[])object.values.clone();
            n n18 = this.a;
            float[] fArray = (float[])object2.clone();
            n.a(n18, fArray);
            n18 = this.a;
            boolean bl2 = n.a(n18);
            if (bl2 && (bl2 = com.baidu.location.indoor.mapversion.a.b())) {
                long l12 = object.timestamp;
                com.baidu.location.indoor.mapversion.a.a(n13, (float[])object2, l12);
            }
            object = this.a;
            Sensor sensor = object2[0];
            Sensor sensor3 = object2[n13];
            reference var29_30 = object2[n12];
            object = n.a((n)object, (float)sensor, (float)sensor3, (float)var29_30);
            object2 = this.a;
            n10 = n.b((n)object2);
            if (n10 >= n11) {
                var29_30 = object[0];
                object3 = object[0];
                var29_30 *= object3;
                object3 = object[n13];
                sensor = object[n13];
                var29_30 += (object3 *= sensor);
                object3 = object[n12];
                SensorEvent sensorEvent = object[n12];
                double d15 = (double)(var29_30 += (object3 *= sensorEvent));
                object = this.a;
                int n19 = n.c((n)object);
                if (n19 == 0) {
                    double d16 = 4.0;
                    double d10 = d15 - d16;
                    n19 = (int)(d10 == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1));
                    if (n19 > 0) {
                        object = this.a;
                        n.a((n)object, n13);
                    }
                } else {
                    long l13 = 4576918229175238656L;
                    double d18 = 0.01f;
                    double d11 = d15 - d18;
                    n19 = (int)(d11 == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1));
                    if (n19 < 0) {
                        object = this.a;
                        n.a((n)object, 0);
                    }
                }
            }
        }
    }
}

