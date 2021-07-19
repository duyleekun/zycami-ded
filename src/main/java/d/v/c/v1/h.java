/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v1;

import androidx.fragment.app.DialogFragment;
import com.zhiyun.cama.transition.EditorTransitionFragment;
import d.v.c.b2.w.a;

public final class h
implements d.v.f.f.a {
    public final /* synthetic */ EditorTransitionFragment a;
    public final /* synthetic */ a b;

    public /* synthetic */ h(EditorTransitionFragment editorTransitionFragment, a a10) {
        this.a = editorTransitionFragment;
        this.b = a10;
    }

    public final void a(DialogFragment dialogFragment) {
        EditorTransitionFragment editorTransitionFragment = this.a;
        a a10 = this.b;
        editorTransitionFragment.Z(a10, dialogFragment);
    }
}

