package com.example.geoquiz;

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public int getTextResId(){
        return mTextResId;
    }
    public void setTextResId(int mTextResId){
        this.mTextResId = mTextResId;
    }
    public boolean isAnswerTrue(){
        return mAnswerTrue;
    }
    public void setAnswerTrue(boolean mAnswerTrue){
        this.mAnswerTrue = mAnswerTrue;
    }
    public Question(int textResId, boolean answerTrue){
        mTextResId = textResId;
        mAnswerTrue = answerTrue;
    }
}
