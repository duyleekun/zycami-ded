/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.cache.SystemSetting;
import cn.leancloud.core.AppConfiguration;
import cn.leancloud.json.JSON;
import cn.leancloud.utils.StringUtil;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PersistentQueue
implements Queue {
    private static final String MESSAGE_ZONE = "com.avoscloud.chat.message";
    private static final String QUEUE_KEY = "com.avoscloud.chat.message.queue";
    public Queue messages;
    private final String queueKey;
    private final Class type;

    public PersistentQueue(String object, Class object2) {
        boolean bl2;
        Object object3 = new ConcurrentLinkedQueue();
        this.messages = object3;
        this.type = object2;
        object3 = "com.avoscloud.chat.message.queue.";
        ((StringBuilder)object2).append((String)object3);
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        this.queueKey = object;
        object = this.restoreMessageQueue();
        if (object != null && !(bl2 = ((AbstractCollection)object).isEmpty())) {
            object2 = this.messages;
            object2.addAll(object);
        }
    }

    private LinkedList restoreMessageQueue() {
        synchronized (this) {
            block14: {
                LinkedList linkedList = new LinkedList();
                SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
                Object object = MESSAGE_ZONE;
                Object object2 = this.queueKey;
                object = systemSetting.getString((String)object, (String)object2, null);
                boolean bl2 = StringUtil.isEmpty((String)object);
                if (bl2) break block14;
                object2 = this.type;
                object = JSON.parseArray((String)object, (Class)object2);
                linkedList.addAll(object);
            }
            finally {
            }
        }
    }

    private void storeMessageQueue() {
        String string2 = JSON.toJSONString(this.messages);
        SystemSetting systemSetting = AppConfiguration.getDefaultSetting();
        String string3 = this.queueKey;
        systemSetting.saveString(MESSAGE_ZONE, string3, string2);
    }

    public boolean add(Object object) {
        boolean bl2 = this.messages.add(object);
        this.storeMessageQueue();
        return bl2;
    }

    public boolean addAll(Collection collection) {
        boolean bl2 = this.messages.addAll(collection);
        this.storeMessageQueue();
        return bl2;
    }

    public void clear() {
        this.messages.clear();
        this.storeMessageQueue();
    }

    public boolean contains(Object object) {
        return this.messages.contains(object);
    }

    public boolean containsAll(Collection collection) {
        return this.messages.containsAll(collection);
    }

    public Object element() {
        Object e10 = this.messages.element();
        this.storeMessageQueue();
        return e10;
    }

    public boolean isEmpty() {
        return this.messages.isEmpty();
    }

    public Iterator iterator() {
        return this.messages.iterator();
    }

    public boolean offer(Object object) {
        boolean bl2 = this.messages.offer(object);
        this.storeMessageQueue();
        return bl2;
    }

    public Object peek() {
        return this.messages.peek();
    }

    public Object poll() {
        Object e10 = this.messages.poll();
        this.storeMessageQueue();
        return e10;
    }

    public Object remove() {
        Object e10 = this.messages.remove();
        this.storeMessageQueue();
        return e10;
    }

    public boolean remove(Object object) {
        boolean bl2 = this.messages.remove(object);
        this.storeMessageQueue();
        return bl2;
    }

    public boolean removeAll(Collection collection) {
        boolean bl2 = this.messages.removeAll(collection);
        this.storeMessageQueue();
        return bl2;
    }

    public boolean retainAll(Collection collection) {
        boolean bl2 = this.messages.retainAll(collection);
        this.storeMessageQueue();
        return bl2;
    }

    public int size() {
        return this.messages.size();
    }

    public Object[] toArray() {
        return this.messages.toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return this.messages.toArray(objectArray);
    }
}

