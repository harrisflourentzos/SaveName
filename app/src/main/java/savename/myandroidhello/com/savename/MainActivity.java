package savename.myandroidhello.com.savename;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private TextView showName;
    private EditText enterName;
    private static final String PREFS_NAME = "MyPrefsFile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showName = (TextView) findViewById(R.id.textViewShowNameId);
        enterName = (EditText) findViewById(R.id.editTextId);

        saveButton = (Button) findViewById(R.id.buttonId);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences myPrefs= getSharedPreferences(PREFS_NAME, 0);
                SharedPreferences.Editor editor = myPrefs.edit();

                if(enterName.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Please Insert a Name !!",Toast.LENGTH_LONG).show();
                }else{
                    editor.putString("name", enterName.getText().toString());
                    editor.commit();
                }

            }
        });

        //get date back:
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, 0);

        if(prefs.contains("name")){
            String userName = prefs.getString("name", "not found");
            showName.setText("You are " + userName);
        }else{
            showName.setText("");
        }

    }
}
