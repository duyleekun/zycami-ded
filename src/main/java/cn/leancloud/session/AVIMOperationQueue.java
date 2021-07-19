/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.AVIMOptions;
import cn.leancloud.im.BackgroundThreadpool;
import cn.leancloud.session.AVIMOperationQueue$1;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.PersistentQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class AVIMOperationQueue {
    public static ConcurrentMap timeoutCache;
    public Map cache;
    public PersistentQueue operationQueue;

    static {
        ConcurrentHashMap concurrentHashMap;
        timeoutCache = concurrentHashMap = new ConcurrentHashMap();
    }

    public AVIMOperationQueue(String string2) {
        Object object = new ConcurrentHashMap();
        this.cache = object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("operation.queue.");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        this.operationQueue = object = new PersistentQueue(string2, AVIMOperationQueue$Operation.class);
        this.setupCache();
    }

    private void setupCache() {
        boolean bl2;
        Iterator iterator2 = this.operationQueue.iterator();
        while (bl2 = iterator2.hasNext()) {
            AVIMOperationQueue$Operation aVIMOperationQueue$Operation = (AVIMOperationQueue$Operation)iterator2.next();
            int n10 = aVIMOperationQueue$Operation.requestId;
            int n11 = -65537;
            if (n10 == n11) continue;
            Map map = this.cache;
            Integer n12 = n10;
            map.put(n12, aVIMOperationQueue$Operation);
        }
    }

    public void clear() {
        this.operationQueue.clear();
        this.cache.clear();
    }

    public boolean containRequest(int n10) {
        Map map = this.cache;
        Integer n11 = n10;
        if ((n11 = map.get(n11)) != null) {
            n10 = 1;
        } else {
            n10 = 0;
            n11 = null;
        }
        return n10 != 0;
    }

    public boolean isEmpty() {
        return this.operationQueue.isEmpty();
    }

    public void offer(AVIMOperationQueue$Operation aVIMOperationQueue$Operation) {
        int n10 = aVIMOperationQueue$Operation.requestId;
        int n11 = -65537;
        if (n10 != n11) {
            Object object = this.cache;
            Object object2 = n10;
            object.put(object2, aVIMOperationQueue$Operation);
            object2 = new AVIMOperationQueue$1(this, aVIMOperationQueue$Operation);
            object = timeoutCache;
            Object object3 = aVIMOperationQueue$Operation.requestId;
            object.put(object3, object2);
            object = BackgroundThreadpool.getInstance();
            object3 = AVIMOptions.getGlobalOptions();
            int n12 = ((AVIMOptions)object3).getTimeoutInSecs();
            long l10 = n12;
            ((BackgroundThreadpool)object).executeDelayed((Runnable)object2, l10);
        }
        this.operationQueue.offer(aVIMOperationQueue$Operation);
    }

    public AVIMOperationQueue$Operation poll() {
        return (AVIMOperationQueue$Operation)this.operationQueue.poll();
    }

    public AVIMOperationQueue$Operation poll(int n10) {
        int n11 = -65537;
        if (n10 != n11) {
            Object object = this.cache;
            Object object2 = n10;
            if ((object = object.get(object2)) != null) {
                object = this.cache;
                object2 = n10;
                object = (AVIMOperationQueue$Operation)object.get(object2);
                object2 = this.cache;
                Object object3 = n10;
                object2.remove(object3);
                this.operationQueue.remove(object);
                object2 = timeoutCache;
                object3 = n10;
                object2 = (Runnable)object2.get(object3);
                object3 = timeoutCache;
                Object object4 = n10;
                object3.remove(object4);
                if (object2 != null) {
                    object4 = BackgroundThreadpool.getInstance();
                    ((BackgroundThreadpool)object4).removeScheduledTask((Runnable)object2);
                }
                return object;
            }
        }
        return this.poll();
    }
}

