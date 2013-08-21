package com.jd.data.recommender;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class UserVectorToCooccurrenceReducer extends MapReduceBase implements Reducer<Text, Text, Text, MapWritable> {

	@Override
	public void reduce(Text arg0, Iterator<Text> arg1,
			OutputCollector<Text, MapWritable> arg2, Reporter arg3)
			throws IOException {
		// TODO Auto-generated method stub
		
	}

}
