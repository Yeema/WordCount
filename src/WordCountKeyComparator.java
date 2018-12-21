package wordcount;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class WordCountKeyComparator extends WritableComparator {
	
	public WordCountKeyComparator() {
		super(Text.class, true);
	}	
	
	public int compare(WritableComparable o1, WritableComparable o2) {
		Text key1 = (Text) o1;
		Text key2 = (Text) o2;
		char k1 = key1.toString().charAt(0);
		char k2 = key2.toString().charAt(0);
		// TODO Order by A -> a -> B -> b ....
		if(Character.isUpperCase(k1) && Character.isUpperCase(k2)){
			if(k2-k1>0){
				return -1;
			}else if(k2-k1<0){
				return 1;
			}else{
				return 0;
			}
		}else if(Character.isLowerCase(k1) && Character.isLowerCase(k2)){
			if(k2-k1>0){
				return -1;
			}else if(k2-k1<0){
				return 1;
			}else{
				return 0;
			}
		}else{
			char kk1 = Character.toUpperCase(k1);
			char kk2 = Character.toUpperCase(k2);
			if(kk2-kk1>0){
				return -1;
			}else if(kk2-kk1<0){
				return 1;
			}else{
				if(Character.isUpperCase(k1))
					return -1;
				else
					return 1;
			}
		}
	}
}
