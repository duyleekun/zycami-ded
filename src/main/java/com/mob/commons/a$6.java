/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 */
package com.mob.commons;

import android.os.Handler;
import com.mob.OperationCallback;
import com.mob.commons.a;
import com.mob.commons.a$6$1;
import com.mob.commons.a$6$2;
import com.mob.commons.i;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.UIHandler;

public final class a$6
implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ OperationCallback b;

    public a$6(boolean bl2, OperationCallback operationCallback) {
        this.a = bl2;
        this.b = operationCallback;
    }

    public void run() {
        block7: {
            boolean bl2 = this.a;
            com.mob.commons.a.a(0, bl2);
            bl2 = false;
            Object object = null;
            i.a(null);
            object = this.b;
            if (object == null) break block7;
            object = new a$6$1(this);
            try {
                UIHandler.sendEmptyMessage(0, (Handler.Callback)object);
            }
            catch (Throwable throwable) {
                Object object2 = MobLog.getInstance();
                Object[] objectArray = new Object[]{};
                String string2 = "Submit privacy grant result error";
                ((NLog)object2).e(throwable, (Object)string2, objectArray);
                boolean bl3 = this.a;
                i.a((Boolean)bl3);
                object2 = this.b;
                if (object2 == null) break block7;
                object2 = new a$6$2(this, throwable);
                UIHandler.sendEmptyMessage(0, (Handler.Callback)object2);
            }
        }
    }
}

