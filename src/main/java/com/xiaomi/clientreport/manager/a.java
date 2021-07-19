/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.Config$Builder;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.b;
import com.xiaomi.clientreport.manager.c;
import com.xiaomi.clientreport.manager.d;
import com.xiaomi.clientreport.manager.f;
import com.xiaomi.clientreport.manager.h;
import com.xiaomi.clientreport.manager.i;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.ai;
import com.xiaomi.push.ai$a;
import com.xiaomi.push.bf;
import com.xiaomi.push.bg;
import com.xiaomi.push.bh;
import com.xiaomi.push.bi;
import com.xiaomi.push.bj;
import com.xiaomi.push.bm;
import com.xiaomi.push.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a {
    private static final int a;
    private static volatile a a;
    private Context a;
    private Config a;
    private IEventProcessor a;
    private IPerfProcessor a;
    private String a;
    private HashMap a;
    private ExecutorService a;
    private HashMap b;

    static {
        int n10 = l.a();
        n10 = n10 != 0 ? 30 : 10;
        a = n10;
    }

    private a(Context context) {
        HashMap hashMap = Executors.newSingleThreadExecutor();
        this.a = hashMap;
        this.a = hashMap = new HashMap();
        this.b = hashMap = new HashMap();
        this.a = context;
    }

    private int a() {
        Object object = this.b;
        int n10 = 0;
        if (object != null) {
            int n11;
            object = ((HashMap)object).keySet().iterator();
            int n12 = 0;
            while ((n11 = object.hasNext()) != 0) {
                Object object2 = (String)object.next();
                HashMap hashMap = this.b;
                if ((object2 = (ArrayList)hashMap.get(object2)) != null) {
                    n11 = ((ArrayList)object2).size();
                } else {
                    n11 = 0;
                    object2 = null;
                }
                n12 += n11;
            }
            n10 = n12;
        }
        return n10;
    }

    public static /* synthetic */ int a(a a10) {
        return a10.a();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a(Context context) {
        Object object = a;
        if (object != null) return a;
        object = a.class;
        synchronized (object) {
            a a10 = a;
            if (a10 != null) return a;
            a = a10 = new a(context);
            return a;
        }
    }

    public static /* synthetic */ ExecutorService a(a a10) {
        return a10.a;
    }

    public static /* synthetic */ void a(a a10) {
        a10.d();
    }

    public static /* synthetic */ void a(a a10, EventClientReport eventClientReport) {
        a10.b(eventClientReport);
    }

    public static /* synthetic */ void a(a a10, PerfClientReport perfClientReport) {
        a10.b(perfClientReport);
    }

    private void a(ai$a a10, int n10) {
        ai.a(this.a).b(a10, n10);
    }

    private int b() {
        Object object = this.a;
        int n10 = 0;
        if (object != null) {
            boolean bl2;
            object = ((HashMap)object).keySet().iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                Object object2 = (String)object.next();
                Object object3 = this.a;
                if ((object2 = (HashMap)((HashMap)object3).get(object2)) == null) continue;
                object3 = ((HashMap)object2).keySet().iterator();
                while (bl3 = object3.hasNext()) {
                    Object object4 = (String)object3.next();
                    boolean bl4 = (object4 = (com.xiaomi.clientreport.data.a)((HashMap)object2).get(object4)) instanceof PerfClientReport;
                    if (!bl4) continue;
                    object4 = (PerfClientReport)object4;
                    long l10 = n10;
                    long l11 = ((PerfClientReport)object4).perfCounts;
                    n10 = (int)(l10 += l11);
                }
            }
        }
        return n10;
    }

    public static /* synthetic */ int b(a a10) {
        return a10.b();
    }

    private void b(EventClientReport object) {
        IEventProcessor iEventProcessor = this.a;
        if (iEventProcessor != null) {
            iEventProcessor.a((com.xiaomi.clientreport.data.a)object);
            int n10 = this.a();
            int n11 = 10;
            if (n10 >= n11) {
                this.d();
                object = ai.a(this.a);
                n11 = 100888;
                ((ai)object).a(n11);
            } else {
                object = new d(this);
                n11 = a;
                this.a((ai$a)object, n11);
            }
        }
    }

    private void b(PerfClientReport object) {
        IPerfProcessor iPerfProcessor = this.a;
        if (iPerfProcessor != null) {
            iPerfProcessor.a((com.xiaomi.clientreport.data.a)object);
            int n10 = this.b();
            int n11 = 10;
            if (n10 >= n11) {
                this.e();
                object = ai.a(this.a);
                n11 = 100889;
                ((ai)object).a(n11);
            } else {
                object = new f(this);
                n11 = a;
                this.a((ai$a)object, n11);
            }
        }
    }

    public static /* synthetic */ void b(a a10) {
        a10.e();
    }

    private void d() {
        IEventProcessor iEventProcessor = this.a;
        try {
            iEventProcessor.b();
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "we: ";
            stringBuilder.append(string2);
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            com.xiaomi.channel.commonutils.logger.b.d(string3);
        }
    }

    private void e() {
        IPerfProcessor iPerfProcessor = this.a;
        try {
            iPerfProcessor.b();
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "wp: ";
            stringBuilder.append(string2);
            String string3 = exception.getMessage();
            stringBuilder.append(string3);
            string3 = stringBuilder.toString();
            com.xiaomi.channel.commonutils.logger.b.d(string3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f() {
        int n10;
        int n11;
        Object object = com.xiaomi.clientreport.manager.a.a(this.a).a();
        boolean bl2 = ((Config)object).isEventUploadSwitchOpen();
        if (!bl2) {
            return;
        }
        Object object2 = this.a;
        object = new bg((Context)object2);
        object2 = com.xiaomi.clientreport.manager.a.a(this.a).a();
        long l10 = ((Config)object2).getEventUploadFrequency();
        int n12 = (int)l10;
        if (n12 < (n11 = 1800)) {
            n12 = n11;
        }
        Object object3 = bm.a(this.a);
        Object object4 = "sp_client_report_status";
        String string2 = "event_last_upload_time";
        long l11 = 0L;
        long l12 = ((bm)object3).a((String)object4, string2, l11);
        long l13 = System.currentTimeMillis() - l12;
        long l14 = l13 - (l12 = (long)(n12 * 1000));
        n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n11 > 0) {
            object3 = ai.a(this.a);
            object4 = new h(this, (bg)object);
            n10 = 10;
            ((ai)object3).a((Runnable)object4, n10);
        }
        object3 = a.class;
        synchronized (object3) {
            object4 = this.a;
            object4 = ai.a((Context)object4);
            boolean bl3 = ((ai)object4).a((ai$a)object, n12);
            if (!bl3) {
                object4 = this.a;
                object4 = ai.a((Context)object4);
                n10 = 100886;
                ((ai)object4).a(n10);
                object4 = this.a;
                object4 = ai.a((Context)object4);
                ((ai)object4).a((ai$a)object, n12);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void g() {
        int n10;
        int n11;
        Object object = com.xiaomi.clientreport.manager.a.a(this.a).a();
        boolean bl2 = ((Config)object).isPerfUploadSwitchOpen();
        if (!bl2) {
            return;
        }
        Object object2 = this.a;
        object = new bh((Context)object2);
        object2 = com.xiaomi.clientreport.manager.a.a(this.a).a();
        long l10 = ((Config)object2).getPerfUploadFrequency();
        int n12 = (int)l10;
        if (n12 < (n11 = 1800)) {
            n12 = n11;
        }
        Object object3 = bm.a(this.a);
        Object object4 = "sp_client_report_status";
        String string2 = "perf_last_upload_time";
        long l11 = 0L;
        long l12 = ((bm)object3).a((String)object4, string2, l11);
        long l13 = System.currentTimeMillis() - l12;
        long l14 = l13 - (l12 = (long)(n12 * 1000));
        n11 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1));
        if (n11 > 0) {
            object3 = ai.a(this.a);
            object4 = new i(this, (bh)object);
            n10 = 15;
            ((ai)object3).a((Runnable)object4, n10);
        }
        object3 = a.class;
        synchronized (object3) {
            object4 = this.a;
            object4 = ai.a((Context)object4);
            boolean bl3 = ((ai)object4).a((ai$a)object, n12);
            if (!bl3) {
                object4 = this.a;
                object4 = ai.a((Context)object4);
                n10 = 100887;
                ((ai)object4).a(n10);
                object4 = this.a;
                object4 = ai.a((Context)object4);
                ((ai)object4).a((ai$a)object, n12);
            }
            return;
        }
    }

    public Config a() {
        synchronized (this) {
            Config config = this.a;
            if (config == null) {
                config = this.a;
                this.a = config = Config.defaultConfig((Context)config);
            }
            config = this.a;
            return config;
        }
    }

    public EventClientReport a(int n10, String string2) {
        String string3;
        long l10;
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = string2;
        eventClientReport.eventTime = l10 = System.currentTimeMillis();
        eventClientReport.eventType = n10;
        eventClientReport.eventId = string3 = bf.a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        string3 = this.a.getPackageName();
        eventClientReport.setAppPackageName(string3);
        string3 = this.a;
        eventClientReport.setSdkVersion(string3);
        return eventClientReport;
    }

    public void a() {
        com.xiaomi.clientreport.manager.a.a(this.a).f();
        com.xiaomi.clientreport.manager.a.a(this.a).g();
    }

    public void a(Config object, IEventProcessor object2, IPerfProcessor iPerfProcessor) {
        this.a = object;
        this.a = object2;
        this.a = iPerfProcessor;
        object = this.b;
        object2.setEventMap((HashMap)object);
        object = this.a;
        object2 = this.a;
        object.setPerfMap((HashMap)object2);
    }

    public void a(EventClientReport eventClientReport) {
        Object object = this.a();
        boolean bl2 = ((Config)object).isEventUploadSwitchOpen();
        if (bl2) {
            object = this.a;
            b b10 = new b(this, eventClientReport);
            object.execute(b10);
        }
    }

    public void a(PerfClientReport perfClientReport) {
        Object object = this.a();
        boolean bl2 = ((Config)object).isPerfUploadSwitchOpen();
        if (bl2) {
            object = this.a;
            c c10 = new c(this, perfClientReport);
            object.execute(c10);
        }
    }

    public void a(String string2) {
        this.a = string2;
    }

    public void a(boolean bl2, boolean object, long l10, long l11) {
        long l12;
        long l13;
        long l14;
        boolean bl3;
        Config config = this.a;
        if (config != null && (bl2 != (bl3 = config.isEventUploadSwitchOpen()) || object != (bl3 = (config = this.a).isPerfUploadSwitchOpen()) || (bl3 = (l14 = l10 - (l13 = (config = this.a).getEventUploadFrequency())) == 0L ? 0 : (l14 < 0L ? -1 : 1)) || (bl3 = (l12 = l11 - (l13 = (config = this.a).getPerfUploadFrequency())) == 0L ? 0 : (l12 < 0L ? -1 : 1)))) {
            String string2;
            long l15;
            config = this.a;
            l13 = config.getEventUploadFrequency();
            Config config2 = this.a;
            long l16 = config2.getPerfUploadFrequency();
            Config$Builder config$Builder = Config.getBuilder();
            Object object2 = bj.a(this.a);
            config$Builder = config$Builder.setAESKey((String)object2);
            object2 = this.a;
            boolean bl4 = ((Config)object2).isEventEncrypted();
            config$Builder = config$Builder.setEventEncrypted(bl4);
            Object object3 = config$Builder.setEventUploadSwitchOpen(bl2).setEventUploadFrequency(l10).setPerfUploadSwitchOpen((boolean)object).setPerfUploadFrequency(l11);
            Object object4 = this.a;
            this.a = object3 = ((Config$Builder)object3).build((Context)object4);
            object = ((Config)object3).isEventUploadSwitchOpen();
            if (!object) {
                object4 = ai.a(this.a);
                int n10 = 100886;
                ((ai)object4).a(n10);
            } else {
                l15 = ((Config)object3).getEventUploadFrequency();
                long l17 = l13 - l15;
                object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
                if (object) {
                    object4 = new StringBuilder();
                    string2 = this.a.getPackageName();
                    ((StringBuilder)object4).append(string2);
                    string2 = "reset event job ";
                    ((StringBuilder)object4).append(string2);
                    l10 = ((Config)object3).getEventUploadFrequency();
                    ((StringBuilder)object4).append(l10);
                    object4 = ((StringBuilder)object4).toString();
                    com.xiaomi.channel.commonutils.logger.b.c((String)object4);
                    this.f();
                }
            }
            object4 = this.a;
            object = ((Config)object4).isPerfUploadSwitchOpen();
            if (!object) {
                object3 = ai.a(this.a);
                object = 100887;
                ((ai)object3).a((int)object);
            } else {
                l15 = ((Config)object3).getPerfUploadFrequency();
                long l18 = l16 - l15;
                object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object) {
                    object4 = new StringBuilder();
                    string2 = this.a.getPackageName();
                    ((StringBuilder)object4).append(string2);
                    string2 = "reset perf job ";
                    ((StringBuilder)object4).append(string2);
                    l10 = ((Config)object3).getPerfUploadFrequency();
                    ((StringBuilder)object4).append(l10);
                    object3 = ((StringBuilder)object4).toString();
                    com.xiaomi.channel.commonutils.logger.b.c((String)object3);
                    this.g();
                }
            }
        }
    }

    public void b() {
        Object object = this.a();
        boolean bl2 = ((Config)object).isEventUploadSwitchOpen();
        if (bl2) {
            object = new bi();
            Object object2 = this.a;
            ((bi)object).a((Context)object2);
            object2 = this.a;
            ((bi)object).a((com.xiaomi.clientreport.processor.c)object2);
            object2 = this.a;
            object2.execute((Runnable)object);
        }
    }

    public void c() {
        Object object = this.a();
        boolean bl2 = ((Config)object).isPerfUploadSwitchOpen();
        if (bl2) {
            object = new bi();
            Object object2 = this.a;
            ((bi)object).a((com.xiaomi.clientreport.processor.c)object2);
            object2 = this.a;
            ((bi)object).a((Context)object2);
            object2 = this.a;
            object2.execute((Runnable)object);
        }
    }
}

