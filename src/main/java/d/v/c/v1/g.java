/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.transition.EditorTransitionFragment;
import d.v.c.b2.w.a;

public final class g
implements Observer {
    public final /* synthetic */ EditorTransitionFragment a;

    public /* synthetic */ g(EditorTransitionFragment editorTransitionFragment) {
        this.a = editorTransitionFragment;
    }

    public final void onChanged(Object object) {
        EditorTransitionFragment editorTransitionFragment = this.a;
        object = (a)object;
        editorTransitionFragment.N((a)object);
    }
}

