package com.iiitd.apurupa.mcassignment2.primecheatquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

public class HintActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView mHintView;
    private final static String HINT="A prime number does not have any factors other than one and itself";
      private int flag=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hint_activity_layout);
        init();

    }
    //Initializing the variables
    private void init() {
        Button mShowHintButton = (Button) findViewById(R.id.ShowHintButton);
        Button mBackButton = (Button) findViewById(R.id.HintBackButton);
        mHintView=(TextView)findViewById(R.id.HinttextView);
        mShowHintButton.setOnClickListener( this);
        mBackButton.setOnClickListener( this);
    }

    @Override
    public void onClick(View view) {

        Intent intent = getIntent();
        switch(view.getId())
        {
            case R.id.ShowHintButton:
                mHintView.setText(HINT);
                //Toast.makeText(this,HINT,duration).show();
                flag=1;
                break;
            case R.id.HintBackButton:
                if(flag==0)intent.putExtra("About Hint","Hint Not Taken");
                else intent.putExtra("About Hint","Hint Taken");
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }

}
