/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.eventrecoder;

import com.mob.commons.LockAction;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class EventRecorder$2
implements LockAction {
    public final /* synthetic */ String a;

    public EventRecorder$2(String string2) {
        this.a = string2;
    }

    public boolean run(FileLocker object) {
        object = EventRecorder.b();
        Object object2 = this.a;
        String string2 = "utf-8";
        object2 = ((String)object2).getBytes(string2);
        ((FileOutputStream)object).write((byte[])object2);
        object = EventRecorder.b();
        try {
            ((OutputStream)object).flush();
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
        return false;
    }
}

