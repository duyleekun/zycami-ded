/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.PopupWindow$OnDismissListener
 */
package d.v.c.y1.f.x;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.voice.music.MusicListViewModel;
import com.zhiyun.cama.voice.music.MusicPlayVieModel;
import com.zhiyun.cama.voice.music.mine.MusicLocalImportViewModel;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import d.v.c.w0.d7;
import d.v.c.y1.f.q;
import d.v.c.y1.f.u;
import d.v.c.y1.f.x.a;
import d.v.c.y1.f.x.b;
import d.v.c.y1.f.x.c;
import d.v.c.y1.f.x.d;
import d.v.c.y1.f.x.d0;
import d.v.c.y1.f.x.e;
import d.v.c.y1.f.x.f;
import d.v.c.y1.f.x.g;
import d.v.c.y1.f.x.g0;
import d.v.c.y1.f.x.j0;
import d.v.c.y1.f.x.m0;
import d.v.e.l.o1;
import d.v.g0.k$b;
import java.util.ArrayList;
import java.util.List;

public class f0
extends d.v.c.q0.d {
    private MusicListViewModel j;
    private u k;
    private d7 l;

    private /* synthetic */ void A(View view, int n10, q q10) {
        int n11 = o1.e(view, 2131099773);
        view.setBackgroundColor(n11);
        Object object = view.getContext();
        m0 m02 = new m0((Context)object);
        object = new a(view);
        m02.setOnDismissListener((PopupWindow.OnDismissListener)object);
        object = new d(this);
        m02.e((d.v.e.g.e)object);
        object = new c(this, m02, n10, q10);
        m02.f((d.v.e.g.e)object);
        View view2 = m02.getContentView();
        view2.measure(0, 0);
        int n12 = view2.getMeasuredHeight();
        n10 = view2.getMeasuredWidth();
        int n13 = 2;
        int[] nArray = new int[n13];
        view.getLocationInWindow(nArray);
        int n14 = nArray[0];
        int n15 = view.getWidth() / n13;
        n14 += n15;
        n10 = nArray[1] - n12;
        m02.showAtLocation(view, 0, n14 -= (n10 /= n13), n10);
    }

    private /* synthetic */ void C(j0 j02, List list) {
        j02.m(list);
        j02.notifyDataSetChanged();
        this.l.a.scrollToPosition(0);
    }

    public static /* synthetic */ void E(View view) {
        int n10 = o1.e(view, 2131099860);
        view.setBackgroundColor(n10);
    }

    private /* synthetic */ void F() {
        this.j.m();
        FragmentTransaction fragmentTransaction = this.getParentFragmentManager().beginTransaction();
        g0 g02 = new g0();
        fragmentTransaction.replace(2131362467, g02).commit();
    }

    private /* synthetic */ void H(m0 m02, int n10, q q10) {
        m02.dismiss();
        this.L(n10 += -1, q10);
    }

    private /* synthetic */ void J(int n10, q object, DialogFragment arrayList) {
        Object object2;
        ((DialogFragment)((Object)arrayList)).dismissAllowingStateLoss();
        arrayList = this.j;
        int n11 = ((MusicPlayVieModel)((Object)arrayList)).d();
        if (n11 == n10) {
            object2 = this.j.c();
            n11 = -1;
            arrayList = n11;
            ((MutableLiveData)object2).setValue(arrayList);
            object2 = this.j;
            ((MusicPlayVieModel)object2).m();
        } else if (n11 > n10) {
            object2 = this.j;
            ((MusicPlayVieModel)object2).l(n11 += -1);
        }
        object2 = (MusicLocalImportViewModel)d.v.i0.b.a(this).get(MusicLocalImportViewModel.class);
        arrayList = ((q)object).G().g();
        String string2 = d.v.c.d0.b(EditConfig$ResourceType.MUSIC).getAbsolutePath();
        n11 = (int)(((String)((Object)arrayList)).startsWith(string2) ? 1 : 0);
        if (n11 != 0) {
            arrayList = new ArrayList<Object>();
            object = ((q)object).G().g();
            arrayList.add(object);
            ((MusicLocalImportViewModel)object2).U(arrayList);
        } else {
            arrayList = new ArrayList<Object>();
            object = ((q)object).G().g();
            arrayList.add(object);
            ((MusicLocalImportViewModel)object2).V(arrayList);
        }
    }

    private void L(int n10, q object) {
        Object object2 = this.requireContext();
        k$b k$b = new k$b((Context)object2);
        object2 = d.v.f.i.g.s(this, 2131952024);
        k$b = (k$b)k$b.B((String)object2);
        object2 = d0.a;
        k$b = (k$b)k$b.o(2131951833, (d.v.f.f.a)object2);
        object2 = new b(this, n10, (q)object);
        k$b k$b2 = (k$b)k$b.v(2131951887, (d.v.f.f.a)object2);
        object = this.getChildFragmentManager();
        k$b2.D((FragmentManager)object);
    }

    private void x() {
        Object object = this.j;
        j0 j02 = new j0((LifecycleOwner)this, (MusicListViewModel)object);
        object = this.k;
        j02.r((u)object);
        object = this.l.a;
        Context context = this.requireContext();
        Object object2 = new LinearLayoutManager(context, 1, false);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        this.l.a.setAdapter(j02);
        object = new g(this);
        j02.n((d.v.f.f.b)object);
        object = new e(this);
        j02.u((d.v.f.f.b)object);
        object = this.j.t();
        object2 = new f(this, j02);
        ((LiveData)object).observe(this, (Observer)object2);
    }

    private /* synthetic */ void y(View object, int n10, q q10) {
        if (n10 == 0) {
            this.j.m();
            object = this.k;
            ((u)object).j();
        }
    }

    public /* synthetic */ void B(View view, int n10, q q10) {
        this.A(view, n10, q10);
    }

    public /* synthetic */ void D(j0 j02, List list) {
        this.C(j02, list);
    }

    public /* synthetic */ void G() {
        this.F();
    }

    public /* synthetic */ void I(m0 m02, int n10, q q10) {
        this.H(m02, n10, q10);
    }

    public /* synthetic */ void K(int n10, q q10, DialogFragment dialogFragment) {
        this.J(n10, q10, dialogFragment);
    }

    public int h() {
        return 2131558576;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (d7)object;
        this.l = object;
        this.j = object = (MusicListViewModel)d.v.i0.b.a(this).get(MusicListViewModel.class);
        this.k = object = (u)d.v.i0.b.a(this.requireParentFragment()).get(u.class);
        object = this.getLifecycle();
        MusicListViewModel musicListViewModel = this.j;
        ((Lifecycle)object).addObserver(musicListViewModel);
        this.x();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Lifecycle lifecycle = this.getLifecycle();
        MusicListViewModel musicListViewModel = this.j;
        lifecycle.removeObserver(musicListViewModel);
    }

    public /* synthetic */ void z(View view, int n10, q q10) {
        this.y(view, n10, q10);
    }
}

