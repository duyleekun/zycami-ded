/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.RemoteInput
 *  android.app.RemoteInput$Builder
 *  android.content.ClipData
 *  android.content.Intent
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.os.Bundle
 */
package androidx.core.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.RemoteInput$Builder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class RemoteInput {
    public static final int EDIT_CHOICES_BEFORE_SENDING_AUTO = 0;
    public static final int EDIT_CHOICES_BEFORE_SENDING_DISABLED = 1;
    public static final int EDIT_CHOICES_BEFORE_SENDING_ENABLED = 2;
    private static final String EXTRA_DATA_TYPE_RESULTS_DATA = "android.remoteinput.dataTypeResultsData";
    public static final String EXTRA_RESULTS_DATA = "android.remoteinput.resultsData";
    private static final String EXTRA_RESULTS_SOURCE = "android.remoteinput.resultsSource";
    public static final String RESULTS_CLIP_LABEL = "android.remoteinput.results";
    public static final int SOURCE_CHOICE = 1;
    public static final int SOURCE_FREE_FORM_INPUT = 0;
    private static final String TAG = "RemoteInput";
    private final boolean mAllowFreeFormTextInput;
    private final Set mAllowedDataTypes;
    private final CharSequence[] mChoices;
    private final int mEditChoicesBeforeSending;
    private final Bundle mExtras;
    private final CharSequence mLabel;
    private final String mResultKey;

    public RemoteInput(String object, CharSequence charSequence, CharSequence[] charSequenceArray, boolean bl2, int n10, Bundle bundle, Set set) {
        this.mResultKey = object;
        this.mLabel = charSequence;
        this.mChoices = charSequenceArray;
        this.mAllowFreeFormTextInput = bl2;
        this.mEditChoicesBeforeSending = n10;
        this.mExtras = bundle;
        this.mAllowedDataTypes = set;
        int n11 = this.getEditChoicesBeforeSending();
        int n12 = 2;
        if (n11 == n12 && (n11 = (int)(this.getAllowFreeFormInput() ? 1 : 0)) == 0) {
            object = new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
            throw object;
        }
    }

    public static void addDataResultToIntent(RemoteInput remoteInput, Intent intent, Map object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            remoteInput = RemoteInput.fromCompat(remoteInput);
            android.app.RemoteInput.addDataResultToIntent((android.app.RemoteInput)remoteInput, (Intent)intent, (Map)object);
        } else {
            n11 = 16;
            if (n10 >= n11) {
                Intent intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
                if (intent2 == null) {
                    intent2 = new Intent();
                }
                object = object.entrySet().iterator();
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    Object object2 = (Map.Entry)object.next();
                    String string2 = (String)object2.getKey();
                    object2 = (Uri)object2.getValue();
                    if (string2 == null) continue;
                    String string3 = RemoteInput.getExtraResultsKeyForData(string2);
                    if ((string3 = intent2.getBundleExtra(string3)) == null) {
                        string3 = new Bundle();
                    }
                    String string4 = remoteInput.getResultKey();
                    object2 = object2.toString();
                    string3.putString(string4, (String)object2);
                    object2 = RemoteInput.getExtraResultsKeyForData(string2);
                    intent2.putExtra((String)object2, (Bundle)string3);
                }
                remoteInput = ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent2);
                intent.setClipData((ClipData)remoteInput);
            }
        }
    }

    public static void addResultsToIntent(RemoteInput[] clipData, Intent intent, Bundle bundle) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            clipData = RemoteInput.fromCompat((RemoteInput[])clipData);
            android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[])clipData, (Intent)intent, (Bundle)bundle);
        } else {
            n11 = 20;
            int n12 = 0;
            if (n10 >= n11) {
                Bundle bundle2 = RemoteInput.getResultsFromIntent(intent);
                n11 = RemoteInput.getResultsSource(intent);
                if (bundle2 != null) {
                    bundle2.putAll(bundle);
                    bundle = bundle2;
                }
                n10 = ((RemoteInput[])clipData).length;
                Object var8_9 = null;
                for (int i10 = 0; i10 < n10; ++i10) {
                    RemoteInput remoteInput = clipData[i10];
                    Object object = remoteInput.getResultKey();
                    object = RemoteInput.getDataResultsFromIntent(intent, (String)object);
                    int n13 = 1;
                    RemoteInput[] remoteInputArray = new RemoteInput[n13];
                    remoteInputArray[0] = remoteInput;
                    remoteInputArray = RemoteInput.fromCompat(remoteInputArray);
                    android.app.RemoteInput.addResultsToIntent((android.app.RemoteInput[])remoteInputArray, (Intent)intent, (Bundle)bundle);
                    if (object == null) continue;
                    RemoteInput.addDataResultToIntent(remoteInput, intent, (Map)object);
                }
                RemoteInput.setResultsSource(intent, n11);
            } else {
                n11 = 16;
                if (n10 >= n11) {
                    String string2;
                    Bundle bundle3;
                    Intent intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
                    if (intent2 == null) {
                        intent2 = new Intent();
                    }
                    if ((bundle3 = intent2.getBundleExtra(string2 = EXTRA_RESULTS_DATA)) == null) {
                        bundle3 = new Bundle();
                    }
                    int n14 = ((RemoteInput[])clipData).length;
                    while (n12 < n14) {
                        Object object = clipData[n12];
                        Object object2 = ((RemoteInput)object).getResultKey();
                        boolean bl2 = (object2 = bundle.get((String)object2)) instanceof CharSequence;
                        if (bl2) {
                            object = ((RemoteInput)object).getResultKey();
                            object2 = (CharSequence)object2;
                            bundle3.putCharSequence((String)object, (CharSequence)object2);
                        }
                        ++n12;
                    }
                    intent2.putExtra(string2, bundle3);
                    clipData = ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent2);
                    intent.setClipData(clipData);
                }
            }
        }
    }

    public static android.app.RemoteInput fromCompat(RemoteInput remoteInput) {
        Bundle bundle = remoteInput.getResultKey();
        RemoteInput.Builder builder = new RemoteInput.Builder((String)bundle);
        bundle = remoteInput.getLabel();
        builder = builder.setLabel((CharSequence)bundle);
        bundle = remoteInput.getChoices();
        builder = builder.setChoices((CharSequence[])bundle);
        int n10 = remoteInput.getAllowFreeFormInput();
        builder = builder.setAllowFreeFormInput(n10 != 0);
        bundle = remoteInput.getExtras();
        builder = builder.addExtras(bundle);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            int n12 = remoteInput.getEditChoicesBeforeSending();
            builder.setEditChoicesBeforeSending(n12);
        }
        return builder.build();
    }

    public static android.app.RemoteInput[] fromCompat(RemoteInput[] remoteInputArray) {
        int n10;
        if (remoteInputArray == null) {
            return null;
        }
        int n11 = remoteInputArray.length;
        android.app.RemoteInput[] remoteInputArray2 = new android.app.RemoteInput[n11];
        for (int i10 = 0; i10 < (n10 = remoteInputArray.length); ++i10) {
            android.app.RemoteInput remoteInput;
            remoteInputArray2[i10] = remoteInput = RemoteInput.fromCompat(remoteInputArray[i10]);
        }
        return remoteInputArray2;
    }

    public static RemoteInput fromPlatform(android.app.RemoteInput remoteInput) {
        Bundle bundle = remoteInput.getResultKey();
        RemoteInput$Builder remoteInput$Builder = new RemoteInput$Builder((String)bundle);
        bundle = remoteInput.getLabel();
        remoteInput$Builder = remoteInput$Builder.setLabel((CharSequence)bundle);
        bundle = remoteInput.getChoices();
        remoteInput$Builder = remoteInput$Builder.setChoices((CharSequence[])bundle);
        int n10 = remoteInput.getAllowFreeFormInput();
        remoteInput$Builder = remoteInput$Builder.setAllowFreeFormInput(n10 != 0);
        bundle = remoteInput.getExtras();
        remoteInput$Builder = remoteInput$Builder.addExtras(bundle);
        n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            int n12 = remoteInput.getEditChoicesBeforeSending();
            remoteInput$Builder.setEditChoicesBeforeSending(n12);
        }
        return remoteInput$Builder.build();
    }

    private static Intent getClipDataIntentFromIntent(Intent intent) {
        String string2;
        if ((intent = intent.getClipData()) == null) {
            return null;
        }
        Object object = intent.getDescription();
        boolean bl2 = object.hasMimeType(string2 = "text/vnd.android.intent");
        if (!bl2) {
            return null;
        }
        boolean bl3 = ((String)(object = object.getLabel().toString())).contentEquals(string2 = RESULTS_CLIP_LABEL);
        if (!bl3) {
            return null;
        }
        return intent.getItemAt(0).getIntent();
    }

    public static Map getDataResultsFromIntent(Intent intent, String string2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return android.app.RemoteInput.getDataResultsFromIntent((Intent)intent, (String)string2);
        }
        n11 = 16;
        HashMap<String, String> hashMap = null;
        if (n10 >= n11) {
            boolean bl2;
            if ((intent = RemoteInput.getClipDataIntentFromIntent(intent)) == null) {
                return null;
            }
            HashMap<String, String> hashMap2 = new HashMap<String, String>();
            Iterator iterator2 = intent.getExtras().keySet().iterator();
            while (bl2 = iterator2.hasNext()) {
                boolean bl3;
                String string3;
                String string4 = (String)iterator2.next();
                int n12 = string4.startsWith(string3 = EXTRA_DATA_TYPE_RESULTS_DATA);
                if (n12 == 0 || (bl3 = (string3 = string4.substring(n12 = 39)).isEmpty()) || (string4 = intent.getBundleExtra(string4).getString(string2)) == null || (bl3 = string4.isEmpty())) continue;
                string4 = Uri.parse((String)string4);
                hashMap2.put(string3, string4);
            }
            boolean bl4 = hashMap2.isEmpty();
            if (!bl4) {
                hashMap = hashMap2;
            }
        }
        return hashMap;
    }

    private static String getExtraResultsKeyForData(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EXTRA_DATA_TYPE_RESULTS_DATA);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 20;
        if (n10 >= n11) {
            return android.app.RemoteInput.getResultsFromIntent((Intent)intent);
        }
        n11 = 16;
        if (n10 >= n11) {
            if ((intent = RemoteInput.getClipDataIntentFromIntent(intent)) == null) {
                return null;
            }
            return (Bundle)intent.getExtras().getParcelable(EXTRA_RESULTS_DATA);
        }
        return null;
    }

    public static int getResultsSource(Intent intent) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return android.app.RemoteInput.getResultsSource((Intent)intent);
        }
        n11 = 16;
        if (n10 >= n11) {
            if ((intent = RemoteInput.getClipDataIntentFromIntent(intent)) == null) {
                return 0;
            }
            return intent.getExtras().getInt(EXTRA_RESULTS_SOURCE, 0);
        }
        return 0;
    }

    public static void setResultsSource(Intent intent, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 28;
        if (n11 >= n12) {
            android.app.RemoteInput.setResultsSource((Intent)intent, (int)n10);
        } else {
            n12 = 16;
            if (n11 >= n12) {
                Intent intent2 = RemoteInput.getClipDataIntentFromIntent(intent);
                if (intent2 == null) {
                    intent2 = new Intent();
                }
                String string2 = EXTRA_RESULTS_SOURCE;
                intent2.putExtra(string2, n10);
                ClipData clipData = ClipData.newIntent((CharSequence)RESULTS_CLIP_LABEL, (Intent)intent2);
                intent.setClipData(clipData);
            }
        }
    }

    public boolean getAllowFreeFormInput() {
        return this.mAllowFreeFormTextInput;
    }

    public Set getAllowedDataTypes() {
        return this.mAllowedDataTypes;
    }

    public CharSequence[] getChoices() {
        return this.mChoices;
    }

    public int getEditChoicesBeforeSending() {
        return this.mEditChoicesBeforeSending;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public CharSequence getLabel() {
        return this.mLabel;
    }

    public String getResultKey() {
        return this.mResultKey;
    }

    public boolean isDataOnly() {
        Object object;
        int n10 = this.getAllowFreeFormInput();
        if (n10 == 0 && ((object = this.getChoices()) == null || (n10 = ((CharSequence[])(object = this.getChoices())).length) == 0) && (object = this.getAllowedDataTypes()) != null && (n10 = (int)((object = this.getAllowedDataTypes()).isEmpty() ? 1 : 0)) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }
}

