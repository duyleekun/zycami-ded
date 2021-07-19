/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.Sensor
 *  android.hardware.SensorEventListener
 *  android.hardware.SensorManager
 */
package d.v.b0.e;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.zhiyun.renderengine.bean.TextureFormat;
import com.zhiyun.renderengine.engine.IRenderEngine;
import com.zhiyun.renderengine.engine.IRenderEngine$RenderMode;
import d.v.b0.d.d;
import d.v.b0.f.b;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class a
implements IRenderEngine {
    public IRenderEngine$RenderMode a;
    public int b;
    public b c;
    public Context d;
    public int e;
    private SensorManager f;
    private Sensor g;
    public List h;
    private SensorEventListener i;

    public a() {
        Object object;
        this.a = object = IRenderEngine$RenderMode.RENDER_SELECT_EFFECT;
        this.b = -1;
        this.e = 0;
        super(this);
        this.i = object;
    }

    private void s(Context context) {
        context = (SensorManager)context.getSystemService("sensor");
        this.f = context;
        context = context.getDefaultSensor(1);
        this.g = context;
        SensorManager sensorManager = this.f;
        SensorEventListener sensorEventListener = this.i;
        sensorManager.registerListener(sensorEventListener, (Sensor)context, 3);
    }

    private void u() {
        SensorManager sensorManager = this.f;
        if (sensorManager != null) {
            SensorEventListener sensorEventListener = this.i;
            sensorManager.unregisterListener(sensorEventListener);
        }
    }

    public void b(int n10) {
        this.b = n10;
    }

    public d c(int n10) {
        boolean bl2;
        Iterator iterator2 = this.h.iterator();
        while (bl2 = iterator2.hasNext()) {
            int n11;
            d d10 = (d)iterator2.next();
            if (d10 == null || n10 != (n11 = d10.q())) continue;
            return d10;
        }
        return null;
    }

    public List d() {
        return this.h;
    }

    public int e(byte[] byArray, TextureFormat textureFormat, int n10, boolean bl2, int n11, int n12) {
        return -1;
    }

    public boolean f(d d10) {
        this.h.remove(d10);
        return false;
    }

    public int g(byte[] byArray, TextureFormat textureFormat, int n10, int n11) {
        return -1;
    }

    public int getDeviceOrientation() {
        return this.e;
    }

    public int h(int n10, int n11, int n12) {
        return -1;
    }

    public boolean i() {
        this.h.clear();
        return false;
    }

    public boolean k(Context context) {
        LinkedList linkedList;
        this.h = linkedList = new LinkedList();
        this.d = context = context.getApplicationContext();
        this.s(context);
        return true;
    }

    public boolean n() {
        this.u();
        return true;
    }

    public void p(IRenderEngine$RenderMode iRenderEngine$RenderMode) {
        this.a = iRenderEngine$RenderMode;
    }

    public void q(b b10) {
        this.c = b10;
    }

    public boolean r(d d10) {
        if (d10 != null) {
            List list = this.h;
            list.add(d10);
        }
        return false;
    }

    public abstract void t(int var1);
}

