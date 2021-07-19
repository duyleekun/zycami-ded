/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.text.TextUtils
 */
package d.e.a;

import android.os.Looper;
import android.text.TextUtils;
import com.dianping.logan.LoganModel;
import com.dianping.logan.LoganModel$Action;
import d.e.a.d;
import d.e.a.h;
import d.e.a.j;
import d.e.a.m;
import d.e.a.o;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

public class e {
    private static e l;
    private ConcurrentLinkedQueue a;
    private String b;
    private String c;
    private long d;
    private long e;
    private long f;
    private long g;
    private String h;
    private String i;
    private h j;
    private SimpleDateFormat k;

    private e(d object) {
        Object object2 = new ConcurrentLinkedQueue();
        this.a = object2;
        Object object3 = "yyyy-MM-dd";
        super((String)object3);
        this.k = object2;
        boolean bl2 = ((d)object).h();
        if (bl2) {
            long l10;
            this.c = object2 = ((d)object).b;
            this.b = object2 = ((d)object).a;
            this.d = l10 = ((d)object).d;
            this.f = l10 = ((d)object).f;
            this.e = l10 = ((d)object).c;
            this.g = l10 = ((d)object).e;
            object3 = ((d)object).g;
            this.h = object2 = new String((byte[])object3);
            object = ((d)object).h;
            this.i = object2 = new String((byte[])object);
            this.d();
            return;
        }
        object = new NullPointerException("config's param is invalid");
        throw object;
    }

    private long b(String object) {
        long l10;
        SimpleDateFormat simpleDateFormat = this.k;
        object = simpleDateFormat.parse((String)object);
        try {
            l10 = ((Date)object).getTime();
        }
        catch (ParseException parseException) {
            parseException.printStackTrace();
            l10 = 0L;
        }
        return l10;
    }

    private void d() {
        h h10 = this.j;
        if (h10 == null) {
            ConcurrentLinkedQueue concurrentLinkedQueue = this.a;
            String string2 = this.b;
            String string3 = this.c;
            long l10 = this.d;
            long l11 = this.e;
            long l12 = this.f;
            String string4 = this.h;
            String string5 = this.i;
            Object object = h10;
            this.j = h10 = new h(concurrentLinkedQueue, string2, string3, l10, l11, l12, string4, string5);
            object = "logan-thread";
            h10.setName((String)object);
            h10 = this.j;
            h10.start();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e e(d d10) {
        Object object = l;
        if (object != null) return l;
        object = e.class;
        synchronized (object) {
            e e10 = l;
            if (e10 != null) return l;
            l = e10 = new e(d10);
            return l;
        }
    }

    public void a() {
        Object object = this.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        object = new LoganModel();
        Object object2 = LoganModel$Action.FLUSH;
        ((LoganModel)object).a = object2;
        object2 = this.a;
        ((ConcurrentLinkedQueue)object2).add(object);
        object = this.j;
        if (object != null) {
            ((h)object).o();
        }
    }

    public File c() {
        String string2 = this.c;
        File file = new File(string2);
        return file;
    }

    public void f(String[] stringArray, m m10) {
        String string2 = this.c;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && stringArray != null && (n10 = stringArray.length) != 0) {
            for (String string3 : stringArray) {
                String string4;
                LoganModel$Action loganModel$Action;
                long l10;
                long l11;
                long l12;
                long l13;
                boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
                if (bl2 || (l13 = (l12 = (l11 = this.b(string3)) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) <= 0) continue;
                LoganModel loganModel = new LoganModel();
                j j10 = new j();
                loganModel.a = loganModel$Action = LoganModel$Action.SEND;
                j10.b = string4 = String.valueOf(l11);
                j10.d = m10;
                loganModel.c = j10;
                this.a.add(loganModel);
                h h10 = this.j;
                if (h10 == null) continue;
                h10.o();
            }
        }
    }

    public void g(String object, int n10) {
        long l10;
        long l11;
        Looper looper;
        Object object2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        LoganModel loganModel = new LoganModel();
        loganModel.a = object2 = LoganModel$Action.WRITE;
        object2 = new o();
        String string2 = Thread.currentThread().getName();
        Thread thread = Thread.currentThread();
        long l12 = thread.getId();
        boolean bl3 = false;
        Looper looper2 = Looper.getMainLooper();
        if (looper2 == (looper = Looper.myLooper())) {
            bl3 = true;
        }
        ((o)object2).a = object;
        ((o)object2).e = l11 = System.currentTimeMillis();
        ((o)object2).f = n10;
        ((o)object2).b = bl3;
        ((o)object2).c = l12;
        ((o)object2).d = string2;
        loganModel.b = object2;
        object = this.a;
        long l13 = ((ConcurrentLinkedQueue)object).size();
        long l14 = l13 - (l10 = this.g);
        Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object3 < 0) {
            this.a.add(loganModel);
            object = this.j;
            if (object != null) {
                ((h)object).o();
            }
        }
    }
}

