package com.qulix.fibonacci.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.qulix.fibonacci.fibonacci.R;
import com.qulix.fibonacci.generator.SlideGenerator;
import com.qulix.fibonacci.ui.holder.FibonacciRowViewHolder;

import java.math.BigInteger;

public class FibonacciAdapter extends ArrayAdapter<BigInteger> {

    private final LayoutInflater mInflater;
    private final SlideGenerator mGenerator = new SlideGenerator();

    public FibonacciAdapter(final Context context) {
        super(context, 0, 0);
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(
            final int position,
            final View convertView,
            final ViewGroup parent) {
        final View vi;
        if (convertView == null) {
            vi = mInflater.inflate(R.layout.fibonacci_row, null);
        } else {
            vi = convertView;
            FibonacciRowViewHolder task = (FibonacciRowViewHolder) vi.getTag();
            task.cancel();
        }

        FibonacciRowViewHolder holder = new FibonacciRowViewHolder(vi);
        holder.bindItem(position, mGenerator);
        vi.setTag(holder);

        return vi;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
    }

    @Override
    public BigInteger getItem(final int position) {
        return mGenerator.fibonacciForIndex(position);
    }
}
