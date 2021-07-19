/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Message
 */
package com.mob.commons.logcollector;

import android.os.Message;
import com.mob.commons.LockAction;
import com.mob.commons.b;
import com.mob.commons.logcollector.c;
import com.mob.commons.logcollector.e;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.util.HashMap;

public class c$2
implements LockAction {
    public final /* synthetic */ String a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Message d;
    public final /* synthetic */ c e;

    public c$2(c c10, String string2, int n10, String string3, Message message) {
        this.e = c10;
        this.a = string2;
        this.b = n10;
        this.c = string3;
        this.d = message;
    }

    /*
     * WARNING - void declaration
     */
    public boolean run(FileLocker fileLocker) {
        block9: {
            long l10 = com.mob.commons.b.a();
            Object object = this.a;
            int n10 = this.b;
            Object object2 = this.c;
            try {
                com.mob.commons.logcollector.e.a(l10, (String)object, n10, (String)object2);
            }
            catch (Throwable throwable) {
                void var9_12;
                Object object3 = com.mob.commons.logcollector.c.a(this.e);
                object = this.c;
                boolean n11 = ((HashMap)object3).containsKey(object);
                if (n11) {
                    object3 = com.mob.commons.logcollector.c.a(this.e);
                    object = this.c;
                    object3 = (Integer)((HashMap)object3).get(object);
                    int n12 = (Integer)object3;
                } else {
                    boolean bl2 = false;
                    object3 = null;
                }
                void var9_13 = var9_12 + true;
                object = com.mob.commons.logcollector.c.a(this.e);
                String string2 = this.c;
                object2 = (int)var9_13;
                ((HashMap)object).put(string2, object2);
                int n13 = 3;
                if (var9_13 < n13) {
                    c c10 = this.e;
                    object3 = this.d;
                    com.mob.commons.logcollector.c.a(c10, (Message)object3);
                    break block9;
                }
                object3 = com.mob.commons.logcollector.c.a(this.e);
                object = this.c;
                ((HashMap)object3).remove(object);
                object3 = MobLog.getInstance();
                ((NLog)object3).w(throwable);
            }
        }
        return false;
    }
}

