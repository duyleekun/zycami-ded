/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.template.edit;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import com.zhiyun.cama.ResConfig$AppResType;
import com.zhiyun.cama.template.edit.TemplateEditViewModel$a;
import com.zhiyun.cama.template.edit.TemplateEditViewModel$b;
import com.zhiyun.editorsdk.MainUseCase;
import com.zhiyun.editorsdk.fundation.EditorUseCase;
import com.zhiyun.editorsdk.fundation.PlayerWrapperView;
import com.zhiyun.editortemplate.TemEditorConfig;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.c.d1.e;
import d.v.c.j0;
import d.v.c.m0;
import d.v.c.u1.m.a1;
import d.v.c.u1.m.w0;
import d.v.e.f;
import d.v.e.i.h;
import d.v.e.j.a;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.h.e.b;
import d.v.h.e.d;
import d.v.v.g.g;
import java.lang.constant.Constable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TemplateEditViewModel
extends ViewModel
implements LifecycleObserver {
    public static final int A = 0;
    public static final int B = 1;
    public static final int C = 0;
    public static final int D = 1;
    public static final int z = 255;
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private final MutableLiveData e;
    private final MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private MutableLiveData i;
    private MutableLiveData j;
    private MutableLiveData k;
    private MutableLiveData l;
    private MutableLiveData m;
    private final MutableLiveData n;
    private MutableLiveData o;
    private MutableLiveData p;
    private MainUseCase q;
    private a1 r;
    private EditorUseCase s;
    private int t;
    private long u;
    private int v;
    private boolean w;
    private String x;
    private b y;

    public TemplateEditViewModel() {
        Object object = new MutableLiveData();
        this.a = object;
        Constable constable = -1;
        object = new MutableLiveData(constable);
        this.b = object;
        constable = 0L;
        object = new MutableLiveData(constable);
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        constable = Boolean.FALSE;
        object = new MutableLiveData(constable);
        this.g = object;
        Integer n10 = 0;
        object = new MutableLiveData(n10);
        this.h = object;
        object = new MutableLiveData();
        this.i = object;
        object = new MutableLiveData();
        this.j = object;
        object = new MutableLiveData();
        this.k = object;
        object = new MutableLiveData();
        this.l = object;
        object = new MutableLiveData(constable);
        this.m = object;
        object = new MutableLiveData();
        this.n = object;
        object = new MutableLiveData();
        this.o = object;
        object = new MutableLiveData();
        this.p = object;
        this.y = object = new TemplateEditViewModel$a(this);
    }

    private int J() {
        return this.q.F();
    }

    public static /* synthetic */ MutableLiveData b(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.f;
    }

    public static /* synthetic */ MutableLiveData c(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.n;
    }

    public static /* synthetic */ MutableLiveData d(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.h;
    }

    public static /* synthetic */ int e(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.g0();
    }

    public static /* synthetic */ MutableLiveData f(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.k;
    }

    public static /* synthetic */ MutableLiveData g(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.l;
    }

    private int g0() {
        int n10;
        Object object = this.n;
        if (object != null && (object = ((LiveData)object).getValue()) != null) {
            object = (Integer)this.n.getValue();
            n10 = (Integer)object;
        } else {
            n10 = -1;
        }
        return n10;
    }

    private int h0() {
        int n10 = this.v;
        int n11 = m0.l;
        int n12 = n10 / n11;
        if ((n10 %= n11) != 0) {
            ++n12;
        }
        return n12;
    }

    public static /* synthetic */ MainUseCase i(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.q;
    }

    public static /* synthetic */ a1 j(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.r;
    }

    public static /* synthetic */ MutableLiveData k(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.o;
    }

    private int k0(int n10, int n11) {
        long l10 = this.r.C0(n11);
        long l11 = this.r.t0(n11);
        double d10 = n10;
        double d11 = l11;
        double d12 = l10;
        return (int)((d10 /= d11) * d12);
    }

    public static /* synthetic */ boolean l(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.w;
    }

    public static /* synthetic */ String m(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.x;
    }

    public static /* synthetic */ void n(TemplateEditViewModel templateEditViewModel) {
        templateEditViewModel.x();
    }

    public static /* synthetic */ MutableLiveData o(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.e;
    }

    public static /* synthetic */ MutableLiveData p(TemplateEditViewModel templateEditViewModel) {
        return templateEditViewModel.j;
    }

    public static /* synthetic */ boolean v0(d d10) {
        return d10.P() ^ true;
    }

    private void x() {
        Object object = this.q;
        if (object == null) {
            return;
        }
        this.s = object = ((MainUseCase)object).G();
        TemplateEditViewModel$b templateEditViewModel$b = new TemplateEditViewModel$b(this);
        ((EditorUseCase)object).h(templateEditViewModel$b);
    }

    public void A(boolean bl2) {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.C(bl2);
    }

    public void A0() {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        this.W0();
    }

    public void B0() {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.B();
    }

    public boolean C0(String[] stringArray) {
        int n10;
        if (stringArray != null && (n10 = stringArray.length) != 0) {
            n10 = this.e0();
            return this.r.G0(stringArray, n10);
        }
        return false;
    }

    public void D0() {
        int n10;
        int n11 = this.g0();
        if (n11 == (n10 = 1)) {
            Object object;
            Object object2 = this.N();
            long l10 = -1;
            if (object2 != null && (object = ((e)object2).b()) != null && (object = ((e)object2).b().getTemplate()) != null) {
                object2 = ((e)object2).b().getTemplate();
                l10 = ((Template)object2).getReferenceId();
            }
            j0.H(l10);
        }
    }

    public void E0() {
        Object object = (Integer)this.n.getValue();
        int n10 = (Integer)object;
        if (n10) {
            int n11 = 1;
            if (n10 == n11) {
                n10 = this.w;
                j0.I(n10 != 0);
                object = this.x;
                j0.J((String)object);
            }
        } else {
            n10 = (int)(this.w ? 1 : 0);
            j0.F(n10 != 0);
        }
    }

    public void F(String object) {
        String string2;
        boolean bl2 = j0.D();
        if (!bl2) {
            return;
        }
        bl2 = j0.B();
        this.x = !bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = j0.E()))) ? (object = j0.E()) : object;
        object = ResConfig$AppResType.WATERMARK;
        string2 = this.x;
        this.x = object = TemEditorConfig.c((a)object, string2);
    }

    public boolean F0(int n10) {
        long l10;
        MainUseCase mainUseCase = this.q;
        n10 = mainUseCase != null && (n10 = (int)(this.G0(l10 = mainUseCase.I(n10)) ? 1 : 0)) != 0 ? 1 : 0;
        return n10 != 0;
    }

    public d.v.h.f.a G() {
        int n10 = this.J();
        return this.Q(n10);
    }

    public boolean G0(long l10) {
        boolean bl2;
        MainUseCase mainUseCase = this.q;
        bl2 = mainUseCase != null && (bl2 = mainUseCase.e0(l10));
        return bl2;
    }

    public String H() {
        Object object = this.r;
        if (object == null) {
            object = "";
        } else {
            int n10 = this.e0();
            object = ((a1)object).E0(n10);
        }
        return object;
    }

    public void H0(boolean bl2) {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.g0(bl2);
    }

    public MutableLiveData I() {
        return this.h;
    }

    public boolean I0(int n10, d.v.h.f.a a10) {
        return this.r.H0(n10, a10);
    }

    public boolean J0(d.v.h.f.a a10) {
        boolean bl2;
        int n10 = this.s0();
        if (n10 != 0) {
            bl2 = this.K0(a10);
        } else {
            n10 = this.J();
            bl2 = this.I0(n10, a10);
        }
        return bl2;
    }

    public long K() {
        return this.q.E();
    }

    public boolean K0(d.v.h.f.a a10) {
        return this.r.I0(a10);
    }

    public MutableLiveData L() {
        return this.i;
    }

    public void L0(int n10) {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.h0(n10);
    }

    public long M() {
        long l10;
        Object object = this.i.getValue();
        if (object == null) {
            l10 = -1;
        } else {
            object = (Long)this.i.getValue();
            l10 = (Long)object;
        }
        return l10;
    }

    public void M0(int n10) {
        Object object = this.n;
        Integer n11 = n10;
        d.v.e.i.h.g((MutableLiveData)object, n11);
        if (n10 == 0) {
            String string2;
            n10 = (int)(j0.A() ? 1 : 0);
            this.w = n10;
            this.x = string2 = m0.d();
        } else {
            int n12 = 1;
            if (n10 == n12) {
                Object object2;
                n10 = (int)(this.w ? 1 : 0);
                if (n10 == 0) {
                    n10 = (int)(j0.D() ? 1 : 0);
                    this.w = n10;
                }
                if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object2 = this.x)) ? 1 : 0)) != 0) {
                    this.x = object2 = j0.E();
                }
                object2 = ResConfig$AppResType.WATERMARK;
                object = this.x;
                this.x = object2 = TemEditorConfig.c((a)object2, (String)object);
            }
        }
    }

    public e N() {
        Object object = this.p;
        object = object != null && (object = ((LiveData)object).getValue()) != null ? (e)this.p.getValue() : null;
        return object;
    }

    public void N0(int n10) {
        this.t = n10;
    }

    public void O0(boolean bl2) {
        this.q.k0(bl2);
    }

    public d.v.h.f.a P() {
        boolean bl2 = this.s0();
        d.v.h.f.a a10 = bl2 ? this.R() : this.G();
        return a10;
    }

    public void P0(String string2, boolean bl2) {
        boolean bl3;
        boolean bl4 = this.W();
        MainUseCase mainUseCase = this.q;
        boolean bl5 = true;
        mainUseCase.l0(bl5, string2);
        this.x = string2;
        this.w = bl3 = TextUtils.isEmpty((CharSequence)string2) ^ bl5;
        if (bl4) {
            this.z0();
        }
        String string3 = (string2 = this.q.L()) == null ? "" : string2;
        j0.J(string3);
        j0.I(TextUtils.isEmpty((CharSequence)string2) ^ bl5);
        j0.G(bl2);
    }

    public d.v.h.f.a Q(int n10) {
        return this.r.u0(n10);
    }

    public boolean Q0(d.v.h.e.a object) {
        int n10;
        int n11 = TextUtils.isEmpty((CharSequence)(object = ((d.v.h.e.a)object).e()));
        if (n11 == 0 && (n11 = this.e0()) == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            n11 = 1;
        }
        return n11 != 0;
    }

    public d.v.h.f.a R() {
        boolean bl2 = this.s0();
        d.v.h.f.a a10 = bl2 ? this.r.v0() : new d.v.h.f.a();
        return a10;
    }

    public void R0() {
        int n10;
        Object object = this.q;
        if (object == null) {
            return;
        }
        object = this.m;
        Boolean bl2 = Boolean.FALSE;
        d.v.e.i.h.g((MutableLiveData)object, bl2);
        long l10 = this.M();
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return;
        }
        l12 = this.e0();
        if (l12 == (n10 = -1)) {
            return;
        }
        MainUseCase mainUseCase = this.q;
        long l13 = mainUseCase.I((int)l12);
        long l14 = l10 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 < 0) {
            return;
        }
        float f10 = l10 - l13;
        float f11 = this.r.y0((int)l12);
        long l15 = (long)(f10 / f11);
        l10 = this.r.A0((int)l12);
        long l16 = l15 + l10;
        this.q.z((int)l12, l15, l16);
        l10 = this.q.I((int)l12);
        this.G0(l10);
        this.r.e(false);
    }

    public LiveData S() {
        return this.f;
    }

    public void S0() {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.X();
    }

    public LiveData T() {
        return this.e;
    }

    public boolean T0(boolean bl2) {
        return this.r.K0(bl2);
    }

    public MutableLiveData U() {
        return this.o;
    }

    public void U0() {
        MutableLiveData mutableLiveData = this.g;
        Boolean bl2 = this.q.S();
        d.v.e.i.h.g(mutableLiveData, bl2);
    }

    public MutableLiveData V() {
        return this.g;
    }

    public void V0() {
        a1 a12 = this.r;
        if (a12 == null) {
            return;
        }
        boolean bl2 = a12.M0();
        if (bl2) {
            this.Y0();
        }
    }

    public boolean W() {
        boolean bl2;
        Object object = this.g.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.g.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public void W0() {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.m0();
        this.U0();
    }

    public List X() {
        return this.q.H();
    }

    public void X0() {
        int n10;
        Object object = this.q;
        if (object == null) {
            return;
        }
        int n11 = this.e0();
        if (n11 == (n10 = -1)) {
            Integer n12;
            boolean bl2;
            object = this.a;
            MainUseCase mainUseCase = this.q;
            if (mainUseCase != null && (bl2 = mainUseCase.R())) {
                n10 = 0;
                n12 = null;
            }
            n12 = n10;
            d.v.e.i.h.g((MutableLiveData)object, n12);
        } else {
            object = this.a;
            n10 = 1;
            Integer n13 = n10;
            d.v.e.i.h.g((MutableLiveData)object, n13);
        }
    }

    public List Y() {
        boolean bl2;
        Object object = this.q;
        if (object == null) {
            return Collections.emptyList();
        }
        if ((object = ((MainUseCase)object).H()) != null && !(bl2 = object.isEmpty())) {
            object = object.stream();
            Object object2 = w0.a;
            object = object.filter(object2);
            object2 = Collectors.toList();
            object = (List)object.collect(object2);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public void Y0() {
        void var2_6;
        boolean bl2;
        Object object = this.q;
        if (object == null) {
            return;
        }
        int bl22 = ((MainUseCase)object).F();
        int n10 = -1;
        float f10 = 0.0f / 0.0f;
        if (bl22 == n10) {
            return;
        }
        List list = this.q.H();
        object = (d)list.get(bl22);
        f10 = ((d)object).O();
        MutableLiveData mutableLiveData = this.d;
        float f11 = f10 - 0.0f;
        Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object2 != false && !(bl2 = ((d)object).Q())) {
            boolean bl3 = false;
            object = null;
        } else {
            boolean bl4 = true;
        }
        object = (boolean)var2_6;
        d.v.e.i.h.g(mutableLiveData, object);
    }

    public MutableLiveData Z() {
        return this.k;
    }

    public void Z0() {
        EditorUseCase editorUseCase = this.s;
        if (editorUseCase != null) {
            editorUseCase.p();
        }
    }

    public MutableLiveData a0() {
        return this.j;
    }

    public MutableLiveData b0() {
        return this.a;
    }

    public int c0() {
        int n10;
        Object object = this.a.getValue();
        if (object == null) {
            n10 = -1;
        } else {
            object = (Integer)this.a.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public MutableLiveData d0() {
        return this.b;
    }

    public int e0() {
        int n10;
        Object object = this.b.getValue();
        if (object == null) {
            n10 = -1;
        } else {
            object = (Integer)this.b.getValue();
            n10 = (Integer)object;
        }
        return n10;
    }

    public MutableLiveData f0() {
        return this.c;
    }

    public long i0() {
        return this.u;
    }

    public LiveData j0() {
        return Transformations.distinctUntilChanged(this.l);
    }

    public List l0(String[] stringArray) {
        a1 a12 = this.r;
        if (a12 == null) {
            return Collections.emptyList();
        }
        return a12.D0(stringArray);
    }

    public MutableLiveData m0() {
        return this.d;
    }

    public String n0() {
        return this.q.L();
    }

    public void o0(PlayerWrapperView playerWrapperView, List list) {
        int n10 = this.r.u();
        MainUseCase mainUseCase = this.q;
        b b10 = this.y;
        mainUseCase.N(playerWrapperView, list, n10, b10);
        int n11 = o1.c(d.v.e.f.a().c().getResources(), 2131099762);
        this.L0(n11);
    }

    public void onCleared() {
        super.onCleared();
        this.z();
    }

    public void onDestroy() {
        this.B0();
    }

    public void onPause() {
        this.S0();
    }

    public void p0(TemplatePOJO templatePOJO) {
        Object object = new MainUseCase();
        this.q = object;
        this.r = object = new a1(templatePOJO, true);
    }

    public void q0(TemplatePOJO templatePOJO, boolean bl2, boolean bl3) {
        Object object = new MainUseCase();
        this.q = object;
        this.r = object = new a1(templatePOJO, bl2, bl3, true);
    }

    public boolean r(e e10, boolean bl2) {
        Object object = this.q;
        if (object == null) {
            return false;
        }
        object = e10.b();
        List list = ((TemplatePOJO)object).getTemplateVideoList();
        boolean bl3 = d.v.j.b.f(list);
        boolean bl4 = true;
        if (bl3) {
            this.q.s();
            d.v.e.i.h.g(this.p, e10);
            return bl4;
        }
        if (bl2) {
            a1 a12 = this.r;
            bl2 = a12.K((TemplatePOJO)object);
            if (bl2) {
                object = this.p;
                d.v.e.i.h.g((MutableLiveData)object, e10);
            }
            return bl2;
        }
        this.r.n0((TemplatePOJO)object);
        d.v.e.i.h.g(this.p, e10);
        return bl4;
    }

    public boolean r0() {
        boolean bl2;
        MainUseCase mainUseCase = this.q;
        if (mainUseCase != null && (bl2 = mainUseCase.Q())) {
            bl2 = true;
        } else {
            bl2 = false;
            mainUseCase = null;
        }
        return bl2;
    }

    public void s(long l10) {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        int n10 = this.e0();
        long l11 = mainUseCase.I(n10) + l10;
        MutableLiveData mutableLiveData = this.i;
        Long l12 = l11;
        d.v.e.i.h.g(mutableLiveData, l12);
    }

    public boolean s0() {
        boolean bl2;
        Object object = this.o.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.o.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public boolean t(int n10) {
        int n11 = this.s0();
        if (n11 != 0) {
            n10 = (int)(this.v(n10) ? 1 : 0);
        } else {
            n11 = this.J();
            n10 = (int)(this.u(n11, n10) ? 1 : 0);
        }
        return n10 != 0;
    }

    public boolean t0() {
        boolean bl2;
        MainUseCase mainUseCase = this.q;
        if (mainUseCase != null && (bl2 = mainUseCase.R())) {
            bl2 = true;
        } else {
            bl2 = false;
            mainUseCase = null;
        }
        return bl2;
    }

    public boolean u(int n10, int n11) {
        return this.r.q0(n11, n10);
    }

    public boolean u0() {
        boolean bl2;
        Object object = this.m.getValue();
        if (object == null) {
            bl2 = false;
            object = null;
        } else {
            object = (Boolean)this.m.getValue();
            bl2 = (Boolean)object;
        }
        return bl2;
    }

    public boolean v(int n10) {
        return this.r.p0(n10);
    }

    public void w(g g10) {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.q(g10);
    }

    public void w0(boolean bl2) {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.n0(bl2);
    }

    public void x0(int n10, d.v.h.e.a object) {
        long l10;
        object = this.r;
        if (object == null) {
            return;
        }
        double d10 = ((a1)object).t0(n10);
        int n11 = this.t;
        int n12 = h2.b(66.0f);
        double d11 = n11 - n12;
        d10 /= d11;
        d11 = m0.l;
        this.u = l10 = (long)(d10 * d11);
        n11 = this.t;
        this.v = n11 = this.k0(n11, n10);
        object = this.b;
        Integer n13 = n10;
        d.v.e.i.h.g((MutableLiveData)object, n13);
        object = this.c;
        Long l11 = this.r.B0(n10);
        d.v.e.i.h.g((MutableLiveData)object, l11);
    }

    public void y() {
        Object object = this.q;
        if (object == null) {
            return;
        }
        object = this.m;
        Boolean bl2 = Boolean.TRUE;
        d.v.e.i.h.g((MutableLiveData)object, bl2);
        int n10 = this.e0();
        int n11 = -1;
        if (n10 == n11) {
            return;
        }
        long l10 = this.r.C0(n10);
        long l11 = this.r.A0(n10);
        long l12 = Math.max(l10, l11);
        this.r.H();
        this.q.z(n10, 0L, l12);
    }

    public void y0() {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.X();
        this.U0();
    }

    public void z() {
        Object object = this.q;
        if (object != null) {
            ((MainUseCase)object).B();
        }
        if ((object = this.s) != null) {
            ((EditorUseCase)object).i();
        }
    }

    public void z0() {
        MainUseCase mainUseCase = this.q;
        if (mainUseCase == null) {
            return;
        }
        mainUseCase.Y();
        this.U0();
    }
}

