package Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lambda.iith.dashboard.R;

import java.util.ArrayList;


public class HomeTimeTableAdapter extends RecyclerView.Adapter<HomeTimeTableAdapter.ViewHolder>{
    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<String> mCourse = new ArrayList<>();
    private ArrayList<String> mTime = new ArrayList<>();


    private Context mContext;

    public HomeTimeTableAdapter(Context context, ArrayList<String> Names, ArrayList<String> Emails  ) {
        mCourse = Names;

        mTime = Emails;
        mContext = context;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.timetable_home_recycler, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");



        holder.course.setText(mCourse.get(position));
        holder.time.setText(mTime.get(position));


        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });
    }

    @Override
    public int getItemCount() {
        return mCourse.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView course , time;
        ConstraintLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            course= itemView.findViewById(R.id.CourseCode);

            time = itemView.findViewById(R.id.CourseTime);
            parentLayout = itemView.findViewById(R.id.ParentLayout);
        }
    }
}