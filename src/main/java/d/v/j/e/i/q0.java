/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import androidx.core.util.Consumer;
import com.zhiyun.editortemplate.data.database.model.FileDataItem;
import d.v.j.e.i.d1;
import java.util.List;

public final class q0
implements Consumer {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ List b;
    public final /* synthetic */ List c;
    public final /* synthetic */ List d;

    public /* synthetic */ q0(d1 d12, List list, List list2, List list3) {
        this.a = d12;
        this.b = list;
        this.c = list2;
        this.d = list3;
    }

    public final void accept(Object object) {
        d1 d12 = this.a;
        List list = this.b;
        List list2 = this.c;
        List list3 = this.d;
        object = (FileDataItem)object;
        d12.O(list, list2, list3, (FileDataItem)object);
    }
}

