/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.transition.EditorTransitionFragment;
import java.util.List;

public final class c
implements Observer {
    public final /* synthetic */ EditorTransitionFragment a;

    public /* synthetic */ c(EditorTransitionFragment editorTransitionFragment) {
        this.a = editorTransitionFragment;
    }

    public final void onChanged(Object object) {
        EditorTransitionFragment editorTransitionFragment = this.a;
        object = (List)object;
        editorTransitionFragment.V((List)object);
    }
}

