/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q1;
import h.i0;
import h.j;
import h.k;
import h.k0;
import h.m;
import java.io.IOException;

public final class k$c
implements k0 {
    public final /* synthetic */ k a;
    public final /* synthetic */ k0 b;

    public k$c(k k10, k0 k02) {
        this.a = k10;
        this.b = k02;
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
    public void flush() {
        Throwable throwable2222222;
        k k10 = this.a;
        k10.v();
        Object object = this.b;
        object.flush();
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
    public void t(m m10, long l10) {
        Throwable throwable2222222;
        Object object;
        block8: {
            long l11;
            long l12;
            long l13;
            String string2 = "source";
            f0.p(m10, string2);
            long l14 = m10.S0();
            long l15 = 0L;
            j.e(l14, l15, l10);
            while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
                long l16;
                long l17;
                object = m10.a;
                f0.m(object);
                while ((l17 = (l16 = l11 - (l15 = (long)65536)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) < 0) {
                    l17 = ((i0)object).c;
                    int n10 = ((i0)object).b;
                    l15 = l17 - n10;
                    long l18 = (l11 += l15) - l10;
                    if ((l17 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1)) >= 0) {
                        l11 = l10;
                        break;
                    }
                    object = ((i0)object).f;
                    f0.m(object);
                }
                object = this.a;
                ((k)object).v();
                Object object2 = this.b;
                object2.t(m10, l11);
                object2 = q1.a;
                {
                    catch (Throwable throwable2222222) {
                        break block8;
                    }
                    catch (IOException iOException) {}
                    {
                        IOException iOException;
                        boolean bl2 = ((k)object).w();
                        if (!bl2) {
                            throw iOException;
                        }
                        iOException = ((k)object).q(iOException);
                        throw iOException;
                    }
                }
                l17 = (long)((k)object).w();
                if (l17 != false) throw ((k)object).q(null);
                l10 -= l11;
            }
            return;
        }
        boolean bl3 = ((k)object).w();
        throw throwable2222222;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("AsyncTimeout.sink(");
        k0 k02 = this.b;
        stringBuilder.append(k02);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

