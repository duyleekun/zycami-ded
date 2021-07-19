/*
 * Decompiled with CFR 0.151.
 */
package d.m.a.g;

import com.meishe.cafconvertor.webpcoder.WebpImageView$b;
import d.m.a.g.b;
import d.m.a.g.e;
import java.io.InputStream;

public class e$a
implements Runnable {
    public final /* synthetic */ InputStream a;
    public final /* synthetic */ e b;

    public e$a(e e10, InputStream inputStream) {
        this.b = e10;
        this.a = inputStream;
    }

    public void run() {
        Object object = d.m.a.g.b.a;
        if (object != null) {
            Object object2 = this.b;
            object.e((WebpImageView$b)object2);
            object = this.b;
            object2 = this.a;
            ((e)object).c((InputStream)object2);
        }
    }
}

