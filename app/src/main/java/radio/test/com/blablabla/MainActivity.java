package radio.test.com.blablabla;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    private TextView textView_Quest;
    private TextView textView_Option1;
    private TextView textView_Option2;
    private RadioButton button1;
    private RadioButton button2;
    private RadioGroup button_group;
    String msg="Android";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(msg, "The onStart() event 0");
    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event 0");
    }

    /** Called when another activity is taking focus. */
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event 0");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(msg, "The onStop() event 0");
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(msg, "The onDestroy() event 0");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(msg, "The onCreate() event 0");
        initializeVariables();
        textView_Quest.setText(R.string.question_text);
        String opt_text_1=this.getString(R.string.option_text_1_1);
        button1.setText("\n"+"\n"+opt_text_1+"\n"+"\n");
        textView_Option1.setText(R.string.temporal_demand);
        String opt_text_2=this.getString(R.string.option_text_2_1);
        button2.setText("\n"+"\n"+opt_text_2+"\n"+"\n");
        textView_Option2.setText(R.string.effort);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //button1.isChecked();
                button1.setChecked(true);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                button2.setChecked(true);
            }
        });

        //System.out.println("You are at question_2_1 "+question_val+", "+inc);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

            button_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Intent myIntent = new Intent(MainActivity.this, MainActivity_2.class);
                    startActivity(myIntent);
                    button1.setChecked(false);
                    button2.setChecked(false);
                    //finish();
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeVariables() {
        textView_Quest = (TextView) findViewById(R.id.question_text);
        textView_Option1 = (TextView) findViewById(R.id.option_1_text);
        textView_Option2 = (TextView) findViewById(R.id.option_2_text);
        button1= (RadioButton)findViewById(R.id.option_1);
        button2= (RadioButton)findViewById(R.id.option_2);
        button_group=(RadioGroup)findViewById(R.id.radioOptionGroup);
    }
}
