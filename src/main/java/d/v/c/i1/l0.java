/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainFragment;
import d.v.c.b2.w.e;

public final class l0
implements Observer {
    public final /* synthetic */ EditorMainFragment a;

    public /* synthetic */ l0(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public final void onChanged(Object object) {
        EditorMainFragment editorMainFragment = this.a;
        object = (e)object;
        EditorMainFragment.E0(editorMainFragment, (e)object);
    }
}

