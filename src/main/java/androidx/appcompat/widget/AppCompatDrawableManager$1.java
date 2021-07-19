/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.LayerDrawable
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$color;
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$drawable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.appcompat.widget.ResourceManagerInternal$ResourceManagerHooks;
import androidx.appcompat.widget.ThemeUtils;
import androidx.core.graphics.ColorUtils;

public class AppCompatDrawableManager$1
implements ResourceManagerInternal$ResourceManagerHooks {
    private final int[] COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
    private final int[] COLORFILTER_COLOR_CONTROL_ACTIVATED;
    private final int[] COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
    private final int[] TINT_CHECKABLE_BUTTON_LIST;
    private final int[] TINT_COLOR_CONTROL_NORMAL;
    private final int[] TINT_COLOR_CONTROL_STATE_LIST;

    public AppCompatDrawableManager$1() {
        int n10;
        int n11;
        int n12 = 3;
        int[] nArray = new int[n12];
        nArray[0] = n11 = R$drawable.abc_textfield_search_default_mtrl_alpha;
        n11 = R$drawable.abc_textfield_default_mtrl_alpha;
        int n13 = 1;
        nArray[n13] = n11;
        n11 = R$drawable.abc_ab_share_pack_mtrl_alpha;
        int n14 = 2;
        nArray[n14] = n11;
        this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL = nArray;
        int n15 = 7;
        int[] nArray2 = new int[n15];
        nArray2[0] = n10 = R$drawable.abc_ic_commit_search_api_mtrl_alpha;
        nArray2[n13] = n10 = R$drawable.abc_seekbar_tick_mark_material;
        nArray2[n14] = n10 = R$drawable.abc_ic_menu_share_mtrl_alpha;
        nArray2[n12] = n10 = R$drawable.abc_ic_menu_copy_mtrl_am_alpha;
        n10 = R$drawable.abc_ic_menu_cut_mtrl_alpha;
        int n16 = 4;
        nArray2[n16] = n10;
        n10 = R$drawable.abc_ic_menu_selectall_mtrl_alpha;
        int n17 = 5;
        nArray2[n17] = n10;
        n10 = R$drawable.abc_ic_menu_paste_mtrl_am_alpha;
        int n18 = 6;
        nArray2[n18] = n10;
        this.TINT_COLOR_CONTROL_NORMAL = nArray2;
        nArray = new int[n15];
        nArray[0] = n11 = R$drawable.abc_textfield_activated_mtrl_alpha;
        nArray[n13] = n11 = R$drawable.abc_textfield_search_activated_mtrl_alpha;
        nArray[n14] = n11 = R$drawable.abc_cab_background_top_mtrl_alpha;
        nArray[n12] = n11 = R$drawable.abc_text_cursor_material;
        nArray[n16] = n11 = R$drawable.abc_text_select_handle_left_mtrl;
        nArray[n17] = n11 = R$drawable.abc_text_select_handle_middle_mtrl;
        nArray[n18] = n11 = R$drawable.abc_text_select_handle_right_mtrl;
        this.COLORFILTER_COLOR_CONTROL_ACTIVATED = nArray;
        nArray = new int[n12];
        nArray[0] = n11 = R$drawable.abc_popup_background_mtrl_mult;
        nArray[n13] = n11 = R$drawable.abc_cab_background_internal_bg;
        nArray[n14] = n11 = R$drawable.abc_menu_hardkey_panel_mtrl_mult;
        this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY = nArray;
        nArray = new int[n14];
        nArray[0] = n11 = R$drawable.abc_tab_indicator_material;
        nArray[n13] = n11 = R$drawable.abc_textfield_search_material;
        this.TINT_COLOR_CONTROL_STATE_LIST = nArray;
        nArray = new int[n16];
        nArray[0] = n11 = R$drawable.abc_btn_check_material;
        nArray[n13] = n11 = R$drawable.abc_btn_radio_material;
        nArray[n14] = n11 = R$drawable.abc_btn_check_material_anim;
        nArray[n12] = n11 = R$drawable.abc_btn_radio_material_anim;
        this.TINT_CHECKABLE_BUTTON_LIST = nArray;
    }

    private boolean arrayContains(int[] nArray, int n10) {
        for (int n11 : nArray) {
            if (n11 != n10) continue;
            return true;
        }
        return false;
    }

    private ColorStateList createBorderlessButtonColorStateList(Context context) {
        return this.createButtonColorStateList(context, 0);
    }

    private ColorStateList createButtonColorStateList(Context object, int n10) {
        int n11 = 4;
        int[][] nArrayArray = new int[n11][];
        int[] nArray = new int[n11];
        int n12 = R$attr.colorControlHighlight;
        n12 = ThemeUtils.getThemeAttrColor(object, n12);
        int n13 = R$attr.colorButtonNormal;
        int n14 = ThemeUtils.getDisabledThemeAttrColor(object, n13);
        int[] nArray2 = ThemeUtils.DISABLED_STATE_SET;
        nArrayArray[0] = nArray2;
        nArray[0] = n14;
        object = ThemeUtils.PRESSED_STATE_SET;
        n13 = 1;
        nArrayArray[n13] = (int[])object;
        nArray[n13] = n14 = ColorUtils.compositeColors(n12, n10);
        object = ThemeUtils.FOCUSED_STATE_SET;
        n13 = 2;
        nArrayArray[n13] = (int[])object;
        nArray[n13] = n14 = ColorUtils.compositeColors(n12, n10);
        object = ThemeUtils.EMPTY_STATE_SET;
        n12 = 3;
        nArrayArray[n12] = (int[])object;
        nArray[n12] = n10;
        object = new ColorStateList((int[][])nArrayArray, nArray);
        return object;
    }

    private ColorStateList createColoredButtonColorStateList(Context context) {
        int n10 = R$attr.colorAccent;
        n10 = ThemeUtils.getThemeAttrColor(context, n10);
        return this.createButtonColorStateList(context, n10);
    }

    private ColorStateList createDefaultButtonColorStateList(Context context) {
        int n10 = R$attr.colorButtonNormal;
        n10 = ThemeUtils.getThemeAttrColor(context, n10);
        return this.createButtonColorStateList(context, n10);
    }

    private ColorStateList createSwitchThumbColorStateList(Context object) {
        boolean bl2;
        int n10 = 3;
        int[][] nArrayArray = new int[n10][];
        int[] nArray = new int[n10];
        int n11 = R$attr.colorSwitchThumbNormal;
        Object object2 = ThemeUtils.getThemeAttrColorStateList(object, n11);
        int n12 = 2;
        int n13 = 1;
        if (object2 != null && (bl2 = object2.isStateful())) {
            int n14;
            int[] nArray2 = ThemeUtils.DISABLED_STATE_SET;
            nArrayArray[0] = nArray2;
            nArray2 = nArrayArray[0];
            nArray[0] = n11 = object2.getColorForState(nArray2, 0);
            nArray2 = ThemeUtils.CHECKED_STATE_SET;
            nArrayArray[n13] = nArray2;
            n11 = R$attr.colorControlActivated;
            nArray[n13] = n14 = ThemeUtils.getThemeAttrColor(object, n11);
            object = ThemeUtils.EMPTY_STATE_SET;
            nArrayArray[n12] = (int[])object;
            nArray[n12] = n14 = object2.getDefaultColor();
        } else {
            int n15;
            int n16;
            object2 = ThemeUtils.DISABLED_STATE_SET;
            nArrayArray[0] = (int[])object2;
            nArray[0] = n16 = ThemeUtils.getDisabledThemeAttrColor(object, n11);
            object2 = ThemeUtils.CHECKED_STATE_SET;
            nArrayArray[n13] = (int[])object2;
            n16 = R$attr.colorControlActivated;
            nArray[n13] = n16 = ThemeUtils.getThemeAttrColor(object, n16);
            object2 = ThemeUtils.EMPTY_STATE_SET;
            nArrayArray[n12] = (int[])object2;
            nArray[n12] = n15 = ThemeUtils.getThemeAttrColor(object, n11);
        }
        object = new ColorStateList((int[][])nArrayArray, nArray);
        return object;
    }

    private LayerDrawable getRatingBarLayerDrawable(ResourceManagerInternal resourceManagerInternal, Context context, int n10) {
        Drawable[] drawableArray;
        n10 = context.getResources().getDimensionPixelSize(n10);
        int n11 = R$drawable.abc_star_black_48dp;
        Drawable drawable2 = resourceManagerInternal.getDrawable(context, n11);
        int n12 = R$drawable.abc_star_half_black_48dp;
        resourceManagerInternal = resourceManagerInternal.getDrawable(context, n12);
        int n13 = drawable2 instanceof BitmapDrawable;
        n12 = 0;
        if (n13 != 0 && (n13 = drawable2.getIntrinsicWidth()) == n10 && (n13 = drawable2.getIntrinsicHeight()) == n10) {
            drawable2 = (BitmapDrawable)drawable2;
            drawableArray = drawable2.getBitmap();
            context = new BitmapDrawable((Bitmap)drawableArray);
        } else {
            context = Bitmap.Config.ARGB_8888;
            context = Bitmap.createBitmap((int)n10, (int)n10, (Bitmap.Config)context);
            drawableArray = new Canvas((Bitmap)context);
            drawable2.setBounds(0, 0, n10, n10);
            drawable2.draw((Canvas)drawableArray);
            drawable2 = new BitmapDrawable((Bitmap)context);
            drawableArray = new BitmapDrawable((Bitmap)context);
            context = drawableArray;
        }
        drawableArray = Shader.TileMode.REPEAT;
        context.setTileModeX((Shader.TileMode)drawableArray);
        int n14 = resourceManagerInternal instanceof BitmapDrawable;
        if (n14 != 0 && (n14 = ((Drawable)resourceManagerInternal).getIntrinsicWidth()) == n10 && (n14 = ((Drawable)resourceManagerInternal).getIntrinsicHeight()) == n10) {
            resourceManagerInternal = (BitmapDrawable)resourceManagerInternal;
        } else {
            drawableArray = Bitmap.Config.ARGB_8888;
            drawableArray = Bitmap.createBitmap((int)n10, (int)n10, (Bitmap.Config)drawableArray);
            Canvas canvas = new Canvas((Bitmap)drawableArray);
            ((Drawable)resourceManagerInternal).setBounds(0, 0, n10, n10);
            ((Drawable)resourceManagerInternal).draw(canvas);
            resourceManagerInternal = new BitmapDrawable((Bitmap)drawableArray);
        }
        drawableArray = new Drawable[3];
        drawableArray[0] = drawable2;
        n11 = 1;
        drawableArray[n11] = resourceManagerInternal;
        int n15 = 2;
        drawableArray[n15] = context;
        LayerDrawable layerDrawable = new LayerDrawable(drawableArray);
        layerDrawable.setId(0, 0x1020000);
        layerDrawable.setId(n11, 16908303);
        layerDrawable.setId(n15, 16908301);
        return layerDrawable;
    }

    private void setPorterDuffColorFilter(Drawable drawable2, int n10, PorterDuff.Mode mode) {
        boolean bl2 = DrawableUtils.canSafelyMutateDrawable(drawable2);
        if (bl2) {
            drawable2 = drawable2.mutate();
        }
        if (mode == null) {
            mode = AppCompatDrawableManager.access$000();
        }
        PorterDuffColorFilter porterDuffColorFilter = AppCompatDrawableManager.getPorterDuffColorFilter(n10, mode);
        drawable2.setColorFilter((ColorFilter)porterDuffColorFilter);
    }

    public Drawable createDrawableFor(ResourceManagerInternal resourceManagerInternal, Context context, int n10) {
        int n11 = R$drawable.abc_cab_background_top_material;
        if (n10 == n11) {
            Drawable drawable2;
            Drawable[] drawableArray = new Drawable[2];
            int n12 = R$drawable.abc_cab_background_internal_bg;
            drawableArray[0] = drawable2 = resourceManagerInternal.getDrawable(context, n12);
            n12 = R$drawable.abc_cab_background_top_mtrl_alpha;
            resourceManagerInternal = resourceManagerInternal.getDrawable(context, n12);
            drawableArray[1] = resourceManagerInternal;
            LayerDrawable layerDrawable = new LayerDrawable(drawableArray);
            return layerDrawable;
        }
        n11 = R$drawable.abc_ratingbar_material;
        if (n10 == n11) {
            n10 = R$dimen.abc_star_big;
            return this.getRatingBarLayerDrawable(resourceManagerInternal, context, n10);
        }
        n11 = R$drawable.abc_ratingbar_indicator_material;
        if (n10 == n11) {
            n10 = R$dimen.abc_star_medium;
            return this.getRatingBarLayerDrawable(resourceManagerInternal, context, n10);
        }
        n11 = R$drawable.abc_ratingbar_small_material;
        if (n10 == n11) {
            n10 = R$dimen.abc_star_small;
            return this.getRatingBarLayerDrawable(resourceManagerInternal, context, n10);
        }
        return null;
    }

    public ColorStateList getTintListForDrawableRes(Context context, int n10) {
        int n11 = R$drawable.abc_edit_text_material;
        if (n10 == n11) {
            n10 = R$color.abc_tint_edittext;
            return AppCompatResources.getColorStateList(context, n10);
        }
        n11 = R$drawable.abc_switch_track_mtrl_alpha;
        if (n10 == n11) {
            n10 = R$color.abc_tint_switch_track;
            return AppCompatResources.getColorStateList(context, n10);
        }
        n11 = R$drawable.abc_switch_thumb_material;
        if (n10 == n11) {
            return this.createSwitchThumbColorStateList(context);
        }
        n11 = R$drawable.abc_btn_default_mtrl_shape;
        if (n10 == n11) {
            return this.createDefaultButtonColorStateList(context);
        }
        n11 = R$drawable.abc_btn_borderless_material;
        if (n10 == n11) {
            return this.createBorderlessButtonColorStateList(context);
        }
        n11 = R$drawable.abc_btn_colored_material;
        if (n10 == n11) {
            return this.createColoredButtonColorStateList(context);
        }
        n11 = R$drawable.abc_spinner_mtrl_am_alpha;
        if (n10 != n11 && n10 != (n11 = R$drawable.abc_spinner_textfield_background_material)) {
            int[] nArray = this.TINT_COLOR_CONTROL_NORMAL;
            n11 = (int)(this.arrayContains(nArray, n10) ? 1 : 0);
            if (n11 != 0) {
                n10 = R$attr.colorControlNormal;
                return ThemeUtils.getThemeAttrColorStateList(context, n10);
            }
            nArray = this.TINT_COLOR_CONTROL_STATE_LIST;
            n11 = (int)(this.arrayContains(nArray, n10) ? 1 : 0);
            if (n11 != 0) {
                n10 = R$color.abc_tint_default;
                return AppCompatResources.getColorStateList(context, n10);
            }
            nArray = this.TINT_CHECKABLE_BUTTON_LIST;
            n11 = (int)(this.arrayContains(nArray, n10) ? 1 : 0);
            if (n11 != 0) {
                n10 = R$color.abc_tint_btn_checkable;
                return AppCompatResources.getColorStateList(context, n10);
            }
            n11 = R$drawable.abc_seekbar_thumb_material;
            if (n10 == n11) {
                n10 = R$color.abc_tint_seek_thumb;
                return AppCompatResources.getColorStateList(context, n10);
            }
            return null;
        }
        n10 = R$color.abc_tint_spinner;
        return AppCompatResources.getColorStateList(context, n10);
    }

    public PorterDuff.Mode getTintModeForDrawableRes(int n10) {
        PorterDuff.Mode mode;
        int n11 = R$drawable.abc_switch_thumb_material;
        if (n10 == n11) {
            mode = PorterDuff.Mode.MULTIPLY;
        } else {
            n10 = 0;
            mode = null;
        }
        return mode;
    }

    public boolean tintDrawable(Context context, int n10, Drawable drawable2) {
        int n11 = R$drawable.abc_seekbar_track_material;
        boolean bl2 = true;
        int n12 = 16908301;
        int n13 = 16908303;
        int n14 = 0x1020000;
        if (n10 == n11) {
            drawable2 = (LayerDrawable)drawable2;
            Drawable drawable3 = drawable2.findDrawableByLayerId(n14);
            n11 = R$attr.colorControlNormal;
            n14 = ThemeUtils.getThemeAttrColor(context, n11);
            PorterDuff.Mode mode = AppCompatDrawableManager.access$000();
            this.setPorterDuffColorFilter(drawable3, n14, mode);
            drawable3 = drawable2.findDrawableByLayerId(n13);
            n11 = ThemeUtils.getThemeAttrColor(context, n11);
            PorterDuff.Mode mode2 = AppCompatDrawableManager.access$000();
            this.setPorterDuffColorFilter(drawable3, n11, mode2);
            drawable3 = drawable2.findDrawableByLayerId(n12);
            int n15 = R$attr.colorControlActivated;
            int n16 = ThemeUtils.getThemeAttrColor(context, n15);
            drawable2 = AppCompatDrawableManager.access$000();
            this.setPorterDuffColorFilter(drawable3, n16, (PorterDuff.Mode)drawable2);
            return bl2;
        }
        n11 = R$drawable.abc_ratingbar_material;
        if (n10 != n11 && n10 != (n11 = R$drawable.abc_ratingbar_indicator_material) && n10 != (n11 = R$drawable.abc_ratingbar_small_material)) {
            return false;
        }
        drawable2 = (LayerDrawable)drawable2;
        Drawable drawable4 = drawable2.findDrawableByLayerId(n14);
        n11 = R$attr.colorControlNormal;
        n11 = ThemeUtils.getDisabledThemeAttrColor(context, n11);
        PorterDuff.Mode mode = AppCompatDrawableManager.access$000();
        this.setPorterDuffColorFilter(drawable4, n11, mode);
        drawable4 = drawable2.findDrawableByLayerId(n13);
        n11 = R$attr.colorControlActivated;
        n13 = ThemeUtils.getThemeAttrColor(context, n11);
        mode = AppCompatDrawableManager.access$000();
        this.setPorterDuffColorFilter(drawable4, n13, mode);
        drawable4 = drawable2.findDrawableByLayerId(n12);
        int n17 = ThemeUtils.getThemeAttrColor(context, n11);
        drawable2 = AppCompatDrawableManager.access$000();
        this.setPorterDuffColorFilter(drawable4, n17, (PorterDuff.Mode)drawable2);
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    public boolean tintDrawableUsingColorFilter(Context var1_1, int var2_2, Drawable var3_3) {
        block7: {
            block9: {
                block8: {
                    var4_4 = AppCompatDrawableManager.access$000();
                    var5_5 = this.COLORFILTER_TINT_COLOR_CONTROL_NORMAL;
                    var6_6 = this.arrayContains(var5_5, var2_2);
                    var7_7 = 0x1010031;
                    var8_8 = -1;
                    var9_9 = 0.0f / 0.0f;
                    var10_10 = 1;
                    if (var6_6 != 0) {
                        var7_7 = R$attr.colorControlNormal;
lbl10:
                        // 4 sources

                        while (true) {
                            var2_2 = var8_8;
                            var11_11 = var9_9;
lbl13:
                            // 2 sources

                            while (true) {
                                var6_6 = var10_10;
                                break block7;
                                break;
                            }
                            break;
                        }
                    }
                    var5_5 = this.COLORFILTER_COLOR_CONTROL_ACTIVATED;
                    var6_6 = this.arrayContains(var5_5, var2_2);
                    if (var6_6 == 0) break block8;
                    var7_7 = R$attr.colorControlActivated;
                    ** GOTO lbl10
                }
                var5_5 = this.COLORFILTER_COLOR_BACKGROUND_MULTIPLY;
                var6_6 = this.arrayContains(var5_5, var2_2);
                if (var6_6 == 0) break block9;
                var4_4 = PorterDuff.Mode.MULTIPLY;
                ** GOTO lbl10
            }
            var6_6 = R$drawable.abc_list_divider_mtrl_alpha;
            if (var2_2 == var6_6) {
                var7_7 = 0x1010030;
                var11_12 = 40.8f;
                var2_2 = Math.round(var11_12);
                ** continue;
            }
            var6_6 = R$drawable.abc_dialog_material_background;
            if (var2_2 != var6_6) ** break;
            ** while (true)
            var2_2 = var8_8;
            var11_13 = var9_9;
            var6_6 = 0;
            var5_5 = null;
            var7_7 = 0;
        }
        if (var6_6 != 0) {
            var6_6 = DrawableUtils.canSafelyMutateDrawable(var3_3);
            if (var6_6 != 0) {
                var3_3 = var3_3.mutate();
            }
            var12_14 = ThemeUtils.getThemeAttrColor(var1_1, var7_7);
            var1_1 = AppCompatDrawableManager.getPorterDuffColorFilter(var12_14, var4_4);
            var3_3.setColorFilter((ColorFilter)var1_1);
            if (var2_2 != var8_8) {
                var3_3.setAlpha(var2_2);
            }
            return var10_10;
        }
        return false;
    }
}

