/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import com.zhiyun.protocol.constants.Model;
import com.zhiyun.protocol.message.bl.other.UpgradeLink;
import java.util.Arrays;

public class xd {
    private Model a;
    private int b;
    private UpgradeLink c;
    private boolean d;
    private boolean e;
    private String[] f;

    public int a() {
        return this.b;
    }

    public UpgradeLink b() {
        return this.c;
    }

    public Model c() {
        return this.a;
    }

    public String[] d() {
        return this.f;
    }

    public boolean e() {
        return this.d;
    }

    public boolean f() {
        return this.e;
    }

    public void g(boolean bl2) {
        this.d = bl2;
    }

    public void h(boolean bl2) {
        this.e = bl2;
    }

    public void i(int n10) {
        this.b = n10;
    }

    public void j(UpgradeLink upgradeLink) {
        this.c = upgradeLink;
    }

    public void k(Model model) {
        this.a = model;
    }

    public void l(String ... stringArray) {
        this.f = stringArray;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Module{model=");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(", id=");
        int bl2 = this.b;
        stringBuilder.append(bl2);
        stringBuilder.append(", link=");
        object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", dependency=");
        boolean bl3 = this.d;
        stringBuilder.append(bl3);
        stringBuilder.append(", external=");
        boolean bl4 = this.e;
        stringBuilder.append(bl4);
        stringBuilder.append(", suffix=");
        object = Arrays.toString(this.f);
        stringBuilder.append((String)object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

