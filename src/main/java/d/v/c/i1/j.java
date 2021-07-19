/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import com.zhiyun.cama.main.EditorMainActivity;
import java.util.function.Consumer;

public final class j
implements Consumer {
    public final /* synthetic */ EditorMainActivity a;
    public final /* synthetic */ boolean b;

    public /* synthetic */ j(EditorMainActivity editorMainActivity, boolean bl2) {
        this.a = editorMainActivity;
        this.b = bl2;
    }

    public final void accept(Object object) {
        EditorMainActivity editorMainActivity = this.a;
        boolean bl2 = this.b;
        object = (Boolean)object;
        editorMainActivity.F(bl2, (Boolean)object);
    }
}

