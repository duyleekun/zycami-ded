/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.message.bl.other.OtherStatus;
import d.v.e0.ce;
import d.v.e0.ie.d;
import e.a.v0.o;

public final class sa
implements o {
    public final /* synthetic */ ce a;
    public final /* synthetic */ boolean[] b;
    public final /* synthetic */ d c;

    public /* synthetic */ sa(ce ce2, boolean[] blArray, d d10) {
        this.a = ce2;
        this.b = blArray;
        this.c = d10;
    }

    public final Object apply(Object object) {
        ce ce2 = this.a;
        boolean[] blArray = this.b;
        d d10 = this.c;
        object = (OtherStatus)((Object)object);
        return ce2.e4(blArray, d10, (OtherStatus)((Object)object));
    }
}

