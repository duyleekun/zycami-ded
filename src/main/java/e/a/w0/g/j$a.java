/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.w0.g.j;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public final class j$a
implements Runnable {
    public void run() {
        boolean bl2;
        Object object = j.f.keySet();
        Object object2 = new ArrayList(object);
        object2 = ((ArrayList)object2).iterator();
        while (bl2 = object2.hasNext()) {
            object = (ScheduledThreadPoolExecutor)object2.next();
            boolean bl3 = ((ThreadPoolExecutor)object).isShutdown();
            if (bl3) {
                Map map = j.f;
                map.remove(object);
                continue;
            }
            ((ThreadPoolExecutor)object).purge();
        }
    }
}

