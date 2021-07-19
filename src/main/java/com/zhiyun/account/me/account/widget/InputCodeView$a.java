/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.zhiyun.account.me.account.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.zhiyun.account.me.account.widget.InputCodeView;

public class InputCodeView$a
implements TextWatcher {
    public final /* synthetic */ LinearLayout a;
    public final /* synthetic */ InputCodeView b;

    public InputCodeView$a(InputCodeView inputCodeView, LinearLayout linearLayout) {
        this.b = inputCodeView;
        this.a = linearLayout;
    }

    public void afterTextChanged(Editable object) {
        InputCodeView inputCodeView;
        int n10;
        int n11;
        object = this.b;
        Object object2 = InputCodeView.c((InputCodeView)((Object)object)).getText().toString();
        InputCodeView.b((InputCodeView)((Object)object), object2);
        object = InputCodeView.a(this.b);
        int n12 = ((String)object).length();
        object2 = null;
        for (n11 = 0; n11 < (n10 = InputCodeView.d(inputCodeView = this.b)); ++n11) {
            String string2;
            inputCodeView = (TextView)this.a.getChildAt(n11);
            if (n11 < n12) {
                char c10 = InputCodeView.a(this.b).charAt(n11);
                string2 = String.valueOf(c10);
                inputCodeView.setText(string2);
                continue;
            }
            string2 = "";
            inputCodeView.setText(string2);
        }
        object2 = this.b;
        n11 = InputCodeView.d((InputCodeView)((Object)object2));
        if (n11 == n12 && (object = InputCodeView.e(this.b)) != null) {
            object = InputCodeView.e(this.b);
            object2 = InputCodeView.a(this.b);
            object.a((String)object2);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

