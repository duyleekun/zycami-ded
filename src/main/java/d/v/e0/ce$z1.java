/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import androidx.core.util.Pair;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.zhiyun.protocol.message.bl.other.Status;
import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$z1
implements o {
    public final /* synthetic */ short a;
    public final /* synthetic */ ce b;

    public ce$z1(ce ce2, short s10) {
        this.b = ce2;
        this.a = s10;
    }

    public e0 a(Pair object) {
        Object object2 = ((Pair)object).first;
        Status status = Status.ERR_NONE;
        if (object2 != status) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Write status error :  ");
            object = ((Pair)object).first;
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(", current page = ");
            short s10 = this.a;
            ((StringBuilder)object2).append(s10);
            q.c(((StringBuilder)object2).toString());
            object = new BleException("Send error to trigger retry");
            return z.m2((Throwable)object);
        }
        return z.t3(object);
    }
}

