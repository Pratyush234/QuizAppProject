package com.example.praty.quizappproject;

public class TrueFalse{
    private int QuestionID;
    private boolean answer;

    public TrueFalse(int questionID, boolean b) {
        QuestionID=questionID;
        answer=b;
    }



    public int getQuestionID() {
        return QuestionID;
    }

    public void setQuestionID(int questionID) {
        QuestionID = questionID;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
