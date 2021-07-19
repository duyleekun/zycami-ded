/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.TextView
 */
package d.v.c.s0.h7.r0;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import com.zhiyun.cama.camera.StackLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$StoryState;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import d.v.c.s0.h7.m0;
import d.v.c.s0.h7.r0.b;
import d.v.c.s0.h7.r0.c;
import d.v.c.s0.h7.r0.d;
import d.v.c.s0.h7.r0.e;
import d.v.c.s0.h7.r0.q;
import d.v.c.s0.h7.r0.r$a;
import d.v.c.s0.h7.r0.r$b;
import d.v.c.s0.h7.r0.r$c;
import d.v.c.s0.h7.r0.r$d;
import d.v.c.s0.h7.r0.s;
import d.v.c.s0.h7.r0.t;
import d.v.c.w0.oh;
import d.v.e.i.f;
import d.v.e.l.m2;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.j.f.h;
import java.util.ArrayList;
import java.util.List;

public class r
extends a {
    private static final int h;
    private s b;
    private m0 c;
    private oh d;
    private h e;
    private BleViewModel f;
    private final List g;

    public r() {
        ArrayList arrayList;
        this.g = arrayList = new ArrayList();
    }

    public static String A(int n10, long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("android:switcher:");
        stringBuilder.append(n10);
        stringBuilder.append(":");
        stringBuilder.append(l10);
        return stringBuilder.toString();
    }

    public static r B() {
        r r10 = new r();
        return r10;
    }

    private void C(List object) {
        Object object2;
        Object object3;
        int n10;
        this.g.clear();
        int n11 = 0;
        Object object4 = null;
        object.add(0, null);
        object.add(0, null);
        int n12 = object.size();
        int n13 = 0;
        Object object5 = null;
        while (true) {
            Object object6;
            Object object7;
            n10 = 1;
            if (n13 >= n12) break;
            long l10 = -1;
            long l11 = 0L;
            if (n13 == 0) {
                object7 = this.getChildFragmentManager();
                object6 = this.d.e;
                int n14 = object6.getId();
                String string2 = r.A(n14, l11);
                if ((object7 = (q)((FragmentManager)object7).findFragmentByTag(string2)) == null) {
                    object7 = new q();
                    string2 = "type_me";
                    object3 = t.r(string2, l10);
                    ((Fragment)object7).setArguments((Bundle)object3);
                }
                object3 = this.g;
                object3.add(object7);
            } else {
                long l12;
                object6 = this.getChildFragmentManager();
                int n15 = this.d.e.getId();
                String string3 = r.A(n15, l12 = (long)n13);
                if ((object6 = (t)object6.findFragmentByTag(string3)) == null) {
                    object6 = new t();
                    if (n10 == n13) {
                        object7 = t.r("type_smart", l10);
                        ((Fragment)object6).setArguments((Bundle)object7);
                    } else {
                        long l13;
                        long l14;
                        object7 = object.get(n13);
                        if (object7 != null && (n10 = (int)((l14 = (l13 = ((TemplateType)(object7 = (TemplateType)object.get(n13))).getId()) - l11) == 0L ? 0 : (l14 < 0L ? -1 : 1))) != 0) {
                            l13 = ((TemplateType)object.get(n13)).getId();
                            object2 = "type_id";
                            object7 = t.r((String)object2, l13);
                            ((Fragment)object6).setArguments((Bundle)object7);
                        }
                    }
                }
                object7 = this.g;
                object7.add(object6);
            }
            ++n13;
        }
        object3 = this.getChildFragmentManager();
        object2 = this.g;
        object5 = new d.v.c.n0.b((FragmentManager)object3, n10, (List)object2);
        this.d.e.setAdapter((PagerAdapter)object5);
        object5 = this.d.e;
        int n16 = this.g.size();
        ((ViewPager)((Object)object5)).setOffscreenPageLimit(n16);
        object5 = this.d;
        object3 = ((oh)object5).c;
        object5 = ((oh)object5).e;
        ((TabLayout)((Object)object3)).setupWithViewPager((ViewPager)((Object)object5));
        object5 = this.d.c;
        object3 = new r$c(this);
        ((TabLayout)((Object)object5)).addOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener)object3);
        while (n11 < n12) {
            int n17;
            object5 = this.d.c.getTabAt(n11);
            n16 = 2131558651;
            ((TabLayout$Tab)object5).setCustomView(n16);
            if (n11 == 0) {
                object3 = this.getResources();
                n17 = 2131952076;
                object3 = d.v.f.i.g.o((Resources)object3, n17);
            } else if (n10 == n11) {
                object3 = this.getResources();
                n17 = 2131951820;
                object3 = d.v.f.i.g.o((Resources)object3, n17);
            } else {
                object3 = object.get(n11);
                object3 = object3 != null ? ((TemplateType)object.get(n11)).a() : "";
            }
            object2 = ((TabLayout$Tab)object5).getCustomView();
            if (object2 != null && (n17 = (object2 = ((TabLayout$Tab)object5).getCustomView()) instanceof TextView) != 0) {
                object5 = (TextView)((TabLayout$Tab)object5).getCustomView();
                object5.setText((CharSequence)object3);
            }
            ++n11;
        }
        object4 = this.b;
        ((s)object4).d = object;
        object = ((s)object4).c;
        object4 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(object4);
    }

    private void D(TabLayout$Tab tabLayout$Tab, boolean bl2) {
        boolean bl3;
        if (tabLayout$Tab != null && (bl3 = (tabLayout$Tab = tabLayout$Tab.getCustomView()) instanceof TextView)) {
            float f10;
            TabLayout$Tab tabLayout$Tab2 = tabLayout$Tab;
            tabLayout$Tab2 = (TextView)tabLayout$Tab;
            if (bl2) {
                int n10 = 1101004800;
                f10 = 20.0f;
            } else {
                int n11 = 1098907648;
                f10 = 16.0f;
            }
            tabLayout$Tab2.setTextSize(f10);
            ((View)tabLayout$Tab).requestLayout();
        }
    }

    public static /* synthetic */ void j(r r10) {
        r10.n();
    }

    public static /* synthetic */ s k(r r10) {
        return r10.b;
    }

    public static /* synthetic */ void l(r r10, TabLayout$Tab tabLayout$Tab, boolean bl2) {
        r10.D(tabLayout$Tab, bl2);
    }

    public static /* synthetic */ m0 m(r r10) {
        return r10.c;
    }

    private void n() {
        m0 m02 = this.c;
        if (m02 != null) {
            CameraSet$StoryState cameraSet$StoryState = CameraSet$StoryState.STORY_LIST;
            m02.g0(cameraSet$StoryState);
        }
    }

    private void o() {
        ViewPager viewPager = this.d.e;
        r$b r$b = new r$b(this);
        viewPager.addOnPageChangeListener(r$b);
    }

    private void p() {
        this.e.j();
        LiveData liveData = this.b.h;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new e(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.b.c;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new b(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.f.m;
        lifecycleOwner = this.getViewLifecycleOwner();
        c c10 = new c(this);
        observer = new f(c10);
        ((StackLiveData)liveData).observe(lifecycleOwner, observer);
    }

    private void q() {
        oh oh2 = this.d;
        s s10 = this.b;
        oh2.B(s10);
    }

    private void r() {
        r$a r$a = new r$a(this, true);
        OnBackPressedDispatcher onBackPressedDispatcher = this.requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        onBackPressedDispatcher.addCallback(lifecycleOwner, r$a);
    }

    private /* synthetic */ void s(List list) {
        ArrayList arrayList = new ArrayList(list);
        this.C(arrayList);
    }

    /*
     * WARNING - void declaration
     */
    private /* synthetic */ void u(Boolean object) {
        void var2_5;
        boolean n10 = (Boolean)object;
        boolean bl2 = true;
        if (n10) {
            object = this.b;
            int n11 = ((s)object).c();
        } else {
            boolean bl3 = bl2;
        }
        this.d.e.setCurrentItem((int)var2_5);
        TabLayout$Tab tabLayout$Tab = this.d.c.getTabAt((int)var2_5);
        this.D(tabLayout$Tab, bl2);
        d d10 = new d(this, (int)var2_5);
        m2.Y(1L, d10);
    }

    private /* synthetic */ void w(Boolean bl2) {
        this.d.d.performClick();
    }

    private /* synthetic */ void y(int n10) {
        this.d.c.setScrollPosition(n10, 0.0f, false);
    }

    public int h() {
        return 2131558785;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (oh)viewDataBinding;
        this.d = viewDataBinding;
        r$d r$d = new r$d(this);
        ((oh)viewDataBinding).A(r$d);
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.b = viewModel = (s)((ViewModelProvider)object).get(s.class);
        viewModel = (m0)((ViewModelProvider)object).get(m0.class);
        this.c = viewModel;
        viewModel = (h)d.v.i0.b.a(this).get(h.class);
        this.e = viewModel;
        this.f = object = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.q();
        this.r();
        this.p();
        this.o();
    }

    public /* synthetic */ void t(List list) {
        this.s(list);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ void x(Boolean bl2) {
        this.w(bl2);
    }

    public /* synthetic */ void z(int n10) {
        this.y(n10);
    }
}

