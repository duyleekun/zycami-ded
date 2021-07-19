/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.p1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.rotate.EditorRotateFragment;

public final class c
implements Observer {
    public final /* synthetic */ EditorRotateFragment a;

    public /* synthetic */ c(EditorRotateFragment editorRotateFragment) {
        this.a = editorRotateFragment;
    }

    public final void onChanged(Object object) {
        EditorRotateFragment editorRotateFragment = this.a;
        object = (Integer)object;
        editorRotateFragment.X((Integer)object);
    }
}

