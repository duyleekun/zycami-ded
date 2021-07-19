/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.c.s1.n;

import com.zhiyun.protocol.constants.BoxWorkingMode;
import com.zhiyun.protocol.constants.WorkingMode;
import java.util.Map;
import java.util.Objects;

public class d {
    private final Map a;

    public d(Map map) {
        Objects.requireNonNull(map);
        this.a = map;
    }

    private boolean b(int n10) {
        Map map = this.a;
        Object object = n10;
        object = (String)map.get(object);
        return "1".equals(object);
    }

    private int f(int n10) {
        Map map;
        try {
            map = this.a;
        }
        catch (Exception exception) {
            return -1;
        }
        Object object = n10;
        object = map.get(object);
        object = (String)object;
        return Integer.parseInt((String)object);
    }

    private boolean m(int n10) {
        Map map = this.a;
        Integer n11 = n10;
        return map.containsKey(n11);
    }

    public Map a() {
        return this.a;
    }

    public BoxWorkingMode c() {
        return BoxWorkingMode.from(this.f(4));
    }

    public int d() {
        return this.f(6);
    }

    public int e() {
        return this.f(5);
    }

    public int g() {
        return this.f(2);
    }

    public WorkingMode h() {
        return WorkingMode.from(this.f(3));
    }

    public boolean i() {
        return this.m(1);
    }

    public boolean j() {
        return this.m(4);
    }

    public boolean k() {
        return this.m(6);
    }

    public boolean l() {
        return this.m(5);
    }

    public boolean n() {
        return this.m(2);
    }

    public boolean o() {
        return this.m(3);
    }

    public boolean p() {
        return this.b(1);
    }
}

