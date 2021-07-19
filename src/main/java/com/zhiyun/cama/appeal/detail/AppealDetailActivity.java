/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.text.SpannableString
 *  android.text.method.LinkMovementMethod
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.TextView
 */
package com.zhiyun.cama.appeal.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity$a;
import com.zhiyun.cama.appeal.detail.AppealDetailActivity$b;
import com.zhiyun.common.util.StatusBarUtil;
import d.v.c.p0.n.a;
import d.v.c.p0.n.d;
import d.v.c.p0.n.f;
import d.v.c.p0.n.h;
import d.v.c.p0.n.i;
import d.v.c.p0.n.j;
import d.v.c.p0.p.g;
import d.v.c.w0.e;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.i0.b;
import java.util.List;

public class AppealDetailActivity
extends d.v.f.c.a {
    private e b;
    private j c;
    private g d;

    public static /* synthetic */ j d(AppealDetailActivity appealDetailActivity) {
        return appealDetailActivity.c;
    }

    private void h() {
        Object object = this.getIntent();
        if (object != null) {
            String string2 = object.getStringExtra("type");
            object = object.getStringExtra("appeal_id");
            j j10 = this.c;
            AppealDetailActivity$a appealDetailActivity$a = new AppealDetailActivity$a(this, string2);
            j10.d((String)object, appealDetailActivity$a);
        }
    }

    private void i() {
        Window window = this.getWindow();
        int n10 = d.v.f.i.g.c((Context)this, 2131099772);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
        window = this.b.k.d;
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951641);
        window.setText((CharSequence)string2);
        this.b.k.c.setVisibility(8);
    }

    private void j() {
        TextView textView = this.b.f;
        Object object = LinkMovementMethod.getInstance();
        textView.setMovementMethod(object);
        textView = this.b.k.b;
        object = new d.v.c.p0.n.b(this);
        textView.setOnClickListener((View.OnClickListener)object);
    }

    private /* synthetic */ void k(View view) {
        ActivityCompat.finishAfterTransition(this);
    }

    private /* synthetic */ void m(Boolean bl2) {
        this.f();
    }

    public static void v(Activity activity, String string2, String string3) {
        Intent intent = new Intent((Context)activity, AppealDetailActivity.class);
        intent.putExtra("type", string2);
        intent.putExtra("appeal_id", string3);
        activity.startActivity(intent);
    }

    public void f() {
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951876);
        String string3 = d.v.f.i.g.o(this.getResources(), 2131951874);
        SimpleWebViewActivity.h(this, string2, string3);
    }

    public /* synthetic */ void l(View view) {
        this.k(view);
    }

    public /* synthetic */ void n(Boolean bl2) {
        this.m(bl2);
    }

    public void o(List object) {
        RecyclerView$Adapter recyclerView$Adapter = this.b.a.getAdapter();
        if (recyclerView$Adapter != null && (recyclerView$Adapter = this.d) != null) {
            ((g)recyclerView$Adapter).l();
            recyclerView$Adapter = this.d;
            ((g)recyclerView$Adapter).a((List)object);
            object = this.d;
            ((RecyclerView$Adapter)object).notifyDataSetChanged();
        } else {
            recyclerView$Adapter = new AppealDetailActivity$b(this);
            this.d = recyclerView$Adapter;
            ((g)recyclerView$Adapter).a((List)object);
            int n10 = 3;
            object = new GridLayoutManager((Context)this, n10);
            this.b.a.setLayoutManager((RecyclerView$LayoutManager)object);
            object = this.b.a;
            recyclerView$Adapter = this.d;
            ((RecyclerView)object).setAdapter(recyclerView$Adapter);
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getWindow();
        int n10 = d.v.f.i.g.c((Context)this, 2131099772);
        StatusBarUtil.z((Window)object, n10);
        StatusBarUtil.E(this.getWindow(), true);
        object = (e)DataBindingUtil.setContentView(this, 2131558430);
        this.b = object;
        object = (j)d.v.i0.b.c(this).get(j.class);
        this.c = object;
        this.b.setLifecycleOwner(this);
        object = this.b;
        Object object2 = this.c;
        ((e)object).z((j)object2);
        object = this.c.n();
        object2 = new a(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.c.e();
        object2 = new d(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.c.f();
        object2 = new h(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.c.g();
        object2 = new i(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.c.j();
        object2 = new f(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.c.k();
        object2 = new d.v.c.p0.n.g(this);
        ((LiveData)object).observe(this, (Observer)object2);
        object = this.c.b();
        object2 = new d.v.c.p0.n.e(this);
        ((LiveData)object).observe(this, (Observer)object2);
        this.i();
        this.j();
        this.h();
    }

    public void p(int n10) {
        TextView textView = this.b.c;
        Drawable drawable2 = o1.m((Context)this, n10);
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(null, drawable2, null, null);
    }

    public void q(int n10) {
        TextView textView = this.b.c;
        String string2 = d.v.f.i.g.o(this.getResources(), n10);
        textView.setText((CharSequence)string2);
    }

    public void r(boolean bl2) {
        this.b.c.setSelected(bl2);
    }

    public void s(SpannableString spannableString) {
        this.b.e.setText((CharSequence)spannableString);
    }

    public void t(SpannableString spannableString) {
        this.b.f.setText((CharSequence)spannableString);
    }

    public void u(String string2) {
        n2.e(string2);
    }
}

