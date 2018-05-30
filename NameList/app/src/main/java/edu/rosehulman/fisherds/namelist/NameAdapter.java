package edu.rosehulman.fisherds.namelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameAdapter extends RecyclerView.Adapter {
  private List<String> mNames;
  private Context mContext;
  private Random mRandom = new Random();

  public NameAdapter(Context context) {
    mNames = new ArrayList<>();
    mContext = context;

    for (int i = 0; i < 5; i++) {
      mNames.add(getRandomName());
    }
    Log.d("TAG", "Names = " + mNames);
  }

  private String getRandomName() {
    String[] names = new String[]{
        "Hannah", "Emily", "Sarah", "Madison", "Brianna",
        "Kaylee", "Kaitlyn", "Hailey", "Alexis", "Elizabeth",
        "Michael", "Jacob", "Matthew", "Nicholas", "Christopher",
        "Joseph", "Zachary", "Joshua", "Andrew", "William"
    };
    return names[mRandom.nextInt(names.length)];
  }

  @NonNull
  @Override
  public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    return null;
  }

  @Override
  public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return 0;
  }
}
