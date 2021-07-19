/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import com.zhiyun.cama.main.EditorMainFragment$g$b;
import d.v.c.b2.w.k;
import java.util.function.Consumer;

public final class t
implements Consumer {
    public final /* synthetic */ EditorMainFragment$g$b a;
    public final /* synthetic */ int b;
    public final /* synthetic */ k c;

    public /* synthetic */ t(EditorMainFragment$g$b editorMainFragment$g$b, int n10, k k10) {
        this.a = editorMainFragment$g$b;
        this.b = n10;
        this.c = k10;
    }

    public final void accept(Object object) {
        EditorMainFragment$g$b editorMainFragment$g$b = this.a;
        int n10 = this.b;
        k k10 = this.c;
        object = (k)object;
        editorMainFragment$g$b.h(n10, k10, (k)object);
    }
}

