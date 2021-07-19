/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.utils;

import cn.leancloud.AVException;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONObject;
import g.d0;
import java.io.IOException;
import java.io.Serializable;
import k.r;
import retrofit2.HttpException;

public class ErrorUtils {
    public static AVException illegalArgument(String string2) {
        return ErrorUtils.propagateException(9304, string2);
    }

    public static AVException invalidObjectIdException() {
        return ErrorUtils.propagateException(104, "Invalid object id.");
    }

    public static AVException invalidStateException() {
        return ErrorUtils.propagateException(9303, "Invalid State Exception.");
    }

    public static AVException invalidStateException(String string2) {
        return ErrorUtils.propagateException(9303, string2);
    }

    public static AVException propagateException(int n10, String string2) {
        AVException aVException = new AVException(n10, string2);
        return aVException;
    }

    public static AVException propagateException(String string2) {
        String string3;
        Serializable serializable;
        try {
            serializable = JSON.parseObject(string2);
            string3 = "error";
        }
        catch (Exception exception) {
            serializable = new AVException(999, string2);
            return serializable;
        }
        string3 = ((JSONObject)serializable).getString(string3);
        Object object = "code";
        int n10 = ((JSONObject)serializable).getIntValue((String)object);
        object = new AVException(n10, string3);
        return object;
    }

    public static AVException propagateException(Throwable object) {
        Object object2;
        if (object == null) {
            return null;
        }
        boolean bl2 = object instanceof HttpException;
        if (bl2) {
            object2 = object;
            object2 = (HttpException)object;
            Object object3 = ((HttpException)object2).response();
            if (object3 != null && (object2 = ((HttpException)object2).response()) != null && (object3 = ((r)object2).e()) != null) {
                try {
                    object2 = ((r)object2).e();
                }
                catch (IOException iOException) {}
                object2 = ((d0)object2).string();
                return ErrorUtils.propagateException((String)object2);
            }
        }
        object = ((Throwable)object).getMessage();
        object2 = new AVException(999, (String)object);
        return object2;
    }

    public static AVException sessionMissingException() {
        return ErrorUtils.propagateException(206, "No valid session token, make sure signUp or login has been called.");
    }
}

