/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.j.n;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

public class c {
    private final String a;
    private final int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private char[] g;

    public c(X500Principal object) {
        int n10;
        this.a = object = ((X500Principal)object).getName("RFC2253");
        this.b = n10 = ((String)object).length();
    }

    private int a(int n10) {
        String string2;
        block2: {
            Object object;
            block6: {
                block10: {
                    int n11;
                    block8: {
                        int n12;
                        int n13;
                        block9: {
                            int n14;
                            int n15;
                            block7: {
                                int n16;
                                int n17;
                                block4: {
                                    block5: {
                                        block3: {
                                            n11 = n10 + 1;
                                            int n18 = this.b;
                                            string2 = "Malformed DN: ";
                                            if (n11 >= n18) break block2;
                                            object = this.g;
                                            n10 = object[n10];
                                            n13 = 70;
                                            n15 = 102;
                                            n12 = 65;
                                            n17 = 57;
                                            n14 = 97;
                                            n16 = 48;
                                            if (n10 < n16 || n10 > n17) break block3;
                                            n10 -= n16;
                                            break block4;
                                        }
                                        if (n10 < n14 || n10 > n15) break block5;
                                        n10 += -87;
                                        break block4;
                                    }
                                    if (n10 < n12 || n10 > n13) break block6;
                                    n10 += -55;
                                }
                                n11 = object[n11];
                                if (n11 < n16 || n11 > n17) break block7;
                                n11 -= n16;
                                break block8;
                            }
                            if (n11 < n14 || n11 > n15) break block9;
                            n11 += -87;
                            break block8;
                        }
                        if (n11 < n12 || n11 > n13) break block10;
                        n11 += -55;
                    }
                    return (n10 << 4) + n11;
                }
                CharSequence charSequence = new StringBuilder();
                charSequence.append(string2);
                object = this.a;
                charSequence.append((String)object);
                charSequence = charSequence.toString();
                IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
                throw illegalStateException;
            }
            CharSequence charSequence = new StringBuilder();
            charSequence.append(string2);
            object = this.a;
            charSequence.append((String)object);
            charSequence = charSequence.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
            throw illegalStateException;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append(string2);
        String string3 = this.a;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    private String b() {
        int n10;
        int n11;
        char[] cArray;
        int n12;
        this.d = n12 = this.c;
        this.e = n12;
        while (true) {
            char[] cArray2;
            int n13;
            int n14;
            if ((n12 = this.c) >= (n14 = this.b)) {
                cArray = this.g;
                n11 = this.d;
                n10 = this.e - n11;
                String string2 = new String(cArray, n11, n10);
                return string2;
            }
            cArray = this.g;
            n11 = cArray[n12];
            n10 = 44;
            int n15 = 43;
            int n16 = 59;
            int n17 = 32;
            if (n11 != n17) {
                if (n11 != n16) {
                    n16 = 92;
                    if (n11 != n16) {
                        if (n11 != n15 && n11 != n10) {
                            n11 = this.e;
                            this.e = n10 = n11 + 1;
                            cArray[n11] = n10 = cArray[n12];
                            this.c = ++n12;
                            continue;
                        }
                    } else {
                        n12 = this.e;
                        this.e = n11 = n12 + 1;
                        cArray[n12] = n11 = (int)this.d();
                        this.c = n12 = this.c + 1;
                        continue;
                    }
                }
                cArray = this.g;
                n11 = this.d;
                n10 = this.e - n11;
                String string3 = new String(cArray, n11, n10);
                return string3;
            }
            this.f = n11 = this.e;
            this.c = ++n12;
            this.e = n12 = n11 + 1;
            cArray[n11] = n17;
            while ((n12 = this.c) < (n14 = this.b) && (n13 = (cArray2 = this.g)[n12]) == n17) {
                n14 = this.e;
                this.e = n13 = n14 + 1;
                cArray2[n14] = n17;
                this.c = ++n12;
            }
            if (n12 == n14 || (n11 = (cArray = this.g)[n12]) == n10 || (n11 = cArray[n12]) == n15 || (n12 = cArray[n12]) == n16) break;
        }
        cArray = this.g;
        n11 = this.d;
        n10 = this.f - n11;
        String string4 = new String(cArray, n11, n10);
        return string4;
    }

    private char d() {
        int n10;
        this.c = n10 = this.c + 1;
        int n11 = this.b;
        if (n10 != n11) {
            char[] cArray = this.g;
            int n12 = cArray[n10];
            int n13 = 32;
            if (n12 != n13 && n12 != (n13 = 37) && n12 != (n13 = 92) && n12 != (n13 = 95) && n12 != (n13 = 34) && n12 != (n13 = 35)) {
                switch (n12) {
                    default: {
                        switch (n12) {
                            default: {
                                return this.f();
                            }
                            case 59: 
                            case 60: 
                            case 61: 
                            case 62: 
                        }
                    }
                    case 42: 
                    case 43: 
                    case 44: 
                }
            }
            return cArray[n10];
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Unexpected end of DN: ");
        String string2 = this.a;
        charSequence.append(string2);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    private char f() {
        int n10 = this.c;
        n10 = this.a(n10);
        int n11 = this.c;
        int n12 = 1;
        this.c = n11 += n12;
        n11 = 128;
        if (n10 < n11) {
            return (char)n10;
        }
        int n13 = 192;
        char c10 = '?';
        if (n10 >= n13 && n10 <= (n13 = 247)) {
            n13 = 223;
            if (n10 <= n13) {
                n10 &= 0x1F;
                n13 = n12;
            } else {
                n13 = 239;
                if (n10 <= n13) {
                    n13 = 2;
                    n10 &= 0xF;
                } else {
                    n13 = 3;
                    n10 &= 7;
                }
            }
            for (int i10 = 0; i10 < n13; ++i10) {
                int n14;
                char[] cArray;
                int n15;
                this.c = n15 = this.c + n12;
                int n16 = this.b;
                if (n15 != n16 && (n16 = (cArray = this.g)[n15]) == (n14 = 92)) {
                    this.c = ++n15;
                    n15 = this.a(n15);
                    this.c = n16 = this.c + n12;
                    n16 = n15 & 0xC0;
                    if (n16 != n11) {
                        return c10;
                    }
                    n10 <<= 6;
                    n10 += (n15 &= 0x3F);
                    continue;
                }
                return c10;
            }
            return (char)n10;
        }
        return c10;
    }

    private String g() {
        int n10 = this.c;
        int n11 = n10 + 4;
        Object object = this.b;
        Object object2 = "Unexpected end of DN: ";
        if (n11 < object) {
            Object object3;
            int n12;
            Object object4;
            block7: {
                this.d = n10++;
                this.c = n10;
                while ((n10 = this.c) != (n11 = this.b) && (object = (object4 = this.g)[n10]) != (n12 = 43) && (object = object4[n10]) != (n12 = 44) && (object = object4[n10]) != (n12 = 59)) {
                    object = object4[n10];
                    n12 = 32;
                    if (object == n12) {
                        this.e = n10++;
                        this.c = n10;
                        while ((n10 = this.c) < (n11 = this.b) && (n11 = (object4 = (Object)this.g)[n10]) == n12) {
                            this.c = ++n10;
                        }
                        break block7;
                    }
                    object = object4[n10];
                    object3 = 65;
                    if (object >= object3 && (object = (Object)object4[n10]) <= (object3 = 70)) {
                        object4[n10] = object = (Object)((char)(object4[n10] + n12));
                    }
                    this.c = ++n10;
                }
                this.e = n10;
            }
            n10 = this.e;
            n11 = this.d;
            object = 5;
            if ((n10 -= n11) >= object && (object = n10 & 1) != 0) {
                object = n10 / 2;
                object2 = new byte[object];
                ++n11;
                for (n12 = 0; n12 < object; ++n12) {
                    object3 = (byte)this.a(n11);
                    object2[n12] = object3;
                    n11 += 2;
                }
                char[] cArray = this.g;
                int n13 = this.d;
                object4 = new String(cArray, n13, n10);
                return object4;
            }
            object4 = new StringBuilder;
            object4 = new StringBuilder();
            object4.append((String)object2);
            String string2 = this.a;
            object4.append(string2);
            object4 = object4.toString();
            IllegalStateException illegalStateException = new IllegalStateException((String)object4);
            throw illegalStateException;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)object2);
        String string3 = this.a;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    private String h() {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        int n10;
        int n11;
        Object object5;
        while (true) {
            char[] cArray;
            object5 = this.c;
            n11 = this.b;
            n10 = 32;
            if (object5 >= n11 || (object4 = (cArray = this.g)[object5]) != n10) break;
            this.c = ++object5;
        }
        if (object5 == n11) {
            return null;
        }
        this.d = object5++;
        this.c = object5;
        while (true) {
            object5 = this.c;
            n11 = this.b;
            object4 = 61;
            if (object5 >= n11 || (object3 = (object2 = (Object)this.g)[object5]) == object4 || (object = object2[object5]) == n10) break;
            this.c = ++object5;
        }
        object2 = "Unexpected end of DN: ";
        if (object5 < n11) {
            Object object6;
            this.e = object5;
            Object object7 = this.g;
            if ((object5 = object7[object5]) == n10) {
                char[] cArray;
                char c10;
                while ((object5 = this.c) < (n11 = this.b) && (c10 = (cArray = this.g)[object5]) != object4 && (object3 = (Object)cArray[object5]) == n10) {
                    this.c = ++object5;
                }
                cArray = this.g;
                object3 = cArray[object5];
                if (object3 != object4 || object5 == n11) {
                    object7 = new StringBuilder;
                    object7();
                    object7.append((String)object2);
                    String string2 = this.a;
                    object7.append(string2);
                    object7 = object7.toString();
                    IllegalStateException illegalStateException = new IllegalStateException((String)object7);
                    throw illegalStateException;
                }
            }
            this.c = object5 = this.c + 1;
            while ((object5 = this.c) < (n11 = this.b) && (n11 = (object7 = this.g)[object5]) == n10) {
                this.c = ++object5;
            }
            object5 = this.e;
            n11 = this.d;
            n10 = 4;
            if ((object5 -= n11) > n10) {
                object6 = this.g;
                object4 = n11 + 3;
                object = 46;
                if (!((object4 = (Object)object6[object4]) != object || (object4 = (Object)object6[n11]) != (object = (Object)79) && (object4 = (Object)object6[n11]) != (object = (Object)111) || (object = object6[object4 = n11 + 1]) != (object3 = (Object)73) && (object4 = (Object)object6[object4]) != (object = (Object)105) || (object = object6[object4 = n11 + 2]) != (object3 = (Object)68) && (object5 = (Object)object6[object4]) != (object4 = 100))) {
                    this.d = n11 += n10;
                }
            }
            object7 = this.g;
            n10 = this.d;
            object4 = this.e - n10;
            object6 = new String((char[])object7, n10, (int)object4);
            return object6;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append((String)object2);
        String string3 = this.a;
        charSequence.append(string3);
        charSequence = charSequence.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    private String i() {
        Object object;
        int n10;
        Object object2;
        this.c = object2 = this.c + 1;
        this.d = object2;
        this.e = object2;
        while ((object2 = this.c) != (n10 = this.b)) {
            object = this.g;
            int n11 = object[object2];
            int n12 = 34;
            if (n11 == n12) {
                this.c = ++object2;
                while ((object2 = this.c) < (n10 = this.b) && (n10 = (object = (Object)this.g)[object2]) == (n11 = 32)) {
                    this.c = ++object2;
                }
                object = this.g;
                n11 = this.d;
                n12 = this.e - n11;
                String string2 = new String((char[])object, n11, n12);
                return string2;
            }
            n11 = (int)object[object2];
            n12 = 92;
            if (n11 == n12) {
                object2 = this.e;
                n11 = this.d();
                object[object2] = n11;
            } else {
                n11 = this.e;
                object2 = object[object2];
                object[n11] = object2;
            }
            this.c = object2 = this.c + 1;
            this.e = object2 = this.e + 1;
        }
        object = new StringBuilder;
        object();
        object.append("Unexpected end of DN: ");
        String string3 = this.a;
        object.append(string3);
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public String c(String object) {
        String string2;
        boolean n10 = false;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        Object object2 = this.a.toCharArray();
        this.g = object2;
        object2 = this.h();
        String string3 = null;
        if (object2 == null) {
            return null;
        }
        do {
            Object object3;
            Object object4;
            if ((object4 = this.c) == (object3 = this.b)) {
                return null;
            }
            char[] cArray = this.g;
            object4 = cArray[object4];
            object3 = 34;
            int n11 = 59;
            int n12 = 44;
            int n13 = 43;
            Object object5 = object4 != object3 ? (object4 != (object3 = 35) ? (object4 != n13 && object4 != n12 && object4 != n11 ? this.b() : "") : this.g()) : this.i();
            int n14 = ((String)object).equalsIgnoreCase((String)object2);
            if (n14 != 0) {
                return object5;
            }
            n14 = this.c;
            object4 = this.b;
            if (n14 >= object4) {
                return null;
            }
            object5 = this.g;
            object3 = object5[n14];
            string2 = "Malformed DN: ";
            if (object3 != n12 && (object3 = (Object)object5[n14]) != n11 && (object4 = (Object)object5[n14]) != n13) {
                object2 = new StringBuilder;
                ((StringBuilder)object2)();
                ((StringBuilder)object2).append(string2);
                string3 = this.a;
                ((StringBuilder)object2).append(string3);
                object2 = ((StringBuilder)object2).toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            this.c = ++n14;
        } while ((object2 = (Object)this.h()) != null);
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append(string2);
        string3 = this.a;
        ((StringBuilder)object2).append(string3);
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public List e(String object) {
        Object object2;
        Object object3;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        Object object4 = this.a.toCharArray();
        this.g = object4;
        object4 = Collections.emptyList();
        String string2 = this.h();
        if (string2 == null) {
            return object4;
        }
        while ((object3 = this.c) < (object2 = this.b)) {
            char[] cArray = this.g;
            object3 = cArray[object3];
            object2 = 34;
            int n10 = 59;
            int n11 = 44;
            int n12 = 43;
            Object object5 = object3 != object2 ? (object3 != (object2 = 35) ? (object3 != n12 && object3 != n11 && object3 != n10 ? this.b() : "") : this.g()) : this.i();
            int n13 = ((String)object).equalsIgnoreCase(string2);
            if (n13 != 0) {
                n13 = object4.isEmpty();
                if (n13 != 0) {
                    object4 = new ArrayList();
                }
                object4.add(object5);
            }
            if ((n13 = this.c) >= (object3 = this.b)) break;
            object5 = this.g;
            object2 = object5[n13];
            String string3 = "Malformed DN: ";
            if (object2 != n11 && (object2 = (Object)object5[n13]) != n10 && (object3 = (Object)object5[n13]) != n12) {
                object4 = new StringBuilder();
                ((StringBuilder)object4).append(string3);
                string2 = this.a;
                ((StringBuilder)object4).append(string2);
                object4 = ((StringBuilder)object4).toString();
                object = new IllegalStateException((String)object4);
                throw object;
            }
            this.c = ++n13;
            string2 = this.h();
            if (string2 != null) continue;
            object4 = new StringBuilder();
            ((StringBuilder)object4).append(string3);
            string2 = this.a;
            ((StringBuilder)object4).append(string2);
            object4 = ((StringBuilder)object4).toString();
            object = new IllegalStateException((String)object4);
            throw object;
        }
        return object4;
    }
}

