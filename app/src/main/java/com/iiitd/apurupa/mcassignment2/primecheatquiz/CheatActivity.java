package com.iiitd.apurupa.mcassignment2.primecheatquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CheatActivity extends AppCompatActivity implements  View.OnClickListener{


    private TextView mcheatTextView;
    private int flag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.cheat_activity_layout);
        init();

    }
//Initializing the variables
    private void init() {
        Button mShowCheatButton = (Button) findViewById(R.id.ShowCheatButton);
        Button mBackButton = (Button) findViewById(R.id.CheatBackButton);
        mcheatTextView=(TextView)findViewById(R.id.cheatTextView);
        mShowCheatButton.setOnClickListener(this);
        mBackButton.setOnClickListener(this);
    }

    private String getAnswer(int number)
    {
        for(int i=2;i<=number/2;i++) if(number%i==0) return "No, "+number+" is not a Prime";
        return "Yes, "+number+" is a Prime";
    }

    @Override
    public void onClick(View view) {
        int res;
        Intent intent = getIntent();

        switch(view.getId())
        {
            case R.id.ShowCheatButton:
                 res= intent.getIntExtra("Question",0);
                 mcheatTextView.setText(getAnswer(res));
                 flag=1;
                 break;
            case R.id.CheatBackButton:
                if(flag==0)intent.putExtra("About Cheat","Answer Not Taken");
                else intent.putExtra("About Cheat","Answer Taken");
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }
}
