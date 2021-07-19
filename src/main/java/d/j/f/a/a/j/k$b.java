/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.webkit.SslErrorHandler
 */
package d.j.f.a.a.j;

import android.content.Context;
import android.webkit.SslErrorHandler;
import d.j.f.a.a.j.k;
import d.j.f.a.a.j.k$a;
import d.j.f.a.a.j.o.i;
import g.c0;
import g.e;
import g.f;
import java.io.IOException;

public final class k$b
implements f {
    public final /* synthetic */ k$a a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ SslErrorHandler d;

    public k$b(k$a k$a, Context context, String string2, SslErrorHandler sslErrorHandler) {
        this.a = k$a;
        this.b = context;
        this.c = string2;
        this.d = sslErrorHandler;
    }

    public void onFailure(e object, IOException object2) {
        object = k.a();
        CharSequence charSequence = new StringBuilder();
        String string2 = "onFailure , IO Exception : ";
        charSequence.append(string2);
        object2 = ((Throwable)object2).getMessage();
        charSequence.append((String)object2);
        object2 = charSequence.toString();
        i.d((String)object, (String)object2);
        object = this.a;
        if (object != null) {
            object2 = this.b;
            charSequence = this.c;
            object.b((Context)object2, (String)charSequence);
        } else {
            object = this.d;
            object.cancel();
        }
    }

    public void onResponse(e object, c0 object2) {
        object = k.a();
        object2 = "onResponse . proceed";
        i.d((String)object, (String)object2);
        object = this.a;
        if (object != null) {
            object2 = this.b;
            String string2 = this.c;
            object.a((Context)object2, string2);
        } else {
            object = this.d;
            object.proceed();
        }
    }
}

