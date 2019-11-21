package br.com.barrsoft.jankenpon;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
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
    private MediaPlayer player = new MediaPlayer();
    private MediaPlayer player1 = new MediaPlayer();

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    private void playerMusica(int firstMusic, int secondMusic) {

        player.release();
        player1.release();
        if(player != null){
            player = MediaPlayer.create(this, firstMusic);
            player1 = MediaPlayer.create(this,secondMusic);
            player.setNextMediaPlayer(player1);
            player.start();
        }
    }

    @OnClick(R.id.imageViewPaper)
    public void submitPaper (View view){
        funGame(1);
        imageViewPaper.setImageResource(R.drawable.papel_select);
        Log.i(TAG, "submitPaper: ");
    }
    
    @OnClick(R.id.imageViewRock)
    public void submitRock(View view){
        funGame(2);
        imageViewRock.setImageResource(R.drawable.pedra_select);
        Log.i(TAG, "submitRock: ");
    }
    
    @OnClick(R.id.imageViewScissor)
    public void submitScissor (View view){
        funGame(3);
        imageViewScissor.setImageResource(R.drawable.tesoura_select);
        Log.i(TAG, "submitScissor: ");
    }

    @OnClick(R.id.imageViewApp)
    public void easterEgg(View view){
        playerMusica(R.raw.teobaldo_dpa, R.raw.teobaldo_dpa);
    }

    private void funGame(int chooseUser) {
        int max = 3;
        int min = 1;
        int random = (int) (Math.random() * (max - min + 1) + min);
        setImage(random);
        winner(chooseUser, random);

    }

    private void setImage(int random) {
        switch (random){
            case 1:
                imageViewApp.setImageResource(R.drawable.papel);
                resetImage();
                break;
            case 2:
                imageViewApp.setImageResource(R.drawable.pedra);
                resetImage();
                break;
            case 3:
                imageViewApp.setImageResource(R.drawable.tesoura);
                resetImage();
                break;
        }
    }

    private void winner(int chooseUser, int random) {

        if (chooseUser == 1 && random == 1){
            playerVictory(getString(R.string.msg_empate), R.raw.jankenpon ,R.raw.jankenpon);
        }
        if (chooseUser == 1 && random == 2){
            playerVictory(getString(R.string.msg_win), R.raw.jankenpon ,R.raw.youwin);
        }
        if (chooseUser == 1 && random == 3){
            playerVictory(getString(R.string.msg_lose), R.raw.jankenpon ,R.raw.youlose);
        }
        if (chooseUser == 2 && random == 1){
            playerVictory(getString(R.string.msg_lose), R.raw.jankenpon ,R.raw.youlose);
        }
        if (chooseUser == 2 && random == 2){
            playerVictory(getString(R.string.msg_empate), R.raw.jankenpon ,R.raw.jankenpon);
        }
        if (chooseUser == 2 && random == 3){
            playerVictory(getString(R.string.msg_win), R.raw.jankenpon ,R.raw.youwin);
        }
        if (chooseUser == 3 && random == 1){
            playerVictory(getString(R.string.msg_win), R.raw.jankenpon ,R.raw.youwin);
        }
        if (chooseUser == 3 && random == 2){
            playerVictory(getString(R.string.msg_lose),R.raw.jankenpon ,R.raw.youlose);
        }
        if (chooseUser == 3 && random == 3){
            playerVictory(getString(R.string.msg_empate), R.raw.jankenpon ,R.raw.jankenpon);
        }
    }

    private void playerVictory(String message, int firstMusic, int secondMusic) {
            playerMusica(firstMusic,secondMusic);
            Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
    }

    private void resetImage() {

        imageViewScissor.setImageResource(R.drawable.tesoura);
        imageViewRock.setImageResource(R.drawable.pedra);
        imageViewPaper.setImageResource(R.drawable.papel);
    }

}
