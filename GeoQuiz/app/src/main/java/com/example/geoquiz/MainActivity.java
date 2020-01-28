package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView mQuestionText;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private Question[] mQuestionBank = new Question[]{
            new Question(R.string.question_ocean, true),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_america, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_australia, false),
    };
    private int mCurrentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionText = (TextView) findViewById(R.id.question_text);
        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                boolean mAnswerBool = mQuestionBank[mCurrentIndex].isAnswerTrue();
                String mAnswer = Boolean.toString(mAnswerBool);
                if (mAnswerBool == true)
                    Toast.makeText(MainActivity.this, "You are correct, the answer was "+ mAnswer +".", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "You are incorrect, the answer was "+ mAnswer +".", Toast.LENGTH_SHORT).show();

            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                boolean mAnswerBool = mQuestionBank[mCurrentIndex].isAnswerTrue();
                String mAnswer = Boolean.toString(mAnswerBool);
                if (mAnswerBool == false)
                    Toast.makeText(MainActivity.this, "You are correct, the answer was "+ mAnswer +".", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "You are incorrect, the answer was "+ mAnswer +".", Toast.LENGTH_SHORT).show();
            }
        });
        mNextButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View v){
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int question = mQuestionBank[mCurrentIndex].getTextResId();
                mQuestionText.setText(question);
            }
        });
    }
}