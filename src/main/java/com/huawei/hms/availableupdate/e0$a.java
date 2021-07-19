/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Message
 */
package com.huawei.hms.availableupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.availableupdate.e0;
import com.huawei.hms.ui.SafeBundle;

public class e0$a
extends Handler {
    public final /* synthetic */ e0 a;

    public e0$a(e0 e02) {
        this.a = e02;
    }

    public void handleMessage(Message object) {
        Bundle bundle = (Bundle)object.obj;
        SafeBundle safeBundle = new SafeBundle(bundle);
        int n10 = object.what;
        switch (n10) {
            default: {
                break;
            }
            case 103: {
                object = this.a;
                e0.c((e0)object, safeBundle);
                break;
            }
            case 102: {
                object = this.a;
                e0.b((e0)object, safeBundle);
                break;
            }
            case 101: {
                object = this.a;
                e0.a((e0)object, safeBundle);
            }
        }
    }
}

