/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.NetworkUtil;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.c.b.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.k;
import com.huawei.hms.framework.network.grs.c.l;
import com.huawei.hms.framework.network.grs.d.d;
import com.huawei.hms.framework.network.grs.d.d$a;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;

public class m {
    private ExecutorService a;
    private Map b;
    private final Object c;
    private a d;

    public m() {
        Object object = ExecutorsUtils.newCachedThreadPool("GRS_RequestController-Task");
        this.a = object;
        object = new ConcurrentHashMap(16);
        this.b = object;
        this.c = object = new Object();
    }

    public static /* synthetic */ ExecutorService a(m m10) {
        return m10.a;
    }

    private void a(f object, com.huawei.hms.framework.network.grs.b b10) {
        if (b10 != null) {
            String string2 = "RequestController";
            if (object == null) {
                object = "GrsResponse is null";
                Logger.v(string2, object);
                b10.a();
            } else {
                String string3 = "GrsResponse is not null";
                Logger.v(string2, string3);
                b10.a((f)object);
            }
        }
    }

    public static /* synthetic */ void a(m m10, f f10, com.huawei.hms.framework.network.grs.b b10) {
        m10.a(f10, b10);
    }

    public static /* synthetic */ a b(m m10) {
        return m10.d;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public f a(c future, String object, com.huawei.hms.framework.network.grs.a.c object2) {
        void var1_5;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("request to server with service name is: ");
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        Logger.d("RequestController", object3);
        object3 = ((c)((Object)future)).b();
        Object object4 = ((c)((Object)future)).a();
        boolean bl2 = false;
        boolean bl3 = true;
        object3 = ((GrsBaseInfo)object3).getGrsParasTag(false, bl3, (Context)object4);
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("request spUrlKey: ");
        ((StringBuilder)object4).append((String)object3);
        object4 = ((StringBuilder)object4).toString();
        Object object5 = "RequestController";
        Logger.v((String)object5, object4);
        object4 = this.c;
        synchronized (object4) {
            boolean bl4;
            object5 = ((c)((Object)future)).a();
            bl2 = NetworkUtil.isNetworkAvailable((Context)object5);
            bl3 = false;
            if (!bl2) {
                return null;
            }
            object5 = com.huawei.hms.framework.network.grs.d.d.a((String)object3);
            Object object6 = this.b;
            object6 = object6.get(object3);
            if ((object6 = (b)object6) != null && (bl4 = ((b)object6).b())) {
                future = ((b)object6).a();
            } else {
                if (object5 != null && (bl2 = ((d$a)object5).a())) {
                    return null;
                }
                object5 = "RequestController";
                object6 = "hitGrsRequestBean == null or request block is released.";
                Logger.d((String)object5, object6);
                object5 = this.a;
                object6 = new k(this, (c)((Object)future), (String)object, (com.huawei.hms.framework.network.grs.a.c)object2);
                future = object5.submit(object6);
                object = this.b;
                object2 = new b(future);
                object.put(object3, object2);
            }
        }
        try {
            future = future.get();
            return (f)((Object)future);
        }
        catch (InterruptedException interruptedException) {
            object = "RequestController";
            object2 = "when check result, find InterruptedException, check others";
        }
        catch (ExecutionException executionException) {
            object = "RequestController";
            object2 = "when check result, find ExecutionException, check others";
        }
        catch (CancellationException cancellationException) {
            object = "RequestController";
            object2 = "when check result, find CancellationException, check others";
        }
        Logger.w((String)object, (String)object2, (Throwable)var1_5);
        return null;
    }

    public void a(a a10) {
        this.d = a10;
    }

    public void a(c c10, com.huawei.hms.framework.network.grs.b b10, String string2, com.huawei.hms.framework.network.grs.a.c c11) {
        ExecutorService executorService = this.a;
        l l10 = new l(this, c10, string2, c11, b10);
        executorService.execute(l10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(String string2) {
        Object object = this.c;
        synchronized (object) {
            Map map = this.b;
            map.remove(string2);
            return;
        }
    }
}

