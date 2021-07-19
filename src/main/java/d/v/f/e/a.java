/*
 * Decompiled with CFR 0.151.
 */
package d.v.f.e;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.SimpleItemAnimator;

public class a {
    public static void a(RecyclerView object, boolean bl2) {
        if (object != null && bl2) {
            RecyclerView$ItemAnimator recyclerView$ItemAnimator = ((RecyclerView)object).getItemAnimator();
            long l10 = 0L;
            recyclerView$ItemAnimator.setAddDuration(l10);
            ((RecyclerView)object).getItemAnimator().setChangeDuration(l10);
            ((RecyclerView)object).getItemAnimator().setMoveDuration(l10);
            ((RecyclerView)object).getItemAnimator().setRemoveDuration(l10);
            object = (SimpleItemAnimator)((RecyclerView)object).getItemAnimator();
            bl2 = false;
            recyclerView$ItemAnimator = null;
            ((SimpleItemAnimator)object).setSupportsChangeAnimations(false);
        }
    }
}

