/*
 * Decompiled with CFR 0.151.
 */
package d.v.j.e.i;

import com.zhiyun.editortemplate.data.api.entity.template.TemplateInfoData;
import d.v.j.e.i.z0;
import java.util.function.Consumer;

public final class e
implements Consumer {
    public final /* synthetic */ z0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ e(z0 z02, int n10) {
        this.a = z02;
        this.b = n10;
    }

    public final void accept(Object object) {
        z0 z02 = this.a;
        int n10 = this.b;
        object = (TemplateInfoData)object;
        z02.K0(n10, (TemplateInfoData)object);
    }
}

