package com.example.nipuxo.stickynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class welcome_page extends AppCompatActivity {
    Button addBtn, viewBtn;
    TextView addText, viewText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_page);

        addBtn = (Button)findViewById(R.id.addBTN);
        viewBtn = (Button)findViewById(R.id.viewBTN);

        addText = (TextView)findViewById(R.id.addtext);
        viewText = (TextView)findViewById(R.id.viewText);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_page.this,addnotespage.class));
            }
        });
        addText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_page.this,addnotespage.class));
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_page.this,viewnotespage.class));
            }
        });
        viewText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(welcome_page.this,viewnotespage.class));
            }
        });
    }
}
