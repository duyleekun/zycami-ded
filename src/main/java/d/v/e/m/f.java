/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.e.m;

import android.content.Context;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import e.a.l;
import e.a.m;

public final class f
implements m {
    public final /* synthetic */ DeviceViewModel a;
    public final /* synthetic */ Context b;

    public /* synthetic */ f(DeviceViewModel deviceViewModel, Context context) {
        this.a = deviceViewModel;
        this.b = context;
    }

    public final void subscribe(l l10) {
        DeviceViewModel deviceViewModel = this.a;
        Context context = this.b;
        deviceViewModel.m(context, l10);
    }
}

