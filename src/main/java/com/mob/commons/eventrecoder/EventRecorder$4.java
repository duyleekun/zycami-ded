/*
 * Decompiled with CFR 0.151.
 */
package com.mob.commons.eventrecoder;

import com.mob.MobSDK;
import com.mob.commons.LockAction;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.io.FileOutputStream;

public final class EventRecorder$4
implements LockAction {
    public boolean run(FileLocker object) {
        object = EventRecorder.b();
        ((FileOutputStream)object).close();
        object = EventRecorder.a();
        ((File)object).delete();
        Object object2 = MobSDK.getContext();
        object2 = object2.getFilesDir();
        String string2 = ".mrecord";
        object = new File((File)object2, string2);
        EventRecorder.a((File)object);
        object = EventRecorder.a();
        ((File)object).createNewFile();
        object2 = EventRecorder.a();
        boolean bl2 = true;
        try {
            object = new FileOutputStream((File)object2, bl2);
            EventRecorder.a((FileOutputStream)object);
        }
        catch (Throwable throwable) {
            object2 = MobLog.getInstance();
            ((NLog)object2).w(throwable);
        }
        return false;
    }
}

