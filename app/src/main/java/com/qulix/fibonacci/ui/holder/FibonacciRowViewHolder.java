package com.qulix.fibonacci.ui.holder;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import com.qulix.fibonacci.fibonacci.R;
import com.qulix.fibonacci.generator.FibonacciGenerator;

import java.math.BigInteger;

public class FibonacciRowViewHolder {

    private final TextView mIndexField;
    private final TextView mValueField;
    private AsyncTask<Void, Void, BigInteger> mCalculateValueAndDisplay;

    public FibonacciRowViewHolder(final View rowView) {
        mIndexField = textViewById(rowView, R.id.fibonacci_index);
        mValueField = textViewById(rowView, R.id.fibonacci_value);
    }

    public void bindItem(final long fibIndex, final FibonacciGenerator generator) {
        Context context = mIndexField.getContext();
        mIndexField.setText(context.getString(R.string.fibonacci_index_title, fibIndex));

        mCalculateValueAndDisplay = new AsyncTask<Void, Void, BigInteger>() {

            @Override
            protected void onPreExecute() {
                mValueField.setText("Calculating...");
            }

            @Override
            protected BigInteger doInBackground(Void... args) {
                synchronized (generator) {
                    return generator.fibonacciForIndex(fibIndex);
                }
            }

            @Override
            protected void onPostExecute(BigInteger value) {
                mValueField.setText(value.toString());
            }
        }.execute();
    }

    public void cancel() {
        mCalculateValueAndDisplay.cancel(true);
    }

    private TextView textViewById(View view, int resId) {
        return (TextView) view.findViewById(resId);
    }

}
