/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.e$a;
import com.tencent.liteav.network.a.a.a;
import com.tencent.liteav.network.a.b;
import com.tencent.liteav.network.a.e;
import java.util.HashMap;

public class e$1
implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.tencent.liteav.e b;

    public e$1(com.tencent.liteav.e e10, String string2) {
        this.b = e10;
        this.a = string2;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            void var3_10;
            Object object;
            boolean bl2;
            Object object2;
            block6: {
                object2 = com.tencent.liteav.network.a.a.a.c();
                String string2 = this.a;
                bl2 = true;
                object = new b(string2, bl2);
                Object var3_6 = null;
                object2 = object2.a((b)object, null);
                int n10 = ((e[])object2).length;
                Object var3_7 = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    boolean bl3;
                    Object object3 = object2[i10];
                    boolean bl4 = ((e)object3).a();
                    if (!bl4 || !(bl3 = com.tencent.liteav.e.c((String)(object3 = ((e)object3).a)))) {
                        continue;
                    }
                    break block6;
                }
                bl2 = false;
            }
            object2 = com.tencent.liteav.e.g();
            object = this.a;
            if (bl2) {
                e$a e$a = e$a.b;
            } else {
                e$a e$a = e$a.c;
            }
            ((HashMap)object2).put(object, var3_10);
            object2 = com.tencent.liteav.e.h();
            object = new StringBuilder();
            String string3 = this.a;
            ((StringBuilder)object).append(string3);
            String string4 = " isTencent ";
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(bl2);
            object = ((StringBuilder)object).toString();
            TXCLog.d((String)object2, (String)object);
            return;
        }
        catch (Exception exception) {
            String string5 = com.tencent.liteav.e.h();
            String string6 = "check dns failed.";
            TXCLog.e(string5, string6, exception);
        }
    }
}

