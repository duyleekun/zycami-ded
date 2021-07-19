/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.w0;

import androidx.databinding.InverseBindingListener;
import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.d7.z;
import d.v.c.w0.xd;

public class xd$a
implements InverseBindingListener {
    public final /* synthetic */ xd a;

    public xd$a(xd xd2) {
        this.a = xd2;
    }

    public void onChange() {
        Object object = this.a.a;
        boolean bl2 = object.isChecked();
        Object object2 = this.a.i;
        boolean bl3 = true;
        boolean bl4 = object2 != null ? bl3 : false;
        if (bl4) {
            if ((object2 = ((z)object2).W()) == null) {
                bl3 = false;
            }
            if (bl3) {
                object = bl2;
                ((MutableLiveData)object2).setValue(object);
            }
        }
    }
}

