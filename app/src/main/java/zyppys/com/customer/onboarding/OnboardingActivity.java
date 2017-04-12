package zyppys.com.customer.onboarding;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import zyppys.com.customer.R;

public class OnboardingActivity extends AppCompatActivity implements OnBoardingListener {


    public static String EXTRA_SHOW_ANIM = "ShowAnim";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);
        SignInFragment signInFragment = new SignInFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(EXTRA_SHOW_ANIM,true);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        signInFragment.setArguments(bundle);
        transaction.replace(R.id.fragment_container, signInFragment,OnboardingActivity.class.getSimpleName());
        transaction.commit();
    }


    @Override
    public void onSignupSelected() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.fragment_slide_left_enter,
                        R.anim.fragment_slide_left_exit,
                        R.anim.fragment_slide_right_enter,
                        R.anim.fragment_slide_right_exit)
                .replace(R.id.fragment_container, new SignupFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSignInSelected() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations( R.anim.slide_out_down, R.anim.slide_out_up,R.anim.slide_in_up, R.anim.slide_in_down)
                .replace(R.id.fragment_container, new OTPFragment())
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void onSignUpClosed() {
        getSupportFragmentManager().popBackStack();
    }

    @Override
    public void onSignInClosed() {
        getSupportFragmentManager().popBackStack();
    }
}
