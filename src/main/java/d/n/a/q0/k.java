/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 */
package d.n.a.q0;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.q0.k$a;
import d.n.a.q0.u.p;
import d.n.a.q0.w.j;
import e.a.b0;
import e.a.z;

public abstract class k
implements p {
    public d.n.a.q0.j E() {
        return d.n.a.q0.j.c;
    }

    public final z O(j j10) {
        k$a k$a = new k$a(this, j10);
        return z.y1(k$a);
    }

    public int a(p p10) {
        int n10 = p10.E().a;
        int n11 = this.E().a;
        return n10 - n11;
    }

    public abstract void b(b0 var1, j var2);

    public abstract BleException c(DeadObjectException var1);
}

