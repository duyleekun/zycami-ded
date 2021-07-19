/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 */
package com.zhiyun.account.me.account.widget;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.i.a.y0.e;

public class MeNameView$a
implements TextWatcher {
    public final /* synthetic */ MeNameView a;

    public MeNameView$a(MeNameView meNameView) {
        this.a = meNameView;
    }

    public void afterTextChanged(Editable object) {
        boolean bl2;
        Object object2;
        e e10 = MeNameView.a(this.a);
        if (e10 != null) {
            e10 = MeNameView.a(this.a);
            object2 = object.toString();
            e10.a((String)object2);
        }
        e10 = MeNameView.c((MeNameView)this.a).b;
        object2 = this.a;
        boolean bl3 = MeNameView.b((MeNameView)((Object)object2));
        int n10 = 8;
        if (bl3 && !(bl2 = TextUtils.isEmpty((CharSequence)(object = object.toString())))) {
            n10 = 0;
        }
        e10.setVisibility(n10);
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

