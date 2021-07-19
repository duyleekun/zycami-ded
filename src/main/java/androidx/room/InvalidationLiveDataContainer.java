/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.lifecycle.LiveData;
import androidx.room.RoomDatabase;
import androidx.room.RoomTrackingLiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import java.util.concurrent.Callable;

public class InvalidationLiveDataContainer {
    private final RoomDatabase mDatabase;
    public final Set mLiveDataSet;

    public InvalidationLiveDataContainer(RoomDatabase roomDatabase) {
        Object object = new IdentityHashMap();
        this.mLiveDataSet = object = Collections.newSetFromMap(object);
        this.mDatabase = roomDatabase;
    }

    public LiveData create(String[] stringArray, boolean bl2, Callable callable) {
        RoomDatabase roomDatabase = this.mDatabase;
        RoomTrackingLiveData roomTrackingLiveData = new RoomTrackingLiveData(roomDatabase, this, bl2, callable, stringArray);
        return roomTrackingLiveData;
    }

    public void onActive(LiveData liveData) {
        this.mLiveDataSet.add(liveData);
    }

    public void onInactive(LiveData liveData) {
        this.mLiveDataSet.remove(liveData);
    }
}

