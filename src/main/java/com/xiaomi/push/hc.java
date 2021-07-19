/*
 * Decompiled with CFR 0.151.
 */
package com.xiaomi.push;

import com.xiaomi.push.fh;
import com.xiaomi.push.fu;
import com.xiaomi.push.gd;
import com.xiaomi.push.hc$a;
import java.net.UnknownHostException;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class hc {
    public static hc$a a(Exception object) {
        Object object2;
        Object object3;
        hc.a(object);
        boolean bl2 = object instanceof gd;
        if (bl2) {
            object3 = object;
            object3 = (gd)object;
            object2 = ((gd)object3).a();
            if (object2 != null) {
                object = ((gd)object3).a();
            }
        }
        object3 = new hc$a();
        object2 = ((Throwable)object).getMessage();
        Object object4 = ((Throwable)object).getCause();
        if (object4 != null) {
            object2 = ((Throwable)object).getCause().getMessage();
        }
        object4 = new StringBuilder();
        String string2 = object.getClass().getSimpleName();
        ((StringBuilder)object4).append(string2);
        string2 = ":";
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append((String)object2);
        object2 = ((StringBuilder)object4).toString();
        int n10 = fu.a(object);
        if (n10 != 0) {
            object4 = fh.i;
            int n11 = ((fh)((Object)object4)).a() + n10;
            object = fh.a(n11);
            ((hc$a)object3).a = object;
        }
        if ((object = ((hc$a)object3).a) == null) {
            object = fh.q;
            ((hc$a)object3).a = object;
        }
        if ((object = ((hc$a)object3).a) == (object4 = fh.q)) {
            ((hc$a)object3).a = object2;
        }
        return object3;
    }

    private static void a(Exception exception) {
        Objects.requireNonNull(exception);
    }

    public static hc$a b(Exception object) {
        Object object2;
        Object object3;
        Object object4;
        block5: {
            block6: {
                block4: {
                    boolean bl2;
                    hc.a(object);
                    boolean bl3 = object instanceof gd;
                    if (bl3) {
                        object4 = object;
                        object4 = (gd)object;
                        object3 = ((gd)object4).a();
                        if (object3 != null) {
                            object = ((gd)object4).a();
                        }
                    }
                    object4 = new hc$a();
                    object3 = ((Throwable)object).getMessage();
                    object2 = ((Throwable)object).getCause();
                    if (object2 != null) {
                        object3 = ((Throwable)object).getCause().getMessage();
                    }
                    int n10 = fu.a(object);
                    Object object5 = new StringBuilder();
                    String string2 = object.getClass().getSimpleName();
                    object5.append(string2);
                    string2 = ":";
                    object5.append(string2);
                    object5.append((String)object3);
                    object3 = object5.toString();
                    if (n10 == 0) break block4;
                    int n11 = fh.s.a() + n10;
                    object2 = fh.a(n11);
                    ((hc$a)object4).a = object2;
                    object5 = fh.D;
                    if (object2 != object5 || (object = ((Throwable)object).getCause()) == null || !(bl2 = object instanceof UnknownHostException)) break block5;
                    object = fh.C;
                    break block6;
                }
                object = fh.B;
            }
            ((hc$a)object4).a = object;
        }
        if ((object = ((hc$a)object4).a) == (object2 = fh.A) || object == (object2 = fh.B) || object == (object2 = fh.D)) {
            ((hc$a)object4).a = object3;
        }
        return object4;
    }

    public static hc$a c(Exception object) {
        Object object2;
        Object object3;
        Object object4;
        block8: {
            block7: {
                block4: {
                    block5: {
                        block6: {
                            hc.a((Exception)object);
                            boolean bl2 = object instanceof gd;
                            if (bl2) {
                                object4 = object;
                                object4 = (gd)object;
                                object3 = ((gd)object4).a();
                                if (object3 != null) {
                                    object = ((gd)object4).a();
                                }
                            }
                            object4 = new hc$a();
                            object3 = ((Throwable)object).getMessage();
                            object2 = ((Throwable)object).getCause();
                            if (object2 != null) {
                                object3 = ((Throwable)object).getCause().getMessage();
                            }
                            int n10 = fu.a((Throwable)object);
                            StringBuilder stringBuilder = new StringBuilder();
                            object = object.getClass().getSimpleName();
                            stringBuilder.append((String)object);
                            stringBuilder.append(":");
                            stringBuilder.append((String)object3);
                            object = stringBuilder.toString();
                            int n11 = 105;
                            if (n10 == n11) break block4;
                            n11 = 199;
                            if (n10 == n11) break block5;
                            n11 = 499;
                            if (n10 == n11) break block6;
                            int n12 = 109;
                            object3 = n10 != n12 ? (n10 != (n12 = 110) ? fh.M : fh.K) : fh.J;
                            break block7;
                        }
                        object2 = fh.O;
                        ((hc$a)object4).a = object2;
                        object2 = "Terminal binding condition encountered: item-not-found";
                        boolean bl3 = ((String)object3).startsWith((String)object2);
                        if (!bl3) break block8;
                        object3 = fh.N;
                        break block7;
                    }
                    object3 = fh.L;
                    break block7;
                }
                object3 = fh.I;
            }
            ((hc$a)object4).a = object3;
        }
        if ((object3 = ((hc$a)object4).a) == (object2 = fh.L) || object3 == (object2 = fh.M) || object3 == (object2 = fh.O)) {
            ((hc$a)object4).a = object;
        }
        return object4;
    }

    public static hc$a d(Exception object) {
        Object object2;
        Object object3;
        Object object4;
        block7: {
            block6: {
                block3: {
                    block4: {
                        block5: {
                            hc.a((Exception)object);
                            boolean bl2 = object instanceof gd;
                            if (bl2) {
                                object4 = object;
                                object4 = (gd)object;
                                object3 = ((gd)object4).a();
                                if (object3 != null) {
                                    object = ((gd)object4).a();
                                }
                            }
                            object4 = new hc$a();
                            object3 = ((Throwable)object).getMessage();
                            int n10 = fu.a((Throwable)object);
                            StringBuilder stringBuilder = new StringBuilder();
                            object = object.getClass().getSimpleName();
                            stringBuilder.append((String)object);
                            stringBuilder.append(":");
                            stringBuilder.append((String)object3);
                            object = stringBuilder.toString();
                            int n11 = 105;
                            if (n10 == n11) break block3;
                            n11 = 199;
                            if (n10 == n11) break block4;
                            n11 = 499;
                            if (n10 == n11) break block5;
                            int n12 = 109;
                            object3 = n10 != n12 ? (n10 != (n12 = 110) ? fh.Y : fh.W) : fh.V;
                            break block6;
                        }
                        ((hc$a)object4).a = object2 = fh.aa;
                        object2 = "Terminal binding condition encountered: item-not-found";
                        boolean bl3 = ((String)object3).startsWith((String)object2);
                        if (!bl3) break block7;
                        object3 = fh.Z;
                        break block6;
                    }
                    object3 = fh.X;
                    break block6;
                }
                object3 = fh.U;
            }
            ((hc$a)object4).a = object3;
        }
        if ((object3 = ((hc$a)object4).a) == (object2 = fh.X) || object3 == (object2 = fh.Y) || object3 == (object2 = fh.aa)) {
            ((hc$a)object4).a = object;
        }
        return object4;
    }
}

