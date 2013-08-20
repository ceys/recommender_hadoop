package com.jd.data.recommender;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.io.*;

public class ToItemPrefMapper extends MapReduceBase implements Mapper<LongWritable,Text,Text,Text>{

	@Override
	public void map(LongWritable key, Text value,
			OutputCollector<Text, Text> output, Reporter reporter) throws IOException {
		
		Text userid = new Text();
		Text itemid = new Text();
		
		String line = value.toString();
		StringTokenizer tokenizer = new StringTokenizer(line);
		
		userid.set(tokenizer.nextToken());
		while (tokenizer.hasMoreTokens()) {
			itemid.set(tokenizer.nextToken());
			// user-item pairs for each itemid
			output.collect(userid, itemid);
		}
		
	}

}
