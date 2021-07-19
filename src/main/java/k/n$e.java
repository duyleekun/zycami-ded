/*
 * Decompiled with CFR 0.151.
 */
package k;

import java.lang.reflect.Method;
import java.util.Map;
import k.h;
import k.n;
import k.p;
import k.w;

public final class n$e
extends n {
    private final Method a;
    private final int b;
    private final h c;
    private final boolean d;

    public n$e(Method method, int n10, h h10, boolean bl2) {
        this.a = method;
        this.b = n10;
        this.c = h10;
        this.d = bl2;
    }

    public void d(p object, Map object2) {
        Object[] objectArray = null;
        if (object2 != null) {
            boolean bl2;
            object2 = object2.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                Object object3 = (Map.Entry)object2.next();
                String string2 = (String)object3.getKey();
                if (string2 != null) {
                    object3 = object3.getValue();
                    String string3 = "'.";
                    if (object3 != null) {
                        CharSequence charSequence = (String)this.c.convert(object3);
                        if (charSequence != null) {
                            bl2 = this.d;
                            ((p)object).a(string2, (String)charSequence, bl2);
                            continue;
                        }
                        object = this.a;
                        int n10 = this.b;
                        charSequence = new StringBuilder();
                        ((StringBuilder)charSequence).append("Field map value '");
                        ((StringBuilder)charSequence).append(object3);
                        ((StringBuilder)charSequence).append("' converted to null by ");
                        object3 = this.c.getClass().getName();
                        ((StringBuilder)charSequence).append((String)object3);
                        ((StringBuilder)charSequence).append(" for key '");
                        ((StringBuilder)charSequence).append(string2);
                        ((StringBuilder)charSequence).append(string3);
                        object3 = ((StringBuilder)charSequence).toString();
                        objectArray = new Object[]{};
                        throw w.o((Method)object, n10, (String)object3, objectArray);
                    }
                    object = this.a;
                    int n11 = this.b;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Field map contained null value for key '");
                    ((StringBuilder)object3).append(string2);
                    ((StringBuilder)object3).append(string3);
                    object3 = ((StringBuilder)object3).toString();
                    objectArray = new Object[]{};
                    throw w.o((Method)object, n11, (String)object3, objectArray);
                }
                object = this.a;
                int n12 = this.b;
                objectArray = new Object[]{};
                throw w.o((Method)object, n12, "Field map contained null key.", objectArray);
            }
            return;
        }
        object = this.a;
        int n13 = this.b;
        objectArray = new Object[]{};
        throw w.o((Method)object, n13, "Field map was null.", objectArray);
    }
}

