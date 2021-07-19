/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.f;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.music.EditorAudioBeatFragment;

public final class b
implements Observer {
    public final /* synthetic */ EditorAudioBeatFragment a;

    public /* synthetic */ b(EditorAudioBeatFragment editorAudioBeatFragment) {
        this.a = editorAudioBeatFragment;
    }

    public final void onChanged(Object object) {
        EditorAudioBeatFragment editorAudioBeatFragment = this.a;
        object = (Integer)object;
        editorAudioBeatFragment.M((Integer)object);
    }
}

