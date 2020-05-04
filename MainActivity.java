package sg.edu.np.mad.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import java.util.Random;



public class MainActivity extends AppCompatActivity
{

    private static final String TAG ="Whack-A-Mole!";
    private Button middle;
    private Button right;
    private Button left;
    private String mole;
    private Button target;
    private int score;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = findViewById(R.id.first);
        middle = findViewById(R.id.second);
        right = findViewById(R.id.third);

        left.setOnClickListener(buttonOnClickListener);
        middle.setOnClickListener(buttonOnClickListener);
        right.setOnClickListener(buttonOnClickListener);

        Log.v(TAG, "Loading Complete!");

    }

    @Override
    protected void onStart()
    {
        super.onStart();
        setGame();
        Log.v(TAG, "Starting Game...");
    }

    public void setGame()
    {
        Random r = new Random();
        int rLocation = r.nextInt(3);
        switch (mole)
        {
            case "first":{
                left.setText("*");
                middle.setText("O");
                right.setText("O");
                break;
            }
            case "second":{
                left.setText("O");
                middle.setText("*");
                right.setText("O");
                break;
            }
            default:{
                left.setText("O");
                middle.setText("O");
                right.setText("*");
                break;
            }

        }
    }

    private View.OnClickListener buttonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            TextView textView = (TextView) findViewById(R.id.textView);
            switch (v.getId())
            {
                case R.id.first:
                    {
                    if (left.getText() == "*")
                    {
                        score += 1;
                        Log.d(TAG, "Hit, score added!");
                    }
                    else {
                        score -= 1;
                        Log.d(TAG, "Missed, score deducted!");
                    }
                    Log.d(TAG, "Left button is clicked!");
                    textView.setText("Score is: " + score);
                    setGame();
                    break;
                }
                case R.id.second:
                    {
                    if (middle.getText() == "*")
                    {
                        score += 1;
                        Log.d(TAG, "Hit, score added!");
                    }
                    else {
                        score -= 1;
                        Log.d(TAG, "Missed, score deducted!");
                    }
                    Log.d(TAG, "Middle button is clicked!");
                    textView.setText("Score is: " + score);
                    setGame();
                    break;
                }
                default:
                    {
                    if (right.getText() == "*")
                    {
                        score += 1;
                        Log.d(TAG, "Hit, score added!");
                    }
                    else {
                        score -= 1;
                        Log.d(TAG, "Missed, score deducted!");
                    }
                    Log.d(TAG, "Right button is clicked!");
                    textView.setText("Score is: " + score);
                    setGame();
                    break;
                }
            }
        }
    };
}
