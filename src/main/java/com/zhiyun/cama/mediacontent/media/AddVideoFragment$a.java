/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.mediacontent.media;

import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.zhiyun.cama.mediacontent.media.AddVideoFragment;
import d.v.c.r1.c;
import java.util.List;

public class AddVideoFragment$a
extends c {
    public final /* synthetic */ AddVideoFragment d;

    public AddVideoFragment$a(AddVideoFragment addVideoFragment, List list) {
        this.d = addVideoFragment;
        super(list);
    }

    public void clearView(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        super.clearView(recyclerView, recyclerView$ViewHolder);
        AddVideoFragment.x((AddVideoFragment)this.d).i.b(false, null, null, -1);
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return ItemTouchHelper$Callback.makeMovementFlags(12, 0);
    }
}

