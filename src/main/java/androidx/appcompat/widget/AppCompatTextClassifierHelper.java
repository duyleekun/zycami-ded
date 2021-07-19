/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.textclassifier.TextClassificationManager
 *  android.view.textclassifier.TextClassifier
 *  android.widget.TextView
 */
package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

public final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    public AppCompatTextClassifierHelper(TextView textView) {
        this.mTextView = textView = (TextView)Preconditions.checkNotNull(textView);
    }

    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier = this.mTextClassifier;
        if (textClassifier == null) {
            textClassifier = this.mTextView.getContext();
            Class<TextClassificationManager> clazz = TextClassificationManager.class;
            if ((textClassifier = (TextClassificationManager)textClassifier.getSystemService(clazz)) != null) {
                return textClassifier.getTextClassifier();
            }
            textClassifier = TextClassifier.NO_OP;
        }
        return textClassifier;
    }

    public void setTextClassifier(TextClassifier textClassifier) {
        this.mTextClassifier = textClassifier;
    }
}

