/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import java.util.ArrayList;

public class DefaultItemAnimator$3
implements Runnable {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ArrayList val$additions;

    public DefaultItemAnimator$3(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$additions = arrayList;
    }

    public void run() {
        Object object;
        boolean bl2;
        Object object2 = this.val$additions.iterator();
        while (bl2 = object2.hasNext()) {
            object = (RecyclerView$ViewHolder)object2.next();
            DefaultItemAnimator defaultItemAnimator = this.this$0;
            defaultItemAnimator.animateAddImpl((RecyclerView$ViewHolder)object);
        }
        this.val$additions.clear();
        object2 = this.this$0.mAdditionsList;
        object = this.val$additions;
        ((ArrayList)object2).remove(object);
    }
}

