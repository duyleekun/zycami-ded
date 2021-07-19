/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.camera.liveassistant;

import android.content.Context;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment;
import com.zhiyun.cama.camera.liveassistant.LiveAssistantFragment$b;
import d.v.c.s0.e7.j;
import d.v.c.x1.l;
import d.v.c.y0.b.s;
import d.v.f.f.a;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class LiveAssistantFragment$c {
    public final /* synthetic */ LiveAssistantFragment a;

    public LiveAssistantFragment$c(LiveAssistantFragment liveAssistantFragment) {
        this.a = liveAssistantFragment;
    }

    private /* synthetic */ void d(DialogFragment dialogFragment) {
        dialogFragment.dismiss();
        LiveAssistantFragment.k(this.a);
    }

    public void a() {
        LiveAssistantFragment.h(this.a);
    }

    public void b() {
        s s10 = new s();
        s10.X(false);
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        s10.q(fragmentManager);
    }

    public void c() {
        l.d(this.a, 2131361809);
    }

    public /* synthetic */ void e(DialogFragment dialogFragment) {
        this.d(dialogFragment);
    }

    public void f() {
        Object object = LiveAssistantFragment$b.a;
        Object object2 = LiveAssistantFragment.i(this.a).l();
        int n10 = object2.ordinal();
        int n11 = object[n10];
        if (n11 != (n10 = 1)) {
            n10 = 4;
            if (n11 == n10) {
                object = this.a;
                LiveAssistantFragment.j((LiveAssistantFragment)object);
            }
        } else {
            object = new k$b;
            object2 = this.a.getContext();
            ((k$b)object)((Context)object2);
            object = (k$b)((k$a)object).m(2131952439);
            a a10 = d.v.c.s0.e7.a.a;
            object = (k$b)((k$a)object).o(2131951833, a10);
            n10 = 2131951887;
            a10 = new j(this);
            object = (k$b)((k$a)object).v(n10, a10);
            object2 = this.a.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        }
    }
}

