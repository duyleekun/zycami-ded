/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.a7;

import androidx.lifecycle.MutableLiveData;
import d.v.c.s0.a7.b1;
import d.v.c.x1.n$b;

public class b1$a
implements n$b {
    public final /* synthetic */ b1 a;

    public b1$a(b1 b12) {
        this.a = b12;
    }

    public void onProgress(int n10) {
        MutableLiveData mutableLiveData = b1.u((b1)this.a).c;
        Integer n11 = n10;
        mutableLiveData.postValue(n11);
    }
}

