/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.s0.a7;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.a7.l1;

public class l1$b {
    public final /* synthetic */ l1 a;

    public l1$b(l1 l12) {
        this.a = l12;
    }

    private void e(MutableLiveData mutableLiveData) {
        Float f10 = Float.valueOf(0.0f);
        mutableLiveData.setValue(f10);
    }

    public void a(View view) {
        this.a.i();
        l1.w(this.a).d1();
    }

    public void b(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = l1.w((l1)object).K;
        l1.x((l1)object, mutableLiveData, true);
    }

    public void c(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = l1.w((l1)object).K;
        l1.x((l1)object, mutableLiveData, false);
    }

    public void d(View object) {
        object = l1.w((l1)this.a).K;
        this.e((MutableLiveData)object);
    }

    public void f(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = l1.w((l1)object).J;
        l1.x((l1)object, mutableLiveData, true);
    }

    public void g(View object) {
        object = this.a;
        MutableLiveData mutableLiveData = l1.w((l1)object).J;
        l1.x((l1)object, mutableLiveData, false);
    }

    public void h(View object) {
        object = l1.w((l1)this.a).J;
        this.e((MutableLiveData)object);
    }
}

