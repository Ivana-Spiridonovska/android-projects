package com.example.finaltask;

import java.util.ArrayList;
import java.util.List;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyPersonAdapter extends BaseAdapter{
	
	List<Person> persons = new ArrayList<Person>();
	Activity activity;
	
	public MyPersonAdapter(Activity activity, List<Person> persons){
		this.activity=activity;
		this.persons=persons;
				
	}
	
	

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return persons.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return persons.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int arg0, View arg1, ViewGroup arg2) {
		View rowView = arg1;
		if (rowView == null) {
			LayoutInflater inflater = activity.getLayoutInflater();
			rowView = inflater.inflate(R.layout.person_layout2, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.name = (TextView) rowView.findViewById(R.id.ime);
			viewHolder.surname = (TextView) rowView.findViewById(R.id.prezime);
			viewHolder.address = (TextView) rowView.findViewById(R.id.adresa);
			viewHolder.image = (ImageView) rowView.findViewById(R.id.slika);
			rowView.setTag(viewHolder);
		}
		ViewHolder holder = (ViewHolder) rowView.getTag();
		Person person = persons.get(arg0);
		
		holder.name.setText(person.ime);
		holder.surname.setText(person.prezime);
		holder.address.setText(person.adresa);
		
		holder.image.setImageResource(person.resourceId);
		
		
		return rowView;
		
	}

    static class ViewHolder{
    	public TextView name;
		public TextView surname;
		public TextView address;
		public ImageView image;
    }
}
