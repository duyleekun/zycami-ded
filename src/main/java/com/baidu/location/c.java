/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.baidu.location;

import android.content.Context;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b.d;

public class c
extends Thread {
    public final /* synthetic */ LocationClient a;

    public c(LocationClient locationClient) {
        this.a = locationClient;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            Object object = this.a;
            object = LocationClient.h((LocationClient)object);
            if (object == null) {
                object = this.a;
                LocationClient locationClient = this.a;
                locationClient = LocationClient.i(locationClient);
                Object object2 = this.a;
                object2 = LocationClient.j((LocationClient)object2);
                LocationClient locationClient2 = this.a;
                d d10 = new d((Context)locationClient, (LocationClientOption)object2, locationClient2);
                LocationClient.a((LocationClient)object, d10);
            }
            object = this.a;
            if ((object = LocationClient.h((LocationClient)object)) == null) return;
            object = this.a;
            object = LocationClient.h((LocationClient)object);
            ((d)object).a();
            object = this.a;
            object = LocationClient.h((LocationClient)object);
            ((d)object).c();
            return;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

