package edu.rosehulman.fisherds.recyclerviewpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    String[] names = new String[] {
        "Du Yu", "Yu Xiaoyue ", "Zhang Xingyu ", "Cao Renxuan", "Wang Qishun", "Ding Haoran", "Liu Yate ", "Zhang Naichuan",
        "Zhang Junjie ", "Wang Zhi ", "Li Peifeng", "Zhang Jiahe ", "Zhao Jiahui", "Shao Xiaoyang", "Zhang Yucheng", "Li Chenyang",
        "Yu Runze", "Yuan Ruicheng ", "Wang Honggang", "Qi Xin", "Huang Haotian ", "Yang Jingjun", "Song Zeyuan ", "Li Yangfan",
        "Wang Yusen ", "Zhang Yundeng", "Xu Yifu", "Yuan Kun", "Zhang Chenglong ", "Mi Hao", "Gan Xu", "Tian Ye", "Xiao Guangen",
        "Zhou Xindong ", "Li Jiayuan ", "Zhang Zhuofan", "Li Ruohan", "Wang Liuyi", "An Xinyi", "Qin Xiaodi", "Li Pengyi", "Liu Qi",
        "Sun Rui", "Yang Wanqing", "Zhao Yue ", "Yu Liangyue", "Li Dongqing", "Li Shenrui", "Yue Yang", "Jv Pengyuan", "Liu Hengjia",
        "Wang Luxiang", "He Pengfei", "Liu Liming", "Cai Yu", "Shi Fanghui", "Cao Kaiyang", "Yu Mingkang", "Zhang Zinan",
        "Peng Changxin", "Liu Yanwei", "Shao Xueyu", "Wang Zhenyu", "Li Qiushi", "Yan Xiaolu", "Liu Zenghui", "Liang Zhifang",
        "Xv Jichuan", "Zhao Zhuolin", "Wang Xiangguo", "Liu Zhendong", "Liu Tonglei", "Guo Hanlin", "Long Ming", "Chen Xiaoyu", "Qi Yue",
        "Liu Songrun", "Wang Wenhao", "Huan Shuai", "Zhang Lei", "Wang Yubo", "Li Boyu", "Lin Xinyu", "Ma Xinhang", "Zhang Mengya",
        "Li Lexin", "Zhang Yuxue", "Zhang Yankun", "Yao Jing", "Jiang Shuhan", "Rang Ran", "Lv Haochen", "Zhang Wenqi"
    };
    return names[mRandom.nextInt(names.length)];
  }

  public void addName() {
    mNames.add(0, getRandomName());
    Log.d("TAG", mNames.toString());
//    notifyDataSetChanged();
    notifyItemInserted(0);
    notifyItemRangeChanged(0, mNames.size());
  }

  private void removeName(int position) {
    mNames.remove(position);
//          notifyDataSetChanged();
    notifyItemRemoved(position);
    notifyItemRangeChanged(position, mNames.size());
  }

  @NonNull
  @Override
  public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_view, parent, false);
    return new NameViewHolder(itemView);
  }

  @Override
  public void onBindViewHolder(@NonNull NameViewHolder holder, int position) {
    holder.mNameTextView.setText(mNames.get(position));
    holder.mDescriptionTextView.setText("I'm #" + (position + 1));
  }

  @Override
  public int getItemCount() {
    return mNames.size();
  }


  class NameViewHolder extends RecyclerView.ViewHolder {
    private TextView mNameTextView;
    private TextView mDescriptionTextView;

    public NameViewHolder(View itemView) {
      super(itemView);
      mNameTextView = itemView.findViewById(R.id.name);
      mDescriptionTextView = itemView.findViewById(R.id.description);
      itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
          removeName(getAdapterPosition());
          return true;
        }
      });
    }
  }

}
