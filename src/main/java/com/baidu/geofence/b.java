/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.geofence;

import com.baidu.geofence.GeoFence;
import com.baidu.geofence.GeoFenceClient;
import com.baidu.geofence.GeoFenceListener;
import com.baidu.geofence.PoiItem;
import com.baidu.geofence.a.f$a;
import com.baidu.geofence.model.DPoint;
import java.util.ArrayList;

public class b
implements f$a {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ GeoFenceClient c;

    public b(GeoFenceClient geoFenceClient, String string2, String string3) {
        this.c = geoFenceClient;
        this.a = string2;
        this.b = string3;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(int n10, ArrayList arrayList) {
        int n11 = 13;
        String string2 = null;
        if (n10 != 0) {
            GeoFenceListener geoFenceListener = GeoFenceClient.a(this.c);
            if (geoFenceListener == null) return;
            geoFenceListener = GeoFenceClient.a(this.c);
            arrayList = this.a;
            geoFenceListener.onGeoFenceCreateFinished(null, n11, (String)((Object)arrayList));
            return;
        }
        if (arrayList == null) {
            return;
        }
        n10 = arrayList.size();
        if (n10 == 0) {
            return;
        }
        Object object = arrayList.iterator();
        arrayList = null;
        while (true) {
            double d10;
            double d11;
            int n12;
            boolean bl2 = object.hasNext();
            boolean bl3 = false;
            Object object2 = null;
            if (!bl2) break;
            Object object3 = (PoiItem)object.next();
            Object object4 = GeoFenceClient.b(this.c);
            float f10 = 200.0f;
            int n13 = 22;
            if (object4 != null && (n12 = ((ArrayList)(object4 = GeoFenceClient.b(this.c))).size()) != 0) {
                int n14;
                object4 = GeoFenceClient.b(this.c).iterator();
                while ((n14 = object4.hasNext()) != 0) {
                    double d12;
                    PoiItem poiItem;
                    double d13;
                    double d14;
                    double d15;
                    Object object5 = (GeoFence)object4.next();
                    int n15 = ((GeoFence)object5).getType();
                    if (n15 != n13 || (n15 = (int)((d15 = (d14 = ((PoiItem)object3).getLatitude()) - (d13 = (poiItem = ((GeoFence)object5).getPoiItem()).getLatitude())) == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1))) != 0 || (n14 = (d12 = (d14 = ((PoiItem)object3).getLongitude()) - (d13 = ((PoiItem)(object5 = ((GeoFence)object5).getPoiItem())).getLongitude())) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) != 0) continue;
                    object2 = GeoFenceClient.a(this.c);
                    if (object2 != null) {
                        object2 = GeoFenceClient.a(this.c);
                        n14 = 14;
                        String string3 = this.a;
                        object2.onGeoFenceCreateFinished(null, n14, string3);
                    }
                    bl3 = true;
                }
                if (bl3) continue;
                object2 = new GeoFence();
                ((GeoFence)object2).setFenceType(n13);
                ((GeoFence)object2).setPoiItem((PoiItem)object3);
                ((GeoFence)object2).setRadius(f10);
                object4 = this.b;
                ((GeoFence)object2).setKeyWord((String)object4);
                object4 = GeoFenceClient.c(this.c);
                ((GeoFence)object2).setActivatesAction((String)object4);
                object4 = this.a;
                ((GeoFence)object2).setCustomId((String)object4);
                n12 = GeoFenceClient.d(this.c);
                object4 = String.valueOf(n12);
                ((GeoFence)object2).setFenceId((String)object4);
                d11 = ((PoiItem)object3).getLatitude();
                d10 = ((PoiItem)object3).getLongitude();
                object4 = new DPoint(d11, d10);
                ((GeoFence)object2).setCenter((DPoint)object4);
                if (arrayList == null) {
                    arrayList = new ArrayList<Object>();
                }
            } else {
                object2 = new GeoFence();
                ((GeoFence)object2).setFenceType(n13);
                ((GeoFence)object2).setPoiItem((PoiItem)object3);
                ((GeoFence)object2).setRadius(f10);
                object4 = this.b;
                ((GeoFence)object2).setKeyWord((String)object4);
                object4 = GeoFenceClient.c(this.c);
                ((GeoFence)object2).setActivatesAction((String)object4);
                object4 = this.a;
                ((GeoFence)object2).setCustomId((String)object4);
                n12 = GeoFenceClient.d(this.c);
                object4 = String.valueOf(n12);
                ((GeoFence)object2).setFenceId((String)object4);
                d11 = ((PoiItem)object3).getLatitude();
                d10 = ((PoiItem)object3).getLongitude();
                object4 = new DPoint(d11, d10);
                ((GeoFence)object2).setCenter((DPoint)object4);
                if (arrayList == null) {
                    arrayList = new ArrayList<Object>();
                }
            }
            object3 = this.c;
            GeoFenceClient.a((GeoFenceClient)object3, (GeoFence)object2);
            arrayList.add(object2);
        }
        if (arrayList == null) {
            object = GeoFenceClient.a(this.c);
            if (object == null) return;
            object = GeoFenceClient.a(this.c);
            arrayList = this.a;
            object.onGeoFenceCreateFinished(null, n11, (String)((Object)arrayList));
            return;
        }
        n10 = (int)(arrayList.isEmpty() ? 1 : 0);
        if (n10 != 0) return;
        object = GeoFenceClient.b(this.c);
        if (object == null) return;
        GeoFenceClient.b(this.c).addAll(arrayList);
        object = GeoFenceClient.a(this.c);
        if (object != null) {
            object = GeoFenceClient.a(this.c);
            n11 = 7;
            string2 = this.a;
            object.onGeoFenceCreateFinished(arrayList, n11, string2);
        }
        GeoFenceClient.a(this.c, false);
        object = this.c;
        GeoFenceClient.e((GeoFenceClient)object);
    }
}

