package sagsaguz.joyage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class PhoneCodeActivity extends AppCompatActivity implements View.OnClickListener{

    TextView pass1, pass2, pass3, pass4, pass5, pass6;
    TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv0, tvX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phone_code_layout);

        TextView tvConfirmMessage = findViewById(R.id.tvConfirmMessage);
        String message = tvConfirmMessage.getText().toString() + getIntent().getStringExtra("PhNumber");
        tvConfirmMessage.setText(message);

        CardView cvPrevious = findViewById(R.id.cvPrevious);
        cvPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        CardView cvNext = findViewById(R.id.cvNext);
        cvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PhoneCodeActivity.this, "Next Activity", Toast.LENGTH_SHORT).show();
            }
        });

        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);
        pass3 = findViewById(R.id.pass3);
        pass4 = findViewById(R.id.pass4);
        pass5 = findViewById(R.id.pass5);
        pass6 = findViewById(R.id.pass6);

        tv1 = findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
        tv2 = findViewById(R.id.tv2);
        tv2.setOnClickListener(this);
        tv3 = findViewById(R.id.tv3);
        tv3.setOnClickListener(this);
        tv4 = findViewById(R.id.tv4);
        tv4.setOnClickListener(this);
        tv5 = findViewById(R.id.tv5);
        tv5.setOnClickListener(this);
        tv6 = findViewById(R.id.tv6);
        tv6.setOnClickListener(this);
        tv7 = findViewById(R.id.tv7);
        tv7.setOnClickListener(this);
        tv8 = findViewById(R.id.tv8);
        tv8.setOnClickListener(this);
        tv9 = findViewById(R.id.tv9);
        tv9.setOnClickListener(this);
        tv0 = findViewById(R.id.tv0);
        tv0.setOnClickListener(this);
        tvX = findViewById(R.id.tvX);
        tvX.setOnClickListener(this);

    }

    private void enterValue(String value){

        if (value.equals("X")){
            if (!TextUtils.isEmpty(pass6.getText().toString())){
                pass6.setText("");
            } else if (!TextUtils.isEmpty(pass5.getText().toString())){
                pass5.setText("");
            } else if (!TextUtils.isEmpty(pass4.getText().toString())){
                pass4.setText("");
            } else if (!TextUtils.isEmpty(pass3.getText().toString())){
                pass3.setText("");
            } else if (!TextUtils.isEmpty(pass2.getText().toString())){
                pass2.setText("");
            } else {
                pass1.setText("");
            }
        } else {
            if (TextUtils.isEmpty(pass1.getText().toString())){
                pass1.setText(value);
            } else if (TextUtils.isEmpty(pass2.getText().toString())){
                pass2.setText(value);
            } else if (TextUtils.isEmpty(pass3.getText().toString())){
                pass3.setText(value);
            } else if (TextUtils.isEmpty(pass4.getText().toString())){
                pass4.setText(value);
            } else if (TextUtils.isEmpty(pass5.getText().toString())){
                pass5.setText(value);
            } else {
                pass6.setText(value);
                validate();
            }
        }
    }

    private void validate(){
        if (pass1.getText().toString().equals("1")
                && pass2.getText().toString().equals("2")
                && pass3.getText().toString().equals("3")
                && pass4.getText().toString().equals("4")
                && pass5.getText().toString().equals("5")
                && pass6.getText().toString().equals("6")){
            Toast.makeText(this, "Working", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Wrong Passcode", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv1: enterValue("1");break;
            case R.id.tv2: enterValue("2");break;
            case R.id.tv3: enterValue("3");break;
            case R.id.tv4: enterValue("4");break;
            case R.id.tv5: enterValue("5");break;
            case R.id.tv6: enterValue("6");break;
            case R.id.tv7: enterValue("7");break;
            case R.id.tv8: enterValue("8");break;
            case R.id.tv9: enterValue("9");break;
            case R.id.tv0: enterValue("0");break;
            case R.id.tvX: enterValue("X");break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.fade_out, R.anim.slide_out_down);
    }

}
