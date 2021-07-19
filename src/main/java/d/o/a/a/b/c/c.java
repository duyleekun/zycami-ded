/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.b.c;

import com.quvideo.mobile.external.platform.uploader.OooO;
import com.quvideo.mobile.external.platform.uploader.OooO$OooO0OO;
import com.quvideo.mobile.external.platform.uploader.OooO00o;
import com.quvideo.mobile.external.platform.uploader.OooOo00;
import d.o.a.a.b.c.c$a;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class c
implements Runnable,
Comparable {
    public String a;
    private int b;
    private volatile OooO c;
    private OooO00o d;
    private AtomicBoolean e;
    private final ReentrantLock f;
    private final Condition g;

    public c(String string2) {
        int n10 = 1;
        Object object = new AtomicBoolean(n10 != 0);
        this.e = object;
        this.f = object;
        this.g = object = ((ReentrantLock)object).newCondition();
        this.a = string2;
        this.b = n10;
    }

    public c(String string2, OooO oooO, OooO00o oooO00o) {
        Object object = new AtomicBoolean(true);
        this.e = object;
        this.f = object;
        this.g = object = ((ReentrantLock)object).newCondition();
        this.a = string2;
        this.b = 0;
        this.c = oooO;
        this.d = oooO00o;
    }

    public static /* synthetic */ AtomicBoolean a(c c10) {
        return c10.e;
    }

    public static /* synthetic */ OooO b(c c10) {
        return c10.c;
    }

    public static /* synthetic */ ReentrantLock c(c c10) {
        return c10.f;
    }

    public static /* synthetic */ Condition d(c c10) {
        return c10.g;
    }

    public final int e(c c10) {
        int n10 = -1;
        if (c10 == null) {
            return n10;
        }
        int n11 = this.b;
        int n12 = c10.b;
        if (n11 > n12) {
            return n10;
        }
        if (n11 < n12) {
            return 1;
        }
        return 0;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        Object object2;
        block8: {
            int n10 = this.b;
            int n11 = 1;
            if (n10 == n11) {
                OooOo00 oooOo00 = OooOo00.a();
                String string2 = this.a;
                oooOo00.k(string2);
                return;
            }
            object2 = this.c;
            n10 = (int)(((OooO)object2).OooO0OO ? 1 : 0);
            if (n10 == 0) {
                object2 = this.c.OooO0oO;
                long l10 = ((OooO$OooO0OO)object2).OooO0O0;
                long l11 = System.currentTimeMillis();
                long l12 = 300000L;
                long l13 = l10 - (l11 -= l12);
                n10 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
                if (n10 <= 0) {
                    Throwable throwable2222222;
                    block7: {
                        n10 = 0;
                        object2 = null;
                        object = this.f;
                        ((ReentrantLock)object).lockInterruptibly();
                        object = this.c;
                        l11 = ((OooO)object).OooO0O0;
                        object = this.c;
                        Object object3 = ((OooO)object).OooO00o;
                        object = this.c;
                        boolean bl2 = ((OooO)object).OooO0Oo;
                        object = this.c;
                        boolean bl3 = ((OooO)object).OooO0o0;
                        object = this.c;
                        String string3 = ((OooO)object).OooO0o;
                        c$a c$a = new c$a(this);
                        OooOo00.c(l11, object3, bl2, bl3, string3, c$a);
                        object = this.g;
                        l11 = 3000L;
                        object3 = TimeUnit.MILLISECONDS;
                        object.await(l11, (TimeUnit)((Object)object3));
                        object = this.e;
                        ((AtomicBoolean)object).set(false);
                        {
                            catch (Throwable throwable2222222) {
                                break block7;
                            }
                            catch (Exception exception) {}
                            {
                                object = this.e;
                                ((AtomicBoolean)object).set(false);
                            }
                        }
                        object2 = this.f;
                        ((ReentrantLock)object2).unlock();
                        break block8;
                    }
                    this.f.unlock();
                    throw throwable2222222;
                }
            }
        }
        object2 = this.d;
        object = this.c;
        ((OooO00o)object2).OooO00o((OooO)object);
        this.d.OooOO0();
    }
}

