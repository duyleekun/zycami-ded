/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.text.TextUtils
 *  org.json.JSONArray
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.c.a;
import com.huawei.hms.framework.network.grs.c.b;
import com.huawei.hms.framework.network.grs.c.b.c;
import com.huawei.hms.framework.network.grs.c.d;
import com.huawei.hms.framework.network.grs.c.f;
import com.huawei.hms.framework.network.grs.c.h;
import com.huawei.hms.framework.network.grs.d.d$a;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;

public class e
implements a {
    private static final String a = "e";
    private GrsBaseInfo b;
    private Context c;
    private com.huawei.hms.framework.network.grs.a.a d;
    private f e;
    private ArrayList f;
    private ArrayList g;
    private JSONArray h;
    private ArrayList i;
    private ArrayList j;
    private com.huawei.hms.framework.network.grs.c.b.d k;
    private c l;
    private long m;

    public e(c c10, com.huawei.hms.framework.network.grs.a.a a10) {
        Object object;
        this.f = object = new ArrayList();
        this.g = object = new ArrayList();
        this.h = object = new JSONArray();
        this.i = object;
        super();
        this.j = object;
        this.m = 1L;
        this.l = c10;
        object = c10.b();
        this.b = object;
        c10 = c10.a();
        this.c = c10;
        this.d = a10;
        this.b();
    }

    public static /* synthetic */ f a(e e10, ExecutorService executorService, String string2, com.huawei.hms.framework.network.grs.a.c c10) {
        return e10.b(executorService, string2, c10);
    }

    /*
     * Loose catch block
     */
    private f a(ExecutorService executorService, ArrayList arrayList, String string2, com.huawei.hms.framework.network.grs.a.c c10) {
        e e10 = this;
        int n10 = 0;
        Object object = null;
        Object object2 = null;
        for (int i10 = 0; i10 < (n10 = arrayList.size()); ++i10) {
            Object object3;
            boolean bl2;
            block23: {
                block24: {
                    block22: {
                        Object object4;
                        block21: {
                            String string3;
                            block20: {
                                block19: {
                                    block18: {
                                        block17: {
                                            block16: {
                                                object4 = object = (Object)arrayList.get(i10);
                                                object4 = (String)object;
                                                n10 = (int)(TextUtils.isEmpty((CharSequence)object4) ? 1 : 0);
                                                bl2 = true;
                                                if (n10 != 0) break block22;
                                                Context context = e10.c;
                                                GrsBaseInfo grsBaseInfo = e10.b;
                                                object3 = object;
                                                Object object5 = this;
                                                object = new b((String)object4, i10, this, context, string2, grsBaseInfo, c10);
                                                object = ((b)object).g();
                                                object3 = executorService;
                                                object = executorService.submit(object);
                                                object4 = e10.f;
                                                ((ArrayList)object4).add(object);
                                                long l10 = e10.m;
                                                object5 = TimeUnit.SECONDS;
                                                object4 = object = object.get(l10, (TimeUnit)((Object)object5));
                                                object4 = (f)object;
                                                if (object4 == null) break block16;
                                                n10 = (int)(((f)object4).m() ? 1 : 0);
                                                if (n10 == 0) break block16;
                                                object = a;
                                                string3 = "grs request return body is not null and is OK.";
                                                try {
                                                    Logger.i((String)object, string3);
                                                    break block17;
                                                }
                                                catch (TimeoutException timeoutException) {
                                                    object2 = object4;
                                                    break block18;
                                                }
                                                catch (InterruptedException interruptedException) {
                                                    object2 = object4;
                                                    break block19;
                                                }
                                                catch (ExecutionException executionException) {
                                                    object2 = object4;
                                                    break block20;
                                                }
                                                catch (CancellationException cancellationException) {
                                                    object2 = object4;
                                                    break block21;
                                                }
                                            }
                                            bl2 = false;
                                        }
                                        object2 = object4;
                                        break block23;
                                        catch (TimeoutException timeoutException) {}
                                    }
                                    object = a;
                                    object4 = "the wait timed out";
                                    Logger.w((String)object, object4);
                                    break block24;
                                    catch (InterruptedException interruptedException) {
                                        // empty catch block
                                    }
                                }
                                object4 = a;
                                string3 = "the current thread was interrupted while waiting";
                                Logger.w((String)object4, string3, (Throwable)object);
                                break block23;
                                catch (ExecutionException executionException) {
                                    // empty catch block
                                }
                            }
                            object4 = a;
                            string3 = "the computation threw an ExecutionException";
                            Logger.w((String)object4, string3, (Throwable)object);
                            break block24;
                            catch (CancellationException cancellationException) {}
                        }
                        object = a;
                        object4 = "{requestServer} the computation was cancelled";
                        Logger.i((String)object, object4);
                        break block23;
                    }
                    object3 = executorService;
                }
                bl2 = false;
            }
            if (!bl2) continue;
            object = a;
            object3 = "needBreak is true so need break current circulation";
            Logger.v((String)object, object3);
            break;
        }
        return this.b((f)object2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private f b(f object) {
        boolean bl2;
        ArrayList arrayList = this.f;
        int n10 = arrayList.size();
        for (int i10 = 0; !(i10 >= n10 || object != null && (bl2 = ((f)object).m())); ++i10) {
            String string2;
            String string3;
            Object object2;
            try {
                object2 = this.f;
                object2 = ((ArrayList)object2).get(i10);
                object2 = (Future)object2;
                long l10 = 40000L;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                object2 = object2.get(l10, timeUnit);
                object = object2 = (f)object2;
                continue;
            }
            catch (TimeoutException timeoutException) {
                object2 = a;
                string3 = "{checkResponse} when check result, find TimeoutException, cancel current request task";
                Logger.w((String)object2, string3);
                object2 = (Future)this.f.get(i10);
                bl2 = object2.isCancelled();
                if (bl2) continue;
                object2 = (Future)this.f.get(i10);
                boolean bl3 = true;
                object2.cancel(bl3);
                continue;
            }
            catch (InterruptedException interruptedException) {
                string3 = a;
                string2 = "{checkResponse} when check result, find InterruptedException, check others";
            }
            catch (ExecutionException executionException) {
                string3 = a;
                string2 = "{checkResponse} when check result, find ExecutionException, check others";
            }
            catch (CancellationException cancellationException) {
                object2 = a;
                string3 = "{checkResponse} when check result, find CancellationException, check others";
                Logger.i((String)object2, string3);
                continue;
            }
            Logger.w(string3, string2, (Throwable)object2);
        }
        return object;
    }

    private f b(ExecutorService executorService, String string2, com.huawei.hms.framework.network.grs.a.c arrayList) {
        long l10 = SystemClock.elapsedRealtime();
        Object object = this.j;
        object = this.a(executorService, (ArrayList)object, string2, (com.huawei.hms.framework.network.grs.a.c)((Object)arrayList));
        int n10 = 0;
        String string3 = null;
        int n11 = object == null ? 0 : ((f)object).b();
        String string4 = a;
        int n12 = 1;
        Object[] objectArray = new Object[n12];
        Integer n13 = n11;
        objectArray[0] = n13;
        string3 = "use 2.0 interface return http's code is\uff1a{%s}";
        Logger.v(string4, string3, objectArray);
        n10 = 404;
        if (n11 == n10 || n11 == (n10 = 401)) {
            object = this.c();
            boolean bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2 && (bl2 = TextUtils.isEmpty((CharSequence)(object = this.b.getAppName())))) {
                Logger.i(string4, "request grs server use 1.0 API must set appName,please check.");
                return null;
            }
            this.f.clear();
            Logger.i(string4, "this env has not deploy new interface,so use old interface.");
            object = this.i;
            object = this.a(executorService, (ArrayList)object, string2, (com.huawei.hms.framework.network.grs.a.c)((Object)arrayList));
        }
        long l11 = SystemClock.elapsedRealtime() - l10;
        ArrayList arrayList2 = this.g;
        arrayList = new ArrayList(arrayList2);
        arrayList2 = this.h;
        Context context = this.c;
        com.huawei.hms.framework.network.grs.c.h.a(arrayList, l11, (JSONArray)arrayList2, context);
        return object;
    }

    private void b() {
        int n10;
        Object object = com.huawei.hms.framework.network.grs.c.a.a.a(this.c);
        if (object == null) {
            Logger.w(a, "g*s***_se****er_conf*** maybe has a big error");
            return;
        }
        this.a((com.huawei.hms.framework.network.grs.c.b.d)object);
        Object[] objectArray = ((com.huawei.hms.framework.network.grs.c.b.d)object).a();
        if (objectArray != null && (n10 = objectArray.size()) > 0) {
            int n11;
            n10 = objectArray.size();
            if (n10 <= (n11 = 10)) {
                Object object2 = ((com.huawei.hms.framework.network.grs.c.b.d)object).c();
                object = ((com.huawei.hms.framework.network.grs.c.b.d)object).b();
                n11 = objectArray.size();
                int n12 = 1;
                if (n11 > 0) {
                    objectArray = objectArray.iterator();
                    while ((n11 = (int)(objectArray.hasNext() ? 1 : 0)) != 0) {
                        CharSequence charSequence;
                        Object object3 = (String)objectArray.next();
                        boolean bl2 = ((String)object3).startsWith((String)(charSequence = "https://"));
                        if (!bl2) {
                            object3 = a;
                            charSequence = "grs server just support https scheme url,please check.";
                            Logger.w((String)object3, charSequence);
                            continue;
                        }
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)object3);
                        Object object4 = Locale.ROOT;
                        Context context = new Object[n12];
                        String string2 = this.c();
                        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
                        string2 = bl3 ? this.b.getAppName() : this.c();
                        context[0] = string2;
                        object4 = String.format((Locale)object4, (String)object2, (Object[])context);
                        ((StringBuilder)charSequence).append((String)object4);
                        object4 = this.b;
                        context = this.c;
                        object4 = ((GrsBaseInfo)object4).getGrsReqParamJoint(false, false, "1.0", context);
                        boolean bl4 = TextUtils.isEmpty((CharSequence)object4);
                        string2 = "?";
                        if (!bl4) {
                            ((StringBuilder)charSequence).append(string2);
                            ((StringBuilder)charSequence).append((String)object4);
                        }
                        charSequence = ((StringBuilder)charSequence).toString();
                        this.i.add(charSequence);
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append((String)object3);
                        ((StringBuilder)charSequence).append((String)object);
                        object3 = this.b;
                        object4 = this.c();
                        context = this.c;
                        object3 = ((GrsBaseInfo)object3).getGrsReqParamJoint(false, false, (String)object4, context);
                        boolean bl5 = TextUtils.isEmpty((CharSequence)object3);
                        if (!bl5) {
                            ((StringBuilder)charSequence).append(string2);
                            ((StringBuilder)charSequence).append((String)object3);
                        }
                        object3 = this.j;
                        charSequence = ((StringBuilder)charSequence).toString();
                        ((ArrayList)object3).add(charSequence);
                    }
                }
                object = a;
                objectArray = new Object[2];
                objectArray[0] = object2 = this.i;
                objectArray[n12] = object2 = this.j;
                Logger.v((String)object, "request to GRS server url is{%s} and {%s}", objectArray);
                return;
            }
            object = new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
            throw object;
        }
        Logger.v(a, "maybe grs_base_url config with [],please check.");
    }

    private String c() {
        Object object = this.c.getPackageName();
        Object object2 = this.b;
        if ((object = (object = com.huawei.hms.framework.network.grs.b.b.a((String)object, (GrsBaseInfo)object2)) != null ? ((com.huawei.hms.framework.network.grs.b.b)object).a() : null) != null) {
            object = ((com.huawei.hms.framework.network.grs.local.model.a)object).b();
            object2 = a;
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            String string2 = "get appName from local assets is{%s}";
            Logger.v((String)object2, string2, objectArray);
        } else {
            object = "";
        }
        return object;
    }

    public com.huawei.hms.framework.network.grs.c.b.d a() {
        return this.k;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public f a(ExecutorService object, String string2, com.huawei.hms.framework.network.grs.a.c object2) {
        void var1_5;
        Object object4 = this.i;
        Object object3 = null;
        if (object4 == null) return object3;
        object4 = this.j;
        if (object4 == null) {
            return object3;
        }
        try {
            object4 = this.a();
            int n10 = object4 != null ? ((com.huawei.hms.framework.network.grs.c.b.d)object4).d() : 10;
            d d10 = new d(this, (ExecutorService)object, string2, (com.huawei.hms.framework.network.grs.a.c)object2);
            object = object.submit(d10);
            long l10 = n10;
            object4 = TimeUnit.SECONDS;
            object = object.get(l10, (TimeUnit)((Object)object4));
            return object = (f)object;
        }
        catch (Exception exception) {
            string2 = a;
            object2 = "{submitExcutorTaskWithTimeout} catch Exception";
        }
        catch (TimeoutException timeoutException) {
            object = a;
            string2 = "{submitExcutorTaskWithTimeout} the wait timed out";
            Logger.w((String)object, string2);
            return object3;
        }
        catch (InterruptedException interruptedException) {
            string2 = a;
            object2 = "{submitExcutorTaskWithTimeout} the current thread was interrupted while waiting";
        }
        catch (ExecutionException executionException) {
            string2 = a;
            object2 = "{submitExcutorTaskWithTimeout} the computation threw an ExecutionException";
        }
        catch (CancellationException cancellationException) {
            object = a;
            string2 = "{submitExcutorTaskWithTimeout} the computation was cancelled";
            Logger.i((String)object, string2);
            return object3;
        }
        Logger.w(string2, (String)object2, (Throwable)var1_5);
        return object3;
    }

    public void a(com.huawei.hms.framework.network.grs.c.b.d d10) {
        this.k = d10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(f object) {
        synchronized (this) {
            int n10;
            Object object2 = this.g;
            ((ArrayList)object2).add(object);
            object2 = this.e;
            if (object2 != null && (n10 = ((f)object2).m()) != 0) {
                object = a;
                object2 = "grsResponseResult is ok";
                Logger.v((String)object, object2);
                return;
            }
            n10 = ((f)object).l();
            int n11 = 0;
            d$a d$a = null;
            boolean bl2 = true;
            if (n10 != 0) {
                object2 = a;
                String string2 = "GRS server open 503 limiting strategy.";
                Logger.i((String)object2, string2);
                object2 = this.b;
                string2 = this.c;
                object2 = ((GrsBaseInfo)object2).getGrsParasKey(false, bl2, (Context)string2);
                long l10 = ((f)object).j();
                long l11 = SystemClock.elapsedRealtime();
                d$a = new d$a(l10, l11);
                com.huawei.hms.framework.network.grs.d.d.a((String)object2, d$a);
                return;
            }
            n10 = ((f)object).m();
            if (n10 == 0) {
                object = a;
                object2 = "grsResponseResult has exception so need return";
                Logger.v((String)object, object2);
                return;
            }
            this.e = object;
            object2 = this.d;
            Object object3 = this.b;
            Context context = this.c;
            c c10 = this.l;
            ((com.huawei.hms.framework.network.grs.a.a)object2).a((GrsBaseInfo)object3, (f)object, context, c10);
            while (n11 < (n10 = ((ArrayList)(object2 = this.f)).size())) {
                object2 = this.i;
                object2 = ((ArrayList)object2).get(n11);
                object3 = ((f)object).k();
                n10 = (int)(((String)(object2 = (String)object2)).equals(object3) ? 1 : 0);
                if (n10 == 0) {
                    object2 = this.j;
                    object2 = ((ArrayList)object2).get(n11);
                    object3 = ((f)object).k();
                    n10 = (int)(((String)(object2 = (String)object2)).equals(object3) ? 1 : 0);
                    if (n10 == 0) {
                        object2 = this.f;
                        object2 = ((ArrayList)object2).get(n11);
                        n10 = (int)((object2 = (Future)object2).isCancelled() ? 1 : 0);
                        if (n10 == 0) {
                            object2 = a;
                            object3 = "future cancel";
                            Logger.i((String)object2, object3);
                            object2 = this.f;
                            object2 = ((ArrayList)object2).get(n11);
                            object2 = (Future)object2;
                            object2.cancel(bl2);
                        }
                    }
                }
                ++n11;
            }
            return;
        }
    }
}

