/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.view.Window
 */
package com.zhiyun.account.me.country;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.widget.SideBar;
import com.zhiyun.account.me.account.widget.SideBar$a;
import com.zhiyun.account.me.country.CountryChooseActivity$a;
import com.zhiyun.account.me.country.CountryChooseActivity$b;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.a.g.o;
import d.v.a.i.b.b;
import d.v.a.i.b.c;
import d.v.a.i.b.d;
import d.v.a.i.b.e;
import d.v.a.i.b.f;
import d.v.f.i.g;
import java.util.LinkedHashSet;
import java.util.List;

public class CountryChooseActivity
extends d.v.f.c.d {
    public static final int g = 100;
    public static final int h = 200;
    public static final String i = "extra_is_black_bg";
    private o b;
    private d c;
    private boolean d;
    private GridLayoutManager e;
    private boolean f;

    public static /* synthetic */ boolean d(CountryChooseActivity countryChooseActivity) {
        return countryChooseActivity.d;
    }

    public static /* synthetic */ boolean f(CountryChooseActivity countryChooseActivity, boolean bl2) {
        countryChooseActivity.d = bl2;
        return bl2;
    }

    private void h() {
        boolean bl2;
        this.f = bl2 = this.getIntent().getBooleanExtra(i, false);
        this.b.B(bl2);
    }

    private void i() {
        Object object = this.c;
        Object object2 = new b(this);
        ((d)object).i((d.v.f.f.b)object2);
        object = this.b.c;
        object2 = new c(this);
        ((SideBar)((Object)object)).setOnTouchingSessionChangedListener((SideBar$a)object2);
        object = this.b.b;
        object2 = new CountryChooseActivity$a(this);
        ((RecyclerView)object).addOnScrollListener((RecyclerView$OnScrollListener)object2);
    }

    private void j() {
        Window window = this.getWindow();
        int n10 = R$color.com_color_white;
        n10 = d.v.f.i.g.c((Context)this, n10);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
    }

    private void k() {
        Object object;
        Object object2 = d.v.a.i.b.f.b(this.getResources());
        int n10 = this.f;
        Object object3 = new d(n10 != 0);
        this.c = object3;
        object3.d((List)object2);
        n10 = object2.size();
        object3 = new LinkedHashSet(n10);
        object2 = object2.iterator();
        while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
            int n11 = 16;
            object = (String[])object2.next();
            int n12 = object.e();
            if (n11 != n12) continue;
            object = object.d();
            object3.add(object);
        }
        object2 = this.b.c;
        object = new String[object3.size()];
        object3 = object3.toArray((T[])object);
        ((SideBar)((Object)object2)).setSideBarSessions((String[])object3);
        int n13 = 1;
        this.e = object2 = new GridLayoutManager((Context)this, n13);
        ((LinearLayoutManager)object2).setOrientation(n13);
        object2 = this.b.b;
        object3 = this.e;
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object3);
        object2 = this.b.b;
        object3 = this.c;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object3);
    }

    private /* synthetic */ void l(View view, int n10, e e10) {
        if (e10 != null) {
            view = new Intent();
            String string2 = "CountryInfo";
            view.putExtra(string2, (Parcelable)e10);
            n10 = 200;
            this.setResult(n10, (Intent)view);
        }
        ActivityCompat.finishAfterTransition(this);
    }

    private /* synthetic */ void n(String string2) {
        int n10;
        Object object;
        Object object2;
        block6: {
            boolean bl2;
            object2 = this.c.getData();
            object = object2.iterator();
            while (bl2 = object.hasNext()) {
                String string3;
                int n11 = 16;
                e e10 = (e)object.next();
                int n12 = e10.e();
                if (n11 != n12 || (n11 = (int)((string3 = e10.d()).equals(string2) ? 1 : 0)) == 0) continue;
                n10 = object2.indexOf(e10);
                break block6;
            }
            n10 = -1;
        }
        if (n10 >= 0) {
            object2 = this.e;
            int n13 = ((LinearLayoutManager)object2).findFirstVisibleItemPosition();
            object = this.e;
            int n14 = ((LinearLayoutManager)object).findLastVisibleItemPosition();
            if (n10 <= n13) {
                object2 = this.b.b;
                ((RecyclerView)object2).scrollToPosition(n10);
            } else if (n10 <= n14) {
                object = this.b.b;
                string2 = object.getChildAt(n10 -= n13);
                n10 = string2.getTop();
                object2 = this.b.b;
                n14 = 0;
                object = null;
                ((RecyclerView)object2).scrollBy(0, n10);
            } else {
                object2 = this.b.b;
                ((RecyclerView)object2).scrollToPosition(n10);
                n10 = 1;
                this.d = n10;
            }
        }
    }

    public static e p(int n10, int n11, Intent intent) {
        int n12 = 200;
        if (n12 == n11 && (n11 = 100) == n10 && intent != null) {
            return (e)intent.getParcelableExtra("CountryInfo");
        }
        return null;
    }

    public static void q(Activity activity, boolean bl2) {
        Intent intent = new Intent((Context)activity, CountryChooseActivity.class);
        intent.putExtra(i, bl2);
        activity.startActivityForResult(intent, 100);
    }

    public /* synthetic */ void m(View view, int n10, e e10) {
        this.l(view, n10, e10);
    }

    public /* synthetic */ void o(String string2) {
        this.n(string2);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        this.j();
        int n10 = R$layout.me_country_act;
        object = (o)DataBindingUtil.setContentView(this, n10);
        this.b = object;
        CountryChooseActivity$b countryChooseActivity$b = new CountryChooseActivity$b(this);
        ((o)object).A(countryChooseActivity$b);
        this.h();
        this.k();
        this.i();
    }
}

