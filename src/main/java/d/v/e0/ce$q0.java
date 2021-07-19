/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.f;
import d.v.e0.oe.q;
import e.a.v0.g;
import java.util.Arrays;

public class ce$q0
implements g {
    public final /* synthetic */ f a;
    public final /* synthetic */ ce b;

    public ce$q0(ce ce2, f f10) {
        this.b = ce2;
        this.a = f10;
    }

    public void a(int[] object) {
        this.a.m((int[])object);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("6: getPathPoint\uff1a ");
        String string2 = Arrays.toString(object);
        stringBuilder.append(string2);
        q.f(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("#Offline# ");
        object = Arrays.toString(object);
        stringBuilder.append((String)object);
        q.f(stringBuilder.toString());
    }
}

