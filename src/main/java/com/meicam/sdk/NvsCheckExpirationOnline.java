/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.util.Log
 *  org.json.JSONObject
 */
package com.meicam.sdk;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.meicam.sdk.NvsCheckExpirationOnline$1;
import com.meicam.sdk.NvsHttpsRequest;
import com.meicam.sdk.NvsSystemVariableManager;
import com.meicam.sdk.NvsTimeUtil;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class NvsCheckExpirationOnline {
    private static final String LICENSE_SERVER_DEFAULT_HOST = "api.meishesdk.com";
    private static final String TAG = "Meicam";
    private static NvsCheckExpirationOnline m_checker;
    private Context mContext = null;
    private Handler mHandler = null;
    private String mLicenseServerHost = "";
    private Thread mThread = null;
    private Runnable runnable;

    private NvsCheckExpirationOnline(Context object) {
        Runnable runnable = new NvsCheckExpirationOnline$1(this);
        this.runnable = runnable;
        this.mContext = object;
        this.mHandler = object;
        super(this);
        super(runnable);
        this.mThread = object;
    }

    public static /* synthetic */ Thread access$000(NvsCheckExpirationOnline nvsCheckExpirationOnline) {
        return nvsCheckExpirationOnline.mThread;
    }

    public static /* synthetic */ void access$100(NvsCheckExpirationOnline nvsCheckExpirationOnline) {
        nvsCheckExpirationOnline.checkExpiration();
    }

    private void checkExpiration() {
        int n10;
        CharSequence charSequence;
        String string2;
        Object object;
        Object object2;
        block18: {
            int n11;
            int n12;
            block17: {
                object2 = new NvsHttpsRequest();
                object = new HashMap();
                string2 = "isExpired";
                object.put("command", string2);
                charSequence = this.mContext.getPackageName();
                object.put("appId", charSequence);
                object.put("osType", "android");
                charSequence = this.mLicenseServerHost;
                n12 = ((String)charSequence).length();
                String string3 = "https://api.meishesdk.com/license/index.php";
                if (n12 > 0) {
                    charSequence = this.mLicenseServerHost;
                    String string4 = LICENSE_SERVER_DEFAULT_HOST;
                    string3 = string3.replace(string4, charSequence);
                }
                if ((n10 = ((String)(object2 = ((NvsHttpsRequest)object2).httpsRequest(string3, (Map)object))).isEmpty()) != 0) {
                    return;
                }
                object = new JSONObject((String)object2);
                object2 = "errNo";
                n11 = object.getInt((String)object2);
                if (n11 == 0) break block17;
                object2 = "errString";
                object2 = object.getString((String)object2);
                object = TAG;
                charSequence = new StringBuilder();
                string2 = "";
                ((StringBuilder)charSequence).append(string2);
                ((StringBuilder)charSequence).append((String)object2);
                object2 = ((StringBuilder)charSequence).toString();
                Log.e((String)object, (String)object2);
            }
            n11 = (int)(object.getBoolean(string2) ? 1 : 0);
            n10 = 0;
            object = null;
            n12 = 1;
            if (n11 != n12) break block18;
            n10 = n12;
        }
        object2 = this.mContext;
        NvsSystemVariableManager.setSystemVariableInt((Context)object2, string2, n10);
        object2 = NvsTimeUtil.getCurrentTime();
        object = this.mContext;
        charSequence = "lastTime";
        try {
            NvsSystemVariableManager.setSystemVariableString((Context)object, (String)charSequence, (String)object2);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static NvsCheckExpirationOnline init(Context context) {
        NvsCheckExpirationOnline nvsCheckExpirationOnline = m_checker;
        if (nvsCheckExpirationOnline != null) {
            return nvsCheckExpirationOnline;
        }
        m_checker = nvsCheckExpirationOnline = new NvsCheckExpirationOnline(context);
        return nvsCheckExpirationOnline;
    }

    public static NvsCheckExpirationOnline instance() {
        return m_checker;
    }

    public void release() {
        NvsCheckExpirationOnline nvsCheckExpirationOnline = m_checker;
        if (nvsCheckExpirationOnline == null) {
            return;
        }
        nvsCheckExpirationOnline = null;
        this.mContext = null;
        m_checker = null;
        Object object = this.mHandler;
        object.removeCallbacksAndMessages(null);
        object = this.mThread;
        ((Thread)object).join();
        try {
            this.mThread = null;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("");
            String string2 = exception.getMessage();
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            string2 = TAG;
            Log.e((String)string2, (String)object);
            exception.printStackTrace();
        }
    }

    public void startCheck(String string2) {
        int n10;
        Object object = this.mContext;
        if (object == null) {
            return;
        }
        this.mLicenseServerHost = string2;
        string2 = NvsSystemVariableManager.getSystemVariableString(object, "lastTime");
        int n11 = string2.isEmpty();
        if (n11 == 0 && (n10 = NvsTimeUtil.getHourRange(string2, (String)(object = NvsTimeUtil.getCurrentTime()))) >= 0 && n10 <= (n11 = 24)) {
            return;
        }
        n11 = 60000;
        n10 = NvsTimeUtil.getRandomTime(30000, n11);
        object = this.mHandler;
        if (object != null) {
            Runnable runnable = this.runnable;
            long l10 = n10;
            object.postDelayed(runnable, l10);
        }
    }
}

