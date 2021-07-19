/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.common.api.internal;

import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.GoogleApiManager$zac;
import java.util.Collections;
import java.util.Set;

public final class zabo
implements Runnable {
    private final /* synthetic */ ConnectionResult zaiz;
    private final /* synthetic */ GoogleApiManager$zac zajg;

    public zabo(GoogleApiManager$zac zac2, ConnectionResult connectionResult) {
        this.zajg = zac2;
        this.zaiz = connectionResult;
    }

    public final void run() {
        Object object = this.zaiz;
        boolean bl2 = ((ConnectionResult)object).isSuccess();
        if (bl2) {
            Object object2;
            object = this.zajg;
            boolean bl3 = true;
            GoogleApiManager$zac.zaa((GoogleApiManager$zac)object, bl3);
            object = GoogleApiManager$zac.zaa(this.zajg);
            bl2 = object.requiresSignIn();
            if (bl2) {
                GoogleApiManager$zac.zab(this.zajg);
                return;
            }
            try {
                object = this.zajg;
            }
            catch (SecurityException securityException) {
                Log.e((String)"GoogleApiManager", (String)"Failed to get service from broker. ", (Throwable)securityException);
                Object object3 = GoogleApiManager.zaj(this.zajg.zaim);
                object2 = GoogleApiManager$zac.zac(this.zajg);
                object3 = (GoogleApiManager$zaa)object3.get(object2);
                object2 = new ConnectionResult(10);
                ((GoogleApiManager$zaa)object3).onConnectionFailed((ConnectionResult)object2);
                return;
            }
            object = GoogleApiManager$zac.zaa((GoogleApiManager$zac)object);
            bl3 = false;
            object2 = null;
            Set set = Collections.emptySet();
            object.getRemoteService(null, set);
            return;
        }
        object = GoogleApiManager.zaj(this.zajg.zaim);
        Object object4 = GoogleApiManager$zac.zac(this.zajg);
        object = (GoogleApiManager$zaa)object.get(object4);
        object4 = this.zaiz;
        ((GoogleApiManager$zaa)object).onConnectionFailed((ConnectionResult)object4);
    }
}

