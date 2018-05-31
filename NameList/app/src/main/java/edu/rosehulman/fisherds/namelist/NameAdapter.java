package edu.rosehulman.fisherds.namelist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameAdapter extends RecyclerView.Adapter<NameAdapter.NameViewHolder> {
  private List<String> mNames;
  private Context mContext;
  private Random mRandom = new Random();

  public NameAdapter(Context context) {
    mNames = new ArrayList<>();
    mContext = context;
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

  public void addName() {
//    mNames.add(getRandomName());
//    notifyDataSetChanged();

    mNames.add(0, getRandomName());
//    notifyItemInserted(0);
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_view, parent, false);
    return new NameViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
    String name = mNames.get(position);
    holder.mNameTextView.setText(name);
    holder.mDescriptionTextView.setText(String.format("I'm #%d", (position+1)));
  }

  @Override
  public int getItemCount() {
    return mNames.size();
  }

  class NameViewHolder extends RecyclerView.ViewHolder {
    private final TextView mNameTextView;
    private final TextView mDescriptionTextView;

    public NameViewHolder(View itemView) {
      super(itemView);
      mNameTextView = itemView.findViewById(R.id.name);
      mDescriptionTextView = itemView.findViewById(R.id.description);
    }
  }

}
