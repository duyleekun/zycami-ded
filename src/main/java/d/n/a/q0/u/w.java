/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothAdapter;
import d.n.a.q0.p;
import d.n.a.q0.u.v;
import d.n.a.q0.u.w$a;
import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.x.y;
import e.a.b0;

public class w
extends v {
    public final g b;
    public final e c;

    public w(y y10, g g10, e e10) {
        super(y10);
        this.b = g10;
        this.c = e10;
    }

    public BluetoothAdapter.LeScanCallback g(b0 b02) {
        w$a w$a = new w$a(this, b02);
        return w$a;
    }

    public boolean h(y y10, BluetoothAdapter.LeScanCallback leScanCallback) {
        Object[] objectArray = this.c;
        boolean bl2 = objectArray.a();
        if (bl2) {
            bl2 = false;
            objectArray = new Object[]{};
            String string2 = "No library side filtering \u2014> debug logs of scanned devices disabled";
            p.b(string2, objectArray);
        }
        return y10.g(leScanCallback);
    }

    public void i(y y10, BluetoothAdapter.LeScanCallback leScanCallback) {
        y10.j(leScanCallback);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScanOperationApi18{");
        Object object = this.c;
        boolean bl2 = ((e)object).a();
        if (bl2) {
            object = "";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("ANY_MUST_MATCH -> ");
            e e10 = this.c;
            ((StringBuilder)object).append(e10);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

