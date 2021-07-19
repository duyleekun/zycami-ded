/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.i;

import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import d.v.y.d.b;
import java.util.ArrayList;
import java.util.Arrays;

public class a
extends d.v.y.c.s1.a {
    private d.v.y.b.a b;
    private KeyFunc c;
    private KeyFunc[] d;

    public a() {
        KeyFunc[] keyFuncArray = new d.v.y.b.a(0);
        this.b = keyFuncArray;
        keyFuncArray = KeyFunc.DEFAULT;
        this.c = keyFuncArray;
        keyFuncArray = new KeyFunc[]{};
        this.d = keyFuncArray;
    }

    public byte[] a() {
        int n10 = 1;
        byte[] byArray = new byte[n10];
        byArray[0] = 18;
        int n11 = this.b.f;
        boolean bl2 = this.b();
        byte[] byArray2 = d.v.y.d.b.r(n11, 2, bl2);
        byte[][] byArrayArray = new byte[n10][];
        byArrayArray[0] = byArray2;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        KeyFunc[] keyFuncArray = new d.v.y.b.a(0);
        this.b = keyFuncArray;
        keyFuncArray = KeyFunc.DEFAULT;
        this.c = keyFuncArray;
        keyFuncArray = new KeyFunc[]{};
        this.d = keyFuncArray;
    }

    public d.v.y.b.a d() {
        return this.b;
    }

    public KeyFunc e() {
        return this.c;
    }

    public KeyFunc[] f() {
        return this.d;
    }

    public void g(d.v.y.b.a a10) {
        this.b = a10;
    }

    public boolean parseFrom(byte[] objectArray) {
        int n10;
        int n11 = objectArray.length;
        int n12 = 2;
        if (n11 >= n12 && (n11 = objectArray[0]) == (n10 = 18)) {
            Object object;
            d.v.y.b.a a10;
            n11 = 1;
            n10 = objectArray[n11];
            n12 = objectArray[n12];
            int n13 = this.b();
            n12 = d.v.y.d.b.y((byte)n10, (byte)n12, n13 != 0);
            this.b = a10 = new d.v.y.b.a(n12);
            n12 = objectArray.length;
            n10 = 4;
            if (n12 >= n10) {
                n12 = objectArray[3] & 0xFF;
                object = KeyFunc.from(n12);
                this.c = object;
            }
            object = new ArrayList();
            n13 = objectArray.length;
            int n14 = 5;
            if (n13 >= n14) {
                while (n10 < (n13 = objectArray.length)) {
                    n13 = objectArray[n10] & 0xFF;
                    KeyFunc keyFunc = KeyFunc.from(n13);
                    object.add(keyFunc);
                    ++n10;
                }
            }
            objectArray = (Object[])new KeyFunc[0];
            objectArray = (Object[])((KeyFunc[])object.toArray(objectArray));
            this.d = (KeyFunc[])objectArray;
            return n11 != 0;
        }
        return false;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{event=");
        Object object = this.b.toString();
        stringBuilder.append((String)object);
        stringBuilder.append(", keyFunc=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", supportedKeyFunc=");
        object = Arrays.toString((Object[])this.d);
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

