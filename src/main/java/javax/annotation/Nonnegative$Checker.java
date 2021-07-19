/*
 * Decompiled with CFR 0.151.
 */
package javax.annotation;

import javax.annotation.Nonnegative;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

public class Nonnegative$Checker
implements TypeQualifierValidator {
    /*
     * Enabled aggressive block sorting
     */
    public When b(Nonnegative nonnegative, Object object) {
        boolean bl2;
        block7: {
            block6: {
                block9: {
                    block8: {
                        block5: {
                            boolean bl3 = object instanceof Number;
                            if (!bl3) {
                                return When.NEVER;
                            }
                            object = (Number)object;
                            boolean bl4 = object instanceof Long;
                            bl2 = true;
                            if (!bl4) break block5;
                            long l10 = ((Number)object).longValue();
                            long l11 = 0L;
                            double d10 = 0.0;
                            Object object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                            if (object2 >= 0) break block6;
                            break block7;
                        }
                        boolean bl5 = object instanceof Double;
                        if (!bl5) break block8;
                        double d11 = ((Number)object).doubleValue();
                        long l12 = 0L;
                        double d12 = 0.0;
                        double d13 = d11 - d12;
                        Object object3 = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
                        if (object3 >= 0) break block6;
                        break block7;
                    }
                    boolean bl6 = object instanceof Float;
                    if (!bl6) break block9;
                    float f10 = ((Number)object).floatValue();
                    object = null;
                    float f11 = f10 - 0.0f;
                    Object object4 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
                    if (object4 >= 0) break block6;
                    break block7;
                }
                int n10 = ((Number)object).intValue();
                if (n10 < 0) break block7;
            }
            bl2 = false;
        }
        if (bl2) {
            return When.NEVER;
        }
        return When.ALWAYS;
    }
}

