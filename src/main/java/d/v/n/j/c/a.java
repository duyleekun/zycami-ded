/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.j.c;

import com.zhiyun.live.data.api.entity.LiveChannelActive;
import com.zhiyun.net.RetrofitService;
import g.b0;
import g.w$c;
import k.d;

public interface a {
    public static final String a = "service";
    public static final String b = "base_url:service";
    public static final a c = (a)RetrofitService.create(a.class);

    public d a(String var1, String var2, String var3, LiveChannelActive var4);

    public d b(String var1, String var2);

    public d c(String var1);

    public d d(String var1, String var2, String var3, String var4, String var5, String var6, String var7);

    public d e(String var1, String var2, String var3);

    public d f(b0 var1, b0 var2, b0 var3, b0 var4, b0 var5, w$c var6);

    public d g(String var1);

    public d h();

    public d i(String var1, String var2, String var3, String var4);

    public d j(String var1, String var2, String var3, String var4);

    public d k(int var1);
}

