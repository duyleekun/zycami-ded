/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Message
 */
package com.huawei.hms.support.api.push.service;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import com.huawei.hms.push.c;
import com.huawei.hms.support.api.push.service.HmsMsgService;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper$PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;
import java.util.Objects;

public class HmsMsgService$a
extends Handler {
    public Context a;

    public HmsMsgService$a(Context context) {
        this.a = context;
    }

    public void handleMessage(Message message) {
        Object object = message.getData();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            Object object2;
            Object object3 = this.a.getApplicationContext().getPackageManager();
            n11 = message.sendingUid;
            n10 = (int)(Objects.equals(object3 = object3.getNameForUid(n11), object2 = HMSPackageManager.getInstance(this.a).getHMSPackageName()) ? 1 : 0);
            if (n10 != 0 && object != null) {
                object3 = HMSPackageManager.getInstance(this.a).getHMSPackageStates();
                object2 = PackageManagerHelper$PackageStates.ENABLED;
                String string2 = "HmsMsgService";
                if (object3 != object2) {
                    object = "service not start by hms";
                    HMSLog.i(string2, (String)object);
                } else {
                    HMSLog.i(string2, "chose push type");
                    object3 = "push_action";
                    object2 = c.b(object, (String)object3);
                    String string3 = "com.huawei.push.msg.NOTIFY_MSG";
                    n11 = (int)(Objects.equals(object2, string3) ? 1 : 0);
                    if (n11 != 0) {
                        object3 = ResourceLoaderUtil.getmContext();
                        if (object3 == null) {
                            object3 = this.a.getApplicationContext();
                            ResourceLoaderUtil.setmContext((Context)object3);
                        }
                        HMSLog.i(string2, "invokeSelfShow");
                        object3 = this.a;
                        HmsMsgService.a((Context)object3, object);
                    } else {
                        n10 = (int)(Objects.equals(object3 = c.b(object, (String)object3), object2 = "com.huawei.push.msg.PASSBY_MSG") ? 1 : 0);
                        if (n10 != 0) {
                            HMSLog.i(string2, "sendBroadcastToHms");
                            object3 = this.a;
                            HmsMsgService.b((Context)object3, object);
                        }
                    }
                }
            }
            super.handleMessage(message);
        }
    }
}

