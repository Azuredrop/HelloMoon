package azuredrop.hellomoon;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Administrator on 2017/3/15.
 */
public class HelloMoonFragment extends android.support.v4.app.Fragment {
    private AudioPlayer mPlayer = new AudioPlayer();
    private Button mPlayBtn;
    private Button mPauseBtn;
    private Button mStopBtn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_hello_moon, parent, false);

        mPlayBtn = (Button)v.findViewById(R.id.hellomoon_playBtn);
        mPlayBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.play(getActivity());
            }
        });

        mPauseBtn = (Button)v.findViewById(R.id.hellomoon_pauseBtn);
        mPauseBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.pause();
            }
        });

        mStopBtn = (Button)v.findViewById(R.id.hellomoon_stopBtn);
        mStopBtn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                mPlayer.stop();
            }
        });

        return v;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPlayer.stop();
    }
}
