/*
 * Decompiled with CFR 0.151.
 */
package d.j.f.a.a.k;

public class m {
    private String a;
    private Character b;
    private Character c;
    private int d = 0;
    private int e = 0;

    public m(String string2) {
        this.a = string2;
    }

    public static boolean d(Character c10) {
        int n10;
        boolean bl2 = false;
        if (c10 == null) {
            return false;
        }
        int n11 = c10.charValue();
        if (n11 >= (n10 = 48) && n11 <= (n10 = 57) || n11 >= (n10 = 97) && n11 <= (n10 = 102) || n11 >= (n10 = 65) && n11 <= (n10 = 70)) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean g(Character c10) {
        int n10;
        boolean bl2 = false;
        if (c10 == null) {
            return false;
        }
        int n11 = c10.charValue();
        if (n11 >= (n10 = 48) && n11 <= (n10 = 55)) {
            bl2 = true;
        }
        return bl2;
    }

    public int a() {
        return this.d;
    }

    public void b(Character c10) {
        this.b = c10;
    }

    public Character c() {
        Object object = this.b;
        int n10 = 0;
        if (object != null) {
            this.b = null;
            return object;
        }
        object = this.a;
        if (object == null) {
            return null;
        }
        int n11 = ((String)object).length();
        if (n11 == 0) {
            return null;
        }
        n11 = this.d;
        String string2 = this.a;
        int n12 = string2.length();
        if (n11 >= n12) {
            return null;
        }
        object = this.a;
        n10 = this.d;
        this.d = n12 = n10 + 1;
        return Character.valueOf(((String)object).charAt(n10));
    }

    public Character e() {
        Character c10 = this.c();
        if (c10 == null) {
            return null;
        }
        boolean bl2 = m.d(c10);
        if (bl2) {
            return c10;
        }
        return null;
    }

    public boolean f(char c10) {
        int n10;
        Object object = this.b;
        boolean bl2 = true;
        if (object != null && (n10 = ((Character)object).charValue()) == c10) {
            return bl2;
        }
        object = this.a;
        if (object == null) {
            return false;
        }
        n10 = ((String)object).length();
        if (n10 == 0) {
            return false;
        }
        n10 = this.d;
        String string2 = this.a;
        int n11 = string2.length();
        if (n10 >= n11) {
            return false;
        }
        object = this.a;
        n11 = this.d;
        n10 = ((String)object).charAt(n11);
        if (n10 != c10) {
            bl2 = false;
        }
        return bl2;
    }

    public Character h() {
        Character c10 = this.c();
        if (c10 == null) {
            return null;
        }
        boolean bl2 = m.g(c10);
        if (bl2) {
            return c10;
        }
        return null;
    }

    public Character i() {
        Object object = this.b;
        if (object != null) {
            return object;
        }
        object = this.a;
        int n10 = 0;
        if (object == null) {
            return null;
        }
        int n11 = ((String)object).length();
        if (n11 == 0) {
            return null;
        }
        n11 = this.d;
        String string2 = this.a;
        int n12 = string2.length();
        if (n11 >= n12) {
            return null;
        }
        object = this.a;
        n10 = this.d;
        return Character.valueOf(((String)object).charAt(n10));
    }

    public void j() {
        int n10;
        Character c10;
        this.c = c10 = this.b;
        this.e = n10 = this.d;
    }

    public String k() {
        String string2 = this.a;
        int n10 = this.d;
        string2 = string2.substring(n10);
        Comparable<Character> comparable = this.b;
        if (comparable != null) {
            comparable = new Comparable<Character>();
            Character c10 = this.b;
            ((StringBuilder)comparable).append(c10);
            ((StringBuilder)comparable).append(string2);
            string2 = ((StringBuilder)comparable).toString();
        }
        return string2;
    }

    public boolean l() {
        Object object = this.b;
        boolean bl2 = true;
        if (object != null) {
            return bl2;
        }
        object = this.a;
        if (object == null) {
            return false;
        }
        int n10 = ((String)object).length();
        if (n10 == 0) {
            return false;
        }
        n10 = this.d;
        String string2 = this.a;
        int n11 = string2.length();
        if (n10 >= n11) {
            return false;
        }
        return bl2;
    }

    public void m() {
        int n10;
        Character c10;
        this.b = c10 = this.c;
        this.d = n10 = this.e;
    }
}

