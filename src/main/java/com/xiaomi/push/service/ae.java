/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push.service;

import com.xiaomi.push.hg;
import com.xiaomi.push.service.ad;
import java.util.Iterator;
import java.util.List;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class ae
implements Runnable {
    public final /* synthetic */ List a;
    public final /* synthetic */ boolean a;

    public ae(List list, boolean bl2) {
        this.a = list;
        this.a = bl2;
    }

    public void run() {
        int n10;
        boolean bl2;
        String string2 = "www.baidu.com:80";
        int n11 = ad.a(string2);
        Iterator iterator2 = this.a.iterator();
        do {
            bl2 = iterator2.hasNext();
            n10 = 1;
            if (!bl2) break;
            String string3 = (String)iterator2.next();
            if (n11 == 0 && (n11 = (int)(ad.a(string3) ? 1 : 0)) == 0) {
                n11 = 0;
                string2 = null;
                continue;
            }
            n11 = n10;
        } while (n11 == 0 || (bl2 = this.a));
        if (n11 == 0) {
            n10 = 2;
        }
        hg.a(n10);
    }
}

