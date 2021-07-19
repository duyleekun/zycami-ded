/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 */
package com.zhiyun.common.viewmodel;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.l;

public class DeviceViewModel$e
extends ContentObserver {
    public final /* synthetic */ Uri a;
    public final /* synthetic */ l b;
    public final /* synthetic */ DeviceViewModel c;

    public DeviceViewModel$e(DeviceViewModel deviceViewModel, Handler handler, Uri uri, l l10) {
        this.c = deviceViewModel;
        this.a = uri;
        this.b = l10;
        super(handler);
    }

    public void onChange(boolean bl2, Uri object) {
        Object object2 = this.a;
        bl2 = object.equals(object2);
        if (bl2) {
            object2 = this.b;
            boolean bl3 = this.c.i();
            object = bl3;
            object2.onNext(object);
        }
    }
}

