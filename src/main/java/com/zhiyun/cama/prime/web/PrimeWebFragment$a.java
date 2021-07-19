/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.web;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.prime.web.PrimeWebFragment;
import java.util.List;

public class PrimeWebFragment$a
implements Observer {
    public final /* synthetic */ List a;
    public final /* synthetic */ PrimeWebFragment b;

    public PrimeWebFragment$a(PrimeWebFragment primeWebFragment, List list) {
        this.b = primeWebFragment;
        this.a = list;
    }

    public void a(List list) {
        if (list != null) {
            PrimeWebFragment.J((PrimeWebFragment)this.b).g.removeObserver(this);
            PrimeWebFragment primeWebFragment = this.b;
            List list2 = this.a;
            PrimeWebFragment.O(primeWebFragment, list2, list);
        }
    }
}

