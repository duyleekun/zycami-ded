/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.b.f;

import com.huawei.updatesdk.b.f.a;
import com.huawei.updatesdk.b.f.b;
import java.util.ArrayList;
import java.util.List;

public final class c$a
implements a {
    private final List a;

    public c$a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, com.huawei.updatesdk.a.b.b.b b10) {
        List list = this.a;
        synchronized (list) {
            Object object = this.a;
            object = object.iterator();
            boolean bl2;
            while (bl2 = object.hasNext()) {
                Object object2 = object.next();
                object2 = (b)object2;
                object2.a(n10, b10);
            }
            return;
        }
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(b object) {
        List list = this.a;
        synchronized (list) {
            block10: {
                if (object == null) {
                    return;
                }
                Object object2 = this.a;
                boolean bl2 = object2.contains(object);
                if (bl2) break block10;
                try {
                    object2 = this.a;
                    object2.add(object);
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    block9: {
                        object = "InstallObserverManager";
                        object2 = "registerObserver IllegalArgumentException";
                        break block9;
                        catch (ClassCastException classCastException) {
                            object = "InstallObserverManager";
                            object2 = "registerObserver ClassCastException";
                            break block9;
                        }
                        catch (UnsupportedOperationException unsupportedOperationException) {
                            object = "InstallObserverManager";
                            object2 = "registerObserver UnsupportedOperationException";
                        }
                    }
                    com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, (String)object2);
                }
            }
            return;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void b(b object) {
        List list = this.a;
        // MONITORENTER : list
        List list2 = this.a;
        list2.remove(object);
        return;
        {
            catch (Throwable throwable) {
                throw throwable;
            }
            catch (UnsupportedOperationException unsupportedOperationException) {}
            object = "InstallObserverManager";
            String string2 = "unRegisterObserver UnsupportedOperationException";
            {
                com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string2);
                // MONITOREXIT : list
                return;
            }
        }
    }
}

