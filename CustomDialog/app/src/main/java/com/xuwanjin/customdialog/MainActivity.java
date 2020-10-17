package com.xuwanjin.customdialog;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;
import static com.xuwanjin.customdialog.VipRightsDialogUtil.VIP_RIGHTS_FFH;
import static com.xuwanjin.customdialog.VipRightsDialogUtil.VIP_RIGHTS_MULTI_OPEN;
import static com.xuwanjin.customdialog.VipRightsDialogUtil.VIP_RIGHTS_NO_ADD;
import static com.xuwanjin.customdialog.VipRightsDialogUtil.VIP_RIGHTS_PRIVACY_SPACE;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image_view = findViewById(R.id.image_view);

        Glide.with(this)
                .load(VIP_RIGHTS_MULTI_OPEN)
                .into(image_view);
        VipRightsDialogUtil.DialogCallback dialogCallback = new VipRightsDialogUtil.DialogCallback() {
            @Override
            public void onDialogShow() {
                Toast.makeText(getApplicationContext(), "onDialogShow", LENGTH_SHORT).show();
            }

            @Override
            public void onLeftClick() {
                Toast.makeText(getApplicationContext(), "onLeftClick", LENGTH_SHORT).show();
            }

            @Override
            public void onRightClick() {
                Toast.makeText(getApplicationContext(), "onRightClick", LENGTH_SHORT).show();
            }

            @Override
            public void onDialogDismiss() {
                Toast.makeText(getApplicationContext(), "onDialogDismiss", LENGTH_SHORT).show();
            }

            @Override
            public void onCloseClick() {
                Toast.makeText(getApplicationContext(), "onCloseClick", LENGTH_SHORT).show();
            }

            @Override
            public void onDialogCancel() {
                Toast.makeText(getApplicationContext(), "onCanceled", LENGTH_SHORT).show();
            }

            @Override
            public void onKeyCode(int keycode, KeyEvent event) {
                Toast.makeText(getApplicationContext(), "onKeyCode", LENGTH_SHORT).show();
            }

            @Override
            public void onKeyCodeBack(KeyEvent event) {
                Toast.makeText(getApplicationContext(), "onKeyCodeBack", LENGTH_SHORT).show();
            }
        };
        VipRightsDialogUtil.VipRightsDialog.Builder builder = new VipRightsDialogUtil.VipRightsDialog.Builder(this);
        VipRightsDialogUtil.DialogButton rightButton = new VipRightsDialogUtil.DialogButton();
        rightButton.setButtonText("限时购买");

        rightButton.setShowSuperscript(true);


        rightButton.setSuperscriptText(getText(R.string.dialog_show_vip_left_sign_text));
        ColorDrawable rightColorDrawable = new ColorDrawable();
        rightColorDrawable.setColor(Color.parseColor("#dedede"));
        rightButton.setButtonContainerBackground(rightColorDrawable);
        VipRightsDialogUtil.DialogButton leftButton = new VipRightsDialogUtil.DialogButton();
        leftButton.setButtonText("登录会员");
        leftButton.setShowSuperscript(true);

        ColorDrawable leftColorDrawable = new ColorDrawable();
        leftColorDrawable.setColor(Color.parseColor("#F4C663"));
        leftButton.setButtonContainerBackground(leftColorDrawable);
        leftButton.setSuperscriptText(getText(R.string.dialog_show_vip_left_sign_text));
        VipRightsDialogUtil.VipRightsItem itemView1 = new VipRightsDialogUtil.VipRightsItem();
        itemView1.imageUrl = VIP_RIGHTS_MULTI_OPEN;
        itemView1.vipRightsName = this.getString(R.string.vip_unlimit_multi_open);
        VipRightsDialogUtil.VipRightsItem itemView2 = new VipRightsDialogUtil.VipRightsItem();
        itemView2.imageUrl = VIP_RIGHTS_NO_ADD;
        itemView2.vipRightsName = this.getString(R.string.vip_no_ad);
        VipRightsDialogUtil.VipRightsItem itemView3 = new VipRightsDialogUtil.VipRightsItem();
        itemView3.imageUrl = VIP_RIGHTS_PRIVACY_SPACE;
        itemView3.vipRightsName = this.getString(R.string.vip_private_space);
        VipRightsDialogUtil.VipRightsItem itemView4 = new VipRightsDialogUtil.VipRightsItem();
        itemView4.imageUrl = VIP_RIGHTS_FFH;
        itemView4.vipRightsName = this.getString(R.string.vip_anti_title);
        List<VipRightsDialogUtil.VipRightsItem> vipRightsItemList = new ArrayList<>();
        vipRightsItemList.add(itemView1);
        vipRightsItemList.add(itemView2);
        vipRightsItemList.add(itemView3);
        vipRightsItemList.add(itemView4);

        VipRightsDialogUtil.DialogDecoration dialogDecoration = new VipRightsDialogUtil.DialogDecoration();
        VipRightsDialogUtil.DialogDecorationItem crownItem = new VipRightsDialogUtil.DialogDecorationItem();
        dialogDecoration.setUpperLeftCornerItem(crownItem);
        builder
                .setDialogContent(getString(R.string.toast_deny_add3))
                .setIsShowLeftButton(true)
                .setLeftButton(leftButton)
                .setIsShowRightButton(true)
                .setRightButton(rightButton)
                .setVipRightsItemList(vipRightsItemList)
                .setDialogCallback(dialogCallback)
                .setDialogDecoration(dialogDecoration)
                .setIsCanceledOnTouchOutside(false)
                .dialogOnShow();
    }
}