/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.session;

import cn.leancloud.session.PersistentQueue;
import cn.leancloud.utils.StringUtil;

public class StaleMessageDepot {
    private static final int MAXLENGTH = 50;
    public PersistentQueue messageDepot;

    public StaleMessageDepot(String string2) {
        PersistentQueue persistentQueue;
        this.messageDepot = persistentQueue = new PersistentQueue(string2, String.class);
    }

    public boolean putStableMessage(String object) {
        synchronized (this) {
            int n10;
            int n11;
            block12: {
                block11: {
                    boolean n112 = StringUtil.isEmpty((String)object);
                    boolean bl2 = true;
                    if (!n112) break block11;
                    return bl2;
                }
                PersistentQueue persistentQueue = this.messageDepot;
                n11 = persistentQueue.contains(object);
                if (n11 != 0) break block12;
                PersistentQueue persistentQueue2 = this.messageDepot;
                persistentQueue2.offer(object);
                while (true) {
                    object = this.messageDepot;
                    break;
                }
                {
                    n10 = ((PersistentQueue)object).size();
                    int n12 = 50;
                    if (n10 <= n12) break;
                    object = this.messageDepot;
                    ((PersistentQueue)object).poll();
                    continue;
                }
            }
            n10 = n11 ^ 1;
            return n10 != 0;
        }
    }
}

