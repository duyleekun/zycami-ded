/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.LinearLayout
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package cn.sharesdk.facebookmessenger;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.FakeActivity;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class b
extends FakeActivity {
    private String a;
    private Platform b;
    private PlatformActionListener c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private List i;
    private String j;

    private String b() {
        String string2 = this.j;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            this.j = string2 = this.f;
        }
        string2 = new JSONObject();
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("template_type", (Object)"generic");
        jSONObject2.put("sharable", false);
        jSONObject2.put("image_aspect_ratio", (Object)"horizontal");
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject3 = new JSONObject();
        String string3 = this.e;
        String string4 = "title";
        jSONObject3.put(string4, (Object)string3);
        string3 = this.g;
        jSONObject3.put("subtitle", (Object)string3);
        string3 = this.h;
        jSONObject3.put("image_url", (Object)string3);
        string3 = new JSONArray();
        Object object = new JSONObject();
        String string5 = "type";
        object = object.put(string5, (Object)"web_url");
        String string6 = this.j;
        string4 = object.put(string4, (Object)string6);
        object = this.f;
        JSONObject jSONObject4 = string4.put("url", object).put("webview_height_ratio", (Object)"full").put("messenger_extensions", false);
        string3.put((Object)jSONObject4);
        jSONObject3.put("buttons", (Object)string3);
        jSONArray.put((Object)jSONObject3);
        jSONObject2.put("elements", (Object)jSONArray);
        jSONObject.put(string5, (Object)"template");
        jSONObject.put("payload", (Object)jSONObject2);
        string2.put("attachment", (Object)jSONObject);
        return string2.toString();
    }

    public Intent a() {
        Object object;
        int n10;
        Bundle bundle = new Bundle();
        Object object2 = "DATA_FAILURES_FATAL";
        String string2 = null;
        bundle.putBoolean((String)object2, false);
        int n11 = this.d;
        int n12 = 2;
        if (n11 != n12) {
            n10 = 4;
            if (n11 == n10) {
                bundle.putString("PAGE", "1");
                bundle.putString("PREVIEW_TYPE", "DEFAULT");
                object2 = this.f;
                string2 = "ITEM_URL";
                bundle.putString(string2, (String)object2);
                object2 = this.g;
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                if (n11 == 0) {
                    object2 = this.g;
                    string2 = "SUBTITLE";
                    bundle.putString(string2, (String)object2);
                }
                if ((n11 = (int)(TextUtils.isEmpty((CharSequence)(object2 = this.e)) ? 1 : 0)) == 0) {
                    object2 = this.e;
                    bundle.putString("TITLE", (String)object2);
                    object2 = this.j;
                    n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                    string2 = "TARGET_DISPLAY";
                    if (n11 == 0) {
                        object2 = this.j;
                        bundle.putString(string2, (String)object2);
                    } else {
                        object2 = this.f;
                        bundle.putString(string2, (String)object2);
                    }
                }
                object2 = this.h;
                n11 = (int)(TextUtils.isEmpty((CharSequence)object2) ? 1 : 0);
                string2 = "IMAGE";
                if (n11 == 0) {
                    object2 = this.h;
                    bundle.putString(string2, (String)object2);
                } else {
                    object2 = "";
                    bundle.putString(string2, (String)object2);
                }
                object2 = "MESSENGER_PLATFORM_CONTENT";
                string2 = this.b();
                try {
                    bundle.putString((String)object2, string2);
                }
                catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        } else {
            object2 = new ArrayList();
            object = this.i;
            if (object != null && (n12 = object.size()) > 0) {
                for (n10 = 0; n10 < (n12 = (object = this.i).size()); ++n10) {
                    object = (String)this.i.get(n10);
                    boolean bl2 = TextUtils.isEmpty((CharSequence)object);
                    if (bl2) continue;
                    File file = new File((String)object);
                    object = Uri.fromFile((File)file).toString();
                    ((ArrayList)object2).add(object);
                }
            }
            string2 = "PHOTOS";
            bundle.putStringArrayList(string2, (ArrayList)object2);
        }
        object2 = new Intent("com.facebook.platform.PLATFORM_ACTIVITY");
        object2.setPackage("com.facebook.orca");
        object2.addCategory("android.intent.category.DEFAULT");
        string2 = object2.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", 20170417).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.MESSAGE_DIALOG");
        object = this.a;
        string2.putExtra("com.facebook.platform.extra.APPLICATION_ID", (String)object);
        string2 = new Bundle();
        object = UUID.randomUUID().toString();
        string2.putString("action_id", (String)object);
        object2.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", (Bundle)string2);
        object2.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
        return object2;
    }

    public void a(Platform platform, String string2) {
        this.a = string2;
        this.b = platform;
    }

    public void a(PlatformActionListener platformActionListener) {
        this.c = platformActionListener;
    }

    public void a(String string2, int n10, String string3, String string4, String string5, String string6, List list, String string7) {
        this.a = string2;
        this.d = n10;
        this.e = string3;
        this.f = string4;
        this.g = string5;
        this.h = string6;
        this.i = list;
        this.j = string7;
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        int n12;
        int n13 = 9;
        if (n10 == n10 && n11 == (n12 = -1)) {
            PlatformActionListener platformActionListener = this.c;
            Platform platform = this.b;
            platformActionListener.onComplete(platform, n13, null);
        } else if (n10 == n10 && n11 == 0) {
            PlatformActionListener platformActionListener = this.c;
            Platform platform = this.b;
            platformActionListener.onCancel(platform, n13);
        }
        this.finish();
        super.onActivityResult(n10, n11, intent);
    }

    public void onCreate() {
        block7: {
            Object object = this.activity;
            Object object2 = new LinearLayout((Context)object);
            int n10 = 1;
            object2.setOrientation(n10);
            object = this.activity;
            object.setContentView((View)object2);
            object2 = this.a();
            n10 = 64208;
            try {
                this.startActivityForResult((Intent)object2, n10);
            }
            catch (Exception exception) {
                object2 = this.c;
                if (object2 == null) break block7;
                object = this.b;
                int n11 = 9;
                String string2 = "start Activity error!";
                Throwable throwable = new Throwable(string2);
                object2.onError((Platform)object, n11, throwable);
                this.finish();
            }
        }
    }
}

