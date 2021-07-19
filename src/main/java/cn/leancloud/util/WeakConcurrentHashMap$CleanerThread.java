/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.util;

import cn.leancloud.util.WeakConcurrentHashMap;
import cn.leancloud.util.WeakConcurrentHashMapListener;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WeakConcurrentHashMap$CleanerThread
extends Thread {
    public final /* synthetic */ WeakConcurrentHashMap this$0;

    public WeakConcurrentHashMap$CleanerThread(WeakConcurrentHashMap weakConcurrentHashMap) {
        this.this$0 = weakConcurrentHashMap;
    }

    private void cleanMap() {
        boolean bl2;
        Date date = new Date();
        long l10 = date.getTime();
        Iterator iterator2 = WeakConcurrentHashMap.access$100(this.this$0).keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            boolean bl3;
            Object k10 = iterator2.next();
            Iterator iterator3 = (Long)WeakConcurrentHashMap.access$100(this.this$0).get(k10);
            long l11 = (Long)((Object)iterator3);
            Object object = this.this$0;
            long l12 = WeakConcurrentHashMap.access$200((WeakConcurrentHashMap)object);
            long l13 = l10 - (l11 += l12);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 <= 0) continue;
            iterator3 = (List)this.this$0.remove(k10);
            WeakConcurrentHashMap.access$100(this.this$0).remove(k10);
            WeakConcurrentHashMapListener weakConcurrentHashMapListener = WeakConcurrentHashMap.access$300(this.this$0);
            if (weakConcurrentHashMapListener == null || iterator3 == null) continue;
            iterator3 = iterator3.iterator();
            while (bl3 = iterator3.hasNext()) {
                weakConcurrentHashMapListener = iterator3.next();
                object = WeakConcurrentHashMap.access$300(this.this$0);
                object.notifyOnRemoval(k10, weakConcurrentHashMapListener);
            }
        }
    }

    public void run() {
        WeakConcurrentHashMap weakConcurrentHashMap;
        boolean bl2;
        while (bl2 = WeakConcurrentHashMap.access$000(weakConcurrentHashMap = this.this$0)) {
            this.cleanMap();
            long l10 = 1000L;
            try {
                Thread.sleep(l10);
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }
}

