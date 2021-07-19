/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import com.zhiyun.cama.main.EditorMainFragment$g$e;
import d.v.c.b2.w.j;
import java.util.function.Consumer;

public final class u
implements Consumer {
    public final /* synthetic */ EditorMainFragment$g$e a;
    public final /* synthetic */ int b;
    public final /* synthetic */ j c;

    public /* synthetic */ u(EditorMainFragment$g$e editorMainFragment$g$e, int n10, j j10) {
        this.a = editorMainFragment$g$e;
        this.b = n10;
        this.c = j10;
    }

    public final void accept(Object object) {
        EditorMainFragment$g$e editorMainFragment$g$e = this.a;
        int n10 = this.b;
        j j10 = this.c;
        object = (j)object;
        editorMainFragment$g$e.h(n10, j10, (j)object);
    }
}

