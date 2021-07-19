/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainFragment;

public final class q
implements Observer {
    public final /* synthetic */ EditorMainFragment a;

    public /* synthetic */ q(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public final void onChanged(Object object) {
        EditorMainFragment editorMainFragment = this.a;
        object = (Boolean)object;
        editorMainFragment.U0((Boolean)object);
    }
}

