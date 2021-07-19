/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.Html
 *  android.text.Spanned
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import androidx.core.app.ShareCompat;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.ArrayList;

public class ShareCompat$IntentReader {
    private static final String TAG = "IntentReader";
    private final ComponentName mCallingActivity;
    private final String mCallingPackage;
    private final Context mContext;
    private final Intent mIntent;
    private ArrayList mStreams;

    public ShareCompat$IntentReader(Activity activity) {
        Context context = (Context)Preconditions.checkNotNull(activity);
        activity = activity.getIntent();
        this(context, (Intent)activity);
    }

    public ShareCompat$IntentReader(Context object, Intent intent) {
        this.mContext = object = (Context)Preconditions.checkNotNull(object);
        object = (Intent)Preconditions.checkNotNull(intent);
        this.mIntent = object;
        object = ShareCompat.getCallingPackage(intent);
        this.mCallingPackage = object;
        object = ShareCompat.getCallingActivity(intent);
        this.mCallingActivity = object;
    }

    public static ShareCompat$IntentReader from(Activity activity) {
        ShareCompat$IntentReader shareCompat$IntentReader = new ShareCompat$IntentReader(activity);
        return shareCompat$IntentReader;
    }

    private static void withinStyle(StringBuilder stringBuilder, CharSequence charSequence, int n10, int n11) {
        while (n10 < n11) {
            String string2;
            char c10;
            int n12 = charSequence.charAt(n10);
            if (n12 == (c10 = 60)) {
                string2 = "&lt;";
                stringBuilder.append(string2);
            } else {
                c10 = '>';
                if (n12 == c10) {
                    string2 = "&gt;";
                    stringBuilder.append(string2);
                } else {
                    c10 = '&';
                    if (n12 == c10) {
                        string2 = "&amp;";
                        stringBuilder.append(string2);
                    } else {
                        c10 = '~';
                        if (n12 <= c10 && n12 >= (c10 = ' ')) {
                            if (n12 == c10) {
                                char c11;
                                while ((n12 = n10 + 1) < n11 && (c11 = charSequence.charAt(n12)) == c10) {
                                    String string3 = "&nbsp;";
                                    stringBuilder.append(string3);
                                    n10 = n12;
                                }
                                stringBuilder.append(c10);
                            } else {
                                stringBuilder.append((char)n12);
                            }
                        } else {
                            String string4 = "&#";
                            stringBuilder.append(string4);
                            stringBuilder.append(n12);
                            string2 = ";";
                            stringBuilder.append(string2);
                        }
                    }
                }
            }
            ++n10;
        }
    }

    public ComponentName getCallingActivity() {
        return this.mCallingActivity;
    }

    public Drawable getCallingActivityIcon() {
        ComponentName componentName;
        ComponentName componentName2 = this.mCallingActivity;
        if (componentName2 == null) {
            return null;
        }
        componentName2 = this.mContext.getPackageManager();
        try {
            componentName = this.mCallingActivity;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)TAG, (String)"Could not retrieve icon for calling activity", (Throwable)nameNotFoundException);
            return null;
        }
        return componentName2.getActivityIcon(componentName);
    }

    public Drawable getCallingApplicationIcon() {
        String string2;
        String string3 = this.mCallingPackage;
        if (string3 == null) {
            return null;
        }
        string3 = this.mContext.getPackageManager();
        try {
            string2 = this.mCallingPackage;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)TAG, (String)"Could not retrieve icon for calling application", (Throwable)nameNotFoundException);
            return null;
        }
        return string3.getApplicationIcon(string2);
    }

    public CharSequence getCallingApplicationLabel() {
        String string2;
        String string3 = this.mCallingPackage;
        if (string3 == null) {
            return null;
        }
        string3 = this.mContext.getPackageManager();
        try {
            string2 = this.mCallingPackage;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)TAG, (String)"Could not retrieve label for calling application", (Throwable)nameNotFoundException);
            return null;
        }
        string2 = string3.getApplicationInfo(string2, 0);
        return string3.getApplicationLabel((ApplicationInfo)string2);
    }

    public String getCallingPackage() {
        return this.mCallingPackage;
    }

    public String[] getEmailBcc() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
    }

    public String[] getEmailCc() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
    }

    public String[] getEmailTo() {
        return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
    }

    public String getHtmlText() {
        Object object = this.mIntent;
        CharSequence charSequence = "android.intent.extra.HTML_TEXT";
        if ((object = object.getStringExtra((String)charSequence)) == null) {
            charSequence = this.getText();
            int n10 = charSequence instanceof Spanned;
            if (n10 != 0) {
                charSequence = (Spanned)charSequence;
                object = Html.toHtml((Spanned)charSequence);
            } else if (charSequence != null) {
                int n11 = Build.VERSION.SDK_INT;
                n10 = 16;
                if (n11 >= n10) {
                    object = Html.escapeHtml((CharSequence)charSequence);
                } else {
                    object = new StringBuilder();
                    n10 = 0;
                    int n12 = charSequence.length();
                    ShareCompat$IntentReader.withinStyle((StringBuilder)object, charSequence, 0, n12);
                    object = ((StringBuilder)object).toString();
                }
            }
        }
        return object;
    }

    public Uri getStream() {
        return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }

    public Uri getStream(int n10) {
        boolean bl2;
        Serializable serializable = this.mStreams;
        CharSequence charSequence = "android.intent.extra.STREAM";
        if (serializable == null && (bl2 = this.isMultipleShare())) {
            this.mStreams = serializable = this.mIntent.getParcelableArrayListExtra((String)charSequence);
        }
        if ((serializable = this.mStreams) != null) {
            return (Uri)serializable.get(n10);
        }
        if (n10 == 0) {
            return (Uri)this.mIntent.getParcelableExtra((String)charSequence);
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Stream items available: ");
        int n11 = this.getStreamCount();
        ((StringBuilder)charSequence).append(n11);
        ((StringBuilder)charSequence).append(" index requested: ");
        ((StringBuilder)charSequence).append(n10);
        String string2 = ((StringBuilder)charSequence).toString();
        serializable = new IndexOutOfBoundsException(string2);
        throw serializable;
    }

    public int getStreamCount() {
        boolean bl2;
        ArrayList arrayList = this.mStreams;
        String string2 = "android.intent.extra.STREAM";
        if (arrayList == null && (bl2 = this.isMultipleShare())) {
            this.mStreams = arrayList = this.mIntent.getParcelableArrayListExtra(string2);
        }
        if ((arrayList = this.mStreams) != null) {
            return arrayList.size();
        }
        return (int)(this.mIntent.hasExtra(string2) ? 1 : 0);
    }

    public String getSubject() {
        return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
    }

    public CharSequence getText() {
        return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
    }

    public String getType() {
        return this.mIntent.getType();
    }

    public boolean isMultipleShare() {
        String string2 = this.mIntent.getAction();
        return "android.intent.action.SEND_MULTIPLE".equals(string2);
    }

    public boolean isShareIntent() {
        boolean bl2;
        String string2 = "android.intent.action.SEND";
        String string3 = this.mIntent.getAction();
        boolean bl3 = string2.equals(string3);
        if (!bl3 && !(bl2 = (string2 = "android.intent.action.SEND_MULTIPLE").equals(string3))) {
            bl2 = false;
            string3 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean isSingleShare() {
        String string2 = this.mIntent.getAction();
        return "android.intent.action.SEND".equals(string2);
    }
}

