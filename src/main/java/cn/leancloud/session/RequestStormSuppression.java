/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.im.AVIMOptions;
import cn.leancloud.session.AVIMOperationQueue$Operation;
import cn.leancloud.session.RequestStormSuppression$RequestCallback;
import cn.leancloud.util.WeakConcurrentHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RequestStormSuppression {
    private static volatile RequestStormSuppression _instance;
    public WeakConcurrentHashMap operations = null;

    private RequestStormSuppression() {
        WeakConcurrentHashMap weakConcurrentHashMap;
        AVIMOptions aVIMOptions = AVIMOptions.getGlobalOptions();
        int n10 = aVIMOptions.getTimeoutInSecs() * 1000;
        long l10 = n10;
        long l11 = 1000L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 < 0) {
            l10 = 10000L;
        }
        this.operations = weakConcurrentHashMap = new WeakConcurrentHashMap(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static RequestStormSuppression getInstance() {
        Object object = _instance;
        if (object != null) return _instance;
        object = RequestStormSuppression.class;
        synchronized (object) {
            RequestStormSuppression requestStormSuppression = _instance;
            if (requestStormSuppression != null) return _instance;
            _instance = requestStormSuppression = new RequestStormSuppression();
            return _instance;
        }
    }

    public void cleanup() {
        synchronized (this) {
            WeakConcurrentHashMap weakConcurrentHashMap = this.operations;
            weakConcurrentHashMap.clear();
            return;
        }
    }

    public String getCacheKey(AVIMOperationQueue$Operation object) {
        Object object2 = ((AVIMOperationQueue$Operation)object).sessionId;
        object2 = ((AVIMOperationQueue$Operation)object).operation;
        Object[] objectArray = new Object[]{object2, object2, object = ((AVIMOperationQueue$Operation)object).identifier};
        return String.format("%s/%d/%s", objectArray);
    }

    public int getCacheSize() {
        synchronized (this) {
            WeakConcurrentHashMap weakConcurrentHashMap = this.operations;
            int n10 = weakConcurrentHashMap.size();
            return n10;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean postpone(AVIMOperationQueue$Operation aVIMOperationQueue$Operation) {
        if (aVIMOperationQueue$Operation == null) {
            return false;
        }
        String string2 = this.getCacheKey(aVIMOperationQueue$Operation);
        synchronized (this) {
            WeakConcurrentHashMap weakConcurrentHashMap = this.operations;
            boolean bl2 = weakConcurrentHashMap.containsKey(string2);
            WeakConcurrentHashMap weakConcurrentHashMap2 = this.operations;
            weakConcurrentHashMap2.addElement(string2, aVIMOperationQueue$Operation);
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void release(AVIMOperationQueue$Operation iterator2, RequestStormSuppression$RequestCallback requestStormSuppression$RequestCallback) {
        if (iterator2 == null) {
            return;
        }
        iterator2 = this.getCacheKey((AVIMOperationQueue$Operation)((Object)iterator2));
        boolean bl2 = false;
        Object object = null;
        // MONITORENTER : this
        WeakConcurrentHashMap weakConcurrentHashMap = this.operations;
        boolean bl3 = weakConcurrentHashMap.containsKey(iterator2);
        if (bl3) {
            object = this.operations;
            iterator2 = ((ConcurrentHashMap)object).remove(iterator2);
            object = iterator2;
            object = (List)((Object)iterator2);
        }
        // MONITOREXIT : this
        if (object == null) return;
        if (requestStormSuppression$RequestCallback == null) return;
        iterator2 = object.iterator();
        while (bl2 = iterator2.hasNext()) {
            object = (AVIMOperationQueue$Operation)iterator2.next();
            requestStormSuppression$RequestCallback.done((AVIMOperationQueue$Operation)object);
        }
    }
}

