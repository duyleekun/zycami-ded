/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.LinearLayout
 */
package cn.sharesdk.facebook;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import cn.sharesdk.framework.InnerShareParams;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.Platform$ShareParams;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.SSDKLog;
import cn.sharesdk.framework.utils.ShareSDKFileProvider;
import com.mob.MobSDK;
import com.mob.tools.FakeActivity;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class j
extends FakeActivity {
    private PlatformActionListener a;
    private Platform b;
    private Platform$ShareParams c;
    private String d;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Intent a() {
        int n10;
        Intent intent = new Intent("com.facebook.platform.PLATFORM_ACTIVITY");
        Object object = "com.facebook.katana";
        intent.setPackage((String)object);
        intent.addCategory("android.intent.category.DEFAULT");
        Bundle bundle = new Bundle();
        String string2 = null;
        bundle.putBoolean("DATA_FAILURES_FATAL", false);
        Object object2 = this.c.getTitle();
        Object object3 = "TITLE";
        bundle.putString((String)object3, (String)object2);
        object2 = this.c.getUrl();
        int n11 = TextUtils.isEmpty((CharSequence)object2);
        Object object4 = "type";
        String string3 = "HASHTAG";
        if (n11 == 0) {
            object = this.b;
            object2 = this.c.getUrl();
            object = ((Platform)object).getShortLintk((String)object2, false);
            object2 = "LINK";
            bundle.putString((String)object2, (String)object);
            bundle.putString((String)object4, (String)object2);
            object = this.c.getQuote();
            n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
            if (n10 == 0) {
                object = this.c.getQuote();
                object2 = "QUOTE";
                bundle.putString((String)object2, (String)object);
            }
            if ((n10 = (int)(TextUtils.isEmpty((CharSequence)(object = this.c.getHashtag())) ? 1 : 0)) == 0) {
                object = this.c.getHashtag();
                bundle.putString(string3, (String)object);
            }
        } else {
            object2 = this.c.getFilePath();
            n11 = TextUtils.isEmpty((CharSequence)object2);
            string2 = "DESCRIPTION";
            if (n11 == 0) {
                object2 = this.c.getFilePath();
                object = new File((String)object2);
                object = Uri.fromFile((File)object).toString();
                object2 = "VIDEO";
                bundle.putString((String)object2, (String)object);
                bundle.putString((String)object4, (String)object2);
                object = this.c.getText();
                bundle.putString(string2, (String)object);
                object = this.c.getTitle();
                bundle.putString((String)object3, (String)object);
                object = this.c.getHashtag();
                n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
                if (n10 == 0) {
                    object = this.c.getHashtag();
                    bundle.putString(string3, (String)object);
                }
            } else {
                object2 = this.c.getImageArray();
                if (object2 != null && (n11 = ((String[])(object2 = this.c.getImageArray())).length) > 0) {
                    try {
                        int n12;
                        object2 = new ArrayList();
                        object3 = new ArrayList();
                        object4 = this.c;
                        object4 = ((InnerShareParams)object4).getImageArray();
                        if (object4 != null) {
                            object3 = this.c;
                            object3 = ((InnerShareParams)object3).getImageArray();
                            object3 = Arrays.asList(object3);
                        }
                        object3 = object3.iterator();
                        while ((n12 = object3.hasNext()) != 0) {
                            object4 = object3.next();
                            Object object5 = new File((String)(object4 = (String)object4));
                            n12 = ((File)object5).exists();
                            if (n12 != 0) {
                                n12 = Build.VERSION.SDK_INT;
                                int n13 = 29;
                                if (n12 >= n13) {
                                    object4 = MobSDK.getContext();
                                    CharSequence charSequence = new StringBuilder();
                                    Object object6 = MobSDK.getContext();
                                    object6 = object6.getPackageName();
                                    charSequence.append((String)object6);
                                    object6 = ".cn.sharesdk.ShareSDKFileProvider";
                                    charSequence.append((String)object6);
                                    charSequence = charSequence.toString();
                                    object4 = ShareSDKFileProvider.a((Context)object4, (String)charSequence, (File)object5);
                                    object5 = MobSDK.getContext();
                                    n13 = 3;
                                    object5.grantUriPermission((String)object, (Uri)object4, n13);
                                    object4 = String.valueOf(object4);
                                    ((ArrayList)object2).add(object4);
                                    continue;
                                }
                                n13 = 24;
                                if (n12 >= n13) {
                                    object4 = MobSDK.getContext();
                                    object5 = ((File)object5).getAbsolutePath();
                                    object4 = ResHelper.pathToContentUri((Context)object4, (String)object5);
                                    object4 = object4.toString();
                                    ((ArrayList)object2).add(object4);
                                    continue;
                                }
                                object4 = Uri.fromFile((File)object5);
                                object4 = object4.toString();
                                ((ArrayList)object2).add(object4);
                                continue;
                            }
                            object4 = SSDKLog.b();
                            object5 = "Facebook share iamge ShareActivity file is not exist";
                            ((NLog)object4).w((String)object5);
                        }
                        object = this.c;
                        n10 = (int)(TextUtils.isEmpty((CharSequence)(object = ((InnerShareParams)object).getHashtag())) ? 1 : 0);
                        if (n10 == 0) {
                            object = this.c;
                            object = ((InnerShareParams)object).getHashtag();
                            bundle.putString(string3, (String)object);
                        }
                        object = "PHOTOS";
                        bundle.putStringArrayList((String)object, (ArrayList)object2);
                        object = this.c;
                        object = ((InnerShareParams)object).getText();
                        bundle.putString(string2, (String)object);
                        object = "NAME";
                        object2 = this.c;
                        object2 = ((InnerShareParams)object2).getTitle();
                        bundle.putString((String)object, (String)object2);
                    }
                    catch (Throwable throwable) {
                        object2 = SSDKLog.b();
                        ((NLog)object2).d(throwable);
                    }
                }
            }
        }
        n10 = 20171115;
        object = intent.putExtra("com.facebook.platform.protocol.PROTOCOL_VERSION", n10).putExtra("com.facebook.platform.protocol.PROTOCOL_ACTION", "com.facebook.platform.action.request.FEED_DIALOG");
        object2 = this.d;
        object.putExtra("com.facebook.platform.extra.APPLICATION_ID", (String)object2);
        object = new Bundle();
        object.putString("action_id", "cf61947c-a8fe-4fa3-aa7c-fbeb7f291352");
        object2 = DeviceHelper.getInstance(this.getContext());
        string2 = ((DeviceHelper)object2).getAppName();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2 && (n11 = (int)(((String)(object2 = ((DeviceHelper)object2).getNetworkTypeForStatic())).equals(object3 = "none") ? 1 : 0)) != 0) {
            object2 = "app_name";
            object.putString((String)object2, string2);
        }
        intent.putExtra("com.facebook.platform.protocol.BRIDGE_ARGS", (Bundle)object);
        intent.putExtra("com.facebook.platform.protocol.METHOD_ARGS", bundle);
        return intent;
    }

    public void a(PlatformActionListener platformActionListener, Platform platform, Platform$ShareParams platform$ShareParams, String string2) {
        this.a = platformActionListener;
        this.b = platform;
        this.c = platform$ShareParams;
        this.d = string2;
    }

    public void onActivityResult(int n10, int n11, Intent object) {
        this.finish();
        Object object2 = this.a;
        if (object2 != null) {
            int n12;
            object2 = null;
            if (object != null) {
                String string2 = "com.facebook.platform.protocol.RESULT_ARGS";
                object = object.getBundleExtra(string2);
            } else {
                n12 = 0;
                object = null;
            }
            int n13 = 9;
            if (object != null) {
                Object object3 = object.getString("completionGesture");
                Object object4 = "didComplete";
                n11 = (int)(object.getBoolean((String)object4) ? 1 : 0);
                n12 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
                if (n12 == 0) {
                    object4 = "cancel";
                    n11 = (int)(((String)object3).equalsIgnoreCase((String)object4) ? 1 : 0);
                    if (n11 != 0) {
                        object3 = this.a;
                        object4 = this.b;
                        object3.onCancel((Platform)object4, n13);
                    } else {
                        object4 = "post";
                        n10 = (int)(((String)object3).equalsIgnoreCase((String)object4) ? 1 : 0);
                        if (n10 != 0) {
                            object3 = this.a;
                            object4 = this.b;
                            object3.onComplete((Platform)object4, n13, null);
                        }
                    }
                } else if (n11 != 0) {
                    object3 = this.a;
                    object4 = this.b;
                    object3.onComplete((Platform)object4, n13, null);
                } else {
                    object3 = this.a;
                    object4 = this.b;
                    object3.onCancel((Platform)object4, n13);
                }
            } else {
                n12 = 64206;
                if (n10 == n12 && n11 == 0) {
                    PlatformActionListener platformActionListener = this.a;
                    Platform platform = this.b;
                    platformActionListener.onCancel(platform, n13);
                } else {
                    PlatformActionListener platformActionListener = this.a;
                    Platform platform = this.b;
                    object2 = "share error!";
                    object = new Throwable((String)object2);
                    platformActionListener.onError(platform, n13, (Throwable)object);
                }
            }
        }
    }

    public void onCreate() {
        block9: {
            super.onCreate();
            Object object = this.activity;
            LinearLayout linearLayout = new LinearLayout((Context)object);
            int n10 = 1;
            linearLayout.setOrientation(n10);
            object = this.activity;
            object.setContentView((View)linearLayout);
            linearLayout = this.a();
            if (linearLayout == null) break block9;
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

