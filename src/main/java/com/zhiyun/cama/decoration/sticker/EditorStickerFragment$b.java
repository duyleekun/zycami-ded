/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.decoration.sticker;

import android.view.View;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment$b$a;
import d.v.c.b1.t.g;
import d.v.c.q0.d$a;
import d.v.e.i.h;
import d.v.h.d.c;

public class EditorStickerFragment$b
extends d$a {
    public final /* synthetic */ EditorStickerFragment c;

    public EditorStickerFragment$b(EditorStickerFragment editorStickerFragment) {
        this.c = editorStickerFragment;
        super(editorStickerFragment);
    }

    public void c() {
        super.c();
        c c10 = EditorStickerFragment.x(this.c).j();
        g g10 = EditorStickerFragment.B(this.c);
        EditorStickerFragment$b$a editorStickerFragment$b$a = new EditorStickerFragment$b$a(this);
        g10.R2(c10, editorStickerFragment$b$a);
    }

    public void d() {
        super.d();
        EditorStickerFragment editorStickerFragment = this.c;
        boolean bl2 = EditorStickerFragment.C(editorStickerFragment);
        if (!bl2) {
            editorStickerFragment = this.c;
            EditorStickerFragment.D(editorStickerFragment);
        } else {
            editorStickerFragment = this.c;
            EditorStickerFragment.E(editorStickerFragment);
        }
    }

    public void h(View object, int n10) {
        object = EditorStickerFragment.x(this.c).c();
        Integer n11 = n10;
        h.g((MutableLiveData)object, n11);
        EditorStickerFragment.y((EditorStickerFragment)this.c).e.setCurrentItem(n10);
    }
}

