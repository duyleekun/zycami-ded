/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnInfoListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package d.v.c.s0.h7.p0;

import android.content.Context;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.SnapHelper;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.p0.c;
import d.v.c.s0.h7.p0.f;
import d.v.c.s0.h7.p0.g;
import d.v.c.s0.h7.p0.h;
import d.v.c.s0.h7.p0.i;
import d.v.c.s0.h7.p0.j;
import d.v.c.s0.h7.p0.k;
import d.v.c.s0.h7.p0.o;
import d.v.c.s0.h7.p0.p$a;
import d.v.c.s0.h7.p0.p$b;
import d.v.c.s0.h7.p0.p$c;
import d.v.c.s0.h7.p0.q;
import d.v.c.w0.l9;
import d.v.e.h.a;
import d.v.i0.b;
import d.v.j.e.i.f1;
import java.util.Collections;
import java.util.List;

public class p
extends d.v.f.h.a {
    private l9 b;
    private q c;
    private m0 d;
    private f1 e;
    private BleViewModel f;
    private o g;
    private LinearSnapHelper h;
    private LinearLayoutManager i;
    private boolean j = false;
    private boolean k = false;
    private boolean l = true;
    private int m;

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void B(Integer object) {
        int n10;
        Object object3;
        int n11;
        int n12;
        int n102;
        Object object2;
        if (object != null && (object2 = this.g.getData()) != null && (n102 = ((Integer)object).intValue()) >= 0 && (n102 = ((Integer)object).intValue()) <= (n12 = (n11 = (object3 = this.g.getData()).size()) - (n10 = 1))) {
            object2 = this.g;
            int n13 = (Integer)object;
            if ((object2 = ((d.v.c.n0.c)object2).getItem(n13)) != null) {
                n102 = (Integer)object;
                this.L(n102);
                object2 = this.g;
                int n14 = (Integer)object;
                object2 = ((TemplatePOJO)((d.v.c.n0.c)object2).getItem(n14)).getTemplateData();
                object3 = this.c.e();
                ((MutableLiveData)object3).setValue(object2);
                int n15 = (Integer)object;
                if (n15 == 0) {
                    object = this.c.c;
                    object3 = Boolean.FALSE;
                    ((MutableLiveData)object).setValue(object3);
                    this.c.d.setValue(object3);
                    object = this.b.k;
                    object3 = d.v.f.i.g.o(this.getResources(), 2131953138);
                    object.setText((CharSequence)object3);
                    object = this.b.j;
                    object3 = d.v.f.i.g.o(this.getResources(), 2131953133);
                    object.setText((CharSequence)object3);
                    object = this.b.i;
                    object3 = this.getResources();
                    int n16 = 2131953137;
                    object3 = d.v.f.i.g.o((Resources)object3, n16);
                    object.setText((CharSequence)object3);
                } else {
                    void var5_13;
                    boolean bl2;
                    object = this.c.c;
                    boolean bl3 = ((TemplateData)object2).isDIYTemplate();
                    if (!bl3 && !(bl2 = ((TemplateData)object2).isNetworkTemplate())) {
                        boolean bl4 = false;
                        object3 = null;
                    } else {
                        int n17 = n10;
                    }
                    object3 = (boolean)var5_13;
                    ((MutableLiveData)object).setValue(object3);
                    object = this.c.d;
                    boolean bl5 = ((TemplateData)object2).isDIYTemplate();
                    object3 = bl5;
                    ((MutableLiveData)object).setValue(object3);
                    object = this.b.k;
                    object3 = ((TemplateData)object2).showTitle();
                    object.setText((CharSequence)object3);
                    object = this.b.j;
                    object3 = ((TemplateData)object2).showDesc();
                    object.setText((CharSequence)object3);
                    object = this.b.i;
                    object3 = this.getResources();
                    int n18 = 2131951854;
                    object3 = d.v.f.i.g.o((Resources)object3, n18);
                    object.setText((CharSequence)object3);
                }
                this.N((TemplateData)object2, n10 != 0);
                this.M();
            }
        }
    }

    private /* synthetic */ void D(Boolean bl2) {
        this.b.i.performClick();
    }

    private /* synthetic */ void F(View object, int n10, Integer n11) {
        m0 m02;
        int n12 = n11;
        if (n12 == (n10 = (m02 = this.d).m())) {
            return;
        }
        object = this.d;
        n10 = n11;
        ((m0)object).d0(n10);
    }

    public static /* synthetic */ boolean H(MediaPlayer mediaPlayer, int n10, int n11) {
        return true;
    }

    public static /* synthetic */ void I(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
    }

    private /* synthetic */ boolean J(MediaPlayer object, int n10, int n11) {
        int n12 = 3;
        if (n10 == n12 && (n12 = (int)(((q)(object = this.c)).d() ? 1 : 0)) != 0) {
            object = this.c.c();
            Boolean bl2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl2);
        }
        return false;
    }

    private void L(int n10) {
        if (n10 < 0) {
            return;
        }
        RecyclerView recyclerView = this.b.g;
        recyclerView.scrollToPosition(++n10);
        recyclerView = this.b.g;
        n10 = -this.t(n10);
        recyclerView.scrollBy(0, n10);
    }

    private void M() {
        Object object = (TemplateData)this.c.e().getValue();
        if (object != null) {
            ViewModel viewModel = this.e;
            long l10 = ((TemplateData)object).getId();
            object = ((f1)viewModel).j(l10);
            viewModel = this.d;
            ((m0)viewModel).e0((LiveData)object);
        }
    }

    private void N(TemplateData object, boolean bl2) {
        Object object2;
        boolean bl3;
        if (bl2 && (object == null || (bl3 = TextUtils.isEmpty((CharSequence)(object2 = ((TemplateData)object).getVideoUrl()))))) {
            return;
        }
        object2 = this.b.m;
        if (bl2) {
            object2.suspend();
            bl2 = false;
            object2.setMediaController(null);
            j j10 = d.v.c.s0.h7.p0.j.a;
            object2.setOnErrorListener((MediaPlayer.OnErrorListener)j10);
            object = ((TemplateData)object).getVideoUrl();
            object2.setVideoPath((String)object);
            object = d.v.c.s0.h7.p0.i.a;
            object2.setOnPreparedListener((MediaPlayer.OnPreparedListener)object);
            object2.start();
            this.j = true;
            object = this.c;
            boolean bl4 = ((q)object).d();
            if (!bl4) {
                return;
            }
            object = new f(this);
            object2.setOnInfoListener((MediaPlayer.OnInfoListener)object);
        } else {
            object2.suspend();
        }
    }

    public static /* synthetic */ boolean j(p p10) {
        return p10.k;
    }

    public static /* synthetic */ boolean k(p p10, boolean bl2) {
        p10.k = bl2;
        return bl2;
    }

    public static /* synthetic */ LinearLayoutManager l(p p10) {
        return p10.i;
    }

    public static /* synthetic */ LinearSnapHelper m(p p10) {
        return p10.h;
    }

    public static /* synthetic */ m0 n(p p10) {
        return p10.d;
    }

    public static /* synthetic */ l9 o(p p10) {
        return p10.b;
    }

    public static /* synthetic */ void p(p p10, int n10) {
        p10.L(n10);
    }

    public static /* synthetic */ q q(p p10) {
        return p10.c;
    }

    public static /* synthetic */ BleViewModel r(p p10) {
        return p10.f;
    }

    public static /* synthetic */ void s(p p10) {
        p10.M();
    }

    private int t(int n10) {
        LinearLayoutManager linearLayoutManager = this.i;
        View view = linearLayoutManager.findViewByPosition(n10);
        if (view != null) {
            int n11 = view.getTop();
            n10 = view.getBottom();
            int n12 = this.m;
            return (n12 - (n10 += n11)) / 2;
        }
        return 0;
    }

    private void u(int n10) {
        ViewTreeObserver viewTreeObserver = this.b.g.getViewTreeObserver();
        p$b p$b = new p$b(this, n10);
        viewTreeObserver.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)p$b);
    }

    public static p v() {
        p p10 = new p();
        return p10;
    }

    private void w() {
        boolean bl2 = a.c((Boolean)this.f.L.getValue());
        Model model = this.f.x();
        MediatorLiveData mediatorLiveData = this.c.e;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        c c10 = new c(this, bl2, model);
        mediatorLiveData.observe(lifecycleOwner, c10);
    }

    private void x() {
        Object object = this.d.l();
        Object object2 = this.getViewLifecycleOwner();
        Observer observer = new k(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.b.g;
        object2 = new p$a(this);
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
        object = this.f.m;
        object2 = this.getViewLifecycleOwner();
        g g10 = new g(this);
        observer = new d.v.e.i.f(g10);
        ((StackLiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.g;
        object2 = new h(this);
        ((o)object).g((d.v.f.f.b)object2);
    }

    private void y() {
        Object object = this.d;
        Object object2 = new o(this, (m0)object);
        this.g = object2;
        object = Collections.emptyList();
        ((d.v.c.n0.c)object2).d((List)object);
        object = this.requireContext();
        boolean bl2 = true;
        this.i = object2 = new LinearLayoutManager((Context)object, (int)(bl2 ? 1 : 0), bl2);
        this.b.g.setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = this.b.g;
        object = this.g;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        this.h = object2 = new LinearSnapHelper();
        object = this.b.g;
        ((SnapHelper)object2).attachToRecyclerView((RecyclerView)object);
    }

    private /* synthetic */ void z(boolean bl2, Model object, List object2) {
        Object object3;
        Boolean bl3;
        q q10 = this.c;
        Object object4 = TemplateData.RATIO_STR_ARRAY;
        int n10 = 3;
        object4 = object4[n10];
        List list = q10.s((List)((Object)bl3), (String)object4, bl2, (Model)((Object)object3));
        object3 = this.g;
        ((d.v.c.n0.c)object3).d(list);
        boolean bl4 = this.l;
        if (bl4) {
            object3 = this.c.c();
            bl3 = Boolean.TRUE;
            ((MutableLiveData)object3).setValue(bl3);
            int n11 = this.c.i(list);
            object3 = this.d;
            ((m0)object3).d0(n11);
            this.u(n11);
            boolean bl5 = false;
            list = null;
            this.l = false;
        }
    }

    public /* synthetic */ void A(boolean bl2, Model model, List list) {
        this.z(bl2, model, list);
    }

    public /* synthetic */ void C(Integer n10) {
        this.B(n10);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public /* synthetic */ void G(View view, int n10, Integer n11) {
        this.F(view, n10, n11);
    }

    public /* synthetic */ boolean K(MediaPlayer mediaPlayer, int n10, int n11) {
        return this.J(mediaPlayer, n10, n11);
    }

    public int h() {
        return 2131558606;
    }

    public void i(ViewDataBinding viewDataBinding) {
        int n10;
        super.i(viewDataBinding);
        viewDataBinding = (l9)viewDataBinding;
        this.b = viewDataBinding;
        this.m = n10 = Windows.l(this.requireContext()).getHeight();
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        ViewModelProvider viewModelProvider = d.v.i0.b.a(this);
        this.c = viewModel = (q)viewModelProvider.get(q.class);
        viewModel = (m0)((ViewModelProvider)object).get(m0.class);
        this.d = viewModel;
        this.f = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.e = object = (f1)viewModelProvider.get(f1.class);
    }

    public void onDestroy() {
        super.onDestroy();
        this.N(null, false);
    }

    public void onPause() {
        super.onPause();
        this.k = false;
        this.N(null, false);
    }

    public void onResume() {
        super.onResume();
        Object object = this.d;
        ((m0)object).H();
        int n10 = this.j;
        if (n10 != 0) {
            object = this.c.c();
            Boolean bl2 = Boolean.TRUE;
            ((MutableLiveData)object).setValue(bl2);
            object = (TemplateData)this.c.e().getValue();
            boolean bl3 = true;
            this.N((TemplateData)object, bl3);
        }
        n10 = this.d.m();
        this.u(n10);
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = this.b;
        object2 = this.c;
        ((l9)object).D((q)object2);
        object = this.b;
        object2 = this.d;
        ((l9)object).C((m0)object2);
        object = this.b;
        object2 = new p$c(this);
        ((l9)object).B((p$c)object2);
        this.b.setLifecycleOwner(this);
        this.y();
        this.w();
        this.x();
    }
}

