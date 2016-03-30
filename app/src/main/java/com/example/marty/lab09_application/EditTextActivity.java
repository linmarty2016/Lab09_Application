package com.example.marty.lab09_application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditTextActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY_EditText = "com.example.marty.editText";
    private CharSequence mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
    }

    public void cancel(View view){
        setResult(RESULT_CANCELED);
        finish();
    }

    public void ok(View view){
        Intent intent = new Intent();
        EditText editText = (EditText)findViewById(R.id.edit_text);
        mEditText = editText.getText();
        intent.putExtra(BUNDLE_KEY_EditText,mEditText);
        setResult(RESULT_OK, intent);
        finish();
    }
}

