package com.homenet.minipeople;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv1)
    ImageView iv1;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.iv2)
    ImageView iv2;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.iv3)
    ImageView iv3;
    @BindView(R.id.tv3)
    TextView tv3;
    @BindView(R.id.iv4)
    ImageView iv4;
    @BindView(R.id.tv4)
    TextView tv4;
    @BindView(R.id.llineralayout)
    LinearLayout llineralayout;
    @BindView(R.id.edittext)
    EditText edittext;
    @BindView(R.id.ll1)
    RelativeLayout ll1;
    @BindView(R.id.ll2)
    RelativeLayout ll2;
    @BindView(R.id.ll3)
    RelativeLayout ll3;
    @BindView(R.id.ll4)
    RelativeLayout ll4;
    private View view;
    private List<String> manmsgList;
    private ContentBean contentBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        view = View.inflate(this, R.layout.activity_main, null);
        setContentView(view);
        ButterKnife.bind(this);


        tv1.setRotation(25);
        tv2.setRotation(25);
        tv3.setRotation(25);
        tv4.setRotation(25);


        contentBean = new ContentBean();
        manmsgList = new ArrayList<>();

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                String edittest = editable.toString();
                char[] string_char = edittest.toCharArray();
                System.out.println(edittest);

                for (int a = 0; a < string_char.length; a++) {
                    manmsgList.add(string_char[a] + "");
                }

                for (int i = 0; i < manmsgList.size(); i++) {
                    switch (i) {
                        case 0:
                            ll1.setVisibility(View.VISIBLE);


                        case 1:
                            ll2.setVisibility(View.VISIBLE);


                        case 2:
                            ll3.setVisibility(View.VISIBLE);


                        case 3:
                            ll4.setVisibility(View.VISIBLE);

                    }
                }
            }
        });
    }


}
