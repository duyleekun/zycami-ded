/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.StatFs
 *  android.text.TextUtils
 *  android.util.Log
 */
package d.e.a;

import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import com.dianping.logan.LoganModel;
import com.dianping.logan.LoganModel$Action;
import d.e.a.c;
import d.e.a.f;
import d.e.a.h$a;
import d.e.a.h$b;
import d.e.a.h$c;
import d.e.a.i;
import d.e.a.j;
import d.e.a.m;
import d.e.a.m$a;
import d.e.a.n;
import d.e.a.o;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class h
extends Thread {
    private static final String u = "LoganThread";
    private static final int v = 60000;
    private static final long w = 86400000L;
    private static final int x = 1024;
    private final Object a;
    private final Object b;
    private volatile boolean c;
    private long d;
    private boolean e;
    private File f;
    private boolean g;
    private long h;
    private f i;
    private ConcurrentLinkedQueue j;
    private String k;
    private String l;
    private long m;
    private long n;
    private long o;
    private String p;
    private String q;
    private int r;
    private ConcurrentLinkedQueue s;
    private ExecutorService t;

    public h(ConcurrentLinkedQueue concurrentLinkedQueue, String string2, String string3, long l10, long l11, long l12, String string4, String string5) {
        ConcurrentLinkedQueue concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        this.a = concurrentLinkedQueue2;
        concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        this.b = concurrentLinkedQueue2;
        this.c = true;
        this.s = concurrentLinkedQueue2 = new ConcurrentLinkedQueue();
        this.j = concurrentLinkedQueue;
        this.k = string2;
        this.l = string3;
        this.m = l10;
        this.n = l11;
        this.o = l12;
        this.p = string4;
        this.q = string5;
    }

    public static /* synthetic */ Object a(h h10) {
        return h10.b;
    }

    public static /* synthetic */ int b(h h10, int n10) {
        h10.r = n10;
        return n10;
    }

    public static /* synthetic */ ConcurrentLinkedQueue c(h h10) {
        return h10.s;
    }

    public static /* synthetic */ ConcurrentLinkedQueue d(h h10) {
        return h10.j;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void e(LoganModel object) {
        boolean bl2;
        Object object2;
        if (object == null) return;
        boolean bl3 = ((LoganModel)object).a();
        if (!bl3) {
            return;
        }
        Object object3 = this.i;
        if (object3 == null) {
            object3 = d.e.a.f.g();
            this.i = object3;
            object2 = new h$a(this);
            ((f)object3).c((i)object2);
            f f10 = this.i;
            String string2 = this.k;
            String string3 = this.l;
            long l10 = this.n;
            int n10 = (int)l10;
            String string4 = this.p;
            String string5 = this.q;
            f10.b(string2, string3, n10, string4, string5);
            object3 = this.i;
            bl2 = d.e.a.c.c;
            ((f)object3).f(bl2);
        }
        if ((object3 = ((LoganModel)object).a) == (object2 = LoganModel$Action.WRITE)) {
            object = ((LoganModel)object).b;
            this.j((o)object);
            return;
        }
        object2 = LoganModel$Action.SEND;
        if (object3 != object2) {
            object = LoganModel$Action.FLUSH;
            if (object3 != object) return;
            this.h();
            return;
        }
        object3 = object.c.d;
        if (object3 == null) return;
        object3 = this.b;
        synchronized (object3) {
            bl2 = this.r;
            boolean bl4 = 10001 != 0;
            if (bl2 == bl4) {
                object2 = this.s;
                ((ConcurrentLinkedQueue)object2).add(object);
            } else {
                object = ((LoganModel)object).c;
                this.i((j)object);
            }
            return;
        }
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean f(String object, String object2) {
        void var2_10;
        FileInputStream fileInputStream;
        block34: {
            boolean bl2;
            block36: {
                void var2_12;
                block38: {
                    block35: {
                        block37: {
                            FileInputStream fileInputStream2;
                            block33: {
                                block32: {
                                    block31: {
                                        int n10 = 0;
                                        fileInputStream = null;
                                        bl2 = false;
                                        File file = new File((String)object);
                                        fileInputStream2 = new FileInputStream(file);
                                        file = new File((String)object2);
                                        object = new FileOutputStream(file);
                                        int n11 = 1024;
                                        object2 = new byte[n11];
                                        while ((n10 = fileInputStream2.read((byte[])object2)) >= 0) {
                                            ((FileOutputStream)object).write((byte[])object2, 0, n10);
                                            ((OutputStream)object).flush();
                                        }
                                        bl2 = true;
                                        try {
                                            fileInputStream2.close();
                                        }
                                        catch (Exception exception) {
                                            exception.printStackTrace();
                                        }
                                        try {
                                            ((FileOutputStream)object).close();
                                            return bl2;
                                        }
                                        catch (Exception exception) {
                                            exception.printStackTrace();
                                            return bl2;
                                        }
                                        catch (Throwable throwable) {
                                            break block31;
                                        }
                                        catch (IOException iOException) {
                                            break block32;
                                        }
                                        catch (FileNotFoundException fileNotFoundException) {
                                            break block33;
                                        }
                                        catch (Throwable throwable) {
                                            object = null;
                                        }
                                    }
                                    fileInputStream = fileInputStream2;
                                    break block34;
                                    catch (IOException iOException) {
                                        object = null;
                                    }
                                }
                                fileInputStream = fileInputStream2;
                                break block37;
                                catch (FileNotFoundException fileNotFoundException) {
                                    object = null;
                                }
                            }
                            fileInputStream = fileInputStream2;
                            break block38;
                            catch (Throwable throwable) {
                                object = null;
                                break block34;
                            }
                            catch (IOException iOException) {
                                object = null;
                            }
                        }
                        var2_12.printStackTrace();
                        if (fileInputStream == null) break block35;
                        try {
                            fileInputStream.close();
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    if (object == null) return bl2;
                    ((FileOutputStream)object).close();
                    return bl2;
                    catch (FileNotFoundException fileNotFoundException) {
                        object = null;
                    }
                }
                var2_12.printStackTrace();
                if (fileInputStream == null) break block36;
                try {
                    fileInputStream.close();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (object == null) return bl2;
            ((FileOutputStream)object).close();
            return bl2;
            catch (Throwable throwable) {
                // empty catch block
            }
        }
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        if (object == null) throw var2_10;
        try {
            ((FileOutputStream)object).close();
            throw var2_10;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        throw var2_10;
    }

    private void g(long l10) {
        String string2 = this.l;
        String[] stringArray = new File(string2);
        int n10 = stringArray.isDirectory();
        if (n10 != 0 && (stringArray = stringArray.list()) != null) {
            for (String string3 : stringArray) {
                int n11 = TextUtils.isEmpty((CharSequence)string3);
                if (n11 != 0) continue;
                Object object = "\\.";
                object = string3.split((String)object);
                int n12 = ((String[])object).length;
                if (n12 <= 0) continue;
                Object object2 = object[0];
                object2 = Long.valueOf((String)object2);
                long l11 = (Long)object2;
                n12 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                if (n12 > 0) continue;
                n11 = ((String[])object).length;
                n12 = 1;
                if (n11 != n12) continue;
                object2 = this.l;
                try {
                    object = new File((String)object2, string3);
                    ((File)object).delete();
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    private void h() {
        Object object;
        boolean bl2 = d.e.a.c.c;
        if (bl2) {
            object = u;
            String string2 = "Logan flush start";
            Log.d((String)object, (String)string2);
        }
        if ((object = this.i) != null) {
            ((f)object).a();
        }
    }

    private void i(j object) {
        Object object2;
        int n10 = d.e.a.c.c;
        Object object3 = u;
        if (n10 != 0) {
            object2 = "Logan send start";
            Log.d((String)object3, (String)object2);
        }
        if ((n10 = TextUtils.isEmpty((CharSequence)(object2 = this.l))) == 0 && object != null && (n10 = ((j)object).a()) != 0) {
            n10 = this.p((j)object);
            if (n10 == 0) {
                boolean bl2 = d.e.a.c.c;
                if (bl2) {
                    object = "Logan prepare log file failed, can't find log file";
                    Log.d((String)object3, (String)object);
                }
                return;
            }
            ((j)object).d.d((j)object);
            object2 = ((j)object).d;
            object3 = new h$b(this);
            ((m)object2).c((m$a)object3);
            this.r = n10 = 10001;
            object2 = this.t;
            if (object2 == null) {
                object2 = new h$c(this);
                this.t = object2 = Executors.newSingleThreadExecutor((ThreadFactory)object2);
            }
            object2 = this.t;
            object = ((j)object).d;
            object2.execute((Runnable)object);
        }
    }

    private void j(o o10) {
        long l10;
        long l11;
        Object object;
        Object object2;
        Object object3 = d.e.a.c.c;
        if (object3 != 0) {
            object2 = u;
            object = "Logan write start";
            Log.d((String)object2, (String)object);
        }
        if ((object2 = this.f) == null) {
            object = this.l;
            this.f = object2 = new File((String)object);
        }
        if ((object3 = this.l()) == 0) {
            l11 = d.e.a.n.a();
            l10 = this.m;
            l10 = l11 - l10;
            this.g(l10);
            this.d = l11;
            f f10 = this.i;
            object2 = String.valueOf(l11);
            f10.e((String)object2);
        }
        l11 = System.currentTimeMillis();
        l10 = this.h;
        long l12 = (l11 -= l10) - (l10 = 60000L);
        object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 > 0) {
            object3 = this.k();
            this.g = object3;
        }
        this.h = l11 = System.currentTimeMillis();
        object3 = this.g;
        if (object3 == 0) {
            return;
        }
        object = this.i;
        int n10 = o10.f;
        String string2 = o10.a;
        long l13 = o10.e;
        String string3 = o10.d;
        long l14 = o10.c;
        boolean bl2 = o10.b;
        ((f)object).d(n10, string2, l13, string3, l14, bl2);
    }

    private boolean k() {
        long l10;
        boolean bl2 = false;
        String string2 = this.l;
        StatFs statFs = new StatFs(string2);
        int n10 = statFs.getBlockSize();
        long l11 = n10;
        int n11 = statFs.getAvailableBlocks();
        long l12 = (long)n11 * l11;
        try {
            l10 = this.o;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }
        n11 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1));
        if (n11 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    private boolean l() {
        long l10;
        long l11;
        int n10;
        long l12 = this.d;
        long l13 = System.currentTimeMillis();
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        n10 = object < 0 && (n10 = (l11 = (l12 += (l10 = 86400000L)) - l13) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0 ? 1 : 0;
        return n10 != 0;
    }

    private boolean m(String string2) {
        Object object = this.l;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        boolean bl3 = false;
        if (bl2) {
            return false;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = this.l;
        stringBuilder.append(string3);
        string3 = File.separator;
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        object = new File(string2);
        boolean bl4 = ((File)object).exists();
        if (bl4 && (bl4 = ((File)object).isFile())) {
            bl3 = true;
        }
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean p(j j10) {
        String string2;
        CharSequence charSequence;
        boolean bl2 = d.e.a.c.c;
        if (bl2) {
            charSequence = u;
            string2 = "prepare log file";
            Log.d((String)charSequence, (String)string2);
        }
        if (bl2 = this.m((String)(charSequence = j10.b))) {
            charSequence = new StringBuilder();
            string2 = this.l;
            ((StringBuilder)charSequence).append(string2);
            string2 = File.separator;
            ((StringBuilder)charSequence).append(string2);
            CharSequence charSequence2 = j10.b;
            ((StringBuilder)charSequence).append((String)charSequence2);
            charSequence = ((StringBuilder)charSequence).toString();
            charSequence2 = j10.b;
            long l10 = d.e.a.n.a();
            String string3 = String.valueOf(l10);
            boolean bl3 = ((String)charSequence2).equals(string3);
            boolean bl4 = true;
            if (bl3) {
                this.h();
                charSequence2 = new StringBuilder();
                String string4 = this.l;
                ((StringBuilder)charSequence2).append(string4);
                ((StringBuilder)charSequence2).append(string2);
                string2 = j10.b;
                ((StringBuilder)charSequence2).append(string2);
                ((StringBuilder)charSequence2).append(".copy");
                string2 = ((StringBuilder)charSequence2).toString();
                bl2 = this.f((String)charSequence, string2);
                if (!bl2) return false;
                j10.c = string2;
                return bl4;
            }
            j10.c = charSequence;
            return bl4;
        }
        charSequence = "";
        j10.c = charSequence;
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void o() {
        boolean bl2 = this.e;
        if (bl2) return;
        Object object = this.a;
        synchronized (object) {
            Object object2 = this.a;
            object2.notify();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void q() {
        Object object = null;
        this.c = false;
        boolean bl2 = this.e;
        if (bl2) return;
        object = this.a;
        synchronized (object) {
            Object object2 = this.a;
            object2.notify();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        super.run();
        boolean bl2;
        while (bl2 = this.c) {
            Object object = this.a;
            synchronized (object) {
                boolean bl3;
                this.e = bl3 = true;
                try {
                    Object object2 = this.j;
                    object2 = ((ConcurrentLinkedQueue)object2).poll();
                    object2 = (LoganModel)object2;
                    if (object2 == null) {
                        this.e = false;
                        object2 = this.a;
                        object2.wait();
                        this.e = bl3;
                    } else {
                        this.e((LoganModel)object2);
                    }
                }
                catch (InterruptedException interruptedException) {
                    interruptedException.printStackTrace();
                    this.e = false;
                }
            }
        }
        return;
    }
}

