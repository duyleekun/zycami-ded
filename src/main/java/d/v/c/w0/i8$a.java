/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.Editable
 */
package d.v.c.w0;

import android.text.Editable;
import androidx.databinding.adapters.TextViewBindingAdapter$AfterTextChanged;
import d.v.c.x0.c.e.b$a;

public class i8$a
implements TextViewBindingAdapter$AfterTextChanged {
    private b$a a;

    public i8$a a(b$a object) {
        this.a = object;
        object = object == null ? null : this;
        return object;
    }

    public void afterTextChanged(Editable editable) {
        this.a.a(editable);
    }
}

