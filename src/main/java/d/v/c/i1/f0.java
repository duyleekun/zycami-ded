/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.core.util.Pair;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainFragment;

public final class f0
implements Observer {
    public final /* synthetic */ EditorMainFragment a;

    public /* synthetic */ f0(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public final void onChanged(Object object) {
        EditorMainFragment editorMainFragment = this.a;
        object = (Pair)object;
        editorMainFragment.W0((Pair)object);
    }
}

