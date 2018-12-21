# WordCount
using hadoop to calculate the occurrences of each start letter and assign each job to corresponded reducer
## Calculate occurrences of each start letter 
  * Words are separated by white characters 
  * Ignore words that are not started by an alphabet 
  * Use 2 reducers, first reducer process words start with Aa~Gg, and second reducer process remaining words 
  * Result should be case sensitive
  * Sort by A → a → B → b ....
  ![image](https://github.com/Yeema/WordCount/blob/master/螢幕快照%202018-12-21%20下午4.23.14.png)
## Components
  * Mapper: generate <K, V> pair 
  * src/WordCountMapper.java
  * Partitioner : assign specific job to each reduce
  * src/WordCountPartitioner.java
  * Key Comparator : compare function for sorting
  * src/WordCountKeyComparator.java
  * Return negative value (e.g. -1) for ascending order
  * Return zero for equal order
  * Return positive value (e.g. 1) for descending order
  * Reducer: aggregate value of same key and output final result
  * src/WordCountReducer.java

## Execution (in WordCount/)
  * make clean; 
  
    make
    
    sh execute.sh
    
    need to modify input path
  * lab5-judge-wordcount
