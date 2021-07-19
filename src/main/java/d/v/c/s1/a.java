/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.speed.EditorSpeedFragment;

public final class a
implements Observer {
    public final /* synthetic */ EditorSpeedFragment a;

    public /* synthetic */ a(EditorSpeedFragment editorSpeedFragment) {
        this.a = editorSpeedFragment;
    }

    public final void onChanged(Object object) {
        EditorSpeedFragment editorSpeedFragment = this.a;
        object = (Integer)object;
        editorSpeedFragment.g0((Integer)object);
    }
}

