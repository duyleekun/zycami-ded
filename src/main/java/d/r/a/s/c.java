/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.s;

import android.content.Context;
import d.r.a.r.d;
import java.util.List;

public interface c {
    public boolean isAllowNet(Context var1);

    public void onBind(Context var1, int var2, String var3);

    public void onDelAlias(Context var1, int var2, List var3, List var4, String var5);

    public void onDelTags(Context var1, int var2, List var3, List var4, String var5);

    public void onListTags(Context var1, int var2, List var3, String var4);

    public void onLog(Context var1, String var2, int var3, boolean var4);

    public boolean onNotificationMessageArrived(Context var1, d.r.a.r.c var2);

    public void onNotificationMessageClicked(Context var1, d.r.a.r.c var2);

    public void onPublish(Context var1, int var2, String var3);

    public void onReceiveRegId(Context var1, String var2);

    public void onSetAlias(Context var1, int var2, List var3, List var4, String var5);

    public void onSetTags(Context var1, int var2, List var3, List var4, String var5);

    public void onTransmissionMessage(Context var1, d var2);

    public void onUnBind(Context var1, int var2, String var3);
}

