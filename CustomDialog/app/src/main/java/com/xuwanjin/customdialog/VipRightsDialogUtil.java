package com.xuwanjin.customdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @author EG.
 */
public class VipRightsDialogUtil {

    private static final String TAG = "VipRightsDialogUtil";

    private final Context mContext;

    private static VipRightsDialogUtil util;

    public static final String VIP_RIGHTS_MULTI_OPEN = "https://oss.excelliance.cn/app_img/16/1587453622153679.png";
    public static final String VIP_RIGHTS_NO_ADD = "https://oss.excelliance.cn/app_img/17/1587453651638513.png";
    public static final String VIP_RIGHTS_PRIVACY_SPACE = "https://oss.excelliance.cn/app_img/18/1587453683284991.png";
    public static final String VIP_RIGHTS_FFH = "https://oss.excelliance.cn/app_img/19/1587453711673103.png";

    public static class DialogCallback {
        public void onDialogShow() {

        }

        public void onLeftClick() {

        }

        public void onRightClick() {

        }

        public void onDialogDismiss() {

        }

        public void onCloseClick() {

        }

        public void onDialogCancel() {

        }

        public void onKeyCode(int keycode, KeyEvent event) {

        }

        public void onKeyCodeBack(KeyEvent event) {

        }
    }


    public static class VipRightsDialog {
        @StyleRes
        private int themeResId = 0;

        private boolean isShowLeftButton;
        private boolean isShowRightButton;
        private boolean isCanceledOnTouchOutside;

        private CharSequence dialogContent;
        private List<VipRightsItem> vipRightsItemList;
        private DialogButton leftButton;
        private DialogButton rightButton;
        private DialogCallback dialogCallback;
        private DialogDecoration dialogDecoration;

        public static class Builder {
            private VipRightsDialog vipRightsDialog;
            private Context mContext;

            public Builder(Context context) {
                vipRightsDialog = new VipRightsDialog();
                mContext = context;
            }

            public Builder setIsShowLeftButton(boolean isShow) {
                vipRightsDialog.isShowLeftButton = isShow;
                return this;
            }

            public Builder setIsShowRightButton(boolean isShow) {
                vipRightsDialog.isShowRightButton = isShow;
                return this;
            }

            public Builder setThemeResId(@StyleRes int themeResId) {
                vipRightsDialog.themeResId = themeResId;
                return this;
            }

            public Builder setLeftButton(DialogButton dialogButton) {
                vipRightsDialog.leftButton = dialogButton;
                return this;
            }

            public Builder setRightButton(DialogButton dialogButton) {
                vipRightsDialog.rightButton = dialogButton;
                return this;
            }

            public Builder setDialogCallback(DialogCallback dialogCallback) {
                vipRightsDialog.dialogCallback = dialogCallback;
                return this;
            }

            public Builder setDialogContent(CharSequence content) {
                vipRightsDialog.dialogContent = content;
                return this;
            }

            public Builder setDialogDecoration(DialogDecoration dialogDecoration) {
                vipRightsDialog.dialogDecoration = dialogDecoration;
                return this;
            }

            public Builder setIsCanceledOnTouchOutside(boolean isCanceledOnTouchOutside) {
                vipRightsDialog.isCanceledOnTouchOutside = isCanceledOnTouchOutside;
                return this;
            }

            public void setVipRightsDialog(VipRightsDialog vipRightsDialog) {
                this.vipRightsDialog = vipRightsDialog;
            }

            public Builder setVipRightsItemList(List<VipRightsItem> itemViewList) {
                vipRightsDialog.vipRightsItemList = itemViewList;
                return this;
            }

            public void dialogOnShow() {
                showVipRightsDialog(mContext, vipRightsDialog);
            }
        }

    }

    public static class VipRightsItem {
        public String imageUrl;
        public CharSequence vipRightsName;
    }

    public static class DialogDecorationItem {
        @DrawableRes
        private int resId;
        private String resUrl;

        public DialogDecorationItem setResId(int resId) {
            this.resId = resId;
            return this;
        }

        public DialogDecorationItem setResUrl(String resUrl) {
            this.resUrl = resUrl;
            return this;
        }
    }

    public static class DialogDecoration {
        private DialogDecorationItem upperLeftCornerItem;
        private DialogDecorationItem leftMiddleItem;
        private DialogDecorationItem rightMiddleItem;
        private DialogDecorationItem lowerLeftCornerItem;
        private DialogDecorationItem lowerRightCornerItem;

        public void setUpperLeftCornerItem(DialogDecorationItem upperLeftCornerItem) {
            this.upperLeftCornerItem = upperLeftCornerItem;
        }

        public void setLeftMiddleItem(DialogDecorationItem leftMiddleItem) {
            this.leftMiddleItem = leftMiddleItem;
        }

        public void setRightMiddleItem(DialogDecorationItem rightMiddleItem) {
            this.rightMiddleItem = rightMiddleItem;
        }

        public void setLowerLeftCornerItem(DialogDecorationItem lowerLeftCornerItem) {
            this.lowerLeftCornerItem = lowerLeftCornerItem;
        }

        public void setLowerRightCornerItem(DialogDecorationItem lowerRightCornerItem) {
            this.lowerRightCornerItem = lowerRightCornerItem;
        }
    }

    public static class DialogButton {
        private CharSequence buttonText;
        @ColorInt
        private int textColor;
        private Drawable buttonContainerBackground;
        private boolean isShowSuperscript = false;
        private CharSequence superscriptText;

        public void setButtonText(CharSequence buttonText) {
            this.buttonText = buttonText;
        }

        public void setTextColor(int textColor) {
            this.textColor = textColor;
        }

        public void setButtonContainerBackground(Drawable backgroundDrawable) {
            this.buttonContainerBackground = backgroundDrawable;
        }

        public void setShowSuperscript(boolean showSuperscript) {
            isShowSuperscript = showSuperscript;
        }

        public void setSuperscriptText(CharSequence superscriptText) {
            this.superscriptText = superscriptText;
        }
    }

    private VipRightsDialogUtil(Context context) {
        mContext = context.getApplicationContext();
    }

    public static synchronized VipRightsDialogUtil getInstance(Context context) {
        if (util == null) {
            util = new VipRightsDialogUtil(context);
        }
        return util;
    }


    public static void showVipRightsDialog(final Context activity, final VipRightsDialog vipRightsDialog) {
        if (vipRightsDialog == null) {
            throw new NullPointerException("vipRightsDialog should not be null");
        }
        int themeResId = vipRightsDialog.themeResId;
        final Dialog dialog = new Dialog(activity, themeResId > 0 ? themeResId : R.style.pop_custom_dialog_theme);
        final View contentView = LayoutInflater.from(activity).inflate(R.layout.vip_dialog, null);
        dialog.setContentView(contentView);

        setDialogDecoration(activity, contentView, vipRightsDialog.dialogDecoration);

        fillVipRightsItem(activity, contentView, vipRightsDialog);

        TextView leftFunctionDesc = contentView.findViewById(R.id.left_button_function_desc);
        TextView rightFunctionDesc = contentView.findViewById(R.id.right_button_function_desc);
        RelativeLayout leftButtonAndSuperscriptContainer = contentView.findViewById(R.id.left_button_and_superscript_container);
        RelativeLayout rightButtonAndSuperscriptContainer = contentView.findViewById(R.id.right_button_and_superscript_container);
        LinearLayout leftButtonContainer = contentView.findViewById(R.id.left_button_container);
        LinearLayout rightButtonContainer = contentView.findViewById(R.id.right_button_container);
        TextView leftButtonSuperscript = contentView.findViewById(R.id.left_button_superscript);
        TextView rightButtonSuperscript = contentView.findViewById(R.id.right_button_superscript);
        ImageView close = contentView.findViewById(R.id.iv_close);
        TextView content = contentView.findViewById(R.id.vip_rights_content);
        content.setText(vipRightsDialog.dialogContent);


        final DialogCallback dialogCallback = vipRightsDialog.dialogCallback;
        View.OnClickListener onCloseClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogCallback != null) {
                    dialogCallback.onCloseClick();
                }
            }
        };
        close.setOnClickListener(onCloseClickListener);

        final View.OnClickListener rightFunctionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogCallback != null) {
                    dialogCallback.onRightClick();
                }
                dialog.dismiss();
            }
        };
        final View.OnClickListener leftFunctionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dialogCallback != null) {
                    dialogCallback.onLeftClick();
                }
                dialog.dismiss();
            }
        };

        if (!vipRightsDialog.isShowLeftButton && !vipRightsDialog.isShowRightButton) {
            return;
        }

        if (vipRightsDialog.isShowLeftButton && vipRightsDialog.isShowRightButton) {
            if (vipRightsDialog.leftButton == null || vipRightsDialog.rightButton == null) {
                throw new IllegalArgumentException("have not set the left or right button");
            }
            leftButtonAndSuperscriptContainer.setVisibility(View.VISIBLE);
            rightButtonAndSuperscriptContainer.setVisibility(View.VISIBLE);
            if (vipRightsDialog.leftButton.buttonContainerBackground != null) {
                rightButtonContainer.setBackground(vipRightsDialog.leftButton.buttonContainerBackground);
            }
            if (vipRightsDialog.rightButton.buttonContainerBackground != null) {
                rightButtonContainer.setBackground(vipRightsDialog.rightButton.buttonContainerBackground);
            }
            leftButtonContainer.setBackground(vipRightsDialog.leftButton.buttonContainerBackground);
            rightButtonContainer.setBackground(vipRightsDialog.rightButton.buttonContainerBackground);
            leftFunctionDesc.setOnClickListener(leftFunctionClickListener);
            rightFunctionDesc.setOnClickListener(rightFunctionClickListener);
            leftFunctionDesc.setText(vipRightsDialog.leftButton.buttonText);
            rightFunctionDesc.setText(vipRightsDialog.rightButton.buttonText);
            if (vipRightsDialog.leftButton.isShowSuperscript) {
                leftButtonSuperscript.setVisibility(View.VISIBLE);
                leftButtonSuperscript.setText(vipRightsDialog.leftButton.superscriptText);
            } else {
                leftButtonSuperscript.setVisibility(View.GONE);
            }

            if (vipRightsDialog.rightButton.isShowSuperscript) {
                rightButtonSuperscript.setVisibility(View.VISIBLE);
                rightButtonSuperscript.setText(vipRightsDialog.rightButton.superscriptText);
            } else {
                rightButtonSuperscript.setVisibility(View.GONE);
            }
        }

        if (vipRightsDialog.isShowLeftButton && !vipRightsDialog.isShowRightButton) {
            if (vipRightsDialog.leftButton == null) {
                throw new IllegalArgumentException("have not set the left button");
            }
            if (vipRightsDialog.leftButton.buttonContainerBackground != null) {
                rightButtonContainer.setBackground(vipRightsDialog.leftButton.buttonContainerBackground);
            }
            rightButtonAndSuperscriptContainer.setVisibility(View.GONE);
            leftButtonAndSuperscriptContainer.setVisibility(View.VISIBLE);
            leftButtonContainer.setBackground(vipRightsDialog.leftButton.buttonContainerBackground);
            leftFunctionDesc.setText(vipRightsDialog.leftButton.buttonText);
            leftFunctionDesc.setOnClickListener(leftFunctionClickListener);
            if (vipRightsDialog.leftButton.isShowSuperscript) {
                leftButtonSuperscript.setVisibility(View.VISIBLE);
                leftButtonSuperscript.setText(vipRightsDialog.leftButton.superscriptText);
            } else {
                rightButtonSuperscript.setVisibility(View.GONE);
            }
        }

        if (!vipRightsDialog.isShowLeftButton && vipRightsDialog.isShowRightButton) {
            if (vipRightsDialog.rightButton == null) {
                throw new IllegalArgumentException("have not set the right button");
            }
            leftButtonAndSuperscriptContainer.setVisibility(View.GONE);
            rightButtonAndSuperscriptContainer.setVisibility(View.VISIBLE);
            if (vipRightsDialog.rightButton.buttonContainerBackground != null) {
                rightButtonContainer.setBackground(vipRightsDialog.rightButton.buttonContainerBackground);
            }
            rightFunctionDesc.setOnClickListener(rightFunctionClickListener);
            rightFunctionDesc.setText(vipRightsDialog.rightButton.buttonText);
            if (vipRightsDialog.rightButton.isShowSuperscript) {
                rightButtonSuperscript.setVisibility(View.VISIBLE);
                rightButtonSuperscript.setText(vipRightsDialog.rightButton.superscriptText);
            } else {
                rightButtonSuperscript.setVisibility(View.GONE);
            }
        }

        final DialogInterface.OnDismissListener onDialogDismiss = new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if (dialogCallback != null) {
                    dialogCallback.onDialogDismiss();
                }
            }
        };
        dialog.setOnDismissListener(onDialogDismiss);

        DialogInterface.OnKeyListener onKeyCodeBackListener = new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialogInterface, int keyCode, KeyEvent keyEvent) {
                if (keyCode == KeyEvent.KEYCODE_BACK && dialogCallback != null) {
                    dialogCallback.onKeyCodeBack(keyEvent);
                } else if (dialogCallback != null) {
                    dialogCallback.onKeyCode(keyCode, keyEvent);
                }
                return false;
            }
        };
        dialog.setOnKeyListener(onKeyCodeBackListener);

        dialog.setCanceledOnTouchOutside(vipRightsDialog.isCanceledOnTouchOutside);
        DialogInterface.OnCancelListener onCancelListener = new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                if (dialogCallback != null && vipRightsDialog.isCanceledOnTouchOutside) {
                    dialogCallback.onDialogCancel();
                }
                if (dialog != null) {
                    dialog.dismiss();
                }
            }
        };

        dialog.setOnCancelListener(onCancelListener);
        DialogInterface.OnShowListener onShowListener = new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                if (dialogCallback != null) {
                    dialogCallback.onDialogShow();
                }
            }
        };

        dialog.setOnShowListener(onShowListener);
        dialog.show();
    }

    private static void setDialogDecoration(Context context, View contentView, DialogDecoration dialogDecoration) {

        ImageView upperLeftCorner = contentView.findViewById(R.id.upper_left_corner);
        ImageView lowerLeftCorner = contentView.findViewById(R.id.lower_left_corner);
        ImageView lowerRightCorner = contentView.findViewById(R.id.lower_right_corner);
        ImageView leftMiddle = contentView.findViewById(R.id.left_middle);
        ImageView rightMiddle = contentView.findViewById(R.id.right_middle);

        if (dialogDecoration == null) {
            dialogDecoration = new DialogDecoration();
            dialogDecoration.upperLeftCornerItem = new DialogDecorationItem().setResId(R.drawable.crown);
            dialogDecoration.lowerLeftCornerItem = new DialogDecorationItem().setResId(R.drawable.ribbon_green);
            dialogDecoration.lowerRightCornerItem = new DialogDecorationItem().setResId(R.drawable.ribbon_blue);
            dialogDecoration.leftMiddleItem = new DialogDecorationItem().setResId(R.drawable.shake_ball_left);
            dialogDecoration.rightMiddleItem = new DialogDecorationItem().setResId(R.drawable.shake_ball_right);
        }

        if (dialogDecoration.upperLeftCornerItem == null
                && dialogDecoration.lowerLeftCornerItem == null
                && dialogDecoration.lowerRightCornerItem == null
                && dialogDecoration.rightMiddleItem == null
                && dialogDecoration.leftMiddleItem == null

        ) {
            throw new IllegalArgumentException("you want custom dialog decoration, but you didn't set any decoration item");
        }
        setDialogDecorationItem(context, upperLeftCorner, dialogDecoration.upperLeftCornerItem, R.drawable.crown);
        setDialogDecorationItem(context, lowerLeftCorner, dialogDecoration.lowerLeftCornerItem, R.drawable.ribbon_green);
        setDialogDecorationItem(context, lowerRightCorner, dialogDecoration.lowerRightCornerItem, R.drawable.ribbon_blue);
        setDialogDecorationItem(context, leftMiddle, dialogDecoration.leftMiddleItem, R.drawable.shake_ball_left);
        setDialogDecorationItem(context, rightMiddle, dialogDecoration.rightMiddleItem, R.drawable.shake_ball_right);

    }

    private static void fillVipRightsItem(final Context activity, View contentView, VipRightsDialog vipRightsDialog) {
        class VipRightsItemViewHolder extends RecyclerView.ViewHolder {
            public ImageView vipRightsPicture;
            public TextView vipRightsName;

            public VipRightsItemViewHolder(@NonNull View itemView) {
                super(itemView);
                vipRightsPicture = itemView.findViewById(R.id.vip_rights_picture);
                vipRightsName = itemView.findViewById(R.id.vip_rights_name);
            }
        }

        final RecyclerView recyclerView = contentView.findViewById(R.id.rv_vip_rights_item);
        List<VipRightsItem> vipRightsItemList = vipRightsDialog.vipRightsItemList;
        if (vipRightsItemList == null || vipRightsItemList.size() == 0) {
            VipRightsDialogUtil.VipRightsItem itemView1 = new VipRightsDialogUtil.VipRightsItem();
            itemView1.imageUrl = VIP_RIGHTS_MULTI_OPEN;
            itemView1.vipRightsName = activity.getString(R.string.vip_unlimit_multi_open);
            VipRightsDialogUtil.VipRightsItem itemView2 = new VipRightsDialogUtil.VipRightsItem();
            itemView2.imageUrl = VIP_RIGHTS_NO_ADD;
            itemView2.vipRightsName = activity.getString(R.string.vip_no_ad);
            VipRightsDialogUtil.VipRightsItem itemView3 = new VipRightsDialogUtil.VipRightsItem();
            itemView3.imageUrl = VIP_RIGHTS_PRIVACY_SPACE;
            itemView3.vipRightsName = activity.getString(R.string.vip_private_space);
            VipRightsDialogUtil.VipRightsItem itemView4 = new VipRightsDialogUtil.VipRightsItem();
            itemView4.imageUrl = VIP_RIGHTS_FFH;
            itemView4.vipRightsName = activity.getString(R.string.vip_anti_title);
            if (vipRightsItemList == null) {
                vipRightsItemList = new ArrayList<>();
            }
            vipRightsItemList.add(itemView1);
            vipRightsItemList.add(itemView2);
            vipRightsItemList.add(itemView3);
            vipRightsItemList.add(itemView4);
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        final List<VipRightsItem> itemList = vipRightsItemList;
        recyclerView.setAdapter(new RecyclerView.Adapter<VipRightsItemViewHolder>() {
            @NonNull
            @Override
            public VipRightsItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(activity).inflate(R.layout.vip_rights_item, parent, false);
                itemView.getLayoutParams().width = recyclerView.getWidth() / itemList.size();
                return new VipRightsItemViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(@NonNull VipRightsItemViewHolder holder, int position) {
                VipRightsItem vipRightsItem = itemList.get(position);
                Glide.with(activity)
                        .load(vipRightsItem.imageUrl)
                        .into(holder.vipRightsPicture);
                holder.vipRightsName.setText(vipRightsItem.vipRightsName);
            }

            @Override
            public int getItemCount() {
                return itemList.size();
            }
        });
    }

    /**
     * 资源的URL
     * 本资源
     *
     * @param context
     * @param decorationItem
     * @param defaultResId
     */
    public static void  setDialogDecorationItem(Context context, ImageView imageViewItem, DialogDecorationItem decorationItem, @DrawableRes int defaultResId) {
        if (decorationItem == null || TextUtils.isEmpty(decorationItem.resUrl)) {
            setDialogDecorationItemBackground(imageViewItem, decorationItem == null ? 0 : decorationItem.resId);
        } else {
            Glide.with(context)
                    .load(decorationItem.resUrl)
                    .placeholder(defaultResId)
                    .into(imageViewItem);
        }
    }

    /**
     * @param decorationItem  显示的 ImageView
     * @param decorationResId 显示自己订制的资源
     */
    public static void setDialogDecorationItemBackground(ImageView decorationItem, int decorationResId) {
        if (decorationResId > 0) {
            decorationItem.setBackgroundResource(decorationResId);
        } else if (decorationResId <= 0) {
            decorationItem.setVisibility(View.GONE);
        }
    }
}
