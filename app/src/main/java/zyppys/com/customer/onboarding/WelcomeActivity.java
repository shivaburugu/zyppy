package zyppys.com.customer.onboarding;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import zyppys.com.customer.R;
import zyppys.com.customer.landing.LandingActivity;


public class WelcomeActivity extends AppCompatActivity {

    private Button enable_locaiton;
    private TextView skip;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        enable_locaiton = (Button) findViewById(R.id.enable_location);
        skip = (TextView) findViewById(R.id.skip);
        enable_locaiton.setOnClickListener(navigateToLandingPage);
        skip.setOnClickListener(navigateToLandingPage);
    }

    private View.OnClickListener navigateToLandingPage = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(WelcomeActivity.this,LandingActivity.class);
            startActivity(intent);
        }
    };
}
