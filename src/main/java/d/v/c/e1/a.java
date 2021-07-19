/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.filter.EditorFilterFragment;

public final class a
implements Observer {
    public final /* synthetic */ EditorFilterFragment a;

    public /* synthetic */ a(EditorFilterFragment editorFilterFragment) {
        this.a = editorFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorFilterFragment editorFilterFragment = this.a;
        object = (d.v.c.b2.w.a)object;
        editorFilterFragment.S((d.v.c.b2.w.a)object);
    }
}

