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
import com.zhiyun.account.me.account.widget.MeGetCodeView;
import d.v.a.i.a.y0.e;

public class MeGetCodeView$a
implements TextWatcher {
    public final /* synthetic */ MeGetCodeView a;

    public MeGetCodeView$a(MeGetCodeView meGetCodeView) {
        this.a = meGetCodeView;
    }

    public void afterTextChanged(Editable object) {
        e e10 = MeGetCodeView.a(this.a);
        if (e10 != null) {
            e10 = MeGetCodeView.a(this.a);
            object = object.toString();
            e10.a((String)object);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

