/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.location.Location
 *  android.location.LocationListener
 *  android.os.Bundle
 */
package com.mob.tools.utils;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.LHelper;

public class LHelper$2
implements LocationListener {
    public final /* synthetic */ LHelper this$0;

    public LHelper$2(LHelper lHelper) {
        this.this$0 = lHelper;
    }

    public void onLocationChanged(Location object) {
        Object object2 = this.this$0;
        object2 = LHelper.access$400((LHelper)object2);
        object2.removeUpdates((LocationListener)this);
        object2 = this.this$0;
        LHelper.access$502((LHelper)object2, object);
        object = this.this$0;
        long l10 = System.currentTimeMillis();
        try {
            LHelper.access$602((LHelper)object, l10);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).d(throwable);
        }
        return;
        {
            finally {
                LHelper.access$300(this.this$0);
            }
        }
    }

    public void onProviderDisabled(String string2) {
    }

    public void onProviderEnabled(String string2) {
    }

    public void onStatusChanged(String string2, int n10, Bundle bundle) {
    }
}

