/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package d.v.c.s0.h7.r0;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import d.v.c.n0.d;
import d.v.c.s0.h7.r0.a;
import d.v.c.s0.h7.r0.t;
import d.v.c.w0.kh;
import d.v.c.w0.sh;
import d.v.e.l.w1;
import java.util.ArrayList;

public class q
extends t {
    private sh q;

    private /* synthetic */ void F(View view, Bundle bundle, Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            view = this.q.getRoot();
            bundle = null;
            view.setVisibility(0);
            this.u();
        } else {
            bl2 = this.q.getRoot();
            int n10 = 8;
            bl2.setVisibility(n10);
            super.onViewCreated(view, bundle);
        }
    }

    /*
     * WARNING - void declaration
     */
    private void u() {
        void var3_7;
        int n10;
        int n11;
        Object object = w1.a();
        Object object2 = "zh_CN".toLowerCase();
        boolean n12 = ((String)object2).equals(object);
        if (n12) {
            n11 = 2131231740;
            int n13 = 2131231741;
            n10 = 2131231742;
        } else {
            object2 = "zh_TW".toLowerCase();
            n11 = (int)(((String)object2).equals(object) ? 1 : 0);
            if (n11 != 0) {
                n11 = 2131231746;
                int n14 = 2131231747;
                n10 = 2131231748;
            } else {
                n11 = 2131231743;
                int n15 = 2131231744;
                n10 = 2131231745;
            }
        }
        ArrayList<Object> arrayList = new ArrayList<Object>();
        Object object3 = LayoutInflater.from((Context)this.getContext());
        Object object4 = this.q.a;
        int n16 = 2131558783;
        object3 = (kh)DataBindingUtil.inflate(object3, n16, object4, false);
        object4 = 2131231739;
        object3.C((Integer)object4);
        object = n11;
        object3.F((Integer)object);
        object = 2131231539;
        object3.E((Integer)object);
        object = 2131953134;
        object3.D((Integer)object);
        object = object3.getRoot();
        arrayList.add(object);
        object = LayoutInflater.from((Context)this.getContext());
        object3 = this.q.a;
        object = (kh)DataBindingUtil.inflate((LayoutInflater)object, n16, (ViewGroup)object3, false);
        object2 = (int)var3_7;
        ((kh)object).C((Integer)object2);
        object2 = n10;
        ((kh)object).F((Integer)object2);
        object2 = 2131231542;
        ((kh)object).E((Integer)object2);
        object2 = 2131953135;
        ((kh)object).D((Integer)object2);
        object = ((ViewDataBinding)object).getRoot();
        arrayList.add(object);
        object = this.q.a;
        object2 = new d(arrayList);
        ((ViewPager)((Object)object)).setAdapter((PagerAdapter)object2);
    }

    public /* synthetic */ void G(View view, Bundle bundle, Boolean bl2) {
        this.F(view, bundle, bl2);
    }

    public void onResume() {
        super.onResume();
        boolean bl2 = d.v.e.h.a.c((Boolean)this.c.g.getValue());
        MutableLiveData mutableLiveData = this.c.a;
        Boolean bl3 = bl2 ^ true;
        mutableLiveData.setValue(bl3);
        mutableLiveData = this.c.b;
        Boolean bl4 = bl2 ^ true;
        mutableLiveData.setValue(bl4);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Object object = LayoutInflater.from((Context)this.getContext());
        Object object2 = this.f.a;
        object = (sh)DataBindingUtil.inflate((LayoutInflater)object, 2131558787, (ViewGroup)object2, false);
        this.q = object;
        object2 = this.f.a;
        object = ((ViewDataBinding)object).getRoot();
        object2.addView((View)object);
        object = this.c.g;
        object2 = this.getViewLifecycleOwner();
        a a10 = new a(this, view, bundle);
        ((LiveData)object).observe((LifecycleOwner)object2, a10);
    }
}

