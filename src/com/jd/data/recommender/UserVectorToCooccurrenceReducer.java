package com.jd.data.recommender;

import java.io.IOException;
import java.util.Iterator;

import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;

public class UserVectorToCooccurrenceReducer extends MapReduceBase implements Reducer<Text, Text, Text, MapWritable> {

	@Override
	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, MapWritable> output, Reporter arg3)
			throws IOException {
		
		MapWritable item_map = new MapWritable();
		
		while(values.hasNext()) {
			Text item = values.next();
			if(!item_map.containsKey(item)) {
				item_map.put(item, new FloatWritable(1.0f));
			} else {
				FloatWritable count = (FloatWritable) item_map.get(item);
				item_map.put(item, new FloatWritable((float)count.get() + 1.0f));
			}
			
		}
		output.collect(key, item_map);
		
	}

}
