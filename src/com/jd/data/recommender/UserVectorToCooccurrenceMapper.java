package com.jd.data.recommender;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.hadoop.io.MapWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class UserVectorToCooccurrenceMapper extends MapReduceBase implements Mapper<Text,MapWritable,Text,Text>{

	@Override
	public void map(Text userid, MapWritable value,
			OutputCollector<Text, Text> output, Reporter arg3) throws IOException {
		
		Set<Writable> keys = value.keySet();
		Iterator<Writable> iterator1 = keys.iterator();
		
		while(iterator1.hasNext()) {
			Text item1 = (Text) iterator1.next();
			Iterator<Writable> iterator2 = keys.iterator();
			while(iterator2.hasNext()) {
				Text item2 = (Text) iterator2.next();
				output.collect(item1, item2);
			}
		}
		
	}

}
