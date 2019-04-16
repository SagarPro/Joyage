package sagsaguz.joyage;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText phoneNumber;
    TextView countryCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cvCountry = findViewById(R.id.cvCountry);
        cvCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Not implemented yet.", Toast.LENGTH_SHORT).show();
            }
        });

        countryCode = findViewById(R.id.countryCode);
        phoneNumber = findViewById(R.id.phoneNumber);
        
        CardView cvPrevious = findViewById(R.id.cvPrevious);
        cvPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Main page", Toast.LENGTH_SHORT).show();
            }
        });

        CardView cvNext = findViewById(R.id.cvNext);
        cvNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(phoneNumber.getText().toString().trim()))
                    Toast.makeText(MainActivity.this, "Enter your phone number", Toast.LENGTH_SHORT).show();
                else
                    showConfirmationDialog();
            }
        });

    }

    private void showConfirmationDialog(){
        final Dialog confirmationDialog = new Dialog(MainActivity.this);
        confirmationDialog.setContentView(R.layout.dialog_phone_confirmation);
        confirmationDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        confirmationDialog.setCancelable(false);

        final String phNo = countryCode.getText().toString().trim()+" "+phoneNumber.getText().toString().trim();

        TextView phNumber = confirmationDialog.findViewById(R.id.phNumber);
        phNumber.setText(phNo);

        TextView edit = confirmationDialog.findViewById(R.id.edit);
        TextView yes = confirmationDialog.findViewById(R.id.yes);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationDialog.cancel();
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmationDialog.dismiss();
                Intent nextIntent = new Intent(MainActivity.this, PhoneCodeActivity.class);
                nextIntent.putExtra("PhNumber", phNo);
                startActivity(nextIntent);
                overridePendingTransition(R.anim.slide_in_up, R.anim.fade_in);
            }
        });

        confirmationDialog.show();

    }

}
