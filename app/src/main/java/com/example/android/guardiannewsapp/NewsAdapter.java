package com.example.android.guardiannewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news) {
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }
        News currentNews = getItem(position);

        String newsSection = currentNews.getSection();
        String newsTitle = currentNews.getTitle();

        TextView newsSectionView = (TextView) listItemView.findViewById(R.id.news_section);
        newsSectionView.setText(newsSection);

        TextView newsTitleView = (TextView) listItemView.findViewById(R.id.news_title);
        newsTitleView.setText(newsTitle);

        TextView author = (TextView) listItemView.findViewById(R.id.news_author);
        author.setText(currentNews.getAuthor());

        TextView date = (TextView) listItemView.findViewById(R.id.date);
        date.setText(currentNews.getDate());

        return listItemView;
    }
}
