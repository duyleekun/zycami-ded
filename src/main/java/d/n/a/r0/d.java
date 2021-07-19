/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.r0;

import com.polidea.rxandroidble2.scan.ScanCallbackType;
import d.n.a.j0;
import d.n.a.q0.t.b;
import d.n.a.r0.c;

public class d {
    private final j0 a;
    private final int b;
    private final long c;
    private final ScanCallbackType d;
    private final c e;

    public d(j0 j02, int n10, long l10, ScanCallbackType scanCallbackType, c c10) {
        this.a = j02;
        this.b = n10;
        this.c = l10;
        this.d = scanCallbackType;
        this.e = c10;
    }

    public j0 a() {
        return this.a;
    }

    public ScanCallbackType b() {
        return this.d;
    }

    public int c() {
        return this.b;
    }

    public c d() {
        return this.e;
    }

    public long e() {
        return this.c;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ScanResult{bleDevice=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", rssi=");
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", timestampNanos=");
        long l10 = this.c;
        stringBuilder.append(l10);
        stringBuilder.append(", callbackType=");
        object = this.d;
        stringBuilder.append(object);
        stringBuilder.append(", scanRecord=");
        object = d.n.a.q0.t.b.a(this.e.g());
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

