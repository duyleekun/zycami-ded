/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.View
 */
package com.zhiyun.account.me.account.widget;

import android.app.Activity;
import android.view.View;
import com.zhiyun.account.me.account.widget.MeNameView;
import com.zhiyun.account.me.country.CountryChooseActivity;

public class MeNameView$b {
    public final /* synthetic */ MeNameView a;

    public MeNameView$b(MeNameView meNameView) {
        this.a = meNameView;
    }

    public void a(View view) {
        MeNameView.c((MeNameView)this.a).a.setText((CharSequence)"");
    }

    public void b(View view) {
        view = (Activity)this.a.getContext();
        boolean bl2 = MeNameView.d(this.a);
        CountryChooseActivity.q((Activity)view, bl2);
    }
}

