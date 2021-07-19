/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.types;

import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import cn.leancloud.utils.StringUtil;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class AVDate {
    public static final String DEFAULT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    private static final ThreadLocal THREAD_LOCAL_DATE_FORMAT;
    private String iso;
    private String type = "Date";

    static {
        ThreadLocal threadLocal;
        THREAD_LOCAL_DATE_FORMAT = threadLocal = new ThreadLocal();
    }

    public AVDate() {
        this.iso = "";
    }

    public AVDate(JSONObject object) {
        String string2;
        this.iso = string2 = "";
        if (object != null) {
            string2 = "iso";
            this.iso = object = ((JSONObject)object).getString(string2);
        }
    }

    public AVDate(String string2) {
        this.iso = "";
        this.iso = string2;
    }

    public Date getDate() {
        TimeZone timeZone;
        Object object = THREAD_LOCAL_DATE_FORMAT;
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)((ThreadLocal)object).get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(DEFAULT_FORMAT);
            timeZone = DesugarTimeZone.getTimeZone("UTC");
            simpleDateFormat.setTimeZone(timeZone);
            ((ThreadLocal)object).set(simpleDateFormat);
        }
        object = this.iso;
        boolean bl2 = StringUtil.isEmpty((String)object);
        timeZone = null;
        if (bl2) {
            return null;
        }
        try {
            object = this.iso;
        }
        catch (ParseException parseException) {
            return null;
        }
        return simpleDateFormat.parse((String)object);
    }

    public String getIso() {
        return this.iso;
    }

    public String getType() {
        return this.type;
    }

    public void setIso(String string2) {
        this.iso = string2;
    }

    public void setType(String string2) {
        this.type = string2;
    }

    public String toJSONString() {
        return JSON.toJSONString(this);
    }
}

