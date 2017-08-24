import org.grouplens.lenskit.transform.threshold.RealThreshold
import org.grouplens.lenskit.transform.threshold.Threshold
import org.lenskit.api.ItemScorer
import org.lenskit.baseline.BaselineScorer
import org.lenskit.baseline.ItemMeanRatingItemScorer
import org.lenskit.knn.item.ItemItemScorer
import org.lenskit.transform.normalize.BaselineSubtractingUserVectorNormalizer
import org.lenskit.transform.normalize.UserVectorNormalizer
import org.lenskit.knn.NeighborhoodSize
import org.lenskit.knn.item.ModelSize
import org.lenskit.knn.item.MinCommonUsers
import org.lenskit.knn.item.ItemSimilarityThreshold

bind ItemScorer to ItemItemScorer
bind UserVectorNormalizer to BaselineSubtractingUserVectorNormalizer
within (UserVectorNormalizer) {
    bind (BaselineScorer, ItemScorer) to ItemMeanRatingItemScorer
}
bind (ItemSimilarityThreshold, Threshold) to RealThreshold
set NeighborhoodSize to 10
set ModelSize to 5000
set MinCommonUsers to 2
