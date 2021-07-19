/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location;

import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.location.b;
import java.util.ArrayList;

public class LocationClient$b
implements Runnable {
    public final /* synthetic */ LocationClient a;

    private LocationClient$b(LocationClient locationClient) {
        this.a = locationClient;
    }

    public /* synthetic */ LocationClient$b(LocationClient locationClient, b b10) {
        this(locationClient);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = LocationClient.k(this.a);
        synchronized (object) {
            block7: {
                block10: {
                    int n10;
                    Object object2;
                    int n11;
                    Object object3;
                    block9: {
                        block8: {
                            object3 = this.a;
                            n11 = 0;
                            object2 = null;
                            LocationClient.b((LocationClient)object3, false);
                            object3 = this.a;
                            object3 = LocationClient.a((LocationClient)object3);
                            if (object3 == null) break block7;
                            object3 = this.a;
                            if ((object3 = LocationClient.d((LocationClient)object3)) == null) break block7;
                            object3 = this.a;
                            object3 = LocationClient.l((LocationClient)object3);
                            n11 = 1;
                            if (object3 == null) break block8;
                            object3 = this.a;
                            n10 = ((ArrayList)(object3 = LocationClient.l((LocationClient)object3))).size();
                            if (n10 >= n11) break block9;
                        }
                        object3 = this.a;
                        if ((object3 = LocationClient.m((LocationClient)object3)) == null) break block10;
                        object3 = this.a;
                        n10 = ((ArrayList)(object3 = LocationClient.m((LocationClient)object3))).size();
                        if (n10 < n11) break block10;
                    }
                    if ((n10 = (int)(LocationClient.n((LocationClient)(object3 = this.a)) ? 1 : 0)) == 0) {
                        object3 = this.a;
                        object3 = LocationClient.c((LocationClient)object3);
                        n11 = 4;
                        object3 = object3.obtainMessage(n11);
                        object3.sendToTarget();
                        return;
                    }
                    object3 = this.a;
                    if ((object3 = LocationClient.o((LocationClient)object3)) == null) {
                        object3 = this.a;
                        object2 = new LocationClient$b((LocationClient)object3);
                        LocationClient.a((LocationClient)object3, (LocationClient$b)object2);
                    }
                    object3 = this.a;
                    object3 = LocationClient.c((LocationClient)object3);
                    object2 = this.a;
                    object2 = LocationClient.o((LocationClient)object2);
                    Object object4 = this.a;
                    object4 = LocationClient.f((LocationClient)object4);
                    int n12 = ((LocationClientOption)object4).scanSpan;
                    long l10 = n12;
                    object3.postDelayed((Runnable)object2, l10);
                    return;
                }
                return;
            }
            return;
        }
    }
}

