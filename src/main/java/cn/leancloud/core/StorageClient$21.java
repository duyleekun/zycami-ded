/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.core;

import cn.leancloud.AVObject;
import cn.leancloud.AVStatus;
import cn.leancloud.core.StorageClient;
import cn.leancloud.query.AVQueryResult;
import e.a.v0.o;
import java.util.ArrayList;
import java.util.List;

public class StorageClient$21
implements o {
    public final /* synthetic */ StorageClient this$0;

    public StorageClient$21(StorageClient storageClient) {
        this.this$0 = storageClient;
    }

    public List apply(AVQueryResult object) {
        boolean bl2;
        if (object == null) {
            StorageClient.access$000().e("The mapper function returned a null value.");
            return null;
        }
        ArrayList<AVStatus> arrayList = new ArrayList<AVStatus>();
        object = ((AVQueryResult)object).getResults().iterator();
        while (bl2 = object.hasNext()) {
            AVObject aVObject = (AVObject)object.next();
            AVStatus aVStatus = new AVStatus(aVObject);
            arrayList.add(aVStatus);
        }
        return arrayList;
    }
}

