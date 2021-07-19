/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.speed.EditorSpeedFragment;

public final class j
implements Observer {
    public final /* synthetic */ EditorSpeedFragment a;

    public /* synthetic */ j(EditorSpeedFragment editorSpeedFragment) {
        this.a = editorSpeedFragment;
    }

    public final void onChanged(Object object) {
        EditorSpeedFragment editorSpeedFragment = this.a;
        object = (Long)object;
        editorSpeedFragment.e0((Long)object);
    }
}

