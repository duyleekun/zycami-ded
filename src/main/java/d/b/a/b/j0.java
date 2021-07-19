/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import com.android.billingclient.api.SkuDetails$a;
import d.b.a.b.e;
import d.b.a.b.m0;
import d.b.a.b.p;
import java.util.List;
import java.util.concurrent.Callable;

public final class j0
implements Callable {
    private final /* synthetic */ String a;
    private final /* synthetic */ List b;
    private final /* synthetic */ String c;
    public final /* synthetic */ p d;
    private final /* synthetic */ e e;

    public j0(e e10, String string2, List list, String string3, p p10) {
        this.e = e10;
        this.a = string2;
        this.b = list;
        this.c = string3;
        this.d = p10;
    }

    public final /* synthetic */ Object call() {
        Object object = this.e;
        Object object2 = this.a;
        Object object3 = this.b;
        String string2 = this.c;
        object = ((e)object).u((String)object2, (List)object3, string2);
        object2 = this.e;
        object3 = new m0(this, (SkuDetails$a)object);
        d.b.a.b.e.B((e)object2, (Runnable)object3);
        return null;
    }
}

