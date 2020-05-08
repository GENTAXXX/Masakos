//package com.example.masakos;
//
//import android.os.Bundle;
//import android.widget.Toast;
//
//import com.google.android.material.snackbar.Snackbar;
//import androidx.appcompat.app.AppCompatActivity;
//import com.bumptech.glide.Glide;
//import com.example.masakos.classes.Explore;
//import com.example.masakos.fragment.DiscoverFragment;
//import com.google.android.youtube.player.YouTubeBaseActivity;
//import com.google.android.youtube.player.YouTubeInitializationResult;
//import com.google.android.youtube.player.YouTubePlayer;
//import com.google.android.youtube.player.YouTubePlayerView;
//
//import java.security.cert.LDAPCertStoreParameters;
//
//public class DetailExplore extends YouTubeBaseActivity {
//    private final String API_KEY = "AIzaSyC7iOPOpQDglF9asAoNnM7jqaU48K58ZGY";
//    private final String VIDEO_CODE = "XfP31eWXli4";
//    YouTubePlayerView player;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_detail_explore);
//
//        player = (YouTubePlayerView) findViewById(R.id.player);
//        player.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
//            @Override
//            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
//                if (!b) {
//                    youTubePlayer.loadVideo(VIDEO_CODE);
//                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
//                }
//            }
//
//            @Override
//                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
//                        Toast.makeText(DetailExplore.this, youTubeInitializationResult.toString(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//            }
//        }
//
