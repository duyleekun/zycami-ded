/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package d.v.c.x0.b;

import android.view.View;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$a;

public final class a
implements Runnable {
    public final /* synthetic */ EditorStickerFragment$a a;
    public final /* synthetic */ View b;

    public /* synthetic */ a(EditorStickerFragment$a a10, View view) {
        this.a = a10;
        this.b = view;
    }

    public final void run() {
        EditorStickerFragment$a editorStickerFragment$a = this.a;
        View view = this.b;
        editorStickerFragment$a.b(view);
    }
}

