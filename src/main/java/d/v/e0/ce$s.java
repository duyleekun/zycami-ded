/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import e.a.v0.o;
import e.a.z;

public class ce$s
implements o {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ ce c;

    public ce$s(ce ce2, String string2, String string3) {
        this.c = ce2;
        this.a = string2;
        this.b = string3;
    }

    public z a(Boolean object) {
        object = ce.s(this.c);
        String string2 = this.a;
        String string3 = this.b;
        return ((Stabilizer)object).v0(string2, string3);
    }
}

