package com.reizx.xtfr.view;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.reizx.xtfr.R;

import org.joor.Reflect;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.btn_toast_show)
//    Button btnToastShow;
    @BindView(R.id.txt_info)
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_toast_show)
    public void toastShow(){
        Toast.makeText(getApplication(), "toast show.", Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.btn_get_rom_name)
    public void getRomName(){
        /**
         * Oppo中的一个获取Display设备rom版本号的获取方法，此种方法并非直接“Build.DISPLAY”,参数没有替换到。
         * 要求增加android.os.SystemPropertiesd的HOOK，并且将Build的参数Hook进去。
         */
        String romName = Reflect.on("android.os.SystemProperties").call("get","ro.build.display.id", "").get();
        txtInfo.append(romName);

    }
}
