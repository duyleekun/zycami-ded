/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push.service;

import android.content.Context;
import com.xiaomi.push.az;
import com.xiaomi.push.cy;
import com.xiaomi.push.cz;
import com.xiaomi.push.cz$b;
import com.xiaomi.push.fh;
import com.xiaomi.push.he;
import com.xiaomi.push.hg;
import com.xiaomi.push.service.be;
import java.io.IOException;
import java.util.ArrayList;

public class au$b
extends cz {
    public au$b(Context context, cy cy2, cz$b cz$b, String string2) {
        super(context, cy2, cz$b, string2);
    }

    public String a(ArrayList arrayList, String string2, String string3, boolean bl2) {
        block5: {
            he he2;
            try {
                he2 = he.a();
            }
            catch (IOException iOException) {
                int n10 = az.b(cz.a);
                int n11 = fh.r.a();
                hg.a(0, n11, 1, null, n10);
                throw iOException;
            }
            boolean bl3 = he2.a();
            if (!bl3) break block5;
            string3 = be.a();
        }
        return super.a(arrayList, string2, string3, bl2);
    }
}

