/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.DeadObjectException
 */
package d.n.a.q0.u;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import d.n.a.q0.k;
import d.n.a.q0.p;
import d.n.a.q0.u.v$a;
import d.n.a.q0.w.j;
import d.n.a.q0.x.y;
import e.a.b0;
import e.a.v0.f;

public abstract class v
extends k {
    public final y a;

    public v(y y10) {
        this.a = y10;
    }

    public final void b(b0 b02, j j10) {
        block16: {
            Object object = this.d(b02);
            Object object2 = new v$a(this, object);
            b02.setCancellable((f)object2);
            object2 = "Scan operation is requested to start.";
            Object[] objectArray = new Object[]{};
            p.k((String)object2, objectArray);
            object2 = this.a;
            boolean bl2 = this.e((y)object2, object);
            if (bl2) break block16;
            object = new BleScanException(0);
            try {
                b02.tryOnError((Throwable)object);
            }
            catch (Throwable throwable) {
                object2 = "Error while calling the start scan function";
                objectArray = new Object[]{};
                p.v(throwable, (String)object2, objectArray);
                object2 = new BleScanException(0, throwable);
                b02.tryOnError((Throwable)object2);
            }
        }
        return;
        {
            finally {
                j10.release();
            }
        }
    }

    public BleException c(DeadObjectException deadObjectException) {
        BleScanException bleScanException = new BleScanException(1, (Throwable)deadObjectException);
        return bleScanException;
    }

    public abstract Object d(b0 var1);

    public abstract boolean e(y var1, Object var2);

    public abstract void f(y var1, Object var2);
}

