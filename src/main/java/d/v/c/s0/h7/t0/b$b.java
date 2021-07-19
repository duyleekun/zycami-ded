/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextUtils
 *  android.text.TextWatcher
 */
package d.v.c.s0.h7.t0;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import d.v.c.s0.h7.t0.b;

public class b$b
implements TextWatcher {
    public final /* synthetic */ b a;

    public b$b(b b10) {
        this.a = b10;
    }

    public void afterTextChanged(Editable object) {
        object = b.k((b)this.a).a.getText().toString();
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 != 0) {
            object = b.k((b)this.a).d;
            n10 = 8;
            object.setVisibility(n10);
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            int n11 = ((String)object).length();
            stringBuilder.append(n11);
            stringBuilder.append("/30");
            object = stringBuilder.toString();
            b.k((b)this.a).d.setText((CharSequence)object);
            object = b.k((b)this.a).d;
            n10 = 0;
            stringBuilder = null;
            object.setVisibility(0);
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

