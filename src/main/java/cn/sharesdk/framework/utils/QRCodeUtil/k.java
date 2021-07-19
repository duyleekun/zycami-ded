/*
 * Decompiled with CFR 0.151.
 */
package cn.sharesdk.framework.utils.QRCodeUtil;

import cn.sharesdk.framework.b.a.e;
import com.mob.MobSDK;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;

public class k {
    private String a;
    private e b;
    private Hashon c;
    private DeviceHelper d;
    private NetworkHelper e;

    public k() {
        Object object = new Hashon();
        this.c = object;
        this.e = object = new NetworkHelper();
        this.d = object = DeviceHelper.getInstance(MobSDK.getContext());
        this.b = object = cn.sharesdk.framework.b.a.e.a();
        object = new StringBuilder();
        CharSequence charSequence = this.d.getPackageName();
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append("/");
        charSequence = this.d.getAppVersionName();
        ((StringBuilder)object).append((String)charSequence);
        object = ((StringBuilder)object).toString();
        ((StringBuilder)charSequence).append("Android/");
        int n10 = this.d.getOSVersionInt();
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object);
        object = " ";
        stringBuilder.append((String)object);
        stringBuilder.append("ShareSDK/3.8.4");
        stringBuilder.append((String)object);
        stringBuilder.append((String)charSequence);
        this.a = object = stringBuilder.toString();
    }
}

