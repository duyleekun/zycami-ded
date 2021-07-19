/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment;

public final class c
implements Observer {
    public final /* synthetic */ EditorAudioBeatFragment a;

    public /* synthetic */ c(EditorAudioBeatFragment editorAudioBeatFragment) {
        this.a = editorAudioBeatFragment;
    }

    public final void onChanged(Object object) {
        EditorAudioBeatFragment editorAudioBeatFragment = this.a;
        object = (Long)object;
        editorAudioBeatFragment.K((Long)object);
    }
}

