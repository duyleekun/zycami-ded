/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 *  android.text.TextWatcher
 */
package d.v.c.n1;

import android.text.Editable;
import android.text.TextWatcher;
import d.v.c.n1.i2;
import d.v.c.n1.j2;

public class i2$a
implements TextWatcher {
    public final /* synthetic */ i2 a;

    public i2$a(i2 i22) {
        this.a = i22;
    }

    public void afterTextChanged(Editable object) {
        j2 j22 = i2.u(this.a);
        object = object.toString();
        j22.g0((String)object);
    }

    public void beforeTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }

    public void onTextChanged(CharSequence charSequence, int n10, int n11, int n12) {
    }
}

