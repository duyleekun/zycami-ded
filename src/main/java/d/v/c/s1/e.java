/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.speed.EditorSpeedFragment;

public final class e
implements Observer {
    public final /* synthetic */ EditorSpeedFragment a;

    public /* synthetic */ e(EditorSpeedFragment editorSpeedFragment) {
        this.a = editorSpeedFragment;
    }

    public final void onChanged(Object object) {
        EditorSpeedFragment editorSpeedFragment = this.a;
        object = (Integer)object;
        editorSpeedFragment.a0((Integer)object);
    }
}

