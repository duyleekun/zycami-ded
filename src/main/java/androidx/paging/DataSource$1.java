/*
 * Decompiled with CFR 0.151.
 */
package androidx.paging;

import androidx.arch.core.util.Function;
import java.util.ArrayList;
import java.util.List;

public final class DataSource$1
implements Function {
    public final /* synthetic */ Function val$innerFunc;

    public DataSource$1(Function function) {
        this.val$innerFunc = function;
    }

    public List apply(List list) {
        int n10;
        int n11 = list.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        for (n11 = 0; n11 < (n10 = list.size()); ++n11) {
            Object object = this.val$innerFunc;
            Object e10 = list.get(n11);
            object = object.apply(e10);
            arrayList.add(object);
        }
        return arrayList;
    }
}

