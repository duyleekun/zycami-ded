/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator$MoveInfo;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;

public class DefaultItemAnimator$1
implements Runnable {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ArrayList val$moves;

    public DefaultItemAnimator$1(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$moves = arrayList;
    }

    public void run() {
        Object object;
        boolean bl2;
        Object object2 = this.val$moves.iterator();
        while (bl2 = object2.hasNext()) {
            object = (DefaultItemAnimator$MoveInfo)object2.next();
            DefaultItemAnimator defaultItemAnimator = this.this$0;
            RecyclerView$ViewHolder recyclerView$ViewHolder = ((DefaultItemAnimator$MoveInfo)object).holder;
            int n10 = ((DefaultItemAnimator$MoveInfo)object).fromX;
            int n11 = ((DefaultItemAnimator$MoveInfo)object).fromY;
            int n12 = ((DefaultItemAnimator$MoveInfo)object).toX;
            int n13 = ((DefaultItemAnimator$MoveInfo)object).toY;
            defaultItemAnimator.animateMoveImpl(recyclerView$ViewHolder, n10, n11, n12, n13);
        }
        this.val$moves.clear();
        object2 = this.this$0.mMovesList;
        object = this.val$moves;
        ((ArrayList)object2).remove(object);
    }
}

