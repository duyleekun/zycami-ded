/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.view.View
 */
package com.zhiyun.cama.set;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.set.SetAboutFragment;
import d.v.c.q1.g0;
import d.v.c.x1.l;
import d.v.e.l.d1;
import d.v.f.i.g;

public class SetAboutFragment$a {
    public final /* synthetic */ SetAboutFragment a;

    public SetAboutFragment$a(SetAboutFragment setAboutFragment) {
        this.a = setAboutFragment;
    }

    public void a(View view) {
        l.g(view);
    }

    public void b(View object) {
        object = "android.intent.action.VIEW";
        String string2 = d1.d();
        SetAboutFragment setAboutFragment = this.a;
        CharSequence charSequence = new StringBuilder();
        String string3 = "market://details?id=";
        charSequence.append(string3);
        charSequence.append(string2);
        charSequence = charSequence.toString();
        charSequence = Uri.parse((String)charSequence);
        Intent intent = new Intent((String)object, (Uri)charSequence);
        try {
            setAboutFragment.startActivity(intent);
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            setAboutFragment = this.a;
            charSequence = new StringBuilder();
            string3 = "https://play.google.com/store/apps/details?id=";
            charSequence.append(string3);
            charSequence.append(string2);
            string2 = Uri.parse((String)charSequence.toString());
            intent = new Intent((String)object, (Uri)string2);
            setAboutFragment.startActivity(intent);
        }
    }

    public void c(View object) {
        FragmentActivity fragmentActivity = this.a.requireActivity();
        String string2 = g.q(object, 2131952719);
        object = g.q(object, 2131952720);
        SimpleWebViewActivity.j((Context)fragmentActivity, string2, (String)object);
    }

    public void d(View view) {
    }

    public void e(View object) {
        object = SetAboutFragment.j(this.a);
        Context context = this.a.requireContext();
        ((g0)object).d(context);
    }

    public void f(View object) {
        FragmentActivity fragmentActivity = this.a.requireActivity();
        String string2 = g.q(object, 2131953235);
        object = g.q(object, 2131953236);
        SimpleWebViewActivity.j((Context)fragmentActivity, string2, (String)object);
    }
}

