/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.decoration.sticker;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.zhiyun.cama.data.api.entity.sticker.StickerTabInfo;
import com.zhiyun.cama.decoration.sticker.EditorStickerFragment;
import d.v.c.x0.b.p;
import java.util.ArrayList;
import java.util.List;

public class EditorStickerFragment$c
extends FragmentStateAdapter {
    public List a;
    public final /* synthetic */ EditorStickerFragment b;

    public EditorStickerFragment$c(EditorStickerFragment arrayList, Fragment fragment) {
        this.b = arrayList;
        super(fragment);
        this.a = arrayList = new ArrayList();
    }

    public static /* synthetic */ void a(EditorStickerFragment$c editorStickerFragment$c, List list) {
        editorStickerFragment$c.b(list);
    }

    private void b(List list) {
        this.a.clear();
        this.a.addAll(list);
        this.notifyDataSetChanged();
    }

    public Fragment createFragment(int n10) {
        long l10 = ((StickerTabInfo)this.a.get(n10)).getId();
        n10 = (int)(EditorStickerFragment.F(this.b) ? 1 : 0);
        return p.F(l10, n10 != 0);
    }

    public int getItemCount() {
        return this.a.size();
    }
}

