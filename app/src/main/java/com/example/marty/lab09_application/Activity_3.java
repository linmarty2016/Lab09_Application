package com.example.marty.lab09_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

public class Activity_3 extends AppCompatActivity {

    public static final String Q3_ANSWER_KEY = "Q3";

    private TextView m_tv_no;
    private TextView m_tv_question;
    private RadioButton m_radio_a;
    private RadioButton m_radio_b;
    private RadioButton m_radio_c;
    private CharSequence m_answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_3);
        init();
    }

    private void init()
    {
        m_tv_no = (TextView)findViewById(R.id.tv_no);
        m_tv_question = (TextView)findViewById(R.id.tv_question);
        m_radio_a = (RadioButton)findViewById(R.id.radio_a);
        m_radio_b = (RadioButton)findViewById(R.id.radio_b);
        m_radio_c = (RadioButton)findViewById(R.id.radio_c);

        m_tv_no.setText("3");
        m_tv_question.setText(Html.fromHtml(getString(R.string.question_3)));
        m_radio_a.setText(Html.fromHtml(getString(R.string.question_3_radio_a)));
        m_radio_b.setText(Html.fromHtml(getString(R.string.question_3_radio_b)));
        m_radio_c.setText(Html.fromHtml(getString(R.string.question_3_radio_c)));
    }

    public void main(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        // startActivityForResult(intent, SELECT_NEXT_REQUEST);

        //  intent.putExtra(ColorPickerActivity.BUNDLE_KEY_COLOR_INT,m_color);
        //  startActivity(intent);
    }

    public void back(View view){
        finish();
        overridePendingTransition(R.anim.push_left_in, R.anim.push_right_out);
    }
}
