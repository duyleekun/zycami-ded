/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.polidea.rxandroidble2.RxBleConnection$d;
import d.v.e0.k;
import d.v.e0.pd;
import e.a.e0;
import e.a.z;

public class pd$a
implements RxBleConnection$d {
    public final /* synthetic */ z a;
    public final /* synthetic */ pd b;

    public pd$a(pd pd2, z z10) {
        this.b = pd2;
        this.a = z10;
    }

    private /* synthetic */ Boolean b(byte[] byArray, Boolean bl2) {
        pd.a(this.b, byArray);
        return bl2;
    }

    public e0 a(z z10) {
        z z11 = this.a;
        k k10 = new k(this);
        return z.W7(z11, z10, k10);
    }

    public /* synthetic */ Boolean c(byte[] byArray, Boolean bl2) {
        this.b(byArray, bl2);
        return bl2;
    }
}

