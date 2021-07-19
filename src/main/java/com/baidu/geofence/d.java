/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.baidu.geofence;

import android.text.TextUtils;
import com.baidu.geofence.GeoFence;
import com.baidu.geofence.GeoFenceClient;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.a.b$a;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import java.util.ArrayList;
import java.util.List;

public class d
implements b$a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ GeoFenceClient c;

    public d(GeoFenceClient geoFenceClient, String string2, String string3) {
        this.c = geoFenceClient;
        this.a = string2;
        this.b = string3;
    }

    public void a(int n10) {
        if (n10 != 0) {
            GeoFenceListener geoFenceListener = GeoFenceClient.a(this.c);
            if (geoFenceListener != null) {
                geoFenceListener = GeoFenceClient.a(this.c);
                boolean bl2 = false;
                Object var4_8 = null;
                int n11 = 13;
                String string2 = this.a;
                geoFenceListener.onGeoFenceCreateFinished(null, n11, string2);
            }
        } else {
            Object object = new GeoFence();
            ((GeoFence)object).setFenceType(23);
            Object object2 = this.b;
            ((GeoFence)object).setRegion((String)object2);
            object2 = this.b;
            ((GeoFence)object).setKeyWord((String)object2);
            object2 = this.a;
            ((GeoFence)object).setCustomId((String)object2);
            object2 = GeoFenceClient.c(this.c);
            ((GeoFence)object).setActivatesAction((String)object2);
            int bl3 = GeoFenceClient.d(this.c);
            object2 = String.valueOf(bl3);
            ((GeoFence)object).setFenceId((String)object2);
            GeoFenceClient.a(this.c, (GeoFence)object);
            GeoFenceClient.b(this.c).add(object);
            object2 = new ArrayList();
            object2.add(object);
            object = GeoFenceClient.a(this.c);
            if (object != null) {
                object = GeoFenceClient.a(this.c);
                int n12 = 7;
                String string3 = this.a;
                object.onGeoFenceCreateFinished((List)object2, n12, string3);
            }
            if ((n10 = (int)(TextUtils.equals((CharSequence)(object = GeoFenceClient.f(this.c).getAddrType()), (CharSequence)(object2 = "all")) ? 1 : 0)) == 0) {
                object = GeoFenceClient.f(this.c);
                boolean bl2 = true;
                ((LocationClientOption)object).setIsNeedAddress(bl2);
                object = GeoFenceClient.g(this.c);
                object2 = GeoFenceClient.f(this.c);
                ((LocationClient)object).setLocOption((LocationClientOption)object2);
            }
            object = this.c;
            boolean bl4 = false;
            object2 = null;
            GeoFenceClient.a((GeoFenceClient)object, false);
            object = this.c;
            GeoFenceClient.e((GeoFenceClient)object);
        }
    }
}

