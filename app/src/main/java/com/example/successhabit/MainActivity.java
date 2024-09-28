package com.example.successhabit;

import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String [] questions   = {"Do you set aside time for daily reflection and goal review?",
            " Do you maintain a consistent and healthy sleep routine?",
            "    Do you practice effective delegation to maximize productivity?",
            "    Do you actively seek out opportunities for skill diversification?",
            "Do you engage in regular reading to expand your knowledge base?",
            "Do you cultivate a habit of gratitude and positivity?",
            " Do you prioritize self-care and mental well-being?",
            " Do you embrace failure as a learning opportunity and persevere?",
            "Do you allocate time for creative thinking and ideation?",
            "Do you consistently give back through acts of kindness or philanthropy?"};
    private boolean[] ans = {true,true,true,true,true,true,true,true,true,true };
    private int score=0;
    private int index = 0;


    Button yes;
    Button no;
    TextView textView2;
    Button restart;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        yes = findViewById(R.id.yes);
        no = findViewById(R.id.no);
        textView2 = findViewById(R.id.textView2);

        textView2.setText(questions[0]);


        restart = findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restartGame();
            }

            private void restartGame() {
                score = 0;
                index = 0;
                textView2.setText(questions[0]);
                yes.setEnabled(true);
                no.setEnabled(true);
                restart.setVisibility(View.GONE);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View view) {
if (index <=questions.length-1)
         {
             if(ans[index]  ){
                 score = score+1;
             }index++;
             if (index<=questions.length-1){
                 textView2.setText(questions[index]);
             }
             else
                 Toast.makeText(MainActivity.this, "your score is " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();

         }
else {
    yes.setEnabled(false);
    no.setEnabled(false);
    restart.setVisibility(View.VISIBLE);
}
     }
 });


no.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (index <=questions.length-1)
        {
            if(!ans[index]  ){
                score = score+1;
            }index++;
            if (index<=questions.length-1){
                textView2.setText(questions[index]);
            }
            else
                Toast.makeText(MainActivity.this, "your score is " + score + "/" + questions.length, Toast.LENGTH_SHORT).show();

        }
        else {
            yes.setEnabled(false);
            no.setEnabled(false);
            restart.setVisibility(View.VISIBLE);
        }
    }
});
    }
   public  void contact(View view ) {
        String linkedInProfileUrl = "https://www.linkedin.com/in/rahul-das-2752b1248/"; // Replace with the actual profile URL

        // Create an intent with the action ACTION_VIEW
        Intent intent = new Intent(Intent.ACTION_VIEW);

        // Set the data (URL) for the intent
        intent.setData(Uri.parse(linkedInProfileUrl));

        // Check if there's a LinkedIn app installed, if not, use a web browser
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            // If no LinkedIn app, open the link in a web browser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(linkedInProfileUrl));
            startActivity(browserIntent);
        }
    }
}