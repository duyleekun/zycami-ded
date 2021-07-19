/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b1;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.draft.EditorDraftFragment;
import java.util.List;

public final class m
implements Observer {
    public final /* synthetic */ EditorDraftFragment a;

    public /* synthetic */ m(EditorDraftFragment editorDraftFragment) {
        this.a = editorDraftFragment;
    }

    public final void onChanged(Object object) {
        EditorDraftFragment editorDraftFragment = this.a;
        object = (List)object;
        editorDraftFragment.B((List)object);
    }
}

