/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.em;
import com.xiaomi.push.ep;
import com.xiaomi.push.eq;
import com.xiaomi.push.es;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class er
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ eq a;
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;

    public er(eq eq2, String string2, Context context, String string3, String string4) {
        this.a = eq2;
        this.a = string2;
        this.a = context;
        this.b = string3;
        this.c = string4;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        String string2;
        String string3;
        int n10;
        Object object;
        block15: {
            block8: {
                object = this.a;
                int n11 = TextUtils.isEmpty((CharSequence)object);
                n10 = 1008;
                if (n11 != 0) break block8;
                try {
                    String string4;
                    CharSequence charSequence;
                    Object object2;
                    Object object3;
                    block9: {
                        block14: {
                            block10: {
                                String string5;
                                block13: {
                                    block12: {
                                        boolean bl2;
                                        block11: {
                                            object = this.a;
                                            object3 = this.a;
                                            int n12 = 1001;
                                            object2 = "get message";
                                            em.a((Context)object, (String)object3, n12, (String)object2);
                                            object3 = this.a;
                                            object = new JSONObject((String)object3);
                                            object3 = "action";
                                            object3 = object.optString((String)object3);
                                            charSequence = "awakened_app_packagename";
                                            charSequence = object.optString((String)charSequence);
                                            object2 = "awake_app_packagename";
                                            object2 = object.optString((String)object2);
                                            string4 = "awake_app";
                                            string4 = object.optString(string4);
                                            string5 = "awake_type";
                                            string5 = object.optString(string5);
                                            Object object4 = "awake_foreground";
                                            n11 = object.optInt((String)object4, 0);
                                            object4 = this.b;
                                            boolean bl3 = ((String)object4).equals(object2);
                                            if (!bl3 || !(bl3 = ((String)(object4 = this.c)).equals(string4))) break block9;
                                            bl3 = TextUtils.isEmpty((CharSequence)string5);
                                            if (bl3 || (bl3 = TextUtils.isEmpty((CharSequence)object2)) || (bl3 = TextUtils.isEmpty((CharSequence)string4)) || (bl3 = TextUtils.isEmpty((CharSequence)charSequence))) break block10;
                                            object4 = this.a;
                                            ((eq)object4).b((String)object2);
                                            object2 = this.a;
                                            ((eq)object2).a(string4);
                                            object2 = new ep();
                                            ((ep)object2).b((String)object3);
                                            ((ep)object2).a((String)charSequence);
                                            ((ep)object2).a(n11);
                                            object = this.a;
                                            ((ep)object2).d((String)object);
                                            object = "service";
                                            n11 = (int)(object.equals(string5) ? 1 : 0);
                                            if (n11 != 0) {
                                                n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                                                if (n11 == 0) {
                                                    object = this.a;
                                                    object3 = es.b;
                                                    charSequence = this.a;
                                                } else {
                                                    object = "com.xiaomi.mipush.sdk.PushMessageHandler";
                                                    ((ep)object2).c((String)object);
                                                    object = this.a;
                                                    object3 = es.c;
                                                    charSequence = this.a;
                                                }
                                                eq.a((eq)object, (es)((Object)object3), (Context)charSequence, (ep)object2);
                                                return;
                                            }
                                            object = es.a;
                                            object3 = ((es)object).a;
                                            bl2 = ((String)object3).equals(string5);
                                            if (!bl2) break block11;
                                            object3 = this.a;
                                            charSequence = this.a;
                                            break block12;
                                        }
                                        object = es.d;
                                        object3 = ((es)object).a;
                                        bl2 = ((String)object3).equals(string5);
                                        if (!bl2) break block13;
                                        object3 = this.a;
                                        charSequence = this.a;
                                    }
                                    eq.a((eq)object3, (es)((Object)object), (Context)charSequence, (ep)object2);
                                    return;
                                }
                                object = this.a;
                                object3 = this.a;
                                charSequence = new StringBuilder();
                                object2 = "A receive a incorrect message with unknown type ";
                                ((StringBuilder)charSequence).append((String)object2);
                                ((StringBuilder)charSequence).append(string5);
                                charSequence = ((StringBuilder)charSequence).toString();
                                break block14;
                            }
                            object = this.a;
                            object3 = this.a;
                            charSequence = "A receive a incorrect message with empty type";
                        }
                        em.a((Context)object, (String)object3, n10, (String)charSequence);
                        return;
                    }
                    object = this.a;
                    object3 = this.a;
                    charSequence = new StringBuilder();
                    string4 = "A receive a incorrect message with incorrect package info";
                    ((StringBuilder)charSequence).append(string4);
                    ((StringBuilder)charSequence).append((String)object2);
                    charSequence = ((StringBuilder)charSequence).toString();
                    em.a((Context)object, (String)object3, n10, (String)charSequence);
                    return;
                }
                catch (JSONException jSONException) {
                    com.xiaomi.channel.commonutils.logger.b.a(jSONException);
                    object = this.a;
                    string3 = this.a;
                    string2 = "A meet a exception when receive the message";
                }
                break block15;
            }
            object = this.a;
            string3 = "null";
            string2 = "A receive a incorrect message with empty info";
        }
        em.a((Context)object, string3, n10, string2);
    }
}

