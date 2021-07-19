/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Process
 */
package com.mob.commons.a;

import android.os.Process;
import com.mob.commons.LockAction;
import com.mob.commons.a.d;
import com.mob.commons.a.d$1;
import com.mob.commons.b;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.FileLocker;
import java.io.File;

public class d$1$1
implements LockAction {
    public final /* synthetic */ d$1 a;

    public d$1$1(d$1 d$1) {
        this.a = d$1;
    }

    public boolean run(FileLocker fileLocker) {
        block38: {
            Object object = MobLog.getInstance();
            Object object2 = new StringBuilder();
            Object object3 = "synchronizeProcess success clt: ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.a;
            object3 = ((d$1)object3).b;
            object3 = object3.getClass();
            object3 = ((Class)object3).getSimpleName();
            ((StringBuilder)object2).append((String)object3);
            object3 = ", file: ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.a;
            object3 = ((d$1)object3).a;
            object3 = ((File)object3).getPath();
            ((StringBuilder)object2).append((String)object3);
            object3 = ", pid: ";
            ((StringBuilder)object2).append((String)object3);
            int bl2 = Process.myPid();
            ((StringBuilder)object2).append(bl2);
            object3 = ", isStop: ";
            ((StringBuilder)object2).append((String)object3);
            object3 = this.a;
            object3 = ((d$1)object3).b;
            boolean bl3 = d.a((d)object3);
            ((StringBuilder)object2).append(bl3);
            object2 = ((StringBuilder)object2).toString();
            object3 = new Object[]{};
            ((NLog)object).d(object2, (Object[])object3);
            object = this.a;
            object = ((d$1)object).b;
            boolean bl4 = d.a((d)object);
            if (bl4) break block38;
            bl4 = b.Z();
            object2 = this.a;
            object2 = ((d$1)object2).b;
            boolean bl5 = ((d)object2).b_();
            object3 = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            Object[] objectArray = "Clt entrance. forb: ";
            charSequence.append((String)objectArray);
            charSequence.append(bl4);
            objectArray = ", coll: ";
            charSequence.append((String)objectArray);
            charSequence.append(bl5);
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            ((NLog)object3).d(charSequence, objectArray);
            if (bl4 || !bl5) break block38;
            object = this.a;
            try {
                d$1.a((d$1)object);
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                ((NLog)object2).d(throwable);
            }
        }
        return false;
    }
}

