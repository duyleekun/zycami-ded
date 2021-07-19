/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipData
 *  android.content.ClipboardManager
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.net.Uri
 *  android.view.View
 */
package com.zhiyun.cama.set;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.account.SimpleWebViewActivity;
import com.zhiyun.cama.set.SetSupportFragment;
import d.v.c.q1.y;
import d.v.c.q1.z;
import d.v.c.x1.l;
import d.v.e.l.n2;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class SetSupportFragment$a {
    public final /* synthetic */ SetSupportFragment a;

    public SetSupportFragment$a(SetSupportFragment setSupportFragment) {
        this.a = setSupportFragment;
    }

    private /* synthetic */ void e(DialogFragment dialogFragment) {
        this.h();
    }

    public static /* synthetic */ void g(DialogFragment dialogFragment) {
    }

    private void h() {
        Object object = new Intent();
        String string2 = "com.tencent.mm.ui.LauncherUI";
        Object object2 = new ComponentName("com.tencent.mm", string2);
        object.setAction("android.intent.action.MAIN");
        Object[] objectArray = "android.intent.category.LAUNCHER";
        object.addCategory((String)objectArray);
        int n10 = 0x10000000;
        object.addFlags(n10);
        object.setComponent((ComponentName)object2);
        object2 = this.a;
        try {
            ((Fragment)object2).startActivity((Intent)object);
        }
        catch (Exception exception) {
            object = this.a.getResources();
            int n11 = 2131952933;
            n10 = 1;
            objectArray = new Object[n10];
            string2 = null;
            Object object3 = this.a.getResources();
            int n12 = 2131952947;
            object3 = g.o(object3, n12);
            objectArray[0] = object3;
            object = g.p((Resources)object, n11, objectArray);
            n2.e((String)object);
        }
    }

    public void a(View view) {
        l.g(view);
    }

    public void b(View object) {
        FragmentActivity fragmentActivity = this.a.getActivity();
        object = g.q(object, 2131952882);
        String string2 = g.o(this.a.getResources(), 2131952883);
        SimpleWebViewActivity.h(fragmentActivity, (String)object, string2);
    }

    public void c(View object) {
        object = g.o(this.a.getResources(), 2131952924);
        Intent intent = new Intent("android.intent.action.DIAL");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tel:");
        stringBuilder.append((String)object);
        object = Uri.parse((String)stringBuilder.toString());
        intent.setData((Uri)object);
        this.a.startActivity(intent);
    }

    public void d(View object) {
        object = this.a.getActivity();
        if (object == null) {
            return;
        }
        object = (ClipboardManager)this.a.getActivity().getSystemService("clipboard");
        Object object2 = this.a.getResources();
        int n10 = 2131952909;
        object2 = g.o(object2, n10);
        Object object3 = "wechat";
        object2 = ClipData.newPlainText((CharSequence)object3, (CharSequence)object2);
        if (object != null) {
            object.setPrimaryClip((ClipData)object2);
            object2 = this.a.getContext();
            object = new k$b((Context)object2);
            object2 = g.o(this.a.getResources(), 2131952908);
            object = (k$b)((k$a)object).B((String)object2);
            object2 = this.a.getResources();
            n10 = 2131952885;
            object2 = g.o(object2, n10);
            object3 = new y(this);
            object = (k$b)((k$a)object).x((String)object2, (a)object3);
            object2 = z.a;
            object = (k$b)((k$a)object).p((a)object2);
            object2 = this.a.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        }
    }

    public /* synthetic */ void f(DialogFragment dialogFragment) {
        this.e(dialogFragment);
    }
}

