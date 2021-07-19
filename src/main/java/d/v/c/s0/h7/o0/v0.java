/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.s0.h7.o0;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.util.Pair;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.album.AlbumListAdapter;
import com.zhiyun.cama.album.AlbumSection;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.common.util.Windows;
import d.v.c.o0.p0;
import d.v.c.s0.h7.l0;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.o0.c;
import d.v.c.s0.h7.o0.g;
import d.v.c.s0.h7.o0.j;
import d.v.c.s0.h7.o0.k;
import d.v.c.s0.h7.o0.l;
import d.v.c.s0.h7.o0.m;
import d.v.c.s0.h7.o0.v0$a;
import d.v.c.s0.h7.o0.v0$b;
import d.v.c.s0.h7.o0.w0;
import d.v.c.w0.ch;
import d.v.e.i.f;
import d.v.e.l.h2;
import d.v.f.f.a;
import d.v.g0.k$b;
import d.v.i0.b;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class v0
extends d.v.f.h.a {
    private ObservableBoolean b;
    private m0 c;
    private w0 d;
    private BleViewModel e;
    private AlbumListAdapter f;
    private ch g;

    public v0() {
        ObservableBoolean observableBoolean;
        this.b = observableBoolean = new ObservableBoolean(false);
    }

    private void A(AlbumSection object) {
        Object object2 = this.c;
        if (object2 != null) {
            boolean bl2;
            int n10 = -1;
            w0 w02 = this.d;
            try {
                n10 = w02.k((AlbumSection)object);
            }
            catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            w02 = this.d;
            long l10 = w02.i((AlbumSection)object);
            long l11 = -1;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 == false) {
                return;
            }
            Object object3 = this.d.g((AlbumSection)object);
            Object object4 = this.c;
            ((m0)object4).b0();
            object3 = object3.iterator();
            while (bl2 = object3.hasNext()) {
                object4 = (Pair)object3.next();
                m0 m02 = this.c;
                Integer n11 = (Integer)((Pair)object4).first;
                int n12 = n11;
                m02.c0(n12);
                m02 = this.c;
                object4 = (String)((Pair)object4).second;
                m02.Z((String)object4);
            }
            object3 = this.c;
            object = object.getAlbum().path;
            object4 = new File((String)object);
            ((m0)object3).l = object = ((File)object4).getParentFile();
            object = this.c;
            object2 = l0.e(n10, l10);
            ((m0)object).e0((LiveData)object2);
        }
    }

    public static v0 B() {
        v0 v02 = new v0();
        return v02;
    }

    private void C() {
        Context context = this.requireContext();
        int n10 = Windows.r(context);
        if (n10 == 0) {
            return;
        }
        n10 = h2.b(10.0f);
        this.g.d.setPadding(n10, 0, n10, 0);
    }

    private void D() {
        ch ch2 = this.g;
        Object object = new v0$b(this);
        ch2.B((v0$b)object);
        ch2 = this.g;
        object = this.b;
        ch2.C((ObservableBoolean)object);
    }

    private void E() {
        Object object = this.getContext();
        k$b k$b = new k$b((Context)object);
        k$b = (k$b)k$b.m(2131953145);
        int n10 = h2.b(320.0f);
        k$b = (k$b)k$b.g(n10, -1);
        object = d.v.c.s0.h7.o0.c.a;
        k$b = (k$b)k$b.v(2131952621, (a)object);
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public static /* synthetic */ void j(v0 v02) {
        v02.n();
    }

    public static /* synthetic */ ObservableBoolean k(v0 v02) {
        return v02.b;
    }

    public static /* synthetic */ AlbumListAdapter l(v0 v02) {
        return v02.f;
    }

    public static /* synthetic */ w0 m(v0 v02) {
        return v02.d;
    }

    private void n() {
        m0 m02 = this.c;
        if (m02 != null) {
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_LIST;
            m02.g0(cameraSet$StoryState);
        }
    }

    private void o() {
        Object object = this.getContext();
        Object object2 = new p0((Context)object);
        int n10 = 2131231811;
        ((p0)object2).b(2131952002, n10);
        object = this.requireContext();
        int n11 = h2.c(object);
        n11 = n11 != 0 ? 3 : 6;
        RecyclerView recyclerView = this.g.d;
        Context context = this.requireContext();
        ArrayList arrayList = new ArrayList(context, n11);
        recyclerView.setLayoutManager((RecyclerView$LayoutManager)((Object)arrayList));
        n11 = h2.b(2.0f);
        arrayList = new ArrayList(n11);
        recyclerView.addItemDecoration((RecyclerView$ItemDecoration)((Object)arrayList));
        arrayList = new ArrayList();
        object = new AlbumListAdapter(arrayList);
        this.f = object;
        recyclerView.setAdapter((RecyclerView$Adapter)object);
        this.f.setEmptyView((View)object2);
        object2 = this.f;
        object = new l(this);
        ((BaseQuickAdapter)object2).setOnItemClickListener((OnItemClickListener)object);
        object2 = this.f;
        object = new g(this);
        ((BaseQuickAdapter)object2).setOnItemChildClickListener((OnItemChildClickListener)object);
    }

    private void p() {
        Object object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.c = object;
        object = (w0)d.v.i0.b.a(this).get(w0.class);
        this.d = object;
        object = (BleViewModel)d.v.i0.b.c(this.requireActivity()).get(BleViewModel.class);
        this.e = object;
        object = this.g;
        Object object2 = this.d;
        ((ch)object).D((w0)object2);
        object = this.d.a;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new m(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        this.d.e();
        object = this.d.b;
        object2 = this.getViewLifecycleOwner();
        observer = new k(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.m;
        object2 = this.getViewLifecycleOwner();
        j j10 = j.a;
        observer = new f(j10);
        ((StackLiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void q() {
        v0$a v0$a = new v0$a(this, true);
        OnBackPressedDispatcher onBackPressedDispatcher = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        onBackPressedDispatcher.addCallback(lifecycleOwner, v0$a);
    }

    private /* synthetic */ void r(BaseQuickAdapter object, View object2, int n10) {
        object = (AlbumSection)this.f.getData().get(n10);
        object2 = this.b;
        boolean bl2 = ((ObservableBoolean)object2).get();
        if (bl2) {
            bl2 = ((AlbumSection)object).isHeader();
            if (!bl2) {
                object2 = object.getAlbum().isChecked;
                ObservableBoolean observableBoolean = object.getAlbum().isChecked;
                n10 = observableBoolean.get() ^ 1;
                ((ObservableBoolean)object2).set(n10 != 0);
                object2 = this.f;
                ((AlbumListAdapter)object2).g((AlbumSection)object);
            }
        } else {
            this.A((AlbumSection)object);
        }
    }

    private /* synthetic */ void t(BaseQuickAdapter object, View view, int n10) {
        object = (AlbumSection)this.f.getData().get(n10);
        this.f.s((AlbumSection)object);
    }

    private /* synthetic */ void v(List list) {
        this.f.setList(list);
    }

    private /* synthetic */ void x(Integer object) {
        int n10 = (Integer)object;
        if (n10 == 0) {
            this.f.b();
            object = this.d.b;
            int n11 = -1;
            Integer n12 = n11;
            ((MutableLiveData)object).setValue(n12);
            this.E();
        }
    }

    public static /* synthetic */ void z(Boolean bl2) {
    }

    public int h() {
        return 2131558779;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (ch)viewDataBinding;
        this.g = viewDataBinding;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.D();
        this.p();
        this.q();
        this.o();
        this.C();
    }

    public /* synthetic */ void s(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.r(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void u(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.t(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void w(List list) {
        this.v(list);
    }

    public /* synthetic */ void y(Integer n10) {
        this.x(n10);
    }
}

