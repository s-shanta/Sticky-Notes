package com.example.nipuxo.stickynotes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addnotespage extends AppCompatActivity {

    EditText addTitle, addnotes;
    Button doneBTN;
    public static String titleName;
    public  static String note;
    DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotespage);

        db = new DataBaseHelper(this);

        doneBTN = (Button)findViewById(R.id.doneBTN);
        addTitle = (EditText)findViewById(R.id.titleET);
        addnotes=(EditText)findViewById(R.id.noteET);


        doneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                titleName = addTitle.getText().toString();
                note = addnotes.getText().toString();

                if(titleName.isEmpty() || note.isEmpty())
                {
                    displayToast("Fill all field");
                }
                else{
                    db.addNote(titleName,note);
                    displayToast("Note Added");
                    startActivity(new Intent(addnotespage.this,welcome_page.class));
                }
            }
        });

    }
    private void displayToast(String msg)
    {
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();
    }
}


