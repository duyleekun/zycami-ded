/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.k1.a;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;

public final class m
implements Observer {
    public final /* synthetic */ EditorAddVideoActivity a;

    public /* synthetic */ m(EditorAddVideoActivity editorAddVideoActivity) {
        this.a = editorAddVideoActivity;
    }

    public final void onChanged(Object object) {
        EditorAddVideoActivity editorAddVideoActivity = this.a;
        object = (Boolean)object;
        editorAddVideoActivity.m((Boolean)object);
    }
}

