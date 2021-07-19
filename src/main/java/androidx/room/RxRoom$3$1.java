/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker$Observer;
import androidx.room.RxRoom;
import androidx.room.RxRoom$3;
import e.a.b0;
import java.util.Set;

public class RxRoom$3$1
extends InvalidationTracker$Observer {
    public final /* synthetic */ RxRoom$3 this$0;
    public final /* synthetic */ b0 val$emitter;

    public RxRoom$3$1(RxRoom$3 rxRoom$3, String[] stringArray, b0 b02) {
        this.this$0 = rxRoom$3;
        this.val$emitter = b02;
        super(stringArray);
    }

    public void onInvalidated(Set object) {
        object = this.val$emitter;
        Object object2 = RxRoom.NOTHING;
        object.onNext(object2);
    }
}

