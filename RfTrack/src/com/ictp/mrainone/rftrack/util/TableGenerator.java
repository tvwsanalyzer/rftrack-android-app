package com.ictp.mrainone.rftrack.util;
import android.R;
import android.graphics.Color;
import android.graphics.Typeface;
import android.content.Context;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class TableGenerator {
    
    static int nRow = 0;
    
    private final Context mContext;
    private TableLayout mTable;
 
    private TableLayout.LayoutParams rowParams = new TableLayout.LayoutParams();
    private TableRow.LayoutParams colParams = new TableRow.LayoutParams();
 
    public TableGenerator(Context context) {
        mContext = context;
        mTable = new TableLayout(context);
        rowParams.setMargins(0, 0, 0, 1);
        colParams.setMargins(0, 0, 1, 0);
 
        TableLayout.LayoutParams lptable = new TableLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        mTable.setLayoutParams(lptable);
 
        mTable.setStretchAllColumns(true);
        mTable.setBackgroundColor(mContext.getResources().getColor(
                R.color.white));
        
        nRow = 0;
    }
     
    public void addRow(String[] data) {
        
        TableRow tr = new TableRow(mContext);
        tr.setBackgroundColor(mContext.getResources().getColor(
                R.color.background_light));
                // R.color.table_background));
 
        tr.setLayoutParams(rowParams);
		
		// set the row color
        int rowcolor;
        if((nRow%2)==0)
            rowcolor = mContext.getResources().getColor(R.color.white);
        else    
            rowcolor = mContext.getResources().getColor(R.color.holo_blue_dark);
        
        // compile the columns for the row
        for (int iCol = 0; iCol < data.length; iCol++) {
            TextView tvCol = new TextView(mContext);
            
            tvCol.setText(data[iCol]);
            tvCol.setTextSize(18);
            tvCol.setTypeface(null, Typeface.BOLD);
			
			// text position (Gravity.CENTER, Gravity.RIGHT)
            // tvCol.setGravity(Gravity.CENTER | Gravity.CENTER);
            tvCol.setGravity(Gravity.CENTER | Gravity.RIGHT);

            tvCol.setPadding(3, 3, 3, 3);
            
            tvCol.setTextColor(mContext.getResources().getColor(
                    R.color.black));
                    // R.color.white));
            
            tvCol.setLayoutParams(colParams);

            tvCol.setBackgroundColor(rowcolor);
            
            /***
            if((nRow%2)==0)
            tvCol.setBackgroundColor(mContext.getResources().getColor(
                    R.color.white));
            else    
            tvCol.setBackgroundColor(mContext.getResources().getColor(
                    R.color.holo_blue_dark));
            nRow++;
            ***/
            
            tr.addView(tvCol);
        }
 
		// insert row in table
		if(nRow<=1)
			mTable.addView(tr);				// add row following the creation order
		else
			mTable.addView(tr, 1);			// insert row starting at second position
        nRow++;
    }
     
    public TableLayout getTable() {
        return mTable;
    }
}
