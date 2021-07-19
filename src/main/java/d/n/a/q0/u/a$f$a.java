/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import com.polidea.rxandroidble2.RxBleConnection$e$a;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattCharacteristicException;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.n.a.q0.u.a$f;
import e.a.v0.o;
import e.a.z;

public class a$f$a
implements o {
    public final /* synthetic */ a$f a;

    public a$f$a(a$f f10) {
        this.a = f10;
    }

    public z a(Throwable throwable) {
        int n10 = throwable instanceof BleGattCharacteristicException;
        if (n10 == 0 && (n10 = throwable instanceof BleGattCannotStartException) == 0) {
            return z.m2(throwable);
        }
        n10 = this.a.b.get();
        throwable = (BleGattException)throwable;
        RxBleConnection$e$a rxBleConnection$e$a = new RxBleConnection$e$a(n10, (BleGattException)throwable);
        return z.t3(rxBleConnection$e$a);
    }
}

