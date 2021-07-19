/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package d.v.c.s0;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.util.Pair;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.c.s0.q6$a;
import d.v.e.l.o1;
import java.util.Optional;

public class q6 {
    public static Drawable a(Context context, Pair object) {
        int n10 = 2131231420;
        if (object == null) {
            return o1.o(context.getResources(), n10);
        }
        Object object2 = Optional.ofNullable(((Pair)object).first);
        Comparable<Boolean> comparable = Boolean.FALSE;
        object2 = (Boolean)((Optional)object2).orElse((Object)comparable);
        boolean n11 = (Boolean)object2;
        object = Optional.ofNullable(((Pair)object).second);
        comparable = 0;
        object = (Integer)((Optional)object).orElse((Object)comparable);
        int n12 = (Integer)object;
        if (n11) {
            n10 = 100;
            n10 = n12 >= n10 ? 2131231426 : 2131231425;
        } else {
            int n13 = 76;
            if (n12 >= n13) {
                n10 = 2131231421;
            } else {
                int n14 = 51;
                if (n12 >= n14) {
                    n10 = 2131231424;
                } else {
                    int n15 = 16;
                    if (n12 >= n15) {
                        n10 = 2131231423;
                    } else {
                        int n16 = 6;
                        if (n12 >= n16) {
                            n10 = 2131231422;
                        }
                    }
                }
            }
        }
        return o1.m(context, n10);
    }

    public static int b(Integer n10) {
        int n11 = 2131953244;
        if (n10 == null) {
            return n11;
        }
        int n12 = n10;
        if (n12 != 0) {
            int n13 = 1;
            if (n12 != n13) {
                n13 = 2;
                if (n12 != n13) {
                    n13 = 3;
                    if (n12 != n13) {
                        n13 = 4;
                        if (n12 == n13) {
                            n11 = 2131953287;
                        }
                    } else {
                        n11 = 2131953288;
                    }
                } else {
                    n11 = 2131953285;
                }
            } else {
                n11 = 2131953289;
            }
        }
        return n11;
    }

    public static Drawable c(Context context, Pair object) {
        int n10 = 2131231568;
        if (object == null) {
            return o1.o(context.getResources(), n10);
        }
        Object object2 = Optional.ofNullable(((Pair)object).first);
        Comparable<Boolean> comparable = Boolean.FALSE;
        object2 = (Boolean)((Optional)object2).orElse((Object)comparable);
        boolean n11 = (Boolean)object2;
        object = Optional.ofNullable(((Pair)object).second);
        comparable = 0;
        object = (Integer)((Optional)object).orElse((Object)comparable);
        int n12 = (Integer)object;
        if (n11) {
            n10 = 100;
            n10 = n12 >= n10 ? 2131231574 : 2131231573;
        } else {
            int n13 = 76;
            if (n12 >= n13) {
                n10 = 2131231569;
            } else {
                int n14 = 51;
                if (n12 >= n14) {
                    n10 = 2131231572;
                } else {
                    int n15 = 16;
                    if (n12 >= n15) {
                        n10 = 2131231571;
                    } else {
                        int n16 = 6;
                        if (n12 >= n16) {
                            n10 = 2131231570;
                        }
                    }
                }
            }
        }
        return o1.m(context, n10);
    }

    public static int d(boolean n10, int n11) {
        int n12 = 2131231484;
        if (n10 != 0) {
            return n12;
        }
        n10 = -55;
        if (n11 > n10) {
            n12 = 2131231488;
        } else {
            n10 = -70;
            if (n11 > n10) {
                n12 = 2131231487;
            } else {
                n10 = -85;
                if (n11 > n10) {
                    n12 = 2131231486;
                } else {
                    n10 = -100;
                    if (n11 > n10) {
                        n12 = 2131231485;
                    }
                }
            }
        }
        return n12;
    }

    public static int e(WorkingMode object) {
        object = Optional.ofNullable(object);
        Object object2 = WorkingMode.PF;
        object = ((Optional)object).orElse(object2);
        object2 = q6$a.a;
        Object object3 = ((Enum)object).ordinal();
        Object object4 = 1;
        if ((object3 = (Object)((Object)object2[object3])) != object4) {
            object4 = 2;
            if (object3 != object4) {
                object4 = 3;
                if (object3 != object4) {
                    object4 = 4;
                    if (object3 != object4) {
                        object4 = 5;
                        if (object3 != object4) {
                            return 2131231508;
                        }
                        return 2131231457;
                    }
                    return 2131231504;
                }
                return 2131231615;
            }
            return 2131231456;
        }
        return 2131231503;
    }

    public static int f(WorkingMode object) {
        object = Optional.ofNullable(object);
        Object object2 = WorkingMode.PF;
        object = ((Optional)object).orElse(object2);
        object2 = q6$a.a;
        Object object3 = ((Enum)object).ordinal();
        Object object4 = 1;
        if ((object3 = (Object)((Object)object2[object3])) != object4) {
            object4 = 2;
            if (object3 != object4) {
                object4 = 3;
                if (object3 != object4) {
                    object4 = 4;
                    if (object3 != object4) {
                        object4 = 5;
                        if (object3 != object4) {
                            return 2131952760;
                        }
                        return 2131952762;
                    }
                    return 2131952758;
                }
                return 2131952761;
            }
            return 2131952757;
        }
        return 2131952759;
    }
}

