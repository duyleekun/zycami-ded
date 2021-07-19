/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.clientreport.manager.a;
import com.xiaomi.push.ai$a;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bh
extends ai$a {
    private Context a;

    public bh(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).a().isPerfUploadSwitchOpen();
    }

    public int a() {
        return 100887;
    }

    public void run() {
        block10: {
            boolean bl2 = this.a();
            if (!bl2) break block10;
            Object object = this.a;
            object = com.xiaomi.clientreport.manager.a.a((Context)object);
            ((a)object).c();
            object = new StringBuilder();
            Object object2 = this.a;
            object2 = object2.getPackageName();
            ((StringBuilder)object).append((String)object2);
            object2 = "perf  begin upload";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            try {
                b.c((String)object);
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
    }
}

