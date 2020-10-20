package cat.itb.diceroller;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity {

    ImageView resultImageView1;
    ImageView resultImageView2;
    Button rollButton;
    Button intialButton;
    public int max = 5, min = 0, result1, result2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultImageView1 = findViewById(R.id.result_Imatgeview1);
        resultImageView2 = findViewById(R.id.result_Imatgeview2);
        rollButton = findViewById(R.id.roll_button);
        intialButton = findViewById(R.id.initial_button);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeText(MainActivity.this, "clic", Toast.LENGTH_SHORT).show();
                rollButton.setText(R.string.roll_button_text2);

                result1 = (int)Math.floor((Math.random()*((max-min)+1)+min));
                result2 = (int)Math.floor((Math.random()*((max-min)+1)+min));

                diceRolled(resultImageView1, result1);
                diceRolled(resultImageView2, result2);

                if (result1 == 5 && result2 == 5){
                    Toast jackpot = makeText(MainActivity.this, "JACKPOT!", Toast.LENGTH_SHORT);
                    jackpot.setGravity(Gravity.TOP|Gravity.CENTER,0,0);
                    jackpot.show();
                }

            }
        });

        intialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultImageView1.setImageResource(R.drawable.empty_dice);
                resultImageView2.setImageResource(R.drawable.empty_dice);
            }
        });

        resultImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result1 = (int)Math.floor((Math.random()*((max-min)+1)+min));
                diceRolled(resultImageView1, result1);
                if(result1 == 5 && result2 == 5) makeText(MainActivity.this, "JACKPOT!", Toast.LENGTH_SHORT).show();
            }
        });

        resultImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result2 = (int)Math.floor((Math.random()*((max-min)+1)+min));
                diceRolled(resultImageView2, result2);
                if(result1 == 5 && result2 == 5) makeText(MainActivity.this, "JACKPOT!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void diceRolled(ImageView dice, int num){
        int [] diceRollers = {R.drawable.dice_1, R.drawable.dice_2, R.drawable.dice_3,R.drawable.dice_4, R.drawable.dice_5, R.drawable.dice_6};
        dice.setImageResource(diceRollers[num]);
    }
}