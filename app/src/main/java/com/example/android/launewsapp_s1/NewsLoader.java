package com.example.android.launewsapp_s1;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.util.List;

/**
 * Created by lfotache on 06.04.2018.
 */

/**
 * Loads a list of news by using an AsyncTask to perform the network request to the given URL.
 */
public class NewsLoader extends AsyncTaskLoader<List<News>> {

    /**
     * Query URL
     */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader}.
     *
     * @param context of the activity
     * @param url     to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract the news list.

        List<News> news = null;
        try {
            news = NewsUtils.fetchNewsData(mUrl);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return news;
    }
}


