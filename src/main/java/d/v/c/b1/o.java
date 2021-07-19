/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.draft.EditorDraftFragment;

public final class o
implements Observer {
    public final /* synthetic */ EditorDraftFragment a;

    public /* synthetic */ o(EditorDraftFragment editorDraftFragment) {
        this.a = editorDraftFragment;
    }

    public final void onChanged(Object object) {
        EditorDraftFragment editorDraftFragment = this.a;
        object = (Integer)object;
        editorDraftFragment.F((Integer)object);
    }
}

