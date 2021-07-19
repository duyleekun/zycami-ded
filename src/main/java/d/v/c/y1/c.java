/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.EditorVolumeFragment;

public final class c
implements Observer {
    public final /* synthetic */ EditorVolumeFragment a;

    public /* synthetic */ c(EditorVolumeFragment editorVolumeFragment) {
        this.a = editorVolumeFragment;
    }

    public final void onChanged(Object object) {
        EditorVolumeFragment editorVolumeFragment = this.a;
        object = (Integer)object;
        editorVolumeFragment.N((Integer)object);
    }
}

