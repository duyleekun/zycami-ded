/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainFragment;

public final class j0
implements Observer {
    public final /* synthetic */ EditorMainFragment a;

    public /* synthetic */ j0(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    public final void onChanged(Object object) {
        EditorMainFragment editorMainFragment = this.a;
        object = (Boolean)object;
        editorMainFragment.S0((Boolean)object);
    }
}

