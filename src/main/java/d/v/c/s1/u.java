/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.api.entity.speed.CurveTemp;
import com.zhiyun.cama.data.api.entity.speed.CurveTemp$CurveTempBean;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editortemplate.TemEditorConfig;
import d.v.c.m0;
import d.v.c.s1.q;
import d.v.c.s1.s;
import d.v.c.s1.t;
import d.v.c.x1.p.d;
import d.v.e.i.h;
import d.v.e.j.a;
import d.v.e.l.q2.c;
import d.v.j.b;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class u
extends ViewModel {
    public static final int d = 0;
    public static final int e = 1;
    private d a;
    private MutableLiveData b;
    private MutableLiveData c;

    public u() {
        Object object = new d();
        this.a = object;
        this.b = object = new MutableLiveData();
        Integer n10 = 0;
        this.c = object = new MutableLiveData(n10);
    }

    private int d(double d10) {
        double[] dArray = m0.f;
        int n10 = 0;
        double d11 = dArray[0];
        int n11 = Double.compare(d10, d11);
        if (n11 > 0) {
            n11 = dArray.length + -1;
            d11 = dArray[n11];
            if ((n11 = Double.compare(d10, d11)) >= 0) {
                int n12 = dArray.length;
                n10 = n12 + -1;
            } else {
                for (int i10 = dArray.length + -1; i10 >= 0; i10 += -1) {
                    double d12;
                    double[] dArray2 = m0.f;
                    double d13 = dArray2[i10];
                    int n13 = Double.compare(d10, d13);
                    if (n13 > 0 || (n11 = Double.compare(d10, d12 = dArray2[n13 = i10 + -1])) < 0) continue;
                    n10 = n13;
                    break;
                }
            }
        }
        return n10 + 1;
    }

    private boolean k(long l10, String string2) {
        double d10 = d.v.v.q.h.s(string2);
        double d11 = -1.0;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        boolean bl2 = false;
        if (d12 == false) {
            return false;
        }
        double d13 = (double)l10 * d10;
        double d14 = d13 - (d10 = 500000.0);
        Object object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void m(long l10, CurveTemp$CurveTempBean object) {
        Object object2 = EditConfig$ResourceType.SPEED;
        String string2 = ((CurveTemp$CurveTempBean)object).getThumb();
        object2 = TemEditorConfig.c((a)object2, string2);
        object2 = ((CurveTemp$CurveTempBean)object).setThumb((String)object2);
        object = ((CurveTemp$CurveTempBean)object).getCurveString();
        boolean bl2 = this.k(l10, (String)object);
        ((CurveTemp$CurveTempBean)object2).setCanSelected(bl2);
    }

    public List b(long l10) {
        boolean bl2;
        Object object = m0.c();
        Class<CurveTemp> clazz = CurveTemp.class;
        if ((object = (CurveTemp)d.v.e.l.q2.c.d((String)object, clazz)) != null && !(bl2 = d.v.j.b.f((List)((Object)(clazz = ((CurveTemp)object).getList()))))) {
            object = ((CurveTemp)object).getList();
            clazz = new q(this, l10);
            object.forEach(clazz);
            return object;
        }
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public Map c() {
        return this.a.a();
    }

    public MutableLiveData e() {
        return this.b;
    }

    public List f(double d10) {
        Object object;
        int n10;
        int n11 = this.d(d10);
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = ((double[])(object = m0.f)).length); ++i10) {
            t t10 = new t();
            String string2 = m0.g[i10];
            t10 = t10.x(string2);
            double d11 = object[i10];
            object = t10.w(d11);
            if (i10 < n11) {
                n10 = 1;
            } else {
                n10 = 0;
                t10 = null;
            }
            object = ((t)object).v(n10 != 0);
            arrayList.add(object);
        }
        return arrayList;
    }

    public int g(double d10) {
        int n10;
        block2: {
            double[] dArray;
            int n11;
            for (n10 = 0; n10 < (n11 = (dArray = m0.f).length); ++n10) {
                double d11 = dArray[n10];
                int n12 = Double.compare(d11, d10);
                if (n12 != 0) {
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    public MutableLiveData i() {
        return this.c;
    }

    public int j() {
        int n10;
        Object object = this.c;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Integer)this.c.getValue();
            n10 = (Integer)object;
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public boolean l(int n10) {
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public /* synthetic */ void n(long l10, CurveTemp$CurveTempBean curveTemp$CurveTempBean) {
        this.m(l10, curveTemp$CurveTempBean);
    }

    public s o(int n10) {
        return (s)this.a.c(n10);
    }

    public void p(int n10) {
        MutableLiveData mutableLiveData = this.c;
        Integer n11 = n10;
        h.g(mutableLiveData, n11);
    }

    public void r(int n10, s s10) {
        d d10 = this.a;
        Integer n11 = n10;
        d10.e(n11, s10);
    }
}

