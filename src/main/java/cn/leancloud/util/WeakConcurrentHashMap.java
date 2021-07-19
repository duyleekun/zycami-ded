/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.util;

import cn.leancloud.util.WeakConcurrentHashMap$CleanerThread;
import cn.leancloud.util.WeakConcurrentHashMapListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class WeakConcurrentHashMap
extends ConcurrentHashMap {
    private static final long serialVersionUID = 1L;
    private long expiryInMillis;
    private WeakConcurrentHashMapListener listener;
    private boolean mapAlive;
    private Map timeMap;

    public WeakConcurrentHashMap() {
        ConcurrentHashMap concurrentHashMap;
        this.timeMap = concurrentHashMap = new ConcurrentHashMap();
        this.listener = null;
        this.mapAlive = true;
        this.expiryInMillis = 10000L;
        this.initialize();
    }

    public WeakConcurrentHashMap(long l10) {
        ConcurrentHashMap concurrentHashMap;
        this.timeMap = concurrentHashMap = new ConcurrentHashMap();
        this.listener = null;
        this.mapAlive = true;
        this.expiryInMillis = l10;
        this.initialize();
    }

    public WeakConcurrentHashMap(long l10, WeakConcurrentHashMapListener weakConcurrentHashMapListener) {
        ConcurrentHashMap concurrentHashMap;
        this.timeMap = concurrentHashMap = new ConcurrentHashMap();
        this.listener = null;
        this.mapAlive = true;
        this.expiryInMillis = l10;
        this.listener = weakConcurrentHashMapListener;
        this.initialize();
    }

    public WeakConcurrentHashMap(WeakConcurrentHashMapListener weakConcurrentHashMapListener) {
        ConcurrentHashMap concurrentHashMap;
        this.timeMap = concurrentHashMap = new ConcurrentHashMap();
        this.listener = null;
        this.mapAlive = true;
        this.listener = weakConcurrentHashMapListener;
        this.expiryInMillis = 10000L;
        this.initialize();
    }

    public static /* synthetic */ boolean access$000(WeakConcurrentHashMap weakConcurrentHashMap) {
        return weakConcurrentHashMap.mapAlive;
    }

    public static /* synthetic */ Map access$100(WeakConcurrentHashMap weakConcurrentHashMap) {
        return weakConcurrentHashMap.timeMap;
    }

    public static /* synthetic */ long access$200(WeakConcurrentHashMap weakConcurrentHashMap) {
        return weakConcurrentHashMap.expiryInMillis;
    }

    public static /* synthetic */ WeakConcurrentHashMapListener access$300(WeakConcurrentHashMap weakConcurrentHashMap) {
        return weakConcurrentHashMap.listener;
    }

    public Object addElement(Object object, Object object2) {
        boolean bl2 = this.mapAlive;
        if (bl2) {
            ArrayList<Object> arrayList;
            bl2 = super.containsKey(object);
            if (bl2) {
                arrayList = (List)this.get(object);
                arrayList.add(object2);
            } else {
                arrayList = new ArrayList<Object>();
                Map map = this.timeMap;
                long l10 = ((Date)((Object)arrayList)).getTime();
                arrayList = l10;
                map.put(object, arrayList);
                arrayList = new ArrayList<Object>();
                arrayList.add(object2);
                this.put(object, arrayList);
            }
            arrayList = this.listener;
            if (arrayList != null) {
                arrayList.notifyOnAdd(object, object2);
            }
            return object2;
        }
        object = new IllegalStateException("WeakConcurrent Hashmap is no more alive.. Try creating a new one.");
        throw object;
    }

    public Object addIfAbsent(Object object, Object object2) {
        boolean bl2 = this.mapAlive;
        if (bl2) {
            bl2 = this.containsKey(object);
            if (!bl2) {
                return this.addElement(object, object2);
            }
            return null;
        }
        object = new IllegalStateException("WeakConcurrent Hashmap is no more alive.. Try creating a new one.");
        throw object;
    }

    public void initialize() {
        WeakConcurrentHashMap$CleanerThread weakConcurrentHashMap$CleanerThread = new WeakConcurrentHashMap$CleanerThread(this);
        weakConcurrentHashMap$CleanerThread.start();
    }

    public boolean isAlive() {
        return this.mapAlive;
    }

    public void quitMap() {
        this.mapAlive = false;
    }

    public void registerRemovalListener(WeakConcurrentHashMapListener weakConcurrentHashMapListener) {
        this.listener = weakConcurrentHashMapListener;
    }
}

