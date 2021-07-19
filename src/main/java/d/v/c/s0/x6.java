/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Range
 */
package d.v.c.s0;

import android.util.Range;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.x1.o;
import d.v.e.i.h;
import java.math.BigDecimal;
import java.util.Arrays;
import m.a.a;

public class x6 {
    private final MutableLiveData a;
    private final MutableLiveData b;
    private final MutableLiveData c;
    private final MutableLiveData d;
    private final MutableLiveData e;
    private final MutableLiveData f;
    private final MutableLiveData g;
    private float[] h;
    private float[] i;
    private Range j;
    private Range k;
    private float[] l;
    private Range m;
    private boolean n;

    public x6() {
        MutableLiveData mutableLiveData;
        Float f10 = Float.valueOf(0.0f);
        this.a = mutableLiveData = new MutableLiveData(f10);
        this.b = mutableLiveData = new MutableLiveData();
        this.c = mutableLiveData = new MutableLiveData();
        this.d = mutableLiveData = new MutableLiveData();
        this.e = mutableLiveData = new MutableLiveData();
        this.f = mutableLiveData = new MutableLiveData();
        this.g = mutableLiveData = new MutableLiveData();
        this.n = true;
    }

    private float e(int n10) {
        float f10 = (float)n10 * 1.0f;
        float f11 = this.d();
        return f10 / f11;
    }

    private Range f(float[] object) {
        Float f10 = Float.valueOf(object[0]);
        int n10 = ((float[])object).length + -1;
        object = Float.valueOf(object[n10]);
        Range range = new Range((Comparable)f10, (Comparable)object);
        return range;
    }

    private Float p(int n10, float[] fArray, float[] fArray2) {
        return o.b(this.e(n10), fArray2, fArray);
    }

    private void r(float f10) {
        Float f11;
        Object object = this.k;
        if (object == null) {
            return;
        }
        Float f12 = Float.valueOf(f10);
        boolean bl2 = object.contains((Comparable)f12);
        if (!bl2) {
            Float f13;
            float f14;
            f12 = (Float)object.getLower();
            float f15 = f12.floatValue();
            float f16 = (f15 = Math.abs(f10 - f15)) - (f10 = Math.abs(f10 - (f14 = (f13 = (Float)object.getUpper()).floatValue())));
            Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object2 > 0) {
                f11 = (Float)object.getUpper();
                f10 = f11.floatValue();
            } else {
                f11 = (Float)object.getLower();
                f10 = f11.floatValue();
            }
        }
        object = this.a;
        f11 = Float.valueOf(f10);
        d.v.e.i.h.d((MutableLiveData)object, f11);
    }

    private float[] u(float[] object) {
        float f10 = 0.0f;
        float[] fArray = null;
        if (object != null) {
            float f11;
            int n10;
            float f12;
            float f13;
            Object object2;
            int n11 = ((float[])object).length;
            int n12 = 1;
            int n13 = 2;
            if (n11 >= n13 && (object2 = (f13 = (f12 = object[n10 = ((float[])object).length - n12]) - (f11 = object[0])) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0) {
                f10 = 1.0f;
                float f14 = f12 - f10;
                object2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
                if (object2 > 0 && (object2 = f11 == f10 ? 0 : (f11 > f10 ? 1 : -1)) < 0) {
                    object2 = 3;
                    float[] fArray2 = new float[object2];
                    fArray2[0] = f11;
                    fArray2[n12] = f10;
                    fArray2[n13] = f12;
                    fArray = fArray2;
                } else {
                    fArray = new float[n13];
                    fArray[0] = f11;
                    fArray[n12] = f12;
                }
            }
            Object[] objectArray = new Object[n13];
            objectArray[0] = object;
            objectArray[n12] = fArray;
            object = "translateData, pre: %s, cur: %s";
            m.a.a.b((String)object, objectArray);
        }
        return fArray;
    }

    private float[] v(float[] objectArray) {
        int n10 = objectArray.length;
        float[] fArray = new float[n10];
        int n11 = n10 + -1;
        int n12 = 5;
        if (n11 >= n12) {
            n12 = n11;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            float f10 = 1.0f;
            if (i10 == n11) {
                fArray[i10] = f10;
                continue;
            }
            float f11 = (float)i10 * f10;
            f10 = n12;
            fArray[i10] = f11 /= f10;
        }
        objectArray = new Object[1];
        String string2 = Arrays.toString(fArray);
        objectArray[0] = (float)string2;
        m.a.a.b("mZoomPointProgressArrayLiveData: %s", objectArray);
        return fArray;
    }

    private Range w(Range object) {
        float f10 = ((Float)object.getLower()).floatValue();
        int n10 = this.x(f10);
        f10 = this.e(n10);
        float f11 = ((Float)object.getUpper()).floatValue();
        int n11 = this.x(f11);
        f11 = this.e(n11);
        Range range = new Object[2];
        Float f12 = Float.valueOf(f10);
        range[0] = f12;
        f12 = Float.valueOf(f11);
        range[1] = f12;
        m.a.a.b("mZoomProgressRangeLiveData, lower:%s, upper:%s", (Object[])range);
        Float f13 = Float.valueOf(f10);
        object = Float.valueOf(f11);
        range = new Range((Comparable)f13, (Comparable)object);
        return range;
    }

    public void a(float f10, int n10) {
        float f11 = this.d();
        float f12 = n10;
        int n11 = (int)((f10 *= f11) + f12);
        this.t(n11);
    }

    public MutableLiveData b() {
        return this.c;
    }

    public MutableLiveData c() {
        return this.e;
    }

    public int d() {
        return 1000;
    }

    public MutableLiveData g() {
        return this.b;
    }

    public MutableLiveData h() {
        return this.d;
    }

    public MutableLiveData i() {
        return this.a;
    }

    public LiveData j() {
        return this.g;
    }

    public LiveData k() {
        return this.f;
    }

    public String l(double d10) {
        int n10 = 1;
        Object object = new Object[n10];
        Number number = d10;
        object[0] = number;
        m.a.a.b("getZoomString, zoom: %s", (Object[])object);
        object = new StringBuilder();
        number = new BigDecimal(d10);
        float f10 = ((BigDecimal)number).setScale(n10, 4).floatValue();
        ((StringBuilder)object).append(f10);
        ((StringBuilder)object).append("X");
        return ((StringBuilder)object).toString();
    }

    public boolean m() {
        boolean bl2;
        Object object = this.j().getValue();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean n() {
        boolean bl2;
        Object object = this.i().getValue();
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Float o(int n10) {
        float[] fArray = this.h;
        float[] fArray2 = this.l;
        return this.p(n10, fArray, fArray2);
    }

    public void q(boolean bl2) {
        this.n = bl2;
    }

    public void s(Float f10, float[] object) {
        boolean bl2;
        Object object2;
        boolean bl3;
        if ((object = this.u((float[])object)) != null && !(bl3 = Arrays.equals(object, object2 = this.h))) {
            this.h = object;
            object2 = this.f((float[])object);
            this.j = (Range)object2;
            object2 = this.h;
            object2 = this.v((float[])object2);
            this.l = object2;
            object2 = this.b;
            Object object3 = this.h;
            d.v.e.i.h.d((MutableLiveData)object2, object3);
            object2 = this.d;
            object3 = this.j;
            d.v.e.i.h.d((MutableLiveData)object2, object3);
            object2 = this.f;
            object3 = this.l;
            d.v.e.i.h.d((MutableLiveData)object2, object3);
        }
        if (object != null && !(bl3 = Arrays.equals(object, object2 = this.i))) {
            this.i = object;
            object = this.f((float[])object);
            this.k = (Range)object;
            object = this.w((Range)object);
            this.m = (Range)object;
            object = this.c;
            object2 = this.i;
            d.v.e.i.h.d((MutableLiveData)object, object2);
            object = this.e;
            object2 = this.k;
            d.v.e.i.h.d((MutableLiveData)object, object2);
            object = this.g;
            object2 = this.m;
            d.v.e.i.h.d((MutableLiveData)object, object2);
        }
        if (f10 != null && (bl2 = this.n)) {
            object = this.a;
            d.v.e.i.h.d((MutableLiveData)object, f10);
        }
    }

    public void t(int n10) {
        Float f10;
        float f11;
        if (n10 < 0) {
            n10 = 0;
            f11 = 0.0f;
            f10 = null;
        } else {
            int n11 = this.d();
            if (n10 > n11) {
                n10 = this.d();
            }
        }
        f10 = this.o(n10);
        if (f10 == null) {
            return;
        }
        f11 = f10.floatValue();
        this.r(f11);
    }

    public Integer x(float f10) {
        float[] fArray = this.h;
        float[] fArray2 = this.l;
        return this.y(f10, fArray, fArray2);
    }

    public Integer y(float f10, float[] fArray, float[] fArray2) {
        Number number = o.b(f10, fArray, fArray2);
        if (number == null) {
            boolean bl2 = false;
            f10 = 0.0f;
            number = null;
        } else {
            f10 = number.floatValue();
            int n10 = this.d();
            float f11 = n10;
            int n11 = (int)(f10 *= f11);
            number = n11;
        }
        return number;
    }
}

