/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.Log
 *  org.json.JSONObject
 */
package com.meicam.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.meicam.sdk.NvsHttpsRequest;
import com.meicam.sdk.NvsStatisticsInfo;
import com.meicam.sdk.NvsSystemVariableManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class NvsStatisticsSender {
    private static String HTTPS_API_SET_STATISTICS = "https://api.meishesdk.com/statistics/index.php";
    private static final boolean NV_DEBUG = false;
    private static String NV_KEY_STATISTICS_APP_START_TIME = "NV_KEY_STATISTICS_APP_START_TIME";
    private static String NV_KEY_STATISTICS_INFO_CURRENT_DATE = "NV_KEY_STATISTICS_INFO_CURRENT_DATE";
    private static final int NV_STATISTICS_DAILY = 1;
    private static final int NV_STATISTICS_EVERY_START = 2;
    private static final int NV_STATISTICS_NEVER = 0;
    private static final String TAG = "Meicam";
    private static NvsStatisticsInfo m_statisticsInfo;
    private static NvsStatisticsSender m_statisticsSender;
    private Context m_context = null;
    private Handler m_handler = null;
    private boolean m_isStatisticsPrivateInfo = false;
    private int m_statisticsFrequency = 0;
    private HandlerThread m_thread = null;

    private NvsStatisticsSender(Context object) {
        this.m_context = object;
        super("StatisticsSendThread");
        this.m_thread = object;
        object.start();
        Looper looper = this.m_thread.getLooper();
        super(this, looper);
        this.m_handler = object;
    }

    public static /* synthetic */ void access$000(NvsStatisticsSender nvsStatisticsSender) {
        nvsStatisticsSender.startSendStatistics();
    }

    private String getCurrentDateString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long l10 = System.currentTimeMillis();
        Date date = new Date(l10);
        return simpleDateFormat.format(date);
    }

    public static NvsStatisticsSender getInstance() {
        return m_statisticsSender;
    }

    public static NvsStatisticsSender init(Context context) {
        Object object = m_statisticsSender;
        if (object != null) {
            return object;
        }
        object = new NvsStatisticsSender(context);
        m_statisticsSender = object;
        m_statisticsInfo = object = new NvsStatisticsInfo(context);
        return m_statisticsSender;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void startSendStatistics() {
        String string2;
        int n10;
        Object object;
        int n11;
        int n12 = this.m_statisticsFrequency;
        if (n12 == 0) {
            return;
        }
        Object object2 = this.m_context;
        Object object3 = NV_KEY_STATISTICS_APP_START_TIME;
        object2 = NvsSystemVariableManager.getSystemVariableStringSet((Context)object2, (String)object3);
        object3 = new HashSet();
        object2 = object2.iterator();
        while ((n11 = object2.hasNext()) != 0) {
            object = (String)object2.next();
            ((HashSet)object3).add(object);
        }
        object2 = m_statisticsInfo.getStartTime();
        ((HashSet)object3).add(object2);
        object2 = this.m_context;
        object = NV_KEY_STATISTICS_INFO_CURRENT_DATE;
        object2 = NvsSystemVariableManager.getSystemVariableString((Context)object2, (String)object);
        object = ((String)object2).trim();
        String string3 = this.getCurrentDateString();
        n11 = ((String)object).equals(string3);
        int n13 = 1;
        if (n11 != 0 && (n11 = this.m_statisticsFrequency) == n13) {
            return;
        }
        n12 = (int)(((String)(object2 = ((String)object2).trim())).equals(object = this.getCurrentDateString()) ? 1 : 0);
        if (n12 != 0 && (n12 = this.m_statisticsFrequency) == (n11 = 2)) {
            object2 = this.m_context;
            object = NV_KEY_STATISTICS_APP_START_TIME;
            NvsSystemVariableManager.setSystemVariableStringSet((Context)object2, (String)object, (Set)object3);
            return;
        }
        object2 = new HashSet();
        object = ((HashSet)object3).iterator();
        while ((n10 = object.hasNext()) != 0) {
            string2 = (String)object.next();
            ((HashSet)object2).add(string2);
        }
        object3 = ((HashSet)object3).iterator();
        while (true) {
            if ((n11 = (int)(object3.hasNext() ? 1 : 0)) == 0) {
                object3 = this.m_context;
                object = NV_KEY_STATISTICS_APP_START_TIME;
                NvsSystemVariableManager.setSystemVariableStringSet((Context)object3, (String)object, (Set)object2);
                object2 = this.m_context;
                object3 = NV_KEY_STATISTICS_INFO_CURRENT_DATE;
                object = this.getCurrentDateString();
                NvsSystemVariableManager.setSystemVariableString((Context)object2, (String)object3, (String)object);
                return;
            }
            object = (String)object3.next();
            try {
                string2 = new JSONObject();
                Object object4 = "appId";
                Object object5 = m_statisticsInfo;
                object5 = ((NvsStatisticsInfo)object5).getAppId();
                string2.put((String)object4, object5);
                object4 = "startTime";
                string2.put((String)object4, object);
                object4 = "deviceId";
                object5 = m_statisticsInfo;
                object5 = ((NvsStatisticsInfo)object5).getDeviceId();
                string2.put((String)object4, object5);
                object4 = "model";
                object5 = m_statisticsInfo;
                object5 = ((NvsStatisticsInfo)object5).getModel();
                string2.put((String)object4, object5);
                object4 = "osType";
                object5 = m_statisticsInfo;
                int n14 = ((NvsStatisticsInfo)object5).getOsType();
                string2.put((String)object4, n14);
                object4 = "osVersion";
                object5 = m_statisticsInfo;
                object5 = ((NvsStatisticsInfo)object5).getOsVersion();
                string2.put((String)object4, object5);
                boolean bl2 = this.m_isStatisticsPrivateInfo;
                if (bl2) {
                    object4 = "phoneNumber";
                    object5 = m_statisticsInfo;
                    object5 = ((NvsStatisticsInfo)object5).getPhoneNumber();
                    string2.put((String)object4, object5);
                    object4 = m_statisticsInfo;
                    object4 = ((NvsStatisticsInfo)object4).getLngAndLat();
                    object5 = "longitude";
                    Object var14_16 = null;
                    Object e10 = ((ArrayList)object4).get(0);
                    string2.put((String)object5, e10);
                    object5 = "latitude";
                    object4 = ((ArrayList)object4).get(n13);
                    string2.put((String)object5, object4);
                }
                string2 = string2.toString();
                object4 = new NvsHttpsRequest();
                object5 = new HashMap();
                String string4 = "command";
                String string5 = "setAppStatistics";
                ((HashMap)object5).put(string4, string5);
                String string6 = HTTPS_API_SET_STATISTICS;
                string2 = ((NvsHttpsRequest)object4).postHttpsRequest(string6, (Map)object5, string2);
                object4 = new JSONObject(string2);
                n10 = object4.getInt(string2 = "errNo");
                if (n10 != 0) continue;
                ((HashSet)object2).remove(object);
            }
            catch (Exception exception) {
                exception.printStackTrace();
                continue;
            }
            break;
        }
    }

    public void release() {
        NvsStatisticsSender nvsStatisticsSender = m_statisticsSender;
        if (nvsStatisticsSender != null) {
            nvsStatisticsSender = null;
            this.m_context = null;
            Object object = m_statisticsInfo;
            ((NvsStatisticsInfo)object).release();
            m_statisticsInfo = null;
            m_statisticsSender = null;
            this.m_handler = null;
            object = this.m_thread;
            object.quit();
            try {
                this.m_thread = null;
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
    }

    public void sendStatistics(int n10, boolean bl2) {
        this.m_statisticsFrequency = n10;
        this.m_isStatisticsPrivateInfo = bl2;
        this.m_handler.sendEmptyMessage(0);
    }
}

