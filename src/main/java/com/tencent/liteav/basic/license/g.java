/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.basic.license;

import android.content.Context;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.license.f;

public class g
implements e {
    private Context a;

    public g(Context context) {
        this.a = context;
    }

    public boolean a() {
        boolean bl2;
        boolean bl3;
        Object object = this.a;
        if (object != null) {
            object = LicenceCheck.a();
            bl3 = false;
            Context context = this.a;
            ((LicenceCheck)object).a((f)null, context);
        }
        if ((bl2 = ((LicenceCheck)(object = LicenceCheck.a())).b()) >= (bl3 = 2 != 0)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }
}

