/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;
import g.h0.l.d$d;
import g.h0.l.d$e;
import g.h0.l.g;
import g.h0.n.h;
import java.io.IOException;
import java.util.List;
import okhttp3.internal.http2.ErrorCode;

public final class d$e$b
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ boolean f;
    public final /* synthetic */ g g;
    public final /* synthetic */ d$e h;
    public final /* synthetic */ g i;
    public final /* synthetic */ int j;
    public final /* synthetic */ List k;
    public final /* synthetic */ boolean l;

    public d$e$b(String string2, boolean bl2, String string3, boolean bl3, g g10, d$e d$e, g g11, int n10, List list, boolean bl4) {
        this.e = string2;
        this.f = bl2;
        this.g = g10;
        this.h = d$e;
        this.i = g11;
        this.j = n10;
        this.k = list;
        this.l = bl4;
        super(string3, bl3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long f() {
        try {
            Object object = this.h;
            object = ((d$e)object).b;
            object = ((d)object).D0();
            g object2 = this.g;
            ((d$d)object).f(object2);
            return -1;
        }
        catch (IOException iOException) {
            Object object = g.h0.n.h.e.g();
            StringBuilder string3 = new StringBuilder();
            string3.append("Http2Connection.Listener failure for ");
            String string2 = this.h.b.B0();
            string3.append(string2);
            String errorCode = string3.toString();
            int n10 = 4;
            ((h)object).m(errorCode, n10, iOException);
            try {
                object = this.g;
                ErrorCode errorCode2 = ErrorCode.PROTOCOL_ERROR;
                ((g)object).d(errorCode2, iOException);
                return -1;
            }
            catch (IOException iOException2) {
                return -1;
            }
        }
    }
}

