/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.j1.a;

import android.content.Context;
import com.zhiyun.cama.data.database.model.Feedback;
import d.v.a.f.b.a;
import d.v.c.j1.a.o0;
import e.a.v0.g;

public final class d0
implements g {
    public final /* synthetic */ o0 a;
    public final /* synthetic */ Feedback b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Context f;
    public final /* synthetic */ a g;

    public /* synthetic */ d0(o0 o02, Feedback feedback, String string2, String string3, String string4, Context context, a a10) {
        this.a = o02;
        this.b = feedback;
        this.c = string2;
        this.d = string3;
        this.e = string4;
        this.f = context;
        this.g = a10;
    }

    public final void accept(Object object) {
        o0 o02 = this.a;
        Feedback feedback = this.b;
        String string2 = this.c;
        String string3 = this.d;
        String string4 = this.e;
        Context context = this.f;
        a a10 = this.g;
        Object object2 = object;
        object2 = (String)object;
        o02.t(feedback, string2, string3, string4, context, a10, (String)object2);
    }
}

