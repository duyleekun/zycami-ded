/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 */
package com.mob.tools.utils;

import android.os.Handler;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ApplicationTracker$1;
import com.mob.tools.utils.ApplicationTracker$Tracker;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import java.util.HashSet;

public class ApplicationTracker {
    private static HashSet trackers;

    static {
        Object object = new HashSet();
        trackers = object;
        object = DeviceHelper.currentActivityThread();
        Object object2 = "mH";
        object2 = ReflectHelper.getInstanceField(object, (String)object2);
        CharSequence charSequence = new StringBuilder();
        Object object3 = "mC";
        charSequence.append((String)object3);
        object3 = "al";
        charSequence.append((String)object3);
        object3 = "lb";
        charSequence.append((String)object3);
        object3 = "ac";
        charSequence.append((String)object3);
        object3 = "k";
        charSequence.append((String)object3);
        charSequence = charSequence.toString();
        object3 = ReflectHelper.getInstanceField(object2, (String)charSequence);
        object3 = (Handler.Callback)object3;
        ApplicationTracker$1 applicationTracker$1 = new ApplicationTracker$1(object, (Handler.Callback)object3);
        try {
            ReflectHelper.setInstanceField(object2, (String)charSequence, applicationTracker$1);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
    }

    public static /* synthetic */ HashSet access$000() {
        return trackers;
    }

    public static void addTracker(ApplicationTracker$Tracker applicationTracker$Tracker) {
        trackers.add(applicationTracker$Tracker);
    }

    public static void removeTracker(ApplicationTracker$Tracker applicationTracker$Tracker) {
        trackers.remove(applicationTracker$Tracker);
    }
}

