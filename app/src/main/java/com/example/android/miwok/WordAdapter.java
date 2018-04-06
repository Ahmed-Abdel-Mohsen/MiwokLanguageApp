package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.resource;

/**
 * Created by ahmed on 2/6/2018.
 */

public class WordAdapter extends ArrayAdapter<Word> {


    private int mColorResourceId;

    public WordAdapter(Activity context, ArrayList<Word> word, int color) {
        super(context, 0, word);
        mColorResourceId = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.linearLayout);
        linearLayout.setBackgroundColor(mColorResourceId);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defult_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourseId());
        } else {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
