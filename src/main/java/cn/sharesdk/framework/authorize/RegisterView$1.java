/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import cn.sharesdk.framework.authorize.RegisterView;
import cn.sharesdk.framework.utils.SSDKLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.ResHelper;

public class RegisterView$1
implements View.OnClickListener {
    public final /* synthetic */ RegisterView a;

    public RegisterView$1(RegisterView registerView) {
        this.a = registerView;
    }

    public void onClick(View view) {
        block11: {
            int n10;
            String string2;
            Object object;
            block10: {
                object = view.getContext();
                string2 = "ssdk_website";
                n10 = ResHelper.getStringRes((Context)object, string2);
                string2 = null;
                if (n10 <= 0) break block10;
                string2 = view.getResources();
                string2 = string2.getString(n10);
            }
            n10 = (int)(TextUtils.isEmpty((CharSequence)string2) ? 1 : 0);
            if (n10 != 0) break block11;
            object = Uri.parse((String)string2);
            String string3 = "android.intent.action.VIEW";
            string2 = new Intent(string3, (Uri)object);
            view = view.getContext();
            try {
                view.startActivity((Intent)string2);
            }
            catch (Throwable throwable) {
                object = SSDKLog.b();
                ((NLog)object).d(throwable);
            }
        }
    }
}

