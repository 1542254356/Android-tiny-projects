package we.calculator;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private String displaystr = "";
    private int[] ids = {R.id.b0, R.id.b1, R.id.b2, R.id.b3, R.id.b4,
            R.id.b5, R.id.b6, R.id.b7, R.id.b8, R.id.b9};
    private EditText displayedt = null;
    private Double predouble = 0.0, nowdouble = 0.0;
    private String prefh = null;
    private Button backbtn;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayedt = (EditText) findViewById(R.id.displayedt);
        displayedt.setInputType(InputType.TYPE_NULL);
       /* findViewById(R.id.backbutton).setOnLongClickListener(new Button.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                isplaystr = "";
                displayedt.setText(displaystr);
                predouble = nowdouble = 0.0;
                prefh = null;
                return false;
            }
        });*/

        for (int i = 0; i < 10; i++) {
            findViewById(ids[i]).setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId(), i;
                    for (i = 0; i < 10; i++)
                        if (id == ids[i]) break;
                    if (displaystr.length() > 20)
                        Toast.makeText(MainActivity.this, "数字过长！", Toast.LENGTH_SHORT).show();
                    else {
                        displaystr += i + "";
                        displayedt.setText(displaystr);
                    }

                }
            });
        }


    }

    public void cleanAll(View v) {
        displaystr = "";
        displayedt.setText(displaystr);
        predouble = nowdouble = 0.0;
        prefh = null;

    }

    private String format(double a) {
        if (a % 1.0 == 0)
            return String.valueOf((long) a);
        else
            return String.valueOf(a);
    }

    private void caculate(String fh) {
        if (displayedt.length() > 0) {
            if (prefh == null) {
                predouble = Double.parseDouble(displayedt.getText().toString());
                prefh = fh;
                displaystr = "";
            } else {
                nowdouble = Double.parseDouble(displayedt.getText().toString());
                switch (prefh) {
                    case "+":
                        predouble += nowdouble;
                        break;
                    case "-":
                        predouble -= nowdouble;
                        break;
                    case "*":
                        predouble *= nowdouble;
                        break;
                    case "/":
                        predouble /= nowdouble;
                        break;
                }
                if (fh == null)
                    prefh = null;
                else
                    prefh = fh;

                if (predouble < 1E19d)
                    displayedt.setText(format(predouble));
                else
                    displayedt.setText(predouble.toString());
                displaystr = "";

            }
        }


    }

    public void divide(View v) {
        caculate("/");
    }

    public void multiply(View v) {
        caculate("*");
    }

    public void back(View v) {
        if (displaystr.length() > 0)
            displaystr = displaystr.substring(0, displaystr.length() - 1);
        displayedt.setText(displaystr);
    }

    public void point(View v) {
        if (displaystr.length() > 20)
            Toast.makeText(MainActivity.this, "数字过长！", Toast.LENGTH_SHORT).show();
        else {
            displaystr += ".";
            displayedt.setText(displaystr);
        }

    }

    public void equal(View v) {
        caculate(null);
    }

    public void plus(View v) {
        caculate("+");
    }

    public void minus(View v) {
        caculate("-");
    }




}
