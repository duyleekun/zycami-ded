/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.AsyncTask
 *  android.text.TextUtils
 *  org.apache.http.conn.ConnectTimeoutException
 *  org.json.JSONObject
 */
package com.huawei.updatesdk.a.b.c;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.b.b$a;
import com.huawei.updatesdk.a.a.d.g;
import com.huawei.updatesdk.a.b.c.c.a;
import com.huawei.updatesdk.a.b.c.c.c;
import com.huawei.updatesdk.a.b.c.c.d;
import com.huawei.updatesdk.a.b.c.c.d$a;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.concurrent.Executor;
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONObject;

public class b
extends AsyncTask {
    public c a = null;
    private d b = null;
    private a c = null;
    private com.huawei.updatesdk.a.a.b.b d = null;
    private int e = 0;

    public b(c c10, a a10) {
        this.a = c10;
        this.c = a10;
    }

    private d a(String string2, d d10) {
        Object object = new JSONObject(string2);
        d10.fromJson((JSONObject)object);
        string2 = null;
        try {
            d10.b(0);
        }
        catch (Exception exception) {
            object = "StoreTask";
            String string3 = "parse json error";
            com.huawei.updatesdk.a.a.c.a.a.a.a((String)object, string3, exception);
        }
        return d10;
    }

    private void a(d d10, int n10, d$a d$a, Throwable throwable) {
        if (d10 != null) {
            d10.b(n10);
            d10.a(d$a);
            String string2 = throwable.toString();
            d10.a(string2);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a(d var1_1, Throwable var2_2, String var3_3) {
        block6: {
            block10: {
                block9: {
                    block8: {
                        block7: {
                            var4_4 = var2_2 instanceof ConnectException;
                            var5_5 = 1;
                            if (var4_4) {
                                var6_6 = d$a.f;
lbl5:
                                // 6 sources

                                while (true) {
                                    this.a((d)var1_1, var5_5, var6_6, var2_2);
                                    break block6;
                                    break;
                                }
                            }
                            var4_4 = var2_2 instanceof SocketTimeoutException;
                            if (!var4_4 && !(var4_4 = var2_2 instanceof ConnectTimeoutException)) break block7;
                            var6_6 = d$a.f;
                            var5_5 = 2;
                            ** GOTO lbl5
                        }
                        var4_4 = var2_2 instanceof IllegalArgumentException;
                        if (!var4_4) break block8;
                        var6_6 = d$a.d;
                        var5_5 = 5;
                        ** GOTO lbl5
                    }
                    var4_4 = var2_2 instanceof IllegalAccessException;
                    if (!var4_4) break block9;
                    var6_6 = d$a.g;
                    ** GOTO lbl5
                }
                var4_4 = var2_2 instanceof ArrayIndexOutOfBoundsException;
                if (!var4_4) break block10;
                var6_6 = d$a.h;
                var5_5 = 6;
                ** GOTO lbl5
            }
            var4_4 = var2_2 instanceof InterruptedException;
            if (!var4_4 && !(var4_4 = var2_2 instanceof InterruptedIOException)) {
                var4_4 = var2_2 instanceof IOException;
                if (var4_4) {
                    var6_6 = d$a.e;
                    ** continue;
                }
                if (var1_1 != null) {
                    var6_7 = var2_2.toString();
                    var1_1.a(var6_7);
                }
            } else {
                var6_8 /* !! */  = d$a.a;
                var5_5 = 0;
                this.a((d)var1_1, 0, var6_8 /* !! */ , var2_2);
                var1_1 = "StoreTask";
                var6_8 /* !! */  = "UpdateSDK task is canceled";
                com.huawei.updatesdk.a.a.a.a((String)var1_1, (String)var6_8 /* !! */ );
            }
        }
        this.a(var3_3, var2_2);
    }

    private void a(String charSequence, Throwable serializable) {
        CharSequence charSequence2 = new StringBuilder();
        charSequence2.append("invoke store error");
        charSequence2.append(", exceptionType:");
        String string2 = serializable.getClass().getName();
        charSequence2.append(string2);
        charSequence2.append(", url:");
        charSequence2.append((String)charSequence);
        charSequence2.append(", method:");
        charSequence = this.a.b();
        charSequence2.append((String)charSequence);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(", retryTimes:");
        int n10 = this.e;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence2.append((String)charSequence);
        charSequence = charSequence2.toString();
        charSequence2 = "StoreTask";
        com.huawei.updatesdk.a.a.c.a.a.a.a((String)charSequence2, (String)charSequence, (Throwable)serializable);
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("UpdateSDK call store error: ");
        ((StringBuilder)serializable).append((String)charSequence);
        charSequence = ((StringBuilder)serializable).toString();
        com.huawei.updatesdk.a.a.a.a((String)charSequence2, (String)charSequence);
    }

    private boolean a(String string2) {
        boolean bl2;
        boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl3 && (bl2 = g.d(string2))) {
            bl2 = false;
            string2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    /*
     * WARNING - void declaration
     */
    private void b(d d10) {
        Object object;
        Object object2 = "notifyResult, create response error, method:";
        boolean bl2 = this.isCancelled();
        if (!bl2 && (object = this.c) != null) {
            if (d10 == null) {
                block9: {
                    void var5_8;
                    StringBuilder stringBuilder;
                    object = "StoreTask";
                    Object object3 = "notifyResult, response is null";
                    com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, (String)object3);
                    object3 = this.a;
                    object3 = ((c)object3).b();
                    try {
                        d10 = com.huawei.updatesdk.a.b.c.a.a((String)object3);
                        break block9;
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        stringBuilder = new StringBuilder();
                    }
                    catch (InstantiationException instantiationException) {
                        stringBuilder = new StringBuilder();
                    }
                    stringBuilder.append((String)object2);
                    object2 = this.a.b();
                    stringBuilder.append((String)object2);
                    object2 = stringBuilder.toString();
                    com.huawei.updatesdk.a.a.c.a.a.a.a((String)object, (String)object2, (Throwable)var5_8);
                }
                if (d10 == null) {
                    d10 = new d();
                    object2 = d$a.d;
                } else {
                    object2 = d$a.g;
                }
                d10.a((d$a)((Object)object2));
                int n10 = 1;
                d10.b(n10);
            }
            object2 = this.c;
            object = this.a;
            object2.b((c)object, d10);
        }
    }

    private void b(String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "StoreTask";
        string2 = bl2 ? "UpdateSDK response error, resData == null" : "UpdateSDK response error, resData is not json string";
        com.huawei.updatesdk.a.a.a.a(string3, string2);
    }

    private boolean c(d object) {
        int n10;
        int n11;
        int n12 = this.isCancelled();
        int n13 = 0;
        if (n12) {
            return false;
        }
        n12 = ((d)object).d();
        if (n12 != (n11 = 1) && (n12 = ((d)object).d()) != (n10 = 2)) {
            return false;
        }
        n12 = this.e;
        n10 = n12 + 1;
        this.e = n10;
        n10 = 3;
        String string2 = "StoreTask";
        String string3 = ",response.responseCode = ";
        if (n12 >= n10) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("retry completed total times = ");
            n11 = this.e;
            stringBuilder.append(n11);
            stringBuilder.append(string3);
            int n14 = ((d)object).d();
            stringBuilder.append(n14);
            object = stringBuilder.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.a(string2, (String)object);
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("retry times = ");
        n13 = this.e;
        stringBuilder.append(n13);
        stringBuilder.append(string3);
        int n15 = ((d)object).d();
        stringBuilder.append(n15);
        object = stringBuilder.toString();
        com.huawei.updatesdk.a.a.c.a.a.a.a(string2, (String)object);
        return n11 != 0;
    }

    private String d() {
        String string2 = com.huawei.updatesdk.b.g.a.a();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = "Android/1.0";
        }
        return string2;
    }

    private void e() {
        d d10 = this.b;
        this.b(d10);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public d a() {
        Object object;
        int n10;
        block10: {
            void var1_10;
            Object object2;
            String string2;
            block9: {
                String string3 = ", body:";
                string2 = ", url:";
                String string4 = "StoreTask";
                n10 = 5;
                object2 = null;
                try {
                    object = this.a;
                    object = ((c)object).b();
                    object = com.huawei.updatesdk.a.b.c.a.a((String)object);
                }
                catch (Throwable throwable) {
                    string2 = null;
                    break block9;
                }
                try {
                    Object object3 = com.huawei.updatesdk.a.b.a.a.c();
                    object3 = ((com.huawei.updatesdk.a.b.a.a)object3).a();
                    boolean bl2 = com.huawei.updatesdk.a.a.d.i.a.d((Context)object3);
                    if (!bl2) {
                        int n11 = 3;
                        ((d)object).b(n11);
                        d$a d$a = d$a.b;
                        ((d)object).a(d$a);
                        break block10;
                    }
                    object3 = this.a;
                    object3 = ((c)object3).a();
                    Object object4 = this.a;
                    object2 = ((c)object4).d();
                    object4 = new StringBuilder();
                    Object object5 = "callStore, method:";
                    ((StringBuilder)object4).append((String)object5);
                    object5 = this.a;
                    object5 = ((c)object5).b();
                    ((StringBuilder)object4).append((String)object5);
                    ((StringBuilder)object4).append(string2);
                    ((StringBuilder)object4).append((String)object2);
                    ((StringBuilder)object4).append(string3);
                    ((StringBuilder)object4).append((String)object3);
                    object4 = ((StringBuilder)object4).toString();
                    com.huawei.updatesdk.a.a.c.a.a.a.a(string4, (String)object4);
                    this.d = object4 = new com.huawei.updatesdk.a.a.b.b();
                    String string5 = "UTF-8";
                    String string6 = this.d();
                    object5 = com.huawei.updatesdk.a.b.a.a.c();
                    Context context = ((com.huawei.updatesdk.a.b.a.a)object5).a();
                    object5 = object2;
                    Object object6 = object3;
                    object4 = ((com.huawei.updatesdk.a.a.b.b)object4).a((String)object2, (String)object3, string5, string6, context);
                    object5 = ((b$a)object4).b();
                    int n12 = ((b$a)object4).a();
                    ((d)object).a(n12);
                    object6 = new StringBuilder();
                    string5 = "UpdateSDK call store responsecode: ";
                    ((StringBuilder)object6).append(string5);
                    int n13 = ((d)object).b();
                    ((StringBuilder)object6).append(n13);
                    object6 = ((StringBuilder)object6).toString();
                    com.huawei.updatesdk.a.a.a.b(string4, (String)object6);
                    int n14 = ((b$a)object4).a();
                    if ((n14 /= 100) == n10) {
                        boolean bl3 = false;
                        Object var1_3 = null;
                        ((d)object).b(0);
                        return object;
                    }
                    n14 = (int)(this.a((String)object5) ? 1 : 0);
                    if (n14 != 0) {
                        int n15 = 1;
                        ((d)object).b(n15);
                        d$a d$a = d$a.c;
                        ((d)object).a(d$a);
                        this.b((String)object5);
                        break block10;
                    } else {
                        object = this.a((String)object5, (d)object);
                        object4 = new StringBuilder();
                        object5 = "callStore response, method:";
                        ((StringBuilder)object4).append((String)object5);
                        object5 = this.a;
                        object5 = ((c)object5).b();
                        ((StringBuilder)object4).append((String)object5);
                        ((StringBuilder)object4).append(string2);
                        ((StringBuilder)object4).append((String)object2);
                        ((StringBuilder)object4).append(string3);
                        ((StringBuilder)object4).append((String)object3);
                        String string7 = ", Receive Json msg:";
                        ((StringBuilder)object4).append(string7);
                        String string8 = ((com.huawei.updatesdk.a.b.c.c.b)object).toJson();
                        ((StringBuilder)object4).append(string8);
                        String string9 = ((StringBuilder)object4).toString();
                        com.huawei.updatesdk.a.a.c.a.a.a.a(string4, string9);
                    }
                    break block10;
                }
                catch (Throwable throwable) {
                    string2 = object2;
                    object2 = object;
                }
            }
            this.a((d)object2, (Throwable)var1_10, string2);
            object = object2;
        }
        if (object == null) {
            object = new d();
            ((d)object).b(n10);
            d$a d$a = d$a.d;
            ((d)object).a(d$a);
        }
        return object;
    }

    public d a(c ... object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("doInBackground, method:");
        Object object2 = this.a.b();
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", (String)object);
        com.huawei.updatesdk.b.g.b.a(this);
        object = this.c();
        object2 = this.c;
        if (object2 != null) {
            c c10 = this.a;
            object2.a(c10, (d)object);
        }
        return object;
    }

    public void a(d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("onPostExecute, method:");
        String string2 = this.a.b();
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        com.huawei.updatesdk.a.a.c.a.a.a.a("StoreTask", (String)object);
        com.huawei.updatesdk.b.g.b.a().remove((Object)this);
        this.e();
    }

    public final void a(Executor executor) {
        c c10 = this.a;
        Object[] objectArray = new c[]{c10};
        this.executeOnExecutor(executor, objectArray);
    }

    public void b() {
        com.huawei.updatesdk.a.a.b.b b10 = this.d;
        if (b10 != null) {
            b10.a();
            b10 = null;
            this.d = null;
        }
    }

    public final d c() {
        int n10;
        int n11 = 0;
        Object object = null;
        do {
            if ((n10 = this.e) <= 0 || object == null) continue;
            CharSequence charSequence = new StringBuilder();
            String string2 = "call store error! responseCode:";
            charSequence.append(string2);
            n11 = ((d)object).d();
            charSequence.append(n11);
            charSequence.append(", retryTimes:");
            n11 = this.e;
            charSequence.append(n11);
            object = charSequence.toString();
            charSequence = "StoreTask";
            com.huawei.updatesdk.a.a.c.a.a.a.a((String)charSequence, (String)object);
        } while ((n10 = (int)(this.c((d)(object = this.a())) ? 1 : 0)) != 0);
        this.b = object;
        return object;
    }
}

