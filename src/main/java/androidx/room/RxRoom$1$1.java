/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker$Observer;
import androidx.room.RxRoom;
import androidx.room.RxRoom$1;
import e.a.l;
import java.util.Set;

public class RxRoom$1$1
extends InvalidationTracker$Observer {
    public final /* synthetic */ RxRoom$1 this$0;
    public final /* synthetic */ l val$emitter;

    public RxRoom$1$1(RxRoom$1 rxRoom$1, String[] stringArray, l l10) {
        this.this$0 = rxRoom$1;
        this.val$emitter = l10;
        super(stringArray);
    }

    public void onInvalidated(Set object) {
        object = this.val$emitter;
        boolean bl2 = object.isCancelled();
        if (!bl2) {
            object = this.val$emitter;
            Object object2 = RxRoom.NOTHING;
            object.onNext(object2);
        }
    }
}

