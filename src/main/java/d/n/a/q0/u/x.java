/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanSettings
 */
package d.n.a.q0.u;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import d.n.a.q0.p;
import d.n.a.q0.u.v;
import d.n.a.q0.u.x$a;
import d.n.a.q0.v.a;
import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.x.y;
import d.n.a.r0.b;
import e.a.b0;
import java.util.Arrays;
import java.util.List;

public class x
extends v {
    public final g b;
    private final a c;
    private final d.n.a.r0.e d;
    public final e e;
    private final b[] f;

    public x(y y10, g g10, a a10, d.n.a.r0.e e10, e e11, b[] bArray) {
        super(y10);
        this.b = g10;
        this.d = e10;
        this.e = e11;
        this.f = bArray;
        this.c = a10;
    }

    public static int h(int n10) {
        int n11 = 1;
        int n12 = 5;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        if (n10 != n12) {
                            Object[] objectArray = new Object[]{};
                            p.u("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", objectArray);
                            return -1 >>> 1;
                        }
                        return 9;
                    }
                    return 8;
                }
                return 7;
            }
            return 6;
        }
        return n12;
    }

    public ScanCallback g(b0 b02) {
        x$a x$a = new x$a(this, b02);
        return x$a;
    }

    public boolean i(y y10, ScanCallback scanCallback) {
        Object object;
        Object object2 = this.e;
        boolean bl2 = object2.a();
        if (bl2) {
            bl2 = false;
            object2 = new Object[]{};
            object = "No library side filtering \u2014> debug logs of scanned devices disabled";
            p.b((String)object, object2);
        }
        object2 = this.c;
        object = this.f;
        object2 = object2.c((b[])object);
        object = this.c;
        d.n.a.r0.e e10 = this.d;
        object = ((a)object).d(e10);
        y10.f((List)object2, (ScanSettings)object, scanCallback);
        return true;
    }

    public void j(y y10, ScanCallback scanCallback) {
        y10.i(scanCallback);
    }

    public String toString() {
        CharSequence charSequence;
        int n10;
        Object object = this.f;
        if (object != null && (n10 = ((b[])object).length) != 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = 1;
        }
        e e10 = this.e;
        boolean bl2 = e10.a();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScanOperationApi21{");
        String string2 = "";
        if (n10 != 0) {
            charSequence = string2;
        } else {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("ANY_MUST_MATCH -> nativeFilters=");
            String string3 = Arrays.toString(this.f);
            ((StringBuilder)charSequence).append(string3);
            charSequence = ((StringBuilder)charSequence).toString();
        }
        stringBuilder.append((String)charSequence);
        object = n10 == 0 && !bl2 ? " and then " : string2;
        stringBuilder.append((String)object);
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("ANY_MUST_MATCH -> ");
            e10 = this.e;
            ((StringBuilder)object).append(e10);
            string2 = ((StringBuilder)object).toString();
        }
        stringBuilder.append(string2);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

