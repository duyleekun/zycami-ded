/*
 * Decompiled with CFR 0.151.
 */
package f.z1;

import f.h2.s.l;
import f.z1.c$a;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public final class c {
    private static final Timer a(String object, boolean bl2, long l10, long l11, l l12) {
        object = c.k((String)object, bl2);
        c$a c$a = new c$a(l12);
        ((Timer)object).scheduleAtFixedRate((TimerTask)c$a, l10, l11);
        return object;
    }

    private static final Timer b(String object, boolean bl2, Date date, long l10, l l11) {
        object = c.k((String)object, bl2);
        c$a c$a = new c$a(l11);
        ((Timer)object).scheduleAtFixedRate((TimerTask)c$a, date, l10);
        return object;
    }

    public static /* synthetic */ Timer c(String object, boolean bl2, long l10, long l11, l l12, int n10, Object object2) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = null;
        }
        if ((n11 = n10 & 2) != 0) {
            bl2 = false;
        }
        if ((n10 &= 4) != 0) {
            l10 = 0L;
        }
        object = c.k((String)object, bl2);
        c$a c$a = new c$a(l12);
        ((Timer)object).scheduleAtFixedRate((TimerTask)c$a, l10, l11);
        return object;
    }

    public static /* synthetic */ Timer d(String object, boolean bl2, Date date, long l10, l l11, int n10, Object object2) {
        c$a c$a;
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = null;
        }
        if ((n10 &= 2) != 0) {
            bl2 = false;
            c$a = null;
        }
        object = c.k((String)object, bl2);
        c$a = new c$a(l11);
        ((Timer)object).scheduleAtFixedRate((TimerTask)c$a, date, l10);
        return object;
    }

    private static final TimerTask e(Timer timer, long l10, long l11, l l12) {
        c$a c$a = new c$a(l12);
        timer.schedule((TimerTask)c$a, l10, l11);
        return c$a;
    }

    private static final TimerTask f(Timer timer, long l10, l l11) {
        c$a c$a = new c$a(l11);
        timer.schedule((TimerTask)c$a, l10);
        return c$a;
    }

    private static final TimerTask g(Timer timer, Date date, long l10, l l11) {
        c$a c$a = new c$a(l11);
        timer.schedule((TimerTask)c$a, date, l10);
        return c$a;
    }

    private static final TimerTask h(Timer timer, Date date, l l10) {
        c$a c$a = new c$a(l10);
        timer.schedule((TimerTask)c$a, date);
        return c$a;
    }

    private static final TimerTask i(Timer timer, long l10, long l11, l l12) {
        c$a c$a = new c$a(l12);
        timer.scheduleAtFixedRate((TimerTask)c$a, l10, l11);
        return c$a;
    }

    private static final TimerTask j(Timer timer, Date date, long l10, l l11) {
        c$a c$a = new c$a(l11);
        timer.scheduleAtFixedRate((TimerTask)c$a, date, l10);
        return c$a;
    }

    public static final Timer k(String object, boolean bl2) {
        if (object == null) {
            object = new Timer(bl2);
        } else {
            Timer timer = new Timer((String)object, bl2);
            object = timer;
        }
        return object;
    }

    private static final Timer l(String object, boolean bl2, long l10, long l11, l l12) {
        object = c.k((String)object, bl2);
        c$a c$a = new c$a(l12);
        ((Timer)object).schedule((TimerTask)c$a, l10, l11);
        return object;
    }

    private static final Timer m(String object, boolean bl2, Date date, long l10, l l11) {
        object = c.k((String)object, bl2);
        c$a c$a = new c$a(l11);
        ((Timer)object).schedule((TimerTask)c$a, date, l10);
        return object;
    }

    public static /* synthetic */ Timer n(String object, boolean bl2, long l10, long l11, l l12, int n10, Object object2) {
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = null;
        }
        if ((n11 = n10 & 2) != 0) {
            bl2 = false;
        }
        if ((n10 &= 4) != 0) {
            l10 = 0L;
        }
        object = c.k((String)object, bl2);
        c$a c$a = new c$a(l12);
        ((Timer)object).schedule((TimerTask)c$a, l10, l11);
        return object;
    }

    public static /* synthetic */ Timer o(String object, boolean bl2, Date date, long l10, l l11, int n10, Object object2) {
        c$a c$a;
        int n11 = n10 & 1;
        if (n11 != 0) {
            object = null;
        }
        if ((n10 &= 2) != 0) {
            bl2 = false;
            c$a = null;
        }
        object = c.k((String)object, bl2);
        c$a = new c$a(l11);
        ((Timer)object).schedule((TimerTask)c$a, date, l10);
        return object;
    }

    private static final TimerTask p(l l10) {
        c$a c$a = new c$a(l10);
        return c$a;
    }
}

