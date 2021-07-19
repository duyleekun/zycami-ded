/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.logcollector;

import com.mob.commons.LockAction;
import com.mob.commons.logcollector.c;
import com.mob.commons.logcollector.d;
import com.mob.commons.logcollector.e;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

public class c$3
implements LockAction {
    public final /* synthetic */ String[] a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ c d;

    public c$3(c c10, String[] stringArray, int n10, String string2) {
        this.d = c10;
        this.a = stringArray;
        this.b = n10;
        this.c = string2;
    }

    public boolean run(FileLocker fileLocker) {
        block20: {
            NLog nLog;
            int n10;
            Object object = this.a;
            try {
                object = e.a((String[])object);
                n10 = 0;
                nLog = null;
            }
            catch (Throwable throwable) {
                nLog = MobLog.getInstance();
                nLog.i(throwable);
            }
            while (true) {
                block21: {
                    int n11 = ((ArrayList)object).size();
                    if (n10 >= n11) break block20;
                    Object object2 = ((ArrayList)object).get(n10);
                    object2 = (d)object2;
                    Object object3 = this.d;
                    int n12 = this.b;
                    Object object4 = this.c;
                    object3 = com.mob.commons.logcollector.c.a((c)object3, n12, (String)object4);
                    Object object5 = "errmsg";
                    object4 = ((d)object2).a;
                    ((HashMap)object3).put(object5, object4);
                    object5 = this.d;
                    object4 = new Hashon();
                    object3 = ((Hashon)object4).fromHashMap((HashMap)object3);
                    object3 = com.mob.commons.logcollector.c.a((c)object5, (String)object3);
                    boolean bl2 = true;
                    boolean bl3 = com.mob.commons.logcollector.c.a((c)object5, (String)object3, bl2);
                    if (!bl3) break block21;
                    object2 = ((d)object2).b;
                    e.a(object2);
                }
                ++n10;
            }
        }
        return false;
    }
}

