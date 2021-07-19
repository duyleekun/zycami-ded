/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import com.zhiyun.cama.transition.EditorTransitionFragment;

public final class a
implements Runnable {
    public final /* synthetic */ EditorTransitionFragment a;
    public final /* synthetic */ Integer b;

    public /* synthetic */ a(EditorTransitionFragment editorTransitionFragment, Integer n10) {
        this.a = editorTransitionFragment;
        this.b = n10;
    }

    public final void run() {
        EditorTransitionFragment editorTransitionFragment = this.a;
        Integer n10 = this.b;
        editorTransitionFragment.b0(n10);
    }
}

