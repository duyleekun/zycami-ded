/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.e1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.filter.EditorFilterFragment;
import java.util.List;

public final class e
implements Observer {
    public final /* synthetic */ EditorFilterFragment a;

    public /* synthetic */ e(EditorFilterFragment editorFilterFragment) {
        this.a = editorFilterFragment;
    }

    public final void onChanged(Object object) {
        EditorFilterFragment editorFilterFragment = this.a;
        object = (List)object;
        editorFilterFragment.c0((List)object);
    }
}

