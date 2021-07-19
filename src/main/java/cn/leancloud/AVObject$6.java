/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVSaveOption;
import cn.leancloud.AVUser;
import e.a.v0.o;
import e.a.z;
import java.util.List;

public class AVObject$6
implements o {
    public final /* synthetic */ AVObject this$0;
    public final /* synthetic */ AVUser val$asAuthenticatedUser;
    public final /* synthetic */ AVSaveOption val$option;

    public AVObject$6(AVObject aVObject, AVUser aVUser, AVSaveOption aVSaveOption) {
        this.this$0 = aVObject;
        this.val$asAuthenticatedUser = aVUser;
        this.val$option = aVSaveOption;
    }

    public z apply(List object) {
        boolean bl2;
        Object object2 = AVObject.logger;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("First, try to execute save operations in thread: ");
        Thread thread = Thread.currentThread();
        ((StringBuilder)object3).append(thread);
        object3 = ((StringBuilder)object3).toString();
        ((AVLogger)object2).d((String)object3);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (AVObject)object.next();
            object3 = this.val$asAuthenticatedUser;
            ((AVObject)object2).save((AVUser)object3);
        }
        AVObject.logger.d("Second, save object itself...");
        object = this.this$0;
        object2 = this.val$asAuthenticatedUser;
        object3 = this.val$option;
        return AVObject.access$000((AVObject)object, (AVUser)object2, (AVSaveOption)object3);
    }
}

