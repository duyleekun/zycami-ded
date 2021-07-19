/*
 * Decompiled with CFR 0.151.
 */
package d.v.g.f.b.d;

import androidx.lifecycle.LiveData;
import com.zhiyun.device.data.local.entity.FirmwareInfo;
import java.util.List;

public interface e {
    public static final String a = "SELECT * FROM firmware_info WHERE serial=:serial AND union_version=:version AND (need_update OR force_update) LIMIT 1";
    public static final String b = "SELECT * FROM firmware_info WHERE serial=:serial AND union_version=:version AND has_popup = 1 AND (need_update OR force_update) LIMIT 1";

    public void a(FirmwareInfo var1);

    public void b(FirmwareInfo var1);

    public void c(List var1);

    public FirmwareInfo d(int var1, String var2);

    public LiveData e(int var1, String var2);

    public LiveData f(int var1, String var2);
}

