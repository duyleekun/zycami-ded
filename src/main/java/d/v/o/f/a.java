/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 */
package d.v.o.f;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import d.v.o.f.a$a;
import d.v.o.f.b;
import d.v.o.f.c;
import d.v.o.f.d;

public abstract class a
implements b {
    private Context a = null;
    private SensorManager b;
    private Sensor c;
    public int d;
    public c e;
    public String f;
    public d g;
    private SensorEventListener h;

    public a(Context context) {
        int n10;
        this.d = n10 = 90;
        this.e = null;
        this.f = null;
        this.g = null;
        a$a a$a = new a$a(this);
        this.h = a$a;
        if (context != null) {
            this.a = context = context.getApplicationContext();
            this.q(context);
        }
    }

    private void q(Context context) {
        context = (SensorManager)context.getSystemService("sensor");
        this.b = context;
        context = context.getDefaultSensor(1);
        this.c = context;
        SensorManager sensorManager = this.b;
        SensorEventListener sensorEventListener = this.h;
        sensorManager.registerListener(sensorEventListener, (Sensor)context, 3);
    }

    private void s() {
        SensorManager sensorManager = this.b;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.h;
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    public int c() {
        return this.d;
    }

    public void d(String string2) {
        this.f = string2;
    }

    public void k(d d10) {
        this.g = d10;
    }

    public void m(c c10) {
        this.e = c10;
    }

    public void r(int n10) {
        this.d = n10;
    }

    public void release() {
        this.s();
    }
}

