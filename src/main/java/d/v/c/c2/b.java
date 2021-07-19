/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.c2;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.zoom.EditorZoomFragment;

public final class b
implements Observer {
    public final /* synthetic */ EditorZoomFragment a;

    public /* synthetic */ b(EditorZoomFragment editorZoomFragment) {
        this.a = editorZoomFragment;
    }

    public final void onChanged(Object object) {
        EditorZoomFragment editorZoomFragment = this.a;
        object = (Integer)object;
        editorZoomFragment.M((Integer)object);
    }
}

