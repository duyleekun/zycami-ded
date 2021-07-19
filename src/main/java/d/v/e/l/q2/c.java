/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.l.q2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;
import com.zhiyun.common.util.gson.AutoValueGsonAdapterFactory;
import d.v.e.f;
import d.v.e.l.f1;
import d.v.e.l.s1;
import d.v.e.l.u1;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import m.a.a;

public class c {
    public static Object a(Class clazz, String string2) {
        Gson gson = c.g().create();
        try {
            return gson.fromJson(string2, clazz);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static List b(Type object, String string2) {
        Gson gson;
        try {
            gson = c.f();
        }
        catch (Exception exception) {
            exception.printStackTrace();
            object = new ArrayList();
            return object;
        }
        object = gson.fromJson(string2, (Type)object);
        return (List)object;
    }

    public static Map c(Type object, String string2) {
        Gson gson = c.g().enableComplexMapKeySerialization().create();
        try {
            object = gson.fromJson(string2, (Type)object);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
        return (Map)object;
    }

    public static Object d(String string2, Type type) {
        return c.e(string2, type, false);
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     */
    public static Object e(String object, Type object2, boolean bl2) {
        Object object3;
        Object object4;
        block23: {
            block24: {
                block25: {
                    block22: {
                        void var1_8;
                        block21: {
                            boolean bl3 = s1.q((String)object);
                            object4 = null;
                            if (!bl3 && !(bl3 = f1.a((String)object)) || object2 == null) {
                                return null;
                            }
                            if (bl2) {
                                object3 = f.a();
                                object3 = ((f)object3).b();
                                object3 = object3.getAssets();
                                object = object3.open((String)object);
                            } else {
                                object = object3 = new FileInputStream((String)object);
                            }
                            object3 = new InputStreamReader((InputStream)object);
                            Gson gson = c.f();
                            try {
                                object4 = gson.fromJson((Reader)object3, (Type)object2);
                            }
                            catch (Throwable throwable) {
                                break block21;
                            }
                            catch (Exception exception) {
                                break block22;
                            }
                            u1.a((Closeable)object);
                            break block24;
                            catch (Throwable throwable) {
                                bl2 = false;
                                object3 = null;
                            }
                        }
                        object4 = object;
                        object = var1_8;
                        break block23;
                        catch (Exception exception) {
                            bl2 = false;
                            object3 = null;
                        }
                    }
                    Type type = object2;
                    object2 = object;
                    object = type;
                    break block25;
                    catch (Throwable throwable) {
                        bl2 = false;
                        object3 = null;
                        break block23;
                    }
                    catch (Exception exception) {
                        object2 = null;
                        bl2 = false;
                        object3 = null;
                    }
                }
                try {
                    a.f((Throwable)object);
                }
                catch (Throwable throwable) {
                    object4 = object2;
                }
                u1.a((Closeable)object2);
            }
            u1.a((Closeable)object3);
            return object4;
        }
        u1.a(object4);
        u1.a((Closeable)object3);
        throw object;
    }

    private static Gson f() {
        return c.g().create();
    }

    private static GsonBuilder g() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        TypeAdapterFactory typeAdapterFactory = AutoValueGsonAdapterFactory.a();
        return gsonBuilder.registerTypeAdapterFactory(typeAdapterFactory);
    }

    public static String h(Class clazz, Object object) {
        return c.g().create().toJson(object, clazz);
    }

    public static String i(Type type, List list) {
        return c.f().toJson((Object)list, type);
    }

    public static String j(Type type, Map map) {
        return c.g().enableComplexMapKeySerialization().create().toJson((Object)map, type);
    }
}

