package com.suiyueyu.w3_FragmentStaticLayout;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yzcc on 2014/10/11.
 */
public class QuotesFragment extends Fragment {

    private TextView mQuoteView = null;
    private int mCurrIdx = -1;
    private int mQuoteArrayLen = 0;

    private static final String TAG = "QuotesFragment";

    public int getShownIndex() {
        return mCurrIdx;
    }

    // Show the Quote string at position newIndex
    public void showQuoteAtIndex(int newIndex) {
        if (newIndex < 0 || newIndex >= mQuoteArrayLen)
            return;
        mCurrIdx = newIndex;
        mQuoteView.setText(QuoteViewerActivity.mQuoteArray[mCurrIdx]);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":onCreate()");
        super.onCreate(savedInstanceState);

        // Retain this Fragment across Activity reconfigurations
        setRetainInstance(true);

    }

    // Called to create the content view for this Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":onCreateView()");

        // Inflate the layout defined in quote_fragment.xml
        // The last parameter is false because the returned view does not need to be attached to the container ViewGroup
        return inflater.inflate(R.layout.quote_fragment, container, false);
    }

    // Set up some information about the mQuoteView TextView
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + ":onActivityCreated()");
        super.onActivityCreated(savedInstanceState);

        mQuoteView = (TextView) getActivity().findViewById(R.id.quoteView);
        mQuoteArrayLen = QuoteViewerActivity.mQuoteArray.length;
        showQuoteAtIndex(mCurrIdx);
    }

}