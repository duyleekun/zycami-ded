/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Typeface
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ScrollView
 *  android.widget.TextView
 */
package com.tencent.rtmp.ui;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import java.text.Format;
import java.text.SimpleDateFormat;

public class TXDashBoard
extends LinearLayout {
    public TextView a;
    public TextView b;
    public ScrollView c;
    public StringBuffer d;
    public int e;
    private final SimpleDateFormat f;
    private boolean g;

    public TXDashBoard(Context context) {
        this(context, null);
    }

    public TXDashBoard(Context object, AttributeSet attributeSet) {
        super(object, attributeSet);
        super("");
        this.d = object;
        this.e = 3000;
        super("HH:mm:ss.SSS");
        this.f = object;
        this.g = false;
        this.setOrientation(1);
        this.setVisibility(4);
    }

    private void a(ScrollView scrollView, View view) {
        if (scrollView != null && view != null) {
            int n10 = view.getMeasuredHeight();
            int n11 = scrollView.getMeasuredHeight();
            n10 -= n11;
            n11 = 0;
            if (n10 < 0) {
                n10 = 0;
                view = null;
            }
            scrollView.scrollTo(0, n10);
        }
    }

    private void b() {
        Object object = this.a;
        if (object != null) {
            return;
        }
        Object object2 = this.getContext();
        object = new TextView((Context)object2);
        this.a = object;
        object2 = this.getContext();
        object = new TextView((Context)object2);
        this.b = object;
        object2 = this.getContext();
        object = new ScrollView((Context)object2);
        this.c = object;
        int n10 = -1;
        object = new LinearLayout.LayoutParams(n10, -2);
        this.a.setLayoutParams((ViewGroup.LayoutParams)object);
        object = this.a;
        int n11 = -49023;
        object.setTextColor(n11);
        object = this.a;
        Typeface typeface = Typeface.MONOSPACE;
        object.setTypeface(typeface);
        object = new LinearLayout.LayoutParams(n10, n10);
        typeface = this.c;
        int n12 = 10;
        typeface.setPadding(0, n12, 0, 0);
        typeface = this.c;
        typeface.setLayoutParams((ViewGroup.LayoutParams)object);
        object = this.c;
        boolean bl2 = true;
        object.setVerticalScrollBarEnabled(bl2);
        this.c.setScrollbarFadingEnabled(bl2);
        object = new FrameLayout.LayoutParams(n10, n10);
        Object object3 = this.b;
        object3.setLayoutParams((ViewGroup.LayoutParams)object);
        this.b.setTextColor(n11);
        object = this.c;
        object2 = this.b;
        object.addView((View)object2);
        object = this.a;
        this.addView((View)object);
        object = this.c;
        this.addView((View)object);
        object = this.d;
        int n13 = ((StringBuffer)object).length();
        if (n13 <= 0) {
            object = this.d;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("liteav sdk version:");
            object3 = TXCCommonUtil.getSDKVersionStr();
            ((StringBuilder)object2).append((String)object3);
            object3 = "\n";
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            ((StringBuffer)object).append((String)object2);
        }
        object = this.b;
        object2 = this.d.toString();
        object.setText((CharSequence)object2);
    }

    public String a(Bundle object) {
        Object[] objectArray = new Object[12];
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("CPU:");
        String string2 = object.getString("CPU_USAGE");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[0] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("RES:");
        int n10 = object.getInt("VIDEO_WIDTH");
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append("*");
        n10 = object.getInt("VIDEO_HEIGHT");
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        n10 = 1;
        objectArray[n10] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("SPD:");
        int n11 = object.getInt("NET_SPEED");
        ((StringBuilder)charSequence).append(n11);
        String string3 = "Kbps";
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[2] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("JIT:");
        int n12 = object.getInt("NET_JITTER");
        ((StringBuilder)charSequence).append(n12);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[3] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("FPS:");
        n12 = object.getInt("VIDEO_FPS");
        ((StringBuilder)charSequence).append(n12);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[4] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("GOP:");
        n12 = object.getInt("VIDEO_GOP");
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append("s");
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[5] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("ARA:");
        n12 = object.getInt("AUDIO_BITRATE");
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[6] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("QUE:");
        n12 = object.getInt("AUDIO_CACHE");
        ((StringBuilder)charSequence).append(n12);
        Object object2 = " | ";
        ((StringBuilder)charSequence).append((String)object2);
        int n13 = object.getInt("VIDEO_CACHE");
        ((StringBuilder)charSequence).append(n13);
        String string4 = ",";
        ((StringBuilder)charSequence).append(string4);
        int n14 = object.getInt("V_SUM_CACHE_SIZE");
        ((StringBuilder)charSequence).append(n14);
        ((StringBuilder)charSequence).append(string4);
        n14 = object.getInt("V_DEC_CACHE_SIZE");
        ((StringBuilder)charSequence).append(n14);
        ((StringBuilder)charSequence).append((String)object2);
        n12 = object.getInt("AV_RECV_INTERVAL");
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string4);
        n12 = object.getInt("AV_PLAY_INTERVAL");
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string4);
        Object[] objectArray2 = new Object[n10];
        objectArray2[0] = object2 = Float.valueOf(object.getFloat("AUDIO_CACHE_THRESHOLD"));
        string2 = String.format("%.1f", objectArray2).toString();
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[7] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("VRA:");
        int n15 = object.getInt("VIDEO_BITRATE");
        ((StringBuilder)charSequence).append(n15);
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[8] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("DRP:");
        n15 = object.getInt("AUDIO_DROP");
        ((StringBuilder)charSequence).append(n15);
        ((StringBuilder)charSequence).append("|");
        n15 = object.getInt("VIDEO_DROP");
        ((StringBuilder)charSequence).append(n15);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[9] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("SVR:");
        string2 = object.getString("SERVER_IP");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        objectArray[10] = charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("AUDIO:");
        object = object.getString("AUDIO_PLAY_INFO");
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        objectArray[11] = object;
        return String.format("%-16s %-16s %-16s\n%-12s %-12s %-12s %-12s\n%-14s %-14s %-14s\n%-16s %-16s", objectArray);
    }

    public void a() {
        this.d.setLength(0);
        TextView textView = this.a;
        String string2 = "";
        if (textView != null) {
            textView.setText((CharSequence)string2);
        }
        if ((textView = this.b) != null) {
            textView.setText((CharSequence)string2);
        }
    }

    public void a(int n10, int n11, int n12, int n13) {
        ScrollView scrollView;
        TextView textView = this.a;
        if (textView != null) {
            textView.setPadding(n10, n11, n12, 0);
        }
        if ((scrollView = this.c) != null) {
            scrollView.setPadding(n10, 0, n12, n13);
        }
    }

    public void a(int n10, String string2) {
        CharSequence charSequence;
        int n11;
        int n12 = 1020;
        if (n10 == n12) {
            return;
        }
        Object object = new SimpleDateFormat("HH:mm:ss.SSS");
        long l10 = System.currentTimeMillis();
        Comparable<Long> comparable = l10;
        object = ((Format)object).format(comparable);
        while ((n12 = ((StringBuffer)(comparable = this.d)).length()) > (n11 = this.e)) {
            comparable = this.d;
            charSequence = "\n";
            n12 = ((StringBuffer)comparable).indexOf((String)charSequence);
            if (n12 == 0) {
                n12 = 1;
            }
            charSequence = this.d;
            comparable = ((StringBuffer)charSequence).delete(0, n12);
            this.d = comparable;
        }
        comparable = this.d;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("\n[");
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append("]");
        ((StringBuilder)charSequence).append(string2);
        object = ((StringBuilder)charSequence).toString();
        ((StringBuffer)comparable).append((String)object);
        this.d = comparable;
    }

    public void a(Bundle object, Bundle object2, int n10) {
        int n11 = this.g;
        if (n11 != 0) {
            return;
        }
        n11 = 2011;
        if (n10 != n11 && n10 != (n11 = 2012)) {
            boolean bl2;
            int n12;
            Object object3;
            if (object != null && (object3 = this.a) != null) {
                object = this.a((Bundle)object);
                object3.setText((CharSequence)object);
            }
            if ((n12 = ((StringBuffer)(object = this.d)).length()) <= 0) {
                object = this.d;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("liteav sdk version:");
                String string2 = TXCCommonUtil.getSDKVersionStr();
                ((StringBuilder)object3).append(string2);
                string2 = "\n";
                ((StringBuilder)object3).append(string2);
                object3 = ((StringBuilder)object3).toString();
                ((StringBuffer)object).append((String)object3);
            }
            if (object2 != null && (object = object2.getString("EVT_MSG")) != null && !(bl2 = ((String)object).isEmpty())) {
                this.a(n10, (String)object);
                object = this.b;
                if (object != null) {
                    object2 = this.d.toString();
                    object.setText((CharSequence)object2);
                }
                if ((n12 = this.getVisibility()) == 0 && (object = this.c) != null && (object2 = this.b) != null) {
                    this.a((ScrollView)object, (View)object2);
                }
            }
        }
    }

    public void a(CharSequence charSequence) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void a(String charSequence) {
        int n10;
        String string2;
        boolean bl2 = TextUtils.isEmpty((CharSequence)charSequence);
        if (bl2) {
            return;
        }
        Object object = this.f;
        long l10 = System.currentTimeMillis();
        Comparable<Long> comparable = l10;
        object = ((Format)object).format(comparable);
        comparable = new Comparable<Long>();
        CharSequence charSequence2 = "[";
        ((StringBuilder)comparable).append((String)charSequence2);
        ((StringBuilder)comparable).append((String)object);
        ((StringBuilder)comparable).append("]");
        ((StringBuilder)comparable).append((String)charSequence);
        charSequence = "\n";
        ((StringBuilder)comparable).append((String)charSequence);
        object = ((StringBuilder)comparable).toString();
        comparable = this.d;
        int n11 = ((StringBuffer)comparable).length();
        if (n11 <= 0) {
            comparable = this.d;
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append("liteav sdk version:");
            string2 = TXCCommonUtil.getSDKVersionStr();
            ((StringBuilder)charSequence2).append(string2);
            ((StringBuilder)charSequence2).append((String)charSequence);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            ((StringBuffer)comparable).append((String)charSequence2);
        }
        while ((n11 = ((StringBuffer)(comparable = this.d)).length()) > (n10 = this.e)) {
            comparable = this.d;
            n11 = ((StringBuffer)comparable).indexOf((String)charSequence);
            if (n11 == 0) {
                n11 = 1;
            }
            charSequence2 = this.d;
            string2 = null;
            comparable = ((StringBuffer)charSequence2).delete(0, n11);
            this.d = comparable;
        }
        charSequence = this.d;
        ((StringBuffer)charSequence).append((String)object);
        this.d = charSequence;
        object = this.b;
        if (object != null) {
            charSequence = ((StringBuffer)charSequence).toString();
            object.setText(charSequence);
        }
    }

    public void a(boolean bl2) {
        this.g = bl2;
    }

    public void setEventTextSize(float f10) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setTextSize(f10);
        }
    }

    public void setLogMsgLenLimit(int n10) {
        this.e = n10;
    }

    public void setShowLevel(int n10) {
        int n11 = 4;
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                this.b();
                this.a.setVisibility(0);
                ScrollView scrollView = this.c;
                scrollView.setVisibility(0);
                this.setVisibility(0);
            } else {
                this.b();
                this.a.setVisibility(0);
                ScrollView scrollView = this.c;
                scrollView.setVisibility(n11);
                this.setVisibility(0);
            }
        } else {
            TextView textView = this.a;
            if (textView != null) {
                textView.setVisibility(n11);
            }
            if ((textView = this.c) != null) {
                textView.setVisibility(n11);
            }
            this.setVisibility(n11);
        }
    }

    public void setStatusTextSize(float f10) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setTextSize(f10);
        }
    }
}

