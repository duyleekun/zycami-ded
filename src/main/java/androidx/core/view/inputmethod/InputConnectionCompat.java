/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ClipDescription
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.text.TextUtils
 *  android.view.inputmethod.EditorInfo
 *  android.view.inputmethod.InputConnection
 *  android.view.inputmethod.InputContentInfo
 */
package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.view.inputmethod.InputConnectionCompat$1;
import androidx.core.view.inputmethod.InputConnectionCompat$2;
import androidx.core.view.inputmethod.InputConnectionCompat$OnCommitContentListener;
import androidx.core.view.inputmethod.InputContentInfoCompat;

public final class InputConnectionCompat {
    private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
    private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
    private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
    private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
    private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
    private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;

    public static boolean commitContent(InputConnection inputConnection, EditorInfo editorInfo, InputContentInfoCompat object, int n10, Bundle bundle) {
        int n11;
        int n12;
        int n13;
        Uri uri;
        Object object2;
        block7: {
            object2 = ((InputContentInfoCompat)object).getDescription();
            uri = EditorInfoCompat.getContentMimeTypes(editorInfo);
            int n14 = ((String[])uri).length;
            n13 = 0;
            int n15 = 0;
            while (true) {
                n12 = 1;
                if (n15 >= n14) break;
                String string2 = uri[n15];
                boolean bl2 = object2.hasMimeType(string2);
                if (bl2) {
                    n11 = n12;
                    break block7;
                }
                ++n15;
            }
            n11 = 0;
            object2 = null;
        }
        if (n11 == 0) {
            return false;
        }
        n11 = Build.VERSION.SDK_INT;
        int n16 = 25;
        if (n11 >= n16) {
            editorInfo = (InputContentInfo)((InputContentInfoCompat)object).unwrap();
            return inputConnection.commitContent((InputContentInfo)editorInfo, n10, bundle);
        }
        int n17 = EditorInfoCompat.getProtocol(editorInfo);
        if (n17 != (n11 = 2)) {
            n11 = 3;
            if (n17 != n11 && n17 != (n11 = 4)) {
                return false;
            }
        } else {
            n13 = n12;
        }
        editorInfo = new Bundle();
        object2 = n13 != 0 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY;
        uri = ((InputContentInfoCompat)object).getContentUri();
        editorInfo.putParcelable((String)object2, (Parcelable)uri);
        object2 = n13 != 0 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY;
        uri = ((InputContentInfoCompat)object).getDescription();
        editorInfo.putParcelable((String)object2, (Parcelable)uri);
        object2 = n13 != 0 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY;
        object = ((InputContentInfoCompat)object).getLinkUri();
        editorInfo.putParcelable((String)object2, (Parcelable)object);
        object = n13 != 0 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY;
        editorInfo.putInt((String)object, n10);
        object = n13 != 0 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY;
        editorInfo.putParcelable((String)object, (Parcelable)bundle);
        object = n13 != 0 ? COMMIT_CONTENT_INTEROP_ACTION : COMMIT_CONTENT_ACTION;
        return inputConnection.performPrivateCommand((String)object, (Bundle)editorInfo);
    }

    public static InputConnection createWrapper(InputConnection object, EditorInfo object2, InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener) {
        if (object != null) {
            if (object2 != null) {
                if (inputConnectionCompat$OnCommitContentListener != null) {
                    int n10 = Build.VERSION.SDK_INT;
                    int n11 = 25;
                    if (n10 >= n11) {
                        object2 = new InputConnectionCompat$1((InputConnection)object, false, inputConnectionCompat$OnCommitContentListener);
                        return object2;
                    }
                    int n12 = ((String[])(object2 = EditorInfoCompat.getContentMimeTypes((EditorInfo)object2))).length;
                    if (n12 == 0) {
                        return object;
                    }
                    object2 = new InputConnectionCompat$2((InputConnection)object, false, inputConnectionCompat$OnCommitContentListener);
                    return object2;
                }
                object = new IllegalArgumentException("onCommitContentListener must be non-null");
                throw object;
            }
            object = new IllegalArgumentException("editorInfo must be non-null");
            throw object;
        }
        object = new IllegalArgumentException("inputConnection must be non-null");
        throw object;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean handlePerformPrivateCommand(String string2, Bundle object, InputConnectionCompat$OnCommitContentListener inputConnectionCompat$OnCommitContentListener) {
        void var0_3;
        String string3;
        block10: {
            int n10;
            block11: {
                String string5;
                boolean bl2;
                n10 = 0;
                if (object == null) {
                    return false;
                }
                String string4 = COMMIT_CONTENT_ACTION;
                boolean bl3 = TextUtils.equals((CharSequence)string4, (CharSequence)string2);
                if (bl3) {
                    bl2 = false;
                    string2 = null;
                } else {
                    string4 = COMMIT_CONTENT_INTEROP_ACTION;
                    bl2 = TextUtils.equals((CharSequence)string4, (CharSequence)string2);
                    if (!bl2) {
                        return false;
                    }
                    bl2 = true;
                }
                bl3 = false;
                string4 = null;
                string3 = bl2 ? COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY : COMMIT_CONTENT_RESULT_RECEIVER_KEY;
                try {
                    string3 = object.getParcelable(string3);
                    string3 = (ResultReceiver)string3;
                    string5 = bl2 ? COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY : COMMIT_CONTENT_CONTENT_URI_KEY;
                }
                catch (Throwable throwable) {
                    string3 = null;
                    break block10;
                }
                try {
                    string5 = object.getParcelable(string5);
                    string5 = (Uri)string5;
                    String string6 = bl2 ? COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY : COMMIT_CONTENT_DESCRIPTION_KEY;
                    string6 = object.getParcelable(string6);
                    string6 = (ClipDescription)string6;
                    String string7 = bl2 ? COMMIT_CONTENT_LINK_URI_INTEROP_KEY : COMMIT_CONTENT_LINK_URI_KEY;
                    string7 = object.getParcelable(string7);
                    string7 = (Uri)string7;
                    String string8 = bl2 ? COMMIT_CONTENT_FLAGS_INTEROP_KEY : COMMIT_CONTENT_FLAGS_KEY;
                    int n11 = object.getInt(string8);
                    string2 = bl2 ? COMMIT_CONTENT_OPTS_INTEROP_KEY : COMMIT_CONTENT_OPTS_KEY;
                    string2 = object.getParcelable(string2);
                    string2 = (Bundle)string2;
                    if (string5 != null && string6 != null) {
                        object = new InputContentInfoCompat((Uri)string5, (ClipDescription)string6, (Uri)string7);
                        n10 = (int)(inputConnectionCompat$OnCommitContentListener.onCommitContent((InputContentInfoCompat)object, n11, (Bundle)string2) ? 1 : 0);
                    }
                    if (string3 == null) break block11;
                }
                catch (Throwable throwable) {
                    break block10;
                }
                string3.send(n10, null);
            }
            return n10 != 0;
        }
        if (string3 != null) {
            string3.send(0, null);
        }
        throw var0_3;
    }
}

