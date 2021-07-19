/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ReflectHelper$ReflectRunnable;
import com.mob.tools.utils.Strings;

public final class DeviceHelper$2
implements ReflectHelper$ReflectRunnable {
    public Object run(Void object) {
        int n10 = 31;
        try {
            object = Strings.getString(n10);
        }
        catch (Throwable throwable) {
            MobLog.getInstance().w(throwable);
            return null;
        }
        object = ReflectHelper.importClass((String)object);
        int n11 = 32;
        String string2 = Strings.getString(n11);
        Object[] objectArray = null;
        objectArray = new Object[]{};
        return ReflectHelper.invokeStaticMethod((String)object, string2, objectArray);
    }
}

