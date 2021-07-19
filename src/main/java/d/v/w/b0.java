/*
 * Decompiled with CFR 0.151.
 */
package d.v.w;

import androidx.core.util.Pair;
import com.zhiyun.pay.data.PurchaseResult;
import d.v.w.b0$a;
import d.v.w.b0$b;
import java.util.Observable;

public class b0
extends Observable {
    private b0() {
    }

    public /* synthetic */ b0(b0$a b0$a) {
        this();
    }

    public static b0 a() {
        return b0$b.a();
    }

    public void b(Pair pair) {
        this.setChanged();
        this.notifyObservers(pair);
    }

    public void c(PurchaseResult purchaseResult) {
        this.setChanged();
        this.notifyObservers((Object)purchaseResult);
    }
}

