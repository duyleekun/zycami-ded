/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.filter.EditorFilterFragment;

public final class b
implements Observer {
    public final /* synthetic */ EditorFilterFragment a;

    public /* synthetic */ b(EditorFilterFragment editorFilterFragment) {
        this.a = editorFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorFilterFragment editorFilterFragment = this.a;
        object = (Integer)object;
        editorFilterFragment.W((Integer)object);
    }
}

