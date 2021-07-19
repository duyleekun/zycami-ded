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
public class bg
extends ai$a {
    private Context a;

    public bg(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).a().isEventUploadSwitchOpen();
    }

    public int a() {
        return 100886;
    }

    public void run() {
        block10: {
            boolean bl2 = this.a();
            if (!bl2) break block10;
            Object object = new StringBuilder();
            Object object2 = this.a;
            object2 = object2.getPackageName();
            ((StringBuilder)object).append((String)object2);
            object2 = " begin upload event";
            ((StringBuilder)object).append((String)object2);
            object = ((StringBuilder)object).toString();
            b.c((String)object);
            object = this.a;
            object = com.xiaomi.clientreport.manager.a.a((Context)object);
            try {
                ((a)object).b();
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
    }
}

