/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.transition.EditorTransitionFragment;

public final class f
implements Observer {
    public final /* synthetic */ EditorTransitionFragment a;

    public /* synthetic */ f(EditorTransitionFragment editorTransitionFragment) {
        this.a = editorTransitionFragment;
    }

    public final void onChanged(Object object) {
        EditorTransitionFragment editorTransitionFragment = this.a;
        object = (Integer)object;
        editorTransitionFragment.R((Integer)object);
    }
}

