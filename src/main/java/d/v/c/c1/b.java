/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.c1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.effect.EditorFrameFragment;

public final class b
implements Observer {
    public final /* synthetic */ EditorFrameFragment a;

    public /* synthetic */ b(EditorFrameFragment editorFrameFragment) {
        this.a = editorFrameFragment;
    }

    public final void onChanged(Object object) {
        EditorFrameFragment editorFrameFragment = this.a;
        object = (Boolean)object;
        editorFrameFragment.K((Boolean)object);
    }
}

