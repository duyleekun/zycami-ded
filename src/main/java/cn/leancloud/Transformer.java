/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud;

import cn.leancloud.AVFile;
import cn.leancloud.AVFriendship;
import cn.leancloud.AVFriendshipRequest;
import cn.leancloud.AVInstallation;
import cn.leancloud.AVLogger;
import cn.leancloud.AVObject;
import cn.leancloud.AVRole;
import cn.leancloud.AVStatus;
import cn.leancloud.AVUser;
import cn.leancloud.annotation.AVClassName;
import cn.leancloud.utils.LogUtil;
import cn.leancloud.utils.StringUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Transformer {
    private static Pattern classnamePattern;
    private static AVLogger logger;
    private static final Map subClassesMAP;
    private static final Map subClassesReverseMAP;

    static {
        HashMap hashMap;
        logger = LogUtil.getLogger(Transformer.class);
        classnamePattern = Pattern.compile("^[a-zA-Z_][a-zA-Z_0-9]*$");
        subClassesMAP = hashMap = new HashMap();
        subClassesReverseMAP = hashMap = new HashMap();
    }

    private Transformer() {
    }

    public static void checkClassName(String object) {
        boolean bl2 = StringUtil.isEmpty((String)object);
        if (!bl2) {
            Pattern pattern = classnamePattern;
            boolean bl3 = ((Matcher)(object = pattern.matcher((CharSequence)object))).matches();
            if (bl3) {
                return;
            }
            object = new IllegalArgumentException("Invalid class name");
            throw object;
        }
        object = new IllegalArgumentException("Blank class name");
        throw object;
    }

    public static Class getSubClass(String string2) {
        return (Class)subClassesMAP.get(string2);
    }

    public static String getSubClassName(Class clazz) {
        Class clazz2 = AVUser.class;
        boolean bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            return "_User";
        }
        clazz2 = AVRole.class;
        bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            return "_Role";
        }
        clazz2 = AVStatus.class;
        bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            return "_Status";
        }
        clazz2 = AVFile.class;
        bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            return "_File";
        }
        clazz2 = AVFriendship.class;
        bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            return "_Followee";
        }
        clazz2 = AVFriendshipRequest.class;
        bl2 = clazz2.isAssignableFrom(clazz);
        if (bl2) {
            return "_FriendshipRequest";
        }
        return (String)subClassesReverseMAP.get(clazz);
    }

    public static AVObject objectFromClassName(String object) {
        Object object2 = "_User";
        boolean bl2 = ((String)object2).equals(object);
        if (bl2) {
            object = new AVUser();
        } else {
            object2 = "_Status";
            bl2 = ((String)object2).equals(object);
            if (bl2) {
                object = new AVStatus();
            } else {
                object2 = "_Role";
                bl2 = ((String)object2).equals(object);
                if (bl2) {
                    object = new AVRole();
                } else {
                    object2 = "_File";
                    bl2 = ((String)object2).equals(object);
                    if (bl2) {
                        object = new AVFile();
                    } else {
                        object2 = "_Installation";
                        bl2 = ((String)object2).equals(object);
                        if (bl2) {
                            object = new AVInstallation();
                        } else {
                            object2 = "_FriendshipRequest";
                            bl2 = ((String)object2).equals(object);
                            if (bl2) {
                                object = new AVFriendshipRequest();
                            } else {
                                object2 = "_Followee";
                                bl2 = ((String)object2).equals(object);
                                if (bl2) {
                                    object = new AVFriendship();
                                } else {
                                    object2 = subClassesMAP;
                                    boolean bl3 = object2.containsKey(object);
                                    if (bl3) {
                                        object2 = object2.get(object);
                                        object2 = (Class)object2;
                                        object2 = ((Class)object2).newInstance();
                                        try {
                                            object2 = (AVObject)object2;
                                        }
                                        catch (Exception exception) {
                                            AVLogger aVLogger = logger;
                                            CharSequence charSequence = new StringBuilder();
                                            String string2 = "failed to create subClass: ";
                                            charSequence.append(string2);
                                            charSequence.append((String)object);
                                            charSequence = charSequence.toString();
                                            aVLogger.w((String)charSequence, exception);
                                            object2 = new AVObject((String)object);
                                        }
                                    } else {
                                        object2 = new AVObject((String)object);
                                    }
                                    object = object2;
                                }
                            }
                        }
                    }
                }
            }
        }
        return object;
    }

    public static void registerClass(Class serializable) {
        Object object = serializable.getAnnotation(AVClassName.class);
        if (object != null) {
            object = object.value();
            Transformer.checkClassName((String)object);
            subClassesMAP.put(object, serializable);
            subClassesReverseMAP.put(serializable, object);
            return;
        }
        serializable = new IllegalArgumentException("The class is not annotated by @AVClassName");
        throw serializable;
    }

    public static AVObject transform(AVObject aVObject, Class object) {
        if (aVObject == null) {
            return null;
        }
        Class clazz = subClassesReverseMAP;
        boolean bl2 = clazz.containsKey(object);
        if (bl2) {
            clazz = ((Class)object).newInstance();
            try {
                clazz = (AVObject)((Object)clazz);
            }
            catch (Exception exception) {
                AVLogger aVLogger = logger;
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "newInstance failed. cause: ";
                stringBuilder.append(string2);
                clazz = exception.getMessage();
                stringBuilder.append((String)((Object)clazz));
                clazz = stringBuilder.toString();
                aVLogger.w((String)((Object)clazz));
                object = ((Class)object).getSimpleName();
                clazz = new AVObject((String)object);
            }
        } else {
            clazz = AVUser.class;
            bl2 = clazz.isAssignableFrom((Class<?>)object);
            if (bl2) {
                clazz = new AVUser();
            } else {
                clazz = AVRole.class;
                bl2 = clazz.isAssignableFrom((Class<?>)object);
                if (bl2) {
                    clazz = new AVRole();
                } else {
                    clazz = AVStatus.class;
                    bl2 = clazz.isAssignableFrom((Class<?>)object);
                    if (bl2) {
                        clazz = new AVStatus();
                    } else {
                        clazz = AVFile.class;
                        bl2 = clazz.isAssignableFrom((Class<?>)object);
                        if (bl2) {
                            clazz = new AVFile();
                        } else {
                            clazz = AVFriendshipRequest.class;
                            bl2 = clazz.isAssignableFrom((Class<?>)object);
                            if (bl2) {
                                clazz = new AVFriendshipRequest();
                            } else {
                                clazz = AVFriendship.class;
                                bl2 = clazz.isAssignableFrom((Class<?>)object);
                                if (bl2) {
                                    clazz = new AVFriendship();
                                } else {
                                    object = ((Class)object).getSimpleName();
                                    clazz = new AVObject((String)object);
                                }
                            }
                        }
                    }
                }
            }
        }
        ((AVObject)((Object)clazz)).resetByRawData(aVObject);
        return clazz;
    }

    public static AVObject transform(AVObject aVObject, String object) {
        if (aVObject == null) {
            return null;
        }
        object = Transformer.objectFromClassName((String)object);
        ((AVObject)object).resetByRawData(aVObject);
        return object;
    }
}

