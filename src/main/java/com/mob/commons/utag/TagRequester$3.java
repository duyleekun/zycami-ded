/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.utag;

import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.i;
import com.mob.commons.j;
import com.mob.commons.utag.TagRequester;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import java.util.HashMap;

public final class TagRequester$3
extends Thread {
    public void run() {
        HashMap hashMap = new HashMap();
        Object object = "duid";
        int n10 = 0;
        Object object2 = null;
        object2 = DeviceAuthorizer.authorize(null);
        hashMap.put(object, object2);
        object = "mac";
        object2 = TagRequester.c();
        object2 = ((DeviceHelper)object2).getMacAddress();
        hashMap.put(object, object2);
        object = "imei";
        object2 = TagRequester.c();
        object2 = ((DeviceHelper)object2).getIMEI();
        hashMap.put(object, object2);
        object = "serialno";
        object2 = TagRequester.c();
        object2 = ((DeviceHelper)object2).getSerialno();
        hashMap.put(object, object2);
        object = "model";
        object2 = TagRequester.c();
        object2 = ((DeviceHelper)object2).getModel();
        hashMap.put(object, object2);
        object = "appkey";
        object2 = MobSDK.getAppkey();
        hashMap.put(object, object2);
        object = "apppkg";
        object2 = TagRequester.c();
        object2 = ((DeviceHelper)object2).getPackageName();
        hashMap.put(object, object2);
        object = "appver";
        object2 = TagRequester.c();
        object2 = ((DeviceHelper)object2).getAppVersionName();
        hashMap.put(object, object2);
        object = "plat";
        n10 = 1;
        object2 = n10;
        hashMap.put(object, object2);
        object = "http://api.utag.mob.com/conf";
        object = j.c((String)object);
        hashMap = TagRequester.a(hashMap, (String)object);
        try {
            i.a(hashMap);
        }
        catch (Throwable throwable) {
            object = MobLog.getInstance();
            ((NLog)object).w(throwable);
        }
        TagRequester.a(false);
    }
}

