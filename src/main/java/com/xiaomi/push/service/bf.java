/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.xiaomi.push.service;

import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.al$b;
import com.xiaomi.push.dd;
import com.xiaomi.push.ej$a;
import com.xiaomi.push.service.be;
import com.xiaomi.push.service.be$a;
import com.xiaomi.push.t;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class bf
extends al$b {
    public final /* synthetic */ be a;
    public boolean a = false;

    public bf(be be2) {
        this.a = be2;
    }

    public void b() {
        block9: {
            Object object = t.a();
            Object object2 = "http://resolver.msg.xiaomi.net/psc/?t=a";
            String string2 = null;
            object = dd.a(object, (String)object2, null);
            int n10 = 10;
            object = Base64.decode((String)object, (int)n10);
            object = ej$a.a((byte[])object);
            if (object == null) break block9;
            object2 = this.a;
            be.a((be)object2, (ej$a)object);
            boolean bl2 = true;
            this.a = bl2;
            object = this.a;
            try {
                be.a((be)object);
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                string2 = "fetch config failure: ";
                ((StringBuilder)object2).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                b.a(string3);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c() {
        be be2 = this.a;
        be$a[] be$aArray = null;
        be.a(be2, null);
        int n10 = this.a;
        if (n10 != 0) {
            int n11;
            be$a[] be$aArray2;
            be2 = this.a;
            synchronized (be2) {
                be$aArray = this.a;
                be$aArray = be.a((be)be$aArray);
                be$aArray2 = this.a;
                be$aArray2 = be.a((be)be$aArray2);
                n11 = be$aArray2.size();
                be$aArray2 = new be$a[n11];
                be$aArray = be$aArray.toArray(be$aArray2);
            }
            n10 = be$aArray.length;
            be$aArray2 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                be$a be$a = be$aArray[n11];
                ej$a ej$a = be.a(this.a);
                be$a.a(ej$a);
            }
        }
    }
}

