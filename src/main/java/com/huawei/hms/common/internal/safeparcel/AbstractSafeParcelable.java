/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.internal.safeparcel;

import com.huawei.hms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.support.api.client.Result;

public abstract class AbstractSafeParcelable
extends Result
implements SafeParcelable {
    public final int describeContents() {
        return 0;
    }
}

