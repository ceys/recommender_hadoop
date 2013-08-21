package com.jd.data.recommender;

import java.io.IOException;
import java.util.*;

import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class ToUserVectorReducer extends MapReduceBase implements Reducer<Text, Text, Text, MapWritable> {

	@Override
	public void reduce(Text key, Iterator<Text> values,
			OutputCollector<Text, MapWritable> output, Reporter reporter)
			throws IOException {
		MapWritable item_map = new MapWritable();
		
		while (values.hasNext()) {
			Text item = values.next();
			if(!item_map.containsKey(values.next())) {
				// item-preference pairs
				item_map.put(item, new FloatWritable(1.0f));
			}
		}
		// user \ [itemid:1.0, itemid2:1.0]
		output.collect(key, item_map);
	}

}
