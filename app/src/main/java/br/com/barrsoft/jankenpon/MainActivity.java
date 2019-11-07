package br.com.barrsoft.jankenpon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    
    public static final String TAG = MainActivity.class.getName();
    @BindView(R.id.imageViewApp)
    ImageView imageViewApp;
    @BindView(R.id.imageViewPaper)
    ImageView imageViewPaper;
    @BindView(R.id.imageViewRock)
    ImageView imageViewRock;
    @BindView(R.id.imageViewScissor)
    ImageView imageViewScissor;
    int chooseUser = 0;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        
    }
    @OnClick(R.id.imageViewPaper)
    public void submitPaper (View view){
        funGame(1);
        Log.i(TAG, "submitPaper: ");
    }
    
    @OnClick(R.id.imageViewRock)
    public void submitRock(View view){
        funGame(2);
        Log.i(TAG, "submitRock: ");
    }
    
    @OnClick(R.id.imageViewScissor)
    public void submitScissor (View view){
        funGame(3);
        Log.i(TAG, "submitScissor: ");
    }

    private void funGame(int chooseUser) {
        int max = 3;
        int min = 1;
        int random = (int) (Math.random() * (max - min + 1) + min);
        winner(chooseUser, random);
        setImage(random);
    }

    private void setImage(int random) {
        switch (random){
            case 1:
                imageViewApp.setImageResource(R.drawable.papel);
                break;
            case 2:
                imageViewApp.setImageResource(R.drawable.pedra);
                break;
            case 3:
                imageViewApp.setImageResource(R.drawable.tesoura);
                break;
        }
    }

    private void winner(int chooseUser, int random) {
        if (chooseUser == 1 && random == 1){
            Toast.makeText(getApplicationContext(), R.string.msg_empate,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 1 && random == 2){
            Toast.makeText(getApplicationContext(), R.string.msg_vitoria,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 1 && random == 3){
            Toast.makeText(getApplicationContext(), R.string.msg_derrota,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 2 && random == 1){
            Toast.makeText(getApplicationContext(), R.string.msg_derrota,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 2 && random == 2){
            Toast.makeText(getApplicationContext(), R.string.msg_empate,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 2 && random == 3){
            Toast.makeText(getApplicationContext(), R.string.msg_vitoria,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 3 && random == 1){
            Toast.makeText(getApplicationContext(), R.string.msg_vitoria,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 3 && random == 2){
            Toast.makeText(getApplicationContext(), R.string.msg_derrota,Toast.LENGTH_SHORT).show();
        }
        if (chooseUser == 3 && random == 3){
            Toast.makeText(getApplicationContext(), R.string.msg_empate,Toast.LENGTH_SHORT).show();
        }
    }

}
