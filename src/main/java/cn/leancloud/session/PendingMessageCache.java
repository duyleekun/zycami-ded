/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.session.PersistentQueue;
import cn.leancloud.session.PersistentQueue$HasId;
import cn.leancloud.utils.StringUtil;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PendingMessageCache {
    private final PersistentQueue messages;
    private Map msgMapping;

    public PendingMessageCache(String string2, Class clazz) {
        PersistentQueue persistentQueue;
        this.messages = persistentQueue = new PersistentQueue(string2, clazz);
        this.setupMapping();
    }

    private void setupMapping() {
        boolean bl2;
        Object object = new ConcurrentHashMap();
        this.msgMapping = object;
        object = this.messages.iterator();
        while (bl2 = object.hasNext()) {
            PersistentQueue$HasId persistentQueue$HasId = (PersistentQueue$HasId)object.next();
            Object object2 = persistentQueue$HasId.getId();
            boolean bl3 = StringUtil.isEmpty((String)object2);
            if (bl3) continue;
            object2 = this.msgMapping;
            String string2 = persistentQueue$HasId.getId();
            object2.put(string2, persistentQueue$HasId);
        }
    }

    public void clear() {
        this.messages.clear();
        this.msgMapping.clear();
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public void offer(PersistentQueue$HasId persistentQueue$HasId) {
        Object object = persistentQueue$HasId.getId();
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            object = this.msgMapping;
            String string2 = persistentQueue$HasId.getId();
            object.put(string2, persistentQueue$HasId);
        }
        this.messages.offer(persistentQueue$HasId);
    }

    public PersistentQueue$HasId poll() {
        return (PersistentQueue$HasId)this.messages.poll();
    }

    public PersistentQueue$HasId poll(String object) {
        Map map;
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2 && (bl2 = (map = this.msgMapping).containsKey(object))) {
            object = (PersistentQueue$HasId)this.msgMapping.remove(object);
            this.messages.remove(object);
            return object;
        }
        return this.poll();
    }
}

