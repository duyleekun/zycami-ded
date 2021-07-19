/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.zhiyun.cama.cloud_engine;

import android.os.Parcel;
import android.os.Parcelable;
import com.zhiyun.cama.cloud_engine.CETemplateModel;

public final class CETemplateModel$a
implements Parcelable.Creator {
    public CETemplateModel a(Parcel parcel) {
        CETemplateModel cETemplateModel = new CETemplateModel(parcel);
        return cETemplateModel;
    }

    public CETemplateModel[] b(int n10) {
        return new CETemplateModel[n10];
    }
}

