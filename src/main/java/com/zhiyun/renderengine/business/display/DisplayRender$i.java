/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.zhiyun.renderengine.business.display;

import android.os.Handler;
import android.os.Message;
import com.zhiyun.renderengine.business.display.DisplayRender;

public class DisplayRender$i
implements Handler.Callback {
    public final /* synthetic */ DisplayRender a;

    public DisplayRender$i(DisplayRender displayRender) {
        this.a = displayRender;
    }

    public boolean handleMessage(Message object) {
        int n10 = object.what;
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 != n11) {
                        n11 = 80;
                        if (n10 != n11) {
                            switch (n10) {
                                default: {
                                    break;
                                }
                                case 36: {
                                    DisplayRender displayRender = this.a;
                                    DisplayRender.G(displayRender, object);
                                    break;
                                }
                                case 35: {
                                    DisplayRender displayRender = this.a;
                                    DisplayRender.F(displayRender, object);
                                    break;
                                }
                                case 34: {
                                    DisplayRender displayRender = this.a;
                                    DisplayRender.H(displayRender, object);
                                    break;
                                }
                                case 33: {
                                    DisplayRender displayRender = this.a;
                                    DisplayRender.E(displayRender, object);
                                    break;
                                }
                            }
                        } else {
                            DisplayRender displayRender = this.a;
                            DisplayRender.I(displayRender, object);
                        }
                    } else {
                        object = this.a;
                        DisplayRender.D((DisplayRender)object);
                    }
                } else {
                    DisplayRender displayRender = this.a;
                    DisplayRender.B(displayRender, object);
                }
            } else {
                DisplayRender displayRender = this.a;
                DisplayRender.p(displayRender, object);
            }
        } else {
            DisplayRender displayRender = this.a;
            DisplayRender.a(displayRender, object);
        }
        return false;
    }
}

