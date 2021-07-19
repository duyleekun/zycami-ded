/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainFragment;

public final class i0
implements Observer {
    public final /* synthetic */ EditorMainFragment a;

    public /* synthetic */ i0(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public final void onChanged(Object object) {
        EditorMainFragment editorMainFragment = this.a;
        object = (Long)object;
        editorMainFragment.Q0((Long)object);
    }
}

