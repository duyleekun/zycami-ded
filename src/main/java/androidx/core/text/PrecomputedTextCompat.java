/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.text.Layout$Alignment
 *  android.text.PrecomputedText
 *  android.text.Spannable
 *  android.text.SpannableString
 *  android.text.StaticLayout
 *  android.text.StaticLayout$Builder
 *  android.text.TextDirectionHeuristic
 *  android.text.TextPaint
 *  android.text.TextUtils
 *  android.text.style.MetricAffectingSpan
 */
package androidx.core.text;

import android.os.Build;
import android.text.Layout;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.os.TraceCompat;
import androidx.core.text.PrecomputedTextCompat$Params;
import androidx.core.text.PrecomputedTextCompat$PrecomputedTextFutureTask;
import androidx.core.util.Preconditions;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrecomputedTextCompat
implements Spannable {
    private static final char LINE_FEED = '\n';
    private static Executor sExecutor;
    private static final Object sLock;
    private final int[] mParagraphEnds;
    private final PrecomputedTextCompat$Params mParams;
    private final Spannable mText;
    private final PrecomputedText mWrapped;

    static {
        Object object;
        sLock = object = new Object();
    }

    private PrecomputedTextCompat(PrecomputedText precomputedText, PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        this.mText = precomputedText;
        this.mParams = precomputedTextCompat$Params;
        precomputedTextCompat$Params = null;
        this.mParagraphEnds = null;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 < n11) {
            precomputedText = null;
        }
        this.mWrapped = precomputedText;
    }

    private PrecomputedTextCompat(CharSequence charSequence, PrecomputedTextCompat$Params precomputedTextCompat$Params, int[] nArray) {
        SpannableString spannableString = new SpannableString(charSequence);
        this.mText = spannableString;
        this.mParams = precomputedTextCompat$Params;
        this.mParagraphEnds = nArray;
        this.mWrapped = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static PrecomputedTextCompat create(CharSequence charSequence, PrecomputedTextCompat$Params precomputedTextCompat$Params) {
        int n10 = Build.VERSION.SDK_INT;
        Preconditions.checkNotNull(charSequence);
        Preconditions.checkNotNull(precomputedTextCompat$Params);
        TextPaint textPaint = "PrecomputedText";
        try {
            PrecomputedTextCompat precomputedTextCompat;
            Integer n11;
            int n12;
            TraceCompat.beginSection((String)textPaint);
            int n13 = 29;
            if (n10 >= n13 && (textPaint = precomputedTextCompat$Params.mWrapped) != null) {
                charSequence = PrecomputedText.create((CharSequence)charSequence, textPaint);
                PrecomputedTextCompat precomputedTextCompat2 = new PrecomputedTextCompat((PrecomputedText)charSequence, precomputedTextCompat$Params);
                return precomputedTextCompat2;
            }
            textPaint = new ArrayList();
            int n14 = charSequence.length();
            StaticLayout staticLayout = null;
            int n15 = 0;
            while (n15 < n14) {
                n12 = 10;
                n15 = (n15 = TextUtils.indexOf((CharSequence)charSequence, (char)n12, (int)n15, (int)n14)) < 0 ? n14 : ++n15;
                n11 = n15;
                textPaint.add(n11);
            }
            n14 = textPaint.size();
            int[] nArray = new int[n14];
            for (n15 = 0; n15 < (n12 = textPaint.size()); ++n15) {
                n11 = textPaint.get(n15);
                nArray[n15] = n12 = n11.intValue();
            }
            n13 = 23;
            if (n10 >= n13) {
                n10 = charSequence.length();
                textPaint = precomputedTextCompat$Params.getTextPaint();
                n15 = -1 >>> 1;
                precomputedTextCompat = StaticLayout.Builder.obtain((CharSequence)charSequence, (int)0, (int)n10, (TextPaint)textPaint, (int)n15);
                n13 = precomputedTextCompat$Params.getBreakStrategy();
                precomputedTextCompat = precomputedTextCompat.setBreakStrategy(n13);
                n13 = precomputedTextCompat$Params.getHyphenationFrequency();
                precomputedTextCompat = precomputedTextCompat.setHyphenationFrequency(n13);
                textPaint = precomputedTextCompat$Params.getTextDirection();
                precomputedTextCompat = precomputedTextCompat.setTextDirection((TextDirectionHeuristic)textPaint);
                precomputedTextCompat.build();
            } else {
                n13 = 21;
                if (n10 >= n13) {
                    n11 = precomputedTextCompat$Params.getTextPaint();
                    int n16 = -1 >>> 1;
                    Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
                    float f10 = 1.0f;
                    staticLayout = new StaticLayout(charSequence, (TextPaint)n11, n16, alignment, f10, 0.0f, false);
                }
            }
            precomputedTextCompat = new PrecomputedTextCompat(charSequence, precomputedTextCompat$Params, nArray);
            return precomputedTextCompat;
        }
        finally {
            TraceCompat.endSection();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Future getTextFuture(CharSequence object, PrecomputedTextCompat$Params object2, Executor executor) {
        PrecomputedTextCompat$PrecomputedTextFutureTask precomputedTextCompat$PrecomputedTextFutureTask = new PrecomputedTextCompat$PrecomputedTextFutureTask((PrecomputedTextCompat$Params)object2, (CharSequence)object);
        if (executor == null) {
            object = sLock;
            synchronized (object) {
                object2 = sExecutor;
                if (object2 == null) {
                    int n10 = 1;
                    sExecutor = object2 = Executors.newFixedThreadPool(n10);
                }
                executor = sExecutor;
            }
        }
        executor.execute(precomputedTextCompat$PrecomputedTextFutureTask);
        return precomputedTextCompat$PrecomputedTextFutureTask;
    }

    public char charAt(int n10) {
        return this.mText.charAt(n10);
    }

    public int getParagraphCount() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            return this.mWrapped.getParagraphCount();
        }
        return this.mParagraphEnds.length;
    }

    public int getParagraphEnd(int n10) {
        int n11 = this.getParagraphCount();
        String string2 = "paraIndex";
        Preconditions.checkArgumentInRange(n10, 0, n11, string2);
        n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            return this.mWrapped.getParagraphEnd(n10);
        }
        return this.mParagraphEnds[n10];
    }

    public int getParagraphStart(int n10) {
        int n11 = this.getParagraphCount();
        int n12 = 0;
        String string2 = "paraIndex";
        Preconditions.checkArgumentInRange(n10, 0, n11, string2);
        n11 = Build.VERSION.SDK_INT;
        int n13 = 29;
        if (n11 >= n13) {
            return this.mWrapped.getParagraphStart(n10);
        }
        if (n10 != 0) {
            int[] nArray = this.mParagraphEnds;
            n12 = nArray[n10 += -1];
        }
        return n12;
    }

    public PrecomputedTextCompat$Params getParams() {
        return this.mParams;
    }

    public PrecomputedText getPrecomputedText() {
        Spannable spannable = this.mText;
        boolean bl2 = spannable instanceof PrecomputedText;
        if (bl2) {
            return (PrecomputedText)spannable;
        }
        return null;
    }

    public int getSpanEnd(Object object) {
        return this.mText.getSpanEnd(object);
    }

    public int getSpanFlags(Object object) {
        return this.mText.getSpanFlags(object);
    }

    public int getSpanStart(Object object) {
        return this.mText.getSpanStart(object);
    }

    public Object[] getSpans(int n10, int n11, Class clazz) {
        int n12 = Build.VERSION.SDK_INT;
        int n13 = 29;
        if (n12 >= n13) {
            return this.mWrapped.getSpans(n10, n11, clazz);
        }
        return this.mText.getSpans(n10, n11, clazz);
    }

    public int length() {
        return this.mText.length();
    }

    public int nextSpanTransition(int n10, int n11, Class clazz) {
        return this.mText.nextSpanTransition(n10, n11, clazz);
    }

    public void removeSpan(Object object) {
        int n10 = object instanceof MetricAffectingSpan;
        if (n10 == 0) {
            n10 = Build.VERSION.SDK_INT;
            int n11 = 29;
            if (n10 >= n11) {
                PrecomputedText precomputedText = this.mWrapped;
                precomputedText.removeSpan(object);
            } else {
                Spannable spannable = this.mText;
                spannable.removeSpan(object);
            }
            return;
        }
        object = new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        throw object;
    }

    public void setSpan(Object object, int n10, int n11, int n12) {
        int n13 = object instanceof MetricAffectingSpan;
        if (n13 == 0) {
            n13 = Build.VERSION.SDK_INT;
            int n14 = 29;
            if (n13 >= n14) {
                PrecomputedText precomputedText = this.mWrapped;
                precomputedText.setSpan(object, n10, n11, n12);
            } else {
                Spannable spannable = this.mText;
                spannable.setSpan(object, n10, n11, n12);
            }
            return;
        }
        object = new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        throw object;
    }

    public CharSequence subSequence(int n10, int n11) {
        return this.mText.subSequence(n10, n11);
    }

    public String toString() {
        return this.mText.toString();
    }
}

