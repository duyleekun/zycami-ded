/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVObject;
import cn.leancloud.Transformer;
import cn.leancloud.query.AVCloudQueryResult;
import cn.leancloud.query.AVQueryResult;
import e.a.v0.o;
import java.util.ArrayList;
import java.util.Iterator;

public final class AVCloudQuery$1
implements o {
    public AVCloudQueryResult apply(AVQueryResult aVQueryResult) {
        boolean bl2;
        AVCloudQueryResult aVCloudQueryResult = new AVCloudQueryResult();
        int n10 = aVQueryResult.getCount();
        ArrayList<AVObject> arrayList = new ArrayList<AVObject>(n10);
        Iterator iterator2 = aVQueryResult.getResults().iterator();
        while (bl2 = iterator2.hasNext()) {
            AVObject aVObject = (AVObject)iterator2.next();
            String string2 = aVQueryResult.getClassName();
            aVObject = Transformer.transform(aVObject, string2);
            arrayList.add(aVObject);
        }
        aVCloudQueryResult.setResults(arrayList);
        int n11 = aVQueryResult.getCount();
        aVCloudQueryResult.setCount(n11);
        return aVCloudQueryResult;
    }
}

