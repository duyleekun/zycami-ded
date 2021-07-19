/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.RxRoom$1;
import androidx.room.RxRoom$2;
import androidx.room.RxRoom$3;
import androidx.room.RxRoom$4;
import androidx.room.RxRoom$5;
import e.a.c1.b;
import e.a.h0;
import e.a.i0;
import e.a.j;
import e.a.q;
import e.a.v0.o;
import e.a.z;
import io.reactivex.BackpressureStrategy;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class RxRoom {
    public static final Object NOTHING;

    static {
        Object object;
        NOTHING = object = new Object();
    }

    public static j createFlowable(RoomDatabase object, boolean bl2, String[] stringArray, Callable object2) {
        Object object3 = b.b(RxRoom.getExecutor((RoomDatabase)object, bl2));
        object2 = q.s0((Callable)object2);
        object = RxRoom.createFlowable((RoomDatabase)object, stringArray).n6((h0)object3).Q7((h0)object3).s4((h0)object3);
        object3 = new RxRoom$2((q)object2);
        return ((j)object).Q2((o)object3);
    }

    public static j createFlowable(RoomDatabase object, String ... stringArray) {
        RxRoom$1 rxRoom$1 = new RxRoom$1(stringArray, (RoomDatabase)object);
        object = BackpressureStrategy.LATEST;
        return j.D1(rxRoom$1, (BackpressureStrategy)((Object)object));
    }

    public static j createFlowable(RoomDatabase roomDatabase, String[] stringArray, Callable callable) {
        return RxRoom.createFlowable(roomDatabase, false, stringArray, callable);
    }

    public static z createObservable(RoomDatabase object, boolean bl2, String[] stringArray, Callable object2) {
        Object object3 = b.b(RxRoom.getExecutor((RoomDatabase)object, bl2));
        object2 = q.s0((Callable)object2);
        object = RxRoom.createObservable((RoomDatabase)object, stringArray).L5((h0)object3).m7((h0)object3).i4((h0)object3);
        object3 = new RxRoom$4((q)object2);
        return ((z)object).I2((o)object3);
    }

    public static z createObservable(RoomDatabase roomDatabase, String ... stringArray) {
        RxRoom$3 rxRoom$3 = new RxRoom$3(stringArray, roomDatabase);
        return z.y1(rxRoom$3);
    }

    public static z createObservable(RoomDatabase roomDatabase, String[] stringArray, Callable callable) {
        return RxRoom.createObservable(roomDatabase, false, stringArray, callable);
    }

    public static i0 createSingle(Callable callable) {
        RxRoom$5 rxRoom$5 = new RxRoom$5(callable);
        return i0.H(rxRoom$5);
    }

    private static Executor getExecutor(RoomDatabase roomDatabase, boolean bl2) {
        if (bl2) {
            return roomDatabase.getTransactionExecutor();
        }
        return roomDatabase.getQueryExecutor();
    }
}

