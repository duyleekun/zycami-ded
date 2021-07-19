/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.AVFile;
import cn.leancloud.AVFriendship;
import cn.leancloud.AVFriendshipRequest;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVObject;
import cn.leancloud.AVRole;
import cn.leancloud.AVStatus;
import cn.leancloud.AVUser;
import cn.leancloud.gson.BaseOperationAdapter;
import cn.leancloud.gson.FileUploadTokenAdapter;
import cn.leancloud.gson.GeneralObjectAdapter;
import cn.leancloud.gson.GsonArray;
import cn.leancloud.gson.GsonObject;
import cn.leancloud.gson.GsonWrapper$1;
import cn.leancloud.gson.GsonWrapper$2;
import cn.leancloud.gson.JSONArrayAdapter;
import cn.leancloud.gson.JSONObjectAdapter;
import cn.leancloud.gson.MapDeserializerDoubleAsIntFix;
import cn.leancloud.gson.NumberDeserializerDoubleAsIntFix;
import cn.leancloud.gson.ObjectDeserializer;
import cn.leancloud.json.JSONObject;
import cn.leancloud.ops.AddOperation;
import cn.leancloud.ops.AddRelationOperation;
import cn.leancloud.ops.AddUniqueOperation;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.BitAndOperation;
import cn.leancloud.ops.BitOrOperation;
import cn.leancloud.ops.BitXOROperation;
import cn.leancloud.ops.CompoundOperation;
import cn.leancloud.ops.DecrementOperation;
import cn.leancloud.ops.DeleteOperation;
import cn.leancloud.ops.IncrementOperation;
import cn.leancloud.ops.NumericOperation;
import cn.leancloud.ops.RemoveOperation;
import cn.leancloud.ops.RemoveRelationOperation;
import cn.leancloud.ops.SetOperation;
import cn.leancloud.service.AppAccessEndpoint;
import cn.leancloud.sms.AVCaptchaDigest;
import cn.leancloud.sms.AVCaptchaValidateResult;
import cn.leancloud.upload.FileUploadToken;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.Primitives;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class GsonWrapper {
    public static String DEFFAULT_DATE_FORMAT;
    public static final BaseOperationAdapter baseOperationAdapter;
    public static Locale defaultLocale;
    public static TimeZone defaultTimeZone;
    public static final Gson gson;
    public static final JSONArrayAdapter jsonArrayAdapter;
    public static final JSONObjectAdapter jsonObjectAdapter;
    public static final ObjectDeserializer objectDeserializer;

    static {
        int[] nArray;
        Object object = AVCaptchaValidateResult.class;
        Object object2 = AVCaptchaDigest.class;
        Object object3 = AppAccessEndpoint.class;
        Object object4 = new ObjectDeserializer();
        objectDeserializer = object4;
        Object object5 = new BaseOperationAdapter();
        baseOperationAdapter = object5;
        Object object6 = new JSONObjectAdapter();
        jsonObjectAdapter = object6;
        Object object7 = new JSONArrayAdapter();
        jsonArrayAdapter = object7;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder = gsonBuilder.serializeNulls();
        int[] nArray2 = nArray = new int[3];
        nArray[0] = 8;
        nArray2[1] = 128;
        nArray2[2] = 64;
        object4 = gsonBuilder.excludeFieldsWithModifiers(nArray).registerTypeAdapter((Type)((Object)AVObject.class), object4).registerTypeAdapter((Type)((Object)AVUser.class), object4).registerTypeAdapter((Type)((Object)AVFile.class), object4).registerTypeAdapter((Type)((Object)AVRole.class), object4).registerTypeAdapter((Type)((Object)AVStatus.class), object4).registerTypeAdapter((Type)((Object)AVInstallation.class), object4).registerTypeAdapter((Type)((Object)AVFriendshipRequest.class), object4).registerTypeAdapter((Type)((Object)AVFriendship.class), object4).registerTypeAdapter((Type)((Object)BaseOperation.class), object5).registerTypeAdapter((Type)((Object)AddOperation.class), object5).registerTypeAdapter((Type)((Object)AddRelationOperation.class), object5).registerTypeAdapter((Type)((Object)AddUniqueOperation.class), object5).registerTypeAdapter((Type)((Object)BitAndOperation.class), object5).registerTypeAdapter((Type)((Object)BitOrOperation.class), object5).registerTypeAdapter((Type)((Object)BitXOROperation.class), object5).registerTypeAdapter((Type)((Object)CompoundOperation.class), object5).registerTypeAdapter((Type)((Object)DecrementOperation.class), object5).registerTypeAdapter((Type)((Object)DeleteOperation.class), object5).registerTypeAdapter((Type)((Object)IncrementOperation.class), object5).registerTypeAdapter((Type)((Object)NumericOperation.class), object5).registerTypeAdapter((Type)((Object)RemoveOperation.class), object5).registerTypeAdapter((Type)((Object)RemoveRelationOperation.class), object5).registerTypeAdapter((Type)((Object)SetOperation.class), object5).registerTypeAdapter((Type)((Object)GsonObject.class), object6).registerTypeAdapter((Type)((Object)JSONObject.class), object6).registerTypeAdapter((Type)((Object)GsonArray.class), object7);
        object6 = new FileUploadTokenAdapter();
        object4 = ((GsonBuilder)object4).registerTypeAdapter((Type)((Object)FileUploadToken.class), object6);
        object6 = FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES;
        object7 = TypeToken.get(object3);
        object5 = new GeneralObjectAdapter((FieldNamingPolicy)object6, (TypeToken)object7);
        object3 = ((GsonBuilder)object4).registerTypeAdapter((Type)object3, object5);
        object5 = TypeToken.get(object2);
        object4 = new GeneralObjectAdapter((FieldNamingPolicy)object6, (TypeToken)object5);
        object2 = ((GsonBuilder)object3).registerTypeAdapter((Type)object2, object4);
        object4 = TypeToken.get(object);
        object3 = new GeneralObjectAdapter((FieldNamingPolicy)object6, (TypeToken)object4);
        object = ((GsonBuilder)object2).registerTypeAdapter((Type)object, object3);
        object2 = new GsonWrapper$1();
        object2 = ((TypeToken)object2).getType();
        object3 = new MapDeserializerDoubleAsIntFix();
        object = ((GsonBuilder)object).registerTypeAdapter((Type)object2, object3);
        object3 = new MapDeserializerDoubleAsIntFix();
        gson = ((GsonBuilder)object).registerTypeAdapter((Type)((Object)Map.class), object3).create();
        defaultTimeZone = TimeZone.getDefault();
        defaultLocale = Locale.getDefault();
        DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    }

    public static final Date castToDate(Object object) {
        Object object2;
        int n10 = 0;
        Object object3 = null;
        if (object == null) {
            return null;
        }
        int n11 = object instanceof Calendar;
        if (n11 != 0) {
            return ((Calendar)object).getTime();
        }
        n11 = object instanceof Date;
        if (n11 != 0) {
            return (Date)object;
        }
        long l10 = -1;
        int n12 = object instanceof BigDecimal;
        String string2 = "can not cast to Date, value : ";
        if (n12 != 0) {
            int n13;
            object3 = object;
            object3 = (BigDecimal)object;
            n11 = ((BigDecimal)object3).scale();
            long l11 = n11 >= (n13 = -100) && n11 <= (n13 = 100) ? ((BigDecimal)object3).longValue() : ((BigDecimal)object3).longValueExact();
            l10 = l11;
        } else {
            n12 = object instanceof Number;
            if (n12 != 0) {
                object3 = object;
                object3 = (Number)object;
                l10 = ((Number)object3).longValue();
            } else {
                n12 = object instanceof String;
                if (n12 != 0) {
                    String string3;
                    object2 = object;
                    object2 = (String)object;
                    int n14 = ((String)object2).indexOf(45);
                    if (n14 != (n12 = -1)) {
                        int n15 = ((String)object2).length();
                        object = n15 == (n10 = ((String)(object3 = DEFFAULT_DATE_FORMAT)).length()) ? DEFFAULT_DATE_FORMAT : ((n15 = ((String)object2).length()) == (n10 = 10) ? "yyyy-MM-dd" : ((n15 = ((String)object2).length()) == (n10 = 19) ? "yyyy-MM-dd HH:mm:ss" : ((n15 = ((String)object2).length()) == (n10 = 29) && (n15 = (int)((String)object2).charAt(26)) == (n10 = 58) && (n15 = (int)((String)object2).charAt(28)) == (n10 = 48) ? "yyyy-MM-dd'T'HH:mm:ss.SSSXXX" : "yyyy-MM-dd HH:mm:ss.SSS")));
                        Locale locale = defaultLocale;
                        object3 = new SimpleDateFormat((String)object, locale);
                        object = defaultTimeZone;
                        ((DateFormat)object3).setTimeZone((TimeZone)object);
                        try {
                            return ((DateFormat)object3).parse((String)object2);
                        }
                        catch (ParseException parseException) {
                            object3 = new StringBuilder();
                            ((StringBuilder)object3).append(string2);
                            ((StringBuilder)object3).append((String)object2);
                            object3 = ((StringBuilder)object3).toString();
                            object = new IllegalArgumentException((String)object3);
                            throw object;
                        }
                    }
                    n14 = ((String)object2).length();
                    if (n14 != 0 && (n14 = (int)((string3 = "null").equals(object2) ? 1 : 0)) == 0) {
                        l10 = Long.parseLong((String)object2);
                    } else {
                        return null;
                    }
                }
            }
        }
        long l12 = 0L;
        n10 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (n10 >= 0) {
            object = new Date(l10);
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(object);
        object = ((StringBuilder)object2).toString();
        object3 = new IllegalArgumentException((String)object);
        throw object3;
    }

    public static Gson getGsonInstance() {
        return gson;
    }

    public static Object parseObject(String object) {
        Object object2;
        Gson gson;
        try {
            gson = GsonWrapper.gson;
        }
        catch (Exception exception) {
            gson = GsonWrapper.gson;
            object = gson.toJsonTree(object);
            boolean bl2 = ((JsonElement)object).isJsonPrimitive();
            object2 = null;
            if (bl2) {
                bl2 = ((JsonPrimitive)(object = ((JsonElement)object).getAsJsonPrimitive())).isBoolean();
                if (bl2) {
                    return ((JsonPrimitive)object).getAsBoolean();
                }
                bl2 = ((JsonPrimitive)object).isString();
                if (bl2) {
                    return ((JsonPrimitive)object).getAsString();
                }
                bl2 = ((JsonPrimitive)object).isNumber();
                if (bl2) {
                    return NumberDeserializerDoubleAsIntFix.parsePrecisionNumber(((JsonPrimitive)object).getAsNumber());
                }
                return null;
            }
            bl2 = ((JsonElement)object).isJsonArray();
            if (bl2) {
                return ((JsonElement)object).getAsJsonArray();
            }
            return null;
        }
        object2 = new GsonWrapper$2();
        object2 = ((TypeToken)object2).getType();
        return gson.fromJson((String)object, (Type)object2);
    }

    public static Object parseObject(String object, Class clazz) {
        Object object2;
        boolean bl2 = clazz.isPrimitive();
        if (!bl2 && !(bl2 = ((Class)(object2 = String.class)).isAssignableFrom(clazz))) {
            return gson.fromJson((String)object, clazz);
        }
        object2 = gson;
        object = ((Gson)object2).toJsonTree(object);
        return ((Gson)object2).fromJson((JsonElement)object, clazz);
    }

    public static Object parseObject(String object, Type type) {
        Object object2;
        block2: {
            block3: {
                boolean bl2 = Primitives.isPrimitive(type);
                if (bl2) break block2;
                bl2 = type instanceof Class;
                if (!bl2) break block3;
                object2 = String.class;
                Type type2 = type;
                type2 = (Class)type;
                bl2 = ((Class)object2).isAssignableFrom((Class<?>)type2);
                if (bl2) break block2;
            }
            return gson.fromJson((String)object, type);
        }
        object2 = gson;
        object = ((Gson)object2).toJsonTree(object, type);
        return ((Gson)object2).fromJson((JsonElement)object, type);
    }

    public static Object toJavaObject(JsonElement jsonElement) {
        if (jsonElement == null) {
            return null;
        }
        return GsonWrapper.toJavaObject(jsonElement, Object.class);
    }

    public static Object toJavaObject(JsonElement jsonElement, Class clazz) {
        if (jsonElement == null) {
            return null;
        }
        return gson.fromJson(jsonElement, clazz);
    }

    public static JsonElement toJsonElement(Object object) {
        if (object == null) {
            return null;
        }
        boolean bl2 = object instanceof GsonObject;
        if (bl2) {
            return ((GsonObject)object).getRawObject();
        }
        bl2 = object instanceof GsonArray;
        if (bl2) {
            return ((GsonArray)object).getRawObject();
        }
        return gson.toJsonTree(object);
    }

    public static String toJsonString(Map map) {
        if (map == null) {
            return null;
        }
        return gson.toJson(map);
    }
}

