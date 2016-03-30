package com.example.marty.lab09_application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    private static final int SELECT_COLOR_REQUEST = 0;
    private static final int SELECT_NEXT_REQUEST = 1;
    private static final int SELECT_INPUT_REQUEST = 2;

    private int m_color = 0XFFFFFFFF;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectColor(View view){
        Intent intent = new Intent(this, ColorPickerActivity.class);
        // startActivity(intent);
        startActivityForResult(intent, SELECT_COLOR_REQUEST);
    }

    public void selectInput(View view){
        Intent intent = new Intent(this, EditTextActivity.class);
        // startActivity(intent);
        startActivityForResult(intent, SELECT_INPUT_REQUEST);
    }

    public void selectNext(View view){
        Intent intent = new Intent(this,Activity_1.class);
         startActivity(intent);
       // startActivityForResult(intent, SELECT_NEXT_REQUEST);

      //  intent.putExtra(ColorPickerActivity.BUNDLE_KEY_COLOR_INT,m_color);
     //  startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);

        if(requestCode == SELECT_COLOR_REQUEST){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                m_color = bundle.getInt(ColorPickerActivity.BUNDLE_KEY_COLOR_INT);
                CharSequence colorName = bundle.getCharSequence(ColorPickerActivity.BUNDLE_KEY_COLOR_NAME);

                TextView tv_color = (TextView)findViewById(R.id.tv_color);
                tv_color.setGravity(Gravity.CENTER);
                tv_color.setText(colorName);

                ScrollView scrollView = (ScrollView)findViewById(R.id.scroll_view);
                scrollView.setBackgroundColor(m_color);
            }

        }


        if(requestCode == SELECT_INPUT_REQUEST){
            if(resultCode == RESULT_OK){
                Bundle bundle = data.getExtras();
                CharSequence editText = bundle.getCharSequence(EditTextActivity.BUNDLE_KEY_EditText);

                TextView tv_color = (TextView)findViewById(R.id.tv_color);
                tv_color.setGravity(Gravity.LEFT);
                tv_color.setText(editText);

            }

        }

    }
}
