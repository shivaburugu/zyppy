package zyppys.com.customer.onboarding;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import zyppys.com.customer.R;
import zyppys.com.customer.utils.KeypadUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragment extends Fragment {

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
    private View rootView;
    private OnBoardingListener mListener;
    private TextView signUpText;
    private Bundle bundle;
    private boolean showAnimation;
    public SignInFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bundle = getArguments();
        if(bundle != null) {
            showAnimation = bundle.getBoolean(OnboardingActivity.EXTRA_SHOW_ANIM);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_sign_in, container, false);
        contentLayout = rootView.findViewById(R.id.content_layout);

        if(showAnimation) {
            showAnimation = false;
            mHandler.postDelayed(contentShowRunnable, TIME_TO_WAIT_TO_SHOW_CONTENT);
        } else {
            contentLayout.setVisibility(View.VISIBLE);
            showContentView();
        }
        return rootView;
    }

    private Runnable contentShowRunnable = new Runnable() {
        @Override
        public void run() {
            contentLayout.setVisibility(View.VISIBLE);
            final Animation animationFadeIn = AnimationUtils.loadAnimation(getActivity(), R.anim.anim_fade_in);
            contentLayout.startAnimation(animationFadeIn);
            showContentView();
        }
    };

    private void showContentView(){
        phoneContainer = (RelativeLayout)rootView.findViewById(R.id.phone_container);
        fl_phonecontainer = (FrameLayout)rootView.findViewById(R.id.phone_icon_container);
        signUpText = (TextView)rootView.findViewById(R.id.signup_text);

        signUpText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onSignupSelected();
                }
            }
        });

        iv_phone = (ImageView)rootView.findViewById(R.id.phone_icon);
        et_phone = (EditText)rootView.findViewById(R.id.phone_no);
        et_phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                phoneContainer.setSelected(hasFocus);
                iv_phone.setSelected(hasFocus);
                if(hasFocus){
                    iv_clear.setVisibility(View.VISIBLE);
                }
            }
        });
        et_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().length() == 0){
                    fl_phonecontainer.setBackgroundColor(ContextCompat.getColor(getActivity(),R.color.transparent));
                    signInButton.setEnabled(false);
                    iv_clear.setVisibility(View.GONE);
                } else if(charSequence.toString().length() > 0 && charSequence.toString().length() < MAX_PHONE_NUMBER_LENGTH){
                    fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_phonecontainer.setEnabled(false);
                    signInButton.setEnabled(false);
                    iv_clear.setVisibility(View.VISIBLE);
                } else if(charSequence.toString().length() == MAX_PHONE_NUMBER_LENGTH){
                    fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_phonecontainer.setEnabled(true);
                    signInButton.setEnabled(true);
                    iv_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_phone.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    KeypadUtils.hideKeyboard(getActivity());
                    et_phone.clearFocus();
                    iv_clear.setVisibility(View.GONE);
                    if(et_phone.getText() != null && et_phone.getText().toString().length() == MAX_PHONE_NUMBER_LENGTH){
                        //iv_phone.setSelected(true);
                        //fl_phonecontainer.setSelected(true);
                        fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    } else {
                        //iv_phone.setSelected(false);
                    }
                }
                return false;
            }
        });

        signInButton = (Button)rootView.findViewById(R.id.signin_button);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onSignInSelected();
                }
            }
        });

        iv_clear = (ImageView)rootView.findViewById(R.id.phone_clear);
        iv_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_phone.setText("");
            }
        });
        View rootLayout = rootView.findViewById(R.id.login_root);
        rootLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KeypadUtils.hideKeyboard(getActivity());
                et_phone.clearFocus();
                iv_clear.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnBoardingListener) {
            mListener = (OnBoardingListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

}
