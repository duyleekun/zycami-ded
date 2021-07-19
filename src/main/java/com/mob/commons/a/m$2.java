/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.os.Message
 *  android.os.SystemClock
 */
package com.mob.commons.a;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.os.SystemClock;
import com.mob.commons.a.m;
import com.mob.tools.utils.ActivityTracker$Tracker;

public class m$2
implements ActivityTracker$Tracker {
    public final /* synthetic */ m a;

    public m$2(m m10) {
        this.a = m10;
    }

    public void onCreated(Activity activity, Bundle bundle) {
    }

    public void onDestroyed(Activity activity) {
        long l10;
        m m10 = this.a;
        long l11 = m.c(m10);
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            this.onStopped(activity);
        }
    }

    public void onPaused(Activity activity) {
    }

    public void onResumed(Activity object) {
        long l10;
        m m10 = this.a;
        long l11 = m.c(m10);
        long l12 = l11 - (l10 = 0L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            m10 = this.a;
            long l13 = SystemClock.elapsedRealtime();
            m.a(m10, l13);
            m10 = m.d(this.a);
            if (m10 != null) {
                m10 = m.d(this.a);
                int n10 = 1;
                m10.sendEmptyMessage(n10);
            }
        }
        m10 = this.a;
        object = object.toString();
        m.a(m10, (String)object);
    }

    public void onSaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onStarted(Activity activity) {
    }

    public void onStopped(Activity object) {
        Object object2;
        String string2 = m.e(this.a);
        if (string2 == null || (object2 = ((String)(object = object.toString())).equals(string2 = m.e(this.a).toString())) != 0) {
            object = m.d(this.a);
            long l10 = 0L;
            if (object != null) {
                int n10;
                object = this.a;
                long l11 = m.c((m)object);
                long l12 = l11 - l10;
                object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 > 0) {
                    l11 = SystemClock.elapsedRealtime();
                    object = this.a;
                    long l13 = m.c((m)object);
                    l11 -= l13;
                } else {
                    l11 = l10;
                }
                object = new Message();
                ((Message)object).what = n10 = 2;
                Long l14 = l11;
                ((Message)object).obj = l14;
                l14 = m.d(this.a);
                l14.sendMessage((Message)object);
            }
            m.a(this.a, l10);
            object = this.a;
            string2 = null;
            m.a((m)object, null);
        }
    }
}

