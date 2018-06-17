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
import pol.una.py.gestprois2_frontend.model.RolModel;

public class RolListViewAdapter extends BaseAdapter{

    Context context;
    List<RolModel> tempList;

    public RolListViewAdapter(List<RolModel> listValue, Context context){
        this.context = context;
        this.tempList = listValue;
    }

    @Override
    public int getCount(){
        return this.tempList.size();
    }

    @Override
    public Object getItem(int position){
        return this.tempList.get(position);
    }

    @Override
    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewRolItem viewItem = null;

        if(convertView == null){
            viewItem = new ViewRolItem();

            LayoutInflater layoutInflater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.rol_items, null);

            viewItem.IdTextView = (TextView)convertView.findViewById(R.id.id_rol);
            viewItem.DescripcionTextView = (TextView)convertView.findViewById(R.id.rol_descripcion);

            convertView.setTag(viewItem);
        }
        else{
            viewItem = (ViewRolItem) convertView.getTag();
        }

        viewItem.IdTextView.setText(tempList.get(position).getId_rol());
        viewItem.DescripcionTextView.setText(tempList.get(position).getRol_Descripcion());

        return convertView;
    }

    class ViewRolItem{

        TextView IdTextView;
        TextView DescripcionTextView;
    }
}
