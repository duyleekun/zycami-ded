/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo;
import java.util.ArrayList;

public class DefaultItemAnimator$2
implements Runnable {
    public final /* synthetic */ DefaultItemAnimator this$0;
    public final /* synthetic */ ArrayList val$changes;

    public DefaultItemAnimator$2(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$changes = arrayList;
    }

    public void run() {
        Object object;
        boolean bl2;
        Object object2 = this.val$changes.iterator();
        while (bl2 = object2.hasNext()) {
            object = (DefaultItemAnimator$ChangeInfo)object2.next();
            DefaultItemAnimator defaultItemAnimator = this.this$0;
            defaultItemAnimator.animateChangeImpl((DefaultItemAnimator$ChangeInfo)object);
        }
        this.val$changes.clear();
        object2 = this.this$0.mChangesList;
        object = this.val$changes;
        ((ArrayList)object2).remove(object);
    }
}

