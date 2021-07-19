/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f.y;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.volume.EditorMusicVolumeFragment;

public final class a
implements Observer {
    public final /* synthetic */ EditorMusicVolumeFragment a;

    public /* synthetic */ a(EditorMusicVolumeFragment editorMusicVolumeFragment) {
        this.a = editorMusicVolumeFragment;
    }

    public final void onChanged(Object object) {
        EditorMusicVolumeFragment editorMusicVolumeFragment = this.a;
        object = (Float)object;
        editorMusicVolumeFragment.L((Float)object);
    }
}

