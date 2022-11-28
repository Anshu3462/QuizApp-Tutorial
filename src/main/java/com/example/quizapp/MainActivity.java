package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn, option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionTV = findViewById(R.id.idTVQuestion);
        questionNumberTV = findViewById(R.id.idTVQuestionAttempted);
        option1Btn = findViewById(R.id.idBtnOption1);
        option2Btn = findViewById(R.id.idBtnOption2);
        option3Btn = findViewById(R.id.idBtnOption3);
        option4Btn = findViewById(R.id.idBtnOption4);

        quizModalArrayList = new ArrayList<>();
        random = new Random();

        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);

        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option1Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option2Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option3Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quizModalArrayList.get(currentPos).getAnswer().trim().toLowerCase().equals(option4Btn.getText().toString().trim().toLowerCase())) {
                    currentScore++;
                }
                questionAttempted++;
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
            }
        });



    }

    private void showBottomSheet(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet,(LinearLayout)findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button restartQuizBtn = bottomSheetView.findViewById(R.id.idBtnRestart);
        scoreTV.setText("Your Score is \n" + currentScore + "/11");
        restartQuizBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
bottomSheetDialog.setCancelable(false);
bottomSheetDialog.setContentView(bottomSheetView);
bottomSheetDialog.show();
    }


private void setDataToViews(int currentPos){
        questionNumberTV.setText("Question Attempted :" +questionAttempted + "/11");
if (questionAttempted == 10){
    showBottomSheet();

} else {
    questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
    option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
    option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
    option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
    option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
}



}
    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList)  {
        quizModalArrayList.add(new QuizModal( "What is the date of viva?",  " 25" , " 56" , "28" , "52" , "28"));
        quizModalArrayList.add(new QuizModal( "How GFG is used ?" , "To solve DSA problems" , "To learn new languages" , "To learn Android Development" , "All of the Above" , "All of the Above"));
        quizModalArrayList.add(new QuizModal( "Who is the vice chancellor of DSEU ?" , "Dr. Amita Dev" , "Mr. Deepak Dahiya" , "Elon Musk" , "A. R. Rahman" , "Dr. Amita Dev"));
        quizModalArrayList.add(new QuizModal( "Total bits used by the IPv6 address is ?" , "64 bit" , "256 bit" , "128 bit" , "32 bit" , "128 bit"));
        quizModalArrayList.add(new QuizModal( "The full form of DOM is ?" , "Fast Internet for Fast Trains Hosts" , "Delhi Skill and Entrepreneurship University" , "Indian Institutes of Technology" , "None" , "None"));
        quizModalArrayList.add(new QuizModal( "Who is the Mr Shivam Gupta sir ?" , "Proctor of ITESM" , "Student Chapter Incharge" , "Ass. Prof." , "All of the above" , "All of the above"));
        quizModalArrayList.add(new QuizModal( "How many students in ITESM" , "10" , "01" , "72" , "525" , "72"));
        quizModalArrayList.add(new QuizModal( "What is part of a database that holds only one type of information?" , "Report" , "Field" , "File" , "Record" , "Field"));
        quizModalArrayList.add(new QuizModal( "'.MOV' extension refers usually to what kind of file?",  "Image File" , "Movie File" , "Audio file" , "MS Office document" , "Movie File"));
        quizModalArrayList.add(new QuizModal( "'OS' computer abbreviation usually means ??" , "Order of Significance" , "Open Software" , "Operating System" , "Optical Sensor" , "Operating System"));
        quizModalArrayList.add(new QuizModal( "#include <stdio.h>\n" +
                "int main()\n" +
                "{\n" +
                "    int i = 5, j = 10, k = 15;\n" +
                "    printf(\"%d \", sizeof(k /= i + j));\n" +
                "    printf(\"%d\", k);\n" +
                "    return 0;\n" +
                "}?" , "4 1" , "4 15" , "2 1" , "Compile-time error" , "2 1"));



    }
}