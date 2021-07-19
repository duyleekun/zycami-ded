/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.text.SpannableString
 *  android.text.TextWatcher
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.text.style.AbsoluteSizeSpan
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.Window
 *  android.widget.EditText
 */
package com.zhiyun.cama.appeal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import androidx.core.app.ActivityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.appeal.AppealActivity$a;
import com.zhiyun.cama.appeal.AppealActivity$b;
import com.zhiyun.cama.data.database.model.Approval;
import com.zhiyun.common.util.StatusBarUtil;
import com.zhiyun.common.util.Windows;
import com.zhiyun.net.Punish;
import d.v.c.p0.b;
import d.v.c.p0.d;
import d.v.c.p0.e;
import d.v.c.p0.f;
import d.v.c.p0.j;
import d.v.c.p0.k;
import d.v.c.p0.l;
import d.v.c.p0.m;
import d.v.c.w0.c;
import d.v.e.l.h2;
import d.v.e.l.n2;
import d.v.e.l.v1;
import d.v.f.c.a;
import d.v.f.i.g;
import d.v.g0.k$b;
import d.v.g0.s;
import java.util.List;

public class AppealActivity
extends a {
    public static final String h = "approval";
    public static final String i = "appeal";
    public static final String j = "appeal_id";
    public static final String k = "type";
    public static final String l = "punish";
    private static boolean m;
    private m b;
    private c c;
    private d.v.c.p0.p.f d;
    private Approval e;
    private Punish f;
    private String g;

    private void A(SpannableString spannableString) {
        this.c.g.setText((CharSequence)spannableString);
    }

    public static void E(Activity activity, String string2, Approval approval) {
        Intent intent = new Intent((Context)activity, AppealActivity.class);
        intent.putExtra(k, string2);
        intent.putExtra(h, (Parcelable)approval);
        activity.startActivity(intent);
    }

    public static void F(Activity activity, String string2, Punish punish) {
        Intent intent = new Intent((Context)activity, AppealActivity.class);
        intent.putExtra(k, string2);
        intent.putExtra(l, (Parcelable)punish);
        activity.startActivity(intent);
    }

    public static void G(Fragment fragment, String string2, Approval approval, int n10) {
        m = true;
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, AppealActivity.class);
        intent.putExtra(k, string2);
        intent.putExtra(h, (Parcelable)approval);
        fragment.startActivityForResult(intent, n10);
    }

    public static void H(Fragment fragment, String string2, Punish punish, int n10) {
        m = true;
        Context context = fragment.requireContext();
        Intent intent = new Intent(context, AppealActivity.class);
        intent.putExtra(k, string2);
        intent.putExtra(l, (Parcelable)punish);
        fragment.startActivityForResult(intent, n10);
    }

    public static /* synthetic */ c d(AppealActivity appealActivity) {
        return appealActivity.c;
    }

    public static /* synthetic */ boolean f() {
        return m;
    }

    public static /* synthetic */ String h(AppealActivity appealActivity) {
        return appealActivity.g;
    }

    private void j() {
    }

    private void n() {
        Object object = this.c.c;
        Object object2 = new d.v.c.p0.p.f(this, (RecyclerView)object);
        this.d = object2;
        ((d.v.c.p0.p.f)object2).k(3);
        object2 = this.d;
        object = Windows.l((Context)this);
        int n10 = object.getWidth();
        float f10 = 32.0f;
        int n11 = h2.b(f10);
        ((d.v.c.p0.p.f)object2).l(n10 -= n11);
        object2 = this.getIntent();
        if (object2 != null) {
            this.g = object = object2.getStringExtra(k);
            this.e = object = (Approval)object2.getParcelableExtra(h);
            this.f = object2 = (Punish)object2.getParcelableExtra(l);
            object = this.b;
            String string2 = this.g;
            Approval approval = this.e;
            ((m)object).c((Context)this, string2, approval, (Punish)object2);
        }
    }

    private void o() {
        EditText editText = this.c.b;
        Object object = new AppealActivity$a(this);
        editText.addTextChangedListener((TextWatcher)object);
        editText = this.c.a;
        object = new d.v.c.p0.c(this);
        editText.setOnClickListener((View.OnClickListener)object);
        editText = this.c.i.b;
        object = new e(this);
        editText.setOnClickListener((View.OnClickListener)object);
    }

    private void p() {
        Window window = this.getWindow();
        int n10 = d.v.f.i.g.c((Context)this, 2131099772);
        StatusBarUtil.z(window, n10);
        StatusBarUtil.E(this.getWindow(), true);
        window = this.c.i.d;
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951639);
        window.setText((CharSequence)string2);
        this.c.i.c.setVisibility(8);
    }

    private void q() {
        String string2;
        boolean bl2;
        Object object = this.c.g;
        MovementMethod movementMethod = LinkMovementMethod.getInstance();
        object.setMovementMethod(movementMethod);
        object = this.getResources();
        int n10 = 2131951681;
        object = d.v.f.i.g.o((Resources)object, n10);
        movementMethod = new SpannableString((CharSequence)object);
        String string3 = "(";
        boolean n11 = ((String)object).contains(string3);
        if (n11 && (bl2 = ((String)object).contains(string2 = ")"))) {
            float f10 = 12.0f;
            int n12 = h2.g(f10);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(n12, false);
            int n13 = ((String)object).indexOf(string3);
            int n14 = ((String)object).indexOf(string2) + 1;
            int n15 = 18;
            movementMethod.setSpan((Object)absoluteSizeSpan, n13, n14, n15);
        }
        this.c.h.setText((CharSequence)movementMethod);
    }

    public static /* synthetic */ void r(AppealActivity appealActivity, SpannableString spannableString) {
        appealActivity.A(spannableString);
    }

    private /* synthetic */ void s(View object) {
        object = this.b;
        String string2 = this.c.b.getText().toString();
        ((m)object).d(string2);
    }

    private /* synthetic */ void u(View view) {
        ActivityCompat.finishAfterTransition(this);
    }

    public static /* synthetic */ void w(AppealActivity appealActivity, SpannableString spannableString) {
        appealActivity.z(spannableString);
    }

    private /* synthetic */ void x(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.C();
        }
    }

    private void z(SpannableString spannableString) {
        this.c.f.setText((CharSequence)spannableString);
    }

    public void B(boolean bl2) {
        if (!bl2) {
            return;
        }
        k$b k$b = new k$b((Context)this);
        Object object = d.v.f.i.g.o(this.getResources(), 2131951645);
        k$b = (k$b)k$b.B((String)object);
        object = d.v.f.i.g.o(this.getResources(), 2131952621);
        l l10 = d.v.c.p0.l.a;
        k$b = (k$b)k$b.x((String)object, l10);
        object = this.getSupportFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public void C() {
        s.r(this);
    }

    public void D(String string2) {
        n2.e(string2);
    }

    public void i(boolean bl2) {
        if (!bl2) {
            return;
        }
        m m10 = this.b;
        String string2 = this.g;
        Approval approval = this.e;
        Punish punish = this.f;
        String string3 = this.c.b.getText().toString();
        List list = this.k();
        AppealActivity$b appealActivity$b = new AppealActivity$b(this);
        m10.b(string2, approval, punish, string3, list, appealActivity$b);
    }

    public List k() {
        return this.d.d();
    }

    public void l(boolean bl2) {
        if (!bl2) {
            return;
        }
        String string2 = d.v.f.i.g.o(this.getResources(), 2131951876);
        String string3 = d.v.f.i.g.o(this.getResources(), 2131951874);
        SimpleWebViewActivity.h(this, string2, string3);
    }

    public void m() {
        s.j();
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        d.v.c.p0.p.f f10 = this.d;
        if (f10 != null) {
            f10.i(n10, n11, intent);
        }
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.getWindow();
        int n10 = d.v.f.i.g.c((Context)this, 2131099772);
        StatusBarUtil.z((Window)object, n10);
        StatusBarUtil.E(this.getWindow(), true);
        object = (c)DataBindingUtil.setContentView(this, 2131558429);
        this.c = object;
        object = (m)d.v.i0.b.c(this).get(m.class);
        this.b = object;
        this.j();
        this.p();
        this.q();
        this.n();
        this.o();
        object = this.b.e();
        Observer observer = new f(this);
        ((LiveData)object).observe(this, observer);
        object = this.b.g();
        observer = new d(this);
        ((LiveData)object).observe(this, observer);
        object = this.b.i();
        observer = new k(this);
        ((LiveData)object).observe(this, observer);
        object = this.b.j();
        observer = new b(this);
        ((LiveData)object).observe(this, observer);
        object = this.b.k();
        observer = new j(this);
        ((LiveData)object).observe(this, observer);
        object = this.b.l();
        observer = new d.v.c.p0.a(this);
        ((LiveData)object).observe(this, observer);
    }

    public void onPause() {
        super.onPause();
        EditText editText = this.c.b;
        v1.d((Context)this, (View)editText);
    }

    public /* synthetic */ void t(View view) {
        this.s(view);
    }

    public /* synthetic */ void v(View view) {
        this.u(view);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

