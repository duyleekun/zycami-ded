/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.text.Html
 */
package androidx.core.app;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcelable;
import android.text.Html;
import androidx.core.app.ShareCompat$Api16Impl;
import androidx.core.util.Preconditions;
import java.util.ArrayList;

public class ShareCompat$IntentBuilder {
    private ArrayList mBccAddresses;
    private ArrayList mCcAddresses;
    private CharSequence mChooserTitle;
    private final Context mContext;
    private final Intent mIntent;
    private ArrayList mStreams;
    private ArrayList mToAddresses;

    public ShareCompat$IntentBuilder(Context context) {
        String string2;
        Context context2;
        block3: {
            boolean bl2;
            this.mContext = context2 = (Context)Preconditions.checkNotNull(context);
            context2 = context2.setAction("android.intent.action.SEND");
            this.mIntent = context2;
            string2 = context.getPackageName();
            context2.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", string2);
            string2 = context.getPackageName();
            String string3 = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
            context2.putExtra(string3, string2);
            int n10 = 524288;
            context2.addFlags(n10);
            while (bl2 = context instanceof ContextWrapper) {
                bl2 = context instanceof Activity;
                if (bl2) {
                    context = (Activity)context;
                    break block3;
                }
                context = ((ContextWrapper)context).getBaseContext();
            }
            context = null;
        }
        if (context != null) {
            context = context.getComponentName();
            this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", (Parcelable)context);
            context2 = this.mIntent;
            string2 = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
            context2.putExtra(string2, (Parcelable)context);
        }
    }

    private void combineArrayExtra(String string2, ArrayList arrayList) {
        String[] stringArray = this.mIntent.getStringArrayExtra(string2);
        int n10 = stringArray != null ? stringArray.length : 0;
        int n11 = arrayList.size() + n10;
        String[] stringArray2 = new String[n11];
        arrayList.toArray(stringArray2);
        if (stringArray != null) {
            int n12 = arrayList.size();
            System.arraycopy(stringArray, 0, stringArray2, n12, n10);
        }
        this.mIntent.putExtra(string2, stringArray2);
    }

    private void combineArrayExtra(String string2, String[] stringArray) {
        Intent intent = this.getIntent();
        String[] stringArray2 = intent.getStringArrayExtra(string2);
        int n10 = stringArray2 != null ? stringArray2.length : 0;
        int n11 = stringArray.length + n10;
        String[] stringArray3 = new String[n11];
        if (stringArray2 != null) {
            System.arraycopy(stringArray2, 0, stringArray3, 0, n10);
        }
        int n12 = stringArray.length;
        System.arraycopy(stringArray, 0, stringArray3, n10, n12);
        intent.putExtra(string2, stringArray3);
    }

    public static ShareCompat$IntentBuilder from(Activity activity) {
        ShareCompat$IntentBuilder shareCompat$IntentBuilder = new ShareCompat$IntentBuilder((Context)activity);
        return shareCompat$IntentBuilder;
    }

    public ShareCompat$IntentBuilder addEmailBcc(String string2) {
        ArrayList arrayList = this.mBccAddresses;
        if (arrayList == null) {
            this.mBccAddresses = arrayList = new ArrayList();
        }
        this.mBccAddresses.add(string2);
        return this;
    }

    public ShareCompat$IntentBuilder addEmailBcc(String[] stringArray) {
        this.combineArrayExtra("android.intent.extra.BCC", stringArray);
        return this;
    }

    public ShareCompat$IntentBuilder addEmailCc(String string2) {
        ArrayList arrayList = this.mCcAddresses;
        if (arrayList == null) {
            this.mCcAddresses = arrayList = new ArrayList();
        }
        this.mCcAddresses.add(string2);
        return this;
    }

    public ShareCompat$IntentBuilder addEmailCc(String[] stringArray) {
        this.combineArrayExtra("android.intent.extra.CC", stringArray);
        return this;
    }

    public ShareCompat$IntentBuilder addEmailTo(String string2) {
        ArrayList arrayList = this.mToAddresses;
        if (arrayList == null) {
            this.mToAddresses = arrayList = new ArrayList();
        }
        this.mToAddresses.add(string2);
        return this;
    }

    public ShareCompat$IntentBuilder addEmailTo(String[] stringArray) {
        this.combineArrayExtra("android.intent.extra.EMAIL", stringArray);
        return this;
    }

    public ShareCompat$IntentBuilder addStream(Uri uri) {
        ArrayList arrayList = this.mStreams;
        if (arrayList == null) {
            this.mStreams = arrayList = new ArrayList();
        }
        this.mStreams.add(uri);
        return this;
    }

    public Intent createChooserIntent() {
        Intent intent = this.getIntent();
        CharSequence charSequence = this.mChooserTitle;
        return Intent.createChooser((Intent)intent, (CharSequence)charSequence);
    }

    public Context getContext() {
        return this.mContext;
    }

    public Intent getIntent() {
        int n10;
        Object object;
        int n11 = Build.VERSION.SDK_INT;
        ArrayList arrayList = this.mToAddresses;
        int n12 = 0;
        Object object2 = null;
        if (arrayList != null) {
            object = "android.intent.extra.EMAIL";
            this.combineArrayExtra((String)object, arrayList);
            this.mToAddresses = null;
        }
        if ((arrayList = this.mCcAddresses) != null) {
            object = "android.intent.extra.CC";
            this.combineArrayExtra((String)object, arrayList);
            this.mCcAddresses = null;
        }
        if ((arrayList = this.mBccAddresses) != null) {
            object = "android.intent.extra.BCC";
            this.combineArrayExtra((String)object, arrayList);
            this.mBccAddresses = null;
        }
        arrayList = this.mStreams;
        n12 = 1;
        object = null;
        if (arrayList == null || (n10 = arrayList.size()) <= n12) {
            n12 = 0;
            object2 = null;
        }
        n10 = 16;
        String string2 = "android.intent.extra.STREAM";
        if (n12 == 0) {
            object2 = this.mIntent;
            Object object3 = "android.intent.action.SEND";
            object2.setAction((String)object3);
            object2 = this.mStreams;
            if (object2 != null && (n12 = (int)(((ArrayList)object2).isEmpty() ? 1 : 0)) == 0) {
                object2 = this.mIntent;
                object3 = this.mStreams;
                object = (Parcelable)((ArrayList)object3).get(0);
                object2.putExtra(string2, (Parcelable)object);
                if (n11 >= n10) {
                    Intent intent = this.mIntent;
                    arrayList = this.mStreams;
                    ShareCompat$Api16Impl.migrateExtraStreamToClipData(intent, arrayList);
                }
            } else {
                object2 = this.mIntent;
                object2.removeExtra(string2);
                if (n11 >= n10) {
                    Intent intent = this.mIntent;
                    ShareCompat$Api16Impl.removeClipData(intent);
                }
            }
        } else {
            this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
            object2 = this.mIntent;
            object = this.mStreams;
            object2.putParcelableArrayListExtra(string2, (ArrayList)object);
            if (n11 >= n10) {
                Intent intent = this.mIntent;
                arrayList = this.mStreams;
                ShareCompat$Api16Impl.migrateExtraStreamToClipData(intent, arrayList);
            }
        }
        return this.mIntent;
    }

    public ShareCompat$IntentBuilder setChooserTitle(int n10) {
        CharSequence charSequence = this.mContext.getText(n10);
        return this.setChooserTitle(charSequence);
    }

    public ShareCompat$IntentBuilder setChooserTitle(CharSequence charSequence) {
        this.mChooserTitle = charSequence;
        return this;
    }

    public ShareCompat$IntentBuilder setEmailBcc(String[] stringArray) {
        this.mIntent.putExtra("android.intent.extra.BCC", stringArray);
        return this;
    }

    public ShareCompat$IntentBuilder setEmailCc(String[] stringArray) {
        this.mIntent.putExtra("android.intent.extra.CC", stringArray);
        return this;
    }

    public ShareCompat$IntentBuilder setEmailTo(String[] stringArray) {
        ArrayList arrayList = this.mToAddresses;
        if (arrayList != null) {
            arrayList = null;
            this.mToAddresses = null;
        }
        this.mIntent.putExtra("android.intent.extra.EMAIL", stringArray);
        return this;
    }

    public ShareCompat$IntentBuilder setHtmlText(String string2) {
        this.mIntent.putExtra("android.intent.extra.HTML_TEXT", string2);
        Intent intent = this.mIntent;
        String string3 = "android.intent.extra.TEXT";
        boolean bl2 = intent.hasExtra(string3);
        if (!bl2) {
            string2 = Html.fromHtml((String)string2);
            this.setText(string2);
        }
        return this;
    }

    public ShareCompat$IntentBuilder setStream(Uri uri) {
        this.mStreams = null;
        if (uri != null) {
            this.addStream(uri);
        }
        return this;
    }

    public ShareCompat$IntentBuilder setSubject(String string2) {
        this.mIntent.putExtra("android.intent.extra.SUBJECT", string2);
        return this;
    }

    public ShareCompat$IntentBuilder setText(CharSequence charSequence) {
        this.mIntent.putExtra("android.intent.extra.TEXT", charSequence);
        return this;
    }

    public ShareCompat$IntentBuilder setType(String string2) {
        this.mIntent.setType(string2);
        return this;
    }

    public void startChooser() {
        Context context = this.mContext;
        Intent intent = this.createChooserIntent();
        context.startActivity(intent);
    }
}

