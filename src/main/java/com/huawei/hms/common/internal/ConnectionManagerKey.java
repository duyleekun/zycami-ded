/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.common.internal;

import android.content.Context;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api$ApiOptions;
import com.huawei.hms.common.internal.Objects;
import java.lang.ref.WeakReference;

public class ConnectionManagerKey {
    private final Api mApi;
    private final WeakReference mContextRef;
    private final int mHashKey;
    private final boolean mHaveOption;
    private final Api$ApiOptions mOption;
    private final String subAppId;

    private ConnectionManagerKey(Context objectArray, Api api, Api$ApiOptions api$ApiOptions, String string2) {
        int n10;
        WeakReference<Object> weakReference;
        this.mHaveOption = false;
        this.mContextRef = weakReference = new WeakReference<Object>((Context)objectArray);
        this.mApi = api;
        this.mOption = api$ApiOptions;
        objectArray = new Object[]{weakReference = weakReference.get(), api, api$ApiOptions};
        this.mHashKey = n10 = Objects.hashCode(objectArray);
        this.subAppId = string2;
    }

    private ConnectionManagerKey(Api api, String string2) {
        int n10;
        this.mHaveOption = true;
        this.mApi = api;
        this.mOption = null;
        this.mHashKey = n10 = System.identityHashCode(this);
        this.subAppId = string2;
        this.mContextRef = null;
    }

    public static ConnectionManagerKey createConnectionManagerKey(Context context, Api api, Api$ApiOptions api$ApiOptions, String string2) {
        ConnectionManagerKey connectionManagerKey = new ConnectionManagerKey(context, api, api$ApiOptions, string2);
        return connectionManagerKey;
    }

    public static ConnectionManagerKey createConnectionManagerKey(Api api, String string2) {
        ConnectionManagerKey connectionManagerKey = new ConnectionManagerKey(api, string2);
        return connectionManagerKey;
    }

    public final boolean equals(Object object) {
        Object object2;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof ConnectionManagerKey;
        if (!bl3) {
            return false;
        }
        object = (ConnectionManagerKey)object;
        Object object3 = this.mContextRef;
        if (object3 != null && (object2 = ((ConnectionManagerKey)object).mContextRef) != null) {
            boolean bl4;
            bl3 = this.mHaveOption;
            boolean bl5 = ((ConnectionManagerKey)object).mHaveOption;
            if (!(bl3 == bl5 && (bl3 = Objects.equal(object3 = this.mApi, object2 = ((ConnectionManagerKey)object).mApi)) && (bl3 = Objects.equal(object3 = this.mOption, object2 = ((ConnectionManagerKey)object).mOption)) && (bl3 = Objects.equal(object3 = this.subAppId, object2 = ((ConnectionManagerKey)object).subAppId)) && (bl4 = Objects.equal(object3 = this.mContextRef.get(), object = ((ConnectionManagerKey)object).mContextRef.get())))) {
                bl2 = false;
            }
            return bl2;
        }
        if (object3 == null && (object3 = ((ConnectionManagerKey)object).mContextRef) == null) {
            boolean bl6;
            bl3 = this.mHaveOption;
            boolean bl7 = ((ConnectionManagerKey)object).mHaveOption;
            if (!(bl3 == bl7 && (bl3 = Objects.equal(object3 = this.mApi, object2 = ((ConnectionManagerKey)object).mApi)) && (bl3 = Objects.equal(object3 = this.mOption, object2 = ((ConnectionManagerKey)object).mOption)) && (bl6 = Objects.equal(object3 = this.subAppId, object = ((ConnectionManagerKey)object).subAppId)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public final int hashCode() {
        return this.mHashKey;
    }
}

