package com.example.praty.quizappproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final int progressIncrement=10;
    private Button mtrueButton;
    private Button mFalseButton;
    private int mIndex;
    private int mQuestion;
    private int mScore;
    private TextView questionView;
    private TextView scoreView;
    ProgressBar mProgressBar;


    TrueFalse obj;




    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question1, true),
            new TrueFalse(R.string.question2, false),
            new TrueFalse(R.string.question3, false),
            new TrueFalse(R.string.question4, false),
            new TrueFalse(R.string.question5, true),
            new TrueFalse(R.string.question6, true),
            new TrueFalse(R.string.question7, false),
            new TrueFalse(R.string.question8, false),
            new TrueFalse(R.string.question9, true),
            new TrueFalse(R.string.question10, false)

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtrueButton = (Button) findViewById(R.id.trueButton);
        mFalseButton= (Button) findViewById(R.id.falseButton);
        questionView = (TextView) findViewById(R.id.textView);
        scoreView=(TextView) findViewById(R.id.textView2);
        mProgressBar=(ProgressBar)findViewById(R.id.progressBar2);

        TrueFalse firstQuestion = mQuestionBank[mIndex];
        mQuestion = firstQuestion.getQuestionID();
        questionView.setText(mQuestion);

       mtrueButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
              boolean answer= checkAnswer();

               if(answer == true)
               {
                   Toast.makeText(getApplicationContext(),"You got it correct",Toast.LENGTH_SHORT).show();
                   scoreView.setText("Score "+(++mScore)+"/10");
               }
               else {

                   Toast.makeText(getApplicationContext(),"You're wrong",Toast.LENGTH_SHORT).show();
               }
               update();


           }
       });

       mFalseButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               if(mIndex==mQuestionBank.length){


               }
               boolean answer=checkAnswer();
                 if(answer==false) {
                   Toast.makeText(getApplicationContext(),"You got it correct",Toast.LENGTH_SHORT).show();
                     scoreView.setText("Score "+(++mScore)+"/10");
               }
               else {

                     Toast.makeText(getApplicationContext(),"You're wrong",Toast.LENGTH_SHORT).show();

                 }
               update();
           }
       });
    }

    public void update(){


        if(mIndex<9) {
            mIndex = (mIndex + 1);

        }
        else {
            AlertDialog.Builder alert= new AlertDialog.Builder(this);
            alert.setCancelable(false);
            alert.setTitle("Game Over!!");
            alert.setMessage("Congratulations, you scored: "+mScore+" points");
            alert.setPositiveButton("Close application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            alert.show();

            //mIndex=0;
            //mScore=0;
        }

        obj= mQuestionBank[mIndex];
        mQuestion=obj.getQuestionID();
        questionView.setText(mQuestion);
        mProgressBar.incrementProgressBy(progressIncrement);
    }

    public boolean checkAnswer(){
        boolean answer;
        obj = mQuestionBank[mIndex];
        answer = obj.isAnswer();
        return answer;

    }
}
