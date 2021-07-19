/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.Sensor
 *  android.hardware.SensorEvent
 *  android.hardware.SensorEventListener
 */
package d.v.b0.e;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import d.v.b0.e.a;

public class a$a
implements SensorEventListener {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    public void onAccuracyChanged(Sensor sensor, int n10) {
    }

    public void onSensorChanged(SensorEvent object) {
        Sensor sensor = ((SensorEvent)object).sensor;
        int n10 = sensor.getType();
        Object object2 = 1;
        float f10 = Float.MIN_VALUE;
        if (n10 == object2) {
            reference cfr_temp_1;
            float f11;
            object = ((SensorEvent)object).values;
            n10 = 0;
            sensor = null;
            reference var6_6 = object[0];
            f10 = (float)object[object2];
            reference var7_7 = object[2];
            var7_7 = (reference)Math.abs((float)var6_6);
            reference cfr_temp_0 = var7_7 - (f11 = 3.0f);
            Object object3 = cfr_temp_0 == 0 ? 0 : (cfr_temp_0 > 0 ? 1 : -1);
            if (object3 > 0 || (object3 = (cfr_temp_1 = (var7_7 = (reference)Math.abs(f10)) - f11) == 0 ? 0 : (cfr_temp_1 > 0 ? 1 : -1)) > 0) {
                var7_7 = (reference)Math.abs((float)var6_6);
                f11 = Math.abs(f10);
                object3 = var7_7 == f11 ? 0 : (var7_7 > f11 ? 1 : -1);
                f11 = 0.0f;
                if (object3 > 0) {
                    object = this.a;
                    reference cfr_temp_2 = var6_6 - 0.0f;
                    object2 = cfr_temp_2 == 0 ? 0 : (cfr_temp_2 > 0 ? 1 : -1);
                    if (object2 <= 0) {
                        n10 = 180;
                    }
                    ((a)object).t(n10);
                } else {
                    object = this.a;
                    float f12 = f10 - 0.0f;
                    n10 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
                    n10 = n10 > 0 ? 90 : 270;
                    ((a)object).t(n10);
                }
            }
        }
    }
}

