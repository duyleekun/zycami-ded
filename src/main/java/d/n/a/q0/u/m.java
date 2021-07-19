/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 */
package d.n.a.q0.u;

import android.bluetooth.BluetoothAdapter;
import d.n.a.q0.p;
import d.n.a.q0.t.b;
import d.n.a.q0.u.m$a;
import d.n.a.q0.u.v;
import d.n.a.q0.x.a0;
import d.n.a.q0.x.y;
import e.a.b0;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class m
extends v {
    public final a0 b;
    public final Set c;

    public m(UUID[] uUIDArray, y hashSet, a0 a02) {
        super((y)((Object)hashSet));
        int n10;
        this.b = a02;
        if (uUIDArray != null && (n10 = uUIDArray.length) > 0) {
            int n11 = uUIDArray.length;
            this.c = hashSet = new HashSet(n11);
            Collections.addAll(hashSet, uUIDArray);
        } else {
            uUIDArray = null;
            this.c = null;
        }
    }

    public BluetoothAdapter.LeScanCallback g(b0 b02) {
        m$a m$a = new m$a(this, b02);
        return m$a;
    }

    public boolean h(y y10, BluetoothAdapter.LeScanCallback leScanCallback) {
        Object[] objectArray = this.c;
        if (objectArray == null) {
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
        stringBuilder.append("LegacyScanOperation{");
        Object object = this.c;
        if (object == null) {
            object = "";
        } else {
            object = new StringBuilder();
            ((StringBuilder)object).append("ALL_MUST_MATCH -> uuids=");
            String string2 = d.n.a.q0.t.b.g(this.c);
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
        }
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

