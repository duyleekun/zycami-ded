/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.h;

import com.zhiyun.protocol.message.bl.file.Direction;
import com.zhiyun.protocol.message.bl.file.FileType;
import d.v.y.d.b;
import d.v.y.d.k;
import java.util.Arrays;
import java.util.Objects;

public class a
extends d.v.y.c.s1.a {
    private int b;
    private int c;
    private FileType d;
    private Direction e;
    private String f;

    public a() {
        this.clear();
    }

    private byte[] d(byte[] object) {
        int n10 = ((byte[])object).length;
        int n11 = 10;
        if (n10 <= n11) {
            return object;
        }
        object = new IllegalArgumentException;
        object("Data \u4e0d\u80fd\u5927\u4e8e10\uff01\u8bf7\u53c2\u8003\u6587\u4ef6\u4f20\u8f93\u534f\u8bae");
        throw object;
    }

    private byte[] e(byte[] byArray, int n10) {
        byte[] byArray2 = new byte[n10];
        Arrays.fill(byArray2, (byte)0);
        int n11 = byArray.length;
        System.arraycopy(byArray, 0, byArray2, 0, n11);
        return byArray2;
    }

    private int i(byte[] byArray) {
        byte by2 = byArray[0];
        byte by3 = byArray[1];
        byte by4 = byArray[2];
        byte by5 = byArray[3];
        boolean bl2 = this.b();
        return d.v.y.d.b.u(by2, by3, by4, by5, bl2);
    }

    private byte[] q(int n10, int n11, FileType fileType, String string2) {
        byte[] byArray;
        if (n10 < 0) {
            byArray = k.h(fileType.toString());
        } else if (n10 == 0) {
            n10 = (int)(this.b() ? 1 : 0);
            byArray = d.v.y.d.b.s(n11, n10 != 0);
        } else {
            byArray = k.h(string2);
        }
        byArray = this.d(byArray);
        n11 = byArray.length;
        int n12 = 10;
        if (n11 < n12) {
            byArray = this.e(byArray, n12);
        }
        return byArray;
    }

    public byte[] a() {
        int n10;
        int n11 = 1;
        byte[] byArray = new byte[n11];
        byArray[0] = 6;
        int n12 = this.c;
        boolean bl2 = this.b();
        int n13 = 2;
        byte[] byArray2 = d.v.y.d.b.r(n12, n13, bl2);
        byte[] byArray3 = new byte[n11];
        byArray3[0] = n10 = (int)this.e.value;
        n10 = this.c;
        int n14 = this.b;
        FileType fileType = this.d;
        String string2 = this.f;
        byte[] byArray4 = this.q(n10, n14, fileType, string2);
        byte[][] byArrayArray = new byte[3][];
        byArrayArray[0] = byArray2;
        byArrayArray[n11] = byArray3;
        byArrayArray[n13] = byArray4;
        return d.v.y.d.a.a(byArray, byArrayArray);
    }

    public void clear() {
        Direction direction;
        this.c = (char)-1;
        this.e = direction = Direction.RECV;
        this.f = "";
    }

    public String f() {
        return this.f;
    }

    public Direction g() {
        return this.e;
    }

    public int h() {
        return this.b;
    }

    public FileType j() {
        return this.d;
    }

    public int k() {
        return this.c;
    }

    public void l(String string2) {
        Objects.requireNonNull(string2);
        this.f = string2;
    }

    public void m(Direction direction) {
        Objects.requireNonNull(direction);
        this.e = direction;
    }

    public void n(int n10) {
        this.b = n10;
    }

    public void o(FileType fileType) {
        this.d = fileType;
    }

    public void p(int n10) {
        this.c = n10;
    }

    public boolean parseFrom(byte[] object) {
        Object object2;
        int n10 = 0;
        int n11 = object[0];
        int n12 = 1;
        int n13 = 6;
        if (n11 == n13) {
            n11 = n12;
        } else {
            n11 = 0;
            object2 = null;
        }
        if (n11 != 0) {
            n11 = object[n12];
            n13 = object[2];
            boolean bl2 = this.b();
            n11 = d.v.y.d.b.y((byte)n11, (byte)n13, bl2);
            this.c = n11;
            this.e = object2 = Direction.toDirection(object[3]);
            object = d.v.y.d.a.d(object, 4);
            n11 = this.c;
            object2 = n11 > 0 ? k.c(object) : "";
            this.f = object2;
            n11 = this.c;
            if (n11 == 0) {
                n10 = this.i((byte[])object);
            }
            this.b = n10;
            n10 = this.c;
            object = n10 < 0 ? (Object)((Object)FileType.toFileType(object)) : null;
            this.d = (FileType)((Object)object);
            return n12;
        }
        return false;
    }
}

