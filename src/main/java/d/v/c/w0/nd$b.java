/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.TextView
 */
package d.v.c.w0;

import android.widget.TextView;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.lifecycle.LiveData;
import d.v.c.s0.d7.z;
import d.v.c.w0.nd;
import d.v.n.j.b;

public class nd$b
implements InverseBindingListener {
    public final /* synthetic */ nd a;

    public nd$b(nd nd2) {
        this.a = nd2;
    }

    public void onChange() {
        String string2 = TextViewBindingAdapter.getTextString((TextView)this.a.b);
        Object object = this.a.n;
        boolean bl2 = true;
        boolean bl3 = object != null ? bl2 : false;
        if (bl3 && (bl3 = (object = ((z)object).p) != null ? bl2 : false)) {
            if ((object = (b)((LiveData)object).getValue()) == null) {
                bl2 = false;
            }
            if (bl2) {
                ((b)object).N(string2);
            }
        }
    }
}

