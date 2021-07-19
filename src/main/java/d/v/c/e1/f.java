/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import com.zhiyun.cama.filter.EditorFilterFragment;

public final class f
implements Runnable {
    public final /* synthetic */ EditorFilterFragment a;
    public final /* synthetic */ Integer b;

    public /* synthetic */ f(EditorFilterFragment editorFilterFragment, Integer n10) {
        this.a = editorFilterFragment;
        this.b = n10;
    }

    public final void run() {
        EditorFilterFragment editorFilterFragment = this.a;
        Integer n10 = this.b;
        editorFilterFragment.k0(n10);
    }
}

