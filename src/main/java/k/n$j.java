/*
 * Decompiled with CFR 0.151.
 */
package k;

import g.b0;
import g.s;
import java.lang.reflect.Method;
import java.util.Map;
import k.h;
import k.n;
import k.p;
import k.w;

public final class n$j
extends n {
    private final Method a;
    private final int b;
    private final h c;
    private final String d;

    public n$j(Method method, int n10, h h10, String string2) {
        this.a = method;
        this.b = n10;
        this.c = h10;
        this.d = string2;
    }

    public void d(p object, Map object2) {
        Object[] objectArray = null;
        if (object2 != null) {
            boolean bl2;
            object2 = object2.entrySet().iterator();
            while (bl2 = object2.hasNext()) {
                Object object3 = (Map.Entry)object2.next();
                Object object4 = (String)object3.getKey();
                if (object4 != null) {
                    if ((object3 = object3.getValue()) != null) {
                        String string2;
                        int n10 = 4;
                        Object object5 = new String[n10];
                        object5[0] = "Content-Disposition";
                        int n11 = 1;
                        StringBuilder stringBuilder = new StringBuilder();
                        String string3 = "form-data; name=\"";
                        stringBuilder.append(string3);
                        stringBuilder.append((String)object4);
                        stringBuilder.append("\"");
                        object4 = stringBuilder.toString();
                        object5[n11] = object4;
                        object5[2] = "Content-Transfer-Encoding";
                        int n12 = 3;
                        object5[n12] = string2 = this.d;
                        object4 = s.l((String[])object5);
                        object5 = this.c;
                        object3 = (b0)object5.convert(object3);
                        ((p)object).d((s)object4, (b0)object3);
                        continue;
                    }
                    object = this.a;
                    int n13 = this.b;
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Part map contained null value for key '");
                    ((StringBuilder)object3).append((String)object4);
                    ((StringBuilder)object3).append("'.");
                    object3 = ((StringBuilder)object3).toString();
                    objectArray = new Object[]{};
                    throw w.o((Method)object, n13, (String)object3, objectArray);
                }
                object = this.a;
                int n14 = this.b;
                objectArray = new Object[]{};
                throw w.o((Method)object, n14, "Part map contained null key.", objectArray);
            }
            return;
        }
        object = this.a;
        int n15 = this.b;
        objectArray = new Object[]{};
        throw w.o((Method)object, n15, "Part map was null.", objectArray);
    }
}

