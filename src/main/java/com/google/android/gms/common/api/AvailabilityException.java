/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.zai;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;

public class AvailabilityException
extends Exception {
    private final ArrayMap zaay;

    public AvailabilityException(ArrayMap arrayMap) {
        this.zaay = arrayMap;
    }

    public ConnectionResult getConnectionResult(GoogleApi object) {
        boolean bl2;
        Object object2 = this.zaay.get(object = ((GoogleApi)object).zak());
        if (object2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        Preconditions.checkArgument(bl2, "The given API was not part of the availability request.");
        return (ConnectionResult)this.zaay.get(object);
    }

    public String getMessage() {
        String string2;
        boolean bl2;
        Object object = new ArrayList();
        Object object2 = this.zaay.keySet().iterator();
        boolean bl3 = true;
        while (bl2 = object2.hasNext()) {
            Object object3 = (zai)object2.next();
            Object object4 = (ConnectionResult)this.zaay.get(object3);
            int n10 = ((ConnectionResult)object4).isSuccess();
            if (n10 != 0) {
                bl3 = false;
                string2 = null;
            }
            object3 = ((zai)object3).zan();
            object4 = String.valueOf(object4);
            String string3 = String.valueOf(object3);
            n10 = string3.length() + 2;
            int n11 = String.valueOf(object4).length();
            StringBuilder stringBuilder = new StringBuilder(n10 += n11);
            stringBuilder.append((String)object3);
            stringBuilder.append(": ");
            stringBuilder.append((String)object4);
            object3 = stringBuilder.toString();
            object.add(object3);
        }
        object2 = new StringBuilder();
        if (bl3) {
            string2 = "None of the queried APIs are available. ";
            ((StringBuilder)object2).append(string2);
        } else {
            string2 = "Some of the queried APIs are unavailable. ";
            ((StringBuilder)object2).append(string2);
        }
        object = TextUtils.join((CharSequence)"; ", object);
        ((StringBuilder)object2).append((String)object);
        return ((StringBuilder)object2).toString();
    }

    public final ArrayMap zaj() {
        return this.zaay;
    }
}

