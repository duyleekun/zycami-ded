/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q1;
import h.k;
import h.m;
import h.m0;
import java.io.IOException;

public final class k$d
implements m0 {
    public final /* synthetic */ k a;
    public final /* synthetic */ m0 b;

    public k$d(k k10, m0 m02) {
        this.a = k10;
        this.b = m02;
    }

    public k a() {
        return this.a;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void close() {
        Throwable throwable2222222;
        k k10 = this.a;
        k10.v();
        Object object = this.b;
        object.close();
        object = q1.a;
        boolean bl2 = k10.w();
        if (bl2) throw k10.q(null);
        return;
        {
            catch (Throwable throwable2222222) {
            }
            catch (IOException iOException) {}
            {
                IOException iOException;
                boolean bl3 = k10.w();
                if (!bl3) {
                    throw iOException;
                }
                iOException = k10.q(iOException);
                throw iOException;
            }
        }
        k10.w();
        throw throwable2222222;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long read(m m10, long l10) {
        Throwable throwable2222222;
        f0.p(m10, "sink");
        k k10 = this.a;
        k10.v();
        m0 m02 = this.b;
        long l11 = m02.read(m10, l10);
        boolean bl2 = k10.w();
        if (bl2) throw k10.q(null);
        return l11;
        {
            catch (Throwable throwable2222222) {
            }
            catch (IOException iOException) {}
            {
                IOException iOException;
                boolean bl3 = k10.w();
                if (!bl3) {
                    throw iOException;
                }
                iOException = k10.q(iOException);
                throw iOException;
            }
        }
        boolean bl4 = k10.w();
        throw throwable2222222;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTimeout.source(");
        m0 m02 = this.b;
        stringBuilder.append(m02);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

