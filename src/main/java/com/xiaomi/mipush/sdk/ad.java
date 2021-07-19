/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient$a$a;
import com.xiaomi.push.hq;
import java.util.ArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ad
implements Runnable {
    public final /* synthetic */ MiTinyDataClient$a$a a;
    public final /* synthetic */ hq a;

    public ad(MiTinyDataClient$a$a miTinyDataClient$a$a, hq hq2) {
        this.a = miTinyDataClient$a$a;
        this.a = hq2;
    }

    public void run() {
        ArrayList arrayList = this.a.a;
        hq hq2 = this.a;
        arrayList.add(hq2);
        MiTinyDataClient$a$a.a(this.a);
    }
}

