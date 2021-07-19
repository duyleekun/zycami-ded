/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import com.polidea.rxandroidble2.exceptions.BleScanException;
import d.n.a.q0.v.n;
import d.n.a.q0.x.r;
import d.n.a.q0.x.y;

public class o
implements n {
    public final y a;
    public final r b;

    public o(y y10, r r10) {
        this.a = y10;
        this.b = r10;
    }

    public void a(boolean bl2) {
        Object object = this.a;
        boolean bl3 = ((y)object).c();
        if (bl3) {
            object = this.a;
            bl3 = ((y)object).d();
            if (bl3) {
                object = this.b;
                bl3 = object.b();
                if (bl3) {
                    Object object2;
                    if (bl2 && !(bl2 = (object2 = this.b).a())) {
                        object2 = new BleScanException(4);
                        throw object2;
                    }
                    return;
                }
                BleScanException bleScanException = new BleScanException(3);
                throw bleScanException;
            }
            BleScanException bleScanException = new BleScanException(1);
            throw bleScanException;
        }
        BleScanException bleScanException = new BleScanException(2);
        throw bleScanException;
    }
}

