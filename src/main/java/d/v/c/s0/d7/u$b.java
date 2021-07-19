/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package d.v.c.s0.d7;

import android.text.Editable;
import android.text.TextWatcher;
import d.v.c.s0.d7.u;
import d.v.c.w0.si;

public class u$b
implements TextWatcher {
    public final /* synthetic */ si a;
    public final /* synthetic */ u b;

    public u$b(u u10, si si2) {
        this.b = u10;
        this.a = si2;
    }

    public void afterTextChanged(Editable editable) {
        int n10 = this.a.d.a.getText().toString().length();
        this.a.d.a.setSelection(n10);
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

