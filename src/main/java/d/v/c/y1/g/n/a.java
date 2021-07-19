/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g.n;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.record.volume.EditorRecordVolumeFragment;

public final class a
implements Observer {
    public final /* synthetic */ EditorRecordVolumeFragment a;

    public /* synthetic */ a(EditorRecordVolumeFragment editorRecordVolumeFragment) {
        this.a = editorRecordVolumeFragment;
    }

    public final void onChanged(Object object) {
        EditorRecordVolumeFragment editorRecordVolumeFragment = this.a;
        object = (Float)object;
        editorRecordVolumeFragment.E((Float)object);
    }
}

