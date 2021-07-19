/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 */
package d.v.c.y1.f.y;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.editorsdk.voice.AudioWaveUseCase;
import d.v.c.x1.p.c;
import d.v.c.x1.p.d;
import d.v.c.y1.f.y.e$a;
import d.v.e.i.h;
import d.v.h.h.b;
import java.util.List;

public class e
extends AndroidViewModel {
    private static final String p = "start_time";
    private static final String q = "end_time";
    private static final String r = "fade_in_duration";
    private static final String s = "fade_out_duration";
    private AudioWaveUseCase a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private b e;
    private long f;
    private long g;
    private double h;
    private long i;
    private int j;
    private MutableLiveData k;
    private final MutableLiveData l;
    private final MutableLiveData m;
    private c n;
    private d o;

    public e(Application object) {
        super((Application)object);
        super();
        this.b = object;
        super();
        this.c = object;
        super();
        this.d = object;
        super();
        this.k = object;
        super();
        this.l = object;
        super();
        this.m = object;
        super();
        this.n = object;
        super();
        this.o = object;
        super();
        this.a = object;
        this.t();
    }

    public static /* synthetic */ MutableLiveData b(e e10) {
        return e10.b;
    }

    private void t() {
        AudioWaveUseCase audioWaveUseCase = this.a;
        e$a e$a = new e$a(this);
        audioWaveUseCase.d(e$a);
    }

    public void A(long l10) {
        d d10 = this.o;
        Long l11 = l10;
        d10.e(q, l11);
    }

    public void F(long l10) {
        d d10 = this.o;
        Long l11 = l10;
        d10.e(r, l11);
    }

    public void G(long l10) {
        d d10 = this.o;
        Long l11 = l10;
        d10.e(s, l11);
    }

    public void H(long l10) {
        d d10 = this.o;
        Long l11 = l10;
        d10.e(p, l11);
    }

    public void I(float f10) {
        c c10 = this.n;
        Float f11 = Float.valueOf(f10);
        c10.b(f11);
    }

    public void c(int n10) {
        long l10 = n10;
        long l11 = this.i;
        l10 = -(l10 * l11);
        l11 = this.f + l10;
        MutableLiveData mutableLiveData = this.c;
        Long l12 = l10;
        d.v.e.i.h.g(mutableLiveData, l12);
        mutableLiveData = this.d;
        l12 = l11;
        d.v.e.i.h.g(mutableLiveData, l12);
    }

    public long d(int n10) {
        float f10 = (float)n10 * 1.0f / 100.0f;
        float f11 = this.f;
        long l10 = (long)(f10 * f11 / 2.0f);
        long l11 = 100000L;
        return l10 / l11 * l11;
    }

    public int e(long l10) {
        long l11 = 100000L;
        float f10 = (float)(l10 / l11 * l11) * 2.0f;
        float f11 = this.f;
        return Math.round(f10 / f11 * 100.0f);
    }

    public MutableLiveData f() {
        return this.d;
    }

    public long g() {
        long l10;
        Object object = this.d.getValue();
        if (object == null) {
            object = this.e;
            l10 = ((b)object).f();
        } else {
            object = (Long)this.d.getValue();
            l10 = (Long)object;
        }
        return l10;
    }

    public int i() {
        double d10 = this.h;
        double d11 = this.e.m();
        return (int)(d10 * d11);
    }

    public MutableLiveData j() {
        return this.l;
    }

    public MutableLiveData k() {
        return this.m;
    }

    public MutableLiveData l() {
        return this.k;
    }

    public void m(int n10) {
        AudioWaveUseCase audioWaveUseCase = this.a;
        String string2 = this.e.k();
        long l10 = this.g;
        audioWaveUseCase.b(string2, 0L, l10, n10);
    }

    public int n(int n10) {
        long l10;
        double d10;
        float f10 = n10;
        long l11 = this.f;
        float f11 = l11;
        this.h = d10 = (double)(f10 /= f11);
        long l12 = n10;
        this.i = l11 /= l12;
        String string2 = this.e.k();
        this.g = l10 = d.v.v.q.h.C(string2);
        long l13 = -1;
        double d11 = 0.0 / 0.0;
        n10 = (int)(l10 == l13 ? 0 : (l10 < l13 ? -1 : 1));
        if (n10 == 0) {
            return 0;
        }
        d11 = this.h;
        double d12 = l10;
        this.j = n10 = (int)(d11 * d12);
        return n10;
    }

    public MutableLiveData o() {
        return this.c;
    }

    public long p() {
        long l10;
        Object object = this.c.getValue();
        if (object == null) {
            object = this.e;
            l10 = ((b)object).m();
        } else {
            object = (Long)this.c.getValue();
            l10 = (Long)object;
        }
        return l10;
    }

    public MutableLiveData r() {
        return this.b;
    }

    public List s() {
        List list = this.b.getValue();
        list = list == null ? new List() : (List)this.b.getValue();
        return list;
    }

    public Long u() {
        return (Long)this.o.d(q);
    }

    public Long v() {
        return (Long)this.o.d(r);
    }

    public Long w() {
        return (Long)this.o.d(s);
    }

    public Long x() {
        return (Long)this.o.d(p);
    }

    public float y() {
        return ((Float)this.n.a()).floatValue();
    }

    public void z(b b10) {
        this.e = b10;
        long l10 = b10.f();
        long l11 = this.e.m();
        this.f = l10 -= l11;
    }
}

