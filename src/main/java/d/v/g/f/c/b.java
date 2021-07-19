/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.c;

import com.zhiyun.device.data.remote.entity.AppProductionList;
import com.zhiyun.net.RetrofitService;
import k.d;

public interface b {
    public static final b a = (b)RetrofitService.create(b.class);

    public d a(String var1, String var2, String var3, String var4, String var5);

    public d b(int var1, float var2, String var3);

    public d c(AppProductionList var1);
}

