import org.lenskit.baseline.BaselineScorer
import org.lenskit.baseline.ItemMeanRatingItemScorer
import org.lenskit.knn.item.ItemItemScorer
import org.lenskit.knn.item.ModelSize
import org.lenskit.slim.MinItemWeight
import org.lenskit.slim.SLIMItemScorer
import org.lenskit.transform.normalize.BaselineSubtractingUserVectorNormalizer
import org.lenskit.transform.normalize.UserVectorNormalizer

bind ItemScorer to SLIMItemScorer
set MinItemWeight to 0.0001
set ModelSize to 100
bind UserVectorNormalizer to BaselineSubtractingUserVectorNormalizer
within (UserVectorNormalizer) {
    bind (BaselineScorer, ItemScorer) to ItemMeanRatingItemScorer
}
