/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.common.api.internal;

import android.content.Context;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api$Client;
import com.google.android.gms.common.api.internal.zaak;
import com.google.android.gms.common.api.internal.zaam;
import com.google.android.gms.common.api.internal.zaao;
import com.google.android.gms.common.api.internal.zaap;
import com.google.android.gms.common.api.internal.zaau;
import com.google.android.gms.common.api.internal.zabd;
import com.google.android.gms.common.api.internal.zabe;
import com.google.android.gms.common.api.internal.zabf;
import com.google.android.gms.common.internal.BaseGmsClient$ConnectionProgressReportCallbacks;
import com.google.android.gms.common.internal.GoogleApiAvailabilityCache;
import java.util.ArrayList;
import java.util.Map;

public final class zaan
extends zaau {
    public final /* synthetic */ zaak zagj;
    private final Map zagl;

    public zaan(zaak zaak2, Map map) {
        this.zagj = zaak2;
        super(zaak2, null);
        this.zagl = map;
    }

    public final void zaan() {
        int n10;
        int n11;
        Object object;
        int n12;
        Object object2;
        int n13;
        Object object3 = zaak.zab(this.zagj);
        Object object4 = new GoogleApiAvailabilityCache((GoogleApiAvailabilityLight)object3);
        object3 = new ArrayList();
        Object object5 = new ArrayList();
        Object object6 = this.zagl.keySet().iterator();
        while ((n13 = object6.hasNext()) != 0) {
            object2 = (Api$Client)object6.next();
            n12 = object2.requiresGooglePlayServices();
            if (n12 != 0 && (n12 = (int)(zaam.zaa((zaam)(object = (zaam)this.zagl.get(object2))) ? 1 : 0)) == 0) {
                object3.add(object2);
                continue;
            }
            object5.add(object2);
        }
        int n14 = -1;
        n13 = object3.isEmpty();
        object = null;
        if (n13 != 0) {
            n11 = ((ArrayList)object5).size();
            for (n12 = 0; n12 < n11; ++n12) {
                object6 = ((ArrayList)object5).get(n12);
                object6 = (Api$Client)object6;
                object2 = zaak.zaa(this.zagj);
                n14 = ((GoogleApiAvailabilityCache)object4).getClientAvailability((Context)object2, (Api$Client)object6);
                if (n14 != 0) continue;
                break;
            }
        } else {
            n10 = ((ArrayList)object3).size();
            while (n12 < n10) {
                object6 = ((ArrayList)object3).get(n12);
                ++n12;
                object6 = (Api$Client)object6;
                object2 = zaak.zaa(this.zagj);
                n14 = ((GoogleApiAvailabilityCache)object4).getClientAvailability((Context)object2, (Api$Client)object6);
                if (n14 == 0) continue;
            }
        }
        if (n14 != 0) {
            object4 = new ConnectionResult(n14, null);
            object3 = zaak.zad(this.zagj);
            object6 = this.zagj;
            object5 = new zaao(this, (zabd)object6, (ConnectionResult)object4);
            ((zabe)object3).zaa((zabf)object5);
            return;
        }
        object3 = this.zagj;
        n11 = (int)(zaak.zae((zaak)object3) ? 1 : 0);
        if (n11 != 0 && (object3 = zaak.zaf(this.zagj)) != null) {
            object3 = zaak.zaf(this.zagj);
            object3.connect();
        }
        object3 = this.zagl.keySet().iterator();
        while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            object5 = (Api$Client)object3.next();
            object6 = (BaseGmsClient$ConnectionProgressReportCallbacks)this.zagl.get(object5);
            n13 = object5.requiresGooglePlayServices();
            if (n13 != 0 && (n13 = ((GoogleApiAvailabilityCache)object4).getClientAvailability((Context)(object2 = zaak.zaa(this.zagj)), (Api$Client)object5)) != 0) {
                object5 = zaak.zad(this.zagj);
                object = this.zagj;
                object2 = new zaap(this, (zabd)object, (BaseGmsClient$ConnectionProgressReportCallbacks)object6);
                ((zabe)object5).zaa((zabf)object2);
                continue;
            }
            object5.connect((BaseGmsClient$ConnectionProgressReportCallbacks)object6);
        }
    }
}

