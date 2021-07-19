/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.g.d0;

import androidx.core.util.Consumer;
import com.zhiyun.editortemplate.data.database.model.FileDataItem;
import d.v.j.g.d0.f;
import java.util.List;

public final class b
implements Consumer {
    public final /* synthetic */ f a;
    public final /* synthetic */ List b;

    public /* synthetic */ b(f f10, List list) {
        this.a = f10;
        this.b = list;
    }

    public final void accept(Object object) {
        f f10 = this.a;
        List list = this.b;
        object = (FileDataItem)object;
        f10.L(list, (FileDataItem)object);
    }
}

