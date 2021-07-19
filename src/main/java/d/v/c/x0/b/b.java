/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.x0.b;

import androidx.lifecycle.Observer;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment;
import java.util.List;

public final class b
implements Observer {
    public final /* synthetic */ EditorStickerFragment a;

    public /* synthetic */ b(EditorStickerFragment editorStickerFragment) {
        this.a = editorStickerFragment;
    }

    public final void onChanged(Object object) {
        EditorStickerFragment editorStickerFragment = this.a;
        object = (List)object;
        editorStickerFragment.N((List)object);
    }
}

