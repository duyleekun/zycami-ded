/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.mediacontent.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity$a;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity$b;
import d.v.c.k1.a.m;
import d.v.c.k1.a.q;
import d.v.c.k1.a.w;
import d.v.c.q0.a;
import d.v.c.w0.g;
import d.v.e.l.o1;
import d.v.i0.b;
import java.util.Objects;

public class EditorAddVideoActivity
extends a {
    private w b;
    private g c;

    public static /* synthetic */ g i(EditorAddVideoActivity editorAddVideoActivity) {
        return editorAddVideoActivity.c;
    }

    public static /* synthetic */ w j(EditorAddVideoActivity editorAddVideoActivity) {
        return editorAddVideoActivity.b;
    }

    private void k() {
        MutableLiveData mutableLiveData = this.b.o();
        m m10 = new m(this);
        mutableLiveData.observe(this, m10);
    }

    private /* synthetic */ void l(Boolean bl2) {
        int n10;
        TextView textView = this.c.b.c;
        Resources resources = this.getResources();
        n10 = bl2 != null && (n10 = (int)(bl2.booleanValue() ? 1 : 0)) != 0 ? 2131099738 : 2131099793;
        n10 = o1.c(resources, n10);
        textView.setTextColor(n10);
    }

    public static void o(Activity activity, long l10) {
        Intent intent = new Intent((Context)activity, EditorAddVideoActivity.class);
        Bundle bundle = AddVideoFragment.D(l10);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    public static void p(Activity activity, String string2, int n10) {
        Intent intent = new Intent((Context)activity, EditorAddVideoActivity.class);
        string2 = AddVideoFragment.E(string2, n10);
        intent.putExtras((Bundle)string2);
        activity.startActivity(intent);
    }

    public static void q(Activity activity, String string2, int n10, int n11) {
        Intent intent = new Intent((Context)activity, EditorAddVideoActivity.class);
        string2 = AddVideoFragment.E(string2, n10);
        intent.putExtras((Bundle)string2);
        activity.startActivityForResult(intent, n11);
    }

    public int d() {
        return 2131558433;
    }

    public void f(ViewDataBinding object, Bundle bundle) {
        super.f((ViewDataBinding)object, bundle);
        object = (g)object;
        this.c = object;
        Object object2 = new EditorAddVideoActivity$b(this);
        ((g)object).A((EditorAddVideoActivity$b)object2);
        object = d.v.i0.b.c(this);
        object2 = w.class;
        this.b = object = (w)((ViewModelProvider)object).get((Class)object2);
        object = this.getIntent();
        Objects.requireNonNull(object);
        object = ((Intent)object).getExtras();
        if (object != null) {
            object2 = "template";
            boolean bl2 = TextUtils.equals((CharSequence)object2, (CharSequence)(object = q.b((Bundle)object).c()));
            if (!bl2) {
                object = this.c;
                object2 = Boolean.TRUE;
                ((g)object).B((Boolean)object2);
            } else {
                object = this.c;
                object2 = Boolean.FALSE;
                ((g)object).B((Boolean)object2);
                object = this.c.b.b;
                object2 = d.v.f.i.g.o(this.getResources(), 2131952010);
                object.setText((CharSequence)object2);
                object = this.c.b.c;
                object2 = d.v.f.i.g.o(this.getResources(), 2131952612);
                object.setText((CharSequence)object2);
                object = this.c.b.c;
                object2 = this.getResources();
                int n10 = 2131099738;
                int n11 = o1.c((Resources)object2, n10);
                object.setTextColor(n11);
            }
        }
        if (bundle == null) {
            this.n();
        }
        this.k();
    }

    public /* synthetic */ void m(Boolean bl2) {
        this.l(bl2);
    }

    public void n() {
        AddVideoFragment addVideoFragment = AddVideoFragment.d0(this.getIntent().getExtras());
        FragmentTransaction fragmentTransaction = this.getSupportFragmentManager().beginTransaction();
        Object object = addVideoFragment.getClass().getName();
        fragmentTransaction.add(2131362795, (Fragment)addVideoFragment, (String)object);
        fragmentTransaction.commit();
        fragmentTransaction = this.c.getRoot().getViewTreeObserver();
        object = new EditorAddVideoActivity$a(this, addVideoFragment);
        fragmentTransaction.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
    }
}

