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
import pol.una.py.gestprois2_frontend.model.SprintModel;

/**
 * Created by Diego on 20/05/2018.
 */

public class SprintListViewAdapter extends BaseAdapter{

    Context context;
    List<SprintModel> listSprint;

    public SprintListViewAdapter(List<SprintModel> listSprint, Context context) {
        this.context = context;
        this.listSprint = listSprint;
    }

    @Override
    public int getCount() {
        return listSprint.size();
    }

    @Override
    public Object getItem(int i) {
        return listSprint.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewSprintItem viewSprintItem = null;
        if(view==null){
            viewSprintItem = new ViewSprintItem();
            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = layoutInfiater.inflate(R.layout.sprint_items, null);

            viewSprintItem.sprintDescription = view.findViewById(R.id.nameProject);
            viewSprintItem.projectDescription = view.findViewById(R.id.descProject);
            viewSprintItem.initDate = view.findViewById(R.id.userName);
            viewSprintItem.endDate = view.findViewById(R.id.state);

            view.setTag(viewSprintItem);

        } else {
            viewSprintItem = (ViewSprintItem) view.getTag();
        }

        viewSprintItem.sprintDescription.setText(listSprint.get(i).getSprintDescription());
        viewSprintItem.projectDescription.setText(listSprint.get(i).getProjectDescription());
        viewSprintItem.initDate.setText(listSprint.get(i).getInitDate());
        viewSprintItem.endDate.setText(listSprint.get(i).getEndDate());

        return view;
    }

    class ViewSprintItem{

        TextView sprintId;
        TextView sprintDescription;
        TextView initDate;
        TextView endDate;
        TextView projectDescription;

    }
}
