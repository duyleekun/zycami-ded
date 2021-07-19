/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.base;

import com.google.common.base.Strings;
import com.google.common.base.VerifyException;

public final class Verify {
    private Verify() {
    }

    public static void verify(boolean bl2) {
        if (bl2) {
            return;
        }
        VerifyException verifyException = new VerifyException();
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, char c10, char c11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c12 = Character.valueOf(c10);
        objectArray[0] = c12;
        Character c13 = Character.valueOf(c11);
        objectArray[1] = c13;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, char c10, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, char c10, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, char c10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Character c11 = Character.valueOf(c10);
        objectArray[0] = c11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Integer n11 = n10;
        objectArray[0] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, int n10, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, int n10, int n11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n12 = n10;
        objectArray[0] = n12;
        Integer n13 = n11;
        objectArray[1] = n13;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, int n10, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, int n10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Integer n11 = n10;
        objectArray[0] = n11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[1];
        Long l11 = l10;
        objectArray[0] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, long l10, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, long l10, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, long l10, long l11) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l12 = l10;
        objectArray[0] = l12;
        Long l13 = l11;
        objectArray[1] = l13;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, long l10, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        Long l11 = l10;
        objectArray[0] = l11;
        objectArray[1] = object;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object};
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object, char c10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Character c11 = Character.valueOf(c10);
        objectArray[1] = c11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object, int n10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Integer n11 = n10;
        objectArray[1] = n11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object, long l10) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object;
        Long l11 = l10;
        objectArray[1] = l11;
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object, Object object2) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2};
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object, Object object2, Object object3) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2, object3};
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object object, Object object2, Object object3, Object object4) {
        if (bl2) {
            return;
        }
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static void verify(boolean bl2, String string2, Object ... objectArray) {
        if (bl2) {
            return;
        }
        string2 = Strings.lenientFormat(string2, objectArray);
        VerifyException verifyException = new VerifyException(string2);
        throw verifyException;
    }

    public static Object verifyNotNull(Object object) {
        Object[] objectArray = new Object[]{};
        return Verify.verifyNotNull(object, "expected a non-null reference", objectArray);
    }

    public static Object verifyNotNull(Object object, String string2, Object ... objectArray) {
        boolean bl2 = object != null;
        Verify.verify(bl2, string2, objectArray);
        return object;
    }
}

