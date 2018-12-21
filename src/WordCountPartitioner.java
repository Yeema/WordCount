package wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class WordCountPartitioner extends Partitioner<Text, IntWritable> {
	@Override
	public int getPartition(Text key, IntWritable value, int numReduceTasks) {
		// customize which <K ,V> will go to which reducer Aa Gg
		if(Character.isUpperCase(key.toString().charAt(0))){
			if(key.toString().charAt(0)-'A'>=0 && key.toString().charAt(0)-'G'<=0){
				return 0;
			}else{
				return 1;
			}
		}else{
			if(key.toString().charAt(0)-'a'>=0 && key.toString().charAt(0)-'g'<=0){
				return 0;
			}else{
				return 1;
			}
		}
	}
}
