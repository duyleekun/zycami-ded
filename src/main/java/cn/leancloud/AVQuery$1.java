/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVQuery;
import cn.leancloud.Transformer;
import e.a.v0.o;
import java.util.ArrayList;
import java.util.List;

public class AVQuery$1
implements o {
    public final /* synthetic */ AVQuery this$0;

    public AVQuery$1(AVQuery aVQuery) {
        this.this$0 = aVQuery;
    }

    public List apply(List object) {
        ArrayList<Object> arrayList = AVQuery.access$000();
        Object object2 = new StringBuilder();
        String string2 = "invoke within AVQuery.findInBackground(). resultSize=";
        ((StringBuilder)object2).append(string2);
        int n10 = object.size();
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        ((AVLogger)((Object)arrayList)).d((String)object2);
        int n11 = object.size();
        arrayList = new ArrayList<Object>(n11);
        object = object.iterator();
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            object2 = (AVObject)object.next();
            string2 = this.this$0.getClassName();
            object2 = Transformer.transform((AVObject)object2, string2);
            arrayList.add(object2);
        }
        return arrayList;
    }
}

