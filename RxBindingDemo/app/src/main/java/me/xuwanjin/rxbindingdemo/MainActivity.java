package me.xuwanjin.rxbindingdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.rxbinding4.view.RxView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import kotlin.Unit;


public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    RecyclerView recyclerView;
    List<Observable<Unit>> observableList = new ArrayList<Observable<Unit>>();
    List<Long> cacheClickEvent = new ArrayList<>();
    CountDownTimer timer = new CountDownTimer(1500, 500) {
        @Override
        public void onTick(long millisUntilFinished) {

        }

        @Override
        public void onFinish() {
            if (cacheClickEvent.size() > 4) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Log.d(TAG, "run: timer: onFinish");
                        Toast.makeText(getApplicationContext(), "Matthew 0000 ", Toast.LENGTH_SHORT).show();
                        cacheClickEvent.clear();
                        timer.cancel();
                        clickTimes = 0;
                    }
                });
            }else {
                for (int i =0; i < cacheClickEvent.size();i ++){
                    Toast.makeText(getApplicationContext(), "Matthew 0000 " + i, Toast.LENGTH_SHORT).show();
                }
                cacheClickEvent.clear();
                timer.cancel();
                clickTimes = 0;
            }
        }
    };
    private int clickTimes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.item, parent, false);
                ViewHolder viewHolder = new ViewHolder(view);
                return viewHolder;
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                holder.textView.setText("Matthew");
                Observable<Unit> observable = RxView.clicks(holder.textView);
                Log.d(TAG, "onCreateViewHolder: observable = " + observable);
                observableList.add(observable);
                holder.textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        long clickedTime = System.currentTimeMillis();
                        if (clickTimes == 0) {
                            if (timer != null) {
                                timer.start();
                            }
                            cacheClickEvent.add(clickedTime);
                        }
                        clickedTime ++;
                    }
                });
            }

            @Override
            public int getItemCount() {
                return 3;
            }
        });


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null){
            timer.cancel();
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }
}