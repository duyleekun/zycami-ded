/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.record.EditorRecordFragment;

public final class a
implements Observer {
    public final /* synthetic */ EditorRecordFragment a;

    public /* synthetic */ a(EditorRecordFragment editorRecordFragment) {
        this.a = editorRecordFragment;
    }

    public final void onChanged(Object object) {
        EditorRecordFragment editorRecordFragment = this.a;
        object = (Long)object;
        editorRecordFragment.i0((Long)object);
    }
}

