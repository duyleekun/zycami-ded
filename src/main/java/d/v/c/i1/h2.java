/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Size
 */
package d.v.c.i1;

import android.util.Size;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.data.database.model.music.MusicBeatData;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorinterface.edit.MediaType;
import com.zhiyun.editorsdk.CallChangeUseCase;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.SpeedUseCase;
import com.zhiyun.editorsdk.TransitionUseCase;
import com.zhiyun.editorsdk.decoration.StickerUseCase;
import com.zhiyun.editorsdk.decoration.TextUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCase$OnTimeUpdateListener;
import com.zhiyun.editorsdk.fundation.IUseCase;
import com.zhiyun.editorsdk.fundation.UseCases;
import com.zhiyun.editorsdk.voice.MusicUseCase;
import com.zhiyun.editorsdk.voice.RecordUseCase;
import d.v.c.b2.w.c;
import d.v.c.b2.w.e;
import d.v.c.b2.w.f;
import d.v.c.b2.w.g;
import d.v.c.b2.w.i;
import d.v.c.b2.w.j;
import d.v.c.b2.w.k;
import d.v.c.i1.a1;
import d.v.c.i1.b1;
import d.v.c.i1.c1;
import d.v.c.i1.d1;
import d.v.c.i1.e1;
import d.v.c.i1.e2;
import d.v.c.i1.f1;
import d.v.c.i1.f2;
import d.v.c.i1.h2$a;
import d.v.c.i1.h2$b;
import d.v.c.i1.h2$c;
import d.v.c.i1.l1;
import d.v.c.i1.m1;
import d.v.c.i1.n0;
import d.v.c.i1.o0;
import d.v.c.i1.p0;
import d.v.c.i1.q0;
import d.v.c.i1.r0;
import d.v.c.i1.s0;
import d.v.c.i1.t0;
import d.v.c.i1.u0;
import d.v.c.i1.v0;
import d.v.c.i1.w0;
import d.v.c.i1.x0;
import d.v.c.i1.y0;
import d.v.c.i1.z0;
import d.v.c.v0.v.b.b;
import d.v.h.e.d;
import d.v.v.q.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import m.a.a;

public class h2
extends ViewModel {
    private EditorUseCase A;
    private MusicUseCase B;
    private RecordUseCase C;
    private TextUseCase D;
    private StickerUseCase E;
    private TransitionUseCase F;
    private SpeedUseCase G;
    private b H;
    private d.v.h.e.b I;
    private EditorUseCase$OnTimeUpdateListener J;
    private d.v.e.i.j a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MutableLiveData i;
    private MutableLiveData j;
    private MutableLiveData k;
    private MutableLiveData l;
    private MediatorLiveData m;
    private MediatorLiveData n;
    private MediatorLiveData o;
    private MediatorLiveData p;
    private MediatorLiveData q;
    private MediatorLiveData r;
    private MutableLiveData s;
    private MutableLiveData t;
    private MutableLiveData u;
    private MutableLiveData v;
    private MutableLiveData w;
    private d.v.e.i.j x;
    private Size y;
    private final MainUseCase z;

    public h2(MainUseCase object) {
        Object object2 = new d.v.e.i.j();
        this.a = object2;
        this.b = object2;
        super();
        this.c = object2;
        super();
        this.d = object2;
        super();
        this.e = object2;
        super();
        this.f = object2;
        super();
        this.g = object2;
        super();
        this.h = object2;
        super();
        this.i = object2;
        Boolean bl2 = Boolean.FALSE;
        super(bl2);
        this.j = object2;
        super(bl2);
        this.k = object2;
        super(bl2);
        this.l = object2;
        super();
        this.m = object2;
        super();
        this.n = object2;
        super();
        this.o = object2;
        super();
        this.p = object2;
        super();
        this.q = object2;
        super();
        this.r = object2;
        super(bl2);
        this.s = object2;
        super(bl2);
        this.t = object2;
        super(bl2);
        this.u = object2;
        super(bl2);
        this.v = object2;
        super();
        this.w = object2;
        object2 = new d.v.e.i.j();
        this.x = object2;
        this.I = object2 = new h2$a(this);
        this.J = object2 = new h2$b(this);
        this.z = object;
        object2 = new n0(this);
        ((MainUseCase)object).f0((d.v.e.g.c)object2);
        object = ((MainUseCase)object).G();
        this.U1((EditorUseCase)object);
        boolean bl3 = this.K0();
        if (bl3) {
            this.I0();
        }
        this.H1();
        this.J0();
        this.H = object = d.v.c.v0.v.b.b.c();
    }

    public h2(Object object) {
        object = (MainUseCase)object;
        this((MainUseCase)object);
    }

    public h2(Object ... object) {
        object = object[0];
        this(object);
    }

    private void C1() {
        d.v.c.b2.w.l.b.k(this.y0());
        d.v.c.b2.w.l.b.k(this.g0());
        Object object = this.E0();
        if (object != null) {
            boolean bl2;
            object = this.E0().iterator();
            while (bl2 = object.hasNext()) {
                List list = (List)object.next();
                d.v.c.b2.w.l.b.k(list);
            }
        }
    }

    private void D1() {
        MainUseCase mainUseCase = this.z;
        d.v.h.e.b b10 = this.I;
        mainUseCase.a0(b10);
    }

    private void G1(boolean bl2, long l10) {
        if (bl2) {
            d.v.e.i.j j10 = this.a;
            Long l11 = l10;
            d.v.e.i.h.e(j10, l11);
        }
    }

    private boolean H0(MutableLiveData object) {
        boolean bl2;
        if ((object = (e)((LiveData)object).getValue()) != null && (bl2 = ((e)object).d())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private void H1() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setEditCallback,");
        Object object2 = this.I;
        ((StringBuilder)object).append(object2);
        object = ((StringBuilder)object).toString();
        object2 = new Object[]{};
        m.a.a.b((String)object, object2);
        object = this.z;
        object2 = this.I;
        ((MainUseCase)object).f((d.v.h.e.b)object2);
    }

    private void I1(List list) {
        d.v.e.i.h.e(this.b, list);
    }

    private void J0() {
        MediatorLiveData mediatorLiveData = this.q;
        MutableLiveData mutableLiveData = this.i;
        Observer observer = new o0(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
        mediatorLiveData = this.q;
        mutableLiveData = this.b;
        observer = new a1(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
        mediatorLiveData = this.r;
        mutableLiveData = this.s;
        observer = new f1(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
        mediatorLiveData = this.r;
        mutableLiveData = this.t;
        observer = new w0(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
        mediatorLiveData = this.o;
        mutableLiveData = this.i;
        observer = new b1(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
        mediatorLiveData = this.m;
        mutableLiveData = this.g;
        observer = new d1(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
        mediatorLiveData = this.n;
        mutableLiveData = this.h;
        observer = new t0(this);
        mediatorLiveData.addSource(mutableLiveData, observer);
    }

    private void J1(List list) {
        ArrayList<List> arrayList = this.E0();
        if (arrayList != null) {
            int n10 = arrayList.size();
            if (n10 > 0) {
                arrayList.remove(0);
            }
        } else {
            arrayList = new ArrayList<List>();
        }
        arrayList.add(0, list);
        d.v.e.i.h.e(this.c, arrayList);
    }

    private boolean K0() {
        return this.z.R();
    }

    private void K1(MusicUseCase musicUseCase) {
        this.B = musicUseCase;
        c1 c12 = new c1(this);
        musicUseCase.d(c12);
    }

    private /* synthetic */ void L0(e e10) {
        this.m2();
    }

    private void L1(List list) {
        int n10;
        ArrayList<List> arrayList = this.E0();
        int n11 = 1;
        if (arrayList != null) {
            n10 = arrayList.size();
            if (n10 > n11) {
                arrayList.remove(n11);
            }
        } else {
            arrayList = new ArrayList<List>();
        }
        if ((n10 = arrayList.size()) == 0) {
            n10 = 0;
            arrayList.add(0, null);
        }
        arrayList.add(n11, list);
        d.v.e.i.h.e(this.c, arrayList);
    }

    private void M1(RecordUseCase recordUseCase) {
        this.C = recordUseCase;
        x0 x02 = new x0(this);
        recordUseCase.d(x02);
    }

    private /* synthetic */ void N0(List list) {
        this.m2();
    }

    private void O1(SpeedUseCase speedUseCase) {
        this.G = speedUseCase;
        z0 z02 = new z0(this);
        speedUseCase.d(z02);
    }

    private /* synthetic */ void P0(Boolean bl2) {
        this.e2();
    }

    private void P1(List list) {
        d.v.e.i.h.e(this.e, list);
    }

    private void Q1(StickerUseCase stickerUseCase) {
        this.E = stickerUseCase;
        v0 v02 = new v0(this);
        stickerUseCase.d(v02);
    }

    private /* synthetic */ void R0(Boolean bl2) {
        this.e2();
    }

    private void R1(List list) {
        d.v.e.i.h.e(this.d, list);
    }

    private void S1(TextUseCase textUseCase) {
        this.D = textUseCase;
        y0 y02 = new y0(this);
        textUseCase.d(y02);
    }

    private long T() {
        boolean bl2;
        Iterator iterator2 = this.U().iterator();
        long l10 = 0L;
        while (bl2 = iterator2.hasNext()) {
            d d10 = (d)iterator2.next();
            long l11 = d10.u();
            long l12 = d10.J();
            double d11 = l11 -= l12;
            double d12 = d10.I();
            long l13 = (long)(d11 /= d12);
            l10 = Math.max(l10, l13);
        }
        return l10;
    }

    private /* synthetic */ void T0(e object) {
        boolean bl2;
        MediatorLiveData mediatorLiveData = this.o;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        d.v.e.i.h.e(mediatorLiveData, object);
    }

    private void T1(TransitionUseCase transitionUseCase) {
        this.F = transitionUseCase;
        s0 s02 = new s0(this);
        transitionUseCase.d(s02);
    }

    private List U() {
        return this.z.H();
    }

    private void U1(EditorUseCase editorUseCase) {
        this.A = editorUseCase;
        EditorUseCase$OnTimeUpdateListener editorUseCase$OnTimeUpdateListener = this.J;
        editorUseCase.h(editorUseCase$OnTimeUpdateListener);
    }

    private HashMap V(String hashMap) {
        b b10 = this.H;
        hashMap = (hashMap = b10.getMusicBeatDataByPath((String)((Object)hashMap))) == null ? new HashMap() : ((MusicBeatData)((Object)hashMap)).getBeatMaps();
        return hashMap;
    }

    private /* synthetic */ void V0(e e10) {
        this.f2();
    }

    private void V1(List list) {
        d.v.e.i.h.e(this.c, list);
    }

    private void W1(k k10) {
        Object object = (d.v.h.h.b)k10.a();
        long l10 = ((d.v.h.h.b)object).d();
        k10.m(l10);
        l10 = ((d.v.h.h.b)object).d();
        long l11 = ((d.v.h.h.b)object).l();
        k10.l(l10 += l11);
        l10 = ((d.v.h.h.b)object).e();
        k10.D(l10);
        l10 = ((d.v.h.h.b)object).m();
        k10.C(l10);
        l10 = ((d.v.h.h.b)object).f();
        k10.B(l10);
        object = ((d.v.h.h.b)object).k();
        object = this.V((String)object);
        k10.A((HashMap)object);
        k10.z(true);
    }

    private /* synthetic */ void X0(e e10) {
        this.g2();
    }

    private void X1(k k10) {
        d.v.h.h.b b10 = (d.v.h.h.b)k10.a();
        long l10 = b10.d();
        k10.m(l10);
        l10 = b10.d();
        long l11 = b10.l();
        k10.l(l10 += l11);
        l10 = b10.e();
        k10.D(l10);
        l10 = b10.m();
        k10.C(l10);
        long l12 = b10.f();
        k10.B(l12);
        k10.z(false);
    }

    private void Y1(f f10) {
        d.v.h.d.c c10 = (d.v.h.d.c)f10.a();
        long l10 = c10.e();
        f10.m(l10);
        l10 = c10.e();
        long l11 = c10.i();
        f10.l(l10 += l11);
    }

    private /* synthetic */ void Z0(boolean bl2, long l10) {
        this.x2();
        this.G1(bl2, l10);
    }

    private void Z1(g g10) {
        d.v.h.d.d d10 = (d.v.h.d.d)g10.a();
        long l10 = d10.e();
        g10.m(l10);
        l10 = d10.e();
        long l11 = d10.i();
        g10.l(l10 += l11);
    }

    private int a0(e e10) {
        if (e10 != null) {
            return e10.b();
        }
        return -1;
    }

    private void a2() {
        List list = this.y0();
        if (list != null) {
            int n10;
            for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
                j j10 = (j)list.get(i10);
                boolean bl2 = this.i(i10);
                j10.C(bl2);
                Object object = (d)j10.a();
                if (object != null && (object = ((d)object).N()) != null) {
                    object = ((d.v.h.k.b)object).d();
                    j10.K((String)object);
                    continue;
                }
                bl2 = false;
                object = null;
                j10.K(null);
            }
        }
    }

    public static /* synthetic */ void b(h2 h22, boolean bl2, long l10) {
        h22.G1(bl2, l10);
    }

    private List b0() {
        StickerUseCase stickerUseCase = this.E;
        boolean bl2 = UseCases.b(stickerUseCase);
        if (bl2) {
            return Collections.emptyList();
        }
        return this.E.i();
    }

    private /* synthetic */ void b1(boolean bl2, long l10) {
        this.o2();
        this.G1(bl2, l10);
    }

    private void b2(j j10) {
        d d10 = (d)j10.a();
        double d11 = d10.I();
        j10.I(d11);
        long l10 = (long)((double)d10.J() / d11);
        j10.m(l10);
        l10 = d10.u();
        double d12 = (double)l10 / d11;
        long l11 = (long)d12;
        j10.l(l11);
        boolean bl2 = d10.j();
        String string2 = bl2 ? d10.g() : d10.e();
        j10.L(string2);
        l11 = d10.d();
        j10.H(l11);
        float f10 = d10.r();
        j10.B(f10);
    }

    public static /* synthetic */ d.v.e.i.j c(h2 h22) {
        return h22.x;
    }

    private List c0(DecorationType decorationType) {
        StickerUseCase stickerUseCase = this.E;
        boolean bl2 = UseCases.b(stickerUseCase);
        if (bl2) {
            return Collections.emptyList();
        }
        return this.E.j(decorationType);
    }

    public static /* synthetic */ void d(h2 h22, long l10) {
        h22.p2(l10);
    }

    private /* synthetic */ void d1(boolean bl2, long l10) {
        this.q2();
        this.G1(bl2, l10);
    }

    public static /* synthetic */ void e(h2 h22, long l10) {
        h22.u2(l10);
    }

    private void e2() {
        Boolean bl2;
        boolean bl3 = this.u();
        if (!bl3 && !(bl3 = this.w())) {
            bl3 = false;
            bl2 = null;
        } else {
            bl3 = true;
        }
        boolean bl4 = this.G();
        if (bl4 != bl3) {
            MediatorLiveData mediatorLiveData = this.r;
            bl2 = bl3;
            d.v.e.i.h.e(mediatorLiveData, bl2);
        }
    }

    public static /* synthetic */ void f(h2 h22) {
        h22.v2();
    }

    private /* synthetic */ void f1(boolean bl2, long l10) {
        this.v2();
        this.G1(bl2, l10);
    }

    private /* synthetic */ void h1(boolean bl2, long l10) {
        this.s2();
        this.G1(bl2, l10);
    }

    private void h2() {
        long l10 = this.Q();
        long l11 = this.o0();
        Object object = this.k;
        Boolean bl2 = this.A1(l10);
        d.v.e.i.h.e((MutableLiveData)object, bl2);
        MutableLiveData mutableLiveData = this.s;
        List list = this.X();
        object = this;
        object = this.j(l10, l11, 500000, list);
        d.v.e.i.h.e(mutableLiveData, object);
    }

    private List i0() {
        TextUseCase textUseCase = this.D;
        boolean bl2 = UseCases.b(textUseCase);
        if (bl2) {
            return Collections.emptyList();
        }
        return this.D.i();
    }

    private void i2() {
        long l10 = this.Q();
        long l11 = this.o0();
        Object object = this.l;
        Boolean bl2 = this.B1(l10);
        d.v.e.i.h.e((MutableLiveData)object, bl2);
        MutableLiveData mutableLiveData = this.t;
        List list = this.Z();
        object = this;
        object = this.j(l10, l11, 500000, list);
        d.v.e.i.h.e(mutableLiveData, object);
    }

    private boolean j(long l10, long l11, int n10, List list) {
        if (list != null) {
            long l12 = n10;
            long l13 = (l11 -= l10) - l12;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object < 0) {
                return false;
            }
            Iterator iterator2 = list.iterator();
            while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                long l14;
                long l15;
                d.v.c.b2.w.b b10 = (d.v.c.b2.w.b)iterator2.next();
                long l16 = b10.i() - l12;
                long l17 = l10 - l16;
                Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object2 <= 0 || (n10 = (int)((l15 = l10 - (l14 = b10.g())) == 0L ? 0 : (l15 < 0L ? -1 : 1))) > 0) continue;
                return false;
            }
        }
        return true;
    }

    private /* synthetic */ void j1(boolean bl2, long l10) {
        this.t2();
        this.G1(bl2, l10);
    }

    private void j2() {
        long l10 = this.Q();
        long l11 = this.o0();
        MutableLiveData mutableLiveData = this.v;
        List list = this.g0();
        Object object = this;
        object = this.j(l10, l11, 500000, list);
        d.v.e.i.h.e(mutableLiveData, object);
    }

    private void k(d.v.c.b2.w.d d10, d.v.c.b2.w.d d11, MutableLiveData mutableLiveData) {
        long l10;
        long l11;
        int n10;
        long l12;
        long l13;
        long l14;
        long l15;
        if (d11 != null && d10 != null && ((l15 = (l14 = (l13 = d10.b()) - (l12 = d11.a())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) > 0 || (n10 = (l11 = (l13 = d10.a()) - (l10 = d11.b())) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0)) {
            n10 = 0;
            d10 = null;
            d.v.e.i.h.e(mutableLiveData, null);
        }
    }

    private void k2() {
        long l10 = this.Q();
        long l11 = this.o0();
        MutableLiveData mutableLiveData = this.u;
        List list = this.m0();
        Object object = this;
        object = this.j(l10, l11, 500000, list);
        d.v.e.i.h.e(mutableLiveData, object);
    }

    private boolean l() {
        Object object = this.D0();
        if (object != null && (object = (k)((e)object).a()) != null) {
            return ((k)object).w();
        }
        return false;
    }

    private /* synthetic */ void l1(boolean bl2, long l10) {
        this.x2();
        this.G1(bl2, l10);
    }

    private void l2() {
        long l10 = this.Q();
        MutableLiveData mutableLiveData = this.j;
        Boolean bl2 = this.x1(l10);
        d.v.e.i.h.e(mutableLiveData, bl2);
    }

    private boolean m() {
        Object object = this.D0();
        if (object != null && (object = (k)((e)object).a()) != null) {
            return ((k)object).x();
        }
        return false;
    }

    private void m2() {
        int n10;
        Object object = (e)this.i.getValue();
        List list = (List)this.b.getValue();
        MediatorLiveData mediatorLiveData = this.q;
        int n11 = 1;
        if (object == null || list == null || (n10 = list.size()) <= n11) {
            n11 = 0;
        }
        object = n11 != 0;
        d.v.e.i.h.e(mediatorLiveData, object);
    }

    private void n(List object, MutableLiveData object2) {
        c c10;
        e e10 = (e)((LiveData)object2).getValue();
        if (e10 != null && (c10 = (c)e10.a()) != null) {
            int n10;
            int n11 = e10.b();
            if (object != null && (n10 = object.size()) > n11) {
                String string2;
                object = (c)object.get(n11);
                String string3 = c10.j();
                n11 = (int)(string3.equals(string2 = ((c)object).j()) ? 1 : 0);
                if (n11 != 0) {
                    if (c10 != object) {
                        e10.e(object);
                    }
                    return;
                }
            }
            d.v.e.i.h.e((MutableLiveData)object2, null);
            object = new Object[]{};
            object2 = "checkSelectedAndReplace, clear Selected item";
            m.a.a.i((String)object2, (Object[])object);
        }
    }

    private /* synthetic */ Void n1(k k10) {
        this.W1(k10);
        return null;
    }

    private void n2() {
        long l10 = this.Q();
        MediatorLiveData mediatorLiveData = this.p;
        Boolean bl2 = this.y1(l10);
        d.v.e.i.h.e(mediatorLiveData, bl2);
    }

    private /* synthetic */ Void p1(k k10) {
        this.X1(k10);
        return null;
    }

    private void p2(long l10) {
        boolean bl2 = this.K0();
        if (!bl2) {
            return;
        }
        this.r2(l10);
        this.h2();
        this.i2();
        this.k2();
        this.j2();
        this.l2();
        this.n2();
    }

    private void r(int n10, DecorationType object) {
        Object object2 = h2$c.a;
        int n11 = object.ordinal();
        int n12 = 1;
        if ((n11 = object2[n11]) != n12 && n11 != (n12 = 2)) {
            n12 = 3;
            if ((n11 == n12 || n11 == (n12 = 4)) && n10 < (n12 = (object = this.m0()).size())) {
                object2 = new e;
                object = object.get(n10);
                object2(0, n10, object);
                MutableLiveData mutableLiveData = this.g;
                d.v.e.i.h.g(mutableLiveData, object2);
            }
        } else {
            object = this.g0();
            n12 = object.size();
            if (n10 < n12) {
                object2 = new e;
                object = object.get(n10);
                object2(0, n10, object);
                MutableLiveData mutableLiveData = this.h;
                d.v.e.i.h.g(mutableLiveData, object2);
            }
        }
    }

    private /* synthetic */ Void r1(f f10) {
        this.Y1(f10);
        return null;
    }

    private void r2(long l10) {
        double d10 = this.p0();
        long l11 = 0L;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object <= 0) {
            return;
        }
        object = this.y.getWidth();
        d11 = (double)object / d10;
        d10 = 2.0;
        long l12 = (long)(d11 /= d10);
        l11 = l10 - l12;
        d.v.c.b2.w.d d13 = new d.v.c.b2.w.d(l11, l10 += l12);
        Object object2 = this.D0();
        Object object3 = this.l0();
        e e10 = this.f0();
        e e11 = this.w0();
        if (object2 != null) {
            object2 = this.t0((e)object2);
            object3 = this.f;
            this.k(d13, (d.v.c.b2.w.d)object2, (MutableLiveData)object3);
        } else if (object3 != null) {
            object2 = this.t0((e)object3);
            object3 = this.g;
            this.k(d13, (d.v.c.b2.w.d)object2, (MutableLiveData)object3);
        } else if (e10 != null) {
            object2 = this.t0(e10);
            object3 = this.h;
            this.k(d13, (d.v.c.b2.w.d)object2, (MutableLiveData)object3);
        } else if (e11 != null) {
            object2 = this.A0(e11);
            object3 = this.i;
            this.k(d13, (d.v.c.b2.w.d)object2, (MutableLiveData)object3);
        }
    }

    private void s() {
        MutableLiveData mutableLiveData = this.g;
        boolean bl2 = this.H0(mutableLiveData);
        if (bl2 || (bl2 = this.H0(mutableLiveData = this.h))) {
            this.o();
        }
    }

    private /* synthetic */ Void t1(g g10) {
        this.Z1(g10);
        return null;
    }

    private void u2(long l10) {
        i i10 = this.s0();
        if (i10 == null) {
            i10 = new i(l10);
        } else {
            i10.k(l10);
        }
        l10 = this.T();
        i10.h(l10);
        d.v.e.i.h.g(this.w, i10);
    }

    private /* synthetic */ Void v1(j j10) {
        this.b2(j10);
        return null;
    }

    private void v2() {
        this.x2();
        this.o2();
        this.q2();
        this.s2();
        this.t2();
    }

    public boolean A() {
        return (Boolean)this.u.getValue();
    }

    public d.v.c.b2.w.d A0(e object) {
        if (object != null) {
            int n10;
            int n11 = ((e)object).b();
            List list = this.y0();
            if (list != null && n11 >= 0 && n11 < (n10 = list.size())) {
                int n12;
                long l10 = 0L;
                for (int i10 = 0; i10 < (n12 = list.size()) && i10 < n11; ++i10) {
                    j j10 = (j)list.get(i10);
                    long l11 = j10.h();
                    l10 += l11;
                }
                long l12 = ((j)list.get(n11)).h() + l10;
                object = new d.v.c.b2.w.d(l10, l12);
                return object;
            }
        }
        return null;
    }

    public boolean A1(long l10) {
        boolean bl2;
        MusicUseCase musicUseCase = this.B;
        boolean bl3 = UseCases.b(musicUseCase);
        bl2 = !bl3 && (bl2 = (musicUseCase = this.B).o(l10));
        return bl2;
    }

    public int B0() {
        e e10 = this.D0();
        return this.a0(e10);
    }

    public boolean B1(long l10) {
        boolean bl2;
        RecordUseCase recordUseCase = this.C;
        boolean bl3 = UseCases.b(recordUseCase);
        bl2 = !bl3 && (bl2 = (recordUseCase = this.C).s(l10));
        return bl2;
    }

    public MutableLiveData C0() {
        return this.f;
    }

    public e D0() {
        return (e)this.f.getValue();
    }

    public List E0() {
        return (List)this.c.getValue();
    }

    public void E1(int n10) {
        DecorationType decorationType = DecorationType.CAPTION;
        this.r(n10, decorationType);
    }

    public LiveData F() {
        return this.r;
    }

    public LiveData F0() {
        return this.c;
    }

    public void F1(int n10) {
        DecorationType decorationType = DecorationType.GIF_PASTER;
        this.r(n10, decorationType);
    }

    public boolean G() {
        boolean bl2;
        Object object = this.r.getValue();
        if (object != null && (bl2 = ((Boolean)(object = (Boolean)this.r.getValue())).booleanValue())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean G0() {
        MutableLiveData mutableLiveData = this.f;
        boolean bl2 = this.H0(mutableLiveData);
        if (!(bl2 || (bl2 = this.H0(mutableLiveData = this.g)) || (bl2 = this.H0(mutableLiveData = this.h)) || (bl2 = this.H0(mutableLiveData = this.i)))) {
            bl2 = false;
            mutableLiveData = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public MediatorLiveData H() {
        return this.p;
    }

    public MediatorLiveData I() {
        return this.m;
    }

    public void I0() {
        CallChangeUseCase callChangeUseCase = (MusicUseCase)this.z.K(MusicUseCase.class);
        this.K1((MusicUseCase)callChangeUseCase);
        callChangeUseCase = (RecordUseCase)this.z.K(RecordUseCase.class);
        this.M1((RecordUseCase)callChangeUseCase);
        callChangeUseCase = (TextUseCase)this.z.K(TextUseCase.class);
        this.S1((TextUseCase)callChangeUseCase);
        callChangeUseCase = (StickerUseCase)this.z.K(StickerUseCase.class);
        this.Q1((StickerUseCase)callChangeUseCase);
        callChangeUseCase = (TransitionUseCase)this.z.K(TransitionUseCase.class);
        this.T1((TransitionUseCase)callChangeUseCase);
        callChangeUseCase = (SpeedUseCase)this.z.K(SpeedUseCase.class);
        this.O1((SpeedUseCase)callChangeUseCase);
        long l10 = this.z.J();
        this.u2(l10);
        this.x2();
    }

    public MediatorLiveData J() {
        return this.n;
    }

    public MediatorLiveData K() {
        return this.o;
    }

    public LiveData L() {
        return this.k;
    }

    public LiveData M() {
        return this.l;
    }

    public /* synthetic */ void M0(e e10) {
        this.L0(e10);
    }

    public LiveData N() {
        return this.j;
    }

    public void N1(Size size) {
        this.y = size;
    }

    public /* synthetic */ void O0(List list) {
        this.N0(list);
    }

    public LiveData P() {
        return this.q;
    }

    public long Q() {
        return this.z.E();
    }

    public /* synthetic */ void Q0(Boolean bl2) {
        this.P0(bl2);
    }

    public d.v.e.i.j R() {
        return this.a;
    }

    public d.v.e.i.j S() {
        return this.x;
    }

    public /* synthetic */ void S0(Boolean bl2) {
        this.R0(bl2);
    }

    public /* synthetic */ void U0(e e10) {
        this.T0(e10);
    }

    public List W() {
        Object object = this.B;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.B.m();
        return object;
    }

    public /* synthetic */ void W0(e e10) {
        this.V0(e10);
    }

    public List X() {
        int n10;
        List list = this.E0();
        if (list != null && (n10 = list.size()) > 0) {
            return (List)list.get(0);
        }
        return null;
    }

    public List Y() {
        Object object = this.C;
        boolean bl2 = UseCases.b((IUseCase)object);
        object = bl2 ? Collections.emptyList() : this.C.p();
        return object;
    }

    public /* synthetic */ void Y0(e e10) {
        this.X0(e10);
    }

    public List Z() {
        int n10;
        int n11;
        List list = this.E0();
        if (list != null && (n11 = list.size()) > (n10 = 1)) {
            return (List)list.get(n10);
        }
        return null;
    }

    public /* synthetic */ void a1(boolean bl2, long l10) {
        this.Z0(bl2, l10);
    }

    public /* synthetic */ void c1(boolean bl2, long l10) {
        this.b1(bl2, l10);
    }

    public int c2(long l10) {
        int n10;
        i i10 = this.s0();
        if (i10 != null) {
            long l11 = i10.getTotalTime();
            int n11 = i10.c();
            double d10 = l10;
            double d11 = 1.0;
            d10 *= d11;
            double d12 = l11;
            d10 /= d12;
            d12 = n11;
            l10 = Math.round(d10 *= d12);
            n10 = (int)l10;
            n10 = Math.max(0, n10);
            n10 = Math.min(n11, n10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int d0() {
        e e10 = this.f0();
        return this.a0(e10);
    }

    public long d2(int n10) {
        long l10;
        i i10 = this.s0();
        if (i10 != null) {
            long l11 = i10.getTotalTime();
            int n11 = i10.c();
            double d10 = (double)n10 * 1.0;
            double d11 = n11;
            d10 /= d11;
            d11 = l11;
            long l12 = Math.round(d10 *= d11);
            long l13 = 0L;
            d11 = 0.0;
            l12 = Math.max(l13, l12);
            l10 = Math.min(l11, l12);
        } else {
            l10 = -1;
        }
        return l10;
    }

    public MutableLiveData e0() {
        return this.h;
    }

    public /* synthetic */ void e1(boolean bl2, long l10) {
        this.d1(bl2, l10);
    }

    public e f0() {
        return (e)this.h.getValue();
    }

    public void f2() {
        long l10;
        Long l11;
        long l12;
        Object object = (e)this.g.getValue();
        if (object == null) {
            object = this.m;
            Boolean bl2 = Boolean.FALSE;
            d.v.e.i.h.e((MutableLiveData)object, bl2);
            return;
        }
        Object object2 = (List)this.d.getValue();
        int n10 = ((e)object).b();
        d.v.h.d.d d10 = (d.v.h.d.d)((g)object2.get(n10)).a();
        int n11 = 1;
        int n12 = object2.size();
        int n13 = 0;
        long l13 = 500000L;
        if ((n10 += n11) < n12) {
            object = ((d.v.h.d.d)((g)object2.get(n10)).a()).e();
            l12 = (Long)object;
            l11 = d10.e();
            l10 = l11;
            l12 -= l10;
            l10 = d10.i();
            long l14 = (l12 -= l10) - l13;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 < 0) {
                n11 = 0;
            }
        }
        l12 = d.v.v.q.h.z();
        l11 = d10.e();
        l10 = l11;
        l12 -= l10;
        l10 = d10.i();
        long l15 = (l12 -= l10) - l13;
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 >= 0) {
            n13 = n11;
        }
        object = this.m;
        object2 = n13 != 0;
        d.v.e.i.h.e((MutableLiveData)object, object2);
    }

    public void g(float f10) {
        i i10 = this.s0();
        if (i10 != null) {
            i10.d(f10);
            MutableLiveData mutableLiveData = this.w;
            d.v.e.i.h.e(mutableLiveData, i10);
        }
    }

    public List g0() {
        return (List)this.e.getValue();
    }

    public /* synthetic */ void g1(boolean bl2, long l10) {
        this.f1(bl2, l10);
    }

    public void g2() {
        long l10;
        Long l11;
        long l12;
        Object object = (e)this.h.getValue();
        if (object == null) {
            object = this.n;
            Boolean bl2 = Boolean.FALSE;
            d.v.e.i.h.e((MutableLiveData)object, bl2);
            return;
        }
        Object object2 = (List)this.e.getValue();
        int n10 = ((e)object).b();
        d.v.h.d.c c10 = (d.v.h.d.c)((f)object2.get(n10)).a();
        int n11 = 1;
        int n12 = object2.size();
        int n13 = 0;
        long l13 = 500000L;
        if ((n10 += n11) < n12) {
            object = ((d.v.h.d.c)((f)object2.get(n10)).a()).e();
            l12 = (Long)object;
            l11 = c10.e();
            l10 = l11;
            l12 -= l10;
            l10 = c10.i();
            long l14 = (l12 -= l10) - l13;
            n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
            if (n10 < 0) {
                n11 = 0;
            }
        }
        l12 = d.v.v.q.h.z();
        l11 = c10.e();
        l10 = l11;
        l12 -= l10;
        l10 = c10.i();
        long l15 = (l12 -= l10) - l13;
        n10 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n10 >= 0) {
            n13 = n11;
        }
        object = this.n;
        object2 = n13 != 0;
        d.v.e.i.h.e((MutableLiveData)object, object2);
    }

    public MutableLiveData h0() {
        return this.e;
    }

    public boolean i(int n10) {
        TransitionUseCase transitionUseCase = this.F;
        boolean bl2 = UseCases.b(transitionUseCase);
        if (bl2) {
            return false;
        }
        return this.F.g(n10);
    }

    public /* synthetic */ void i1(boolean bl2, long l10) {
        this.h1(bl2, l10);
    }

    public int j0() {
        e e10 = this.l0();
        return this.a0(e10);
    }

    public MutableLiveData k0() {
        return this.g;
    }

    public /* synthetic */ void k1(boolean bl2, long l10) {
        this.j1(bl2, l10);
    }

    public e l0() {
        return (e)this.g.getValue();
    }

    public List m0() {
        return (List)this.d.getValue();
    }

    public /* synthetic */ void m1(boolean bl2, long l10) {
        this.l1(bl2, l10);
    }

    public MutableLiveData n0() {
        return this.d;
    }

    public void o() {
        Object[] objectArray = new Object[]{};
        m.a.a.i("clearAllSelected", objectArray);
        d.v.e.i.h.e(this.f, null);
        d.v.e.i.h.e(this.g, null);
        d.v.e.i.h.e(this.h, null);
        d.v.e.i.h.e(this.i, null);
    }

    public long o0() {
        i i10 = (i)this.w.getValue();
        if (i10 != null) {
            return i10.getTotalTime();
        }
        return 0L;
    }

    public /* synthetic */ Void o1(k k10) {
        return this.n1(k10);
    }

    public void o2() {
        boolean bl2 = this.K0();
        if (!bl2) {
            return;
        }
        List list = this.X();
        Object object = this.W();
        l1 l12 = l1.a;
        u0 u02 = new u0(this);
        list = this.w2(list, (List)object, l12, u02);
        this.J1(list);
        this.h2();
        bl2 = this.l();
        if (bl2) {
            list = this.X();
            object = this.C0();
            this.n(list, (MutableLiveData)object);
        }
    }

    public void onCleared() {
        super.onCleared();
        this.D1();
        EditorUseCase editorUseCase = this.A;
        EditorUseCase$OnTimeUpdateListener editorUseCase$OnTimeUpdateListener = this.J;
        editorUseCase.m(editorUseCase$OnTimeUpdateListener);
        this.C1();
    }

    public void p(int n10, DecorationType decorationType) {
        if (decorationType == null) {
            this.s();
        } else {
            this.r(n10, decorationType);
        }
    }

    public double p0() {
        i i10 = (i)this.w.getValue();
        if (i10 != null) {
            return i10.b();
        }
        return 0.0;
    }

    public LiveData q0() {
        return this.w;
    }

    public /* synthetic */ Void q1(k k10) {
        return this.p1(k10);
    }

    public void q2() {
        boolean bl2 = this.K0();
        if (!bl2) {
            return;
        }
        List list = this.Z();
        Object object = this.Y();
        l1 l12 = l1.a;
        p0 p02 = new p0(this);
        list = this.w2(list, (List)object, l12, p02);
        this.L1(list);
        this.i2();
        bl2 = this.m();
        if (bl2) {
            list = this.Z();
            object = this.C0();
            this.n(list, (MutableLiveData)object);
        }
    }

    public float r0() {
        i i10 = (i)this.w.getValue();
        if (i10 != null) {
            return i10.a();
        }
        return 0.0f;
    }

    public i s0() {
        return (i)this.w.getValue();
    }

    public /* synthetic */ Void s1(f f10) {
        return this.r1(f10);
    }

    public void s2() {
        boolean bl2 = this.K0();
        if (!bl2) {
            return;
        }
        List list = this.g0();
        Object object = this.b0();
        f2 f22 = f2.a;
        q0 q02 = new q0(this);
        list = this.w2(list, (List)object, f22, q02);
        this.P1(list);
        this.j2();
        list = this.g0();
        object = this.e0();
        this.n(list, (MutableLiveData)object);
    }

    public LiveData t() {
        return this.s;
    }

    public d.v.c.b2.w.d t0(e object) {
        if (object != null && (object = (d.v.c.b2.w.b)((e)object).a()) != null) {
            long l10 = ((c)object).i();
            long l11 = ((c)object).g();
            object = new d.v.c.b2.w.d(l10, l11);
            return object;
        }
        return null;
    }

    public void t2() {
        boolean bl2 = this.K0();
        if (!bl2) {
            return;
        }
        List list = this.m0();
        Object object = this.i0();
        m1 m12 = m1.a;
        e1 e12 = new e1(this);
        list = this.w2(list, (List)object, m12, e12);
        this.R1(list);
        this.k2();
        list = this.m0();
        object = this.k0();
        this.n(list, (MutableLiveData)object);
    }

    public boolean u() {
        return (Boolean)this.s.getValue();
    }

    public int u0() {
        e e10 = this.w0();
        return this.a0(e10);
    }

    public /* synthetic */ Void u1(g g10) {
        return this.t1(g10);
    }

    public LiveData v() {
        return this.t;
    }

    public MutableLiveData v0() {
        return this.i;
    }

    public boolean w() {
        return (Boolean)this.t.getValue();
    }

    public e w0() {
        return (e)this.i.getValue();
    }

    public /* synthetic */ Void w1(j j10) {
        return this.v1(j10);
    }

    public List w2(List arrayList, List object, Function function, Function function2) {
        ArrayList<d.v.h.b> arrayList2 = null;
        if (object != null) {
            boolean bl2;
            if (arrayList == null) {
                arrayList = new ArrayList<d.v.h.b>();
            }
            ArrayList<d.v.h.b> arrayList3 = new ArrayList<d.v.h.b>();
            arrayList3.addAll(arrayList);
            arrayList.clear();
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                d.v.h.b b10 = (d.v.h.b)object.next();
                Iterator iterator2 = arrayList3.iterator();
                Object object2 = null;
                while (bl3 = iterator2.hasNext()) {
                    c c10 = (c)iterator2.next();
                    d.v.h.b b11 = c10.a();
                    boolean bl4 = b10.equals(b11);
                    if (!bl4) continue;
                    object2 = c10;
                }
                if (object2 == null) {
                    b10 = function.apply(b10);
                    object2 = b10;
                    object2 = (c)((Object)b10);
                }
                function2.apply(object2);
                arrayList.add((d.v.h.b)object2);
            }
            arrayList3.clear();
            arrayList2 = arrayList;
        }
        return arrayList2;
    }

    public LiveData x() {
        return this.v;
    }

    public d.v.c.b2.w.d x0(e object) {
        int n10;
        if (object != null && (n10 = ((e)object).b()) >= 0) {
            long l10 = d.v.v.q.h.g0(n10);
            long l11 = d.v.v.q.h.a0(n10);
            object = new d.v.c.b2.w.d(l10, l11);
            return object;
        }
        return null;
    }

    public boolean x1(long l10) {
        return this.z.U(l10);
    }

    public void x2() {
        boolean bl2 = this.K0();
        if (!bl2) {
            return;
        }
        long l10 = this.z.J();
        this.u2(l10);
        List list = this.U();
        Object object = this.y0();
        e2 e22 = e2.a;
        r0 r02 = new r0(this);
        list = this.w2((List)object, list, e22, r02);
        this.I1(list);
        this.a2();
        this.l2();
        this.n2();
        list = this.y0();
        object = this.v0();
        this.n(list, (MutableLiveData)object);
    }

    public boolean y() {
        return (Boolean)this.v.getValue();
    }

    public List y0() {
        return (List)this.b.getValue();
    }

    public boolean y1(long l10) {
        return this.z.V(l10);
    }

    public LiveData z() {
        return this.u;
    }

    public LiveData z0() {
        return this.b;
    }

    public boolean z1(int n10) {
        MediaType mediaType;
        int n11;
        Object object = this.z.H();
        int n12 = 0;
        if (n10 >= 0 && n10 < (n11 = object.size()) && (mediaType = ((d)object.get(n10)).f()) == (object = MediaType.VIDEO)) {
            n12 = n10 = 1;
        }
        return n12 != 0;
    }
}

