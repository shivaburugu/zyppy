package zyppys.com.customer.onboarding;


import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import zyppys.com.customer.R;
import zyppys.com.customer.utils.KeypadUtils;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {

    private OnBoardingListener mListener;
    private ImageView closeImage;
    private EditText et_phone_no;
    private EditText et_name;
    private EditText et_email;
    private EditText et_referral;
    private RelativeLayout phoneContainer;
    private RelativeLayout nameContainer;
    private RelativeLayout emailContainer;
    private RelativeLayout referralContainer;
    private ImageView iv_phone;
    private ImageView iv_name;
    private ImageView iv_email;
    private FrameLayout fl_phonecontainer;
    private FrameLayout fl_namecontainer;
    private FrameLayout fl_emailcontainer;
    private ImageView iv_phone_clear;
    private ImageView iv_name_clear;
    private ImageView iv_email_clear;
    private ImageView iv_referral_clear;
    private int MAX_PHONE_NUMBER_LENGTH = 10;

    public SignupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        initViews(view);
        initPhoneNumberView();
        initNameView();
        initEmailView();
        initReferralView();

        closeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mListener != null){
                    mListener.onSignUpClosed();
                }
            }
        });

        return view;
    }

    private void initReferralView() {
        et_referral.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                referralContainer.setSelected(hasFocus);
                et_referral.setSelected(hasFocus);
                if(hasFocus){
                    iv_referral_clear.setVisibility(View.VISIBLE);
                }
            }
        });

        et_referral.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_DONE){
                    KeypadUtils.hideKeyboard(getActivity());
                    et_referral.clearFocus();
                    iv_referral_clear.setVisibility(View.GONE);
                }
                return false;
            }
        });
        iv_referral_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_referral.setText("");
            }
        });
    }

    private void initEmailView() {
        et_email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                emailContainer.setSelected(hasFocus);
                iv_email.setSelected(hasFocus);
                if(hasFocus){
                    iv_email_clear.setVisibility(View.VISIBLE);
                }
            }
        });
        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(android.util.Patterns.EMAIL_ADDRESS.matcher(et_email.getText()).matches()){
                    fl_emailcontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_emailcontainer.setEnabled(true);
                    iv_email_clear.setVisibility(View.VISIBLE);
                } else {
                    fl_emailcontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_emailcontainer.setEnabled(false);
                    iv_email_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et_email.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT){
                    et_email.clearFocus();
                    iv_email_clear.setVisibility(View.GONE);
                    if(et_email.getText() != null && android.util.Patterns.EMAIL_ADDRESS.matcher(et_email.getText()).matches()){
                        fl_emailcontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    } else {

                    }
                }
                return false;
            }
        });
        iv_email_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_email.setText("");
            }
        });
    }

    private void initNameView() {
        et_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                nameContainer.setSelected(hasFocus);
                iv_name.setSelected(hasFocus);
                if(hasFocus){
                    iv_name_clear.setVisibility(View.VISIBLE);
                }
            }
        });
        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().length() == 0){
                    fl_namecontainer.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.transparent));
                    iv_name_clear.setVisibility(View.GONE);
                } else if(charSequence.toString().length() > 0){
                    fl_namecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_namecontainer.setEnabled(true);
                    iv_name_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        et_name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT){
                    //KeypadUtils.hideKeyboard(getActivity());
                    et_name.clearFocus();
                    iv_name_clear.setVisibility(View.GONE);
                    if(et_name.getText() != null && et_name.getText().toString().length() > 0){
                        fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    } else {
                    }
                }
                return false;
            }
        });

        iv_name_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_name.setText("");
            }
        });
    }

    private void initPhoneNumberView() {
        et_phone_no.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                phoneContainer.setSelected(hasFocus);
                iv_phone.setSelected(hasFocus);
                if(hasFocus){
                    iv_phone_clear.setVisibility(View.VISIBLE);
                }
            }
        });
        et_phone_no.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if(charSequence.toString().length() == 0){
                    fl_phonecontainer.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.transparent));
                    iv_phone_clear.setVisibility(View.GONE);
                } else if(charSequence.toString().length() > 0 && charSequence.toString().length() < MAX_PHONE_NUMBER_LENGTH){
                    fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_phonecontainer.setEnabled(false);
                    iv_phone_clear.setVisibility(View.VISIBLE);
                } else if(charSequence.toString().length() == MAX_PHONE_NUMBER_LENGTH){
                    fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    fl_phonecontainer.setEnabled(true);
                    iv_phone_clear.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        et_phone_no.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId== EditorInfo.IME_ACTION_NEXT){
                    //KeypadUtils.hideKeyboard(getActivity());
                    et_phone_no.clearFocus();
                    iv_phone_clear.setVisibility(View.GONE);
                    if(et_phone_no.getText() != null && et_phone_no.getText().toString().length() == MAX_PHONE_NUMBER_LENGTH){
                        fl_phonecontainer.setBackgroundResource(R.drawable.selector_phone_background);
                    } else {
                    }
                }
                return false;
            }
        });
        iv_phone_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                et_phone_no.setText("");
            }
        });
    }

    private void initViews(View view) {
        phoneContainer = (RelativeLayout)view.findViewById(R.id.phone_container);
        nameContainer = (RelativeLayout)view.findViewById(R.id.name_container);
        emailContainer = (RelativeLayout)view.findViewById(R.id.email_container);
        referralContainer = (RelativeLayout)view.findViewById(R.id.referral_container);
        et_phone_no = (EditText)view.findViewById(R.id.phone_no);
        et_name =  (EditText)view.findViewById(R.id.name);
        et_email = (EditText) view.findViewById(R.id.email);
        et_referral = (EditText) view.findViewById(R.id.referral);
        closeImage = (ImageView)view.findViewById(R.id.close_img);
        iv_phone = (ImageView)view.findViewById(R.id.phone_icon);
        iv_name = (ImageView)view.findViewById(R.id.name_icon);
        iv_email = (ImageView)view.findViewById(R.id.email_icon);
        fl_phonecontainer = (FrameLayout)view.findViewById(R.id.phone_icon_container);
        fl_namecontainer = (FrameLayout)view.findViewById(R.id.name_icon_container);
        fl_emailcontainer = (FrameLayout)view.findViewById(R.id.email_icon_container);
        iv_phone_clear = (ImageView)view.findViewById(R.id.phone_clear);
        iv_name_clear = (ImageView) view.findViewById(R.id.name_clear);
        iv_email_clear = (ImageView) view.findViewById(R.id.email_clear);
        iv_referral_clear = (ImageView) view.findViewById(R.id.referral_clear);
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
