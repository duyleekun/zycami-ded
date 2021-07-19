/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.template.EditorProtocol;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import d.v.j.e.i.d1;
import java.util.concurrent.Callable;

public final class o0
implements Callable {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ TemplatePOJO b;
    public final /* synthetic */ EditorProtocol c;

    public /* synthetic */ o0(d1 d12, TemplatePOJO templatePOJO, EditorProtocol editorProtocol) {
        this.a = d12;
        this.b = templatePOJO;
        this.c = editorProtocol;
    }

    public final Object call() {
        d1 d12 = this.a;
        TemplatePOJO templatePOJO = this.b;
        EditorProtocol editorProtocol = this.c;
        return d12.W(templatePOJO, editorProtocol);
    }
}

