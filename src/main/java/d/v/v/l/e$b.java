/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.l;

import com.zhiyun.nvseditor.record.AudioRecorder$b;
import d.v.h.h.a$a;
import d.v.h.h.b;
import d.v.v.l.e;
import d.v.v.q.h;
import m.a.a;

public class e$b
implements AudioRecorder$b {
    public final /* synthetic */ e a;

    public e$b(e e10) {
        this.a = e10;
    }

    public void a(short[] sArray) {
        a$a a$a = e.s(this.a);
        if (a$a != null) {
            a$a = e.s(this.a);
            a$a.a(sArray);
        }
    }

    public void b(long l10) {
        Object object = e.q(this.a);
        Long l11 = l10;
        ((b)object).p(l11);
        object = e.s(this.a);
        if (object != null) {
            object = e.s(this.a);
            object.c(l10);
        }
    }

    public void c(String object, String string2) {
        object = e.q(this.a);
        if (object != null) {
            e.q(this.a).v(string2);
            object = e.q(this.a);
            ((b)object).x(0L);
            long l10 = h.C(string2);
            Object object2 = new Object[1];
            Long l11 = l10;
            object2[0] = l11;
            Object object3 = "----duration = %s";
            m.a.a.b((String)object3, (Object[])object2);
            long l12 = -1;
            long l13 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
            if (l13 == false) {
                return;
            }
            e.q(this.a).q(l10);
            e.q(this.a).r(l10);
            object2 = this.a;
            object3 = e.q((e)object2);
            ((e)object2).l((b)object3);
            object2 = e.s(this.a);
            if (object2 != null) {
                object2 = e.s(this.a);
                object2.d(l10);
            }
        }
    }

    public void d(Exception exception) {
        a$a a$a = e.s(this.a);
        if (a$a != null) {
            a$a = e.s(this.a);
            String string2 = exception.getMessage();
            a$a.b(exception, string2);
        }
    }
}

