/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.opendevice.o;
import java.util.concurrent.Callable;

public class j
implements Callable {
    public Context a;

    public j(Context context) {
        this.a = context;
    }

    public AAIDResult call() {
        Object object = this.a;
        if (object != null) {
            object = o.c(object);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId((String)object);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}

