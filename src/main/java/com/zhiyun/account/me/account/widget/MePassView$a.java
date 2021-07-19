/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package com.zhiyun.account.me.account.widget;

import android.text.Editable;
import android.text.TextWatcher;
import com.zhiyun.account.me.account.widget.MePassView;
import d.v.a.i.a.y0.e;

public class MePassView$a
implements TextWatcher {
    public final /* synthetic */ MePassView a;

    public MePassView$a(MePassView mePassView) {
        this.a = mePassView;
    }

    public void afterTextChanged(Editable object) {
        e e10 = MePassView.a(this.a);
        if (e10 != null) {
            e10 = MePassView.a(this.a);
            object = object.toString();
            e10.a((String)object);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

