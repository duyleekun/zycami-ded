/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.TextView
 */
package com.zhiyun.cama.me.message;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.zhiyun.cama.data.database.model.MessageUnReadCount;
import com.zhiyun.cama.me.message.MessageFragment$a;
import d.v.c.j1.b.o0;
import d.v.c.w0.ef;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.i0.b;
import d.v.j.e.h.k;

public class MessageFragment
extends a {
    private ef b;
    private o0 c;

    private void j() {
        LiveData liveData = this.c.g();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        d.v.c.j1.b.a a10 = new d.v.c.j1.b.a(this);
        liveData.observe(lifecycleOwner, a10);
    }

    private /* synthetic */ void k(k object) {
        Object object2;
        if (object != null && (object2 = ((k)object).c) != null) {
            Object object3 = this.b.b;
            int n10 = ((MessageUnReadCount)object2).getLike();
            this.m((TextView)object3, n10);
            object2 = this.b.c;
            object3 = (MessageUnReadCount)((k)object).c;
            int n11 = ((MessageUnReadCount)object3).getNotice();
            this.m((TextView)object2, n11);
            object2 = this.b.e;
            object = (MessageUnReadCount)((k)object).c;
            int n12 = ((MessageUnReadCount)object).getPersonal();
            this.m((TextView)object2, n12);
        } else {
            object = this.b.b;
            boolean bl2 = false;
            object2 = null;
            this.m((TextView)object, 0);
            object = this.b.c;
            this.m((TextView)object, 0);
            object = this.b.e;
            this.m((TextView)object, 0);
        }
    }

    private void m(TextView textView, int n10) {
        if (n10 <= 0) {
            n10 = 8;
            textView.setVisibility(n10);
        } else {
            int n11 = 99;
            if (n10 > n11) {
                textView.setVisibility(0);
                Object object = this.getResources();
                n11 = 2131952583;
                object = g.o(object, n11);
                textView.setText((CharSequence)object);
            } else {
                textView.setVisibility(0);
                String string2 = String.valueOf(n10);
                textView.setText((CharSequence)string2);
            }
        }
    }

    public int h() {
        return 2131558705;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (ef)viewDataBinding;
        this.b = viewDataBinding;
        Object object = this.c;
        ((ef)viewDataBinding).B((o0)object);
        viewDataBinding = this.b;
        object = new MessageFragment$a(this);
        ((ef)viewDataBinding).A((MessageFragment$a)object);
    }

    public /* synthetic */ void l(k k10) {
        this.k(k10);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (o0)d.v.i0.b.c(this.requireActivity()).get(o0.class);
        this.c = object;
    }

    public void onResume() {
        super.onResume();
        this.c.L();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.j();
    }
}

