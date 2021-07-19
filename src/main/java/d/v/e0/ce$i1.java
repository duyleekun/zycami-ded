/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.oe.q;
import e.a.v0.o;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class ce$i1
implements o {
    public final /* synthetic */ int a;
    public final /* synthetic */ byte[] b;
    public final /* synthetic */ int[] c;
    public final /* synthetic */ ce d;

    public ce$i1(ce ce2, int n10, byte[] byArray, int[] nArray) {
        this.d = ce2;
        this.a = n10;
        this.b = byArray;
        this.c = nArray;
    }

    public List a(Object object) {
        Object object2;
        int n10;
        int n11 = this.a;
        ArrayList<int[]> arrayList = new ArrayList<int[]>();
        ByteBuffer byteBuffer = ByteBuffer.wrap(this.b);
        while ((n10 = byteBuffer.remaining()) >= n11) {
            byte[] byArray = new byte[n11];
            byteBuffer.get(byArray);
            arrayList.add(byArray);
        }
        n11 = byteBuffer.remaining();
        if (n11 > 0) {
            n11 = byteBuffer.remaining();
            object2 = new byte[n11];
            byteBuffer.get((byte[])object2);
            arrayList.add((int[])object2);
        }
        object2 = this.c;
        object2[1] = n10 = arrayList.size();
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("[Start Loop write list . ] bytes list size = ");
        int n12 = arrayList.size();
        ((StringBuilder)object2).append(n12);
        q.i(((StringBuilder)object2).toString());
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Current link support async transfer = ");
        ((StringBuilder)object2).append(object);
        q.i(((StringBuilder)object2).toString());
        return arrayList;
    }
}

