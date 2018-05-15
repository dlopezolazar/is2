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
import pol.una.py.gestprois2_frontend.model.UserModel;

/**
 * Created by Diego on 13/05/2018.
 */

public class UserListViewAdapter extends BaseAdapter{

    Context context;
    List<UserModel> tempList;

    public UserListViewAdapter(List<UserModel> listValue, Context context){
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
        ViewUserItem viewItem = null;

        if(convertView == null){
            viewItem = new ViewUserItem();

            LayoutInflater layoutInfiater = (LayoutInflater)this.context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInfiater.inflate(R.layout.usuario_items, null);

            viewItem.IdTextView = (TextView)convertView.findViewById(R.id.textviewID);
            viewItem.NameTextView = (TextView)convertView.findViewById(R.id.text1);

            convertView.setTag(viewItem);
        }
        else{
            viewItem = (ViewUserItem) convertView.getTag();
        }

        viewItem.IdTextView.setText(tempList.get(position).getEmail());
        viewItem.NameTextView.setText(tempList.get(position).getFullName());

        return convertView;
    }

    class ViewUserItem{

        TextView IdTextView;
        TextView NameTextView;
    }
}
