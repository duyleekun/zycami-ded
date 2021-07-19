/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.InputFilter
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package d.v.c.u1.n;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.zhiyun.cama.template.list.ScaleLayoutManager;
import com.zhiyun.cama.template.list.TemplateListAdapter;
import com.zhiyun.cama.template.list.TemplateListAdapter$c;
import com.zhiyun.cama.template.list.TemplateListAdapter$d;
import com.zhiyun.cama.template.list.TemplateListAdapter$e;
import com.zhiyun.cama.widget.RingProgressBar;
import com.zhiyun.editorinterface.EditConfig$a;
import com.zhiyun.editortemplate.data.database.model.template.Template;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.resource.Status;
import com.zhiyun.editortemplate.util.download.DownloadEvent;
import d.v.c.q0.d;
import d.v.c.u1.n.a;
import d.v.c.u1.n.b0;
import d.v.c.u1.n.d0$a;
import d.v.c.u1.n.d0$b;
import d.v.c.u1.n.d0$c;
import d.v.c.u1.n.d0$d;
import d.v.c.u1.n.e0;
import d.v.c.u1.n.f;
import d.v.c.u1.n.g;
import d.v.c.u1.n.h;
import d.v.c.u1.n.i;
import d.v.c.u1.n.j;
import d.v.c.u1.n.k;
import d.v.c.u1.n.l;
import d.v.c.u1.n.m;
import d.v.c.u1.n.n;
import d.v.c.u1.n.o;
import d.v.c.u1.n.p;
import d.v.c.u1.n.q;
import d.v.c.u1.n.r;
import d.v.c.u1.n.s;
import d.v.c.u1.n.t;
import d.v.c.w0.p8;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.g0.i$b;
import d.v.g0.i$c;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import d.v.j.g.z;
import java.util.ArrayList;
import java.util.List;

public class d0
extends d {
    private static final String x = "typeId";
    private static final String y = "empty";
    private p8 j;
    private SwipeRefreshLayout k;
    private RecyclerView l;
    private ViewTreeObserver.OnGlobalLayoutListener m;
    private ScaleLayoutManager n;
    private TemplateListAdapter o;
    private d.v.j.f.g p;
    private z q;
    private m2$d r;
    private int s;
    private long t;
    private boolean u;
    private d.v.g0.k v;
    private d.v.c.u1.k w;

    public static /* synthetic */ TemplateListAdapter A(d0 d02) {
        return d02.o;
    }

    private void A0() {
        ArrayList<TemplatePOJO> arrayList = new ArrayList<TemplatePOJO>();
        TemplateData templateData = new TemplateData();
        Object object = EditConfig$a.l[0];
        templateData.setVideoRatio((String)object);
        object = new Template();
        ((Template)object).setEmpty(true);
        TemplatePOJO templatePOJO = new TemplatePOJO(templateData, (Template)object);
        arrayList.add(templatePOJO);
        this.o.u(arrayList);
        this.o.notifyDataSetChanged();
    }

    public static /* synthetic */ z B(d0 d02) {
        return d02.q;
    }

    private void B0() {
        n2.e(d.v.f.i.g.o(this.getResources(), 2131952827));
    }

    public static /* synthetic */ void C(d0 d02) {
        d02.B0();
    }

    private void C0(TemplatePOJO object) {
        Object object2 = this.requireContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$b)((k$a)object3).A(2131952807)).h(2131952808);
        object2 = ((TemplatePOJO)object).getTemplateData().showTitle();
        object3 = (k$b)((k$b)((k$b)((k$a)object3).k((String)object2)).E(true)).s();
        object2 = a.a;
        object3 = (k$b)((k$a)object3).p((d.v.f.f.a)object2);
        object2 = new i(this, (TemplatePOJO)object);
        object = (k$b)((k$a)object3).w((d.v.f.f.a)object2);
        object3 = d.v.f.i.f.c();
        object = (k$b)((k$a)object).a((InputFilter)object3);
        object3 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    private void D(TemplatePOJO object) {
        Object object2 = this.v;
        if (object2 != null) {
            return;
        }
        object2 = this.q;
        boolean bl2 = ((z)object2).g();
        if (bl2) {
            object2 = this.q;
            bl2 = ((z)object2).f();
            if (bl2) {
                object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
                Object object3 = this.getContext();
                Object object4 = new k$b((Context)object3);
                object2 = (k$b)((k$a)object4).n((String)object2);
                object4 = new p(this);
                object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
                int n10 = 2131951892;
                object3 = new j(this, (TemplatePOJO)object);
                this.v = object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
                object2 = this.getChildFragmentManager();
                object4 = this.getClass().getSimpleName();
                ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
            } else {
                object2 = this.p;
                ((d.v.j.f.g)object2).d((TemplatePOJO)object);
            }
        } else {
            this.B0();
        }
    }

    private void D0() {
        n2.e(d.v.f.i.g.o(this.getResources(), 2131952105));
    }

    public static Bundle E(long l10) {
        Bundle bundle = new Bundle();
        bundle.putLong(x, l10);
        return bundle;
    }

    private void E0() {
        n2.e(d.v.f.i.g.o(this.getResources(), 2131953150));
    }

    public static Bundle F(boolean bl2) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(y, bl2);
        return bundle;
    }

    private void F0(long l10) {
        m2$d m2$d;
        this.G0();
        k k10 = new k(this);
        this.r = m2$d = m2.Y(l10, k10);
    }

    private void G0() {
        m2.a(this.r);
        this.r = null;
    }

    private String H(List object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            TemplateData templateData = ((TemplatePOJO)object.next()).getTemplateData();
            long l10 = templateData.getId();
            stringBuilder.append(l10);
        }
        return stringBuilder.toString();
    }

    private int I(long l10) {
        int n10;
        Object object = this.o;
        if (object != null && (object = ((TemplateListAdapter)object).d()) != null) {
            int n11;
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                Template template = ((TemplatePOJO)object.get(n10)).getTemplate();
                long l11 = template.getId();
                long l12 = l10 - l11;
                n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                if (n11 != 0) {
                    continue;
                }
                break;
            }
        } else {
            n10 = -1;
        }
        return n10;
    }

    private void J(ViewDataBinding object) {
        d.v.j.f.g g10;
        Object object2 = (d.v.c.u1.k)d.v.i0.b.c(this.requireActivity()).get(d.v.c.u1.k.class);
        this.w = object2;
        object2 = d.v.i0.b.a(this);
        this.p = g10 = (d.v.j.f.g)((ViewModelProvider)object2).get(d.v.j.f.g.class);
        this.q = object2 = (z)((ViewModelProvider)object2).get(z.class);
        object = (p8)object;
        this.j = object;
        this.k = object2 = ((p8)object).b;
        this.l = object = ((p8)object).a;
    }

    private void K() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            boolean bl2;
            long l10;
            this.t = l10 = bundle.getLong(x);
            String string2 = y;
            this.u = bl2 = bundle.getBoolean(string2, false);
        }
    }

    private void L() {
        Object object = new g(this);
        this.m = object;
        object = this.l.getViewTreeObserver();
        Object object2 = this.m;
        object.addOnGlobalLayoutListener(object2);
        object = this.l;
        object2 = new d0$b(this);
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
        object = this.o;
        if (object == null) {
            return;
        }
        object2 = new d0$c(this);
        ((TemplateListAdapter)object).x((TemplateListAdapter$d)object2);
        object = this.o;
        object2 = new l(this);
        ((TemplateListAdapter)object).w((TemplateListAdapter$c)object2);
    }

    private void M() {
        LiveData liveData = this.p.i();
        Object object = new o(this);
        liveData.observe(this, (Observer)object);
        liveData = this.p.e();
        object = new f(this);
        liveData.observe(this, (Observer)object);
        liveData = this.j.getRoot().getViewTreeObserver();
        object = new d0$a(this);
        liveData.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
        liveData = this.w.e();
        object = this.getViewLifecycleOwner();
        r r10 = new r(this);
        liveData.observe((LifecycleOwner)object, r10);
    }

    private void N() {
        Object object = this.getContext();
        Object object2 = new ScaleLayoutManager((Context)object, 0, false);
        object2 = ((ScaleLayoutManager)object2).g(0.8f);
        float f10 = 1.0f;
        object2 = ((ScaleLayoutManager)object2).e(f10).f(0.3f).d(f10);
        this.n = object2;
        this.l.setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = new e0();
        object = this.l;
        ((e0)object2).attachToRecyclerView((RecyclerView)object);
        this.k.setEnabled(false);
    }

    private /* synthetic */ void O(DialogFragment dialogFragment) {
        this.v = null;
        this.q.i(false);
    }

    private /* synthetic */ void Q(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.v = null;
        this.q.i(true);
        this.p.d(templatePOJO);
    }

    private /* synthetic */ void S() {
        TemplateListAdapter templateListAdapter = this.o;
        if (templateListAdapter == null) {
            return;
        }
        this.n.c();
    }

    private /* synthetic */ void U(View object, int n10) {
        TemplatePOJO templatePOJO = (TemplatePOJO)this.o.d().get(n10);
        TemplateData templateData = templatePOJO.getTemplateData();
        boolean bl2 = templateData.isDownloadFinished();
        if (bl2) {
            object = this.p;
            boolean bl3 = ((d.v.j.f.g)object).b(templatePOJO);
            if (bl3) {
                object = this.w;
                ((d.v.c.u1.k)object).m(templatePOJO);
            } else {
                bl3 = templateData.isNetworkTemplate();
                if (bl3) {
                    this.D0();
                } else {
                    this.E0();
                }
                object = this.p;
                ((d.v.j.f.g)object).K(templatePOJO);
            }
        } else {
            int n11;
            int n12 = object instanceof RingProgressBar;
            if (n12 != 0 && (n11 = ((RingProgressBar)((Object)(object = (RingProgressBar)((Object)object)))).getProgress()) < (n12 = 100)) {
                this.D(templatePOJO);
            }
        }
    }

    private /* synthetic */ void W(d.v.j.e.h.k object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("get templateDataList, state:");
        Status status = ((d.v.j.e.h.k)object).a;
        ((StringBuilder)object2).append((Object)status);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        status = null;
        Object object3 = new Object[]{};
        m.a.a.b((String)object2, (Object[])object3);
        object2 = d0$d.b;
        object3 = ((d.v.j.e.h.k)object).a;
        int n10 = ((Enum)object3).ordinal();
        Object object4 = object2[n10];
        n10 = 2;
        if (object4 != n10) {
            n10 = 3;
            if (object4 == n10 || object4 == (n10 = 4)) {
                object2 = this.k;
                ((SwipeRefreshLayout)object2).setRefreshing(false);
                object = (List)((d.v.j.e.h.k)object).c;
                this.w0((List)object);
            }
        } else {
            object = this.k;
            object4 = true;
            ((SwipeRefreshLayout)object).setRefreshing((boolean)object4);
        }
    }

    private /* synthetic */ void Y(Pair object) {
        if (object != null) {
            Long l10 = (Long)((Pair)object).first;
            long l11 = l10;
            int n10 = this.I(l11);
            object = (DownloadEvent)((Pair)object).second;
            this.J0(n10, (DownloadEvent)object);
        }
    }

    private /* synthetic */ void a0(Integer n10) {
        if (n10 == null) {
            return;
        }
        int n11 = n10;
        if (n11 != 0) {
            int n12 = 1;
            if (n11 == n12) {
                this.r0();
            }
        } else {
            this.s0();
        }
    }

    private /* synthetic */ void c0(DialogFragment dialogFragment) {
        this.v = null;
        int n10 = this.G();
        this.M0(n10, false, true);
        this.q.i(false);
    }

    private /* synthetic */ void e0(DialogFragment dialogFragment) {
        this.v = null;
        int n10 = this.G();
        boolean bl2 = true;
        this.M0(n10, bl2, bl2);
        this.q.i(bl2);
    }

    public static /* synthetic */ void g0(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void h0(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.p.c(templatePOJO);
        n2.e(d.v.f.i.g.o(this.getResources(), 2131952030));
    }

    private /* synthetic */ void j0(TemplatePOJO templatePOJO, int n10) {
        if (n10 == 0) {
            this.C0(templatePOJO);
        } else {
            int n11 = 1;
            if (n10 == n11) {
                this.x0(templatePOJO);
            }
        }
    }

    public static /* synthetic */ void l0() {
    }

    private /* synthetic */ void m0(TemplatePOJO object, DialogFragment dialogFragment) {
        Object object2 = dialogFragment;
        object2 = ((d.v.g0.k)dialogFragment).G();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object2);
        if (bl2) {
            return;
        }
        d.v.j.f.g g10 = this.p;
        object = ((TemplatePOJO)object).getTemplateData();
        g10.I((TemplateData)object, (String)object2, (String)object2, (String)object2);
        dialogFragment.dismiss();
    }

    private /* synthetic */ void o0() {
        this.u0(false);
    }

    private void q0() {
        ViewModel viewModel = this.p;
        boolean bl2 = ((d.v.j.f.g)viewModel).n();
        if (!bl2) {
            viewModel = this.q;
            bl2 = ((z)viewModel).g();
            if (!bl2) {
                this.B0();
            }
            if (!(bl2 = this.u)) {
                viewModel = this.p;
                long l10 = this.t;
                ((d.v.j.f.g)viewModel).H(l10, 0);
            } else {
                bl2 = false;
                viewModel = null;
                this.w0(null);
            }
        }
    }

    private void r0() {
        this.G0();
        int n10 = this.G();
        this.L0(n10, false);
    }

    private void s0() {
        d.v.j.f.g g10 = this.p;
        boolean bl2 = g10.m();
        if (bl2) {
            bl2 = false;
            g10 = null;
            this.u0(false);
        }
    }

    public static /* synthetic */ p8 x(d0 d02) {
        return d02.j;
    }

    private void x0(TemplatePOJO object) {
        Object object2 = this.requireContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$a)object3).A(2131952111);
        object2 = d.v.c.u1.n.n.a;
        object3 = (k$b)((k$a)object3).p((d.v.f.f.a)object2);
        object2 = new m(this, (TemplatePOJO)object);
        object = (k$b)((k$a)object3).w((d.v.f.f.a)object2);
        object3 = this.getParentFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    public static /* synthetic */ void y(d0 d02) {
        d02.q0();
    }

    public static /* synthetic */ RecyclerView z(d0 d02) {
        return d02.l;
    }

    public int G() {
        return this.s;
    }

    public void H0(int n10, int n11, int n12) {
        int n13;
        int n14 = -1;
        if (n10 != n14 && n10 != (n13 = this.s) && n12 == 0) {
            this.s = n10;
            this.u0(false);
            if (n10 > 0) {
                n13 = n10 + -1;
                this.L0(n13, false);
            }
            n13 = this.s;
            this.I0(n13);
        }
        if (n11 != n14 && (n14 = this.s) != n11) {
            this.L0(n11, false);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mCurrentPosition\uff1a");
        n13 = this.s;
        stringBuilder.append(n13);
        stringBuilder.append("\uff0cvisiblePosition:");
        stringBuilder.append(n10);
        stringBuilder.append(",lastVisibleItemPosition:");
        stringBuilder.append(n11);
        stringBuilder.append(",newState:");
        stringBuilder.append(n12);
        String string2 = stringBuilder.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.b(string2, objectArray);
    }

    public void I0(int n10) {
        int n11;
        Object object = this.o;
        if (object == null) {
            return;
        }
        if ((object = ((TemplateListAdapter)object).d()) != null && n10 >= 0 && n10 < (n11 = object.size())) {
            object = (TemplatePOJO)object.get(n10);
            Object object2 = this.l;
            RecyclerView$ViewHolder recyclerView$ViewHolder = ((RecyclerView)object2).findViewHolderForAdapterPosition(n10);
            n11 = recyclerView$ViewHolder instanceof TemplateListAdapter$e;
            if (n11 != 0) {
                object2 = this.o;
                recyclerView$ViewHolder = (TemplateListAdapter$e)recyclerView$ViewHolder;
                ((TemplateListAdapter)object2).v((TemplateListAdapter$e)recyclerView$ViewHolder, (TemplatePOJO)object);
            }
        }
    }

    public void J0(int n10, DownloadEvent object) {
        int n11;
        Object object2 = this.o;
        if (object2 == null) {
            return;
        }
        if ((object2 = ((TemplateListAdapter)object2).d()) != null && n10 >= 0 && n10 < (n11 = object2.size())) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = this.l.findViewHolderForAdapterPosition(n10);
            TemplatePOJO templatePOJO = (TemplatePOJO)object2.get(n10);
            boolean bl2 = recyclerView$ViewHolder instanceof TemplateListAdapter$e;
            if (bl2) {
                this.y0((DownloadEvent)object);
                object = this.o;
                recyclerView$ViewHolder = (TemplateListAdapter$e)recyclerView$ViewHolder;
                ((TemplateListAdapter)object).v((TemplateListAdapter$e)recyclerView$ViewHolder, templatePOJO);
            }
        }
    }

    public void K0(int n10) {
        Object object = this.o;
        if (object == null) {
            return;
        }
        object = this.l.findViewHolderForAdapterPosition(n10);
        boolean bl2 = object instanceof TemplateListAdapter$e;
        if (bl2) {
            TemplateListAdapter templateListAdapter = this.o;
            object = (TemplateListAdapter$e)object;
            templateListAdapter.C((TemplateListAdapter$e)object, n10);
        }
    }

    public void L0(int n10, boolean bl2) {
        this.M0(n10, bl2, false);
    }

    public void M0(int n10, boolean bl2, boolean bl3) {
        TemplateListAdapter templateListAdapter;
        boolean bl4 = this.isResumed();
        if (!bl4 && bl2) {
            return;
        }
        if (n10 < 0) {
            return;
        }
        RecyclerView$ViewHolder recyclerView$ViewHolder = this.l.findViewHolderForAdapterPosition(n10);
        boolean bl5 = recyclerView$ViewHolder instanceof TemplateListAdapter$e;
        if (bl5 && (templateListAdapter = this.o) != null) {
            recyclerView$ViewHolder = (TemplateListAdapter$e)recyclerView$ViewHolder;
            templateListAdapter.D((TemplateListAdapter$e)recyclerView$ViewHolder, n10, bl2, bl3);
        }
    }

    public /* synthetic */ void P(DialogFragment dialogFragment) {
        this.O(dialogFragment);
    }

    public /* synthetic */ void R(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.Q(templatePOJO, dialogFragment);
    }

    public /* synthetic */ void T() {
        this.S();
    }

    public /* synthetic */ void V(View view, int n10) {
        this.U(view, n10);
    }

    public /* synthetic */ void X(d.v.j.e.h.k k10) {
        this.W(k10);
    }

    public /* synthetic */ void Z(Pair pair) {
        this.Y(pair);
    }

    public /* synthetic */ void b0(Integer n10) {
        this.a0(n10);
    }

    public /* synthetic */ void d0(DialogFragment dialogFragment) {
        this.c0(dialogFragment);
    }

    public /* synthetic */ void f0(DialogFragment dialogFragment) {
        this.e0(dialogFragment);
    }

    public int h() {
        return 2131558595;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        this.J(viewDataBinding);
        this.K();
        this.N();
        this.M();
    }

    public /* synthetic */ void i0(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.h0(templatePOJO, dialogFragment);
    }

    public /* synthetic */ void k0(TemplatePOJO templatePOJO, int n10) {
        this.j0(templatePOJO, n10);
    }

    public /* synthetic */ void n0(TemplatePOJO templatePOJO, DialogFragment dialogFragment) {
        this.m0(templatePOJO, dialogFragment);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onCreateView:");
        charSequence.append(this);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.i((String)charSequence, objectArray);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onDestroyView:");
        charSequence.append(this);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        m.a.a.i((String)charSequence, objectArray);
        super.onDestroyView();
        charSequence = this.m;
        if (charSequence != null) {
            charSequence = this.l.getViewTreeObserver();
            objectArray = this.m;
            charSequence.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)objectArray);
        }
    }

    public void onPause() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onPause:");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.i((String)object, objectArray);
        super.onPause();
        object = this.w;
        boolean bl2 = ((d.v.c.u1.k)object).f();
        if (bl2) {
            this.r0();
        }
    }

    public void onResume() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onResume:");
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        m.a.a.i((String)object, objectArray);
        super.onResume();
        object = this.w;
        boolean bl2 = ((d.v.c.u1.k)object).f();
        if (bl2) {
            this.s0();
        }
    }

    public /* synthetic */ void p0() {
        this.o0();
    }

    /*
     * WARNING - void declaration
     */
    public void t0(boolean bl2, boolean bl3) {
        void var2_3;
        if (var2_3 == false) {
            this.v0(bl2);
        } else {
            int n10 = this.G();
            this.L0(n10, (boolean)var2_3);
        }
    }

    public void u0(boolean bl2) {
        boolean bl3 = this.isResumed();
        if (bl3) {
            z z10 = this.q;
            bl3 = z10.e() ^ true;
            this.t0(bl2, bl3);
        }
    }

    public void v0(boolean bl2) {
        Object object;
        boolean bl3;
        Object object2 = this.v;
        if (object2 != null) {
            return;
        }
        if (!bl2 && (bl3 = ((z)(object = this.q)).c())) {
            int n10 = this.G();
            boolean bl4 = false;
            object2 = null;
            boolean bl5 = true;
            this.M0(n10, false, bl5);
        } else {
            object2 = this.getContext();
            object = new k$b((Context)object2);
            object = (k$b)((k$a)object).m(2131951893);
            object2 = new h(this);
            object = (k$b)((k$a)object).p((d.v.f.f.a)object2);
            int n11 = 2131951892;
            Object object3 = new s(this);
            object = ((k$b)((k$b)((k$a)object).v(n11, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object3 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object3);
        }
    }

    public void w0(List object) {
        int n10;
        int n11;
        Object object2;
        Object object3 = this.l.getAdapter();
        if (object3 == null) {
            object2 = this.requireContext();
            d.v.j.g.d0.f f10 = this.p.f();
            this.o = object3 = new TemplateListAdapter((Context)object2, f10);
            object2 = this.l;
            ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object3);
            this.L();
        }
        if ((n11 = d.v.j.b.f((List)object)) == 0) {
            object3 = b0.a;
            object.forEach(object3);
            object3 = this.H((List)object);
            object2 = this.o.d();
            object2 = this.H((List)object2);
            n11 = (int)(((String)object3).equals(object2) ? 1 : 0);
            if (n11 != 0) {
                object3 = this.o;
                ((TemplateListAdapter)object3).u((List)object);
                n10 = this.G();
                this.K0(n10);
            } else {
                object3 = this.o;
                ((TemplateListAdapter)object3).u((List)object);
                object = this.o;
                ((RecyclerView$Adapter)object).notifyDataSetChanged();
                long l10 = 100;
                this.F0(l10);
            }
        } else {
            this.A0();
        }
        n10 = this.s;
        n11 = this.o.d().size() + -1;
        this.s = n10 = Math.min(n10, n11);
        this.l.scrollToPosition(n10);
    }

    public void y0(DownloadEvent object) {
        int n10;
        if (object == null) {
            return;
        }
        boolean n102 = ((DownloadEvent)object).isSingleEvent();
        if (!n102) {
            return;
        }
        int[] nArray = d0$d.a;
        object = ((DownloadEvent)object).getDownloadState();
        int n11 = ((Enum)object).ordinal();
        int n12 = 1;
        if ((n11 = nArray[n11]) != n12 && n11 != (n10 = 2)) {
            int n13 = 3;
            if (n11 != n13) {
                int n14 = 4;
                if (n11 == n14) {
                    this.B0();
                }
            } else {
                object = this.getResources();
                int n15 = 2131952100;
                object = d.v.f.i.g.o((Resources)object, n15);
                n2.e((String)object);
            }
        } else {
            this.D0();
        }
    }

    public void z0(int n10) {
        Object object = (TemplatePOJO)this.o.d().get(n10);
        Object object2 = new ArrayList();
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131952826);
        int n11 = o1.a(this.requireContext(), 2131099772);
        Object object3 = new d.v.g0.o(string2, n11);
        object2.add(object3);
        string2 = d.v.f.i.g.m(this.requireContext(), 2131951903);
        n11 = o1.a(this.requireContext(), 2131099853);
        object3 = new d.v.g0.o(string2, n11);
        object2.add(object3);
        object2 = d.v.g0.i.v().B((List)object2);
        object3 = new t(this, (TemplatePOJO)object);
        object = ((d.v.g0.i)object2).D((i$c)object3);
        object2 = d.v.c.u1.n.q.a;
        object = ((d.v.g0.i)object).C((i$b)object2);
        object2 = this.getChildFragmentManager();
        object3 = d.v.g0.i.class.getName();
        ((DialogFragment)object).show((FragmentManager)object2, (String)object3);
    }
}

