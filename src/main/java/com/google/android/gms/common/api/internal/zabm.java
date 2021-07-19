/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.GoogleApiManager$zaa;
import com.google.android.gms.common.api.internal.zabn;
import com.google.android.gms.common.internal.BaseGmsClient$SignOutCallbacks;

public final class zabm
implements BaseGmsClient$SignOutCallbacks {
    public final /* synthetic */ GoogleApiManager$zaa zaiy;

    public zabm(GoogleApiManager$zaa googleApiManager$zaa) {
        this.zaiy = googleApiManager$zaa;
    }

    public final void onSignOutComplete() {
        Handler handler = GoogleApiManager.zaa(this.zaiy.zaim);
        zabn zabn2 = new zabn(this);
        handler.post((Runnable)zabn2);
    }
}

