/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.ArchivedRequests;
import cn.leancloud.cache.PersistenceUtil;
import e.a.g0;
import e.a.s0.b;
import java.io.File;
import java.util.Map;

public class ArchivedRequests$3
implements g0 {
    public final /* synthetic */ ArchivedRequests this$0;
    public final /* synthetic */ Map val$collection;
    public final /* synthetic */ boolean val$isDelete;
    public final /* synthetic */ String val$objectInternalId;

    public ArchivedRequests$3(ArchivedRequests archivedRequests, Map map, String string2, boolean bl2) {
        this.this$0 = archivedRequests;
        this.val$collection = map;
        this.val$objectInternalId = string2;
        this.val$isDelete = bl2;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        ArchivedRequests.access$000().w("failed to save archived request. cause: ", throwable);
    }

    public void onNext(AVObject object) {
        object = this.val$collection;
        Object object2 = this.val$objectInternalId;
        object.remove(object2);
        object = this.this$0;
        object2 = this.val$objectInternalId;
        boolean bl2 = this.val$isDelete;
        object = ArchivedRequests.access$500((ArchivedRequests)object, (String)object2, bl2);
        object2 = PersistenceUtil.sharedInstance();
        boolean bl3 = ((PersistenceUtil)object2).forceDeleteFile((File)object);
        String string2 = " for objectInternalId: ";
        if (!bl3) {
            object2 = ArchivedRequests.access$000();
            StringBuilder stringBuilder = new StringBuilder();
            String string3 = "failed to delete file:";
            stringBuilder.append(string3);
            object = ((File)object).getAbsolutePath();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = this.val$objectInternalId;
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            ((AVLogger)object2).w((String)object);
        } else {
            object2 = ArchivedRequests.access$000();
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "succeed to delete file:";
            stringBuilder.append(string4);
            object = ((File)object).getAbsolutePath();
            stringBuilder.append((String)object);
            stringBuilder.append(string2);
            object = this.val$objectInternalId;
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            ((AVLogger)object2).d((String)object);
        }
    }

    public void onSubscribe(b b10) {
    }
}

