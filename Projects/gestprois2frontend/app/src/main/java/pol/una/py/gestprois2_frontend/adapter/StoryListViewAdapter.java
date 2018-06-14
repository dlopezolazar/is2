package pol.una.py.gestprois2_frontend.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import pol.una.py.gestprois2_frontend.R;
import pol.una.py.gestprois2_frontend.model.StoryModel;

/**
 * Created by Diego on 21/05/2018.
 */

public class StoryListViewAdapter extends BaseAdapter{
    Context context;
    List<StoryModel> listStory;

    public StoryListViewAdapter(List<StoryModel> listStory, Context context) {
        this.context = context;
        this.listStory = listStory;
    }

    @Override
    public int getCount() {
        return this.listStory.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listStory.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewStoryItem viewStoryItem;

        if(view == null){
            viewStoryItem = new ViewStoryItem();
            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = layoutInfiater.inflate(R.layout.story_items, null);

            viewStoryItem.projectName = view.findViewById(R.id.nameProject);
            viewStoryItem.sprintName = view.findViewById(R.id.nameSprint);
            viewStoryItem.taskName = view.findViewById(R.id.userName);
            viewStoryItem.taskState = view.findViewById(R.id.state);
            viewStoryItem.userName = view.findViewById(R.id.state);

            view.setTag(viewStoryItem);
        }
        else{
            viewStoryItem = (ViewStoryItem) view.getTag();
        }

        viewStoryItem.projectName.setText("Project");
        viewStoryItem.sprintName.setText(listStory.get(i).getSprint().getSprintDescription());
        viewStoryItem.taskName.setText(listStory.get(i).getTaskDescription());
        viewStoryItem.taskState.setText(listStory.get(i).getState());
        viewStoryItem.userName.setText(listStory.get(i).getUser().getFullName());

        return view;
    }

    class ViewStoryItem{
        TextView projectName;
        TextView sprintName;
        TextView taskName;
        TextView taskState;
        TextView userName;

    }
}
