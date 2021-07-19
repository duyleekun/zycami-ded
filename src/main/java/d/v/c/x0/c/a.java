/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.c;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment;

public final class a
implements Observer {
    public final /* synthetic */ EditorTextMainFragment a;

    public /* synthetic */ a(EditorTextMainFragment editorTextMainFragment) {
        this.a = editorTextMainFragment;
    }

    public final void onChanged(Object object) {
        EditorTextMainFragment editorTextMainFragment = this.a;
        object = (Integer)object;
        editorTextMainFragment.M((Integer)object);
    }
}

