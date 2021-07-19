/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 */
package d.v.c.f1.a;

import android.text.Editable;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import d.v.c.f1.a.a$a;

public final class a
implements TextViewBindingAdapter$AfterTextChanged {
    public final a$a a;
    public final int b;

    public a(a$a a$a, int n10) {
        this.a = a$a;
        this.b = n10;
    }

    public void afterTextChanged(Editable editable) {
        a$a a$a = this.a;
        int n10 = this.b;
        a$a.b(n10, editable);
    }
}

