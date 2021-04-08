package com.example.wechat;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener {

    private Fragment mTab01 = new weixinFragment();
    private Fragment mTab02 = new frdFragment();
    private Fragment mTab03 = new contactFragment();
    private Fragment mTab04 = new settingsFragment();

    private FragmentManager fm;

    private LinearLayout mTabweixin;
    private LinearLayout mTabfrd;
    private LinearLayout mTabcontact;
    private LinearLayout mTabsettings;

    private ImageButton mImgTabweixin;
    private ImageButton mImgTabfrd;
    private ImageButton mImgTabcontact;
    private ImageButton mImgTabsettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE );
        setContentView(R.layout.activity_main);

        initView();
        initFragment();
        initEvent();
        selectfragment(0);
    }

    private void initFragment(){
        fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.id_content, mTab01);
        transaction.add(R.id.id_content, mTab02);
        transaction.add(R.id.id_content, mTab03);
        transaction.add(R.id.id_content, mTab04);
        transaction.commit();
    }

    private void initView(){
        mTabweixin=(LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabfrd=(LinearLayout) findViewById(R.id.id_tab_frd);
        mTabcontact=(LinearLayout) findViewById(R.id.id_tab_contact);
        mTabsettings=(LinearLayout) findViewById(R.id.id_tab_settings);

        mImgTabweixin = (ImageButton)findViewById(R.id.id_tab_weixin_img);
        mImgTabfrd = (ImageButton)findViewById(R.id.id_tab_frd_img);
        mImgTabcontact = (ImageButton)findViewById(R.id.id_tab_contact_img);
        mImgTabsettings = (ImageButton)findViewById(R.id.id_tab_settings_img);
    }

    private void initEvent(){
        mTabweixin.setOnClickListener(this);
        mTabfrd.setOnClickListener(this);
        mTabcontact.setOnClickListener(this);
        mTabsettings.setOnClickListener(this);
    }

    private void hideFragment(FragmentTransaction transaction) {
        transaction.hide(mTab01);
        transaction.hide(mTab02);
        transaction.hide(mTab03);
        transaction.hide(mTab04);
    }

    private void selectfragment(int i){
        FragmentTransaction transaction = fm.beginTransaction();
        hideFragment(transaction);
        //把图片设置为亮的
        //设置内容区域
        switch (i){
            case 0:
                transaction.show(mTab01);
                mImgTabweixin.setImageResource(R.drawable.tab_weixin_pressed);
                break;
            case 1:
                transaction.show(mTab02);
                mImgTabfrd.setImageResource(R.drawable.tab_find_frd_pressed);
                break;
            case 2:
                transaction.show(mTab03);
                mImgTabcontact.setImageResource(R.drawable.tab_address_pressed);
                break;
            case 3:
                transaction.show(mTab04);
                mImgTabsettings.setImageResource(R.drawable.tab_settings_pressed);
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View view) {
        resetimg();
        switch (view.getId()){
            case R.id.id_tab_weixin:
                selectfragment(0);
                break;
            case R.id.id_tab_frd:
                selectfragment(1);
                break;
            case R.id.id_tab_contact:
                selectfragment(2);
                break;
            case R.id.id_tab_settings:
                selectfragment(3);
                break;
        }
    }

    public void resetimg(){
        //图片变灰
        mImgTabweixin.setImageResource(R.drawable.tab_weixin_normal);
        mImgTabfrd.setImageResource(R.drawable.tab_find_frd_normal);
        mImgTabcontact.setImageResource(R.drawable.tab_address_normal);
        mImgTabsettings.setImageResource(R.drawable.tab_settings_normal);
    }
}