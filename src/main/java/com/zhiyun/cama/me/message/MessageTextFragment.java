/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.me.message;

import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.me.message.MessageTextFragment$a;
import com.zhiyun.common.util.Times;
import d.v.c.j1.b.m0;
import d.v.c.w0.of;
import d.v.f.h.a;

public class MessageTextFragment
extends a {
    private of b;

    private void j() {
        Object object = this.getArguments();
        if (object == null) {
            return;
        }
        object = m0.b(this.getArguments()).e();
        String string2 = m0.b(this.getArguments()).d();
        String string3 = m0.b(this.getArguments()).c();
        this.b.d.setText((CharSequence)object);
        object = this.b.c;
        string2 = Times.getTimeZoneDesNoSecond(string2);
        object.setText((CharSequence)string2);
        this.b.b.setText((CharSequence)string3);
    }

    public int h() {
        return 2131558710;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (of)viewDataBinding;
        this.b = viewDataBinding;
        MessageTextFragment$a messageTextFragment$a = new MessageTextFragment$a(this);
        ((of)viewDataBinding).z(messageTextFragment$a);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.j();
    }
}

