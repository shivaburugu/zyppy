package zyppys.com.customer.onboarding;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import zyppys.com.customer.R;

public class OnboardingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SignInFragment signInFragment = new SignInFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, signInFragment,OnboardingActivity.class.getSimpleName());
        transaction.commit();
    }


}
