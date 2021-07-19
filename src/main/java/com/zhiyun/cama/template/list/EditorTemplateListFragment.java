/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.util.Size
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.Window
 *  android.view.WindowManager$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.zhiyun.cama.template.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout$BaseOnTabSelectedListener;
import com.google.android.material.tabs.TabLayout$Tab;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$a;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$b;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$c;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$d;
import com.zhiyun.cama.template.list.EditorTemplateListFragment$e;
import com.zhiyun.common.util.Windows;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import com.zhiyun.common.viewmodel.DeviceViewModel$NetWorkEvent;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateData;
import com.zhiyun.editortemplate.data.database.model.template.templatelist.TemplateType;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.u1.k;
import d.v.c.u1.m.c1;
import d.v.c.u1.n.c;
import d.v.c.u1.n.d;
import d.v.c.u1.n.e;
import d.v.c.w0.b8;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$b;
import d.v.i0.b;
import d.v.j.f.h;
import d.v.j.g.d0.f;
import java.util.ArrayList;
import java.util.List;

public class EditorTemplateListFragment
extends d.v.c.q0.b {
    private static final int l;
    private b8 g;
    private h h;
    private DeviceViewModel i;
    private k j;
    private c1 k;

    private void A() {
        Object object = this.j;
        boolean bl2 = ((k)object).g();
        if (bl2) {
            this.i();
        } else {
            object = this.requireActivity();
            ((ComponentActivity)object).onBackPressed();
        }
    }

    private void B(TemplatePOJO templatePOJO) {
        TemplateData templateData = templatePOJO.getTemplateData();
        boolean bl2 = templateData.isPrimeUsable();
        if (!bl2 || (bl2 = d.v.c.m1.b.b((Context)(templateData = this.requireContext())))) {
            this.R(templatePOJO);
        }
    }

    private void C(ViewDataBinding viewDataBinding) {
        viewDataBinding = (b8)viewDataBinding;
        this.g = viewDataBinding;
        EditorTemplateListFragment$d editorTemplateListFragment$d = new EditorTemplateListFragment$d(this);
        ((b8)viewDataBinding).z(editorTemplateListFragment$d);
    }

    private void D() {
        Bundle bundle = this.getArguments();
        if (bundle == null) {
            return;
        }
        k k10 = this.j;
        int n10 = bundle.getInt("templateModeType", 0);
        k10.k(n10);
        this.j.n(0);
    }

    private void E() {
        Object object = (k)b.c(this.requireActivity()).get(k.class);
        this.j = object;
        object = b.a(this);
        Object object2 = (h)((ViewModelProvider)object).get(h.class);
        this.h = object2;
        this.i = object = (DeviceViewModel)((ViewModelProvider)object).get(DeviceViewModel.class);
        object = this.h.d();
        object2 = new e(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.i.f();
        object2 = new d.v.c.u1.n.b(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.g.getRoot().getViewTreeObserver();
        object2 = new EditorTemplateListFragment$a(this);
        object.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object2);
        object = this.j.d();
        object2 = new d(this);
        ((LiveData)object).observe(this, (Observer)object2);
    }

    private void F() {
        Size size = Windows.o(this.requireContext());
        int n10 = size.getWidth();
        int n11 = h2.b(24.0f);
        n10 = n10 / n11 + 1;
        this.g.c.removeAllViews();
        n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            LayoutInflater layoutInflater = LayoutInflater.from((Context)this.requireContext());
            int n12 = 2131558654;
            LinearLayout linearLayout = this.g.c;
            layoutInflater = layoutInflater.inflate(n12, (ViewGroup)linearLayout, false);
            LinearLayout linearLayout2 = this.g.c;
            linearLayout2.addView((View)layoutInflater);
        }
    }

    private void G() {
        this.F();
        this.g.d.setEnabled(false);
        this.g.f.setOffscreenPageLimit(10);
    }

    private /* synthetic */ void H(d.v.j.e.h.k object) {
        int[] nArray = EditorTemplateListFragment$c.b;
        Status status = ((d.v.j.e.h.k)object).a;
        int n10 = status.ordinal();
        int n11 = nArray[n10];
        if (n11 == (n10 = 3) || n11 == (n10 = 4)) {
            object = (List)((d.v.j.e.h.k)object).c;
            this.T((List)object);
        }
    }

    private /* synthetic */ void J(DeviceViewModel$NetWorkEvent object) {
        int[] nArray = EditorTemplateListFragment$c.a;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if (((n10 = nArray[n10]) == n11 || n10 == (n11 = 2)) && (n10 = (int)(((h)(object = this.h)).f() ? 1 : 0)) != 0 && (n10 = (int)(((h)(object = this.h)).e() ? 1 : 0)) != 0) {
            object = this.h;
            ((h)object).j();
        }
    }

    private /* synthetic */ void L(TemplatePOJO templatePOJO) {
        if (templatePOJO == null) {
            return;
        }
        this.B(templatePOJO);
    }

    private /* synthetic */ void N() {
        b8 b82 = this.g;
        TabLayout tabLayout = b82.e;
        int n10 = b82.f.getCurrentItem();
        tabLayout.setScrollPosition(n10, 0.0f, false);
    }

    private void P() {
        Window window;
        k k10 = this.j;
        boolean bl2 = k10.g();
        if (bl2 && (k10 = this.getDialog()) != null && (window = k10.getWindow()) != null) {
            int n10;
            k10 = k10.getWindow();
            int n11 = 2131099762;
            k10.setBackgroundDrawableResource(n11);
            k10.getDecorView().setPadding(0, 0, 0, 0);
            window = k10.getAttributes();
            window.width = n10 = -1;
            window.height = n10;
            window.flags = 32;
            window.windowAnimations = 2132017745;
            window.gravity = n10 = 80;
            k10.setAttributes((WindowManager.LayoutParams)window);
        }
    }

    public static EditorTemplateListFragment Q(int n10) {
        EditorTemplateListFragment editorTemplateListFragment = new EditorTemplateListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("templateModeType", n10);
        editorTemplateListFragment.setArguments(bundle);
        return editorTemplateListFragment;
    }

    private void R(TemplatePOJO object) {
        Object object2 = this.j;
        boolean bl2 = ((k)object2).g();
        if (bl2) {
            object2 = this.k;
            if (object2 != null) {
                TemplateData templateData = ((TemplatePOJO)object).getTemplateData();
                long l10 = templateData.getId();
                object2.a(l10, (TemplatePOJO)object);
                this.A();
            }
        } else {
            object2 = this.getActivity();
            object = ((TemplatePOJO)object).getTemplateData();
            long l11 = ((TemplateData)object).getId();
            EditorAddVideoActivity.o((Activity)object2, l11);
        }
    }

    private void T(List object) {
        int n10;
        Object object2;
        String string2;
        Object object3;
        Object object4;
        boolean bl2 = d.v.j.b.f((List)object);
        if (bl2) {
            object = new ArrayList();
            long l10 = 0L;
            object4 = "";
            object3 = "";
            string2 = "";
            object2 = TemplateType.create(l10, (String)object4, (String)object3, string2, 0, 0);
            object.add(object2);
        }
        object2 = (EditorTemplateListFragment$e)this.g.f.getAdapter();
        boolean bl3 = true;
        if (object2 == null) {
            object4 = this.getChildFragmentManager();
            object2 = new EditorTemplateListFragment$e(this, (FragmentManager)object4, (int)(bl3 ? 1 : 0));
            this.g.f.setAdapter((PagerAdapter)object2);
            object4 = this.g.e;
            object3 = new EditorTemplateListFragment$b(this);
            ((TabLayout)((Object)object4)).addOnTabSelectedListener((TabLayout$BaseOnTabSelectedListener)object3);
        }
        ((EditorTemplateListFragment$e)object2).b((List)object);
        ((PagerAdapter)object2).notifyDataSetChanged();
        object4 = this.g;
        object3 = ((b8)object4).e;
        object4 = ((b8)object4).f;
        ((TabLayout)((Object)object3)).setupWithViewPager((ViewPager)((Object)object4));
        object4 = null;
        for (int i10 = 0; i10 < (n10 = object.size()); ++i10) {
            object3 = this.g.e.getTabAt(i10);
            int n11 = 2131558651;
            ((TabLayout$Tab)object3).setCustomView(n11);
            object3 = (TextView)((TabLayout$Tab)object3).getCustomView();
            string2 = ((EditorTemplateListFragment$e)object2).a(i10);
            object3.setText((CharSequence)string2);
        }
        object = this.g;
        object2 = ((b8)object).e;
        int n12 = ((b8)object).f.getCurrentItem();
        object = ((TabLayout)((Object)object2)).getTabAt(n12);
        this.U((TabLayout$Tab)object, bl3);
        object = new c(this);
        m2.Y(1L, (m2$b)object);
    }

    private void U(TabLayout$Tab tabLayout$Tab, boolean bl2) {
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

    public static /* synthetic */ b8 w(EditorTemplateListFragment editorTemplateListFragment) {
        return editorTemplateListFragment.g;
    }

    public static /* synthetic */ h x(EditorTemplateListFragment editorTemplateListFragment) {
        return editorTemplateListFragment.h;
    }

    public static /* synthetic */ void y(EditorTemplateListFragment editorTemplateListFragment, TabLayout$Tab tabLayout$Tab, boolean bl2) {
        editorTemplateListFragment.U(tabLayout$Tab, bl2);
    }

    public static /* synthetic */ void z(EditorTemplateListFragment editorTemplateListFragment) {
        editorTemplateListFragment.A();
    }

    public /* synthetic */ void I(d.v.j.e.h.k k10) {
        this.H(k10);
    }

    public /* synthetic */ void K(DeviceViewModel$NetWorkEvent deviceViewModel$NetWorkEvent) {
        this.J(deviceViewModel$NetWorkEvent);
    }

    public /* synthetic */ void M(TemplatePOJO templatePOJO) {
        this.L(templatePOJO);
    }

    public /* synthetic */ void O() {
        this.N();
    }

    public void S(c1 c12) {
        this.k = c12;
    }

    public void onDestroy() {
        super.onDestroy();
        d.v.j.g.d0.f.H().d();
    }

    public void onResume() {
        super.onResume();
        b8 b82 = this.g;
        TabLayout tabLayout = b82.e;
        int n10 = b82.f.getCurrentItem();
        tabLayout.setScrollPosition(n10, 0.0f, false);
    }

    public int s() {
        return 2131558588;
    }

    public void t(ViewDataBinding viewDataBinding) {
        super.t(viewDataBinding);
        this.C(viewDataBinding);
        this.G();
        this.E();
        this.D();
        this.P();
    }
}

