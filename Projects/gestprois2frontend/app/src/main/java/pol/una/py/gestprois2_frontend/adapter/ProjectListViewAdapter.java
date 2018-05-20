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
import pol.una.py.gestprois2_frontend.model.ProjectModel;

/**
 * Created by Diego on 14/05/2018.
 */

public class ProjectListViewAdapter  extends BaseAdapter{

    Context context;
    List<ProjectModel> listProyect;

    public ProjectListViewAdapter(List<ProjectModel> listValue, Context context){
        this.context = context;
        this.listProyect = listValue;
    }

    @Override
    public int getCount() {
        return this.listProyect.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listProyect.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewProjectItem viewItem = null;

        if(view == null){
            viewItem = new ViewProjectItem();
            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = layoutInfiater.inflate(R.layout.project_items, null);

            viewItem.projectId = (TextView) view.findViewById(R.id.codProject);
            viewItem.projectName = (TextView) view.findViewById(R.id.nameSprint);
            viewItem.projectInitDate = (TextView) view.findViewById(R.id.initDate);
            viewItem.projectEndDate = (TextView) view.findViewById(R.id.endDate);

            view.setTag(viewItem);
        }
        else{
            viewItem = (ViewProjectItem) view.getTag();
        }

        viewItem.projectId.setText(listProyect.get(i).getProjectId());
        viewItem.projectName.setText(listProyect.get(i).getProjectName());
        viewItem.projectInitDate.setText(listProyect.get(i).getProjectInitDate());
        viewItem.projectEndDate.setText(listProyect.get(i).getProjectEndDate());

        return view;
    }

    class ViewProjectItem{

        TextView projectId;
        TextView projectName;
        TextView projectInitDate;
        TextView projectEndDate;

    }
}
