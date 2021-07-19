/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ExecutorsUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.framework.network.grs.IQueryUrlsCallBack;
import com.huawei.hms.framework.network.grs.a.a;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class d {
    private static final String a = "d";
    private static ExecutorService b = ExecutorsUtils.newCachedThreadPool("GRS_GrsClient-Init");
    private GrsBaseInfo c;
    private boolean d = false;
    private final Object e;
    private Context f;
    private m g;
    private a h;
    private c i;
    private c j;
    private com.huawei.hms.framework.network.grs.a k;
    private Future l;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public d(Context object, GrsBaseInfo grsBaseInfo) {
        Context context;
        Object object2;
        this.e = object2 = new Object();
        this.f = context = object.getApplicationContext();
        this.a(grsBaseInfo);
        boolean bl2 = this.d;
        if (bl2) return;
        synchronized (object2) {
            bl2 = this.d;
            if (bl2) return;
            grsBaseInfo = this.c;
            context = this.f;
            ExecutorService executorService = b;
            com.huawei.hms.framework.network.grs.c c10 = new com.huawei.hms.framework.network.grs.c(this, context, grsBaseInfo, (Context)object);
            object = executorService.submit(c10);
            this.l = object;
            return;
        }
    }

    public d(GrsBaseInfo grsBaseInfo) {
        Object object;
        this.e = object = new Object();
        this.a(grsBaseInfo);
    }

    public static /* synthetic */ a a(d d10, a a10) {
        d10.h = a10;
        return a10;
    }

    public static /* synthetic */ c a(d d10, c c10) {
        d10.i = c10;
        return c10;
    }

    public static /* synthetic */ com.huawei.hms.framework.network.grs.a a(d d10, com.huawei.hms.framework.network.grs.a a10) {
        d10.k = a10;
        return a10;
    }

    public static /* synthetic */ m a(d d10) {
        return d10.g;
    }

    public static /* synthetic */ m a(d d10, m m10) {
        d10.g = m10;
        return m10;
    }

    public static /* synthetic */ String a() {
        return a;
    }

    private void a(GrsBaseInfo grsBaseInfo) {
        GrsBaseInfo grsBaseInfo2 = grsBaseInfo.clone();
        try {
            this.c = grsBaseInfo2;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            String string2 = a;
            String string3 = "GrsClient catch CloneNotSupportedException";
            Logger.w(string2, string3, cloneNotSupportedException);
            this.c = grsBaseInfo = grsBaseInfo.copy();
        }
    }

    public static /* synthetic */ void a(d d10, Map map) {
        d10.a(map);
    }

    private void a(Map object) {
        boolean bl2;
        if (object != null && !(bl2 = object.isEmpty())) {
            object = object.keySet().iterator();
            while (bl2 = object.hasNext()) {
                Object object2;
                String string2 = (String)object.next();
                int n10 = string2.endsWith((String)(object2 = "time"));
                if (n10 == 0) continue;
                object2 = this.i;
                Object object3 = "";
                object2 = ((c)object2).a(string2, (String)object3);
                boolean bl3 = TextUtils.isEmpty((CharSequence)object2);
                long l10 = 0L;
                if (!bl3 && (bl3 = ((String)object2).matches((String)(object3 = "\\d+")))) {
                    try {
                        l10 = Long.parseLong((String)object2);
                    }
                    catch (NumberFormatException numberFormatException) {
                        object3 = a;
                        String string3 = "convert expire time from String to Long catch NumberFormatException.";
                        Logger.w((String)object3, string3, numberFormatException);
                    }
                }
                if ((n10 = this.a(l10)) != 0) continue;
                Logger.i(a, "init interface auto clear some invalid sp's data.");
                n10 = string2.length() + -4;
                bl3 = false;
                object2 = string2.substring(0, n10);
                object3 = this.i;
                ((c)object3).a((String)object2);
                object2 = this.i;
                ((c)object2).a(string2);
            }
            return;
        }
        Logger.v(a, "sp's content is empty.");
    }

    private boolean a(long l10) {
        long l11 = System.currentTimeMillis() - l10;
        long l12 = l11 - (l10 = 604800000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object <= 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static /* synthetic */ boolean a(d d10, boolean bl2) {
        d10.d = bl2;
        return bl2;
    }

    public static /* synthetic */ c b(d d10) {
        return d10.i;
    }

    public static /* synthetic */ c b(d d10, c c10) {
        d10.j = c10;
        return c10;
    }

    public static /* synthetic */ c c(d d10) {
        return d10.j;
    }

    public static /* synthetic */ a d(d d10) {
        return d10.h;
    }

    private boolean d() {
        boolean bl2;
        block10: {
            bl2 = false;
            Object object = this.l;
            if (object == null) break block10;
            long l10 = 10;
            TimeUnit timeUnit = TimeUnit.SECONDS;
            object = object.get(l10, timeUnit);
            object = (Boolean)object;
            try {
                bl2 = (Boolean)object;
            }
            catch (Exception exception) {
                Logger.w(a, "init compute task occur unknown Exception", exception);
                return false;
            }
            catch (TimeoutException timeoutException) {
                Logger.w(a, "init compute task timed out");
                return false;
            }
            catch (InterruptedException interruptedException) {
                Logger.w(a, "init compute task interrupted.", interruptedException);
                return false;
            }
            catch (ExecutionException executionException) {
                Logger.w(a, "init compute task failed.", executionException);
                return false;
            }
            catch (CancellationException cancellationException) {
                Logger.i(a, "init compute task canceled.");
                return false;
            }
        }
        return bl2;
    }

    public static /* synthetic */ GrsBaseInfo e(d d10) {
        return d10.c;
    }

    public String a(String string2, String string3) {
        Object object = this.c;
        Context context = null;
        if (object != null && string2 != null && string3 != null) {
            boolean bl2 = this.d();
            if (bl2) {
                object = this.k;
                context = this.f;
                return ((com.huawei.hms.framework.network.grs.a)object).a(string2, string3, context);
            }
            return null;
        }
        Logger.w(a, "invalid para!");
        return null;
    }

    public Map a(String hashMap) {
        Object object = this.c;
        if (object != null && hashMap != null) {
            boolean bl2 = this.d();
            if (bl2) {
                object = this.k;
                Context context = this.f;
                return ((com.huawei.hms.framework.network.grs.a)object).a((String)((Object)hashMap), context);
            }
            hashMap = new HashMap();
            return hashMap;
        }
        Logger.w(a, "invalid para!");
        hashMap = new HashMap();
        return hashMap;
    }

    public void a(String string2, IQueryUrlsCallBack iQueryUrlsCallBack) {
        if (iQueryUrlsCallBack == null) {
            Logger.w(a, "IQueryUrlsCallBack is must not null for process continue.");
            return;
        }
        Object object = this.c;
        if (object != null && string2 != null) {
            boolean bl2 = this.d();
            if (bl2) {
                object = this.k;
                Context context = this.f;
                ((com.huawei.hms.framework.network.grs.a)object).a(string2, iQueryUrlsCallBack, context);
            }
            return;
        }
        iQueryUrlsCallBack.onCallBackFail(-6);
    }

    public void a(String string2, String string3, IQueryUrlCallBack iQueryUrlCallBack) {
        if (iQueryUrlCallBack == null) {
            Logger.w(a, "IQueryUrlCallBack is must not null for process continue.");
            return;
        }
        Object object = this.c;
        if (object != null && string2 != null && string3 != null) {
            boolean bl2 = this.d();
            if (bl2) {
                object = this.k;
                Context context = this.f;
                ((com.huawei.hms.framework.network.grs.a)object).a(string2, string3, iQueryUrlCallBack, context);
            }
            return;
        }
        iQueryUrlCallBack.onCallBackFail(-6);
    }

    public boolean a(Object object) {
        boolean bl2;
        Class<?> clazz;
        Class<d> clazz2;
        if (this == object) {
            return true;
        }
        GrsBaseInfo grsBaseInfo = null;
        if (object != null && (clazz2 = d.class) == (clazz = object.getClass()) && (bl2 = object instanceof d)) {
            object = (d)object;
            grsBaseInfo = this.c;
            object = ((d)object).c;
            return grsBaseInfo.compare(object);
        }
        return false;
    }

    public void b() {
        boolean bl2 = this.d();
        if (!bl2) {
            return;
        }
        Object object = this.c;
        Object object2 = this.f;
        object = ((GrsBaseInfo)object).getGrsParasKey(false, true, (Context)object2);
        this.i.a((String)object);
        object2 = this.i;
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)object);
        charSequence.append("time");
        charSequence = charSequence.toString();
        ((c)object2).a((String)charSequence);
        this.g.a((String)object);
    }

    public boolean c() {
        Context context;
        boolean bl2 = this.d();
        if (!bl2) {
            return false;
        }
        GrsBaseInfo grsBaseInfo = this.c;
        if (grsBaseInfo != null && (context = this.f) != null) {
            this.h.a(grsBaseInfo, context);
            return true;
        }
        return false;
    }
}

