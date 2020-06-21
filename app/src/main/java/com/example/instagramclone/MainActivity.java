package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
  private Button btnSave;
   private EditText edtName,edtPunchSpeed,edtKickSpeed,edtPunchPower,edtKickPower;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       btnSave =findViewById(R.id.btnSave);
       btnSave.setOnClickListener(MainActivity.this);

       edtName=findViewById(R.id.edtName);
       edtPunchSpeed=findViewById(R.id.edtPunchSpeed);
       edtPunchPower=findViewById(R.id.edtPunchPower);
       edtKickSpeed=findViewById(R.id.edtKickSpeed);
        edtKickPower=findViewById(R.id.edtKickPower);
    }

    @Override
    public void onClick(View v) {
        try {
            final ParseObject don = new ParseObject("Don");
            don.put("name", edtName.getText().toString());
            don.put("PunchSpeed", Integer.parseInt(edtPunchSpeed.getText().toString()));
            don.put("punchPower", Integer.parseInt(edtPunchPower.getText().toString()));
            don.put("KickSpeed", Integer.parseInt(edtKickSpeed.getText().toString()));
            don.put("KickPower", Integer.parseInt(edtKickPower.getText().toString()));
            don.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        FancyToast.makeText(MainActivity.this, don.get("name") + " saved to the server", FancyToast.LENGTH_LONG, FancyToast.SUCCESS, true).show();

                        // Toast.makeText(MainActivity.this, don.get("name") + " saved to the server", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }catch (Exception e){
            FancyToast.makeText(MainActivity.this,e.getMessage(),FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
        }
    }
}