/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.InvalidationTracker$Observer;
import androidx.room.RoomDatabase;
import androidx.room.RxRoom;
import androidx.room.RxRoom$3$1;
import androidx.room.RxRoom$3$2;
import e.a.b0;
import e.a.c0;
import e.a.s0.b;
import e.a.s0.c;
import e.a.v0.a;

public class RxRoom$3
implements c0 {
    public final /* synthetic */ RoomDatabase val$database;
    public final /* synthetic */ String[] val$tableNames;

    public RxRoom$3(String[] stringArray, RoomDatabase roomDatabase) {
        this.val$tableNames = stringArray;
        this.val$database = roomDatabase;
    }

    public void subscribe(b0 b02) {
        Object object = this.val$tableNames;
        Object object2 = new RxRoom$3$1(this, (String[])object, b02);
        this.val$database.getInvalidationTracker().addObserver((InvalidationTracker$Observer)object2);
        object = new RxRoom$3$2(this, (InvalidationTracker$Observer)object2);
        object2 = c.c((a)object);
        b02.setDisposable((b)object2);
        object2 = RxRoom.NOTHING;
        b02.onNext(object2);
    }
}

