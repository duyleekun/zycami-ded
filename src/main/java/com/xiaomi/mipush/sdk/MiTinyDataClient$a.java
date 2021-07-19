/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.MiTinyDataClient$a$a;
import com.xiaomi.mipush.sdk.aq;
import com.xiaomi.mipush.sdk.b;
import com.xiaomi.push.hq;
import com.xiaomi.push.service.an;
import com.xiaomi.push.service.bi;
import java.io.Serializable;
import java.util.ArrayList;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class MiTinyDataClient$a {
    private static volatile MiTinyDataClient$a a;
    private Context a;
    private MiTinyDataClient$a$a a;
    private Boolean a;
    private String a;
    private final ArrayList a;

    public MiTinyDataClient$a() {
        ArrayList arrayList = new ArrayList(this);
        this.a = arrayList;
        this.a = arrayList = new ArrayList();
    }

    public static /* synthetic */ Context a(MiTinyDataClient$a miTinyDataClient$a) {
        return miTinyDataClient$a.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static MiTinyDataClient$a a() {
        Object object = a;
        if (object != null) return a;
        object = MiTinyDataClient$a.class;
        synchronized (object) {
            MiTinyDataClient$a miTinyDataClient$a = a;
            if (miTinyDataClient$a != null) return a;
            a = miTinyDataClient$a = new MiTinyDataClient$a();
            return a;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(hq cloneable) {
        ArrayList arrayList = this.a;
        synchronized (arrayList) {
            ArrayList arrayList2 = this.a;
            int n10 = arrayList2.contains(cloneable);
            if (n10 == 0) {
                arrayList2 = this.a;
                arrayList2.add(cloneable);
                cloneable = this.a;
                int n11 = ((ArrayList)cloneable).size();
                n10 = 100;
                if (n11 > n10) {
                    cloneable = this.a;
                    n10 = 0;
                    arrayList2 = null;
                    ((ArrayList)cloneable).remove(0);
                }
            }
            return;
        }
    }

    private boolean a(Context context) {
        boolean bl2;
        block5: {
            aq aq2 = aq.a(context);
            boolean bl3 = aq2.a();
            bl2 = true;
            if (!bl3) {
                return bl2;
            }
            context = context.getPackageManager();
            bl3 = false;
            aq2 = null;
            String string2 = "com.xiaomi.xmsf";
            int n10 = 4;
            try {
                context = context.getPackageInfo(string2, n10);
                if (context != null) break block5;
                return false;
            }
            catch (Exception exception) {
                return false;
            }
        }
        int n11 = context.versionCode;
        int n12 = 108;
        if (n11 < n12) {
            return false;
        }
        return bl2;
    }

    private boolean b(Context object) {
        boolean bl2;
        if ((object = b.a(object).a()) == null && !(bl2 = this.a((Context)(object = this.a)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private boolean b(hq hq2) {
        boolean bl2 = false;
        Object object = null;
        boolean bl3 = bi.a(hq2, false);
        if (bl3) {
            return false;
        }
        object = this.a;
        bl2 = (Boolean)object;
        if (bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("MiTinyDataClient Send item by PushServiceClient.sendTinyData(ClientUploadDataItem).");
            String string2 = hq2.d();
            ((StringBuilder)object).append(string2);
            com.xiaomi.channel.commonutils.logger.b.c(((StringBuilder)object).toString());
            object = aq.a(this.a);
            ((aq)object).a(hq2);
        } else {
            object = this.a;
            ((MiTinyDataClient$a$a)object).a(hq2);
        }
        return true;
    }

    public void a(Context object) {
        if (object == null) {
            com.xiaomi.channel.commonutils.logger.b.a("context is null, MiTinyDataClientImp.init() failed.");
            return;
        }
        this.a = object;
        object = this.a((Context)object);
        this.a = object;
        this.b("com.xiaomi.xmpushsdk.tinydataPending.init");
    }

    public void a(String string2) {
        synchronized (this) {
            block6: {
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (!bl2) break block6;
                string2 = "channel is null, MiTinyDataClientImp.setChannel(String) failed.";
                com.xiaomi.channel.commonutils.logger.b.a(string2);
                return;
            }
            this.a = string2;
            string2 = "com.xiaomi.xmpushsdk.tinydataPending.channel";
            this.b(string2);
            return;
        }
    }

    public boolean a() {
        boolean bl2;
        Context context = this.a;
        if (context != null) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean a(hq hq2) {
        synchronized (this) {
            int n10;
            block19: {
                CharSequence charSequence;
                block17: {
                    String string2;
                    int n11;
                    block18: {
                        int n12;
                        block16: {
                            boolean bl2;
                            n11 = 0;
                            charSequence = null;
                            if (hq2 == null) {
                                return false;
                            }
                            n10 = 1;
                            int n13 = bi.a(hq2, n10 != 0);
                            if (n13 != 0) {
                                return false;
                            }
                            string2 = hq2.a();
                            n13 = TextUtils.isEmpty((CharSequence)string2);
                            if (n13 != 0 && (n13 = TextUtils.isEmpty((CharSequence)(string2 = this.a))) != 0) {
                                n13 = n10;
                            } else {
                                n13 = 0;
                                string2 = null;
                            }
                            n12 = this.a();
                            n12 = n12 == 0 ? n10 : 0;
                            Context context = this.a;
                            if (context == null || (bl2 = this.b(context))) {
                                n11 = n10;
                            }
                            if (n12 == 0 && n13 == 0 && n11 == 0) {
                                long l10;
                                long l11;
                                long l12;
                                charSequence = new StringBuilder();
                                String string3 = "MiTinyDataClient Send item immediately.";
                                ((StringBuilder)charSequence).append(string3);
                                string3 = hq2.d();
                                ((StringBuilder)charSequence).append(string3);
                                charSequence = ((StringBuilder)charSequence).toString();
                                com.xiaomi.channel.commonutils.logger.b.c((String)charSequence);
                                charSequence = hq2.d();
                                n11 = TextUtils.isEmpty((CharSequence)charSequence);
                                if (n11 != 0) {
                                    charSequence = an.a();
                                    hq2.f((String)charSequence);
                                }
                                if ((n11 = TextUtils.isEmpty((CharSequence)(charSequence = hq2.a()))) != 0) {
                                    charSequence = this.a;
                                    hq2.a((String)charSequence);
                                }
                                if ((n11 = TextUtils.isEmpty((CharSequence)(charSequence = hq2.c()))) != 0) {
                                    charSequence = this.a;
                                    charSequence = charSequence.getPackageName();
                                    hq2.e((String)charSequence);
                                }
                                if ((n11 = (l12 = (l11 = hq2.a()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) return this.b(hq2);
                                l11 = System.currentTimeMillis();
                                hq2.b(l11);
                                return this.b(hq2);
                            }
                            if (n13 == 0) break block16;
                            charSequence = new StringBuilder();
                            string2 = "MiTinyDataClient Pending ";
                            ((StringBuilder)charSequence).append(string2);
                            string2 = hq2.b();
                            ((StringBuilder)charSequence).append(string2);
                            string2 = " reason is ";
                            ((StringBuilder)charSequence).append(string2);
                            string2 = "com.xiaomi.xmpushsdk.tinydataPending.channel";
                            ((StringBuilder)charSequence).append(string2);
                            charSequence = ((StringBuilder)charSequence).toString();
                            break block17;
                        }
                        if (n12 == 0) break block18;
                        charSequence = new StringBuilder();
                        string2 = "MiTinyDataClient Pending ";
                        ((StringBuilder)charSequence).append(string2);
                        string2 = hq2.b();
                        ((StringBuilder)charSequence).append(string2);
                        string2 = " reason is ";
                        ((StringBuilder)charSequence).append(string2);
                        string2 = "com.xiaomi.xmpushsdk.tinydataPending.init";
                        ((StringBuilder)charSequence).append(string2);
                        charSequence = ((StringBuilder)charSequence).toString();
                        break block17;
                    }
                    if (n11 == 0) break block19;
                    charSequence = new StringBuilder();
                    string2 = "MiTinyDataClient Pending ";
                    ((StringBuilder)charSequence).append(string2);
                    string2 = hq2.b();
                    ((StringBuilder)charSequence).append(string2);
                    string2 = " reason is ";
                    ((StringBuilder)charSequence).append(string2);
                    string2 = "com.xiaomi.xmpushsdk.tinydataPending.appId";
                    ((StringBuilder)charSequence).append(string2);
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                com.xiaomi.channel.commonutils.logger.b.c((String)charSequence);
            }
            this.a(hq2);
            return n10 != 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void b(String object) {
        Serializable serializable = new StringBuilder();
        Object object2 = "MiTinyDataClient.processPendingList(";
        serializable.append((String)object2);
        serializable.append((String)object);
        serializable.append(")");
        com.xiaomi.channel.commonutils.logger.b.c(serializable.toString());
        object = new ArrayList();
        serializable = this.a;
        synchronized (serializable) {
            object2 = this.a;
            ((ArrayList)object).addAll(object2);
            object2 = this.a;
            ((ArrayList)object2).clear();
        }
        object = ((ArrayList)object).iterator();
        boolean bl2;
        while (bl2 = object.hasNext()) {
            serializable = (hq)object.next();
            this.a((hq)serializable);
        }
        return;
    }
}

