/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.database.model.template.templatelist.FileData;
import d.v.j.e.i.d1;
import java.util.function.Function;

public final class m0
implements Function {
    public final /* synthetic */ long a;

    public /* synthetic */ m0(long l10) {
        this.a = l10;
    }

    public final Object apply(Object object) {
        long l10 = this.a;
        object = (FileData)object;
        return d1.U(l10, (FileData)object);
    }
}

