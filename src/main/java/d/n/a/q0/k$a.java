/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 */
package d.n.a.q0;

import android.os.DeadObjectException;
import d.n.a.q0.k;
import d.n.a.q0.p;
import d.n.a.q0.w.j;
import e.a.b0;
import e.a.c0;

public class k$a
implements c0 {
    public final /* synthetic */ j a;
    public final /* synthetic */ k b;

    public k$a(k k10, j j10) {
        this.b = k10;
        this.a = j10;
    }

    public void subscribe(b0 objectArray) {
        String string2 = null;
        k k10 = this.b;
        Object object = this.a;
        try {
            k10.b((b0)objectArray, (j)object);
        }
        catch (Throwable throwable) {
            objectArray.tryOnError(throwable);
            objectArray = new Object[]{};
            string2 = "QueueOperation terminated with an unexpected exception";
            p.e(throwable, string2, objectArray);
        }
        catch (DeadObjectException deadObjectException) {
            object = this.b.c(deadObjectException);
            objectArray.tryOnError((Throwable)object);
            objectArray = new Object[]{};
            string2 = "QueueOperation terminated with a DeadObjectException";
            p.e(deadObjectException, string2, objectArray);
        }
    }
}

