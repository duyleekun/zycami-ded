/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.LocalDate;
import j$.time.d;
import j$.time.format.B;
import j$.time.format.f;
import j$.time.format.j;
import j$.time.format.m;
import j$.time.format.v;
import j$.time.q.u;
import j$.time.q.x;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

final class q
implements f {
    private char a;
    private int b;

    q(char c10, int n10) {
        this.a = c10;
        this.b = n10;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public boolean m(v object, StringBuilder stringBuilder) {
        int n10;
        int n11;
        Object object2;
        block8: {
            block9: {
                object2 = ((v)object).c();
                x x10 = j$.time.q.B.h;
                Objects.requireNonNull(object2, "locale");
                Object object3 = ((Locale)object2).getLanguage();
                object2 = ((Locale)object2).getCountry();
                Locale locale = new Locale((String)object3, (String)object2);
                object2 = Calendar.getInstance(locale);
                int n12 = ((Calendar)object2).getFirstDayOfWeek();
                object3 = d.d;
                long l10 = n12 + -1;
                d d10 = ((d)object3).o(l10);
                int n13 = ((Calendar)object2).getMinimalDaysInFirstWeek();
                object2 = j$.time.q.B.f(d10, n13);
                n12 = this.a;
                n11 = 87;
                n10 = 2;
                if (n12 == n11) break block9;
                n11 = 89;
                if (n12 != n11) {
                    n11 = 99;
                    if (n12 != n11 && n12 != (n11 = 101)) {
                        n11 = 119;
                        if (n12 != n11) {
                            object = new IllegalStateException("unreachable");
                            throw object;
                        }
                        object2 = ((j$.time.q.B)object2).i();
                        break block8;
                    } else {
                        object2 = ((j$.time.q.B)object2).c();
                    }
                    break block8;
                } else {
                    void var4_9;
                    u u10 = ((j$.time.q.B)object2).g();
                    int n14 = this.b;
                    if (n14 == n10) {
                        LocalDate localDate = m.i;
                        n14 = 2;
                        int n15 = 2;
                        Object object4 = object2;
                        object2 = new m(u10, n14, n15, 0, localDate, 0, null);
                        return ((j)object2).m((v)object, stringBuilder);
                    }
                    int n16 = 19;
                    n12 = 4;
                    if (n14 < n12) {
                        B b10 = B.a;
                    } else {
                        B b11 = B.d;
                    }
                    int n17 = -1;
                    Object object5 = object2;
                    object2 = new j(u10, n14, n16, (B)var4_9, n17);
                    return ((j)object2).m((v)object, stringBuilder);
                }
            }
            object2 = ((j$.time.q.B)object2).h();
        }
        n11 = this.b;
        n11 = n11 == n10 ? n10 : 1;
        B b12 = B.c;
        j j10 = new j((u)object2, n11, n10, b12);
        object2 = j10;
        return ((j)object2).m((v)object, stringBuilder);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String toString() {
        block5: {
            block8: {
                block9: {
                    block6: {
                        block7: {
                            block4: {
                                var1_1 = new StringBuilder(30);
                                var2_2 /* !! */  = "Localized(";
                                var1_1.append(var2_2 /* !! */ );
                                var3_3 = this.a;
                                var4_4 = ",";
                                var5_5 = 89;
                                if (var3_3 != var5_5) break block4;
                                var3_3 = this.b;
                                var5_5 = 1;
                                if (var3_3 == var5_5) {
                                    var2_2 /* !! */  = "WeekBasedYear";
lbl13:
                                    // 2 sources

                                    while (true) {
                                        var1_1.append(var2_2 /* !! */ );
                                        ** GOTO lbl62
                                        break;
                                    }
                                } else {
                                    var5_5 = 2;
                                    if (var3_3 == var5_5) {
                                        var2_2 /* !! */  = "ReducedValue(WeekBasedYear,2,2,2000-01-01)";
                                        ** continue;
                                    }
                                    var2_2 /* !! */  = "WeekBasedYear,";
                                    var1_1.append(var2_2 /* !! */ );
                                    var3_3 = this.b;
                                    var1_1.append(var3_3);
                                    var1_1.append(var4_4);
                                    var1_1.append(19);
                                    var1_1.append(var4_4);
                                    var3_3 = this.b;
                                    var6_6 = 4;
                                    var2_2 /* !! */  = var3_3 < var6_6 ? B.a : B.d;
                                    var1_1.append((Object)var2_2 /* !! */ );
                                }
                                break block5;
                            }
                            var5_5 = 87;
                            if (var3_3 == var5_5) break block6;
                            var5_5 = 99;
                            if (var3_3 == var5_5 || var3_3 == (var5_5 = 101)) break block7;
                            var5_5 = 119;
                            if (var3_3 != var5_5) break block8;
                            var2_2 /* !! */  = "WeekOfWeekBasedYear";
                            break block9;
                        }
                        var2_2 /* !! */  = "DayOfWeek";
                        break block9;
                    }
                    var2_2 /* !! */  = "WeekOfMonth";
                }
                var1_1.append(var2_2 /* !! */ );
            }
            var1_1.append(var4_4);
            var3_3 = this.b;
            var1_1.append(var3_3);
        }
        var1_1.append(")");
        return var1_1.toString();
    }
}

