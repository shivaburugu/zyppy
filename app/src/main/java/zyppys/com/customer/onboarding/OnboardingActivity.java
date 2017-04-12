package zyppys.com.customer.onboarding;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import zyppys.com.customer.R;
import zyppys.com.customer.utils.KeypadUtils;

public class OnboardingActivity extends AppCompatActivity {

    private EditText et_phone;
    private RelativeLayout phoneContainer;
    private ImageView iv_phone;
    private FrameLayout fl_phonecontainer;
    private int MAX_PHONE_NUMBER_LENGTH = 10;
    private int TIME_TO_WAIT_TO_SHOW_CONTENT = 3000; // in millis
    private Button signInButton;
    private ImageView iv_clear;
    private Handler mHandler = new Handler();
    private View contentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentLayout = findViewById(R.id.content_layout);
        mHandler.postDelayed(contentShowRunnable,TIME_TO_WAIT_TO_SHOW_CONTENT);

    }

    private Runnable contentShowRunnable = new Runnable() {
        @Override
        public void run() {
            contentLayout.setVisibility(View.VISIBLE);
            final Animation animationFadeIn = AnimationUtils.loadAnimation(OnboardingActivity.this, R.anim.anim_fade_in);
            contentLayout.startAnimation(animationFadeIn);
            showContentView();
        }
    };

    private void showContentView(){
        phoneContainer = (RelativeLayout)findViewById(R.id.phone_container);
        fl_phonecontainer = (FrameLayout) findViewById(R.id.phone_icon_container);

        iv_phone = (ImageView) findViewById(R.id.phone_icon);
        et_phone = (EditText)findViewById(R.id.phone_no);
        et_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                phoneContainer.setSelected(hasFocus);
                iv_phone.setSelected(hasFocus);
            }
        });
        signInButton = (Button)findViewById(R.id.signin_button);
        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().length() == 0){
                    fl_phonecontainer.setBackgroundColor(ContextCompat.getColor(OnboardingActivity.this,R.color.transparent));
                    signInButton.setEnabled(false);
                    iv_clear.setVisibility(View.GONE);
                } else if(charSequence.toString().length() > 0 && charSequence.toString().length() < MAX_PHONE_NUMBER_LENGTH){
                    fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_phonecontainer.setSelected(false);
                    signInButton.setEnabled(false);
                    iv_clear.setVisibility(View.VISIBLE);
                } else if(charSequence.toString().length() == MAX_PHONE_NUMBER_LENGTH){
                    fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_phonecontainer.setSelected(true);
                    signInButton.setEnabled(true);
                    iv_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        iv_clear = (ImageView)findViewById(R.id.phone_clear);
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_phone.setText("");
            }
        });
        View rootLayout = findViewById(R.id.login_root);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeypadUtils.hideKeyboard(OnboardingActivity.this);
                et_phone.clearFocus();
                iv_clear.setVisibility(View.GONE);
            }
        });
    }
}
