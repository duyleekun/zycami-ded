/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.s;

import android.content.Context;
import d.r.a.r.c;
import d.r.a.r.d;
import d.r.a.s.a;
import java.util.List;

public abstract class b
extends a {
    public final boolean isAllowNet(Context context) {
        return super.isAllowNet(context);
    }

    public final void onBind(Context context, int n10, String string2) {
        super.onBind(context, n10, string2);
    }

    public final void onDelAlias(Context context, int n10, List list, List list2, String string2) {
    }

    public final void onDelTags(Context context, int n10, List list, List list2, String string2) {
    }

    public final void onListTags(Context context, int n10, List list, String string2) {
        super.onListTags(context, n10, list, string2);
    }

    public final void onLog(Context context, String string2, int n10, boolean bl2) {
        super.onLog(context, string2, n10, bl2);
    }

    public final boolean onNotificationMessageArrived(Context context, c c10) {
        return false;
    }

    public final void onPublish(Context context, int n10, String string2) {
        super.onPublish(context, n10, string2);
    }

    public final void onSetAlias(Context context, int n10, List list, List list2, String string2) {
    }

    public final void onSetTags(Context context, int n10, List list, List list2, String string2) {
    }

    public void onTransmissionMessage(Context context, d d10) {
    }

    public final void onUnBind(Context context, int n10, String string2) {
        super.onUnBind(context, n10, string2);
    }
}

