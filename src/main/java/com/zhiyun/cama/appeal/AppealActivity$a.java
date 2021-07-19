/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 */
package com.zhiyun.cama.appeal;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.zhiyun.cama.appeal.AppealActivity;

public class AppealActivity$a
implements TextWatcher {
    public final /* synthetic */ AppealActivity a;

    public AppealActivity$a(AppealActivity appealActivity) {
        this.a = appealActivity;
    }

    public void afterTextChanged(Editable object) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            object = "0";
        } else {
            int n10 = object.toString().length();
            object = n10;
        }
        stringBuilder.append(object);
        stringBuilder.append("/300");
        object = stringBuilder.toString();
        AppealActivity.d((AppealActivity)this.a).e.setText((CharSequence)object);
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

