package application.example.assignmentquizapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;
    Button btnsubmit, btncheck;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        radioGroup = (RadioGroup) findViewById (R.id.radioGroup);
        btnsubmit = (Button) findViewById (R.id.btnsubmit);
        btncheck = (Button) findViewById (R.id.btncheck);
        openHelper = new DatabaseHelper (this);
        btnsubmit.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                int Selectedid = radioGroup.getCheckedRadioButtonId ();
                radioButton = (RadioButton) findViewById (Selectedid);
                String text = radioButton.getText ().toString ();
                db = openHelper.getWritableDatabase ();
                insertdata (text);
                Toast.makeText (getApplicationContext (), "The answer is submitted successfully and the submitted value is" + radioButton.getText (), Toast.LENGTH_LONG).show ();


            }

        });
    }

    public void insertdata(String value) {
        ContentValues contentValues = new ContentValues ();
        contentValues.put (DatabaseHelper.COL_ANS_2, value);
        long id = db.insert (DatabaseHelper.TABLE_SA, null, contentValues);

    }
}

