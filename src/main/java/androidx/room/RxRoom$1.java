/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker$Observer;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.RxRoom$1$1;
import androidx.room.RxRoom$1$2;
import e.a.l;
import e.a.m;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.a;

public class RxRoom$1
implements m {
    public final /* synthetic */ RoomDatabase val$database;
    public final /* synthetic */ String[] val$tableNames;

    public RxRoom$1(String[] stringArray, RoomDatabase roomDatabase) {
        this.val$tableNames = stringArray;
        this.val$database = roomDatabase;
    }

    public void subscribe(l l10) {
        boolean bl2;
        Object object = this.val$tableNames;
        Object object2 = new RxRoom$1$1(this, (String[])object, l10);
        boolean bl3 = l10.isCancelled();
        if (!bl3) {
            this.val$database.getInvalidationTracker().addObserver((InvalidationTracker$Observer)object2);
            object = new RxRoom$1$2(this, (InvalidationTracker$Observer)object2);
            object2 = c.c((a)object);
            l10.setDisposable((b)object2);
        }
        if (!(bl2 = l10.isCancelled())) {
            object2 = RxRoom.NOTHING;
            l10.onNext(object2);
        }
    }
}

