/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.quvideo.mobile.external.platform.api.device;

import android.util.Log;
import com.google.gson.Gson;
import com.quvideo.mobile.external.platform.api.device.OnDeviceListener;
import com.quvideo.mobile.external.platform.api.device.OooO0OO;
import com.quvideo.mobile.external.platform.api.device.model.DeviceResponse;
import e.a.y0.a;

public class OooO0OO$a
extends a {
    public final /* synthetic */ String b;
    public final /* synthetic */ OnDeviceListener c;
    public final /* synthetic */ OooO0OO d;

    public OooO0OO$a(OooO0OO oooO0OO, String string2, OnDeviceListener onDeviceListener) {
        this.d = oooO0OO;
        this.b = string2;
        this.c = onDeviceListener;
    }

    public void c(DeviceResponse deviceResponse) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("bind success: ");
        Object object2 = new Gson();
        object2 = ((Gson)object2).toJson(deviceResponse);
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = "QuVideoHttpCore";
        Log.d((String)object2, (String)object);
        boolean bl2 = deviceResponse.success;
        if (bl2) {
            Log.d((String)object2, (String)"bind success 1111: ");
            object = this.d;
            String string2 = deviceResponse.data.deviceId;
            String string3 = this.b;
            OooO0OO.OooO00o((OooO0OO)object, string2, string3);
            object = "bind success 2222: ";
            Log.d((String)object2, (String)object);
        }
        Log.d((String)object2, (String)"bind success 3333: ");
        object = this.c;
        boolean bl3 = deviceResponse.success;
        object.onLoaded(bl3);
    }

    public void onComplete() {
    }

    public void onError(Throwable object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("bind failed: ");
        object = ((Throwable)object).getMessage();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        Log.d((String)"QuVideoHttpCore", (String)object);
        this.c.onLoaded(false);
    }
}

