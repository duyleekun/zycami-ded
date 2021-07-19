/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.main.EditorMainActivity;

public final class m
implements Observer {
    public final /* synthetic */ EditorMainActivity a;

    public /* synthetic */ m(EditorMainActivity editorMainActivity) {
        this.a = editorMainActivity;
    }

    public final void onChanged(Object object) {
        EditorMainActivity editorMainActivity = this.a;
        object = (Long)object;
        editorMainActivity.x((Long)object);
    }
}

