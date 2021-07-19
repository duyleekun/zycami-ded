/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ce;
import d.v.e0.oe.q;
import d.v.y.d.a;
import e.a.e0;
import e.a.v0.o;
import e.a.z;

public class ce$a2
implements o {
    public final /* synthetic */ byte[] a;
    public final /* synthetic */ short b;
    public final /* synthetic */ ce c;

    public ce$a2(ce ce2, byte[] byArray, short s10) {
        this.c = ce2;
        this.a = byArray;
        this.b = s10;
    }

    public e0 a(Boolean object) {
        object = d.v.y.d.a.h(this.a);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WriteFw in page = ");
        short s10 = this.b;
        stringBuilder.append(s10);
        Object object2 = ", pageData toString = ";
        stringBuilder.append((String)object2);
        stringBuilder.append((String)object);
        q.i(stringBuilder.toString());
        object = ce.s(this.c);
        if (object == null) {
            return z.l2();
        }
        object = ce.s(this.c);
        short s11 = this.b;
        object2 = this.a;
        return ((Stabilizer)object).Y7(s11, (byte[])object2);
    }
}

