/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k.y;

import d.c.a.o.k.y.d$c;
import java.io.File;

public class d$b
implements d$c {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    public d$b(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    public File a() {
        String string2 = this.a;
        String string3 = this.b;
        File file = new File(string2, string3);
        return file;
    }
}

