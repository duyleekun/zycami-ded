/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.filter.EditorFilterFragment;

public final class i
implements Observer {
    public final /* synthetic */ EditorFilterFragment a;

    public /* synthetic */ i(EditorFilterFragment editorFilterFragment) {
        this.a = editorFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorFilterFragment editorFilterFragment = this.a;
        object = (Boolean)object;
        editorFilterFragment.U((Boolean)object);
    }
}

