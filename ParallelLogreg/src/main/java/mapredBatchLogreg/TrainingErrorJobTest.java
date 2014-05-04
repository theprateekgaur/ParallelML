package mapredBatchLogreg;

import org.apache.hadoop.util.ToolRunner;

import Utils.RCV1DatasetInfo;



public class TrainingErrorJobTest {

  private static final String TARGET_POSITIVE = "CCAT";

  private static final String INPUT_FILE_TRAIN = "/home/andre/dev/datasets/RCV1-v2/sequencefiles/lyrl2004_vectors_train_5000.seq";
//private static final String INPUT_FILE_TRAIN = "/Users/uce/Desktop/rcv1-v2/vectors/lyrl2004_vectors_train_5000.seq";
//  private static final String INPUT_FILE_TRAIN ="hdfs://localhost:9000/user/uce/rcv1/rcv1-v2/lyrl2004_vectors_train_5000.seq";
  private static final String OUTPUT_TRAIN_PATH = "output-aim3-gradient";

  public static void main(String[] args) throws Exception {
    
    int labelDimension = RCV1DatasetInfo.get().getLabelIdByName(TARGET_POSITIVE);
    
    TrainingErrorJob job = new TrainingErrorJob(
        INPUT_FILE_TRAIN,
        OUTPUT_TRAIN_PATH,
        labelDimension,
        (int)RCV1DatasetInfo.get().getNumFeatures());
    
    ToolRunner.run(job, null);
  }
}