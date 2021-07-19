/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.SpannableStringBuilder
 *  android.text.TextUtils
 *  android.view.inputmethod.EditorInfo
 */
package androidx.core.view.inputmethod;

import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import androidx.core.util.Preconditions;
import androidx.core.view.inputmethod.EditorInfoCompat$Impl30;

public final class EditorInfoCompat {
    private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
    private static final String CONTENT_SELECTION_END_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END";
    private static final String CONTENT_SELECTION_HEAD_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD";
    private static final String CONTENT_SURROUNDING_TEXT_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT";
    private static final String[] EMPTY_STRING_ARRAY = new String[0];
    public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
    public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 0x1000000;
    public static final int MAX_INITIAL_SELECTION_LENGTH = 1024;
    public static final int MEMORY_EFFICIENT_TEXT_LENGTH = 2048;

    public static String[] getContentMimeTypes(EditorInfo stringArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            stringArray = stringArray.contentMimeTypes;
            if (stringArray == null) {
                stringArray = EMPTY_STRING_ARRAY;
            }
            return stringArray;
        }
        String[] stringArray2 = stringArray.extras;
        if (stringArray2 == null) {
            return EMPTY_STRING_ARRAY;
        }
        String string2 = CONTENT_MIME_TYPES_KEY;
        if ((stringArray2 = stringArray2.getStringArray(string2)) == null) {
            stringArray = stringArray.extras;
            stringArray2 = stringArray.getStringArray(CONTENT_MIME_TYPES_INTEROP_KEY);
        }
        if (stringArray2 == null) {
            stringArray2 = EMPTY_STRING_ARRAY;
        }
        return stringArray2;
    }

    public static CharSequence getInitialSelectedText(EditorInfo object, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 30;
        if (n11 >= n12) {
            return EditorInfoCompat$Impl30.getInitialSelectedText((EditorInfo)object, n10);
        }
        Bundle bundle = ((EditorInfo)object).extras;
        n12 = 0;
        if (bundle == null) {
            return null;
        }
        int n13 = ((EditorInfo)object).initialSelStart;
        int n14 = ((EditorInfo)object).initialSelEnd;
        int n15 = n13 > n14 ? n14 : n13;
        if (n13 <= n14) {
            n13 = n14;
        }
        n11 = bundle.getInt(CONTENT_SELECTION_HEAD_KEY);
        Bundle bundle2 = ((EditorInfo)object).extras;
        String string2 = CONTENT_SELECTION_END_KEY;
        n14 = bundle2.getInt(string2);
        n13 -= n15;
        n15 = ((EditorInfo)object).initialSelStart;
        if (n15 >= 0 && (n15 = ((EditorInfo)object).initialSelEnd) >= 0 && (n15 = n14 - n11) == n13) {
            object = ((EditorInfo)object).extras;
            String string3 = CONTENT_SURROUNDING_TEXT_KEY;
            if ((object = object.getCharSequence(string3)) == null) {
                return null;
            }
            object = (n10 &= 1) != 0 ? object.subSequence(n11, n14) : TextUtils.substring((CharSequence)object, (int)n11, (int)n14);
            return object;
        }
        return null;
    }

    public static CharSequence getInitialTextAfterCursor(EditorInfo object, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 30;
        if (n12 >= n13) {
            return EditorInfoCompat$Impl30.getInitialTextAfterCursor(object, n10, n11);
        }
        Object object2 = object.extras;
        n13 = 0;
        String string2 = null;
        if (object2 == null) {
            return null;
        }
        String string3 = CONTENT_SURROUNDING_TEXT_KEY;
        if ((object2 = object2.getCharSequence(string3)) == null) {
            return null;
        }
        object = object.extras;
        string2 = CONTENT_SELECTION_END_KEY;
        int n14 = object.getInt(string2);
        n13 = object2.length() - n14;
        n10 = Math.min(n10, n13);
        object = (n11 &= 1) != 0 ? object2.subSequence(n14, n10 += n14) : TextUtils.substring((CharSequence)object2, (int)n14, (int)(n10 += n14));
        return object;
    }

    public static CharSequence getInitialTextBeforeCursor(EditorInfo object, int n10, int n11) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 30;
        if (n12 >= n13) {
            return EditorInfoCompat$Impl30.getInitialTextBeforeCursor(object, n10, n11);
        }
        Object object2 = object.extras;
        n13 = 0;
        String string2 = null;
        if (object2 == null) {
            return null;
        }
        String string3 = CONTENT_SURROUNDING_TEXT_KEY;
        if ((object2 = object2.getCharSequence(string3)) == null) {
            return null;
        }
        object = object.extras;
        string2 = CONTENT_SELECTION_HEAD_KEY;
        int n14 = object.getInt(string2);
        n10 = Math.min(n10, n14);
        if ((n11 &= 1) != 0) {
            n10 = n14 - n10;
            object = object2.subSequence(n10, n14);
        } else {
            n10 = n14 - n10;
            object = TextUtils.substring((CharSequence)object2, (int)n10, (int)n14);
        }
        return object;
    }

    public static int getProtocol(EditorInfo editorInfo) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            return 1;
        }
        Bundle bundle = editorInfo.extras;
        n11 = 0;
        if (bundle == null) {
            return 0;
        }
        n10 = (int)(bundle.containsKey(CONTENT_MIME_TYPES_KEY) ? 1 : 0);
        editorInfo = editorInfo.extras;
        String string2 = CONTENT_MIME_TYPES_INTEROP_KEY;
        boolean bl2 = editorInfo.containsKey(string2);
        if (n10 != 0 && bl2) {
            return 4;
        }
        if (n10 != 0) {
            return 3;
        }
        if (bl2) {
            return 2;
        }
        return 0;
    }

    private static boolean isCutOnSurrogate(CharSequence charSequence, int n10, int n11) {
        if (n11 != 0) {
            int n12 = 1;
            if (n11 != n12) {
                return false;
            }
            return Character.isHighSurrogate(charSequence.charAt(n10));
        }
        return Character.isLowSurrogate(charSequence.charAt(n10));
    }

    private static boolean isPasswordInputType(int n10) {
        int n11 = 129;
        n10 = (n10 &= 0xFFF) != n11 && n10 != (n11 = 225) && n10 != (n11 = 18) ? 0 : 1;
        return n10 != 0;
    }

    public static void setContentMimeTypes(EditorInfo editorInfo, String[] stringArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11) {
            editorInfo.contentMimeTypes = stringArray;
        } else {
            Object object = editorInfo.extras;
            if (object == null) {
                editorInfo.extras = object = new Bundle();
            }
            object = editorInfo.extras;
            String string2 = CONTENT_MIME_TYPES_KEY;
            object.putStringArray(string2, stringArray);
            editorInfo = editorInfo.extras;
            object = CONTENT_MIME_TYPES_INTEROP_KEY;
            editorInfo.putStringArray((String)object, stringArray);
        }
    }

    public static void setInitialSurroundingSubText(EditorInfo editorInfo, CharSequence charSequence, int n10) {
        Preconditions.checkNotNull(charSequence);
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 30;
        if (n11 >= n12) {
            EditorInfoCompat$Impl30.setInitialSurroundingSubText(editorInfo, charSequence, n10);
            return;
        }
        n11 = editorInfo.initialSelStart;
        n12 = editorInfo.initialSelEnd;
        int n13 = n11 > n12 ? n12 - n10 : n11 - n10;
        n11 = n11 > n12 ? (n11 -= n10) : n12 - n10;
        n12 = charSequence.length();
        if (n10 >= 0 && n13 >= 0 && n11 <= n12) {
            n10 = (int)(EditorInfoCompat.isPasswordInputType(editorInfo.inputType) ? 1 : 0);
            if (n10 != 0) {
                EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
                return;
            }
            n10 = 2048;
            if (n12 <= n10) {
                EditorInfoCompat.setSurroundingText(editorInfo, charSequence, n13, n11);
                return;
            }
            EditorInfoCompat.trimLongSurroundingText(editorInfo, charSequence, n13, n11);
            return;
        }
        EditorInfoCompat.setSurroundingText(editorInfo, null, 0, 0);
    }

    public static void setInitialSurroundingText(EditorInfo editorInfo, CharSequence charSequence) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 30;
        if (n10 >= n11) {
            EditorInfoCompat$Impl30.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        } else {
            EditorInfoCompat.setInitialSurroundingSubText(editorInfo, charSequence, 0);
        }
    }

    private static void setSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int n10, int n11) {
        Object object = editorInfo.extras;
        if (object == null) {
            editorInfo.extras = object = new Bundle();
        }
        object = charSequence != null ? new SpannableStringBuilder(charSequence) : null;
        editorInfo.extras.putCharSequence(CONTENT_SURROUNDING_TEXT_KEY, (CharSequence)object);
        editorInfo.extras.putInt(CONTENT_SELECTION_HEAD_KEY, n10);
        editorInfo.extras.putInt(CONTENT_SELECTION_END_KEY, n11);
    }

    private static void trimLongSurroundingText(EditorInfo editorInfo, CharSequence charSequence, int n10, int n11) {
        int n12 = n11 - n10;
        int n13 = 1024;
        n13 = n12 > n13 ? 0 : n12;
        int n14 = charSequence.length() - n11;
        int n15 = 2048 - n13;
        double d10 = 0.8;
        double d11 = (double)n15 * d10;
        int n16 = (int)d11;
        n16 = Math.min(n10, n16);
        n16 = n15 - n16;
        n14 = Math.min(n14, n16);
        n15 -= n14;
        if ((n16 = (int)(EditorInfoCompat.isCutOnSurrogate(charSequence, n10 -= (n15 = Math.min(n10, n15)), 0) ? 1 : 0)) != 0) {
            ++n10;
            n15 += -1;
        }
        n16 = n11 + n14;
        int n17 = 1;
        n16 -= n17;
        if ((n16 = (int)(EditorInfoCompat.isCutOnSurrogate(charSequence, n16, n17) ? 1 : 0)) != 0) {
            n14 += -1;
        }
        n16 = n15 + n13 + n14;
        if (n13 != n12) {
            n12 = n10 + n15;
            CharSequence charSequence2 = charSequence.subSequence(n10, n12);
            charSequence = charSequence.subSequence(n11, n14 += n11);
            n11 = 2;
            CharSequence[] charSequenceArray = new CharSequence[n11];
            charSequenceArray[0] = charSequence2;
            charSequenceArray[n17] = charSequence;
            charSequence = TextUtils.concat((CharSequence[])charSequenceArray);
        } else {
            charSequence = charSequence.subSequence(n10, n16 += n10);
        }
        EditorInfoCompat.setSurroundingText(editorInfo, charSequence, n15, n13 += (n15 += 0));
    }
}

