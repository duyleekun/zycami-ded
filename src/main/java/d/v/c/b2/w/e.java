/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.b2.w;

public class e {
    public static final int d = 255;
    private int a;
    private int b;
    private Object c;

    public e(int n10, int n11, Object object) {
        this.a = n10;
        this.b = n11;
        this.c = object;
    }

    public Object a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        boolean bl2;
        Object object = this.c;
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void e(Object object) {
        this.c = object;
    }

    public void f(int n10) {
        this.b = n10;
    }

    public void g(int n10) {
        this.a = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SelectedItemData{mSelectedDataRowIndex=");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", mSelectedDataColumnIndex=");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", data=");
        Object object = this.c;
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

