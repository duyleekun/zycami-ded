/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package d.v.c.s0.a7;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.a7.a;
import d.v.c.s0.s6;
import d.v.i0.b;

public abstract class t0
extends d.v.f.g.a {
    private /* synthetic */ void u(s6 object, Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.dismissAllowingStateLoss();
            object = ((s6)object).f;
            bl2 = Boolean.FALSE;
            ((MutableLiveData)object).setValue(bl2);
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        object = (s6)b.c(this.requireActivity()).get(s6.class);
        object2 = object.f;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        a a10 = new a(this, (s6)object);
        ((LiveData)object2).observe(lifecycleOwner, a10);
    }

    public /* synthetic */ void v(s6 s62, Boolean bl2) {
        this.u(s62, bl2);
    }
}

