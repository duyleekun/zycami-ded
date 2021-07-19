/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.os.Message
 *  android.os.RemoteException
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fl;
import com.xiaomi.push.gh;
import com.xiaomi.push.gi;
import com.xiaomi.push.gj;
import com.xiaomi.push.gl;
import com.xiaomi.push.l;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.ap$b;
import com.xiaomi.push.service.at;
import com.xiaomi.push.service.p;

public class d {
    private p a;

    public d() {
        p p10;
        this.a = p10 = new p();
    }

    /*
     * Enabled aggressive block sorting
     */
    public static String a(ap$b object) {
        String string2 = "9";
        CharSequence charSequence = ((ap$b)object).g;
        boolean bl2 = string2.equals(charSequence);
        if (!bl2) {
            charSequence = new StringBuilder();
            object = ((ap$b)object).a;
            ((StringBuilder)charSequence).append((String)object);
            object = ".permission.MIPUSH_RECEIVE";
        } else {
            charSequence = new StringBuilder();
            object = ((ap$b)object).a;
            ((StringBuilder)charSequence).append((String)object);
            object = ".permission.MIMC_RECEIVE";
        }
        ((StringBuilder)charSequence).append((String)object);
        return ((StringBuilder)charSequence).toString();
    }

    private static void a(Context context, Intent intent, ap$b object) {
        String string2 = "com.xiaomi.xmsf";
        String string3 = context.getPackageName();
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            context.sendBroadcast(intent);
        } else {
            object = d.a((ap$b)object);
            context.sendBroadcast(intent, (String)object);
        }
    }

    public ap$b a(fl object) {
        int n10;
        Object object2 = ap.a();
        Object object3 = Integer.toString(((fl)object).a());
        boolean bl2 = (object2 = ((ap)object2).a((String)object3)).isEmpty();
        if (bl2) {
            return null;
        }
        object3 = object2.iterator();
        int n11 = object2.size();
        if (n11 == (n10 = 1)) {
            return (ap$b)object3.next();
        }
        object = ((fl)object).g();
        while ((n11 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            object2 = (ap$b)object3.next();
            String string2 = ((ap$b)object2).b;
            n10 = (int)(TextUtils.equals((CharSequence)object, (CharSequence)string2) ? 1 : 0);
            if (n10 == 0) continue;
            return object2;
        }
        return null;
    }

    public ap$b a(gj object) {
        int n10;
        Object object2 = ap.a();
        Object object3 = ((gj)object).k();
        boolean bl2 = (object2 = ((ap)object2).a((String)object3)).isEmpty();
        if (bl2) {
            return null;
        }
        object3 = object2.iterator();
        int n11 = object2.size();
        if (n11 == (n10 = 1)) {
            return (ap$b)object3.next();
        }
        object2 = ((gj)object).m();
        object = ((gj)object).l();
        while ((n10 = (int)(object3.hasNext() ? 1 : 0)) != 0) {
            ap$b ap$b = (ap$b)object3.next();
            String string2 = ap$b.b;
            boolean bl3 = TextUtils.equals((CharSequence)object2, (CharSequence)string2);
            if (!bl3 && !(bl3 = TextUtils.equals((CharSequence)object, (CharSequence)(string2 = ap$b.b)))) continue;
            return ap$b;
        }
        return null;
    }

    public void a(Context context) {
        Intent intent = new Intent();
        String string2 = "com.xiaomi.push.service_started";
        intent.setAction(string2);
        int n10 = l.c();
        if (n10 != 0) {
            n10 = 0x1000000;
            intent.addFlags(n10);
        }
        context.sendBroadcast(intent);
    }

    public void a(Context object, ap$b object2, int n10) {
        String string2 = "5";
        String string3 = ((ap$b)object2).g;
        boolean bl2 = string2.equalsIgnoreCase(string3);
        if (!bl2) {
            string3 = new Intent();
            string3.setAction("com.xiaomi.push.channel_closed");
            string2 = ((ap$b)object2).a;
            string3.setPackage(string2);
            string2 = at.r;
            String string4 = ((ap$b)object2).g;
            string3.putExtra(string2, string4);
            string3.putExtra("ext_reason", n10);
            String string5 = at.p;
            string2 = ((ap$b)object2).b;
            string3.putExtra(string5, string2);
            string5 = at.C;
            string2 = ((ap$b)object2).i;
            string3.putExtra(string5, string2);
            string5 = ((ap$b)object2).a;
            if (string5 != null && (n10 = (int)((string2 = "9").equals(string5 = ((ap$b)object2).g) ? 1 : 0)) != 0) {
                int n11 = 17;
                n10 = 0;
                string5 = null;
                object = Message.obtain(null, (int)n11, (Object)string3);
                string3 = ((ap$b)object2).a;
                try {
                    string3.send((Message)object);
                    return;
                }
                catch (RemoteException remoteException) {
                    ((ap$b)object2).a = null;
                    object = new StringBuilder();
                    string5 = "peer may died: ";
                    ((StringBuilder)object).append(string5);
                    object2 = ((ap$b)object2).b;
                    n10 = ((String)object2).lastIndexOf(64);
                    object2 = ((String)object2).substring(n10);
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                    b.a((String)object);
                }
            } else {
                d.a((Context)object, (Intent)string3, (ap$b)object2);
            }
        }
    }

    public void a(Context object, ap$b ap$b, String string2, String string3) {
        String string4 = "5";
        String string5 = ap$b.g;
        boolean bl2 = string4.equalsIgnoreCase(string5);
        if (bl2) {
            object = "mipush kicked by server";
            b.d((String)object);
        } else {
            string5 = new Intent();
            string5.setAction("com.xiaomi.push.kicked");
            string4 = ap$b.a;
            string5.setPackage(string4);
            string4 = "ext_kick_type";
            string5.putExtra(string4, string2);
            string5.putExtra("ext_kick_reason", string3);
            string2 = ap$b.g;
            string5.putExtra("ext_chid", string2);
            string2 = at.p;
            string3 = ap$b.b;
            string5.putExtra(string2, string3);
            string2 = at.C;
            string3 = ap$b.i;
            string5.putExtra(string2, string3);
            d.a(object, (Intent)string5, ap$b);
        }
    }

    public void a(Context context, ap$b ap$b, boolean bl2, int n10, String string2) {
        Object object = "5";
        String string3 = ap$b.g;
        boolean bl3 = ((String)object).equalsIgnoreCase(string3);
        if (bl3) {
            object = this.a;
            ((p)object).a(context, ap$b, bl2, n10, string2);
        } else {
            String string4;
            string3 = new Intent();
            string3.setAction("com.xiaomi.push.channel_opened");
            object = ap$b.a;
            string3.setPackage((String)object);
            object = "ext_succeeded";
            string3.putExtra((String)object, bl2);
            if (!bl2) {
                string4 = "ext_reason";
                string3.putExtra(string4, n10);
            }
            if (!(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
                string4 = "ext_reason_msg";
                string3.putExtra(string4, string2);
            }
            string4 = ap$b.g;
            string3.putExtra("ext_chid", string4);
            string4 = at.p;
            String string5 = ap$b.b;
            string3.putExtra(string4, string5);
            string4 = at.C;
            string5 = ap$b.i;
            string3.putExtra(string4, string5);
            d.a(context, (Intent)string3, ap$b);
        }
    }

    public void a(XMPushService object, String object2, fl object3) {
        ap$b ap$b = this.a((fl)object3);
        if (ap$b == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("error while notify channel closed! channel ");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" not registered");
            b.d(((StringBuilder)object).toString());
            return;
        }
        String string2 = "5";
        boolean bl2 = string2.equalsIgnoreCase((String)object2);
        if (bl2) {
            object2 = this.a;
            ((p)object2).a((XMPushService)object, (fl)object3, ap$b);
        } else {
            int n10;
            string2 = ap$b.a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(string2);
            String string3 = "ext_chid";
            intent.putExtra(string3, (String)object2);
            object2 = ap$b.h;
            object2 = ((fl)object3).a((String)object2);
            intent.putExtra("ext_raw_packet", (byte[])object2);
            object2 = at.C;
            object3 = ap$b.i;
            intent.putExtra((String)object2, (String)object3);
            object2 = at.v;
            object3 = ap$b.h;
            intent.putExtra((String)object2, (String)object3);
            object2 = ap$b.a;
            if (object2 != null) {
                n10 = 17;
                object3 = null;
                object2 = Message.obtain(null, (int)n10, (Object)intent);
                string3 = ap$b.a;
                try {
                    string3.send((Message)object2);
                    return;
                }
                catch (RemoteException remoteException) {
                    ap$b.a = null;
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("peer may died: ");
                    object3 = ap$b.b;
                    int n11 = ((String)object3).lastIndexOf(64);
                    object3 = ((String)object3).substring(n11);
                    ((StringBuilder)object2).append((String)object3);
                    object2 = ((StringBuilder)object2).toString();
                    b.a((String)object2);
                }
            }
            if ((n10 = (int)(((String)(object2 = "com.xiaomi.xmsf")).equals(string2) ? 1 : 0)) == 0) {
                d.a((Context)object, intent, ap$b);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public void a(XMPushService object, String object2, gj object3) {
        block5: {
            block9: {
                String string2;
                String string3;
                ap$b ap$b;
                block7: {
                    boolean bl2;
                    block8: {
                        block6: {
                            block4: {
                                ap$b = this.a((gj)object3);
                                if (ap$b != null) break block4;
                                object = new StringBuilder();
                                object3 = "error while notify channel closed! channel ";
                                ((StringBuilder)object).append((String)object3);
                                ((StringBuilder)object).append((String)object2);
                                object2 = " not registered";
                                ((StringBuilder)object).append((String)object2);
                                object = ((StringBuilder)object).toString();
                                break block5;
                            }
                            string3 = "5";
                            boolean bl3 = string3.equalsIgnoreCase((String)object2);
                            if (bl3) {
                                object2 = this.a;
                                ((p)object2).a((XMPushService)object, (gj)object3, ap$b);
                                return;
                            }
                            string3 = ap$b.a;
                            bl2 = object3 instanceof gi;
                            if (!bl2) break block6;
                            string2 = "com.xiaomi.push.new_msg";
                            break block7;
                        }
                        bl2 = object3 instanceof gh;
                        if (!bl2) break block8;
                        string2 = "com.xiaomi.push.new_iq";
                        break block7;
                    }
                    bl2 = object3 instanceof gl;
                    if (!bl2) break block9;
                    string2 = "com.xiaomi.push.new_pres";
                }
                Intent intent = new Intent();
                intent.setAction(string2);
                intent.setPackage(string3);
                string3 = "ext_chid";
                intent.putExtra(string3, (String)object2);
                object2 = ((gj)object3).a();
                intent.putExtra("ext_packet", (Bundle)object2);
                object2 = at.C;
                object3 = ap$b.i;
                intent.putExtra((String)object2, (String)object3);
                object2 = at.v;
                object3 = ap$b.h;
                intent.putExtra((String)object2, (String)object3);
                d.a((Context)object, intent, ap$b);
                return;
            }
            object = "unknown packet type, drop it";
        }
        b.d((String)object);
    }
}

