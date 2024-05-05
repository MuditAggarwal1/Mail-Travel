package com.example.mailtravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button send;
    TextView email,subject,message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        send= findViewById(R.id.send);
        email= findViewById(R.id.email);
        subject= findViewById(R.id.subject);
        message= findViewById(R.id.message);
       send.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String addresses = email.getText().toString();
               String subjects = subject.getText().toString();
               String body = message.getText().toString();
               Intent intent = new Intent(Intent.ACTION_SENDTO);
               intent.setData(Uri.parse("mailto:")); // only email apps should handle this
               intent.putExtra(Intent.EXTRA_EMAIL, addresses);
               intent.putExtra(Intent.EXTRA_SUBJECT, subjects);
               intent.putExtra(Intent.EXTRA_TEXT, body);
               if (intent.resolveActivity(getPackageManager()) != null) {
                   startActivity(intent);
               }
           }
       });

    }
}