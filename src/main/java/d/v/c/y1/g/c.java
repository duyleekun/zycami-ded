/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.voice.record.EditorRecordFragment;

public final class c
implements Observer {
    public final /* synthetic */ EditorRecordFragment a;

    public /* synthetic */ c(EditorRecordFragment editorRecordFragment) {
        this.a = editorRecordFragment;
    }

    public final void onChanged(Object object) {
        EditorRecordFragment editorRecordFragment = this.a;
        object = (Boolean)object;
        editorRecordFragment.e0((Boolean)object);
    }
}

