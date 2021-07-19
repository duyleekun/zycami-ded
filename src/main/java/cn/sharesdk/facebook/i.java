/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.LinearLayout
 */
package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;

public class i
extends FakeActivity {
    private PlatformActionListener a;
    private Platform b;
    private String c;
    private Platform$ShareParams d;

    public Intent a() {
        String string2;
        Intent intent = new Intent("com.facebook.platform.PLATFORM_ACTIVITY");
        intent.setPackage("com.facebook.katana");
        intent.addCategory("android.intent.category.DEFAULT");
        Bundle bundle = new Bundle();
        String string3 = this.d.getUrl();
        bundle.putString("app_link_url", string3);
        string3 = this.d.getImageUrl();
        bundle.putString("preview_image_url", string3);
        int n10 = 20171115;
        string3 = intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", n10).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.APPINVITES_DIALOG");
        Object object = this.c;
        string3.putExtra("com.facebook.platform.extra.APPLICATION_ID", (String)object);
        string3 = new Bundle();
        string3.putString("action_id", "cf61947c-a8fe-4fa3-aa7c-fbeb7f291352");
        object = DeviceHelper.getInstance(this.getContext());
        String string4 = ((DeviceHelper)object).getAppName();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string4);
        if (!bl2 && (n10 = (int)(((String)(object = ((DeviceHelper)object).getNetworkTypeForStatic())).equals(string2 = "none") ? 1 : 0)) != 0) {
            object = "app_name";
            string3.putString((String)object, string4);
        }
        intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", (Bundle)string3);
        intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
        return intent;
    }

    public void a(PlatformActionListener platformActionListener, Platform platform, Platform$ShareParams platform$ShareParams) {
        this.a = platformActionListener;
        this.b = platform;
        this.d = platform$ShareParams;
    }

    public void a(String string2) {
        this.c = string2;
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        this.finish();
        int n12 = 9;
        if (object != null) {
            Object object2;
            Object object3 = object.getBundleExtra("com.facebook.platform.protocol.BRIDGE_ARGS");
            if (object3 != null) {
                boolean bl2;
                object2 = object3.keySet().iterator();
                while (bl2 = object2.hasNext()) {
                    CharSequence charSequence;
                    Object object4 = (String)object2.next();
                    boolean bl3 = ((String)object4).equals(charSequence = "error");
                    if (!bl3) continue;
                    if ((object3 = (Bundle)object3.get((String)object4)) != null) {
                        object2 = object3.keySet().iterator();
                        object = "";
                        while (bl2 = object2.hasNext()) {
                            object4 = (String)object2.next();
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append((String)object);
                            ((StringBuilder)charSequence).append((String)object4);
                            ((StringBuilder)charSequence).append(":");
                            object = object3.get((String)object4);
                            ((StringBuilder)charSequence).append(object);
                            ((StringBuilder)charSequence).append(", ");
                            object = ((StringBuilder)charSequence).toString();
                        }
                        object3 = "UserCanceled";
                        n10 = ((String)object).indexOf((String)object3);
                        if (n10 > (n11 = -1)) {
                            object3 = this.a;
                            object2 = this.b;
                            object3.onCancel((Platform)object2, n12);
                        }
                        object3 = this.a;
                        object2 = this.b;
                        object4 = new Throwable((String)object);
                        object3.onError((Platform)object2, n12, (Throwable)object4);
                    }
                    return;
                }
            }
            if ((object3 = object.getBundleExtra("com.facebook.platform.protocol.RESULT_ARGS")) != null) {
                int n13;
                object2 = "didComplete";
                n11 = object3.getInt((String)object2);
                if (n11 != (n13 = 1)) {
                    n13 = 0;
                    object = null;
                }
                object2 = "completionGesture";
                object3 = object3.getString((String)object2);
                n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n11 == 0) {
                    object2 = "cancel";
                    n10 = (int)(((String)object3).equalsIgnoreCase((String)object2) ? 1 : 0);
                    if (n10 != 0) {
                        object3 = this.a;
                        object2 = this.b;
                        object3.onCancel((Platform)object2, n12);
                    }
                } else if (n13 != 0) {
                    object3 = this.a;
                    object2 = this.b;
                    n13 = 0;
                    object = null;
                    object3.onComplete((Platform)object2, n12, null);
                }
            }
        } else {
            int n14 = 64206;
            if (n10 == n14 && n11 == 0) {
                PlatformActionListener platformActionListener = this.a;
                Platform platform = this.b;
                platformActionListener.onCancel(platform, n12);
            } else {
                PlatformActionListener platformActionListener = this.a;
                Platform platform = this.b;
                String string2 = "share error!";
                object = new Throwable(string2);
                platformActionListener.onError(platform, n12, (Throwable)object);
            }
        }
    }

    public void onCreate() {
        block11: {
            super.onCreate();
            Object object = this.activity;
            LinearLayout linearLayout = new LinearLayout((Context)object);
            int n10 = 1;
            linearLayout.setOrientation(n10);
            object = this.activity;
            try {
                object.setContentView((View)linearLayout);
            }
            catch (Exception exception) {
                object = SSDKLog.b();
                ((NLog)object).d(exception);
            }
            linearLayout = this.a();
            if (linearLayout == null) break block11;
            linearLayout = this.activity;
            object = this.a();
            int n11 = 64206;
            try {
                linearLayout.startActivityForResult((Intent)object, n11);
            }
            catch (Throwable throwable) {
                this.finish();
                object = this.a;
                Platform platform = this.b;
                int n12 = 9;
                object.onError(platform, n12, throwable);
            }
        }
    }
}

