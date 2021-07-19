/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.d;
import d.v.e0.oe.q;
import e.a.v0.r;
import java.io.Serializable;

public class ce$f1
implements r {
    public final /* synthetic */ int[] a;
    public final /* synthetic */ d b;
    public final /* synthetic */ ce c;

    public ce$f1(ce ce2, int[] nArray, d d10) {
        this.c = ce2;
        this.a = nArray;
        this.b = d10;
    }

    public boolean a(Long object) {
        int n10;
        Object object2;
        int n11;
        long l10;
        long l11 = (Long)object;
        long l12 = l11 - (l10 = (long)(n11 = (object2 = this.a)[n10 = 1]));
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object3 = object3 >= 0 ? (Object)n10 : (Object)0;
        Serializable serializable = new StringBuilder();
        object2 = "CHECK total written pages. has written = ";
        serializable.append((String)object2);
        serializable.append(object);
        serializable.append(" , total = ");
        int n12 = this.a[n10];
        serializable.append(n12);
        object = serializable.toString();
        q.i((String)object);
        if (object3 == false && (object = this.b) != null) {
            object2 = "\u5199\u5165\u9875\u957f\u5ea6\u4e0d\u591f,\u4e0a\u4f20\u5931\u8d25.";
            serializable = new ArithmeticException((String)object2);
            object.d((Throwable)serializable);
            q.c((String)object2);
        }
        return (boolean)object3;
    }
}

