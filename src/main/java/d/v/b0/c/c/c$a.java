/*
 * Decompiled with CFR 0.151.
 */
package d.v.b0.c.c;

import d.v.b0.c.c.c;
import d.v.b0.c.c.c$b;
import d.v.b0.c.c.d$c;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class c$a
implements d$c {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void a(String object, String object2) {
        Map map = c.a(this.a);
        object = (c$b)map.remove(object);
        if (object != null) {
            ((c$b)object).b = object2;
            object2 = this.a;
            object2 = c.b((c)object2);
            try {
                ((LinkedBlockingQueue)object2).put(object);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

